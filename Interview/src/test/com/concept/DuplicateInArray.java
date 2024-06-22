package test.com.concept;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateInArray {
	public static void main(String[] args) {
		List<Integer> listOfIntegers = List.of(111, 222, 333, 111, 555, 333, 777, 222);

		HashSet<Integer> hasSet = new HashSet<>();

		Map<Integer, Integer> map = listOfIntegers.stream().filter(value -> !hasSet.add(value))
				.collect(Collectors.toMap(Integer::intValue, Integer::intValue));

		System.out.println(map);

		Set<Integer> uniqueElements = new HashSet<>();

		Set<Integer> duplicateElements = listOfIntegers.stream().filter(i -> !uniqueElements.add(i))
				.collect(Collectors.toSet());

		System.out.println(duplicateElements);
	}
}