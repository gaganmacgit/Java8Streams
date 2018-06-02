package com.example.stream.flatmap;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapToIntExample {

	public FlatMapToIntExample() {
		int[] intArray = { 1, 2, 3, 4, 5, 6 };
		Stream.of(intArray).flatMapToInt(x -> Arrays.stream(x)).forEach(System.out::println);

	}

	public static void main(String[] args) {
		new FlatMapToIntExample();
	}

}
