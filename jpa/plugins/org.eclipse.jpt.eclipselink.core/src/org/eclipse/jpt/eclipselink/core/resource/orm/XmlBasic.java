/*******************************************************************************
 * Copyright (c) 2008, 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.eclipselink.core.resource.orm;

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
import org.eclipse.jpt.core.internal.resource.xml.translators.SimpleTranslator;
import org.eclipse.jpt.core.utility.TextRange;
import org.eclipse.wst.common.internal.emf.resource.Translator;

/**
 * <!-- begin-user-doc -->
 * 
 * A representation of the model object '<em><b>Xml Basic</b></em>'.
 * 
 * Provisional API: This interface is part of an interim API that is still
 * under development and expected to change significantly before reaching
 * stability. It is available at this early stage to solicit feedback from
 * pioneering adopters on the understanding that any code that uses this API
 * will almost certainly be broken (repeatedly) as the API evolves.
 * 
 * @version 2.1
 * @since 2.1
 * 
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.jpt.eclipselink.core.resource.orm.EclipseLinkOrmPackage#getXmlBasic()
 * @model kind="class"
 * @generated
 */
public class XmlBasic extends org.eclipse.jpt.core.resource.orm.XmlBasic implements XmlAttributeMapping, XmlMutable, XmlConvertibleMapping
{
	/**
	 * The cached value of the '{@link #getAccessMethods() <em>Access Methods</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessMethods()
	 * @generated
	 * @ordered
	 */
	protected XmlAccessMethods accessMethods;
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<XmlProperty> properties;
	/**
	 * The default value of the '{@link #getMutable() <em>Mutable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutable()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean MUTABLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getMutable() <em>Mutable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMutable()
	 * @generated
	 * @ordered
	 */
	protected Boolean mutable = MUTABLE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getConverter() <em>Converter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConverter()
	 * @generated
	 * @ordered
	 */
	protected XmlConverter converter;
	/**
	 * The cached value of the '{@link #getTypeConverter() <em>Type Converter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeConverter()
	 * @generated
	 * @ordered
	 */
	protected XmlTypeConverter typeConverter;
	/**
	 * The cached value of the '{@link #getObjectTypeConverter() <em>Object Type Converter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectTypeConverter()
	 * @generated
	 * @ordered
	 */
	protected XmlObjectTypeConverter objectTypeConverter;
	/**
	 * The cached value of the '{@link #getStructConverter() <em>Struct Converter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructConverter()
	 * @generated
	 * @ordered
	 */
	protected XmlStructConverter structConverter;
	/**
	 * The default value of the '{@link #getConvert() <em>Convert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConvert()
	 * @generated
	 * @ordered
	 */
	protected static final String CONVERT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getConvert() <em>Convert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConvert()
	 * @generated
	 * @ordered
	 */
	protected String convert = CONVERT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XmlBasic()
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
		return EclipseLinkOrmPackage.Literals.XML_BASIC;
	}

	/**
	 * Returns the value of the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mutable</em>' attribute.
	 * @see #setMutable(Boolean)
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.EclipseLinkOrmPackage#getXmlMutable_Mutable()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.BooleanObject"
	 * @generated
	 */
	public Boolean getMutable()
	{
		return mutable;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.XmlBasic#getMutable <em>Mutable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mutable</em>' attribute.
	 * @see #getMutable()
	 * @generated
	 */
	public void setMutable(Boolean newMutable)
	{
		Boolean oldMutable = mutable;
		mutable = newMutable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseLinkOrmPackage.XML_BASIC__MUTABLE, oldMutable, mutable));
	}

	/**
	 * Returns the value of the '<em><b>Convert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Convert</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Convert</em>' attribute.
	 * @see #setConvert(String)
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.EclipseLinkOrmPackage#getXmlConvertibleMapping_Convert()
	 * @model
	 * @generated
	 */
	public String getConvert()
	{
		return convert;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.XmlBasic#getConvert <em>Convert</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Convert</em>' attribute.
	 * @see #getConvert()
	 * @generated
	 */
	public void setConvert(String newConvert)
	{
		String oldConvert = convert;
		convert = newConvert;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseLinkOrmPackage.XML_BASIC__CONVERT, oldConvert, convert));
	}

	/**
	 * Returns the value of the '<em><b>Access Methods</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Methods</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Methods</em>' containment reference.
	 * @see #setAccessMethods(XmlAccessMethods)
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.EclipseLinkOrmPackage#getXmlAccessMethodsHolder_AccessMethods()
	 * @model containment="true"
	 * @generated
	 */
	public XmlAccessMethods getAccessMethods()
	{
		return accessMethods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAccessMethods(XmlAccessMethods newAccessMethods, NotificationChain msgs)
	{
		XmlAccessMethods oldAccessMethods = accessMethods;
		accessMethods = newAccessMethods;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EclipseLinkOrmPackage.XML_BASIC__ACCESS_METHODS, oldAccessMethods, newAccessMethods);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.XmlBasic#getAccessMethods <em>Access Methods</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Access Methods</em>' containment reference.
	 * @see #getAccessMethods()
	 * @generated
	 */
	public void setAccessMethods(XmlAccessMethods newAccessMethods)
	{
		if (newAccessMethods != accessMethods)
		{
			NotificationChain msgs = null;
			if (accessMethods != null)
				msgs = ((InternalEObject)accessMethods).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EclipseLinkOrmPackage.XML_BASIC__ACCESS_METHODS, null, msgs);
			if (newAccessMethods != null)
				msgs = ((InternalEObject)newAccessMethods).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EclipseLinkOrmPackage.XML_BASIC__ACCESS_METHODS, null, msgs);
			msgs = basicSetAccessMethods(newAccessMethods, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseLinkOrmPackage.XML_BASIC__ACCESS_METHODS, newAccessMethods, newAccessMethods));
	}

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.jpt.eclipselink.core.resource.orm.XmlProperty}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.EclipseLinkOrmPackage#getXmlPropertyContainer_Properties()
	 * @model containment="true"
	 * @generated
	 */
	public EList<XmlProperty> getProperties()
	{
		if (properties == null)
		{
			properties = new EObjectContainmentEList<XmlProperty>(XmlProperty.class, this, EclipseLinkOrmPackage.XML_BASIC__PROPERTIES);
		}
		return properties;
	}

	/**
	 * Returns the value of the '<em><b>Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>CustomConverter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Converter</em>' containment reference.
	 * @see #setConverter(XmlConverter)
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.EclipseLinkOrmPackage#getXmlConverterHolder_Converter()
	 * @model containment="true"
	 * @generated
	 */
	public XmlConverter getConverter()
	{
		return converter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConverter(XmlConverter newConverter, NotificationChain msgs)
	{
		XmlConverter oldConverter = converter;
		converter = newConverter;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EclipseLinkOrmPackage.XML_BASIC__CONVERTER, oldConverter, newConverter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.XmlBasic#getConverter <em>Converter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Converter</em>' containment reference.
	 * @see #getConverter()
	 * @generated
	 */
	public void setConverter(XmlConverter newConverter)
	{
		if (newConverter != converter)
		{
			NotificationChain msgs = null;
			if (converter != null)
				msgs = ((InternalEObject)converter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EclipseLinkOrmPackage.XML_BASIC__CONVERTER, null, msgs);
			if (newConverter != null)
				msgs = ((InternalEObject)newConverter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EclipseLinkOrmPackage.XML_BASIC__CONVERTER, null, msgs);
			msgs = basicSetConverter(newConverter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseLinkOrmPackage.XML_BASIC__CONVERTER, newConverter, newConverter));
	}

	/**
	 * Returns the value of the '<em><b>Type Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type CustomConverter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Converter</em>' containment reference.
	 * @see #setTypeConverter(XmlTypeConverter)
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.EclipseLinkOrmPackage#getXmlConverterHolder_TypeConverter()
	 * @model containment="true"
	 * @generated
	 */
	public XmlTypeConverter getTypeConverter()
	{
		return typeConverter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeConverter(XmlTypeConverter newTypeConverter, NotificationChain msgs)
	{
		XmlTypeConverter oldTypeConverter = typeConverter;
		typeConverter = newTypeConverter;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EclipseLinkOrmPackage.XML_BASIC__TYPE_CONVERTER, oldTypeConverter, newTypeConverter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.XmlBasic#getTypeConverter <em>Type Converter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Converter</em>' containment reference.
	 * @see #getTypeConverter()
	 * @generated
	 */
	public void setTypeConverter(XmlTypeConverter newTypeConverter)
	{
		if (newTypeConverter != typeConverter)
		{
			NotificationChain msgs = null;
			if (typeConverter != null)
				msgs = ((InternalEObject)typeConverter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EclipseLinkOrmPackage.XML_BASIC__TYPE_CONVERTER, null, msgs);
			if (newTypeConverter != null)
				msgs = ((InternalEObject)newTypeConverter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EclipseLinkOrmPackage.XML_BASIC__TYPE_CONVERTER, null, msgs);
			msgs = basicSetTypeConverter(newTypeConverter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseLinkOrmPackage.XML_BASIC__TYPE_CONVERTER, newTypeConverter, newTypeConverter));
	}

	/**
	 * Returns the value of the '<em><b>Object Type Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Type CustomConverter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Type Converter</em>' containment reference.
	 * @see #setObjectTypeConverter(XmlObjectTypeConverter)
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.EclipseLinkOrmPackage#getXmlConverterHolder_ObjectTypeConverter()
	 * @model containment="true"
	 * @generated
	 */
	public XmlObjectTypeConverter getObjectTypeConverter()
	{
		return objectTypeConverter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObjectTypeConverter(XmlObjectTypeConverter newObjectTypeConverter, NotificationChain msgs)
	{
		XmlObjectTypeConverter oldObjectTypeConverter = objectTypeConverter;
		objectTypeConverter = newObjectTypeConverter;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EclipseLinkOrmPackage.XML_BASIC__OBJECT_TYPE_CONVERTER, oldObjectTypeConverter, newObjectTypeConverter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.XmlBasic#getObjectTypeConverter <em>Object Type Converter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Type Converter</em>' containment reference.
	 * @see #getObjectTypeConverter()
	 * @generated
	 */
	public void setObjectTypeConverter(XmlObjectTypeConverter newObjectTypeConverter)
	{
		if (newObjectTypeConverter != objectTypeConverter)
		{
			NotificationChain msgs = null;
			if (objectTypeConverter != null)
				msgs = ((InternalEObject)objectTypeConverter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EclipseLinkOrmPackage.XML_BASIC__OBJECT_TYPE_CONVERTER, null, msgs);
			if (newObjectTypeConverter != null)
				msgs = ((InternalEObject)newObjectTypeConverter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EclipseLinkOrmPackage.XML_BASIC__OBJECT_TYPE_CONVERTER, null, msgs);
			msgs = basicSetObjectTypeConverter(newObjectTypeConverter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseLinkOrmPackage.XML_BASIC__OBJECT_TYPE_CONVERTER, newObjectTypeConverter, newObjectTypeConverter));
	}

	/**
	 * Returns the value of the '<em><b>Struct Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Struct CustomConverter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Struct Converter</em>' containment reference.
	 * @see #setStructConverter(XmlStructConverter)
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.EclipseLinkOrmPackage#getXmlConverterHolder_StructConverter()
	 * @model containment="true"
	 * @generated
	 */
	public XmlStructConverter getStructConverter()
	{
		return structConverter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStructConverter(XmlStructConverter newStructConverter, NotificationChain msgs)
	{
		XmlStructConverter oldStructConverter = structConverter;
		structConverter = newStructConverter;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EclipseLinkOrmPackage.XML_BASIC__STRUCT_CONVERTER, oldStructConverter, newStructConverter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Sets the value of the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.XmlBasic#getStructConverter <em>Struct Converter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Struct Converter</em>' containment reference.
	 * @see #getStructConverter()
	 * @generated
	 */
	public void setStructConverter(XmlStructConverter newStructConverter)
	{
		if (newStructConverter != structConverter)
		{
			NotificationChain msgs = null;
			if (structConverter != null)
				msgs = ((InternalEObject)structConverter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EclipseLinkOrmPackage.XML_BASIC__STRUCT_CONVERTER, null, msgs);
			if (newStructConverter != null)
				msgs = ((InternalEObject)newStructConverter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EclipseLinkOrmPackage.XML_BASIC__STRUCT_CONVERTER, null, msgs);
			msgs = basicSetStructConverter(newStructConverter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseLinkOrmPackage.XML_BASIC__STRUCT_CONVERTER, newStructConverter, newStructConverter));
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
			case EclipseLinkOrmPackage.XML_BASIC__ACCESS_METHODS:
				return basicSetAccessMethods(null, msgs);
			case EclipseLinkOrmPackage.XML_BASIC__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case EclipseLinkOrmPackage.XML_BASIC__CONVERTER:
				return basicSetConverter(null, msgs);
			case EclipseLinkOrmPackage.XML_BASIC__TYPE_CONVERTER:
				return basicSetTypeConverter(null, msgs);
			case EclipseLinkOrmPackage.XML_BASIC__OBJECT_TYPE_CONVERTER:
				return basicSetObjectTypeConverter(null, msgs);
			case EclipseLinkOrmPackage.XML_BASIC__STRUCT_CONVERTER:
				return basicSetStructConverter(null, msgs);
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
			case EclipseLinkOrmPackage.XML_BASIC__ACCESS_METHODS:
				return getAccessMethods();
			case EclipseLinkOrmPackage.XML_BASIC__PROPERTIES:
				return getProperties();
			case EclipseLinkOrmPackage.XML_BASIC__MUTABLE:
				return getMutable();
			case EclipseLinkOrmPackage.XML_BASIC__CONVERTER:
				return getConverter();
			case EclipseLinkOrmPackage.XML_BASIC__TYPE_CONVERTER:
				return getTypeConverter();
			case EclipseLinkOrmPackage.XML_BASIC__OBJECT_TYPE_CONVERTER:
				return getObjectTypeConverter();
			case EclipseLinkOrmPackage.XML_BASIC__STRUCT_CONVERTER:
				return getStructConverter();
			case EclipseLinkOrmPackage.XML_BASIC__CONVERT:
				return getConvert();
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
			case EclipseLinkOrmPackage.XML_BASIC__ACCESS_METHODS:
				setAccessMethods((XmlAccessMethods)newValue);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends XmlProperty>)newValue);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__MUTABLE:
				setMutable((Boolean)newValue);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__CONVERTER:
				setConverter((XmlConverter)newValue);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__TYPE_CONVERTER:
				setTypeConverter((XmlTypeConverter)newValue);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__OBJECT_TYPE_CONVERTER:
				setObjectTypeConverter((XmlObjectTypeConverter)newValue);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__STRUCT_CONVERTER:
				setStructConverter((XmlStructConverter)newValue);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__CONVERT:
				setConvert((String)newValue);
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
			case EclipseLinkOrmPackage.XML_BASIC__ACCESS_METHODS:
				setAccessMethods((XmlAccessMethods)null);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__PROPERTIES:
				getProperties().clear();
				return;
			case EclipseLinkOrmPackage.XML_BASIC__MUTABLE:
				setMutable(MUTABLE_EDEFAULT);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__CONVERTER:
				setConverter((XmlConverter)null);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__TYPE_CONVERTER:
				setTypeConverter((XmlTypeConverter)null);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__OBJECT_TYPE_CONVERTER:
				setObjectTypeConverter((XmlObjectTypeConverter)null);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__STRUCT_CONVERTER:
				setStructConverter((XmlStructConverter)null);
				return;
			case EclipseLinkOrmPackage.XML_BASIC__CONVERT:
				setConvert(CONVERT_EDEFAULT);
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
			case EclipseLinkOrmPackage.XML_BASIC__ACCESS_METHODS:
				return accessMethods != null;
			case EclipseLinkOrmPackage.XML_BASIC__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case EclipseLinkOrmPackage.XML_BASIC__MUTABLE:
				return MUTABLE_EDEFAULT == null ? mutable != null : !MUTABLE_EDEFAULT.equals(mutable);
			case EclipseLinkOrmPackage.XML_BASIC__CONVERTER:
				return converter != null;
			case EclipseLinkOrmPackage.XML_BASIC__TYPE_CONVERTER:
				return typeConverter != null;
			case EclipseLinkOrmPackage.XML_BASIC__OBJECT_TYPE_CONVERTER:
				return objectTypeConverter != null;
			case EclipseLinkOrmPackage.XML_BASIC__STRUCT_CONVERTER:
				return structConverter != null;
			case EclipseLinkOrmPackage.XML_BASIC__CONVERT:
				return CONVERT_EDEFAULT == null ? convert != null : !CONVERT_EDEFAULT.equals(convert);
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
		if (baseClass == XmlAccessMethodsHolder.class)
		{
			switch (derivedFeatureID)
			{
				case EclipseLinkOrmPackage.XML_BASIC__ACCESS_METHODS: return EclipseLinkOrmPackage.XML_ACCESS_METHODS_HOLDER__ACCESS_METHODS;
				default: return -1;
			}
		}
		if (baseClass == XmlPropertyContainer.class)
		{
			switch (derivedFeatureID)
			{
				case EclipseLinkOrmPackage.XML_BASIC__PROPERTIES: return EclipseLinkOrmPackage.XML_PROPERTY_CONTAINER__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == XmlAttributeMapping.class)
		{
			switch (derivedFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == XmlMutable.class)
		{
			switch (derivedFeatureID)
			{
				case EclipseLinkOrmPackage.XML_BASIC__MUTABLE: return EclipseLinkOrmPackage.XML_MUTABLE__MUTABLE;
				default: return -1;
			}
		}
		if (baseClass == XmlConverterHolder.class)
		{
			switch (derivedFeatureID)
			{
				case EclipseLinkOrmPackage.XML_BASIC__CONVERTER: return EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__CONVERTER;
				case EclipseLinkOrmPackage.XML_BASIC__TYPE_CONVERTER: return EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__TYPE_CONVERTER;
				case EclipseLinkOrmPackage.XML_BASIC__OBJECT_TYPE_CONVERTER: return EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__OBJECT_TYPE_CONVERTER;
				case EclipseLinkOrmPackage.XML_BASIC__STRUCT_CONVERTER: return EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__STRUCT_CONVERTER;
				default: return -1;
			}
		}
		if (baseClass == XmlConvertibleMapping.class)
		{
			switch (derivedFeatureID)
			{
				case EclipseLinkOrmPackage.XML_BASIC__CONVERT: return EclipseLinkOrmPackage.XML_CONVERTIBLE_MAPPING__CONVERT;
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
		if (baseClass == XmlAccessMethodsHolder.class)
		{
			switch (baseFeatureID)
			{
				case EclipseLinkOrmPackage.XML_ACCESS_METHODS_HOLDER__ACCESS_METHODS: return EclipseLinkOrmPackage.XML_BASIC__ACCESS_METHODS;
				default: return -1;
			}
		}
		if (baseClass == XmlPropertyContainer.class)
		{
			switch (baseFeatureID)
			{
				case EclipseLinkOrmPackage.XML_PROPERTY_CONTAINER__PROPERTIES: return EclipseLinkOrmPackage.XML_BASIC__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == XmlAttributeMapping.class)
		{
			switch (baseFeatureID)
			{
				default: return -1;
			}
		}
		if (baseClass == XmlMutable.class)
		{
			switch (baseFeatureID)
			{
				case EclipseLinkOrmPackage.XML_MUTABLE__MUTABLE: return EclipseLinkOrmPackage.XML_BASIC__MUTABLE;
				default: return -1;
			}
		}
		if (baseClass == XmlConverterHolder.class)
		{
			switch (baseFeatureID)
			{
				case EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__CONVERTER: return EclipseLinkOrmPackage.XML_BASIC__CONVERTER;
				case EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__TYPE_CONVERTER: return EclipseLinkOrmPackage.XML_BASIC__TYPE_CONVERTER;
				case EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__OBJECT_TYPE_CONVERTER: return EclipseLinkOrmPackage.XML_BASIC__OBJECT_TYPE_CONVERTER;
				case EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__STRUCT_CONVERTER: return EclipseLinkOrmPackage.XML_BASIC__STRUCT_CONVERTER;
				default: return -1;
			}
		}
		if (baseClass == XmlConvertibleMapping.class)
		{
			switch (baseFeatureID)
			{
				case EclipseLinkOrmPackage.XML_CONVERTIBLE_MAPPING__CONVERT: return EclipseLinkOrmPackage.XML_BASIC__CONVERT;
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
		result.append(" (mutable: ");
		result.append(mutable);
		result.append(", convert: ");
		result.append(convert);
		result.append(')');
		return result.toString();
	}

	public TextRange getMutableTextRange() {
		return getAttributeTextRange(JPA.MUTABLE);
	}
	
	public TextRange getConvertTextRange() {
		return getElementTextRange(JPA.CONVERT);
	}
	
	// ********** translators **********

	public static Translator buildTranslator(String elementName, EStructuralFeature structuralFeature) {
		return new SimpleTranslator(
			elementName, 
			structuralFeature, 
			EclipseLinkOrmPackage.eINSTANCE.getXmlBasic(), 
			buildTranslatorChildren());
	}

	private static Translator[] buildTranslatorChildren() {
		return new Translator[] {
			buildNameTranslator(),
			buildFetchTranslator(),
			buildOptionalTranslator(),
			buildMutableTranslator(),
			buildColumnTranslator(), 
			buildLobTranslator(),
			buildTemporalTranslator(),
			buildEnumeratedTranslator(),
			buildConvertTranslator(),
			buildConverterTranslator(),
			buildTypeConverterTranslator(),
			buildObjectTypeConverterTranslator(),
			buildStructConverterTranslator(),
			buildPropertyTranslator(),
			buildAccessMethodsTranslator()
		};
	}
	
	protected static Translator buildMutableTranslator() {
		return new Translator(JPA.MUTABLE, EclipseLinkOrmPackage.eINSTANCE.getXmlMutable_Mutable(), Translator.DOM_ATTRIBUTE);
	}
	
	protected static Translator buildConvertTranslator() {
		return new Translator(JPA.CONVERT, EclipseLinkOrmPackage.eINSTANCE.getXmlConvertibleMapping_Convert());
	}
	
	protected static Translator buildConverterTranslator() {
		return XmlConverter.buildTranslator(JPA.CONVERTER, EclipseLinkOrmPackage.eINSTANCE.getXmlConverterHolder_Converter());
	}
	
	protected static Translator buildTypeConverterTranslator() {
		return XmlTypeConverter.buildTranslator(JPA.TYPE_CONVERTER, EclipseLinkOrmPackage.eINSTANCE.getXmlConverterHolder_TypeConverter());
	}
	
	protected static Translator buildObjectTypeConverterTranslator() {
		return XmlObjectTypeConverter.buildTranslator(JPA.OBJECT_TYPE_CONVERTER, EclipseLinkOrmPackage.eINSTANCE.getXmlConverterHolder_ObjectTypeConverter());
	}
	
	protected static Translator buildStructConverterTranslator() {
		return XmlStructConverter.buildTranslator(JPA.STRUCT_CONVERTER, EclipseLinkOrmPackage.eINSTANCE.getXmlConverterHolder_StructConverter());
	}
		
	protected static Translator buildPropertyTranslator() {
		return XmlProperty.buildTranslator(JPA.PROPERTY, EclipseLinkOrmPackage.eINSTANCE.getXmlPropertyContainer_Properties());
	}
	
	protected static Translator buildAccessMethodsTranslator() {
		return XmlAccessMethods.buildTranslator(JPA.ACCESS_METHODS, EclipseLinkOrmPackage.eINSTANCE.getXmlAccessMethodsHolder_AccessMethods());
	}
}
