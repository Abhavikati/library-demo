package com.book.bookdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BookdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookdemoApplication.class, args);

		//this was to test lombok
		//Student student = new Student(1,"bob");
		//System.out.println(student.getId());
		//System.out.println(student.getName());



	}

}
