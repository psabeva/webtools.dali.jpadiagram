/*******************************************************************************
 * Copyright (c) 2007, 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.core.resource.orm;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jpt.core.MappingKeys;
import org.eclipse.jpt.core.internal.utility.translators.SimpleTranslator;
import org.eclipse.jpt.core.resource.orm.v2_0.JPA2_0;
import org.eclipse.jpt.core.resource.orm.v2_0.OrmV2_0Package;
import org.eclipse.jpt.core.resource.orm.v2_0.XmlDerivedId_2_0;
import org.eclipse.jpt.core.resource.orm.v2_0.XmlOneToOne_2_0;
import org.eclipse.jpt.core.utility.TextRange;
import org.eclipse.wst.common.internal.emf.resource.Translator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>One To One</b></em>'.
 * 
 * Provisional API: This interface is part of an interim API that is still
 * under development and expected to change significantly before reaching
 * stability. It is available at this early stage to solicit feedback from
 * pioneering adopters on the understanding that any code that uses this API
 * will almost certainly be broken (repeatedly) as the API evolves.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.jpt.core.resource.orm.XmlOneToOne#getPrimaryKeyJoinColumns <em>Primary Key Join Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.jpt.core.resource.orm.OrmPackage#getXmlOneToOne()
 * @model kind="class"
 * @generated
 */
public class XmlOneToOne extends AbstractXmlSingleRelationshipMapping implements XmlMappedByMapping, XmlOneToOne_2_0
{

