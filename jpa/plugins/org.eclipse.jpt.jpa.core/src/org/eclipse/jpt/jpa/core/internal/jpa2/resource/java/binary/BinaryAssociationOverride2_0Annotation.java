/*******************************************************************************
 * Copyright (c) 2009, 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jpa.core.internal.jpa2.resource.java.binary;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jpt.common.core.resource.java.JavaResourceModel;
import org.eclipse.jpt.jpa.core.internal.resource.java.NullJoinTableAnnotation;
import org.eclipse.jpt.jpa.core.internal.resource.java.binary.BinaryAssociationOverrideAnnotation;
import org.eclipse.jpt.jpa.core.internal.resource.java.binary.BinaryJoinTableAnnotation;
import org.eclipse.jpt.jpa.core.jpa2.resource.java.AssociationOverride2_0Annotation;
import org.eclipse.jpt.jpa.core.jpa2.resource.java.JPA2_0;
import org.eclipse.jpt.jpa.core.resource.java.JoinTableAnnotation;

/**
 *  BinarySequenceGenerator2_0Annotation
 */
public final class BinaryAssociationOverride2_0Annotation
	extends BinaryAssociationOverrideAnnotation
	implements AssociationOverride2_0Annotation
{
	private JoinTableAnnotation joinTable;
	private final JoinTableAnnotation nullJoinTable;

	public BinaryAssociationOverride2_0Annotation(JavaResourceModel parent, IAnnotation jdtAnnotation) {
		super(parent, jdtAnnotation);
		this.joinTable = this.buildJoinTable();
		this.nullJoinTable = this.buildNullJoinTable();
	}

	@Override
	public void update() {
		super.update();
		this.updateJoinTable();
	}


	// ********** AssociationOverride2_0Annotation implementation **********

	// ***** joinTable
	public JoinTableAnnotation getJoinTable() {
		return this.joinTable;
	}

	public JoinTableAnnotation getNonNullJoinTable() {
		return (this.joinTable != null) ? this.joinTable : this.nullJoinTable;
	}

	public JoinTableAnnotation addJoinTable() {
		throw new UnsupportedOperationException();
	}
	
	public void removeJoinTable() {
		throw new UnsupportedOperationException();
	}

	private JoinTableAnnotation buildJoinTable() {
		IAnnotation jdtJoinTable = this.getJdtJoinTable();
		return (jdtJoinTable == null) ? null : this.buildJoinTable(jdtJoinTable);
	}

	private JoinTableAnnotation buildNullJoinTable() {
		return new NullJoinTableAnnotation(this);
	}

	private JoinTableAnnotation buildJoinTable(IAnnotation jdtJoinTable) {
		return new BinaryJoinTableAnnotation(this, jdtJoinTable);
	}

	private IAnnotation getJdtJoinTable() {
		return (IAnnotation) this.getJdtMemberValue(JPA2_0.ASSOCIATION_OVERRIDE__JOIN_TABLE);
	}

	// TODO
	private void updateJoinTable() {
		throw new UnsupportedOperationException();
//		IAnnotation jdtJoinTable = this.getJdtJoinTable();
//		if (jdtJoinTable == null) {
//			this.setJoinTable(null);
//		} else {
//			if (this.column == null) {
//				this.setJoinTable(this.buildJoinTable(jdtJoinTable));
//			} else {
//				this.column.update(jdtJoinTable);
//			}
//		}
	}

}