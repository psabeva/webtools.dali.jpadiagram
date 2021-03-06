/*******************************************************************************
 * Copyright (c) 2008, 2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.common.ui.internal.jface;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jpt.common.ui.jface.ItemExtendedLabelProvider;
import org.eclipse.jpt.common.ui.jface.ItemTreeContentProvider;
import org.eclipse.jpt.common.ui.jface.TreeStateProvider;
import org.eclipse.jpt.common.utility.internal.ObjectTools;
import org.eclipse.jpt.common.utility.internal.RunnableAdapter;

/**
 * @see AbstractItemStructuredStateProviderManager
 * @see ItemTreeContentProvider
 */
public class ItemTreeStateProviderManager
	extends AbstractItemStructuredStateProviderManager<TreeViewer, ItemTreeContentProvider>
	implements TreeStateProvider, ItemTreeContentProvider.Manager
{
	/**
	 * Never <code>null</code>.
	 */
	protected final ItemTreeContentProvider.Factory itemContentProviderFactory;


	public ItemTreeStateProviderManager(ItemTreeContentProvider.Factory itemContentProviderFactory, ResourceManager resourceManager) {
		this(itemContentProviderFactory, null, resourceManager);
	}

	public ItemTreeStateProviderManager(ItemTreeContentProvider.Factory itemContentProviderFactory, ItemExtendedLabelProvider.Factory itemLabelProviderFactory, ResourceManager resourceManager) {
		super(itemLabelProviderFactory, resourceManager);
		if (itemContentProviderFactory == null) {
			throw new NullPointerException();
		}
		this.itemContentProviderFactory = itemContentProviderFactory;
	}


	// ********** tree content provider **********

	public boolean hasChildren(Object element) {
		ItemTreeContentProvider provider = this.getItemContentProvider(element);
		return (provider != null) && provider.hasChildren();
	}

	public Object[] getChildren(Object parentElement) {
		ItemTreeContentProvider provider = this.getItemContentProvider(parentElement);
		return (provider == null) ? ObjectTools.EMPTY_OBJECT_ARRAY : provider.getChildren();
	}

	public Object getParent(Object element) {
		ItemTreeContentProvider provider = this.getItemContentProvider(element);
		return (provider == null) ? null : provider.getParent();
	}

	@Override
	protected ItemTreeContentProvider buildItemContentProvider(Object item) {
		return this.itemContentProviderFactory.buildProvider(item, this);
	}


	// ********** update children **********

	/**
	 * Dispatch to the UI thread.
	 */
	public void updateChildren(Object inputElement) {
		this.execute(new UpdateChildrenRunnable(inputElement));
	}

	/* CU private */ class UpdateChildrenRunnable
		extends RunnableAdapter
	{
		private final Object element;
		UpdateChildrenRunnable(Object element) {
			super();
			this.element = element;
		}
		@Override
		public void run() {
			ItemTreeStateProviderManager.this.updateChildren_(this.element);
		}
	}

	/**
	 * Update the specified item's children.
	 */
	/* CU private */ void updateChildren_(Object element) {
		if (this.viewerIsAlive()) {
			this.viewer.refresh(element, false);
		}
	}
}
