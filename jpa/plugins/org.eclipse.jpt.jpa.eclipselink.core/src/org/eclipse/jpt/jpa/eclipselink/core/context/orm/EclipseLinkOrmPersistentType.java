/*******************************************************************************
 * Copyright (c) 2012 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jpa.eclipselink.core.context.orm;

import org.eclipse.jpt.jpa.core.context.orm.OrmPersistentAttribute;
import org.eclipse.jpt.jpa.core.jpa2.context.orm.OrmPersistentType2_0;
import org.eclipse.jpt.jpa.eclipselink.core.context.EclipseLinkAccessMethodsHolder;

/**
 * <code>eclipselink-orm.xml</code> persistent type:<ul>
 * <li>mapping
 * <li>access
 * <li>access-methods
 * <li>attributes
 * <li>super persistent type
 * <li>Java persistent type
 * </ul>
 */
public interface EclipseLinkOrmPersistentType
	extends OrmPersistentType2_0, EclipseLinkAccessMethodsHolder
{

	//*************** dynamic *****************

	boolean isDynamic();
		String DYNAMIC_PROPERTY = "dynamic"; //$NON-NLS-1$

	OrmPersistentAttribute addVirtualAttribute(String attributeName, String mappingKey, String attributeType);

	//*************** covariant overrides *****************

	EclipseLinkOrmTypeMapping getMapping();
}