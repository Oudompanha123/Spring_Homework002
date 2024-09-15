package com.example.spring_homework002.repository;

import com.example.spring_homework002.model.Course;
import com.example.spring_homework002.model.dto.request.CourseRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("""
        SELECT c.* FROM course c
    """)
    @Results(id = "courseMapping", value = {
            @Result (property = "courseId", column = "course_id"),
            @Result (property = "courseName", column = "course_name"),
            @Result (property = "instructor", column = "instructor_id", one = @One (select = "com.example.spring_homework002.repository.InstructorRepository.getInstructorById")),
    })
    List<Course> findAll();


    @Select("""
        SELECT c.* FROM course c WHERE c.course_id = #{id}
    """)
    @ResultMap("courseMapping")
    Course findById(Integer id);

    @Delete("""
        DELETE FROM course c WHERE c.course_id = #{id}
    """)
    void deleteCourseById(Integer id);

    @Select("""
        INSERT INTO public.course (course_name, description, instructor_id)
        VALUES (#{course.courseName}, #{course.description}, #{course.instructorId})
        RETURNING *;
    """)
    @ResultMap("courseMapping")
    Course addCourse(@Param("course") CourseRequest courseRequest);

    @Select("""
        UPDATE public.course SET course_name = #{course.courseName}, description = #{course.description}
        WHERE course_id = #{id}
        RETURNING *;
    """)
    @ResultMap("courseMapping")
    Course updateCourseById(Integer id, @Param("course") CourseRequest courseRequest);

    @Select("""
        SELECT *
        FROM course c
        JOIN student_course sc ON c.course_id = sc.course_id
        WHERE sc.student_id = #{studentId};
    """)
    @ResultMap("courseMapping")
    List<Course> findCoursesByStudentId(Integer studentId);
}
