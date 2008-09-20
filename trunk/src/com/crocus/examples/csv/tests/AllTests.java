package com.crocus.examples.csv.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for com.crocus.examples.csv.tests");
		// $JUnit-BEGIN$
		suite.addTest(new TestCrocus());
		// $JUnit-END$
		return suite;
	}

}
