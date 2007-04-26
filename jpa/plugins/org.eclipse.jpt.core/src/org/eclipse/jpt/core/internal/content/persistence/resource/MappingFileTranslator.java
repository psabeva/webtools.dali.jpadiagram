/*******************************************************************************
 *  Copyright (c) 2007 Oracle. 
 *  All rights reserved.  This program and the accompanying materials 
 *  are made available under the terms of the Eclipse Public License v1.0 
 *  which accompanies this distribution, and is available at 
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *  	Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.core.internal.content.persistence.resource;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jpt.core.internal.content.persistence.PersistencePackage;
import org.eclipse.wst.common.internal.emf.resource.Translator;

public class MappingFileTranslator extends Translator
{
	private static Translator[] children;
	
	
	public MappingFileTranslator(String domNameAndPath, EStructuralFeature feature, int style) {
		super(domNameAndPath, feature, style);
	}

	public MappingFileTranslator(String domNameAndPath, EStructuralFeature feature) {
		super(domNameAndPath, feature);
	}
	
	
	public Translator[] getChildren(Object target, int versionID) {
		if (children == null) {
			children = createChildren();
		}
		return children;
	}
	
	private static Translator[] createChildren() {
		return new Translator[] {
			new Translator(TEXT_ATTRIBUTE_VALUE, PersistencePackage.eINSTANCE.getMappingFileRef_FileName())
		};
	}
}
