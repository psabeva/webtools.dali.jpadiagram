/*******************************************************************************
 * Copyright (c) 2011, 2012 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.common.utility.internal.iterator;

/**
 * A <code>NullElementIterator</code> provides a {@link java.util.ListIterator}
 * that returns a <code>null</code> a specific number of times.
 * 
 * @param <E> the type of elements returned by the iterator
 * 
 * @see org.eclipse.jpt.common.utility.internal.collection.NullElementList
 */
public class NullElementListIterator<E>
	extends AbstractRepeatingElementListIterator<E>
{
	/**
	 * Construct a list iterator for the specified number of <code>null</code>s.
	 */
	public NullElementListIterator(int size) {
		super(size);
	}

	@Override
	protected E getElement() {
		return null;
	}
}
