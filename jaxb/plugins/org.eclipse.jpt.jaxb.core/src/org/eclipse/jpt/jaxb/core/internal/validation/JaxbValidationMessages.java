/*******************************************************************************
 * Copyright (c) 2010, 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jaxb.core.internal.validation;

@SuppressWarnings("nls")
public interface JaxbValidationMessages {
	
	// bundle name
	String BUNDLE_NAME = "jaxb_validation";
	
	// validation on project
	
	String NO_JAXB_PROJECT = "NO_JAXB_PROJECT"; 
	String PROJECT_INVALID_LIBRARY_PROVIDER = "PROJECT_INVALID_LIBRARY_PROVIDER";
	String PROJECT_UNRESOLVED_SCHEMA = "PROJECT_UNRESOLVED_SCHEMA";
	
	
	// validation on package
	
	String PACKAGE_NO_SCHEMA_FOR_NAMESPACE = "PACKAGE_NO_SCHEMA_FOR_NAMESPACE";
	String PACKAGE_XML_JAVA_TYPE_ADAPTER_TYPE_NOT_SPECIFIED = "PACKAGE_XML_JAVA_TYPE_ADAPTER_TYPE_NOT_SPECIFIED";
	
	String XML_SCHEMA__MISMATCHED_ATTRIBUTE_FORM_DEFAULT = "XML_SCHEMA__MISMATCHED_ATTRIBUTE_FORM_DEFAULT";
	String XML_SCHEMA__MISMATCHED_ELEMENT_FORM_DEFAULT = "XML_SCHEMA__MISMATCHED_ELEMENT_FORM_DEFAULT";
	
	
	// validation on type
	
	String XML_ENUM__NON_SIMPLE_SCHEMA_TYPE = "XML_ENUM__NON_SIMPLE_SCHEMA_TYPE";
	
	String XML_TYPE__UNMATCHING_NAMESPACE_FOR_ANONYMOUS_TYPE = "XML_TYPE__UNMATCHING_NAMESPACE_FOR_ANONYMOUS_TYPE";
	String XML_TYPE__DUPLICATE_PROP = "XML_TYPE__DUPLICATE_PROP";
	String XML_TYPE__MISSING_PROP = "XML_TYPE__MISSING_PROP";
	String XML_TYPE__NONEXISTENT_PROP = "XML_TYPE__NONEXISTENT_PROP";
	String XML_TYPE__TRANSIENT_PROP = "XML_TYPE__TRANSIENT_PROP";
	String XML_TYPE__FACTORY_CLASS_IGNORED_FOR_ENUM = "XML_TYPE__FACTORY_CLASS_IGNORED_FOR_ENUM";
	String XML_TYPE__FACTORY_METHOD_IGNORED_FOR_ENUM = "XML_TYPE__FACTORY_METHOD_IGNORED_FOR_ENUM";
	String XML_TYPE__PROP_ORDER_IGNORED_FOR_ENUM = "XML_TYPE__PROP_ORDER_IGNORED_FOR_ENUM";
	
	String XML_ROOT_ELEMENT_TYPE_CONFLICTS_WITH_XML_TYPE = "XML_ROOT_ELEMENT_TYPE_CONFLICTS_WITH_XML_TYPE";
	
	
	// validation on enum constant 
	
	String XML_ENUM_VALUE__INVALID_LEXICAL_VALUE = "XML_ENUM_VALUE__INVALID_LEXICAL_VALUE";
	
	
	// validation on attribute
	
	String ATTRIBUTE_MAPPING__UNSUPPORTED_ANNOTATION = "ATTRIBUTE_MAPPING__UNSUPPORTED_ANNOTATION";
	String ATTRIBUTE_MAPPING_XML_JAVA_TYPE_ADAPTER_TYPE_NOT_DEFINED = "ATTRIBUTE_MAPPING_XML_JAVA_TYPE_ADAPTER_TYPE_NOT_DEFINED";
	String XML_ELEMENT_WRAPPER_DEFINED_ON_NON_ARRAY_NON_COLLECTION = "XML_ELEMENT_WRAPPER_DEFINED_ON_NON_ARRAY_NON_COLLECTION";
	
	String XML_ANY_ATTRIBUTE__MULTIPLE_MAPPINGS_DEFINED = "XML_ANY_ATTRIBUTE__MULTIPLE_MAPPINGS_DEFINED";
	String XML_ANY_ATTRIBUTE__NON_MAP_TYPE = "XML_ANY_ATTRIBUTE__NON_MAP_TYPE";
	
	String XML_ANY_ELEMENT__MULTIPLE_MAPPINGS_DEFINED = "XML_ANY_ELEMENT__MULTIPLE_MAPPINGS_DEFINED";
	
	String XML_ELEMENT__UNSPECIFIED_TYPE = "XML_ELEMENT__UNSPECIFIED_TYPE";
	String XML_ELEMENT__ILLEGAL_TYPE = "XML_ELEMENT__ILLEGAL_TYPE";
	
	String XML_ELEMENT_DECL__INVALID_METHOD_SIGNATURE_RETURN_TYPE = "XML_ELEMENT_DECL__INVALID_METHOD_SIGNATURE_RETURN_TYPE";
	String XML_ELEMENT_DECL__INVALID_METHOD_SIGNATURE_PARAM = "XML_ELEMENT_DECL__INVALID_METHOD_SIGNATURE_PARAM";
	String XML_ELEMENT_DECL__SUBST_HEAD_NAME_EQUALS_NAME = "XML_ELEMENT_DECL__SUBST_HEAD_NAME_EQUALS_NAME";
	String XML_ELEMENT_DECL__SUBST_HEAD_NO_MATCHING_ELEMENT_DECL = "XML_ELEMENT_DECL__SUBST_HEAD_NO_MATCHING_ELEMENT_DECL";
	
	String XML_ELEMENT_REF__UNSPECIFIED_TYPE = "XML_ELEMENT_REF__UNSPECIFIED_TYPE";
	String XML_ELEMENT_REF__ILLEGAL_TYPE = "XML_ELEMENT_REF__ILLEGAL_TYPE";
	String XML_ELEMENT_REF__NO_ROOT_ELEMENT = "XML_ELEMENT_REF__NO_ROOT_ELEMENT";
	String XML_ELEMENT_REF__NO_REGISTRY = "XML_ELEMENT_REF__NO_REGISTRY";
	String XML_ELEMENT_REF__NO_MATCHING_ELEMENT_DECL = "XML_ELEMENT_REF__NO_MATCHING_ELEMENT_DECL";
	
	String XML_ELEMENT_REFS__DUPLICATE_XML_ELEMENT_TYPE = "XML_ELEMENT_REFS__DUPLICATE_XML_ELEMENT_TYPE";
	String XML_ELEMENT_REFS__DUPLICATE_XML_ELEMENT_QNAME = "XML_ELEMENT_REFS__DUPLICATE_XML_ELEMENT_QNAME";
	
	String XML_ELEMENTS__DUPLICATE_XML_ELEMENT_TYPE = "XML_ELEMENTS__DUPLICATE_XML_ELEMENT_TYPE";
	String XML_ELEMENTS__DUPLICATE_XML_ELEMENT_QNAME = "XML_ELEMENTS__DUPLICATE_XML_ELEMENT_QNAME";
	
	String XML_ID__MULTIPLE_MAPPINGS_DEFINED = "XML_ID__MULTIPLE_MAPPINGS_DEFINED";
	String XML_ID__ATTRIBUTE_TYPE_NOT_STRING = "XML_ID__ATTRIBUTE_TYPE_NOT_STRING";
	String XML_ID__SCHEMA_TYPE_NOT_ID = "XML_ID__SCHEMA_TYPE_NOT_ID";
	
	String XML_LIST__ATTRIBUTE_NOT_COLLECTION_TYPE = "XML_LIST__ATTRIBUTE_NOT_COLLECTION_TYPE";
	String XML_LIST__ITEM_TYPE_NOT_MAPPED_TO_VALID_SCHEMA_TYPE = "XML_LIST__ITEM_TYPE_NOT_MAPPED_TO_VALID_SCHEMA_TYPE";
	
	String XML_REGISTRY__DUPLICATE_XML_ELEMENT_QNAME = "XML_REGISTRY__DUPLICATE_XML_ELEMENT_QNAME";
	
	String XML_VALUE__MULTIPLE_MAPPINGS_DEFINED = "XML_VALUE__MULTIPLE_MAPPINGS_DEFINED";
	
	String XML_IDREF__TYPE_DOES_NOT_CONTAIN_XML_ID = "XML_IDREF__TYPE_DOES_NOT_CONTAIN_XML_ID";
	
	String XML_VALUE_MAPPING_WITH_NON_XML_ATTRIBUTE_MAPPING_DEFINED = "XML_VALUE_MAPPING_WITH_NON_XML_ATTRIBUTE_MAPPING_DEFINED";
	
	
	// general validation
	
	String XML_SCHEMA_TYPE__NON_SIMPLE_TYPE = "XML_SCHEMA_TYPE__NON_SIMPLE_TYPE";
	String XML_SCHEMA_TYPE__TYPE_NOT_SPECIFIED_ON_PACKAGE = "XML_SCHEMA_TYPE__TYPE_NOT_SPECIFIED_ON_PACKAGE";
	String XML_SCHEMA_TYPE__TYPE_SPECIFIED_ON_ATTRIBUTE = "XML_SCHEMA_TYPE__TYPE_SPECIFIED_ON_ATTRIBUTE";
	
	String QNAME__MISSING_NAME = "QNAME__MISSING_NAME";
	String QNAME__UNRESOLVED_COMPONENT = "QNAME__UNRESOLVED_COMPONENT";
}
