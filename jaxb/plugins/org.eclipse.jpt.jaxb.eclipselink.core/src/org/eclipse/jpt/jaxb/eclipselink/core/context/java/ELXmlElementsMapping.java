/*******************************************************************************
 *  Copyright (c) 2012  Oracle. All rights reserved.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License v1.0, which accompanies this distribution
 *  and is available at http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *  	Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.jaxb.eclipselink.core.context.java;

import org.eclipse.jpt.common.utility.internal.iterables.ListIterable;
import org.eclipse.jpt.jaxb.core.context.XmlElementsMapping;


public interface ELXmlElementsMapping
		extends XmlElementsMapping {
	
	// ***** xmlPaths *****
	
	/**
	 * String associated with changes to the xmlPaths list
	 */
	String XML_PATHS_LIST = "xmlPaths";  ///$NON-NLS-1$
	
	ListIterable<ELXmlPath> getXmlPaths();
	
	int getXmlPathsSize();
	
	ELXmlPath addXmlPath(int index);
	
	void removeXmlPath(int index);
	
	void moveXmlPath(int targetIndex, int sourceIndex);
}
