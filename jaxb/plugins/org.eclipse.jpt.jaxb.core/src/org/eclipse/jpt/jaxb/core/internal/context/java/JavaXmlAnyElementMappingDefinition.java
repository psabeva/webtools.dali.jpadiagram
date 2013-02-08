/*******************************************************************************
 * Copyright (c) 2011, 2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jaxb.core.internal.context.java;

import org.eclipse.jpt.common.utility.internal.iterable.IterableTools;
import org.eclipse.jpt.jaxb.core.JaxbFactory;
import org.eclipse.jpt.jaxb.core.MappingKeys;
import org.eclipse.jpt.jaxb.core.context.JaxbAttributeMapping;
import org.eclipse.jpt.jaxb.core.context.JaxbPersistentAttribute;
import org.eclipse.jpt.jaxb.core.context.java.JavaAttributeMappingDefinition;
import org.eclipse.jpt.jaxb.core.resource.java.JAXB;


public class JavaXmlAnyElementMappingDefinition
		extends AbstractJavaAttributeMappingDefinition {
	
	// singleton
	private static final JavaXmlAnyElementMappingDefinition INSTANCE = 
		new JavaXmlAnyElementMappingDefinition();
	
	private static final String[] SUPPORTING_ANNOTATION_NAMES = {
		JAXB.XML_ELEMENT_REF,
		JAXB.XML_ELEMENT_REFS,
		JAXB.XML_ELEMENT_WRAPPER,
		JAXB.XML_JAVA_TYPE_ADAPTER,
		JAXB.XML_MIXED };
	
	
	/**
	 * Return the singleton.
	 */
	public static JavaAttributeMappingDefinition instance() {
		return INSTANCE;
	}
	
	
	/**
	 * Enforce singleton usage
	 */
	protected JavaXmlAnyElementMappingDefinition() {
		super();
	}
	
	
	public String getKey() {
		return MappingKeys.XML_ANY_ELEMENT_ATTRIBUTE_MAPPING_KEY;
	}
	
	public String getAnnotationName() {
		return JAXB.XML_ANY_ELEMENT;
	}
	
	public Iterable<String> getSupportingAnnotationNames() {
		return IterableTools.listIterable(SUPPORTING_ANNOTATION_NAMES);
	}
	
	public JaxbAttributeMapping buildMapping(JaxbPersistentAttribute parent, JaxbFactory factory) {
		return factory.buildJavaXmlAnyElementMapping(parent);
	}
}
