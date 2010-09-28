/*******************************************************************************
 *  Copyright (c) 2010  Oracle. 
 *  All rights reserved.  This program and the accompanying materials are 
 *  made available under the terms of the Eclipse Public License v1.0 which 
 *  accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *  	Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.core.internal.context.java;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jpt.core.context.java.JavaOverride;
import org.eclipse.jpt.core.internal.context.OverrideTextRangeResolver;
import org.eclipse.jpt.core.utility.TextRange;

public class JavaOverrideTextRangeResolver
	implements OverrideTextRangeResolver
{
	protected final JavaOverride javaOverride;

	protected final CompilationUnit astRoot;

	public JavaOverrideTextRangeResolver(JavaOverride javaOverride, CompilationUnit astRoot) {
		this.javaOverride = javaOverride;
		this.astRoot = astRoot;
	}

	protected JavaOverride getOverride() {
		return this.javaOverride;
	}

	public TextRange getNameTextRange() {
		return this.javaOverride.getNameTextRange(this.astRoot);
	}
}