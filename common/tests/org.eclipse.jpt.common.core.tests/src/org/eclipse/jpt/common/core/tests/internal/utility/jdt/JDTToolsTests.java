/*******************************************************************************
 *  Copyright (c) 2011  Oracle. All rights reserved.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License v1.0, which accompanies this distribution
 *  and is available at http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors: 
 *  	Oracle - initial API and implementation
 *******************************************************************************/
package org.eclipse.jpt.common.core.tests.internal.utility.jdt;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jpt.common.core.internal.utility.TypeTools;


public class JDTToolsTests
		extends AnnotationTestCase {
	
	public JDTToolsTests(String name) {
		super(name);
	}
	
	
	public void testTypeIsSubtype() throws Exception {		
		IJavaProject jProj = getJavaProject().getJavaProject();
		
		// same type
		assertTrue(TypeTools.isSubType(ArrayList.class.getName(), ArrayList.class.getName(), jProj));
		assertTrue(TypeTools.isSubType(List.class.getName(), List.class.getName(), jProj));
		
		// concrete type is subtype of interface
		assertTrue(TypeTools.isSubType(ArrayList.class.getName(), List.class.getName(), jProj));
		assertTrue(TypeTools.isSubType(TreeSet.class.getName(), Iterable.class.getName(), jProj));
		
		// concrete type is not subtype of interface
		assertFalse(TypeTools.isSubType(ArrayList.class.getName(), Map.class.getName(), jProj));
		assertFalse(TypeTools.isSubType(TreeSet.class.getName(), Map.class.getName(), jProj));
		
		// interface is subtype of interface
		assertTrue(TypeTools.isSubType(List.class.getName(), Collection.class.getName(), jProj));
		assertTrue(TypeTools.isSubType(SortedSet.class.getName(), Iterable.class.getName(), jProj));
		
		// interface is not subtype of interface
		assertFalse(TypeTools.isSubType(List.class.getName(), Map.class.getName(), jProj));
		assertFalse(TypeTools.isSubType(SortedSet.class.getName(), Map.class.getName(), jProj));
		
		// concrete type is subtype of concrete type
		assertTrue(TypeTools.isSubType(ArrayList.class.getName(), AbstractList.class.getName(), jProj));
		assertTrue(TypeTools.isSubType(LinkedList.class.getName(), AbstractCollection.class.getName(), jProj));
		
		// concrete type is not subtype of concrete type
		assertFalse(TypeTools.isSubType(ArrayList.class.getName(), Vector.class.getName(), jProj));
		assertFalse(TypeTools.isSubType(LinkedList.class.getName(), Vector.class.getName(), jProj));
	}
}
