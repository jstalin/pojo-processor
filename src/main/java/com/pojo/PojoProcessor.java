package com.pojo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PojoProcessor {

	private Object object;

	private Map<String, Object> cache;

	public PojoProcessor(Object object) {
		this.object = object;
		this.cache = new HashMap<String, Object>();
	}

	@SuppressWarnings("unchecked")
	public <T> T get(String path) throws Exception {
		Object object = cache.get(path);
		if (object != null) {
			return (T)object;
		}

		char[] chars = path.toCharArray();
		Stack<String> subPaths = new Stack<String>();
		subPaths.push(path);
		for (int i = chars.length - 1; i > 0; i--) {
			if (chars[i] == '/') {
				char[] subPathChars = new char[i];
				System.arraycopy(chars, 0, subPathChars, 0, i);
				String subPath = new String(subPathChars);
				object = cache.get(subPath);
				if (object != null) {
					break;
				}
				subPaths.push(subPath);
			}
		}
		
		if(object == null) {
			object = this.object;
		}
		
		while(!subPaths.isEmpty()) {
			String subPath = subPaths.pop();
			String p = findLastPath(subPath);
			Field field = object.getClass().getDeclaredField(p);
			field.setAccessible(true);
	        Object value = field.get(object);
	        
			cache.put(subPath, value);
			object = value;
		}

		return (T)object;
	}
	
	public void set(String path, Object object) throws Exception {
		Object tmpObject = null;

		char[] chars = path.toCharArray();
		Stack<String> subPaths = new Stack<String>();
		for (int i = chars.length - 1; i > 0; i--) {
			if (chars[i] == '/') {
				char[] subPathChars = new char[i];
				System.arraycopy(chars, 0, subPathChars, 0, i);
				String subPath = new String(subPathChars);
				tmpObject = cache.get(subPath);
				if (tmpObject != null) {
					break;
				}
				subPaths.push(subPath);
			}
		}
		
		if(tmpObject == null) {
			tmpObject = this.object;
		}
		
		while(!subPaths.isEmpty()) {
			String subPath = subPaths.pop();
			String p = findLastPath(subPath);
			Field field = tmpObject.getClass().getDeclaredField(p);
			field.setAccessible(true);
	        Object value = field.get(tmpObject);
			cache.put(subPath, value);
			tmpObject = value;
		}
		Field field = tmpObject.getClass().getDeclaredField(findLastPath(path));
		field.setAccessible(true);
		field.set(tmpObject, object);
		cache.put(path, object);
	}
	
	private String findLastPath(String paths) {
		char[] chars = paths.toCharArray();
		for (int i = chars.length - 1; i > -1; i--) {
			if (chars[i] == '/') {
				int newPathLength = paths.length()-i-1;
				char[] subPathChars = new char[newPathLength];
				System.arraycopy(chars, i+1, subPathChars, 0, subPathChars.length);
				return new String(subPathChars);
			}
		}
		return null;
	}

}
