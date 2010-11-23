/*******************************************************************************
 *  Copyright (c) 2007, 2010 Oracle. 
 *  All rights reserved.  This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *  	Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.jaxb.ui.internal.navigator;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * This extension of navigator label provider delegates to the platform UI
 * (see the org.eclipse.jpt.ui.jpaPlatform extension point) for navigator labels.
 * 
 * This label provider provides a label for the root "JPA Content" node provided
 * by the content provider (see {@link JaxbNavigatorContentProvider}) and delegates
 * to the label provider returned by the platform UI implementation for labels
 * for children of the "JPA Content" node (or for any other sub-node).
 */
public class JaxbNavigatorLabelProvider
		extends LabelProvider
		implements ICommonLabelProvider {
	
	private JaxbNavigatorContentAndLabelProvider delegate;
	
	
	public JaxbNavigatorLabelProvider() {
		super();
	}
	
	
	public JaxbNavigatorContentAndLabelProvider delegate() {
		return delegate;
	}
	
	
	// **************** IBaseLabelProvider implementation **********************
	
	@Override
	public void addListener(ILabelProviderListener listener) {
		if (delegate != null) {
			delegate.addListener(listener);
		}
		super.addListener(listener);
	}
	
	@Override
	public void removeListener(ILabelProviderListener listener) {
		super.removeListener(listener);
		if (delegate != null) {
			delegate.removeListener(listener);
		}
	}
	
	@Override
	public boolean isLabelProperty(Object element, String property) {
		if (delegate != null) {
			return delegate.isLabelProperty(element, property);
		}
		
		return super.isLabelProperty(element, property);
	}
	
	@Override
	public void dispose() {
		if (delegate != null) {
			delegate.dispose();
		}
		super.dispose();
	}
	
	
	// **************** ILabelProvider implementation **************************
	
	@Override
	public Image getImage(Object element) {
		if (delegate != null) {
			return delegate.getImage(element);
		}
		
		return super.getImage(element);
	}
	
	@Override
	public String getText(Object element) {
		if (delegate != null) {
			return delegate.getText(element);
		}
		
		return super.getText(element);
	}
	
	
	// **************** IDescriptionProvider implementation ********************
	
	public String getDescription(Object element) {
		if (delegate != null) {
			return delegate.getDescription(element);
		}
		
		return super.getText(element);
	}
	
	
	// **************** IMementoAware implementation ***************************
	
	public void saveState(IMemento memento) {
		// no op
	}
	
	public void restoreState(IMemento memento) {
		// no op
	}
	
	
	// **************** ICommonLabelProvider implementation ********************
	
	public void init(ICommonContentExtensionSite config) {
		if (delegate == null) {
			JaxbNavigatorContentProvider contentProvider = (JaxbNavigatorContentProvider) config.getExtension().getContentProvider();
			if (contentProvider != null && contentProvider.delegate() != null) {
				delegate = contentProvider.delegate();
			}
			else {
				delegate = new JaxbNavigatorContentAndLabelProvider();
			}
		}
	}
}
