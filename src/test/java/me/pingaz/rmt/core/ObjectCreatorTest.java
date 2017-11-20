/**
 * 
 */
package me.pingaz.rmt.core;

import static org.junit.Assert.*;

import org.junit.Test;

import me.pingaz.rmt.sample.query.RMTQuery;
import me.pingaz.rmt.server.RMTService;

/**
 * @author Ping
 *
 */
public class ObjectCreatorTest {

	/**
	 * Test method for {@link me.pingaz.rmt.core.ObjectCreator#addPackage(java.lang.String)}.
	 */
	@Test
	public void testAddPackage() {
		ObjectCreator creator = new ObjectCreator();
		creator.addPackage(RMTService.class.getPackage().getName());
		creator.addPackage(RMTQuery.class.getPackage().getName());
		fail("Not yet implemented");
	}

}
