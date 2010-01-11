/*******************************************************************************
 * Copyright (c) 2009, 2010 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.core.context;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Provisional API: This interface is part of an interim API that is still
 * under development and expected to change significantly before reaching
 * stability. It is available at this early stage to solicit feedback from
 * pioneering adopters on the understanding that any code that uses this API
 * will almost certainly be broken (repeatedly) as the API evolves.
 */
public interface AssociationOverrideContainer
	extends JpaContextNode
{

	// **************** association overrides **************************************

	/**
	 * Return a list iterator of the association overrides whether specified or default.
	 * This will not be null.
	 */
	<T extends AssociationOverride> ListIterator<T> associationOverrides();

	/**
	 * Return the number of association overrides, both specified and default.
	 */
	int associationOverridesSize();

	/**
	 * Return a list iterator of the specified association overrides.
	 * This will not be null.  No add/remove for specified association overrides, the
	 * virtual association overrides will be populated from superclasses, then use
	 * {@link AssociationOverride#setVirtual(boolean)} to add/remove the association
	 * override from the source
	 */
	<T extends AssociationOverride> ListIterator<T> specifiedAssociationOverrides();

	/**
	 * Return the number of specified association overrides.
	 */
	int specifiedAssociationOverridesSize();

	/**
	 * Return the number of default association overrides.
	 */
	<T extends AssociationOverride> ListIterator<T> virtualAssociationOverrides();

	/**
	 * Return the number of default association overrides.
	 */
	int virtualAssociationOverridesSize();

	/**
	 * Move the specified association override from the source index to the target index.
	 */
	void moveSpecifiedAssociationOverride(int targetIndex, int sourceIndex);
		String SPECIFIED_ASSOCIATION_OVERRIDES_LIST = "specifiedAssociationOverrides"; //$NON-NLS-1$
		String VIRTUAL_ASSOCIATION_OVERRIDES_LIST = "virtualAssociationOverrides"; //$NON-NLS-1$

	/**
	 * Return the association override, whether specified or default,
	 * with the given name.
	 */
	AssociationOverride getAssociationOverrideNamed(String name);
	
	interface Owner
	{
		/**
		 * Return the type mapping of the owning persistent type.
		 */
		TypeMapping getTypeMapping();
		
		/**
		 * Return the overridable persistent type, not the owning persistent type.
		 * This will be the persistent type of the mapped superclass or embeddable.
		 */
		TypeMapping getOverridableTypeMapping();
		
		RelationshipReference resolveRelationshipReference(String associationOverrideName);

		/**
		 * Return the name of the table which the join column column belongs to by default
		 */
		String getDefaultTableName();

		/**
		 * return whether the given table cannot be explicitly specified
		 * in the join column's 'table' element
		 */
		boolean tableNameIsInvalid(String tableName);

		/**
		 * Return the database table for the specified table name
		 */
		org.eclipse.jpt.db.Table getDbTable(String tableName);

		/**
		 * Return a list of table names that are valid for the overrides column, or join columns
		 */
		Iterator<String> candidateTableNames();
	}


}
