package com.example.spring_homework002.repository;

import com.example.spring_homework002.model.Student;
import com.example.spring_homework002.model.dto.request.StudentRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("""
        SELECT * FROM student
    """)
    @Results(id = "studentMapping", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id", many = @Many(select = "com.example.spring_homework002.repository.CourseRepository.findCoursesByStudentId"))
    })
    List<Student> getAllStudent();

    @Select("""
        SELECT * FROM student WHERE student_id = #{id}
    """)
    @ResultMap("studentMapping")
    Student getStudentById(Integer id);

    @Select("""
        DELETE FROM student WHERE student_id = #{studentId}
    """)
    @ResultMap("studentMapping")
    Student deleteStudentById(Integer studentId);

    @Select("""
        INSERT INTO student (student_name, email, phone_number)
        VALUES (#{student.studentName}, #{student.email}, #{student.phoneNumber})
        RETURNING *;
    """)
    @ResultMap("studentMapping")
    Student insertStudent(@Param("student") StudentRequest studentRequest);

    @Insert("""
        INSERT INTO student_course (student_id, course_id)
        VALUES (#{studentId}, #{courseId});
    """)
    void insertIntoStudentCourse(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

    @Select("""
        UPDATE student
        SET student_name = #{student.studentName}, email = #{student.email}, phone_number = #{student.phoneNumber}
        WHERE student_id = #{id}
        RETURNING *;
    """)
    Student updateStudentById(Integer id, @Param("student") StudentRequest studentRequest);

    @Update("""
        UPDATE student_course
        SET course_id = #{courseId}
        WHERE student_id = #{studentId}
    """)
    void updateIntoStudentCourse(Integer studentId, Integer courseId);
}
