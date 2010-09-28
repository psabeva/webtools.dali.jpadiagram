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
import org.eclipse.jpt.core.context.java.JavaBaseColumn;
import org.eclipse.jpt.core.internal.context.BaseColumnTextRangeResolver;
import org.eclipse.jpt.core.utility.TextRange;

public class JavaBaseColumnTextRangeResolver
	extends JavaNamedColumnTextRangeResolver
	implements BaseColumnTextRangeResolver
{

	public JavaBaseColumnTextRangeResolver(JavaBaseColumn column, CompilationUnit astRoot) {
		super(column, astRoot);
	}

	@Override
	protected JavaBaseColumn getColumn() {
		return (JavaBaseColumn) super.getColumn();
	}
	public TextRange getTableTextRange() {
		return this.getColumn().getTableTextRange(this.astRoot);
	}
}