/*******************************************************************************
 * Copyright (c) 2009, 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.core.jpa2.context.orm;

import org.eclipse.jpt.core.context.JoinColumn;
import org.eclipse.jpt.core.context.orm.OrmOverrideRelationship;
import org.eclipse.jpt.core.context.orm.OrmJoinTableRelationship;
import org.eclipse.jpt.core.context.orm.OrmJoinTableRelationshipStrategy;
import org.eclipse.jpt.core.context.Table;
import org.eclipse.jpt.core.context.JoinColumn.Owner;
import org.eclipse.jpt.core.internal.context.JoinColumnTextRangeResolver;
import org.eclipse.jpt.core.internal.context.JptValidator;
import org.eclipse.jpt.core.internal.context.TableTextRangeResolver;
import org.eclipse.jpt.core.jpa2.context.OverrideRelationship2_0;

/**
 * JPA 2.0 <code>orm.xml</code> association override relationship
 * <p>
 * Provisional API: This interface is part of an interim API that is still
 * under development and expected to change significantly before reaching
 * stability. It is available at this early stage to solicit feedback from
 * pioneering adopters on the understanding that any code that uses this API
 * will almost certainly be broken (repeatedly) as the API evolves.
 * 
 * @version 3.0
 * @since 2.3
 */
public interface OrmOverrideRelationship2_0 
	extends OverrideRelationship2_0,
			OrmOverrideRelationship,
			OrmJoinTableRelationship
{
	OrmJoinTableRelationshipStrategy getJoinTableStrategy();

	JptValidator buildJoinTableJoinColumnValidator(JoinColumn column, JoinColumn.Owner owner, JoinColumnTextRangeResolver textRangeResolver);

	JptValidator buildJoinTableInverseJoinColumnValidator(JoinColumn column, Owner owner, JoinColumnTextRangeResolver textRangeResolver);

	JptValidator buildTableValidator(Table table, TableTextRangeResolver textRangeResolver);
}