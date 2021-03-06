/*******************************************************************************
 * Copyright (c) 2009, 2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.common.utility.collection;

/**
 * Interface defining the classic queue behavior,
 * without the backdoors allowed by {@link java.util.Queue}.
 * <p>
 * Provisional API: This interface is part of an interim API that is still
 * under development and expected to change significantly before reaching
 * stability. It is available at this early stage to solicit feedback from
 * pioneering adopters on the understanding that any code that uses this API
 * will almost certainly be broken (repeatedly) as the API evolves.
 * 
 * @param <E> the type of elements contained by the queue
 * @see org.eclipse.jpt.common.utility.internal.collection.ArrayQueue
 * @see org.eclipse.jpt.common.utility.internal.collection.LinkedQueue
 */
public interface Queue<E> {

	/**
	 * "Enqueue" the specified item to the tail of the queue.
	 */
	void enqueue(E element);

	/**
	 * "Dequeue" an item from the head of the queue.
	 */
	E dequeue();

	/**
	 * Return the item on the head of the queue
	 * without removing it from the queue.
	 */
	E peek();

	/**
	 * Return whether the queue is empty.
	 */
	boolean isEmpty();
}
