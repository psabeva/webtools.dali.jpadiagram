/*******************************************************************************
 *  Copyright (c) 2007 Oracle. 
 *  All rights reserved.  This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *  	Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.core.internal.context.persistence;

import java.util.List;
import org.eclipse.core.resources.IResource;
import org.eclipse.jpt.core.JpaStructureNode;
import org.eclipse.jpt.core.context.JpaRootContextNode;
import org.eclipse.jpt.core.context.persistence.Persistence;
import org.eclipse.jpt.core.context.persistence.PersistenceUnit;
import org.eclipse.jpt.core.context.persistence.PersistenceXml;
import org.eclipse.jpt.core.internal.validation.DefaultJpaValidationMessages;
import org.eclipse.jpt.core.internal.validation.JpaValidationMessages;
import org.eclipse.jpt.core.resource.persistence.PersistenceFactory;
import org.eclipse.jpt.core.resource.persistence.PersistenceResource;
import org.eclipse.jpt.core.resource.persistence.XmlPersistence;
import org.eclipse.jpt.core.utility.TextRange;
import org.eclipse.wst.validation.internal.provisional.core.IMessage;

public class GenericPersistenceXml extends AbstractPersistenceJpaContextNode
	implements PersistenceXml
{
	protected PersistenceResource persistenceResource;
	
	protected Persistence persistence;
	
	
	public GenericPersistenceXml(JpaRootContextNode parent, PersistenceResource persistenceResource) {
		super(parent);
		this.initialize(persistenceResource);
	}
	
	public String getId() {
		// isn't actually displayed, so needs no details page
		return null;
	}
	
	@Override
	public JpaRootContextNode getParent() {
		return (JpaRootContextNode) super.getParent();
	}
	
	@Override
	public IResource getResource() {
		return persistenceResource.getFile();
	}
	
	// **************** persistence ********************************************
	
	public Persistence getPersistence() {
		return persistence;
	}
	
	public Persistence addPersistence() {
		if (persistence != null) {
			throw new IllegalStateException();
		}
		
		XmlPersistence xmlPersistence = PersistenceFactory.eINSTANCE.createXmlPersistence();
		persistence = buildPersistence(xmlPersistence);
		persistenceResource.getContents().add(xmlPersistence);
		firePropertyChanged(PERSISTENCE_PROPERTY, null, persistence);
		return persistence;
	}
	
	public void removePersistence() {
		if (persistence == null) {
			throw new IllegalStateException();
		}
		
		Persistence oldPersistence = persistence;
		persistence = null;
		XmlPersistence xmlPersistence = persistenceResource.getPersistence();
		persistenceResource.getContents().remove(xmlPersistence);
		firePropertyChanged(PERSISTENCE_PROPERTY, oldPersistence, null);
	}
	
	protected void setPersistence_(Persistence newPersistence) {
		Persistence oldPersistence = persistence;
		persistence = newPersistence;
		firePropertyChanged(PERSISTENCE_PROPERTY, oldPersistence, newPersistence);
	}
	
	
	// **************** updating ***********************************************
	
	protected void initialize(PersistenceResource persistenceResource) {
		this.persistenceResource = persistenceResource;
		if (persistenceResource.getPersistence() != null) {
			this.persistence = buildPersistence(persistenceResource.getPersistence());
		}
	}

	public void update(PersistenceResource persistenceResource) {
		if (! persistenceResource.equals(this.persistenceResource)) {
			this.persistenceResource = persistenceResource;
			this.persistenceResource.resourceModel().removeRootStructureNode(this);
		}
		if (persistenceResource.getPersistence() != null) {
			if (this.persistence != null) {
				this.persistence.update(persistenceResource.getPersistence());
			}
			else {
				setPersistence_(buildPersistence(persistenceResource.getPersistence()));
			}
			persistenceResource.resourceModel().addRootStructureNode(getPersistence());
		}
		else {
			setPersistence_(null);
		}
	}
	
	protected Persistence buildPersistence(XmlPersistence xmlPersistence) {
		return getJpaFactory().buildPersistence(this, xmlPersistence);
	}
	
	
	// *************************************************************************
	
	@Override
	public PersistenceUnit getPersistenceUnit() {
		throw new UnsupportedOperationException("No PersistenceUnit in this context");
	}
	
	
	public JpaStructureNode structureNode(int textOffset) {
		if (persistence.containsOffset(textOffset)) {
			return persistence.structureNode(textOffset);
		}
		return this;
	}
	
	// never actually selected
	public TextRange getSelectionTextRange() {
		return TextRange.Empty.instance();
	}
	
	public TextRange getValidationTextRange() {
		return TextRange.Empty.instance();
	}
	
	
	// **************** validation *********************************************
	
	private boolean okToContinueValidation = true;

	@Override
	public void addToMessages(List<IMessage> messages) {
		super.addToMessages(messages);
		addInvalidPersistenceXmlContentMessage(messages);
		
		if (okToContinueValidation){
			getPersistence().addToMessages(messages);
		}
	}
	
	protected void addInvalidPersistenceXmlContentMessage(List<IMessage> messages) {
		if (this.persistence == null) {
			messages.add(
					DefaultJpaValidationMessages.buildMessage(
						IMessage.HIGH_SEVERITY,
						JpaValidationMessages.PERSISTENCE_XML_INVALID_CONTENT,
						this)
				);
			okToContinueValidation = false;
		}
	}

}
