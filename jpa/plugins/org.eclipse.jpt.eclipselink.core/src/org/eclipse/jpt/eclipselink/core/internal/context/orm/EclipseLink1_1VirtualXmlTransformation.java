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

import org.eclipse.emf.common.util.EList;
import org.eclipse.jpt.core.context.orm.OrmTypeMapping;
import org.eclipse.jpt.core.resource.orm.AccessType;
import org.eclipse.jpt.core.utility.TextRange;
import org.eclipse.jpt.eclipselink.core.internal.context.java.JavaTransformationMapping;
import org.eclipse.jpt.eclipselink.core.resource.orm.XmlAccessMethods;
import org.eclipse.jpt.eclipselink.core.resource.orm.XmlProperty;
import org.eclipse.jpt.eclipselink1_1.core.resource.orm.XmlTransformation;

/**
 * VirtualBasic is an implementation of Basic used when there is 
 * no tag in the orm.xml and an underlying javaBasicMapping exists.
 */
public class EclipseLink1_1VirtualXmlTransformation extends XmlTransformation
{

	protected OrmTypeMapping ormTypeMapping;
	
	protected final JavaTransformationMapping javaAttributeMapping;

	protected final VirtualXmlTransformation virtualXmlTransformation;
		
	public EclipseLink1_1VirtualXmlTransformation(OrmTypeMapping ormTypeMapping, JavaTransformationMapping javaTransformationMapping) {
		super();
		this.ormTypeMapping = ormTypeMapping;
		this.javaAttributeMapping = javaTransformationMapping;
		this.virtualXmlTransformation = new VirtualXmlTransformation(ormTypeMapping, javaTransformationMapping);
	}
	
	public boolean isOrmMetadataComplete() {
		return this.ormTypeMapping.isMetadataComplete();
	}
	
	@Override
	public String getMappingKey() {
		return this.virtualXmlTransformation.getMappingKey();
	}
	
	@Override
	public String getName() {
		return this.virtualXmlTransformation.getName();
	}

	@Override
	public void setName(String newName) {
		this.virtualXmlTransformation.setName(newName);
	}
	
	@Override
	public TextRange getNameTextRange() {
		return this.virtualXmlTransformation.getNameTextRange();
	}
	
	@Override
	public XmlAccessMethods getAccessMethods() {
		return this.virtualXmlTransformation.getAccessMethods();
	}
	
	@Override
	public void setAccessMethods(XmlAccessMethods value) {
		this.virtualXmlTransformation.setAccessMethods(value);
	}
	
	@Override
	public EList<XmlProperty> getProperties() {
		return this.virtualXmlTransformation.getProperties();
	}
		
	@Override
	public AccessType getAccess() {
		return org.eclipse.jpt.core.context.AccessType.toOrmResourceModel(this.javaAttributeMapping.getPersistentAttribute().getAccess());
	}
	
	@Override
	public void setAccess(AccessType value) {
		throw new UnsupportedOperationException("cannot set values on a virtual mapping"); //$NON-NLS-1$
	}
}
