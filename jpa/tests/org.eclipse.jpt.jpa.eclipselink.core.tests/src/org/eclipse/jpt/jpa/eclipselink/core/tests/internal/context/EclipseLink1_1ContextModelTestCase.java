/*******************************************************************************
 * Copyright (c) 2009, 2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jpa.eclipselink.core.tests.internal.context;

import org.eclipse.jpt.jpa.eclipselink.core.internal.EclipseLinkJpaPlatformFactory1_1;
import org.eclipse.jpt.jpa.eclipselink.core.resource.orm.v1_1.EclipseLink1_1;

public abstract class EclipseLink1_1ContextModelTestCase extends EclipseLinkContextModelTestCase
{
	public static final String JPA_ANNOTATIONS_PACKAGE_NAME = "javax.persistence"; //$NON-NLS-1$

	protected EclipseLink1_1ContextModelTestCase(String name) {
		super(name);
	}

	@Override
	protected String getJpaPlatformID() {
		return EclipseLinkJpaPlatformFactory1_1.ID;
	}

	@Override
	protected String getEclipseLinkSchemaVersion() {
		return EclipseLink1_1.SCHEMA_VERSION;
	}
}
