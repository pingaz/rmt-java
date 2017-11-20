/**
 * 
 */
package me.pingaz.rmt.server;

/**
 * @author Ping
 *
 */
public class RMTObject {

	private String className;
	private Object value;
	/**
	 * 
	 */
	public RMTObject() {
		super();
	}
	/**
	 * @param value
	 */
	public RMTObject(Object value) {
		super();
		this.className = value.getClass().getName();
		this.value = value;
	}
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
