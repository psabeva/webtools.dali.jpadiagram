/*******************************************************************************
 * Copyright (c) 2006, 2008 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.core.internal.context.orm;

import java.util.List;
import org.eclipse.jpt.core.MappingKeys;
import org.eclipse.jpt.core.context.BasicMapping;
import org.eclipse.jpt.core.context.Converter;
import org.eclipse.jpt.core.context.FetchType;
import org.eclipse.jpt.core.context.Fetchable;
import org.eclipse.jpt.core.context.Nullable;
import org.eclipse.jpt.core.context.orm.OrmAttributeMapping;
import org.eclipse.jpt.core.context.orm.OrmBasicMapping;
import org.eclipse.jpt.core.context.orm.OrmColumn;
import org.eclipse.jpt.core.context.orm.OrmColumnMapping;
import org.eclipse.jpt.core.context.orm.OrmConverter;
import org.eclipse.jpt.core.context.orm.OrmPersistentAttribute;
import org.eclipse.jpt.core.internal.validation.DefaultJpaValidationMessages;
import org.eclipse.jpt.core.internal.validation.JpaValidationMessages;
import org.eclipse.jpt.core.resource.orm.AbstractXmlTypeMapping;
import org.eclipse.jpt.core.resource.orm.OrmFactory;
import org.eclipse.jpt.core.resource.orm.XmlAttributeMapping;
import org.eclipse.jpt.core.resource.orm.XmlBasic;
import org.eclipse.jpt.core.resource.orm.XmlColumn;
import org.eclipse.jpt.db.Table;
import org.eclipse.wst.validation.internal.provisional.core.IMessage;


public class GenericOrmBasicMapping extends AbstractOrmAttributeMapping<XmlBasic>
	implements OrmBasicMapping
{
	protected final OrmColumn column;
	
	protected FetchType specifiedFetch;

	protected Boolean specifiedOptional;
	
	protected OrmConverter defaultConverter;
	
	protected OrmConverter specifiedConverter;
	
	public GenericOrmBasicMapping(OrmPersistentAttribute parent) {
		super(parent);
		this.column = getJpaFactory().buildOrmColumn(this, this);
	}

	public FetchType getFetch() {
		return (this.getSpecifiedFetch() == null) ? this.getDefaultFetch() : this.getSpecifiedFetch();
	}

	public FetchType getDefaultFetch() {
		return BasicMapping.DEFAULT_FETCH_TYPE;
	}

	public FetchType getSpecifiedFetch() {
		return this.specifiedFetch;
	}
	
	public void setSpecifiedFetch(FetchType newSpecifiedFetch) {
		FetchType oldFetch = this.specifiedFetch;
		this.specifiedFetch = newSpecifiedFetch;
		this.resourceAttributeMapping.setFetch(FetchType.toOrmResourceModel(newSpecifiedFetch));
		firePropertyChanged(Fetchable.SPECIFIED_FETCH_PROPERTY, oldFetch, newSpecifiedFetch);
	}

	protected void setSpecifiedFetch_(FetchType newSpecifiedFetch) {
		FetchType oldFetch = this.specifiedFetch;
		this.specifiedFetch = newSpecifiedFetch;
		firePropertyChanged(Fetchable.SPECIFIED_FETCH_PROPERTY, oldFetch, newSpecifiedFetch);
	}

	public Boolean getOptional() {
		return (this.getSpecifiedOptional() == null) ? this.getDefaultOptional() : this.getSpecifiedOptional();
	}
	
	public Boolean getDefaultOptional() {
		return Nullable.DEFAULT_OPTIONAL;
	}

	public Boolean getSpecifiedOptional() {
		return this.specifiedOptional;
	}
	
	public void setSpecifiedOptional(Boolean newSpecifiedOptional) {
		Boolean oldOptional = this.specifiedOptional;
		this.specifiedOptional = newSpecifiedOptional;
		this.resourceAttributeMapping.setOptional(newSpecifiedOptional);
		firePropertyChanged(Nullable.SPECIFIED_OPTIONAL_PROPERTY, oldOptional, newSpecifiedOptional);
	}
	
	protected void setSpecifiedOptional_(Boolean newSpecifiedOptional) {
		Boolean oldOptional = this.specifiedOptional;
		this.specifiedOptional = newSpecifiedOptional;
		firePropertyChanged(Nullable.SPECIFIED_OPTIONAL_PROPERTY, oldOptional, newSpecifiedOptional);
	}
	
	public OrmConverter getConverter() {
		return getSpecifiedConverter() == null ? getDefaultConverter() : getSpecifiedConverter();
	}
	
	public OrmConverter getDefaultConverter() {
		return this.defaultConverter;
	}
	
	public OrmConverter getSpecifiedConverter() {
		return this.specifiedConverter;
	}
	
	protected String getSpecifedConverterType() {
		if (this.specifiedConverter == null) {
			return Converter.NO_CONVERTER;
		}
		return this.specifiedConverter.getType();
	}
	
	public void setSpecifiedConverter(String converterType) {
		if (getSpecifedConverterType() == converterType) {
			return;
		}
		OrmConverter oldConverter = this.specifiedConverter;
		OrmConverter newConverter = buildSpecifiedConverter(converterType);
		this.specifiedConverter = null;
		if (oldConverter != null) {
			oldConverter.removeFromResourceModel();
		}
		this.specifiedConverter = newConverter;
		if (newConverter != null) {
			newConverter.addToResourceModel();
		}
		firePropertyChanged(SPECIFIED_CONVERTER_PROPERTY, oldConverter, newConverter);
	}
	
	protected void setSpecifiedConverter(OrmConverter newConverter) {
		OrmConverter oldConverter = this.specifiedConverter;
		this.specifiedConverter = newConverter;
		firePropertyChanged(SPECIFIED_CONVERTER_PROPERTY, oldConverter, newConverter);
	}	

	public String getKey() {
		return MappingKeys.BASIC_ATTRIBUTE_MAPPING_KEY;
	}

	public void initializeOn(OrmAttributeMapping newMapping) {
		newMapping.initializeFromOrmBasicMapping(this);
	}


	@Override
	public void initializeFromOrmColumnMapping(OrmColumnMapping oldMapping) {
		super.initializeFromOrmColumnMapping(oldMapping);
		getColumn().initializeFrom(oldMapping.getColumn());
	}

	public int getXmlSequence() {
		return 20;
	}

	@Override
	public boolean isOverridableAttributeMapping() {
		return true;
	}

	public OrmColumn getColumn() {
		return this.column;
	}

	public String getDefaultColumnName() {		
		return getAttributeName();
	}

	public String getDefaultTableName() {
		return getTypeMapping().getPrimaryTableName();
	}

	public Table getDbTable(String tableName) {
		return getTypeMapping().getDbTable(tableName);
	}
	
	@Override
	public void initialize(XmlAttributeMapping attributeMapping) {
		super.initialize(attributeMapping);
		this.specifiedFetch = this.specifiedFetch();
		this.specifiedOptional = this.specifiedOptional();
		this.column.initialize(this.resourceAttributeMapping.getColumn());
		this.defaultConverter = new GenericOrmNullConverter(this);
		this.specifiedConverter = this.buildSpecifiedConverter(this.specifiedConverterType());
	}
	
	@Override
	public void update() {
		super.update();
		this.setSpecifiedFetch_(this.specifiedFetch());
		this.setSpecifiedOptional_(this.specifiedOptional());
		this.column.update(this.resourceAttributeMapping.getColumn());
		if (specifiedConverterType() == getSpecifedConverterType()) {
			getSpecifiedConverter().update();
		}
		else {
			setSpecifiedConverter(buildSpecifiedConverter(specifiedConverterType()));
		}
	}
	
	protected Boolean specifiedOptional() {
		return this.resourceAttributeMapping.getOptional();
	}
	
	protected FetchType specifiedFetch() {
		return FetchType.fromOrmResourceModel(this.resourceAttributeMapping.getFetch());
	}
	
	protected OrmConverter buildSpecifiedConverter(String converterType) {
		if (converterType == Converter.ENUMERATED_CONVERTER) {
			return new GenericOrmEnumeratedConverter(this, this.resourceAttributeMapping);
		}
		else if (converterType == Converter.TEMPORAL_CONVERTER) {
			return new GenericOrmTemporalConverter(this, this.resourceAttributeMapping);
		}
		else if (converterType == Converter.LOB_CONVERTER) {
			return new GenericOrmLobConverter(this, this.resourceAttributeMapping);
		}
		return null;
	}
	
	protected String specifiedConverterType() {
		if (this.resourceAttributeMapping.getEnumerated() != null) {
			return Converter.ENUMERATED_CONVERTER;
		}
		else if (this.resourceAttributeMapping.getTemporal() != null) {
			return Converter.TEMPORAL_CONVERTER;
		}
		else if (this.resourceAttributeMapping.isLob()) {
			return Converter.LOB_CONVERTER;
		}
		
		return null;
	}
	
	public XmlBasic addToResourceModel(AbstractXmlTypeMapping typeMapping) {
		XmlBasic basic = OrmFactory.eINSTANCE.createXmlBasicImpl();
		getPersistentAttribute().initialize(basic);
		typeMapping.getAttributes().getBasics().add(basic);
		return basic;
	}
	
	public void removeFromResourceModel(AbstractXmlTypeMapping typeMapping) {
		typeMapping.getAttributes().getBasics().remove(this.resourceAttributeMapping);
	}
	
	//***************** XmlColumn.Owner implementation ****************
	
	public XmlColumn getResourceColumn() {
		return this.resourceAttributeMapping.getColumn();
	}
	
	public void addResourceColumn() {
		this.resourceAttributeMapping.setColumn(OrmFactory.eINSTANCE.createXmlColumnImpl());
	}
	
	public void removeResourceColumn() {
		this.resourceAttributeMapping.setColumn(null);
	}
	
	// ****************** validation ****************
	
	@Override
	public void validate(List<IMessage> messages) {
		super.validate(messages);
		if (this.connectionProfileIsActive() && this.ownerIsEntity()) {
			this.validateColumn(messages);
		}
	}
	
	protected void validateColumn(List<IMessage> messages) {
		String tableName = this.column.getTable();
		if (this.getTypeMapping().tableNameIsInvalid(tableName)) {
			if (this.getPersistentAttribute().isVirtual()) {
				messages.add(
					DefaultJpaValidationMessages.buildMessage(
						IMessage.HIGH_SEVERITY,
						JpaValidationMessages.VIRTUAL_ATTRIBUTE_COLUMN_UNRESOLVED_TABLE,
						new String[] {this.getName(), tableName, this.column.getName()},
						this.column, 
						this.column.getTableTextRange()
					)
				);
			} else {
				messages.add(
					DefaultJpaValidationMessages.buildMessage(
						IMessage.HIGH_SEVERITY,
						JpaValidationMessages.COLUMN_UNRESOLVED_TABLE,
						new String[] {tableName, this.column.getName()}, 
						this.column, 
						this.column.getTableTextRange()
					)
				);
			}
			return;
		}
		
		if ( ! this.column.isResolved()) {
			if (this.getPersistentAttribute().isVirtual()) {
				messages.add(
					DefaultJpaValidationMessages.buildMessage(
						IMessage.HIGH_SEVERITY,
						JpaValidationMessages.VIRTUAL_ATTRIBUTE_COLUMN_UNRESOLVED_NAME,
						new String[] {this.getName(), this.column.getName()}, 
						this.column, 
						this.column.getNameTextRange()
					)
				);
			} else {
				messages.add(
					DefaultJpaValidationMessages.buildMessage(
						IMessage.HIGH_SEVERITY,
						JpaValidationMessages.COLUMN_UNRESOLVED_NAME,
						new String[] {this.column.getName()}, 
						this.column, 
						this.column.getNameTextRange()
					)
				);
			}
		}
	}

}
