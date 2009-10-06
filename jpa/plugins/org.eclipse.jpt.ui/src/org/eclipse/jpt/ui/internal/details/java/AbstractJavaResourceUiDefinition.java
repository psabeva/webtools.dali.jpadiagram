/*******************************************************************************
 * Copyright (c) 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.ui.internal.details.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.eclipse.jpt.core.JpaResourceType;
import org.eclipse.jpt.core.JptCorePlugin;
import org.eclipse.jpt.core.context.AttributeMapping;
import org.eclipse.jpt.core.context.TypeMapping;
import org.eclipse.jpt.ui.MappingResourceUiDefinition;
import org.eclipse.jpt.ui.ResourceUiDefinition;
import org.eclipse.jpt.ui.WidgetFactory;
import org.eclipse.jpt.ui.details.JpaComposite;
import org.eclipse.jpt.ui.details.MappingUiDefinition;
import org.eclipse.jpt.ui.details.java.DefaultJavaAttributeMappingUiDefinition;
import org.eclipse.jpt.ui.details.java.DefaultJavaTypeMappingUiDefinition;
import org.eclipse.jpt.ui.details.java.JavaAttributeMappingUiDefinition;
import org.eclipse.jpt.ui.details.java.JavaTypeMappingUiDefinition;
import org.eclipse.jpt.ui.details.java.JavaUiFactory;
import org.eclipse.jpt.ui.internal.structure.JavaResourceModelStructureProvider;
import org.eclipse.jpt.ui.structure.JpaStructureProvider;
import org.eclipse.jpt.utility.internal.Tools;
import org.eclipse.jpt.utility.internal.iterators.ArrayIterator;
import org.eclipse.jpt.utility.internal.iterators.ArrayListIterator;
import org.eclipse.jpt.utility.model.value.PropertyValueModel;
import org.eclipse.swt.widgets.Composite;

/**
 * All the state in the definition should be "static" (i.e. unchanging once it is initialized).
 */
