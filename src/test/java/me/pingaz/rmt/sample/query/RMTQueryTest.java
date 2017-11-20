/**
 * 
 */
package me.pingaz.rmt.sample.query;

import static org.junit.Assert.*;

import org.junit.Test;

import me.pingaz.rmt.server.RMTObject;
import me.pingaz.rmt.server.RMTService;
import me.pingaz.rmt.util.JsonUtils;

/**
 * @author Ping
 *
 */
public class RMTQueryTest{

	/**
	 * Test method for {@link me.pingaz.rmt.server.RMTService#newInstance(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testNewQuery() {
		RMTService service = new RMTService();
		String result = service.newInstance(RMTQuery.class.getName(), "");
		RMTObject value = JsonUtils.parseRMTObjectFromJson(result);
		System.out.println("query test - new query result: "+value.getValue());
	}

	/**
	 * Test method for {@link me.pingaz.rmt.server.RMTService#execute(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testExecute() {
		fail("Not yet implemented");
	}

}
