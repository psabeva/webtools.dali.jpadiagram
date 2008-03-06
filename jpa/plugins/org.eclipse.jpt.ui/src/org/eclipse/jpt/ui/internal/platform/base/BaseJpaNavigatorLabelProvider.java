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
package org.eclipse.jpt.ui.internal.platform.base;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jpt.core.context.JpaRootContextNode;
import org.eclipse.jpt.core.internal.context.persistence.GenericPersistenceXml;
import org.eclipse.jpt.ui.JptUiPlugin;
import org.eclipse.jpt.ui.internal.JptUiIcons;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

public class BaseJpaNavigatorLabelProvider extends LabelProvider 
	implements ICommonLabelProvider
{
	
	// **************** IBaseLabelProvider implementation **********************
	
	public void addListener(ILabelProviderListener listener) {
		super.addListener(listener);
	}
	
	public void removeListener(ILabelProviderListener listener) {
		super.addListener(listener);
	}
	
	public boolean isLabelProperty(Object element, String property) {
		return super.isLabelProperty(element, property);
	}
	
	public void dispose() {
		super.dispose();
	}
	
	
	// **************** ILabelProvider implementation **************************
	
	public Image getImage(Object element) {
		if (element instanceof JpaRootContextNode) {
			return JptUiPlugin.getImage(JptUiIcons.JPA_CONTENT);
		}
		
		if (element instanceof GenericPersistenceXml) {
			return JptUiPlugin.getImage(JptUiIcons.JPA_FILE);
		}
		
		return super.getImage(element);
	}
	
	public String getText(Object element) {		
		if (element instanceof JpaRootContextNode) {
			return "JPA Content";
		}
		
		if (element instanceof GenericPersistenceXml) {
			return "persistence.xml";
		}
		
		return null;
	}
	
	
	// **************** IDescriptionProvider implementation ********************
	
	public String getDescription(Object anElement) {
		// TODO Auto-generated method stub
		return getText(anElement);
	}
	
	
	// **************** IMementoAware implementation ***************************
	
	public void saveState(IMemento memento) {
	// TODO Auto-generated method stub
	}
	
	public void restoreState(IMemento memento) {
	// TODO Auto-generated method stub
	}
	
	
	// **************** ICommonLabelProvider implementation ********************
	
	public void init(ICommonContentExtensionSite config) {
	// TODO Auto-generated method stub
	}
}
