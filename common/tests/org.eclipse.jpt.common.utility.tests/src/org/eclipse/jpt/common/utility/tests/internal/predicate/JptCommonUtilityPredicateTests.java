/*******************************************************************************
 * Copyright (c) 2012, 2013 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0, which accompanies this distribution
 * and is available at http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Contributors:
 *     Oracle - initial API and implementation
 ******************************************************************************/
package org.eclipse.jpt.common.utility.tests.internal.predicate;

import junit.framework.Test;
import junit.framework.TestSuite;

public class JptCommonUtilityPredicateTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(JptCommonUtilityPredicateTests.class.getPackage().getName());

		suite.addTestSuite(ANDTests.class);
		suite.addTestSuite(EqualsTests.class);
		suite.addTestSuite(FieldPredicateTests.class);
		suite.addTestSuite(IsIdenticalTests.class);
		suite.addTestSuite(InstanceOfTests.class);
		suite.addTestSuite(MethodPredicateTests.class);
		suite.addTestSuite(NOTTests.class);
		suite.addTestSuite(ORTests.class);
		suite.addTestSuite(PredicateTests.class);
		suite.addTestSuite(PredicateWrapperTests.class);
		suite.addTestSuite(TransformerPredicateTests.class);
		suite.addTestSuite(TransformationPredicateTests.class);
		suite.addTestSuite(UniquePredicateTests.class);
		suite.addTestSuite(UniqueIdentityPredicateTests.class);
		suite.addTestSuite(XORTests.class);

		return suite;
	}

	private JptCommonUtilityPredicateTests() {
		super();
		throw new UnsupportedOperationException();
	}
}