public abstract class AbstractJavaResourceUiDefinition
	implements ResourceUiDefinition, MappingResourceUiDefinition
{
	private JavaTypeMappingUiDefinition<? extends TypeMapping>[] specifiedTypeMappingUiDefinitions;
	
	private JavaAttributeMappingUiDefinition<? extends AttributeMapping>[] specifiedAttributeMappingUiDefinitions;
	
	private DefaultJavaAttributeMappingUiDefinition<?>[] defaultAttributeMappingUiDefinitions;
	
	private final JavaUiFactory factory;
	
	
	/**
	 * zero-argument constructor
	 */
	protected AbstractJavaResourceUiDefinition() {
		super();
		this.factory = buildJavaUiFactory();
	}
	
	protected abstract JavaUiFactory buildJavaUiFactory();
	
	public JavaUiFactory getFactory() {
		return this.factory;
	}
	
	public boolean providesUi(JpaResourceType resourceType) {
		return resourceType.equals(JptCorePlugin.JAVA_SOURCE_RESOURCE_TYPE);
	}

	public JpaStructureProvider getStructureProvider() {
		return JavaResourceModelStructureProvider.instance();
	}
	
	
	
	// ********** type mapping ui definitions **********
	
	public JpaComposite buildTypeMappingComposite(String key, PropertyValueModel<TypeMapping> mappingHolder, Composite parent, WidgetFactory widgetFactory) {
		JavaTypeMappingUiDefinition<TypeMapping> mappingUiDefinition = 
			(JavaTypeMappingUiDefinition<TypeMapping>) getSpecifiedJavaTypeMappingUiDefinition(key);
		return mappingUiDefinition.buildTypeMappingComposite(
			getFactory(), 
			mappingHolder,
			parent,
			widgetFactory
		);
	}
	
	protected JavaTypeMappingUiDefinition<? extends TypeMapping> getSpecifiedJavaTypeMappingUiDefinition(String mappingKey) {
		for (JavaTypeMappingUiDefinition<? extends TypeMapping> definition : getSpecifiedTypeMappingUiDefintions()) {
			if (Tools.valuesAreEqual(definition.getKey(), mappingKey)) {
				return definition;
			}
		}
		throw new IllegalArgumentException("Illegal type mapping key: " + mappingKey); //$NON-NLS-1$
	}
	
	public Iterator<MappingUiDefinition<? extends TypeMapping>> typeMappingUiDefinitions() {
		return new ArrayIterator<MappingUiDefinition<? extends TypeMapping>>(getSpecifiedTypeMappingUiDefintions());
	}
	
	protected synchronized JavaTypeMappingUiDefinition<? extends TypeMapping>[] getSpecifiedTypeMappingUiDefintions() {
		if (this.specifiedTypeMappingUiDefinitions == null) {
			this.specifiedTypeMappingUiDefinitions = this.buildSpecifiedTypeMappingUiDefintions();
		}
		return this.specifiedTypeMappingUiDefinitions;
	}
	
	
	/**
	 * Return an array of mapping definitions to use for types in mapping files of this type.  
	 * The order is unimportant.
	 */
	protected JavaTypeMappingUiDefinition<? extends TypeMapping>[] buildSpecifiedTypeMappingUiDefintions() {
		ArrayList<JavaTypeMappingUiDefinition<? extends TypeMapping>> definitions = new ArrayList<JavaTypeMappingUiDefinition<? extends TypeMapping>>();
		this.addSpecifiedTypeMappingUiDefinitionsTo(definitions);
		@SuppressWarnings("unchecked")
		JavaTypeMappingUiDefinition<? extends TypeMapping>[] definitionArray = definitions.toArray(new JavaTypeMappingUiDefinition[definitions.size()]);
		return definitionArray;
	}


	protected abstract void addSpecifiedTypeMappingUiDefinitionsTo(List<JavaTypeMappingUiDefinition<? extends TypeMapping>> definitions);
	
	public DefaultJavaTypeMappingUiDefinition<? extends TypeMapping> getDefaultTypeMappingUiDefinition() {
		return NullJavaTypeMappingUiDefinition.instance();
	}
	
	// ********** attributes mapping UI definitions **********
	
	public JpaComposite buildAttributeMappingComposite(String key, PropertyValueModel<AttributeMapping> mappingHolder, Composite parent, WidgetFactory widgetFactory) {
		JavaAttributeMappingUiDefinition<AttributeMapping> mappingUiDefinition = getAttributeMappingUiDefinition(mappingHolder.getValue());
		return mappingUiDefinition.buildAttributeMappingComposite(
			getFactory(), 
			mappingHolder,
			parent,
			widgetFactory
		);
	}
	
	@SuppressWarnings("unchecked")
	protected JavaAttributeMappingUiDefinition<AttributeMapping> getAttributeMappingUiDefinition(AttributeMapping attributeMapping) {
		String key = attributeMapping == null ? null : attributeMapping.getKey();
		if (attributeMapping == null || attributeMapping.isDefault()) {
			return (JavaAttributeMappingUiDefinition<AttributeMapping>) getDefaultAttributeMappingUiDefinition(key);
		}
		return (JavaAttributeMappingUiDefinition<AttributeMapping>) getSpecifiedAttributeMappingUiDefinition(key);
	}
	
	protected JavaAttributeMappingUiDefinition<? extends AttributeMapping> getSpecifiedAttributeMappingUiDefinition(String mappingKey) {
		for (JavaAttributeMappingUiDefinition<? extends AttributeMapping> definition : getSpecifiedAttributeMappingUiDefinitions()) {
			if (Tools.valuesAreEqual(definition.getKey(), mappingKey)) {
				return definition;
			}
		}
		throw new IllegalArgumentException("Illegal attribute mapping key: " + mappingKey); //$NON-NLS-1$
	}
	
	public ListIterator<MappingUiDefinition<? extends AttributeMapping>> attributeMappingUiDefinitions() {
		return new ArrayListIterator<MappingUiDefinition<? extends AttributeMapping>>(getSpecifiedAttributeMappingUiDefinitions());
	}
	
	protected synchronized JavaAttributeMappingUiDefinition<? extends AttributeMapping>[] getSpecifiedAttributeMappingUiDefinitions() {
		if (this.specifiedAttributeMappingUiDefinitions == null) {
			this.specifiedAttributeMappingUiDefinitions = this.buildSpecifiedAttributeMappingUiDefinitions();
		}
		return this.specifiedAttributeMappingUiDefinitions;
	}
	
	/**
	 * Return an array of mapping definitions to use for attributes in mapping files of this type.  
	 * The order is unimportant.
	 */
	protected JavaAttributeMappingUiDefinition<? extends AttributeMapping>[] buildSpecifiedAttributeMappingUiDefinitions() {
		ArrayList<JavaAttributeMappingUiDefinition<? extends AttributeMapping>> definitions = new ArrayList<JavaAttributeMappingUiDefinition<? extends AttributeMapping>>();
		this.addSpecifiedAttributeMappingUiDefinitionsTo(definitions);
		@SuppressWarnings("unchecked")
		JavaAttributeMappingUiDefinition<? extends AttributeMapping>[] definitionArray = definitions.toArray(new JavaAttributeMappingUiDefinition[definitions.size()]);
		return definitionArray;
	}


	protected abstract void addSpecifiedAttributeMappingUiDefinitionsTo(List<JavaAttributeMappingUiDefinition<? extends AttributeMapping>> definitions);

	// ********** default Java attribute mapping UI providers **********
	
	public DefaultJavaAttributeMappingUiDefinition<? extends AttributeMapping> getDefaultAttributeMappingUiDefinition(String key) {
		for (DefaultJavaAttributeMappingUiDefinition<? extends AttributeMapping> definition : getDefaultAttributeMappingUiDefinitions()) {
			if (Tools.valuesAreEqual(definition.getDefaultKey(), key)) {
				return definition;
			}
		}
		throw new IllegalArgumentException("Illegal attribute mapping key: " + key); //$NON-NLS-1$
	}
		
	protected synchronized DefaultJavaAttributeMappingUiDefinition<? extends AttributeMapping>[] getDefaultAttributeMappingUiDefinitions() {
		if (this.defaultAttributeMappingUiDefinitions == null) {
			this.defaultAttributeMappingUiDefinitions = this.buildDefaultAttributeMappingUiDefinitions();
		}
		return this.defaultAttributeMappingUiDefinitions;
	}

	protected DefaultJavaAttributeMappingUiDefinition<?>[] buildDefaultAttributeMappingUiDefinitions() {
		ArrayList<DefaultJavaAttributeMappingUiDefinition<?>> definitions = new ArrayList<DefaultJavaAttributeMappingUiDefinition<?>>();
		this.addDefaultAttributeMappingUiDefinitionsTo(definitions);
		DefaultJavaAttributeMappingUiDefinition<?>[] definitionArray = definitions.toArray(new DefaultJavaAttributeMappingUiDefinition[definitions.size()]);
		return definitionArray;
	}


	protected abstract void addDefaultAttributeMappingUiDefinitionsTo(List<DefaultJavaAttributeMappingUiDefinition<?>> definitions);

}
