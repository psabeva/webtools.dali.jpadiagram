/*******************************************************************************
 * Copyright (c) 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jaxb.core.internal.context.java;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jpt.common.core.resource.java.Annotation;
import org.eclipse.jpt.common.core.resource.java.JavaResourceAttribute;
import org.eclipse.jpt.common.core.utility.TextRange;
import org.eclipse.jpt.common.utility.internal.iterables.SingleElementIterable;
import org.eclipse.jpt.jaxb.core.context.JaxbAttributeMapping;
import org.eclipse.jpt.jaxb.core.context.JaxbClassMapping;
import org.eclipse.jpt.jaxb.core.context.JaxbPackage;
import org.eclipse.jpt.jaxb.core.context.JaxbPersistentAttribute;

public abstract class AbstractJavaAttributeMapping<A extends Annotation>
		extends AbstractJavaContextNode
		implements JaxbAttributeMapping {
	
	protected boolean default_;

	protected AbstractJavaAttributeMapping(JaxbPersistentAttribute parent) {
		super(parent);
		this.default_ = this.buildDefault();
	}
	
	
	public JaxbClassMapping getClassMapping() {
		return getPersistentAttribute().getClassMapping();
	}
	
	
	// ********** synchronize/update **********

	@Override
	public void synchronizeWithResourceModel() {
		super.synchronizeWithResourceModel();
		this.syncDefault();
	}


	// ********** annotation **********
	
	@SuppressWarnings("unchecked")
	public A getAnnotation() {
		return (A) getJavaResourceAttribute().getAnnotation(getAnnotationName());
	}
	
	protected abstract String getAnnotationName();
	
	/**
	 * This method should only be called when an annotation *must* be present (such as when setting fields on it).
	 * For most mappings, this is equivalent to #getAnnotation(), but for default mappings (such as @XmlElement)
	 * an annotation will be added if none currently exists.
	 */
	public A getOrCreateAnnotation() {
		A annotation = getAnnotation();
		if (annotation == null) {
			getPersistentAttribute().setMappingKey(getKey());
			annotation = getAnnotation();
			if (annotation == null) {
				throw new IllegalStateException("missing annotation: " + this); //$NON-NLS-1$
			}
		}
		return annotation;
	}
	
	
	// ********** default **********
	
	public boolean isDefault() {
		return this.default_;
	}

	protected void setDefault(boolean default_) {
		boolean old = this.default_;
		this.default_ = default_;
		this.firePropertyChanged(DEFAULT_PROPERTY, old, default_);
	}

	public void syncDefault() {
		this.setDefault(this.buildDefault());
	}

	protected boolean buildDefault() {
		return this.getAnnotation() == null;
	}


	// ********** validation **********
	
	@Override
	public TextRange getValidationTextRange(CompilationUnit astRoot) {
		return getAnnotation() == null ? getJavaResourceAttribute().getNameTextRange(astRoot) : getAnnotation().getTextRange(astRoot);
	}
	
	
	// ********** misc **********
	
	public JaxbPersistentAttribute getPersistentAttribute() {
		return (JaxbPersistentAttribute) super.getParent();
	}
	
	public JaxbClassMapping getJaxbClassMapping() {
		return getPersistentAttribute().getClassMapping();
	}
	
	public JaxbPackage getJaxbPackage() {
		return getJaxbClassMapping().getJaxbType().getJaxbPackage();
	}

	public JavaResourceAttribute getJavaResourceAttribute() {
		return this.getPersistentAttribute().getJavaResourceAttribute();
	}
	
	public String getBoundTypeName() {
		return getPersistentAttribute().getJavaResourceAttributeBaseTypeName();
	}
	
	public String getValueTypeName() {
		return getBoundTypeName();
	}
	
	public String getDataTypeName() {
		return getValueTypeName();
	}
	
	public Iterable<String> getReferencedXmlTypeNames() {
		return new SingleElementIterable(getValueTypeName());
	}
	
	/* default impl */
	public boolean isParticleMapping() {
		return false;
	}
	
	/* default impl */
	public boolean isTransient() {
		return false;
	}
}
