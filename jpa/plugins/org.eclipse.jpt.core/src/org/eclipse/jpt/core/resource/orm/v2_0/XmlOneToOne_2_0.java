/*******************************************************************************
 *  Copyright (c) 2009  Oracle. 
 *  All rights reserved.  This program and the accompanying materials are 
 *  made available under the terms of the Eclipse Public License v1.0 which 
 *  accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *  	Oracle - initial API and implementation
 *******************************************************************************/

package org.eclipse.jpt.core.resource.orm.v2_0;

import org.eclipse.jpt.core.resource.orm.XmlDerivedId;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xml One To One 20</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.jpt.core.resource.orm.v2_0.XmlOneToOne_2_0#isOrphanRemoval <em>Orphan Removal</em>}</li>
 *   <li>{@link org.eclipse.jpt.core.resource.orm.v2_0.XmlOneToOne_2_0#getMapsId <em>Maps Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.jpt.core.resource.orm.v2_0.OrmV2_0Package#getXmlOneToOne_2_0()
 * @model kind="class" interface="true" abstract="true"
 * @generated
 */
public interface XmlOneToOne_2_0 extends XmlDerivedId
{
	/**
	 * Returns the value of the '<em><b>Orphan Removal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orphan Removal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orphan Removal</em>' attribute.
	 * @see #setOrphanRemoval(boolean)
	 * @see org.eclipse.jpt.core.resource.orm.v2_0.OrmV2_0Package#getXmlOneToOne_2_0_OrphanRemoval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	boolean isOrphanRemoval();

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.core.resource.orm.v2_0.XmlOneToOne_2_0#isOrphanRemoval <em>Orphan Removal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orphan Removal</em>' attribute.
	 * @see #isOrphanRemoval()
	 * @generated
	 */
	void setOrphanRemoval(boolean value);

	/**
	 * Returns the value of the '<em><b>Maps Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maps Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maps Id</em>' attribute.
	 * @see #setMapsId(String)
	 * @see org.eclipse.jpt.core.resource.orm.v2_0.OrmV2_0Package#getXmlOneToOne_2_0_MapsId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getMapsId();

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.core.resource.orm.v2_0.XmlOneToOne_2_0#getMapsId <em>Maps Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maps Id</em>' attribute.
	 * @see #getMapsId()
	 * @generated
	 */
	void setMapsId(String value);

} // XmlOneToOne_2_0
