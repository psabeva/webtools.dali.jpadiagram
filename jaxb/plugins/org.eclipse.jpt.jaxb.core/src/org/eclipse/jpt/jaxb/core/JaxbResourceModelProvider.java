/*******************************************************************************
 * Copyright (c) 2010 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jaxb.core;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.jpt.common.core.JptResourceModel;

/**
 * Map a content type to a JAXB resource model.
 * 
 * Provisional API: This interface is part of an interim API that is still
 * under development and expected to change significantly before reaching
 * stability. It is available at this early stage to solicit feedback from
 * pioneering adopters on the understanding that any code that uses this API
 * will almost certainly be broken (repeatedly) as the API evolves.
 * 
 * @version 3.0
 * @since 3.0
 */
public interface JaxbResourceModelProvider 
{
	/**
	 * Return the file content type the provider is for.
	 */
	IContentType getContentType();

	/**
	 * Build a JAXB resource model for the specified JAXB project and file.
	 * Use the specified factory for creation so extenders can simply override
	 * the appropriate creation method instead of building a provider for the
	 * same content.
	 */
	JptResourceModel buildResourceModel(JaxbProject jaxbProject, IFile file);
}
