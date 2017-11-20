/**
 * 
 */
package me.pingaz.rmt.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import com.google.common.base.Predicate;

import me.pingaz.rmt.RMTBean;
import me.pingaz.rmt.RMTSingleton;
import me.pingaz.rmt.RMTStateful;
import me.pingaz.rmt.RMTStateless;
import me.pingaz.rmt.server.RMTObject;

/**
 * @author Ping
 *
 */
public class ObjectCreator {
	private static final String BEAN_ANNOTATION = ((Class<? extends Annotation>) RMTBean.class).getName();
	private static final String SINGLETON_ANNOTATION = ((Class<? extends Annotation>) RMTSingleton.class).getName();
	private static final String STATEFUL_ANNOTATION = ((Class<? extends Annotation>) RMTStateful.class).getName();
	private static final String STATELESS_ANNOTATION = ((Class<? extends Annotation>) RMTStateless.class).getName();

	private HashMap<Class<?>, Object> singletonMap = new HashMap<>();
	
	public ObjectCreator() {

	}

	public void addPackage(String packageName) {
		Reflections reflections = new Reflections(packageName);
		Set<Class<?>> allClasses = reflections.getTypesAnnotatedWith(RMTSingleton.class);
		System.out.println("all classes:" + allClasses);
		for(Class<?> clazz : allClasses){
			if (!singletonMap.containsKey(clazz)) {
				singletonMap.put(clazz, null);
			}
		}
	}

	public Object newInstance(Class<?> clazz, Object[] args) {
		if(singletonMap.containsKey(clazz)){
			Object instance = singletonMap.get(clazz);
			if(instance == null){
				instance = createObject(clazz, args);
			}
			return instance;
		}else{
			return createObject(clazz, args);
		}
	}

	/**
	 * @param clazz
	 * @param args
	 * @param instance
	 * @return
	 */
	private Object createObject(Class<?> clazz, Object[] args) {
		Class<?>[] classArray = new Class<?>[args.length];
		int index = 0;
		for(Object argument: args){
			classArray[index++] = argument.getClass();
		}
		try {
			Object instance = clazz.getConstructor(classArray).newInstance(args);
			singletonMap.put(clazz, instance);
			return instance;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
