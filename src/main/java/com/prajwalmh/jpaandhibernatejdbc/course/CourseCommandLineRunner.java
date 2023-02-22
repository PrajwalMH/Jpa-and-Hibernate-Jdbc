package com.prajwalmh.jpaandhibernatejdbc.course;

import com.prajwalmh.jpaandhibernatejdbc.course.Course;
import com.prajwalmh.jpaandhibernatejdbc.course.jdbc.CourseJdbcRepository;
import com.prajwalmh.jpaandhibernatejdbc.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;


    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception{
        repository.save(new Course(1,"Game of thrones","G R R Martin"));
        repository.save(new Course(2,"Harry Potter","J K Rowling"));
        repository.save(new Course(3,"Edwood","Tim Burton"));
        repository.save(new Course(4,"The Disaster Artist","Tommy Wiseau"));

        repository.deleteById(3l);

        System.out.println(repository.findById(1l));
        System.out.println(repository.findByAuthor("J K Rowling"));
        System.out.println(repository.findByName("Harry Potter"));


    }
}
