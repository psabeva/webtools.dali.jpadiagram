/*******************************************************************************
 * Copyright (c) 2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jpa.ui.internal.jpa2_1.details.orm;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jpt.common.ui.WidgetFactory;
import org.eclipse.jpt.common.utility.model.value.PropertyValueModel;
import org.eclipse.jpt.jpa.core.jpa2.context.orm.OrmEntity2_0;
import org.eclipse.jpt.jpa.ui.internal.jpa2.details.orm.OrmEntity2_0Composite;
import org.eclipse.jpt.jpa.ui.internal.jpa2_1.details.Queries2_1Composite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class OrmEntity2_1Composite
	extends OrmEntity2_0Composite
{

	public OrmEntity2_1Composite(
			PropertyValueModel<? extends OrmEntity2_0> entityModel,
			Composite parentComposite, WidgetFactory widgetFactory,
			ResourceManager resourceManager) {
		super(entityModel, parentComposite, widgetFactory, resourceManager);
	}
	
	@Override
	protected Control initializeQueriesSection(Composite container) {
		return new Queries2_1Composite(this, this.buildQueryContainerModel(), container).getControl();
	}

}