/*******************************************************************************
 *  Copyright (c) 2010  Oracle. All rights reserved.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License v1.0, which accompanies this distribution
 *  and is available at http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *  	Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.jaxb.ui.internal.wizards.facet.model;

import org.eclipse.jpt.jaxb.core.internal.facet.JaxbFacetInstallConfig;

public class JaxbFacetInstallDataModelProvider
		extends JaxbFacetDataModelProvider 
		implements JaxbFacetInstallDataModelProperties {
	
	public JaxbFacetInstallDataModelProvider() {
		this(new JaxbFacetInstallConfig());
	}
	
	public JaxbFacetInstallDataModelProvider(JaxbFacetInstallConfig config) {
		super(config);
	}
}
