/**
 * 
 */
package me.pingaz.rmt.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import me.pingaz.rmt.server.RMTObject;

/**
 * @author Ping
 *
 */
public class JsonUtils {
	
	public static <T> T fromJson(String json, Class<T> clazz){
		Gson gson = new Gson();
		return gson.fromJson(json, clazz);
	}

	private static GsonBuilder builder = new GsonBuilder()
			.registerTypeAdapter(RMTObject.class, new RMTObjectDeserializer())
			.registerTypeAdapter(RMTObject.class, new RMTObjectSerializer());
	
	public static RMTObject[] parseRMTArrayFromJson(String json){
		if (json == null || "".equals(json)) {
			return new RMTObject[0];
		}
		Gson gson = builder.create();
		return gson.fromJson(json, RMTObject[].class);
	}
	public static RMTObject parseRMTObjectFromJson(String json){
		Gson gson = builder.create();
		return gson.fromJson(json, RMTObject.class);
	}
	
	public static String toJson(RMTObject rmtObject){
		Gson gson = builder.create();
		return gson.toJson(rmtObject);
	}
	
	public static class RMTObjectDeserializer implements JsonDeserializer<RMTObject>{

		/* (non-Javadoc)
		 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
		 */
		@Override
		public RMTObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			JsonObject root = json.getAsJsonObject();
			System.out.println(root);
			String classname = root.get("classname").getAsString();
			try {
				Class<?> clazz = Class.forName(classname);
				Object value = context.deserialize(root.get("value"), clazz);
				System.out.println(value);
				return new RMTObject(value);
			} catch (ClassNotFoundException e) {
				throw new JsonParseException(e);
			}
		}
		
	}
	
	public static class RMTObjectSerializer implements JsonSerializer<RMTObject>{

		/* (non-Javadoc)
		 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
		 */
		@Override
		public JsonElement serialize(RMTObject src, Type typeOfSrc, JsonSerializationContext context) {
			JsonObject object = new JsonObject();
			object.addProperty("classname",src. getClassName());
			object.add("value", context.serialize(src.getValue()));
			return object;
		}
		
	}
}
