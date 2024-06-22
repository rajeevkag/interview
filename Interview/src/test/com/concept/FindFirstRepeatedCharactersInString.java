package test.com.concept;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatedCharactersInString {
	public static void main(String[] args) {
		String inputString = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();

		String secondRepeated = Arrays.stream(inputString.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).skip(1)
				.findFirst().get();
				
		//System.out.println(secondRepeated);
		
		String lastSecondRepeated = Arrays.stream(inputString.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey())
				.sorted(Comparator.reverseOrder()).peek(System.out::print)
				.findFirst().get();
		
		System.out.println(lastSecondRepeated);

		Map<String, Long> charCountMap = Arrays.stream(inputString.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		String firstRepeatedChar = charCountMap.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.map(entry -> entry.getKey()).findFirst().get();

		//System.out.println(firstRepeatedChar);
	}
}