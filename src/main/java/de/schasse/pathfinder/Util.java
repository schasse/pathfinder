package de.schasse.pathfinder;

public class Util {
	/**
	 * Fills the integerstring with white spaces in front, 
	 * so that the string has the minimum of characters. 
	 * 
	 * @param a integer
	 * @return a String
	 */
	public static String intToString(int a, int max) {
		String retString = "";
		int limit = max;
		while ((limit > 1) && (limit > a)) {
			retString+=" ";
			limit = limit/10;
		}	
		return retString+a;
	}
}
