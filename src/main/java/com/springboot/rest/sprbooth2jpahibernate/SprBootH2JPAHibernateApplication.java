package com.springboot.rest.sprbooth2jpahibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.rest.sprbooth2jpahibernate.student.Student;
import com.springboot.rest.sprbooth2jpahibernate.student.StudentRepository;

@SpringBootApplication
public class SprBootH2JPAHibernateApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SprBootH2JPAHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Student id 10001 -> {}", repository.findById(10001L));
		
		logger.info("All users 1 -> {}", repository.findAll());

		logger.info("Inserting -> {}", repository.save(new Student(10002L, "Louis", "A12546579")));		

		logger.info("Update 10001-> {}", repository.save(new Student(10001L, "Dan", "T12889871")));		

		logger.info("All users (after update and addition) -> {}", repository.findAll());
	}
}
