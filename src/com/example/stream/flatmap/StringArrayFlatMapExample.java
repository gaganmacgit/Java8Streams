package com.example.stream.flatmap;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringArrayFlatMapExample {

	String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
	private Stream<String[]> filterStream;
	
	public StringArrayFlatMapExample() {
		consumeDataFromStringArrayWOFlatmap(data);
		consumeDataFromStringArrayWithFlatmap(data);
	}

	private void consumeDataFromStringArrayWithFlatmap(String[][] data) {

		Stream<String[]> stringArrayStream = Arrays.stream(data);
		Stream<String> flatMapStream = stringArrayStream.flatMap(strArrEle -> Arrays.stream(strArrEle));
		Stream<String> filteredStream = flatMapStream.filter(x -> "a".equals(x));
		filteredStream.forEach(System.out::println);
		
	}

	@SuppressWarnings("unlikely-arg-type")
	private void consumeDataFromStringArrayWOFlatmap(String[][] arr) {
		
		Stream<String[]> stringArrStream = Arrays.stream(arr);
		
		filterStream = stringArrStream.filter(x -> "a".equals(x));
		filterStream.forEach(item -> System.out.println(item));
		
	}

	public static void main(String[] args) {
		new StringArrayFlatMapExample();
	}

}