	/**
	 * The default value of the '{@link #getMappedBy() <em>Mapped By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedBy()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPPED_BY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMappedBy() <em>Mapped By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedBy()
	 * @generated
	 * @ordered
	 */
	protected String mappedBy = MAPPED_BY_EDEFAULT;
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected Boolean id = ID_EDEFAULT;
	/**
	 * The default value of the '{@link #isOrphanRemoval() <em>Orphan Removal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrphanRemoval()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ORPHAN_REMOVAL_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isOrphanRemoval() <em>Orphan Removal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOrphanRemoval()
	 * @generated
	 * @ordered
	 */
	protected boolean orphanRemoval = ORPHAN_REMOVAL_EDEFAULT;
	/**
	 * The default value of the '{@link #getMapsId() <em>Maps Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapsId()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPS_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMapsId() <em>Maps Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapsId()
	 * @generated
	 * @ordered
	 */
	protected String mapsId = MAPS_ID_EDEFAULT;
	/**
	 * The cached value of the '{@link #getPrimaryKeyJoinColumns() <em>Primary Key Join Columns</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKeyJoinColumns()
	 * @generated
	 * @ordered
	 */
	protected EList<XmlPrimaryKeyJoinColumn> primaryKeyJoinColumns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XmlOneToOne()
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
		return OrmPackage.Literals.XML_ONE_TO_ONE;
	}

	/**
	 * Returns the value of the '<em><b>Mapped By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped By</em>' attribute.
	 * @see #setMappedBy(String)
	 * @see org.eclipse.jpt.core.resource.orm.OrmPackage#getXmlMappedByMapping_MappedBy()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	public String getMappedBy()
	{
		return mappedBy;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.core.resource.orm.XmlOneToOne#getMappedBy <em>Mapped By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped By</em>' attribute.
	 * @see #getMappedBy()
	 * @generated
	 */
	public void setMappedBy(String newMappedBy)
	{
		String oldMappedBy = mappedBy;
		mappedBy = newMappedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrmPackage.XML_ONE_TO_ONE__MAPPED_BY, oldMappedBy, mappedBy));
	}

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(Boolean)
	 * @see org.eclipse.jpt.core.resource.orm.OrmPackage#getXmlDerivedId_2_0_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.BooleanObject"
	 * @generated
	 */
	public Boolean getId()
	{
		return id;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.core.resource.orm.XmlOneToOne#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	public void setId(Boolean newId)
	{
		Boolean oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrmPackage.XML_ONE_TO_ONE__ID, oldId, id));
	}

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
	 * @see org.eclipse.jpt.core.resource.orm.OrmPackage#getXmlOneToOne_2_0_OrphanRemoval()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	public boolean isOrphanRemoval()
	{
		return orphanRemoval;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.core.resource.orm.XmlOneToOne#isOrphanRemoval <em>Orphan Removal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orphan Removal</em>' attribute.
	 * @see #isOrphanRemoval()
	 * @generated
	 */
	public void setOrphanRemoval(boolean newOrphanRemoval)
	{
		boolean oldOrphanRemoval = orphanRemoval;
		orphanRemoval = newOrphanRemoval;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrmPackage.XML_ONE_TO_ONE__ORPHAN_REMOVAL, oldOrphanRemoval, orphanRemoval));
	}

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
	 * @see org.eclipse.jpt.core.resource.orm.OrmPackage#getXmlOneToOne_2_0_MapsId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	public String getMapsId()
	{
		return mapsId;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.core.resource.orm.XmlOneToOne#getMapsId <em>Maps Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maps Id</em>' attribute.
	 * @see #getMapsId()
	 * @generated
	 */
	public void setMapsId(String newMapsId)
	{
		String oldMapsId = mapsId;
		mapsId = newMapsId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrmPackage.XML_ONE_TO_ONE__MAPS_ID, oldMapsId, mapsId));
	}

	/**
	 * Returns the value of the '<em><b>Primary Key Join Columns</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.jpt.core.resource.orm.XmlPrimaryKeyJoinColumn}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Key Join Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key Join Columns</em>' containment reference list.
	 * @see org.eclipse.jpt.core.resource.orm.OrmPackage#getXmlOneToOne_PrimaryKeyJoinColumns()
	 * @model containment="true"
	 * @generated
	 */
	public EList<XmlPrimaryKeyJoinColumn> getPrimaryKeyJoinColumns()
	{
		if (primaryKeyJoinColumns == null)
		{
			primaryKeyJoinColumns = new EObjectContainmentEList<XmlPrimaryKeyJoinColumn>(XmlPrimaryKeyJoinColumn.class, this, OrmPackage.XML_ONE_TO_ONE__PRIMARY_KEY_JOIN_COLUMNS);
		}
		return primaryKeyJoinColumns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case OrmPackage.XML_ONE_TO_ONE__PRIMARY_KEY_JOIN_COLUMNS:
				return ((InternalEList<?>)getPrimaryKeyJoinColumns()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case OrmPackage.XML_ONE_TO_ONE__MAPPED_BY:
				return getMappedBy();
			case OrmPackage.XML_ONE_TO_ONE__ID:
				return getId();
			case OrmPackage.XML_ONE_TO_ONE__ORPHAN_REMOVAL:
				return isOrphanRemoval();
			case OrmPackage.XML_ONE_TO_ONE__MAPS_ID:
				return getMapsId();
			case OrmPackage.XML_ONE_TO_ONE__PRIMARY_KEY_JOIN_COLUMNS:
				return getPrimaryKeyJoinColumns();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case OrmPackage.XML_ONE_TO_ONE__MAPPED_BY:
				setMappedBy((String)newValue);
				return;
			case OrmPackage.XML_ONE_TO_ONE__ID:
				setId((Boolean)newValue);
				return;
			case OrmPackage.XML_ONE_TO_ONE__ORPHAN_REMOVAL:
				setOrphanRemoval((Boolean)newValue);
				return;
			case OrmPackage.XML_ONE_TO_ONE__MAPS_ID:
				setMapsId((String)newValue);
				return;
			case OrmPackage.XML_ONE_TO_ONE__PRIMARY_KEY_JOIN_COLUMNS:
				getPrimaryKeyJoinColumns().clear();
				getPrimaryKeyJoinColumns().addAll((Collection<? extends XmlPrimaryKeyJoinColumn>)newValue);
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
			case OrmPackage.XML_ONE_TO_ONE__MAPPED_BY:
				setMappedBy(MAPPED_BY_EDEFAULT);
				return;
			case OrmPackage.XML_ONE_TO_ONE__ID:
				setId(ID_EDEFAULT);
				return;
			case OrmPackage.XML_ONE_TO_ONE__ORPHAN_REMOVAL:
				setOrphanRemoval(ORPHAN_REMOVAL_EDEFAULT);
				return;
			case OrmPackage.XML_ONE_TO_ONE__MAPS_ID:
				setMapsId(MAPS_ID_EDEFAULT);
				return;
			case OrmPackage.XML_ONE_TO_ONE__PRIMARY_KEY_JOIN_COLUMNS:
				getPrimaryKeyJoinColumns().clear();
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
			case OrmPackage.XML_ONE_TO_ONE__MAPPED_BY:
				return MAPPED_BY_EDEFAULT == null ? mappedBy != null : !MAPPED_BY_EDEFAULT.equals(mappedBy);
			case OrmPackage.XML_ONE_TO_ONE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case OrmPackage.XML_ONE_TO_ONE__ORPHAN_REMOVAL:
				return orphanRemoval != ORPHAN_REMOVAL_EDEFAULT;
			case OrmPackage.XML_ONE_TO_ONE__MAPS_ID:
				return MAPS_ID_EDEFAULT == null ? mapsId != null : !MAPS_ID_EDEFAULT.equals(mapsId);
			case OrmPackage.XML_ONE_TO_ONE__PRIMARY_KEY_JOIN_COLUMNS:
				return primaryKeyJoinColumns != null && !primaryKeyJoinColumns.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == XmlMappedByMapping.class)
		{
			switch (derivedFeatureID)
			{
				case OrmPackage.XML_ONE_TO_ONE__MAPPED_BY: return OrmPackage.XML_MAPPED_BY_MAPPING__MAPPED_BY;
				default: return -1;
			}
		}
		if (baseClass == XmlDerivedId_2_0.class)
		{
			switch (derivedFeatureID)
			{
				case OrmPackage.XML_ONE_TO_ONE__ID: return OrmV2_0Package.XML_DERIVED_ID_20__ID;
				default: return -1;
			}
		}
		if (baseClass == XmlDerivedId.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == XmlOneToOne_2_0.class)
		{
			switch (derivedFeatureID)
			{
				case OrmPackage.XML_ONE_TO_ONE__ORPHAN_REMOVAL: return OrmV2_0Package.XML_ONE_TO_ONE_20__ORPHAN_REMOVAL;
				case OrmPackage.XML_ONE_TO_ONE__MAPS_ID: return OrmV2_0Package.XML_ONE_TO_ONE_20__MAPS_ID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == XmlMappedByMapping.class)
		{
			switch (baseFeatureID)
			{
				case OrmPackage.XML_MAPPED_BY_MAPPING__MAPPED_BY: return OrmPackage.XML_ONE_TO_ONE__MAPPED_BY;
				default: return -1;
			}
		}
		if (baseClass == XmlDerivedId_2_0.class)
		{
			switch (baseFeatureID)
			{
				case OrmV2_0Package.XML_DERIVED_ID_20__ID: return OrmPackage.XML_ONE_TO_ONE__ID;
				default: return -1;
			}
		}
		if (baseClass == XmlDerivedId.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == XmlOneToOne_2_0.class)
		{
			switch (baseFeatureID)
			{
				case OrmV2_0Package.XML_ONE_TO_ONE_20__ORPHAN_REMOVAL: return OrmPackage.XML_ONE_TO_ONE__ORPHAN_REMOVAL;
				case OrmV2_0Package.XML_ONE_TO_ONE_20__MAPS_ID: return OrmPackage.XML_ONE_TO_ONE__MAPS_ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (mappedBy: ");
		result.append(mappedBy);
		result.append(", id: ");
		result.append(id);
		result.append(", orphanRemoval: ");
		result.append(orphanRemoval);
		result.append(", mapsId: ");
		result.append(mapsId);
		result.append(')');
		return result.toString();
	}
	
	
	// **************** XmlAttributeMapping impl ******************************

	public String getMappingKey() {
		return MappingKeys.ONE_TO_ONE_ATTRIBUTE_MAPPING_KEY;
	}
	
	
	// **************** validation support ************************************
	
	public TextRange getDerivedIdTextRange() {
		return getAttributeTextRange(JPA2_0.ID);
	}
	
	public TextRange getMappedByTextRange() {
		return getAttributeTextRange(JPA.MAPPED_BY);
	}
	
	
	// ********** translators **********

	public static Translator buildTranslator(String elementName, EStructuralFeature structuralFeature) {
		return new SimpleTranslator(elementName, structuralFeature, buildTranslatorChildren());
	}

	private static Translator[] buildTranslatorChildren() {
		return new Translator[] {
			buildNameTranslator(),
			buildTargetEntityTranslator(),
			buildFetchTranslator(),
			buildOptionalTranslator(),
			buildAccessTranslator(),
			buildMappedByTranslator(),
			buildOrphanRemovalTranslator(),
			buildMapsIdTranslator(),
			buildIdTranslator(),
			buildPrimaryKeyJoinColumnTranslator(),
			buildJoinColumnTranslator(),
			buildJoinTableTranslator(),
			buildCascadeTranslator()
		};
	}
	
	protected static Translator buildMappedByTranslator() {
		return new Translator(JPA.MAPPED_BY, OrmPackage.eINSTANCE.getXmlMappedByMapping_MappedBy(), Translator.DOM_ATTRIBUTE);
	}
	
	protected static Translator buildOrphanRemovalTranslator() {
		return new Translator(JPA2_0.ORPHAN_REMOVAL, OrmV2_0Package.eINSTANCE.getXmlOneToOne_2_0_OrphanRemoval(), Translator.DOM_ATTRIBUTE);
	}
	
	protected static Translator buildMapsIdTranslator() {
		return new Translator(JPA2_0.MAPS_ID, OrmV2_0Package.eINSTANCE.getXmlOneToOne_2_0_MapsId(), Translator.DOM_ATTRIBUTE);
	}

	protected static Translator buildIdTranslator() {
		return new Translator(JPA2_0.ID, OrmV2_0Package.eINSTANCE.getXmlDerivedId_2_0_Id(), Translator.DOM_ATTRIBUTE);
	}
	
	protected static Translator buildPrimaryKeyJoinColumnTranslator() {
		return XmlPrimaryKeyJoinColumn.buildTranslator(JPA.PRIMARY_KEY_JOIN_COLUMN, OrmPackage.eINSTANCE.getXmlOneToOne_PrimaryKeyJoinColumns());
	}
	
	protected static Translator buildJoinColumnTranslator() {
		return XmlJoinColumn.buildTranslator(JPA.JOIN_COLUMN, OrmPackage.eINSTANCE.getXmlJoinColumnsMapping_JoinColumns());
	}
	
	protected static Translator buildJoinTableTranslator() {
		return XmlJoinTable.buildTranslator(JPA.JOIN_TABLE, OrmPackage.eINSTANCE.getXmlJoinTableMapping_JoinTable());
	}
}
