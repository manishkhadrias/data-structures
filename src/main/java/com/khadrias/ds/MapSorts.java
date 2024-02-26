package com.khadrias.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapSorts {

	public static void main(String[] args) {
		Map<String, Integer> wordCount = new HashMap<>();
		wordCount.put("manish", 6);
		wordCount.put("rajesh", 9);
		wordCount.put("hitesh", 5);
		wordCount.put("sam", 8);

		List<Entry<String, Integer>> entires = new ArrayList<>(wordCount.entrySet());

//		entires.stream().sorted((e1, e2) -> e1.getValue() - e2.getValue())
//				.forEach(e -> System.out.println(e.getKey() + e.getValue()));
//
//		entires.stream().sorted((e1, e2) -> e2.getValue() - e1.getValue())
//				.forEach(e -> System.out.println(e.getKey() + e.getValue()));

		wordCount.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.forEach(e -> System.out.println(e.getKey() + e.getValue()));

		wordCount.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEach(e -> System.out.println(e.getKey() + e.getValue()));

		
		wordCount = wordCount.entrySet().stream().sorted((Map.Entry.comparingByValue(Collections.reverseOrder())))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		
		System.out.println(wordCount);
		
//		wordCount = wordCount.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
//						LinkedHashMap::new));
//		
//		System.out.println(wordCount);
//
//		Collections.sort(entires, (e1, e2) -> e1.getValue() - e2.getValue());
//
//		entires.forEach(e -> System.out.println(e.getKey() + e.getValue()));
//
//		Collections.sort(entires, (e1, e2) -> e2.getValue() - e1.getValue());
//
//		entires.forEach(e -> System.out.println(e.getKey() + e.getValue()));

	}

}
