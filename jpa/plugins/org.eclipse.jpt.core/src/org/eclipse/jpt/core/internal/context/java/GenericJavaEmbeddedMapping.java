/*******************************************************************************
 * Copyright (c) 2007, 2008 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.core.internal.context.java;

import org.eclipse.jpt.core.MappingKeys;
import org.eclipse.jpt.core.context.java.JavaEmbeddedMapping;
import org.eclipse.jpt.core.context.java.JavaPersistentAttribute;
import org.eclipse.jpt.core.resource.java.Embedded;


public class GenericJavaEmbeddedMapping extends AbstractJavaBaseEmbeddedMapping<Embedded> implements JavaEmbeddedMapping
{
	public GenericJavaEmbeddedMapping(JavaPersistentAttribute parent) {
		super(parent);
	}
	
	//****************** IJavaAttributeMapping implemenation *******************

	public String getKey() {
		return MappingKeys.EMBEDDED_ATTRIBUTE_MAPPING_KEY;
	}
	
	public String getAnnotationName() {
		return Embedded.ANNOTATION_NAME;
	}
}
