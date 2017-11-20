/**
 * 
 */
package me.pingaz.rmt.server;

import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import me.pingaz.rmt.util.JsonUtils;

/**
 * @author Ping
 *
 */
public class RMTService {

	@POST
	@Path("/{class}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String newInstance(@PathParam("class") String className, @QueryParam("arguments") String arguments){
		RMTObject[] args = JsonUtils.parseRMTArrayFromJson(arguments);
		Class<?>[] classArray = new Class<?>[args.length];
		Object[] valueArray = new Object[args.length];
		int index = 0;
		for(RMTObject argument: args){
			valueArray[index] = argument.getValue();
			classArray[index++] = argument.getValue().getClass();
		}
		try {
			Class<?> clazz = Class.forName(className);
			Object result = clazz.getConstructor(classArray).newInstance(valueArray);
			System.out.println("result:"+result);
			return JsonUtils.toJson(new RMTObject(result));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@POST
	@Path("/{class}/{method}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String execute(@PathParam("class") String classname, @PathParam("method") String methodName, @QueryParam("arguments") String arguments){
		return null;
	}
}
