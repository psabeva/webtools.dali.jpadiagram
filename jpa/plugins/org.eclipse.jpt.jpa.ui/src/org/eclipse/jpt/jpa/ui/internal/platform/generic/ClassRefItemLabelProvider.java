/*******************************************************************************
 * Copyright (c) 2008, 2012 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jpa.ui.internal.platform.generic;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jpt.common.ui.internal.jface.AbstractItemExtendedLabelProvider;
import org.eclipse.jpt.common.ui.jface.ItemExtendedLabelProvider;
import org.eclipse.jpt.common.utility.internal.model.value.PropertyAspectAdapter;
import org.eclipse.jpt.common.utility.model.value.PropertyValueModel;
import org.eclipse.jpt.jpa.core.context.persistence.ClassRef;
import org.eclipse.jpt.jpa.ui.JptJpaUiImages;

public class ClassRefItemLabelProvider
	extends AbstractItemExtendedLabelProvider<ClassRef>
{
	public ClassRefItemLabelProvider(ClassRef classRef, ItemExtendedLabelProvider.Manager manager) {
		super(classRef, manager);
	}

	@Override
	protected ImageDescriptor getImageDescriptor() {
		return JptJpaUiImages.CLASS_REF;
	}

	@Override
	protected PropertyValueModel<String> buildTextModel() {
		return new TextModel(this.item);
	}

	protected static class TextModel
		extends PropertyAspectAdapter<ClassRef, String>
	{
		public TextModel(ClassRef subject) {
			super(ClassRef.CLASS_NAME_PROPERTY, subject);
		}
		@Override
		protected String buildValue_() {
			return this.subject.getClassName();
		}
	}

	@Override
	protected PropertyValueModel<String> buildDescriptionModel() {
		return PersistenceUnitItemLabelProvider.buildQuotedComponentDescriptionModel(
					this.item,
					this.textModel
				);
	}
}
