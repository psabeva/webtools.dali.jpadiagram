/*******************************************************************************
 * Copyright (c) 2007, 2012 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.common.utility.collection;

import java.io.Serializable;
import java.util.EmptyStackException;

/**
 * Interface defining the classic stack behavior,
 * without the backdoors allowed by {@link java.util.Stack}.
 * <p>
 * Provisional API: This interface is part of an interim API that is still
 * under development and expected to change significantly before reaching
 * stability. It is available at this early stage to solicit feedback from
 * pioneering adopters on the understanding that any code that uses this API
 * will almost certainly be broken (repeatedly) as the API evolves.
 * 
 * @param <E> the type of elements contained by the stack
 * @see org.eclipse.jpt.common.utility.internal.collection.ArrayStack
 * @see org.eclipse.jpt.common.utility.internal.collection.LinkedStack
 */
public interface Stack<E> {

	/**
	 * "Push" the specified item on to the top of the stack.
	 */
	void push(E element);

	/**
	 * "Pop" an item from the top of the stack.
	 */
	E pop();

	/**
	 * Return the item on the top of the stack
	 * without removing it from the stack.
	 */
	E peek();

	/**
	 * Return whether the stack is empty.
	 */
	boolean isEmpty();


	final class Empty<E>
		implements Stack<E>, Serializable
	{
		@SuppressWarnings("rawtypes")
		public static final Stack INSTANCE = new Empty();
		@SuppressWarnings("unchecked")
		public static <T> Stack<T> instance() {
			return INSTANCE;
		}
		// ensure single instance
		private Empty() {
			super();
		}
		public void push(E element) {
			throw new UnsupportedOperationException();
		}
		public E pop() {
			throw new EmptyStackException();
		}
		public E peek() {
			throw new EmptyStackException();
		}
		public boolean isEmpty() {
			return true;
		}
		@Override
		public String toString() {
			return "[]"; //$NON-NLS-1$
		}
		private static final long serialVersionUID = 1L;
		private Object readResolve() {
			// replace this object with the singleton
			return INSTANCE;
		}
	}
}