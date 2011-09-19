/*******************************************************************************
 *  Copyright (c) 2011  Oracle. All rights reserved.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License v1.0, which accompanies this distribution
 *  and is available at http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *  	Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.jpa.eclipselink.ui.internal.v2_4.platform;

import java.util.List;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.details.orm.EclipseLinkEntityMappingsDetailsProvider;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.details.orm.EclipseLinkOrmXmlUiDefinition;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.persistence.EclipseLinkPersistenceXmlUiDefinition;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.v1_1.details.orm.EclipseLinkOrmXml1_1UiDefinition;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.v1_2.details.orm.EclipseLinkOrmXml1_2UiDefinition;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.v2_0.details.java.EclipseLink2_0JavaResourceUiDefinition;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.v2_0.details.orm.EclipseLinkEntityMappings2_0DetailsProvider;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.v2_0.details.orm.EclipseLinkOrmXml2_0UiDefinition;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.v2_0.persistence.EclipseLinkPersistenceXml2_0UiDefinition;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.v2_1.details.orm.EclipseLinkOrmXml2_1UiDefinition;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.v2_2.details.orm.EclipseLinkOrmXml2_2UiDefinition;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.v2_3.details.orm.EclipseLinkOrmXml2_3UiDefinition;
import org.eclipse.jpt.jpa.eclipselink.ui.internal.v2_4.details.orm.EclipseLinkOrmXml2_4UiDefinition;
import org.eclipse.jpt.jpa.ui.JpaPlatformUiProvider;
import org.eclipse.jpt.jpa.ui.ResourceUiDefinition;
import org.eclipse.jpt.jpa.ui.details.JpaDetailsProvider;
import org.eclipse.jpt.jpa.ui.internal.AbstractJpaPlatformUiProvider;
import org.eclipse.jpt.jpa.ui.internal.details.java.JavaPersistentAttributeDetailsProvider;
import org.eclipse.jpt.jpa.ui.internal.details.java.JavaPersistentTypeDetailsProvider;
import org.eclipse.jpt.jpa.ui.internal.details.orm.EntityMappingsDetailsProvider;
import org.eclipse.jpt.jpa.ui.internal.details.orm.OrmPersistentAttributeDetailsProvider;
import org.eclipse.jpt.jpa.ui.internal.details.orm.OrmPersistentTypeDetailsProvider;
import org.eclipse.jpt.jpa.ui.internal.details.orm.OrmXmlUiDefinition;
import org.eclipse.jpt.jpa.ui.internal.jpa2.details.orm.EntityMappings2_0DetailsProvider;
import org.eclipse.jpt.jpa.ui.internal.jpa2.details.orm.OrmXml2_0UiDefinition;


public class EclipseLink2_4JpaPlatformUiProvider
		extends AbstractJpaPlatformUiProvider {

	// singleton
	private static final JpaPlatformUiProvider INSTANCE = new EclipseLink2_4JpaPlatformUiProvider();


	/**
	 * Return the singleton.
	 */
	public static JpaPlatformUiProvider instance() {
		return INSTANCE;
	}


	/**
	 * Ensure single instance.
	 */
	private EclipseLink2_4JpaPlatformUiProvider() {
		super();
	}


	// ********** details providers **********

	@Override
	protected void addDetailsProvidersTo(List<JpaDetailsProvider> providers) {
		providers.add(JavaPersistentTypeDetailsProvider.instance());
		providers.add(JavaPersistentAttributeDetailsProvider.instance());
		providers.add(EntityMappingsDetailsProvider.instance());
		providers.add(OrmPersistentTypeDetailsProvider.instance());
		providers.add(OrmPersistentAttributeDetailsProvider.instance());
		providers.add(EntityMappings2_0DetailsProvider.instance());
		providers.add(EclipseLinkEntityMappingsDetailsProvider.instance());
		providers.add(EclipseLinkEntityMappings2_0DetailsProvider.instance());
	}


	// ********** resource ui definitions **********

	@Override
	protected void addResourceUiDefinitionsTo(List<ResourceUiDefinition> definitions) {
		definitions.add(EclipseLink2_0JavaResourceUiDefinition.instance());
		definitions.add(OrmXmlUiDefinition.instance());
		definitions.add(OrmXml2_0UiDefinition.instance());
		definitions.add(EclipseLinkOrmXmlUiDefinition.instance());
		definitions.add(EclipseLinkOrmXml1_1UiDefinition.instance());
		definitions.add(EclipseLinkOrmXml1_2UiDefinition.instance());
		definitions.add(EclipseLinkOrmXml2_0UiDefinition.instance());
		definitions.add(EclipseLinkOrmXml2_1UiDefinition.instance());
		definitions.add(EclipseLinkOrmXml2_2UiDefinition.instance());
		definitions.add(EclipseLinkOrmXml2_3UiDefinition.instance());
		definitions.add(EclipseLinkOrmXml2_4UiDefinition.instance());
		definitions.add(EclipseLinkPersistenceXmlUiDefinition.instance());
		definitions.add(EclipseLinkPersistenceXml2_0UiDefinition.instance());
	}
}