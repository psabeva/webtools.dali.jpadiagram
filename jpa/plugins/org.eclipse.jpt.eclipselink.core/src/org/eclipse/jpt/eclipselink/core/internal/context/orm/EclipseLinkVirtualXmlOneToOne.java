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
import org.eclipse.jpt.core.context.java.JavaOneToOneMapping;
import org.eclipse.jpt.core.context.orm.OrmTypeMapping;
import org.eclipse.jpt.core.internal.context.orm.VirtualXmlOneToOne;
import org.eclipse.jpt.core.resource.orm.CascadeType;
import org.eclipse.jpt.core.resource.orm.FetchType;
import org.eclipse.jpt.core.resource.orm.XmlJoinColumn;
import org.eclipse.jpt.core.resource.orm.XmlJoinTable;
import org.eclipse.jpt.core.resource.orm.XmlPrimaryKeyJoinColumn;
import org.eclipse.jpt.core.utility.TextRange;
import org.eclipse.jpt.eclipselink.core.context.JoinFetchType;
import org.eclipse.jpt.eclipselink.core.internal.context.java.EclipseLinkJavaOneToOneMapping;
import org.eclipse.jpt.eclipselink.core.resource.orm.XmlAccessMethods;
import org.eclipse.jpt.eclipselink.core.resource.orm.XmlJoinFetchType;
import org.eclipse.jpt.eclipselink.core.resource.orm.XmlOneToOne;
import org.eclipse.jpt.eclipselink.core.resource.orm.XmlProperty;

/**
 * VirtualBasic is an implementation of Basic used when there is 
 * no tag in the orm.xml and an underlying javaBasicMapping exists.
 */
public class EclipseLinkVirtualXmlOneToOne extends XmlOneToOne
{
	protected OrmTypeMapping ormTypeMapping;
	
	protected final JavaOneToOneMapping javaAttributeMapping;

	protected final VirtualXmlOneToOne virtualXmlOneToOne;
		
	public EclipseLinkVirtualXmlOneToOne(OrmTypeMapping ormTypeMapping, JavaOneToOneMapping javaOneToOneMapping) {
		super();
		this.ormTypeMapping = ormTypeMapping;
		this.javaAttributeMapping = javaOneToOneMapping;
		this.virtualXmlOneToOne = new VirtualXmlOneToOne(ormTypeMapping, javaOneToOneMapping);
	}
	
	protected boolean isOrmMetadataComplete() {
		return this.ormTypeMapping.isMetadataComplete();
	}
	
	@Override
	public String getMappingKey() {
		return this.virtualXmlOneToOne.getMappingKey();
	}
	
	@Override
	public String getName() {
		return this.virtualXmlOneToOne.getName();
	}

	@Override
	public void setName(String newName) {
		this.virtualXmlOneToOne.setName(newName);
	}
	
	@Override
	public TextRange getNameTextRange() {
		return this.virtualXmlOneToOne.getNameTextRange();
	}
	
	@Override
	public FetchType getFetch() {
		return this.virtualXmlOneToOne.getFetch();
	}

	@Override
	public void setFetch(FetchType newFetch) {
		this.virtualXmlOneToOne.setFetch(newFetch);
	}

	@Override
	public Boolean getOptional() {
		return this.virtualXmlOneToOne.getOptional();
	}

	@Override
	public void setOptional(Boolean newOptional) {
		this.virtualXmlOneToOne.setOptional(newOptional);
	}

	@Override
	public EList<XmlJoinColumn> getJoinColumns() {
		return this.virtualXmlOneToOne.getJoinColumns();
	}

	@Override
	public CascadeType getCascade() {
		return this.virtualXmlOneToOne.getCascade();
	}
	
	@Override
	public void setCascade(CascadeType value) {
		this.virtualXmlOneToOne.setCascade(value);
	}
	
	@Override
	public XmlJoinTable getJoinTable() {
		return this.virtualXmlOneToOne.getJoinTable();
	}

	@Override
	public void setJoinTable(XmlJoinTable value) {
		this.virtualXmlOneToOne.setJoinTable(value);
	}
	
	@Override
	public String getTargetEntity() {
		return this.virtualXmlOneToOne.getTargetEntity();
	}

	@Override
	public void setTargetEntity(String value) {
		this.virtualXmlOneToOne.setTargetEntity(value);
	}

	@Override
	public String getMappedBy() {
		return this.virtualXmlOneToOne.getMappedBy();
	}

	@Override
	public void setMappedBy(String value) {
		this.virtualXmlOneToOne.setMappedBy(value);
	}

	@Override
	public EList<XmlPrimaryKeyJoinColumn> getPrimaryKeyJoinColumns() {
		return this.virtualXmlOneToOne.getPrimaryKeyJoinColumns();
	}
	
	@Override
	public TextRange getMappedByTextRange() {
		return this.virtualXmlOneToOne.getMappedByTextRange();
	}
	
	@Override
	public TextRange getTargetEntityTextRange() {
		return this.virtualXmlOneToOne.getTargetEntityTextRange();
	}
	
	@Override
	public XmlJoinFetchType getJoinFetch() {
		if (isOrmMetadataComplete()) {
			return null; //don't return default value, it only applies for an empty @JoinFetch
		}
		return JoinFetchType.toOrmResourceModel(((EclipseLinkJavaOneToOneMapping) this.javaAttributeMapping).getJoinFetch().getValue());
	}
	
	@Override
	public void setJoinFetch(XmlJoinFetchType value) {
		throw new UnsupportedOperationException("cannot set values on a virtual mapping"); //$NON-NLS-1$
	}
	
	@Override
	public boolean isPrivateOwned() {
		if (isOrmMetadataComplete()) {
			return false;
		}
		return ((EclipseLinkJavaOneToOneMapping) this.javaAttributeMapping).getPrivateOwned().isPrivateOwned();
	}
	
	@Override
	public void setPrivateOwned(boolean value) {
		throw new UnsupportedOperationException("cannot set values on a virtual mapping"); //$NON-NLS-1$
	}
	
	@Override
	public XmlAccessMethods getAccessMethods() {
		return null;
	}
	
	@Override
	public void setAccessMethods(XmlAccessMethods value) {
		throw new UnsupportedOperationException("cannot set values on a virtual mapping"); //$NON-NLS-1$		
	}
	
	@Override
	public EList<XmlProperty> getProperties() {
		// TODO get from java annotations
		return null;
	}
	
	@Override
	public TextRange getJoinFetchTextRange() {
		return null;
	}
	
	@Override
	public TextRange getPrivateOwnedTextRange() {
		return null;
	}
}
