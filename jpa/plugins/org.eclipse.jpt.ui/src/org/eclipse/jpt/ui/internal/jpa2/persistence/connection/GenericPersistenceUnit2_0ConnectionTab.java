/*******************************************************************************
 * Copyright (c) 2009, 2010 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.ui.internal.jpa2.persistence.connection;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jpt.common.ui.WidgetFactory;
import org.eclipse.jpt.common.ui.internal.widgets.Pane;
import org.eclipse.jpt.core.jpa2.context.persistence.connection.JpaConnection2_0;
import org.eclipse.jpt.ui.details.JpaPageComposite;
import org.eclipse.jpt.ui.internal.JpaHelpContextIds;
import org.eclipse.jpt.ui.internal.jpa2.persistence.JptUiPersistence2_0Messages;
import org.eclipse.jpt.utility.model.value.PropertyValueModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 *  GenericPersistenceUnit2_0ConnectionTab
 */
public class GenericPersistenceUnit2_0ConnectionTab extends Pane<JpaConnection2_0>
	implements JpaPageComposite
{
	// ********** constructors/initialization **********
	/**
	 * Creates a new <code>GenericPersistenceUnit2_0ConnectionTab</code>.
	 *
	 * @param subjectHolder The holder of this pane's subject
	 * @param parent The parent container
	 * @param widgetFactory The factory used to create various common widgets
	 */
	public GenericPersistenceUnit2_0ConnectionTab(
											PropertyValueModel<JpaConnection2_0> subjectHolder,
	                                        Composite parent,
	                                        WidgetFactory widgetFactory) {

		super(subjectHolder, parent, widgetFactory);
	}

	@Override
	protected void initializeLayout(Composite container) {
		new GenericPersistenceUnit2_0ConnectionComposite(this, container);
	}

	// ********** Layout **********
	@Override
	protected Composite addContainer(Composite parent) {
		GridLayout layout = new GridLayout(1, true);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.marginTop = 0;
		layout.marginLeft = 0;
		layout.marginBottom = 0;
		layout.marginRight = 0;
		layout.verticalSpacing = 15;
		Composite container = this.addPane(parent, layout);
		updateGridData(container);
		return container;
	}

	private void updateGridData(Composite container) {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.FILL;
		container.setLayoutData(gridData);
	}

	// ********** JpaPageComposite implementation **********

	public String getHelpID() {
		return JpaHelpContextIds.PERSISTENCE_XML_CONNECTION;	// TODO - Review for JPA 2.0
	}
	
	public ImageDescriptor getPageImageDescriptor() {
		return null;
	}

	public String getPageText() {
		return JptUiPersistence2_0Messages.GenericPersistenceUnit2_0ConnectionTab_title;
	}
}
