package moderate;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 16.2 find the frequency of occurrences of any given word in a book.
 * What if we were running this algorithm multiple times?
 * */
public class WordFrequencies {

	static HashMap<String, Integer> table = new HashMap<>();
	
	public static void main(String[] args) {
		
	//	String word = "because";
		
		table = buildTable(args);
		
		// sort by map-value using java 8
		Map<Object, Object> mappedTable = table.entrySet().stream()
							//.sorted(Map.Entry.comparingByValue())
							.sorted(Collections.reverseOrder(Comparator.comparing(Map.Entry::getValue)))
							.collect(Collectors.toMap(k -> k.getKey(),
										v -> v.getValue(),
										(k, v)-> k, LinkedHashMap::new));
		
		mappedTable.forEach((k, v) -> System.out.println(k+ "->"+ v));		
	}

	private static HashMap<String, Integer> buildTable(String[] args) {
		for(String w : args) {
			w =  w.toLowerCase().trim();
			//int freq = getFrequencyCount(args, w);
	
			table.put(w, table.getOrDefault(w, 0)+1);
			
			/*
			  if(table.containsKey(w)) { 
				  int val = table.get(w); 
				  table.put(w, val + 1);
			  } else { 
				  table.put(w, 1); 
			  }
			 */
		}
		return table;
	}

	/**
	private static int getFrequencyCount(String[] book, String word) {		
		int count = 0;
		for(String w : book) {
			if(w.toLowerCase().trim().equals(word)) {
				count++;
			}
		}
		
		return count;
	}
	*/
}
