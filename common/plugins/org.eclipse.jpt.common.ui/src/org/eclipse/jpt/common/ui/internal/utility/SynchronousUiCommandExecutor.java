/*******************************************************************************
 * Copyright (c) 2007, 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.common.ui.internal.utility;

import org.eclipse.jpt.utility.Command;
import org.eclipse.jpt.utility.CommandExecutor;
import org.eclipse.jpt.utility.internal.CommandRunnable;
import org.eclipse.swt.widgets.Display;

/**
 * This implementation of CommandExecutor can be used by a non-UI
 * thread to synchronously modify a JPA project with any objects associated
 * with documents that are currently displayed in the UI.
 */
public final class SynchronousUiCommandExecutor
	implements CommandExecutor
{
	public static final CommandExecutor INSTANCE = new SynchronousUiCommandExecutor();

	public static CommandExecutor instance() {
		return INSTANCE;
	}

	// ensure single instance
	private SynchronousUiCommandExecutor() {
		super();
	}

	public void execute(Command command) {
		this.getDisplay().syncExec(this.buildRunnable(command));
	}

	private Runnable buildRunnable(Command command) {
		return new CommandRunnable(command);
	}

	private Display getDisplay() {
		Display display = Display.getCurrent();
		return (display != null) ? display : Display.getDefault();
	}

}