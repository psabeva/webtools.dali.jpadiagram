/*******************************************************************************
 * Copyright (c) 2006, 2007 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.core.internal.jdtutility;

/**
 * Adapt an indexed Java annotation with a simple-to-use interface.
 */
public interface IndexedAnnotationAdapter extends AnnotationAdapter {

	/**
	 * Return the the index at which the annotation is situated.
	 */
	int index();

	/**
	 * Move the annotation to the specified index, leaving its original
	 * position cleared out.
	 */
	void moveAnnotation(int newIndex);

}
