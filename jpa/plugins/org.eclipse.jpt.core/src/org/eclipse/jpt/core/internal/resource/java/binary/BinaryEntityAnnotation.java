/*******************************************************************************
 * Copyright (c) 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.core.internal.resource.java.binary;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jpt.common.core.utility.TextRange;
import org.eclipse.jpt.core.resource.java.EntityAnnotation;
import org.eclipse.jpt.core.resource.java.JPA;
import org.eclipse.jpt.core.resource.java.JavaResourcePersistentType;

/**
 * javax.persistence.Entity
 */
public final class BinaryEntityAnnotation
	extends BinaryAnnotation
	implements EntityAnnotation
{
	private String name;


	public BinaryEntityAnnotation(JavaResourcePersistentType parent, IAnnotation jdtAnnotation) {
		super(parent, jdtAnnotation);
		this.name = this.buildName();
	}

	public String getAnnotationName() {
		return ANNOTATION_NAME;
	}

	@Override
	public void update() {
		super.update();
		this.setName_(this.buildName());
	}

	@Override
	public void toString(StringBuilder sb) {
		sb.append(this.name);
	}


	// ********** EntityAnnotation implementation **********

	// ***** name
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		throw new UnsupportedOperationException();
	}

	private void setName_(String name) {
		String old = this.name;
		this.name = name;
		this.firePropertyChanged(NAME_PROPERTY, old, name);
	}

	private String buildName() {
		return (String) this.getJdtMemberValue(JPA.ENTITY__NAME);
	}

	public TextRange getNameTextRange(CompilationUnit astRoot) {
		throw new UnsupportedOperationException();
	}

}
