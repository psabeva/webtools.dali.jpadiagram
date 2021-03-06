/*******************************************************************************
 * Copyright (c) 2010, 2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jaxb.core.internal.facet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jpt.jaxb.core.JaxbProjectManager;
import org.eclipse.wst.common.project.facet.core.IProjectFacetVersion;


public class JaxbFacetVersionChangeDelegate
		extends JaxbFacetDelegate {
	
	@Override
	protected void execute_(
			IProject project, IProjectFacetVersion fv, Object config,
			IProgressMonitor monitor) throws CoreException {
		
		SubMonitor sm = SubMonitor.convert(monitor, 2);
		super.execute_(project, fv, config, sm.newChild(1));
		
		JaxbProjectManager jaxbProjectManager = this.getJaxbProjectManager();
		if (jaxbProjectManager != null) {
			jaxbProjectManager.rebuildJaxbProject(project);
		}
		sm.worked(1);
		// nothing further to do here *just* yet
	}
}
