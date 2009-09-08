/*******************************************************************************
 * Copyright (c) 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.core.jpa2.resource.orm;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jpt.core.internal.resource.xml.translators.EmptyTagBooleanTranslator;
import org.eclipse.jpt.core.internal.resource.xml.translators.SimpleTranslator;
import org.eclipse.jpt.core.resource.orm.OrmPackage;
import org.eclipse.wst.common.internal.emf.resource.Translator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xml Persistence Unit Defaults</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.jpt.core.jpa2.resource.orm.XmlPersistenceUnitDefaults#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.jpt.core.jpa2.resource.orm.XmlPersistenceUnitDefaults#isDelimitedIdentifiers <em>Delimited Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.jpt.core.jpa2.resource.orm.Orm2_0Package#getXmlPersistenceUnitDefaults()
 * @model kind="class"
 * @generated
 */
public class XmlPersistenceUnitDefaults extends org.eclipse.jpt.core.resource.orm.XmlPersistenceUnitDefaults
{
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isDelimitedIdentifiers() <em>Delimited Identifiers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDelimitedIdentifiers()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELIMITED_IDENTIFIERS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDelimitedIdentifiers() <em>Delimited Identifiers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDelimitedIdentifiers()
	 * @generated
	 * @ordered
	 */
	protected boolean delimitedIdentifiers = DELIMITED_IDENTIFIERS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XmlPersistenceUnitDefaults()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Orm2_0Package.Literals.XML_PERSISTENCE_UNIT_DEFAULTS;
	}

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.jpt.core.jpa2.resource.orm.Orm2_0Package#getXmlPersistenceUnitDefaults_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.core.jpa2.resource.orm.XmlPersistenceUnitDefaults#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	public void setDescription(String newDescription)
	{
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Orm2_0Package.XML_PERSISTENCE_UNIT_DEFAULTS__DESCRIPTION, oldDescription, description));
	}

	/**
	 * Returns the value of the '<em><b>Delimited Identifiers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delimited Identifiers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delimited Identifiers</em>' attribute.
	 * @see #setDelimitedIdentifiers(boolean)
	 * @see org.eclipse.jpt.core.jpa2.resource.orm.Orm2_0Package#getXmlPersistenceUnitDefaults_DelimitedIdentifiers()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	public boolean isDelimitedIdentifiers()
	{
		return delimitedIdentifiers;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.core.jpa2.resource.orm.XmlPersistenceUnitDefaults#isDelimitedIdentifiers <em>Delimited Identifiers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delimited Identifiers</em>' attribute.
	 * @see #isDelimitedIdentifiers()
	 * @generated
	 */
	public void setDelimitedIdentifiers(boolean newDelimitedIdentifiers)
	{
		boolean oldDelimitedIdentifiers = delimitedIdentifiers;
		delimitedIdentifiers = newDelimitedIdentifiers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Orm2_0Package.XML_PERSISTENCE_UNIT_DEFAULTS__DELIMITED_IDENTIFIERS, oldDelimitedIdentifiers, delimitedIdentifiers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case Orm2_0Package.XML_PERSISTENCE_UNIT_DEFAULTS__DESCRIPTION:
				return getDescription();
			case Orm2_0Package.XML_PERSISTENCE_UNIT_DEFAULTS__DELIMITED_IDENTIFIERS:
				return isDelimitedIdentifiers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case Orm2_0Package.XML_PERSISTENCE_UNIT_DEFAULTS__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case Orm2_0Package.XML_PERSISTENCE_UNIT_DEFAULTS__DELIMITED_IDENTIFIERS:
				setDelimitedIdentifiers((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case Orm2_0Package.XML_PERSISTENCE_UNIT_DEFAULTS__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case Orm2_0Package.XML_PERSISTENCE_UNIT_DEFAULTS__DELIMITED_IDENTIFIERS:
				setDelimitedIdentifiers(DELIMITED_IDENTIFIERS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case Orm2_0Package.XML_PERSISTENCE_UNIT_DEFAULTS__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case Orm2_0Package.XML_PERSISTENCE_UNIT_DEFAULTS__DELIMITED_IDENTIFIERS:
				return delimitedIdentifiers != DELIMITED_IDENTIFIERS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (description: ");
		result.append(description);
		result.append(", delimitedIdentifiers: ");
		result.append(delimitedIdentifiers);
		result.append(')');
		return result.toString();
	}

	// ********** translators **********

	public static Translator buildTranslator(String elementName, EStructuralFeature structuralFeature) {
		return new SimpleTranslator(
			elementName, 
			structuralFeature, 
			Orm2_0Package.eINSTANCE.getXmlPersistenceUnitDefaults(), 
			buildTranslatorChildren());
	}

	private static Translator[] buildTranslatorChildren() {
		return new Translator[] {
			buildDescriptionTranslator(),
			buildSchemaTranslator(),
			buildCatalogTranslator(),
			buildDelimitedIdentifiersTranslator(),
			buildAccessTranslator(),
			buildCascadePersistTranslator(),
			EntityListeners.buildTranslator(JPA2_0.ENTITY_LISTENERS, OrmPackage.eINSTANCE.getXmlPersistenceUnitDefaults_EntityListeners())
		};
	}
	
	protected static Translator buildDescriptionTranslator() {
		return new Translator(JPA2_0.DESCRIPTION, Orm2_0Package.eINSTANCE.getXmlPersistenceUnitDefaults_Description());
	}
	
	protected static Translator buildDelimitedIdentifiersTranslator() {
		return new EmptyTagBooleanTranslator(JPA2_0.DELIMITIED_IDENTIFIERS, Orm2_0Package.eINSTANCE.getXmlPersistenceUnitDefaults_DelimitedIdentifiers());
	}
	
} // XmlPersistenceUnitDefaults
