/*******************************************************************************
 * Copyright (c) 2009, 2011 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.eclipselink2_0.core.tests.internal.context.orm;

import org.eclipse.jpt.common.core.internal.operations.JptFileCreationDataModelProperties;
import org.eclipse.jpt.core.internal.facet.JpaFacetInstallDataModelProperties;
import org.eclipse.jpt.core.internal.operations.JpaFileCreationDataModelProperties;
import org.eclipse.jpt.core.internal.operations.OrmFileCreationDataModelProperties;
import org.eclipse.jpt.core.resource.xml.JpaXmlResource;
import org.eclipse.jpt.core.tests.internal.projects.TestJpaProject;
import org.eclipse.jpt.eclipselink.core.context.orm.EclipseLinkEntityMappings;
import org.eclipse.jpt.eclipselink.core.internal.operations.EclipseLinkOrmFileCreationDataModelProvider;
import org.eclipse.jpt.eclipselink.core.internal.operations.EclipseLinkOrmFileCreationOperation;
import org.eclipse.jpt.eclipselink.core.resource.orm.XmlEntityMappings;
import org.eclipse.jpt.eclipselink.core.resource.orm.v2_0.EclipseLink2_0;
import org.eclipse.jpt.eclipselink2_0.core.tests.internal.context.EclipseLink2_0ContextModelTestCase;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

@SuppressWarnings("nls")
public abstract class EclipseLink2_0OrmContextModelTestCase
	extends EclipseLink2_0ContextModelTestCase
{
	protected JpaXmlResource eclipseLink2_0OrmXmlResource;
	
	
	protected EclipseLink2_0OrmContextModelTestCase(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.eclipseLink2_0OrmXmlResource = getJpaProject().getDefaultEclipseLinkOrmXmlResource();
	}
	@Override
	protected IDataModel buildJpaConfigDataModel() {
		IDataModel dataModel = super.buildJpaConfigDataModel();
		// don't create default orm.xml - instead build eclipselink-orm.xml
		dataModel.setProperty(JpaFacetInstallDataModelProperties.CREATE_ORM_XML, Boolean.FALSE);
		return dataModel;
	}
	
	@Override
	protected TestJpaProject buildJpaProject(String projectName, boolean autoBuild, IDataModel jpaConfig) throws Exception {
		TestJpaProject testJpaProject = super.buildJpaProject(projectName, autoBuild, jpaConfig);
		
		EclipseLinkOrmFileCreationOperation operation = 
			new EclipseLinkOrmFileCreationOperation(buildEclipseLinkOrmConfig(testJpaProject));
		operation.execute(null, null);
		
		return testJpaProject;
	}
	
	protected IDataModel buildEclipseLinkOrmConfig(TestJpaProject testJpaProject) {
		IDataModel dataModel = 
			DataModelFactory.createDataModel(new EclipseLinkOrmFileCreationDataModelProvider());		
		dataModel.setProperty(JptFileCreationDataModelProperties.CONTAINER_PATH, 
				testJpaProject.getProject().getFolder("src/META-INF").getFullPath());
		dataModel.setProperty(JpaFileCreationDataModelProperties.VERSION, EclipseLink2_0.SCHEMA_VERSION);
		dataModel.setProperty(OrmFileCreationDataModelProperties.ADD_TO_PERSISTENCE_UNIT, Boolean.TRUE);
		return dataModel;
	}
	
	@Override
	protected void tearDown() throws Exception {
		this.eclipseLink2_0OrmXmlResource = null;
		super.tearDown();
	}
	
	@Override
	protected JpaXmlResource getOrmXmlResource() {
		return this.eclipseLink2_0OrmXmlResource;
	}
	
	@Override
	protected XmlEntityMappings getXmlEntityMappings() {
		return (XmlEntityMappings) super.getXmlEntityMappings();
	}
	
	@Override
	protected EclipseLinkEntityMappings getEntityMappings() {
		return (EclipseLinkEntityMappings) super.getEntityMappings();
	}
}
