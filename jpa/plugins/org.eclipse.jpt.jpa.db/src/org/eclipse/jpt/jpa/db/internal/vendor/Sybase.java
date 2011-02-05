/*******************************************************************************
 * Copyright (c) 2009 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.jpa.db.internal.vendor;

import java.util.ArrayList;

import org.eclipse.datatools.modelbase.sql.schema.Database;
import org.eclipse.jpt.common.utility.internal.StringTools;

class Sybase
	extends AbstractVendor
{
	private final String dtpVendorName;

	static final Vendor ASA = new Sybase("Sybase_ASA"); //$NON-NLS-1$
	static final Vendor ASE = new Sybase("Sybase_ASE"); //$NON-NLS-1$

	static Vendor asa() {
		return ASA;
	}

	static Vendor ase() {
		return ASE;
	}

	/**
	 * Ensure only static instances.
	 */
	private Sybase(String dtpVendorName) {
		super();
		this.dtpVendorName = dtpVendorName;
	}

	@Override
	public String getDTPVendorName() {
		return this.dtpVendorName;
	}

	@Override
	CatalogStrategy getCatalogStrategy() {
		return SimpleCatalogStrategy.instance();
	}

	/**
	 * By default, Sybase identifiers are case-sensitive, even without
	 * delimiters. This can depend on the collation setting....
	 */
	@Override
	FoldingStrategy getFoldingStrategy() {
		return NonFoldingStrategy.instance();
	}

	/**
	 * Sybase will use the user-requested database; if that database is not
	 * found, it will default to 'master'.
	 */
	@Override
	void addDefaultCatalogNamesTo(Database database, String userName, ArrayList<String> names) {
		names.add(database.getName());
		names.add(MASTER_CATALOG_NAME);
	}
	private static final String MASTER_CATALOG_NAME = "master";  //$NON-NLS-1$

	/**
	 * The typical default schema on Sybase for any database (catalog) is
	 * 'dbo'.
	 * 
	 * Actually, the default schema is more like a search path:
	 * The server looks for a schema object (e.g. a table) first in the user's
	 * schema, then it looks for the schema object in the database owner's
	 * schema (dbo). As a result, it's really not possible to specify
	 * the "default" schema without knowing the schema object we are
	 * looking for.
	 * 
	 * (Note: the current 'user' is not the same thing as the current
	 * 'login' - see sp_adduser and sp_addlogin; so we probably can't
	 * use ConnectionProfile#getUserName().)
	 */
	@Override
	void addDefaultSchemaNamesTo(Database database, String userName, ArrayList<String> names) {
		names.add(DEFAULT_SCHEMA_NAME);
	}
	private static final String DEFAULT_SCHEMA_NAME = "dbo";  //$NON-NLS-1$

	@Override
	char[] getExtendedRegularNameStartCharacters() {
		return EXTENDED_REGULAR_NAME_START_CHARACTERS;
	}
	private static final char[] EXTENDED_REGULAR_NAME_START_CHARACTERS = new char[] { '_', '@' };

	@Override
	char[] getExtendedRegularNamePartCharacters() {
		return EXTENDED_REGULAR_NAME_PART_CHARACTERS;
	}
	private static final char[] EXTENDED_REGULAR_NAME_PART_CHARACTERS = new char[] { '$', '�', '�', '#' };

	/**
	 * By default, Sybase delimits identifiers with brackets ([]); but it
	 * can also be configured to use double-quotes.
	 */
	@Override
	boolean identifierIsDelimited(String identifier) {
		return StringTools.stringIsBracketed(identifier)
					|| super.identifierIsDelimited(identifier);
	}

}
