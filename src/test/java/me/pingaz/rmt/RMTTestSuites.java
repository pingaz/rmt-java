/**
 * 
 */
package me.pingaz.rmt;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;
import me.pingaz.rmt.core.ObjectCreatorTest;
import me.pingaz.rmt.sample.query.RMTQueryTest;
import me.pingaz.rmt.util.JsonUtilsTest;

/**
 * @author Ping
 *
 */
public class RMTTestSuites {

	public static Test suite(){
		TestSuite suite = new TestSuite("Test for ALL RMT PACKAGES");
		  
		suite.addTest(new JUnit4TestAdapter(UtilTestSuite.class));
		suite.addTest(new JUnit4TestAdapter(ObjectCreatorTest.class));
		suite.addTest(new JUnit4TestAdapter(RMTQueryTest.class));
		return suite;  
	}
	
	@RunWith(Suite.class)  
	@Suite.SuiteClasses({JsonUtilsTest.class})
	public static class UtilTestSuite{
	}
	
	@RunWith(Suite.class)  
	@Suite.SuiteClasses({ObjectCreatorTest.class})
	public static class CoreTestSuite{
	}

	@RunWith(Suite.class)  
	@Suite.SuiteClasses({RMTQueryTest.class})
	public static class SampleQueryTestSuite{}
}
