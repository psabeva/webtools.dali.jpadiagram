/*******************************************************************************
 *  Copyright (c) 2011  Oracle. All rights reserved.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License v1.0, which accompanies this distribution
 *  and is available at http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *  	Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.jaxb.eclipselink.core.internal.libval;

import java.util.HashSet;
import java.util.Set;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jpt.common.core.libprov.JptLibraryProviderInstallOperationConfig;
import org.eclipse.jpt.common.core.libval.LibraryValidator;
import org.eclipse.jpt.common.eclipselink.core.internal.libval.EclipseLinkLibValUtil;
import org.eclipse.jpt.jaxb.core.internal.libprov.JaxbUserLibraryProviderInstallOperationConfig;
import org.eclipse.jpt.jaxb.core.platform.JaxbPlatformDescription;
import org.eclipse.jpt.jaxb.eclipselink.core.MoxyPlatform;
import org.eclipse.osgi.service.resolver.VersionRange;


/**
 * Library validator for Moxy user libraries.
 * 
 * In order to validate that the correct eclipselink.jar is present in the user library, the version
 * class which appears in standard EclipseLink libraries will be examined and compared against the
 * union of calculated version ranges, depending on the platform specified in the config.
 */
public class MoxyUserLibraryValidator
		implements LibraryValidator {
	
	public IStatus validate(JptLibraryProviderInstallOperationConfig config) {
		JaxbUserLibraryProviderInstallOperationConfig jaxbConfig 
				= (JaxbUserLibraryProviderInstallOperationConfig) config;
		JaxbPlatformDescription platform = jaxbConfig.getJaxbPlatform();
		Set<VersionRange> versionRanges = new HashSet<VersionRange>();
		
		if (MoxyPlatform.VERSION_2_3.equals(platform)) {
			versionRanges.add(new VersionRange("[2.3, 3.0)")); //$NON-NLS-1$
		}
		
		return EclipseLinkLibValUtil.validate(jaxbConfig.resolve(), versionRanges);
	}
}