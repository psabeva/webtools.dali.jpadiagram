/*******************************************************************************
 *  Copyright (c) 2009, 2010  Oracle. 
 *  All rights reserved.  This program and the accompanying materials are 
 *  made available under the terms of the Eclipse Public License v1.0 which 
 *  accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *  	Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.core.internal.jpa1.context.java;

import org.eclipse.jpt.core.context.JoiningStrategy;
import org.eclipse.jpt.core.context.java.JavaJoinColumnJoiningStrategy;
import org.eclipse.jpt.core.context.java.JavaOneToManyMapping;
import org.eclipse.jpt.core.internal.context.java.AbstractJavaOneToManyRelationshipReference;

public class GenericJavaOneToManyRelationshipReference
	extends AbstractJavaOneToManyRelationshipReference
{	

	public GenericJavaOneToManyRelationshipReference(JavaOneToManyMapping parent) {
		super(parent);
	}	

	@Override
	protected JavaJoinColumnJoiningStrategy buildJoinColumnJoiningStrategy() {
		return new NullJavaJoinColumnJoiningStrategy(this);
	}

	// **************** join columns *******************************************

	@Override
	public boolean usesJoinColumnJoiningStrategy() {
		return false;
	}

	@Override
	public void setJoinColumnJoiningStrategy() {
		throw new UnsupportedOperationException("join column joining strategy not supported on a 1.0 1-m mapping"); //$NON-NLS-1$
	}

	@Override
	public void unsetJoinColumnJoiningStrategy() {
		throw new UnsupportedOperationException("join column joining strategy not supported on a 1.0 1-m mapping"); //$NON-NLS-1$
	}

	@Override
	protected JoiningStrategy calculatePredominantJoiningStrategy() {
		if (this.mappedByJoiningStrategy.getMappedByAttribute() != null) {
			return this.mappedByJoiningStrategy;
		}
		return this.joinTableJoiningStrategy;
	}
}
