/*******************************************************************************
 * Copyright (c) 2012 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.common.utility.internal.command;

import org.eclipse.jpt.common.utility.ExceptionHandler;
import org.eclipse.jpt.common.utility.command.Command;
import org.eclipse.jpt.common.utility.command.CommandExecutor;
import org.eclipse.jpt.common.utility.command.RepeatingCommand;
import org.eclipse.jpt.common.utility.internal.StringTools;

/**
 * Wrap a repeating {@link Command}.
 */
public class RepeatingCommandWrapper
	implements RepeatingCommand
{
	/**
	 * The client-supplied command that performs the execution. It may
	 * trigger further calls to {@link #execute()} (i.e. the <em>wrapped</em>
	 * command's execution may recurse back to the client code that executes the
	 * <em>wrapper</em> command).
	 */
	/* CU private */ final Command command;

	/**
	 * The command executed whenever the wrapped {@link #command} must be
	 * executed and it is not already executing. If the wrapped {@link #command}
	 * is already executing, it will simply be re-executed directly (once it has
	 * completed its current execution), as opposed to calling the start
	 * command.
	 */
	private final Command startCommand;

	/**
	 * The client-supplied command executor that provides the context for the
	 * {@link #startCommand start command}. By default, the start command is
	 * executed directly; but this executor provides a hook for executing the
	 * {@link #startCommand start command} asynchronously; after which,
	 * subsequent overlapping executions are executed synchronously.
	 */
	private final CommandExecutor startCommandExecutor;

	/**
	 * This handles the exceptions thrown by the <em>wrapped</em> command.
	 */
	final ExceptionHandler exceptionHandler;

	/**
	 * The command wrapper's state.
	 */
	final RepeatingCommandState state;


	// ********** construction **********

	/**
	 * Construct a repeating command wrapper that executes the specified
	 * command. Any exceptions thrown by the command will be handled by the
	 * specified exception handler.
	 */
	public RepeatingCommandWrapper(Command command, ExceptionHandler exceptionHandler) {
		this(command, CommandExecutor.Default.instance(), exceptionHandler);
	}

	/**
	 * Construct a repeating command wrapper that executes the specified
	 * command and uses the specified command executor to execute the wrapped
	 * command whenever it is not already executing.
	 * Any exceptions thrown by the command will be handled by the
	 * specified exception handler.
	 */
	public RepeatingCommandWrapper(Command command, CommandExecutor startCommandExecutor, ExceptionHandler exceptionHandler) {
		super();
		if ((command == null) || (startCommandExecutor == null) || (exceptionHandler == null)) {
			throw new NullPointerException();
		}
		this.command = command;
		this.startCommandExecutor = startCommandExecutor;
		this.startCommand = this.buildStartCommand();
		this.exceptionHandler = exceptionHandler;
		this.state = this.buildState();
	}

	private Command buildStartCommand() {
		return new StartCommand();
	}

	private RepeatingCommandState buildState() {
		return new RepeatingCommandState();
	}


	// ********** RepeatingCommand implementation **********

	public void start() {
		this.state.start();
	}

	/**
	 * It is possible to come back here if the wrapped command recurses
	 * to the client and triggers another execution.
	 */
	// pretty sure no need for this method to be 'synchronized'
	public void execute() {
		if (this.state.isReadyToStartExecutionCycle()) {
			this.startCommandExecutor.execute(this.startCommand);
		}
	}

	public void stop() throws InterruptedException {
		this.state.stop();
	}

	/**
	 * The start command.
	 * @see #startCommandExecutor
	 */
	/* CU private */ class StartCommand
		implements Command
	{
		public void execute() {
			RepeatingCommandWrapper.this.execute_();
		}
		@Override
		public String toString() {
			return StringTools.buildToStringFor(this, RepeatingCommandWrapper.this.command);
		}
	}

	/**
	 * This method will be called only once per execution cycle.
	 * Any further calls to {@link #execute()} will
	 * simply set the {@link #state} to "repeat",
	 * causing the command to execute again.
	 */
	/* CU private */ void execute_() {
		if (this.state.wasStoppedBeforeFirstExecutionCouldStart()) {
			return;
		}

		do {
			this.executeCommand();
		} while (this.state.isRepeat());
	}

	/**
	 * Execute the client-supplied command. Do not allow any unhandled
	 * exceptions to kill the wrapper. Pass to the exception handler.
	 * @see NotifyingRepeatingCommandWrapper
	 */
	/* private protected */ void executeCommand() {
		try {
			this.command.execute();
		} catch (Throwable ex) {
			this.exceptionHandler.handleException(ex);
		}
	}

	@Override
	public String toString() {
		return StringTools.buildToStringFor(this, this.command);
	}
}