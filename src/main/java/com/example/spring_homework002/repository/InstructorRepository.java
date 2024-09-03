package com.example.spring_homework002.repository;

import com.example.spring_homework002.model.Instructor;
import com.example.spring_homework002.model.dto.request.InstructorRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

@Mapper
public interface InstructorRepository {
    @Select("""
        SELECT * FROM instructor;
    """)
    @Results(id = "instructorMapping", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
    })
    List<Instructor> getAllInstructors();

    @Select("""
        SELECT * FROM instructor WHERE instructor_id = #{id}
    """)
    @ResultMap("instructorMapping")
    Instructor getInstructorById(Integer id);

    @Select("""
        INSERT INTO instructor (instructor_name, email)
        VALUES (#{instructor.instructorName}, #{instructor.email})
        RETURNING *;
    """)
    @ResultMap("instructorMapping")
    Instructor addInstructor(@Param("instructor") InstructorRequest instructorRequest);

    @Select("""
        DELETE FROM instructor WHERE instructor_id = #{id}
        RETURNING *;
    """)
    @ResultMap("instructorMapping")
    Instructor deleteInstructorById(Integer id);

    @Select("""
        UPDATE instructor
        SET instructor_name = #{instructor.instructorName}, email = #{instructor.email}
        WHERE instructor_id = #{id}
        RETURNING *;
    """)
    @ResultMap("instructorMapping")
    Instructor updateInstructorById(Integer id, @Param("instructor") InstructorRequest instructorRequest);
}
