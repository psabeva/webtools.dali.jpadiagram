/*******************************************************************************
 * Copyright (c) 2007 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.utility.tests.internal.model.value;

import java.util.Collection;
import java.util.Iterator;

import javax.swing.JList;

import org.eclipse.jpt.utility.internal.CollectionTools;
import org.eclipse.jpt.utility.internal.HashBag;
import org.eclipse.jpt.utility.internal.iterators.SingleElementIterator;
import org.eclipse.jpt.utility.internal.model.AbstractModel;
import org.eclipse.jpt.utility.internal.model.event.CollectionChangeEvent;
import org.eclipse.jpt.utility.internal.model.listener.CollectionChangeListener;
import org.eclipse.jpt.utility.internal.model.value.CollectionValueModel;
import org.eclipse.jpt.utility.internal.model.value.PropertyCollectionValueModelAdapter;
import org.eclipse.jpt.utility.internal.model.value.PropertyValueModel;
import org.eclipse.jpt.utility.internal.model.value.SimplePropertyValueModel;
import org.eclipse.jpt.utility.internal.model.value.ValueModel;
import org.eclipse.jpt.utility.internal.model.value.swing.ListModelAdapter;
import org.eclipse.jpt.utility.tests.internal.TestTools;

import junit.framework.TestCase;

public class PropertyCollectionValueModelAdapterTests extends TestCase {
	private CollectionValueModel adapter;
	private PropertyValueModel wrappedValueHolder;

	public PropertyCollectionValueModelAdapterTests(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.wrappedValueHolder = new SimplePropertyValueModel();
		this.adapter = new PropertyCollectionValueModelAdapter(this.wrappedValueHolder);
	}

	private Collection wrappedCollection() {
		return CollectionTools.collection(new SingleElementIterator(this.wrappedValueHolder.getValue()));
	}

	@Override
	protected void tearDown() throws Exception {
		TestTools.clear(this);
		super.tearDown();
	}

	public void testGetValue() {
		this.adapter.addCollectionChangeListener(ValueModel.VALUE, new TestListener() {
			public void itemsAdded(CollectionChangeEvent e) {/* OK */}
		});
		this.wrappedValueHolder.setValue("foo");
		Collection adapterCollection = CollectionTools.collection((Iterator) this.adapter.getValue());
		assertEquals(1, adapterCollection.size());
		assertEquals(this.wrappedCollection(), adapterCollection);
		assertEquals("foo", adapterCollection.iterator().next());
	}

	public void testStaleValue() {
		CollectionChangeListener listener = new TestListener() {
			public void itemsAdded(CollectionChangeEvent e) {/* OK */}
		};
		this.adapter.addCollectionChangeListener(ValueModel.VALUE, listener);
		this.wrappedValueHolder.setValue("foo");
		Collection adapterCollection = CollectionTools.collection((Iterator) this.adapter.getValue());
		assertEquals(1, adapterCollection.size());
		assertEquals(this.wrappedCollection(), adapterCollection);
		assertEquals("foo", adapterCollection.iterator().next());

		this.adapter.removeCollectionChangeListener(ValueModel.VALUE, listener);
		adapterCollection = CollectionTools.collection((Iterator) this.adapter.getValue());
		assertEquals(0, adapterCollection.size());
		assertEquals(new HashBag(), adapterCollection);

		this.adapter.addCollectionChangeListener(ValueModel.VALUE, listener);
		adapterCollection = CollectionTools.collection((Iterator) this.adapter.getValue());
		assertEquals(1, adapterCollection.size());
		assertEquals(this.wrappedCollection(), adapterCollection);
		assertEquals("foo", adapterCollection.iterator().next());
	}

	public void testHasListeners() {
		assertFalse(((AbstractModel) this.adapter).hasAnyCollectionChangeListeners(ValueModel.VALUE));
		SynchronizedBag synchCollection = new SynchronizedBag(this.adapter);
		assertTrue(((AbstractModel) this.adapter).hasAnyCollectionChangeListeners(ValueModel.VALUE));
		this.adapter.removeCollectionChangeListener(ValueModel.VALUE, synchCollection);
		assertFalse(((AbstractModel) this.adapter).hasAnyCollectionChangeListeners(ValueModel.VALUE));
		this.adapter.addCollectionChangeListener(synchCollection);
		assertTrue(((AbstractModel) this.adapter).hasAnyCollectionChangeListeners(ValueModel.VALUE));
		this.adapter.removeCollectionChangeListener(synchCollection);
		assertFalse(((AbstractModel) this.adapter).hasAnyCollectionChangeListeners(ValueModel.VALUE));
	}

	public void testListChangedToEmpty() {
		this.adapter.addCollectionChangeListener(ValueModel.VALUE, new TestListener() {
			public void itemsAdded(CollectionChangeEvent e) {/* OK */}
			public void itemsRemoved(CollectionChangeEvent e) {/* OK */}
		});
		this.wrappedValueHolder.setValue("foo");
		JList jList = new JList(new ListModelAdapter(this.adapter));
		this.wrappedValueHolder.setValue(null);
		assertEquals(0, jList.getModel().getSize());
	}

	public void testCollectionChangedFromEmpty() {
		this.adapter.addCollectionChangeListener(ValueModel.VALUE, new TestListener() {
			public void itemsAdded(CollectionChangeEvent e) {/* OK */}
		});
		JList jList = new JList(new ListModelAdapter(this.adapter));
		
		this.wrappedValueHolder.setValue("foo");
		assertEquals(1, jList.getModel().getSize());
	}
	
	public void testCollectionChangedFromEmptyToEmpty() {
		this.adapter.addCollectionChangeListener(ValueModel.VALUE, new TestListener());
		JList jList = new JList(new ListModelAdapter(this.adapter));
		
		this.wrappedValueHolder.setValue(null);
		assertEquals(0, jList.getModel().getSize());
	}


	// ********** member class **********
	
	private static class TestListener implements CollectionChangeListener {
		TestListener() {
			super();
		}
		public void collectionChanged(CollectionChangeEvent e) {
			fail("unexpected event");
		}
		public void collectionCleared(CollectionChangeEvent e) {
			fail("unexpected event");
		}
		public void itemsAdded(CollectionChangeEvent e) {
			fail("unexpected event");
		}
		public void itemsRemoved(CollectionChangeEvent e) {
			fail("unexpected event");
		}
	}

}
