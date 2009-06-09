/*******************************************************************************
 * Copyright (c) 2008, 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.eclipselink.core.internal.context.orm;

import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.jpt.core.JpaFactory;
import org.eclipse.jpt.core.context.java.JavaAttributeMapping;
import org.eclipse.jpt.core.context.orm.OrmAttributeMapping;
import org.eclipse.jpt.core.context.orm.OrmAttributeMappingProvider;
import org.eclipse.jpt.core.context.orm.OrmPersistentAttribute;
import org.eclipse.jpt.core.context.orm.OrmTypeMapping;
import org.eclipse.jpt.core.resource.orm.XmlAttributeMapping;
import org.eclipse.jpt.eclipselink.core.EclipseLinkMappingKeys;
import org.eclipse.jpt.eclipselink.core.internal.EclipseLink1_1JpaFactory;
import org.eclipse.jpt.eclipselink.core.internal.JptEclipseLinkCorePlugin;
import org.eclipse.jpt.eclipselink.core.internal.context.java.JavaBasicCollectionMapping;
import org.eclipse.jpt.eclipselink.core.resource.orm.XmlBasicCollection;
import org.eclipse.jpt.eclipselink1_1.core.resource.orm.EclipseLink1_1OrmFactory;

public class EclipseLink1_1OrmBasicCollectionMappingProvider
	implements OrmAttributeMappingProvider
{

	// singleton
	private static final EclipseLink1_1OrmBasicCollectionMappingProvider INSTANCE = new EclipseLink1_1OrmBasicCollectionMappingProvider();

	/**
	 * Return the singleton.
	 */
	public static OrmAttributeMappingProvider instance() {
		return INSTANCE;
	}

	/**
	 * Ensure single instance.
	 */
	private EclipseLink1_1OrmBasicCollectionMappingProvider() {
		super();
	}
	
	public IContentType getContentType() {
		return JptEclipseLinkCorePlugin.ECLIPSELINK1_1_ORM_XML_CONTENT_TYPE;
	}
	
	public String getKey() {
		return EclipseLinkMappingKeys.BASIC_COLLECTION_ATTRIBUTE_MAPPING_KEY;
	}
	
	public XmlAttributeMapping buildResourceMapping() {
		return EclipseLink1_1OrmFactory.eINSTANCE.createXmlBasicCollection();
	}

	public OrmAttributeMapping buildMapping(OrmPersistentAttribute parent, XmlAttributeMapping resourceMapping, JpaFactory factory) {
		return ((EclipseLink1_1JpaFactory) factory).buildEclipseLink1_1OrmBasicCollectionMapping(parent, (XmlBasicCollection) resourceMapping);
	}
	
	public XmlAttributeMapping buildVirtualResourceMapping(OrmTypeMapping ormTypeMapping, JavaAttributeMapping javaAttributeMapping, JpaFactory factory) {
		return ((EclipseLink1_1JpaFactory) factory).buildEclipseLink1_1VirtualXmlBasicCollection(ormTypeMapping, (JavaBasicCollectionMapping) javaAttributeMapping);
	}
}
