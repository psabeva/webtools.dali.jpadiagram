/*******************************************************************************
 * Copyright (c) 2009, 2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jpa.core.internal.jpa2.resource.java;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jpt.common.core.resource.java.Annotation;
import org.eclipse.jpt.common.core.resource.java.AnnotationDefinition;
import org.eclipse.jpt.common.core.resource.java.JavaResourceAnnotatedElement;
import org.eclipse.jpt.common.core.utility.jdt.AnnotatedElement;
import org.eclipse.jpt.jpa.core.internal.jpa2.resource.java.binary.BinaryMapKeyEnumeratedAnnotation2_0;
import org.eclipse.jpt.jpa.core.internal.jpa2.resource.java.source.SourceMapKeyEnumeratedAnnotation2_0;
import org.eclipse.jpt.jpa.core.jpa2.resource.java.MapKeyEnumeratedAnnotation2_0;

/**
 * <code>javax.persistence.MapKeyEnumerated</code>
 */
public final class MapKeyEnumeratedAnnotationDefinition2_0
	implements AnnotationDefinition
{
	// singleton
	private static final AnnotationDefinition INSTANCE = new MapKeyEnumeratedAnnotationDefinition2_0();

	/**
	 * Return the singleton.
	 */
	public static AnnotationDefinition instance() {
		return INSTANCE;
	}

	/**
	 * Ensure single instance.
	 */
	private MapKeyEnumeratedAnnotationDefinition2_0() {
		super();
	}

	public Annotation buildAnnotation(JavaResourceAnnotatedElement parent, AnnotatedElement annotatedElement) {
		return new SourceMapKeyEnumeratedAnnotation2_0(parent, annotatedElement);
	}

	public Annotation buildNullAnnotation(JavaResourceAnnotatedElement parent) {
		return new NullMapKeyEnumeratedAnnotation2_0(parent);
	}

	public Annotation buildAnnotation(JavaResourceAnnotatedElement parent, IAnnotation jdtAnnotation) {
		return new BinaryMapKeyEnumeratedAnnotation2_0(parent, jdtAnnotation);
	}

	public String getAnnotationName() {
		return MapKeyEnumeratedAnnotation2_0.ANNOTATION_NAME;
	}
}
