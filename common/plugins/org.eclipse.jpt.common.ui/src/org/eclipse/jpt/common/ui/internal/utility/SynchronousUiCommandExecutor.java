/*******************************************************************************
 * Copyright (c) 2007, 2012 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.common.ui.internal.utility;

import org.eclipse.jpt.common.ui.internal.util.SWTUtil;
import org.eclipse.jpt.common.utility.command.Command;
import org.eclipse.jpt.common.utility.command.ExtendedCommandContext;

/**
 * This command executor synchronously executes a {@link Command command}
 * on the UI thread.
 * <p>
 * This command executor allows a non-UI process to modify any objects
 * associated with documents that are currently displayed in the UI.
 */
public final class SynchronousUiCommandExecutor
	extends AbstractUiCommandExecutor
{
	public static final ExtendedCommandContext INSTANCE = new SynchronousUiCommandExecutor();

	public static ExtendedCommandContext instance() {
		return INSTANCE;
	}

	// ensure single instance
	private SynchronousUiCommandExecutor() {
		super();
	}

	public void execute(Command command) {
		SWTUtil.syncExec(this.buildRunnable(command));
	}

	public void waitToExecute(Command command) {
		this.execute(command);
	}
}
