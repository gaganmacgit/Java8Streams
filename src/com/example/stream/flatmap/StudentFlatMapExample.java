package com.example.stream.flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.model.Student;

public class StudentFlatMapExample {

	public StudentFlatMapExample() {
		createStudentsWithBooks();
	}

	private void createStudentsWithBooks() {
		final Student studentObject1 = new Student();
		studentObject1.setName("mkyong");
		studentObject1.addBook("Java 8 in Action");
		studentObject1.addBook("Spring Boot in Action");
		studentObject1.addBook("Effective Java (2nd Edition)");

		final Student studentObject2 = new Student();
		studentObject2.setName("zilap");
		studentObject2.addBook("Learning Python, 5th Edition");
		studentObject2.addBook("Effective Java (2nd Edition)");

		final List<Student> studentList = new ArrayList<>();
		studentList.add(studentObject1);
		studentList.add(studentObject2);

		final List<String> listOfDistinctBooks = studentList.stream().map(currStudent -> currStudent.getBook())
				.flatMap(books -> books.stream()).distinct().collect(Collectors.toList());
		listOfDistinctBooks.forEach(System.out::println);

	}

	public static void main(final String[] args) {
		new StudentFlatMapExample();
	}
}
