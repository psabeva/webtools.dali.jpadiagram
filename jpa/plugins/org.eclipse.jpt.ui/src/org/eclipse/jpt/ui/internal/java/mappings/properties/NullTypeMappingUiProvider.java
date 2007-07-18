/*******************************************************************************
 * Copyright (c) 2006, 2007 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.ui.internal.java.mappings.properties;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jpt.ui.internal.details.IJpaComposite;
import org.eclipse.jpt.ui.internal.java.details.ITypeMappingUiProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class NullTypeMappingUiProvider implements ITypeMappingUiProvider
{
	// singleton
	private static final NullTypeMappingUiProvider INSTANCE = new NullTypeMappingUiProvider();

	/**
	 * Return the singleton.
	 */
	public static ITypeMappingUiProvider instance() {
		return INSTANCE;
	}

	/**
	 * Ensure non-instantiability.
	 */
	private NullTypeMappingUiProvider() {
		super();
	}
	
	public String mappingKey() {
		return null;
	}
	
	public String label() {
		return "";
	}
	
	public IJpaComposite buildPersistentTypeMappingComposite(
				Composite parent, CommandStack commandStack, TabbedPropertySheetWidgetFactory widgetFactory) {
		return new NullComposite(parent);
	}
	
	
	public static class NullComposite extends Composite 
	implements IJpaComposite 
	{
		private Composite composite;
		NullComposite(Composite parent) {
			super(parent, SWT.NONE);
			this.composite = new Composite(parent, SWT.NONE);
		}
		
		public void populate(EObject model) {
			// no op
		}
		
		@Override
		public void dispose() {
			super.dispose();
		}
		
		public Control getControl() {
			return this.composite;
		}
	}
}