/*******************************************************************************
 * Copyright (c) 2008, 2010 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.ui.internal.platform.generic;

import java.util.ListIterator;
import org.eclipse.jpt.common.ui.internal.jface.AbstractTreeItemContentProvider;
import org.eclipse.jpt.common.ui.internal.jface.DelegatingTreeContentAndLabelProvider;
import org.eclipse.jpt.core.context.java.JavaPersistentAttribute;
import org.eclipse.jpt.core.context.java.JavaPersistentType;
import org.eclipse.jpt.utility.internal.model.value.ListAspectAdapter;
import org.eclipse.jpt.utility.internal.model.value.ListCollectionValueModelAdapter;
import org.eclipse.jpt.utility.model.value.CollectionValueModel;

public class JavaPersistentTypeItemContentProvider extends AbstractTreeItemContentProvider<JavaPersistentAttribute>
{
	public JavaPersistentTypeItemContentProvider(
			JavaPersistentType persistentType, DelegatingTreeContentAndLabelProvider contentProvider) {
		super(persistentType, contentProvider);
	}
	
	@Override
	public JavaPersistentType getModel() {
		return (JavaPersistentType) super.getModel();
	}
	
	@Override
	public Object getParent() {
		return getModel().getParent();
	}
	
	@Override
	protected CollectionValueModel<JavaPersistentAttribute> buildChildrenModel() {
		return new ListCollectionValueModelAdapter<JavaPersistentAttribute>(
		new ListAspectAdapter<JavaPersistentType, JavaPersistentAttribute>(JavaPersistentType.ATTRIBUTES_LIST, getModel()) {
			@Override
			protected ListIterator<JavaPersistentAttribute> listIterator_() {
				return subject.attributes();
			}
			
			@Override
			protected int size_() {
				return subject.attributesSize();
			}
		});
	}
}