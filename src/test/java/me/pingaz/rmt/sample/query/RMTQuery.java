/**
 * 
 */
package me.pingaz.rmt.sample.query;

import me.pingaz.rmt.RMTSingleton;

/**
 * @author Ping
 *
 */
@RMTSingleton
public class RMTQuery {

	public RMTResult query(String keyword){
		return new RMTResult();
	}
}
