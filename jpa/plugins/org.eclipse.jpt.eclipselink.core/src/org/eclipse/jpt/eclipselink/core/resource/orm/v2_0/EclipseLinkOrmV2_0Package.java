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

package org.eclipse.jpt.eclipselink.core.resource.orm.v2_0;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.jpt.core.resource.orm.OrmPackage;
import org.eclipse.jpt.core.resource.orm.v2_0.OrmV2_0Package;
import org.eclipse.jpt.core.resource.xml.CommonPackage;
import org.eclipse.jpt.eclipselink.core.resource.orm.EclipseLinkOrmPackage;
import org.eclipse.jpt.eclipselink.core.resource.orm.v1_1.EclipseLinkOrmV1_1Package;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Factory
 * @model kind="package"
 * @generated
 */
public class EclipseLinkOrmV2_0Package extends EPackageImpl
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "v2_0";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "jpt.eclipselink.orm.v2_0.xmi";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "org.eclipse.jpt.eclipselink.core.resource.orm.v2_0";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final EclipseLinkOrmV2_0Package eINSTANCE = org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package.init();

	/**
	 * The meta object id for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCacheInterceptor2_0 <em>Xml Cache Interceptor2 0</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCacheInterceptor2_0
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlCacheInterceptor2_0()
	 * @generated
	 */
	public static final int XML_CACHE_INTERCEPTOR2_0 = 0;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_CACHE_INTERCEPTOR2_0__CLASS_NAME = 0;

	/**
	 * The number of structural features of the '<em>Xml Cache Interceptor2 0</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_CACHE_INTERCEPTOR2_0_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMapKeyAssociationOverrideContainer2_0 <em>Xml Map Key Association Override Container2 0</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMapKeyAssociationOverrideContainer2_0
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlMapKeyAssociationOverrideContainer2_0()
	 * @generated
	 */
	public static final int XML_MAP_KEY_ASSOCIATION_OVERRIDE_CONTAINER2_0 = 5;

	/**
	 * The feature id for the '<em><b>Map Key Association Overrides</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_MAP_KEY_ASSOCIATION_OVERRIDE_CONTAINER2_0__MAP_KEY_ASSOCIATION_OVERRIDES = 0;

	/**
	 * The number of structural features of the '<em>Xml Map Key Association Override Container2 0</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_MAP_KEY_ASSOCIATION_OVERRIDE_CONTAINER2_0_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCollectionMapping_2_0 <em>Xml Collection Mapping 20</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCollectionMapping_2_0
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlCollectionMapping_2_0()
	 * @generated
	 */
	public static final int XML_COLLECTION_MAPPING_20 = 1;

	/**
	 * The feature id for the '<em><b>Map Key Association Overrides</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_COLLECTION_MAPPING_20__MAP_KEY_ASSOCIATION_OVERRIDES = XML_MAP_KEY_ASSOCIATION_OVERRIDE_CONTAINER2_0__MAP_KEY_ASSOCIATION_OVERRIDES;

	/**
	 * The feature id for the '<em><b>Map Key Convert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_COLLECTION_MAPPING_20__MAP_KEY_CONVERT = XML_MAP_KEY_ASSOCIATION_OVERRIDE_CONTAINER2_0_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xml Collection Mapping 20</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_COLLECTION_MAPPING_20_FEATURE_COUNT = XML_MAP_KEY_ASSOCIATION_OVERRIDE_CONTAINER2_0_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlElementCollection_2_0 <em>Xml Element Collection 20</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlElementCollection_2_0
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlElementCollection_2_0()
	 * @generated
	 */
	public static final int XML_ELEMENT_COLLECTION_20 = 2;

	/**
	 * The feature id for the '<em><b>Access</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__ACCESS = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING__ACCESS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__NAME = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING__NAME;

	/**
	 * The feature id for the '<em><b>Access Methods</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__ACCESS_METHODS = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING__ACCESS_METHODS;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__PROPERTIES = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Lob</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__LOB = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Temporal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__TEMPORAL = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Enumerated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__ENUMERATED = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__CONVERTER = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__TYPE_CONVERTER = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Object Type Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__OBJECT_TYPE_CONVERTER = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Struct Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__STRUCT_CONVERTER = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Convert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__CONVERT = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Converters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__CONVERTERS = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Type Converters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__TYPE_CONVERTERS = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Object Type Converters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__OBJECT_TYPE_CONVERTERS = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Struct Converters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__STRUCT_CONVERTERS = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Map Key Association Overrides</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__MAP_KEY_ASSOCIATION_OVERRIDES = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Map Key Convert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20__MAP_KEY_CONVERT = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Xml Element Collection 20</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ELEMENT_COLLECTION_20_FEATURE_COUNT = EclipseLinkOrmPackage.XML_ATTRIBUTE_MAPPING_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlEntity2_0 <em>Xml Entity2 0</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlEntity2_0
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlEntity2_0()
	 * @generated
	 */
	public static final int XML_ENTITY2_0 = 3;

	/**
	 * The feature id for the '<em><b>Cacheable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ENTITY2_0__CACHEABLE = OrmV2_0Package.XML_ENTITY_20__CACHEABLE;

	/**
	 * The feature id for the '<em><b>Cache Interceptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ENTITY2_0__CACHE_INTERCEPTOR = OrmV2_0Package.XML_ENTITY_20_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Query Redirectors</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ENTITY2_0__QUERY_REDIRECTORS = OrmV2_0Package.XML_ENTITY_20_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Xml Entity2 0</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ENTITY2_0_FEATURE_COUNT = OrmV2_0Package.XML_ENTITY_20_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlManyToMany_2_0 <em>Xml Many To Many 20</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlManyToMany_2_0
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlManyToMany_2_0()
	 * @generated
	 */
	public static final int XML_MANY_TO_MANY_20 = 4;

	/**
	 * The feature id for the '<em><b>Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_MANY_TO_MANY_20__CONVERTER = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__CONVERTER;

	/**
	 * The feature id for the '<em><b>Type Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_MANY_TO_MANY_20__TYPE_CONVERTER = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__TYPE_CONVERTER;

	/**
	 * The feature id for the '<em><b>Object Type Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_MANY_TO_MANY_20__OBJECT_TYPE_CONVERTER = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__OBJECT_TYPE_CONVERTER;

	/**
	 * The feature id for the '<em><b>Struct Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_MANY_TO_MANY_20__STRUCT_CONVERTER = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__STRUCT_CONVERTER;

	/**
	 * The feature id for the '<em><b>Map Key Association Overrides</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_MANY_TO_MANY_20__MAP_KEY_ASSOCIATION_OVERRIDES = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Map Key Convert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_MANY_TO_MANY_20__MAP_KEY_CONVERT = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Xml Many To Many 20</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_MANY_TO_MANY_20_FEATURE_COUNT = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMappedSuperclass_2_0 <em>Xml Mapped Superclass 20</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMappedSuperclass_2_0
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlMappedSuperclass_2_0()
	 * @generated
	 */
	public static final int XML_MAPPED_SUPERCLASS_20 = 6;

	/**
	 * The feature id for the '<em><b>Cacheable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_MAPPED_SUPERCLASS_20__CACHEABLE = OrmV2_0Package.XML_CACHEABLE_20__CACHEABLE;

	/**
	 * The feature id for the '<em><b>Cache Interceptor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_MAPPED_SUPERCLASS_20__CACHE_INTERCEPTOR = OrmV2_0Package.XML_CACHEABLE_20_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Xml Mapped Superclass 20</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_MAPPED_SUPERCLASS_20_FEATURE_COUNT = OrmV2_0Package.XML_CACHEABLE_20_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOneToMany_2_0 <em>Xml One To Many 20</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOneToMany_2_0
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlOneToMany_2_0()
	 * @generated
	 */
	public static final int XML_ONE_TO_MANY_20 = 7;

	/**
	 * The feature id for the '<em><b>Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ONE_TO_MANY_20__CONVERTER = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__CONVERTER;

	/**
	 * The feature id for the '<em><b>Type Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ONE_TO_MANY_20__TYPE_CONVERTER = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__TYPE_CONVERTER;

	/**
	 * The feature id for the '<em><b>Object Type Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ONE_TO_MANY_20__OBJECT_TYPE_CONVERTER = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__OBJECT_TYPE_CONVERTER;

	/**
	 * The feature id for the '<em><b>Struct Converter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ONE_TO_MANY_20__STRUCT_CONVERTER = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER__STRUCT_CONVERTER;

	/**
	 * The feature id for the '<em><b>Map Key Association Overrides</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ONE_TO_MANY_20__MAP_KEY_ASSOCIATION_OVERRIDES = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Map Key Convert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ONE_TO_MANY_20__MAP_KEY_CONVERT = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Xml One To Many 20</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ONE_TO_MANY_20_FEATURE_COUNT = EclipseLinkOrmPackage.XML_CONVERTER_HOLDER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOrderColumn_2_0 <em>Xml Order Column 20</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOrderColumn_2_0
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlOrderColumn_2_0()
	 * @generated
	 */
	public static final int XML_ORDER_COLUMN_20 = 8;

	/**
	 * The feature id for the '<em><b>Correction Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ORDER_COLUMN_20__CORRECTION_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Xml Order Column 20</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_ORDER_COLUMN_20_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0 <em>Xml Query Redirectors2 0</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlQueryRedirectors2_0()
	 * @generated
	 */
	public static final int XML_QUERY_REDIRECTORS2_0 = 9;

	/**
	 * The feature id for the '<em><b>All Queries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_QUERY_REDIRECTORS2_0__ALL_QUERIES = 0;

	/**
	 * The feature id for the '<em><b>Read All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_QUERY_REDIRECTORS2_0__READ_ALL = 1;

	/**
	 * The feature id for the '<em><b>Read Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_QUERY_REDIRECTORS2_0__READ_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Report</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_QUERY_REDIRECTORS2_0__REPORT = 3;

	/**
	 * The feature id for the '<em><b>Update</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_QUERY_REDIRECTORS2_0__UPDATE = 4;

	/**
	 * The feature id for the '<em><b>Insert</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_QUERY_REDIRECTORS2_0__INSERT = 5;

	/**
	 * The feature id for the '<em><b>Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_QUERY_REDIRECTORS2_0__DELETE = 6;

	/**
	 * The number of structural features of the '<em>Xml Query Redirectors2 0</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XML_QUERY_REDIRECTORS2_0_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.OrderCorrectionType_2_0 <em>Order Correction Type 20</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.OrderCorrectionType_2_0
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getOrderCorrectionType_2_0()
	 * @generated
	 */
	public static final int ORDER_CORRECTION_TYPE_20 = 10;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlCacheInterceptor2_0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlCollectionMapping_2_0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlElementCollection_2_0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlEntity2_0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlManyToMany_2_0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlMappedSuperclass_2_0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlOneToMany_2_0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlOrderColumn_2_0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlQueryRedirectors2_0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlMapKeyAssociationOverrideContainer2_0EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum orderCorrectionType_2_0EEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EclipseLinkOrmV2_0Package()
	{
		super(eNS_URI, EclipseLinkOrmV2_0Factory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EclipseLinkOrmV2_0Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EclipseLinkOrmV2_0Package init()
	{
		if (isInited) return (EclipseLinkOrmV2_0Package)EPackage.Registry.INSTANCE.getEPackage(EclipseLinkOrmV2_0Package.eNS_URI);

		// Obtain or create and register package
		EclipseLinkOrmV2_0Package theEclipseLinkOrmV2_0Package = (EclipseLinkOrmV2_0Package)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EclipseLinkOrmV2_0Package ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EclipseLinkOrmV2_0Package());

		isInited = true;

		// Initialize simple dependencies
		OrmPackage.eINSTANCE.eClass();
		CommonPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EclipseLinkOrmPackage theEclipseLinkOrmPackage = (EclipseLinkOrmPackage)(EPackage.Registry.INSTANCE.getEPackage(EclipseLinkOrmPackage.eNS_URI) instanceof EclipseLinkOrmPackage ? EPackage.Registry.INSTANCE.getEPackage(EclipseLinkOrmPackage.eNS_URI) : EclipseLinkOrmPackage.eINSTANCE);
		EclipseLinkOrmV1_1Package theEclipseLinkOrmV1_1Package = (EclipseLinkOrmV1_1Package)(EPackage.Registry.INSTANCE.getEPackage(EclipseLinkOrmV1_1Package.eNS_URI) instanceof EclipseLinkOrmV1_1Package ? EPackage.Registry.INSTANCE.getEPackage(EclipseLinkOrmV1_1Package.eNS_URI) : EclipseLinkOrmV1_1Package.eINSTANCE);

		// Create package meta-data objects
		theEclipseLinkOrmV2_0Package.createPackageContents();
		theEclipseLinkOrmPackage.createPackageContents();
		theEclipseLinkOrmV1_1Package.createPackageContents();

		// Initialize created meta-data
		theEclipseLinkOrmV2_0Package.initializePackageContents();
		theEclipseLinkOrmPackage.initializePackageContents();
		theEclipseLinkOrmV1_1Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEclipseLinkOrmV2_0Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EclipseLinkOrmV2_0Package.eNS_URI, theEclipseLinkOrmV2_0Package);
		return theEclipseLinkOrmV2_0Package;
	}


	/**
	 * Returns the meta object for class '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCacheInterceptor2_0 <em>Xml Cache Interceptor2 0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Cache Interceptor2 0</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCacheInterceptor2_0
	 * @generated
	 */
	public EClass getXmlCacheInterceptor2_0()
	{
		return xmlCacheInterceptor2_0EClass;
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCacheInterceptor2_0#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCacheInterceptor2_0#getClassName()
	 * @see #getXmlCacheInterceptor2_0()
	 * @generated
	 */
	public EAttribute getXmlCacheInterceptor2_0_ClassName()
	{
		return (EAttribute)xmlCacheInterceptor2_0EClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for class '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCollectionMapping_2_0 <em>Xml Collection Mapping 20</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Collection Mapping 20</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCollectionMapping_2_0
	 * @generated
	 */
	public EClass getXmlCollectionMapping_2_0()
	{
		return xmlCollectionMapping_2_0EClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCollectionMapping_2_0#getMapKeyConvert <em>Map Key Convert</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Map Key Convert</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCollectionMapping_2_0#getMapKeyConvert()
	 * @see #getXmlCollectionMapping_2_0()
	 * @generated
	 */
	public EAttribute getXmlCollectionMapping_2_0_MapKeyConvert()
	{
		return (EAttribute)xmlCollectionMapping_2_0EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlElementCollection_2_0 <em>Xml Element Collection 20</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Element Collection 20</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlElementCollection_2_0
	 * @generated
	 */
	public EClass getXmlElementCollection_2_0()
	{
		return xmlElementCollection_2_0EClass;
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlEntity2_0 <em>Xml Entity2 0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Entity2 0</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlEntity2_0
	 * @generated
	 */
	public EClass getXmlEntity2_0()
	{
		return xmlEntity2_0EClass;
	}


	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlEntity2_0#getCacheInterceptor <em>Cache Interceptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cache Interceptor</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlEntity2_0#getCacheInterceptor()
	 * @see #getXmlEntity2_0()
	 * @generated
	 */
	public EReference getXmlEntity2_0_CacheInterceptor()
	{
		return (EReference)xmlEntity2_0EClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlEntity2_0#getQueryRedirectors <em>Query Redirectors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Query Redirectors</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlEntity2_0#getQueryRedirectors()
	 * @see #getXmlEntity2_0()
	 * @generated
	 */
	public EReference getXmlEntity2_0_QueryRedirectors()
	{
		return (EReference)xmlEntity2_0EClass.getEStructuralFeatures().get(1);
	}


	/**
	 * Returns the meta object for class '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlManyToMany_2_0 <em>Xml Many To Many 20</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Many To Many 20</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlManyToMany_2_0
	 * @generated
	 */
	public EClass getXmlManyToMany_2_0()
	{
		return xmlManyToMany_2_0EClass;
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMappedSuperclass_2_0 <em>Xml Mapped Superclass 20</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Mapped Superclass 20</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMappedSuperclass_2_0
	 * @generated
	 */
	public EClass getXmlMappedSuperclass_2_0()
	{
		return xmlMappedSuperclass_2_0EClass;
	}


	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMappedSuperclass_2_0#getCacheInterceptor <em>Cache Interceptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cache Interceptor</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMappedSuperclass_2_0#getCacheInterceptor()
	 * @see #getXmlMappedSuperclass_2_0()
	 * @generated
	 */
	public EReference getXmlMappedSuperclass_2_0_CacheInterceptor()
	{
		return (EReference)xmlMappedSuperclass_2_0EClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for class '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOneToMany_2_0 <em>Xml One To Many 20</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml One To Many 20</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOneToMany_2_0
	 * @generated
	 */
	public EClass getXmlOneToMany_2_0()
	{
		return xmlOneToMany_2_0EClass;
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOrderColumn_2_0 <em>Xml Order Column 20</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Order Column 20</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOrderColumn_2_0
	 * @generated
	 */
	public EClass getXmlOrderColumn_2_0()
	{
		return xmlOrderColumn_2_0EClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOrderColumn_2_0#getCorrectionType <em>Correction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Correction Type</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOrderColumn_2_0#getCorrectionType()
	 * @see #getXmlOrderColumn_2_0()
	 * @generated
	 */
	public EAttribute getXmlOrderColumn_2_0_CorrectionType()
	{
		return (EAttribute)xmlOrderColumn_2_0EClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for class '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0 <em>Xml Query Redirectors2 0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Query Redirectors2 0</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0
	 * @generated
	 */
	public EClass getXmlQueryRedirectors2_0()
	{
		return xmlQueryRedirectors2_0EClass;
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getAllQueries <em>All Queries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>All Queries</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getAllQueries()
	 * @see #getXmlQueryRedirectors2_0()
	 * @generated
	 */
	public EAttribute getXmlQueryRedirectors2_0_AllQueries()
	{
		return (EAttribute)xmlQueryRedirectors2_0EClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getReadAll <em>Read All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read All</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getReadAll()
	 * @see #getXmlQueryRedirectors2_0()
	 * @generated
	 */
	public EAttribute getXmlQueryRedirectors2_0_ReadAll()
	{
		return (EAttribute)xmlQueryRedirectors2_0EClass.getEStructuralFeatures().get(1);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getReadObject <em>Read Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Read Object</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getReadObject()
	 * @see #getXmlQueryRedirectors2_0()
	 * @generated
	 */
	public EAttribute getXmlQueryRedirectors2_0_ReadObject()
	{
		return (EAttribute)xmlQueryRedirectors2_0EClass.getEStructuralFeatures().get(2);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getReport <em>Report</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Report</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getReport()
	 * @see #getXmlQueryRedirectors2_0()
	 * @generated
	 */
	public EAttribute getXmlQueryRedirectors2_0_Report()
	{
		return (EAttribute)xmlQueryRedirectors2_0EClass.getEStructuralFeatures().get(3);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getUpdate <em>Update</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Update</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getUpdate()
	 * @see #getXmlQueryRedirectors2_0()
	 * @generated
	 */
	public EAttribute getXmlQueryRedirectors2_0_Update()
	{
		return (EAttribute)xmlQueryRedirectors2_0EClass.getEStructuralFeatures().get(4);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getInsert <em>Insert</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Insert</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getInsert()
	 * @see #getXmlQueryRedirectors2_0()
	 * @generated
	 */
	public EAttribute getXmlQueryRedirectors2_0_Insert()
	{
		return (EAttribute)xmlQueryRedirectors2_0EClass.getEStructuralFeatures().get(5);
	}


	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getDelete <em>Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delete</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0#getDelete()
	 * @see #getXmlQueryRedirectors2_0()
	 * @generated
	 */
	public EAttribute getXmlQueryRedirectors2_0_Delete()
	{
		return (EAttribute)xmlQueryRedirectors2_0EClass.getEStructuralFeatures().get(6);
	}


	/**
	 * Returns the meta object for class '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMapKeyAssociationOverrideContainer2_0 <em>Xml Map Key Association Override Container2 0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Xml Map Key Association Override Container2 0</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMapKeyAssociationOverrideContainer2_0
	 * @generated
	 */
	public EClass getXmlMapKeyAssociationOverrideContainer2_0()
	{
		return xmlMapKeyAssociationOverrideContainer2_0EClass;
	}


	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMapKeyAssociationOverrideContainer2_0#getMapKeyAssociationOverrides <em>Map Key Association Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Map Key Association Overrides</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMapKeyAssociationOverrideContainer2_0#getMapKeyAssociationOverrides()
	 * @see #getXmlMapKeyAssociationOverrideContainer2_0()
	 * @generated
	 */
	public EReference getXmlMapKeyAssociationOverrideContainer2_0_MapKeyAssociationOverrides()
	{
		return (EReference)xmlMapKeyAssociationOverrideContainer2_0EClass.getEStructuralFeatures().get(0);
	}


	/**
	 * Returns the meta object for enum '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.OrderCorrectionType_2_0 <em>Order Correction Type 20</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Order Correction Type 20</em>'.
	 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.OrderCorrectionType_2_0
	 * @generated
	 */
	public EEnum getOrderCorrectionType_2_0()
	{
		return orderCorrectionType_2_0EEnum;
	}


	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public EclipseLinkOrmV2_0Factory getEclipseLinkOrmV2_0Factory()
	{
		return (EclipseLinkOrmV2_0Factory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		xmlCacheInterceptor2_0EClass = createEClass(XML_CACHE_INTERCEPTOR2_0);
		createEAttribute(xmlCacheInterceptor2_0EClass, XML_CACHE_INTERCEPTOR2_0__CLASS_NAME);

		xmlCollectionMapping_2_0EClass = createEClass(XML_COLLECTION_MAPPING_20);
		createEAttribute(xmlCollectionMapping_2_0EClass, XML_COLLECTION_MAPPING_20__MAP_KEY_CONVERT);

		xmlElementCollection_2_0EClass = createEClass(XML_ELEMENT_COLLECTION_20);

		xmlEntity2_0EClass = createEClass(XML_ENTITY2_0);
		createEReference(xmlEntity2_0EClass, XML_ENTITY2_0__CACHE_INTERCEPTOR);
		createEReference(xmlEntity2_0EClass, XML_ENTITY2_0__QUERY_REDIRECTORS);

		xmlManyToMany_2_0EClass = createEClass(XML_MANY_TO_MANY_20);

		xmlMapKeyAssociationOverrideContainer2_0EClass = createEClass(XML_MAP_KEY_ASSOCIATION_OVERRIDE_CONTAINER2_0);
		createEReference(xmlMapKeyAssociationOverrideContainer2_0EClass, XML_MAP_KEY_ASSOCIATION_OVERRIDE_CONTAINER2_0__MAP_KEY_ASSOCIATION_OVERRIDES);

		xmlMappedSuperclass_2_0EClass = createEClass(XML_MAPPED_SUPERCLASS_20);
		createEReference(xmlMappedSuperclass_2_0EClass, XML_MAPPED_SUPERCLASS_20__CACHE_INTERCEPTOR);

		xmlOneToMany_2_0EClass = createEClass(XML_ONE_TO_MANY_20);

		xmlOrderColumn_2_0EClass = createEClass(XML_ORDER_COLUMN_20);
		createEAttribute(xmlOrderColumn_2_0EClass, XML_ORDER_COLUMN_20__CORRECTION_TYPE);

		xmlQueryRedirectors2_0EClass = createEClass(XML_QUERY_REDIRECTORS2_0);
		createEAttribute(xmlQueryRedirectors2_0EClass, XML_QUERY_REDIRECTORS2_0__ALL_QUERIES);
		createEAttribute(xmlQueryRedirectors2_0EClass, XML_QUERY_REDIRECTORS2_0__READ_ALL);
		createEAttribute(xmlQueryRedirectors2_0EClass, XML_QUERY_REDIRECTORS2_0__READ_OBJECT);
		createEAttribute(xmlQueryRedirectors2_0EClass, XML_QUERY_REDIRECTORS2_0__REPORT);
		createEAttribute(xmlQueryRedirectors2_0EClass, XML_QUERY_REDIRECTORS2_0__UPDATE);
		createEAttribute(xmlQueryRedirectors2_0EClass, XML_QUERY_REDIRECTORS2_0__INSERT);
		createEAttribute(xmlQueryRedirectors2_0EClass, XML_QUERY_REDIRECTORS2_0__DELETE);

		// Create enums
		orderCorrectionType_2_0EEnum = createEEnum(ORDER_CORRECTION_TYPE_20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EclipseLinkOrmPackage theEclipseLinkOrmPackage = (EclipseLinkOrmPackage)EPackage.Registry.INSTANCE.getEPackage(EclipseLinkOrmPackage.eNS_URI);
		OrmV2_0Package theOrmV2_0Package = (OrmV2_0Package)EPackage.Registry.INSTANCE.getEPackage(OrmV2_0Package.eNS_URI);
		OrmPackage theOrmPackage = (OrmPackage)EPackage.Registry.INSTANCE.getEPackage(OrmPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xmlCollectionMapping_2_0EClass.getESuperTypes().add(this.getXmlMapKeyAssociationOverrideContainer2_0());
		xmlElementCollection_2_0EClass.getESuperTypes().add(theEclipseLinkOrmPackage.getXmlAttributeMapping());
		xmlElementCollection_2_0EClass.getESuperTypes().add(theEclipseLinkOrmPackage.getXmlConvertibleMapping());
		xmlElementCollection_2_0EClass.getESuperTypes().add(theEclipseLinkOrmPackage.getXmlConvertersHolder());
		xmlElementCollection_2_0EClass.getESuperTypes().add(this.getXmlCollectionMapping_2_0());
		xmlEntity2_0EClass.getESuperTypes().add(theOrmV2_0Package.getXmlEntity_2_0());
		xmlManyToMany_2_0EClass.getESuperTypes().add(theEclipseLinkOrmPackage.getXmlConverterHolder());
		xmlManyToMany_2_0EClass.getESuperTypes().add(this.getXmlCollectionMapping_2_0());
		xmlMappedSuperclass_2_0EClass.getESuperTypes().add(theOrmV2_0Package.getXmlCacheable_2_0());
		xmlOneToMany_2_0EClass.getESuperTypes().add(theEclipseLinkOrmPackage.getXmlConverterHolder());
		xmlOneToMany_2_0EClass.getESuperTypes().add(this.getXmlCollectionMapping_2_0());

		// Initialize classes and features; add operations and parameters
		initEClass(xmlCacheInterceptor2_0EClass, XmlCacheInterceptor2_0.class, "XmlCacheInterceptor2_0", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXmlCacheInterceptor2_0_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, XmlCacheInterceptor2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmlCollectionMapping_2_0EClass, XmlCollectionMapping_2_0.class, "XmlCollectionMapping_2_0", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXmlCollectionMapping_2_0_MapKeyConvert(), ecorePackage.getEString(), "mapKeyConvert", null, 0, 1, XmlCollectionMapping_2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmlElementCollection_2_0EClass, XmlElementCollection_2_0.class, "XmlElementCollection_2_0", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xmlEntity2_0EClass, XmlEntity2_0.class, "XmlEntity2_0", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXmlEntity2_0_CacheInterceptor(), this.getXmlCacheInterceptor2_0(), null, "cacheInterceptor", null, 0, 1, XmlEntity2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXmlEntity2_0_QueryRedirectors(), this.getXmlQueryRedirectors2_0(), null, "queryRedirectors", null, 0, 1, XmlEntity2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmlManyToMany_2_0EClass, XmlManyToMany_2_0.class, "XmlManyToMany_2_0", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xmlMapKeyAssociationOverrideContainer2_0EClass, XmlMapKeyAssociationOverrideContainer2_0.class, "XmlMapKeyAssociationOverrideContainer2_0", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXmlMapKeyAssociationOverrideContainer2_0_MapKeyAssociationOverrides(), theOrmPackage.getXmlAssociationOverride(), null, "mapKeyAssociationOverrides", null, 0, -1, XmlMapKeyAssociationOverrideContainer2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmlMappedSuperclass_2_0EClass, XmlMappedSuperclass_2_0.class, "XmlMappedSuperclass_2_0", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXmlMappedSuperclass_2_0_CacheInterceptor(), this.getXmlCacheInterceptor2_0(), null, "cacheInterceptor", null, 0, 1, XmlMappedSuperclass_2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmlOneToMany_2_0EClass, XmlOneToMany_2_0.class, "XmlOneToMany_2_0", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xmlOrderColumn_2_0EClass, XmlOrderColumn_2_0.class, "XmlOrderColumn_2_0", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXmlOrderColumn_2_0_CorrectionType(), this.getOrderCorrectionType_2_0(), "correctionType", null, 0, 1, XmlOrderColumn_2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmlQueryRedirectors2_0EClass, XmlQueryRedirectors2_0.class, "XmlQueryRedirectors2_0", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXmlQueryRedirectors2_0_AllQueries(), ecorePackage.getEString(), "allQueries", null, 0, 1, XmlQueryRedirectors2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXmlQueryRedirectors2_0_ReadAll(), ecorePackage.getEString(), "readAll", null, 0, 1, XmlQueryRedirectors2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXmlQueryRedirectors2_0_ReadObject(), ecorePackage.getEString(), "readObject", null, 0, 1, XmlQueryRedirectors2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXmlQueryRedirectors2_0_Report(), ecorePackage.getEString(), "report", null, 0, 1, XmlQueryRedirectors2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXmlQueryRedirectors2_0_Update(), ecorePackage.getEString(), "update", null, 0, 1, XmlQueryRedirectors2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXmlQueryRedirectors2_0_Insert(), ecorePackage.getEString(), "insert", null, 0, 1, XmlQueryRedirectors2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXmlQueryRedirectors2_0_Delete(), ecorePackage.getEString(), "delete", null, 0, 1, XmlQueryRedirectors2_0.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(orderCorrectionType_2_0EEnum, OrderCorrectionType_2_0.class, "OrderCorrectionType_2_0");
		addEEnumLiteral(orderCorrectionType_2_0EEnum, OrderCorrectionType_2_0.READ);
		addEEnumLiteral(orderCorrectionType_2_0EEnum, OrderCorrectionType_2_0.READ_WRITE);
		addEEnumLiteral(orderCorrectionType_2_0EEnum, OrderCorrectionType_2_0.EXCEPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCacheInterceptor2_0 <em>Xml Cache Interceptor2 0</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCacheInterceptor2_0
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlCacheInterceptor2_0()
		 * @generated
		 */
		public static final EClass XML_CACHE_INTERCEPTOR2_0 = eINSTANCE.getXmlCacheInterceptor2_0();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute XML_CACHE_INTERCEPTOR2_0__CLASS_NAME = eINSTANCE.getXmlCacheInterceptor2_0_ClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCollectionMapping_2_0 <em>Xml Collection Mapping 20</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlCollectionMapping_2_0
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlCollectionMapping_2_0()
		 * @generated
		 */
		public static final EClass XML_COLLECTION_MAPPING_20 = eINSTANCE.getXmlCollectionMapping_2_0();

		/**
		 * The meta object literal for the '<em><b>Map Key Convert</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute XML_COLLECTION_MAPPING_20__MAP_KEY_CONVERT = eINSTANCE.getXmlCollectionMapping_2_0_MapKeyConvert();

		/**
		 * The meta object literal for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlElementCollection_2_0 <em>Xml Element Collection 20</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlElementCollection_2_0
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlElementCollection_2_0()
		 * @generated
		 */
		public static final EClass XML_ELEMENT_COLLECTION_20 = eINSTANCE.getXmlElementCollection_2_0();

		/**
		 * The meta object literal for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlEntity2_0 <em>Xml Entity2 0</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlEntity2_0
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlEntity2_0()
		 * @generated
		 */
		public static final EClass XML_ENTITY2_0 = eINSTANCE.getXmlEntity2_0();

		/**
		 * The meta object literal for the '<em><b>Cache Interceptor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference XML_ENTITY2_0__CACHE_INTERCEPTOR = eINSTANCE.getXmlEntity2_0_CacheInterceptor();

		/**
		 * The meta object literal for the '<em><b>Query Redirectors</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference XML_ENTITY2_0__QUERY_REDIRECTORS = eINSTANCE.getXmlEntity2_0_QueryRedirectors();

		/**
		 * The meta object literal for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlManyToMany_2_0 <em>Xml Many To Many 20</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlManyToMany_2_0
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlManyToMany_2_0()
		 * @generated
		 */
		public static final EClass XML_MANY_TO_MANY_20 = eINSTANCE.getXmlManyToMany_2_0();

		/**
		 * The meta object literal for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMappedSuperclass_2_0 <em>Xml Mapped Superclass 20</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMappedSuperclass_2_0
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlMappedSuperclass_2_0()
		 * @generated
		 */
		public static final EClass XML_MAPPED_SUPERCLASS_20 = eINSTANCE.getXmlMappedSuperclass_2_0();

		/**
		 * The meta object literal for the '<em><b>Cache Interceptor</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference XML_MAPPED_SUPERCLASS_20__CACHE_INTERCEPTOR = eINSTANCE.getXmlMappedSuperclass_2_0_CacheInterceptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOneToMany_2_0 <em>Xml One To Many 20</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOneToMany_2_0
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlOneToMany_2_0()
		 * @generated
		 */
		public static final EClass XML_ONE_TO_MANY_20 = eINSTANCE.getXmlOneToMany_2_0();

		/**
		 * The meta object literal for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOrderColumn_2_0 <em>Xml Order Column 20</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlOrderColumn_2_0
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlOrderColumn_2_0()
		 * @generated
		 */
		public static final EClass XML_ORDER_COLUMN_20 = eINSTANCE.getXmlOrderColumn_2_0();

		/**
		 * The meta object literal for the '<em><b>Correction Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute XML_ORDER_COLUMN_20__CORRECTION_TYPE = eINSTANCE.getXmlOrderColumn_2_0_CorrectionType();

		/**
		 * The meta object literal for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0 <em>Xml Query Redirectors2 0</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlQueryRedirectors2_0
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlQueryRedirectors2_0()
		 * @generated
		 */
		public static final EClass XML_QUERY_REDIRECTORS2_0 = eINSTANCE.getXmlQueryRedirectors2_0();

		/**
		 * The meta object literal for the '<em><b>All Queries</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute XML_QUERY_REDIRECTORS2_0__ALL_QUERIES = eINSTANCE.getXmlQueryRedirectors2_0_AllQueries();

		/**
		 * The meta object literal for the '<em><b>Read All</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute XML_QUERY_REDIRECTORS2_0__READ_ALL = eINSTANCE.getXmlQueryRedirectors2_0_ReadAll();

		/**
		 * The meta object literal for the '<em><b>Read Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute XML_QUERY_REDIRECTORS2_0__READ_OBJECT = eINSTANCE.getXmlQueryRedirectors2_0_ReadObject();

		/**
		 * The meta object literal for the '<em><b>Report</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute XML_QUERY_REDIRECTORS2_0__REPORT = eINSTANCE.getXmlQueryRedirectors2_0_Report();

		/**
		 * The meta object literal for the '<em><b>Update</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute XML_QUERY_REDIRECTORS2_0__UPDATE = eINSTANCE.getXmlQueryRedirectors2_0_Update();

		/**
		 * The meta object literal for the '<em><b>Insert</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute XML_QUERY_REDIRECTORS2_0__INSERT = eINSTANCE.getXmlQueryRedirectors2_0_Insert();

		/**
		 * The meta object literal for the '<em><b>Delete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute XML_QUERY_REDIRECTORS2_0__DELETE = eINSTANCE.getXmlQueryRedirectors2_0_Delete();

		/**
		 * The meta object literal for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMapKeyAssociationOverrideContainer2_0 <em>Xml Map Key Association Override Container2 0</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.XmlMapKeyAssociationOverrideContainer2_0
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getXmlMapKeyAssociationOverrideContainer2_0()
		 * @generated
		 */
		public static final EClass XML_MAP_KEY_ASSOCIATION_OVERRIDE_CONTAINER2_0 = eINSTANCE.getXmlMapKeyAssociationOverrideContainer2_0();

		/**
		 * The meta object literal for the '<em><b>Map Key Association Overrides</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference XML_MAP_KEY_ASSOCIATION_OVERRIDE_CONTAINER2_0__MAP_KEY_ASSOCIATION_OVERRIDES = eINSTANCE.getXmlMapKeyAssociationOverrideContainer2_0_MapKeyAssociationOverrides();

		/**
		 * The meta object literal for the '{@link org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.OrderCorrectionType_2_0 <em>Order Correction Type 20</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.OrderCorrectionType_2_0
		 * @see org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLinkOrmV2_0Package#getOrderCorrectionType_2_0()
		 * @generated
		 */
		public static final EEnum ORDER_CORRECTION_TYPE_20 = eINSTANCE.getOrderCorrectionType_2_0();

	}

} //EclipseLinkOrmV2_0Package
