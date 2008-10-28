/*******************************************************************************
 *  Copyright (c) 2008  Oracle. 
 *  All rights reserved.  This program and the accompanying materials are 
 *  made available under the terms of the Eclipse Public License v1.0 which 
 *  accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *  	Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.eclipselink.core.internal.resource.orm.translators;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jpt.core.internal.resource.orm.translators.MappedSuperclassTranslator;
import org.eclipse.jpt.eclipselink.core.resource.orm.EclipseLinkOrmFactory;
import org.eclipse.wst.common.internal.emf.resource.Translator;

public class EclipseLinkMappedSuperclassTranslator extends MappedSuperclassTranslator
	implements EclipseLinkOrmXmlMapper
{
	public EclipseLinkMappedSuperclassTranslator(String domNameAndPath, EStructuralFeature aFeature) {
		super(domNameAndPath, aFeature);
	}
	
	
	@Override
	public EObject createEMFObject(String nodeName, String readAheadName) {
		return EclipseLinkOrmFactory.eINSTANCE.createXmlMappedSuperclass();
	}
	
	
	@Override
	protected Translator[] createChildren() {
		return new Translator[] {
			createClassTranslator(),
			createAccessTranslator(),
			createMetadataCompleteTranslator(),
			createReadOnlyTranslator(),
			createExistenceCheckingTranslator(),
			createDescriptionTranslator(),
			createCustomizerTranslator(),
			createChangeTrackingTranslator(),
			createIdClassTranslator(),
			createCacheTranslator(),
			createConverterTranslator(),
			createTypeConverterTranslator(),
			createObjectTypeConverterTranslator(),
			createStructConverterTranslator(),
			createExcludeDefaultListenersTranslator(),
			createExcludeSuperclassListenersTranslator(),
			createEntityListenersTranslator(),
			createPrePersistTranslator(),
			createPostPersistTranslator(),
			createPreRemoveTranslator(),
			createPostRemoveTranslator(),
			createPreUpdateTranslator(),
			createPostUpdateTranslator(),
			createPostLoadTranslator(),
			createAttributesTranslator()
		};
	}
	
	protected Translator createReadOnlyTranslator() {
		return new Translator(READ_ONLY, ECLIPSELINK_ORM_PKG.getXmlReadOnly_ReadOnly(), DOM_ATTRIBUTE);
	}
	
	protected Translator createExistenceCheckingTranslator() {
		return new Translator(EXISTENCE_CHECKING, ECLIPSELINK_ORM_PKG.getXmlCacheHolder_ExistenceChecking(), DOM_ATTRIBUTE);
	}
	
	protected Translator createCustomizerTranslator() {
		return new CustomizerTranslator(CUSTOMIZER, ECLIPSELINK_ORM_PKG.getXmlCustomizerHolder_Customizer());
	}
	
	protected Translator createChangeTrackingTranslator() {
		return new EclipseLinkChangeTrackingTranslator(CHANGE_TRACKING, ECLIPSELINK_ORM_PKG.getXmlChangeTrackingHolder_ChangeTracking(), END_TAG_NO_INDENT);
	}
	
	protected Translator createCacheTranslator() {
		return new CacheTranslator();
	}
	
	protected Translator createConverterTranslator() {
		return new ConverterTranslator(CONVERTER, ECLIPSELINK_ORM_PKG.getXmlConvertersHolder_Converters());
	}
	
	protected Translator createTypeConverterTranslator() {
		return new TypeConverterTranslator(TYPE_CONVERTER, ECLIPSELINK_ORM_PKG.getXmlConvertersHolder_TypeConverters());
	}
	
	protected Translator createObjectTypeConverterTranslator() {
		return new ObjectTypeConverterTranslator(OBJECT_TYPE_CONVERTER, ECLIPSELINK_ORM_PKG.getXmlConvertersHolder_ObjectTypeConverters());
	}
	
	protected Translator createStructConverterTranslator() {
		return new StructConverterTranslator(STRUCT_CONVERTER, ECLIPSELINK_ORM_PKG.getXmlConvertersHolder_StructConverters());
	}
}
