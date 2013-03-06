/*******************************************************************************
 * Copyright (c) 2008, 2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.common.utility.internal;

import java.io.Serializable;
import org.eclipse.jpt.common.utility.ExceptionHandler;

/**
 * Singleton exception handler that,
 * like what happens with an unhandled exception
 * (see {@link ThreadGroup#uncaughtException(Thread, Throwable)}),
 * prints the exception's stack trace to {@link System#err the
 * "standard" error output stream}.
 */
public final class DefaultExceptionHandler
	implements ExceptionHandler, Serializable
{
	public static final ExceptionHandler INSTANCE = new DefaultExceptionHandler();
	public static ExceptionHandler instance() {
		return INSTANCE;
	}

	// ensure single instance
	private DefaultExceptionHandler() {
		super();
	}

	public void handleException(Throwable t) {
		t.printStackTrace();
	}

	@Override
	public String toString() {
		return ObjectTools.singletonToString(this);
	}

	private static final long serialVersionUID = 1L;
	private Object readResolve() {
		// replace this object with the singleton
		return INSTANCE;
	}
}
