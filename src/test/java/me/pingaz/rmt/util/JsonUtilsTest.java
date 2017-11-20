/**
 * 
 */
package me.pingaz.rmt.util;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

import me.pingaz.rmt.server.RMTObject;

/**
 * @author Ping
 *
 */
public class JsonUtilsTest {

	/**
	 * Test method for {@link me.pingaz.rmt.util.JsonUtils#fromJson(java.lang.String)}.
	 */
	@Test
	public void testFromJsonString() {
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<>();
		map.put("classname", TestJson.class.getName());
		
		Map<String, Object> objectMap = new HashMap<>();
		objectMap.put("name", "test name");
		
		map.put("value", objectMap);
		
		Object[] array = new Object[1];
		array[0] = map;
		String json = gson.toJson(array);
		
		RMTObject[] result = JsonUtils.parseRMTArrayFromJson(json);
		System.out.println("Result is :" + result[0].getValue().getClass()+","+result[0].getValue());
		assertTrue("Result is TestJson.", result[0].getValue() instanceof TestJson);
	}
	
	public static class TestJson{
		private String name;

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "TestJson [name=" + name + "]";
		}
	}

}
