package com.prac.dsalgo.general;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheV2 {
	
	private static LinkedHashMap<String, String> keyValuePair;
	private static int MAX_SIZE = 2;
	
	public static String getValue(String key) {
		if(keyValuePair != null && keyValuePair.containsKey(key)) {
			String val = keyValuePair.remove(key);
			keyValuePair.put(key, val);
			return val;
		}
		return null;
	}
	
	public static void putValue(String key, String value) {
		if(keyValuePair == null) {
			keyValuePair = new LinkedHashMap<String, String>() {
				protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
	                return size() > MAX_SIZE;
	            }
			};
		}
		if(keyValuePair.containsKey(key)) {
			keyValuePair.remove(key);
		}
		keyValuePair.put(key, value);
	}

	public static void main(String[] args) {
		LRUCacheV2.putValue("2", "1");
		LRUCacheV2.putValue("3", "2");
		System.out.println(LRUCacheV2.getValue("3"));
		System.out.println(LRUCacheV2.getValue("2"));
		LRUCacheV2.putValue("4", "3");
		System.out.println(LRUCacheV2.getValue("2"));
		System.out.println(LRUCacheV2.getValue("3"));
		System.out.println(LRUCacheV2.getValue("4"));

	}

}
