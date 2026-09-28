package com.joseph.dao;

import com.joseph.model.Course;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CourseDaoLocal {

    void addCourse(Course course);

    void editCourse(Course course);

    void deleteCourse(int courseId);

    Course getCourse(int courseId);

    List<Course> getAllCourses();
}

