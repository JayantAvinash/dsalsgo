package com.prac.dsalgo.general;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {
	
	private static Map<String, String> keyValuePair;
	private static Node headKey;
	private static Node tailKey;
	private static int MAX_SIZE = 2;
	
	
	public static String getValue(String key) {
		if(keyValuePair != null && keyValuePair.containsKey(key)) {
			String value = keyValuePair.get(key);
			reorderKeyPriority(key);
			
			return value;
		}
		return null;
	}

	private static void reorderKeyPriority(String key) {
		Node temp = headKey;
		while(!temp.val.equals(key)) {
			temp = temp.next;
		}
		Node prev = temp.prev;
		if(prev != null) {
			prev.next = temp.next;
		}
		if(temp.next != null && prev != null) {
			temp.next.prev = prev;
		}
		
		if(headKey != temp) {
			temp.next = headKey;
			headKey.prev = temp;
			headKey = temp;
			if(tailKey == temp) {
				tailKey = prev;
			}
		}
	}
	
	public static void putValue(String key, String value) {
		if(keyValuePair == null) {
			keyValuePair = new ConcurrentHashMap<>();
		}
		if(keyValuePair.containsKey(key)) {
			reorderKeyPriority(key);
			keyValuePair.put(key, value);
		} else {
			keyValuePair.put(key, value);
			Node temp = new Node(key);
			if(headKey == null) {
				headKey = temp;
				tailKey = temp;
			} else {
				temp.next = headKey;
				headKey.prev = temp;
				headKey = temp;
				if(keyValuePair.size() > MAX_SIZE) {
					keyValuePair.remove(tailKey.val);
					Node prev = tailKey.prev;
					tailKey.prev = null;
					prev.next = null;
					tailKey = prev;
					
				}
			}
		}
		
	}
	
	private static class Node {
		String val;
		Node next;
		Node prev;
		Node(String val) {
			this.val = val;
		}
		
	}
	
	public static void main(String[] args) {
		LRUCache.putValue("2", "1");
		LRUCache.putValue("3", "2");
		System.out.println(LRUCache.getValue("3"));
		System.out.println(LRUCache.getValue("2"));
		LRUCache.putValue("4", "3");
		System.out.println(LRUCache.getValue("2"));
		System.out.println(LRUCache.getValue("3"));
		System.out.println(LRUCache.getValue("4"));
		
	}

}


