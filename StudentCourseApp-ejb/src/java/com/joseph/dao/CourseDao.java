
package com.joseph.dao;

import com.joseph.model.Course;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CourseDao implements CourseDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addCourse(Course course) {
        em.persist(course);
    }

    @Override
    public void editCourse(Course course) {
        em.merge(course);
    }

    @Override
    public void deleteCourse(int courseId) {
        Course course = getCourse(courseId);

        if (course != null) {
            em.remove(course);
        }
    }

    @Override
    public Course getCourse(int courseId) {
        return em.find(Course.class, courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return em.createNamedQuery("Course.getAll").getResultList();
    }
}
