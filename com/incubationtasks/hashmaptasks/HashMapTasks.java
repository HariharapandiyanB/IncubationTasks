package com.incubationtasks.hashmaptasks;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import utilities.InvalidInputException;
import utilities.UtilityTasks;

public class HashMapTasks {
	
	public <K,V> Map<K,V> createHashMap() {
		Map<K,V> maps=new HashMap<>();
		return maps;
	}
	
	public <K,V>int getSize(Map<K,V> maps) throws InvalidInputException {
		UtilityTasks.checkNull(maps);
		return maps.size();
	}
	
	public <K,V> Map<K,V> addPair(Map<K,V> maps,K key,V value) throws InvalidInputException{
		UtilityTasks.checkNull(maps);
		maps.put(key, value);
		return maps;
		}
	
	
	public <K,V> boolean checkKey(Map<K,V> maps, K key) throws InvalidInputException{
		UtilityTasks.checkNull(maps);
		return maps.containsKey(key);
	}
	
	public <K,V> boolean checkValue(Map<K,V> maps, V value) throws InvalidInputException{
		UtilityTasks.checkNull(maps);
		return maps.containsValue(value);
	}
	

	public <K,V> Map<K,V> replaceValue(Map<K,V> maps,K key, V value) throws InvalidInputException{
		UtilityTasks.checkNull(maps);
		maps.replace(key,value);
		return maps;
	}
	
	public <K,V> V getValue(Map<K,V> maps, K key) throws InvalidInputException{
		UtilityTasks.checkNull(maps);
		return maps.get(key);
	}
	
	public <K,V> Map<K,V> nonExistingKey(Map<K,V> maps,K key, V value) throws InvalidInputException{
		UtilityTasks.checkNull(maps);
		maps.getOrDefault(key, value);
		return maps;
	}
	
	public <K,V> Map<K,V> removeKey(Map<K,V> maps,K key) throws InvalidInputException{
		UtilityTasks.checkNull(maps);
		maps.remove(key);
		return maps;
	}
	
	public <K,V> Map<K,V> removePair(Map<K,V> maps, K key, V value) throws InvalidInputException{
		
		UtilityTasks.checkNull(maps);
		maps.remove(key, value);
		return maps;
	}
	
	public <K,V> Map<K,V> replacePair(Map<K,V> maps, K key, V oldValue, V newValue) throws InvalidInputException{
		UtilityTasks.checkNull(maps);
		maps.replace(key, oldValue, newValue);
		return maps;
	}
	
	public <K,V> Map<K,V> addEveryElements(Map<K,V> primaryMaps,Map<K,V> secondaryMaps) throws InvalidInputException{
		UtilityTasks.checkNull(primaryMaps);
		UtilityTasks.checkNull(secondaryMaps);
		primaryMaps.putAll(secondaryMaps);
		return primaryMaps;
	}
	
	public <K,V> void sequencePrint(Map<K,V> maps) throws InvalidInputException{
		UtilityTasks.checkNull(maps);
		Set<Map.Entry<K,V>>set=maps.entrySet();
		for(Map.Entry<K,V> entry:set) {
			System.out.println(entry.getKey());
			System.out.print(" = "+entry.getValue());
		}
	}
		
	public <K,V> Map<K,V> clearAllPairs(Map<K,V> maps) throws InvalidInputException{
		UtilityTasks.checkNull(maps);
		maps.clear();
		return maps;
	}
}
