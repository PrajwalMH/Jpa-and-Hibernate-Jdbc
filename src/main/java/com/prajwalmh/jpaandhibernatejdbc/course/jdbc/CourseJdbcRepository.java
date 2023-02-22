package com.prajwalmh.jpaandhibernatejdbc.course.jdbc;

import com.prajwalmh.jpaandhibernatejdbc.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbc;

    private static String insert_query= """
            insert into course(id,name,author) values(?,?,?);
            """;

    private static String delete_query= """
            delete from course where id=?
            """;

    private static String select_query= """
            select * from course where id=?
            """;

    public void insert(Course course){
        jdbc.update(insert_query,course.getId(),course.getName(),course.getAuthor());
    }


    public void deleteById(long id){
        jdbc.update(delete_query,id);
    }

    public Course findById(long id){
        return jdbc.queryForObject(select_query,new BeanPropertyRowMapper<>(Course.class),id);

    }


}
