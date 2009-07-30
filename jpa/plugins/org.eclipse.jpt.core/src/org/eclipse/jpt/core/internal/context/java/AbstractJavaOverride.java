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

import java.util.Iterator;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jpt.core.context.BaseOverride;
import org.eclipse.jpt.core.context.java.JavaJpaContextNode;
import org.eclipse.jpt.core.resource.java.OverrideAnnotation;
import org.eclipse.jpt.core.utility.TextRange;
import org.eclipse.jpt.utility.Filter;
import org.eclipse.jpt.utility.internal.StringTools;
import org.eclipse.jpt.utility.internal.iterators.FilteringIterator;


public abstract class AbstractJavaOverride extends AbstractJavaJpaContextNode implements BaseOverride
{

	protected String name;

	protected final Owner owner;

	protected OverrideAnnotation overrideAnnotation;
	
	public AbstractJavaOverride(JavaJpaContextNode parent, Owner owner) {
		super(parent);
		this.owner = owner;
	}
	
	protected void initialize(OverrideAnnotation overrideAnnotation) {
		this.overrideAnnotation = overrideAnnotation;
		this.name = this.getResourceName(overrideAnnotation);
	}

	protected OverrideAnnotation getOverrideAnnotation() {
		return this.overrideAnnotation;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		String oldName = this.name;
		this.name = newName;
		this.overrideAnnotation.setName(newName);
		firePropertyChanged(NAME_PROPERTY, oldName, newName);
	}
	
	protected void setName_(String newName) {
		String oldName = this.name;
		this.name = newName;
		firePropertyChanged(NAME_PROPERTY, oldName, newName);
	}

	protected void update(OverrideAnnotation overrideResource) {
		this.overrideAnnotation = overrideResource;
		this.setName_(this.getResourceName(overrideResource));
	}

	protected String getResourceName(OverrideAnnotation overrideAnnotation) {
		return overrideAnnotation.getName();
	}

	public boolean isVirtual() {
		return getOwner().isVirtual(this);
	}

	public BaseOverride setVirtual(boolean virtual) {
		return getOwner().setVirtual(virtual, this);
	}
	
	public Owner getOwner() {
		return this.owner;
	}
	
	@Override
	public JavaJpaContextNode getParent() {
		return (JavaJpaContextNode) super.getParent();
	}

	protected abstract Iterator<String> candidateNames();

	private Iterator<String> candidateNames(Filter<String> filter) {
		return new FilteringIterator<String, String>(this.candidateNames(), filter);
	}

	private Iterator<String> javaCandidateNames(Filter<String> filter) {
		return StringTools.convertToJavaStringLiterals(this.candidateNames(filter));
	}

	@Override
	public Iterator<String> javaCompletionProposals(int pos, Filter<String> filter, CompilationUnit astRoot) {
		Iterator<String> result = super.javaCompletionProposals(pos, filter, astRoot);
		if (result != null) {
			return result;
		}
		if (this.nameTouches(pos, astRoot)) {
			return this.javaCandidateNames(filter);
		}
		return null;
	}
	
	public boolean nameTouches(int pos, CompilationUnit astRoot) {
		return this.overrideAnnotation.nameTouches(pos, astRoot);
	}
	
	public TextRange getValidationTextRange(CompilationUnit astRoot) {
		TextRange textRange = this.overrideAnnotation.getTextRange(astRoot);
		return (textRange != null) ? textRange : this.getParent().getValidationTextRange(astRoot);
	}
	
	@Override
	public void toString(StringBuilder sb) {
		super.toString(sb);
		sb.append(getName());
	}

}