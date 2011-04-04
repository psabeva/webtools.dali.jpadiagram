/*******************************************************************************
 * Copyright (c) 2006, 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jpa.core.internal.context.java;

import org.eclipse.jpt.common.utility.internal.iterables.ArrayIterable;
import org.eclipse.jpt.jpa.core.JpaFactory;
import org.eclipse.jpt.jpa.core.MappingKeys;
import org.eclipse.jpt.jpa.core.context.java.JavaAttributeMapping;
import org.eclipse.jpt.jpa.core.context.java.JavaAttributeMappingDefinition;
import org.eclipse.jpt.jpa.core.context.java.JavaPersistentAttribute;
import org.eclipse.jpt.jpa.core.resource.java.JoinColumnAnnotation;
import org.eclipse.jpt.jpa.core.resource.java.JoinColumnsAnnotation;
import org.eclipse.jpt.jpa.core.resource.java.JoinTableAnnotation;
import org.eclipse.jpt.jpa.core.resource.java.MapKeyAnnotation;
import org.eclipse.jpt.jpa.core.resource.java.OneToManyAnnotation;
import org.eclipse.jpt.jpa.core.resource.java.OrderByAnnotation;

public class JavaOneToManyMappingDefinition
	implements JavaAttributeMappingDefinition
{
	// singleton
	private static final JavaAttributeMappingDefinition INSTANCE = new JavaOneToManyMappingDefinition();

	/**
	 * Return the singleton
	 */
	public static JavaAttributeMappingDefinition instance() {
		return INSTANCE;
	}


	/**
	 * Enforce singleton usage
	 */
	private JavaOneToManyMappingDefinition() {
		super();
	}

	public String getKey() {
		return MappingKeys.ONE_TO_MANY_ATTRIBUTE_MAPPING_KEY;
	}

	public String getAnnotationName() {
		return OneToManyAnnotation.ANNOTATION_NAME;
	}

	public boolean isSpecified(JavaPersistentAttribute persistentAttribute) {
		return persistentAttribute.getResourcePersistentAttribute().getAnnotation(this.getAnnotationName()) != null;
	}

	public Iterable<String> getSupportingAnnotationNames() {
		return SUPPORTING_ANNOTATION_NAMES;
	}

	private static final String[] SUPPORTING_ANNOTATION_NAMES_ARRAY = new String[] {
		JoinTableAnnotation.ANNOTATION_NAME,
		MapKeyAnnotation.ANNOTATION_NAME,
		OrderByAnnotation.ANNOTATION_NAME,
		JoinColumnAnnotation.ANNOTATION_NAME,
		JoinColumnsAnnotation.ANNOTATION_NAME
	};
	private static final Iterable<String> SUPPORTING_ANNOTATION_NAMES = new ArrayIterable<String>(SUPPORTING_ANNOTATION_NAMES_ARRAY);

	public JavaAttributeMapping buildMapping(JavaPersistentAttribute persistentAttribute, JpaFactory factory) {
		return factory.buildJavaOneToManyMapping(persistentAttribute);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
