/**
 * 
 */
package me.pingaz.rmt.sample.query;

import me.pingaz.rmt.RMTStateful;

/**
 * @author Ping
 *
 */
@RMTStateful
public class RMTResult {

	public int count(){
		return 100;
	}
	
	public RMTRow[] get(int index, int size){
		return null;
	}
}
