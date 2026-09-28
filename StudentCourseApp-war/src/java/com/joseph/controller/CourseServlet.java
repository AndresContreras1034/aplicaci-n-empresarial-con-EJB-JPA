package com.joseph.controller;

import com.joseph.dao.CourseDaoLocal;
import com.joseph.model.Course;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CourseServlet", urlPatterns = {"/CourseServlet"})
public class CourseServlet extends HttpServlet {

    @EJB
    private CourseDaoLocal courseDao;

    protected void processRequest(HttpServletRequest request,
                                   HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        String courseIdStr = request.getParameter("courseId");
        int courseId = 0;

        if (courseIdStr != null && !courseIdStr.equals("")) {
            courseId = Integer.parseInt(courseIdStr);
        }

        String courseCode = request.getParameter("courseCode");
        String courseName = request.getParameter("courseName");
        String semester = request.getParameter("semester");

        String numberOfCreditsStr =
                request.getParameter("numberOfCredits");
        int numberOfCredits = 0;

        if (numberOfCreditsStr != null
                && !numberOfCreditsStr.equals("")) {
            numberOfCredits = Integer.parseInt(numberOfCreditsStr);
        }

        String numberOfAdmittedStudentsStr =
                request.getParameter("numberOfAdmittedStudents");
        int numberOfAdmittedStudents = 0;

        if (numberOfAdmittedStudentsStr != null
                && !numberOfAdmittedStudentsStr.equals("")) {
            numberOfAdmittedStudents =
                    Integer.parseInt(numberOfAdmittedStudentsStr);
        }

        Course course = new Course(
                courseId,
                courseCode,
                courseName,
                numberOfCredits,
                semester,
                numberOfAdmittedStudents
        );

        if ("Add".equalsIgnoreCase(action)) {

            courseDao.addCourse(course);

        } else if ("Edit".equalsIgnoreCase(action)) {

            courseDao.editCourse(course);

        } else if ("Delete".equalsIgnoreCase(action)) {

            courseDao.deleteCourse(courseId);

        } else if ("Search".equalsIgnoreCase(action)) {

            course = courseDao.getCourse(courseId);
        }

        request.setAttribute("course", course);
        request.setAttribute("allCourses", courseDao.getAllCourses());

        request.getRequestDispatcher("courseinfo.jsp")
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Course Servlet";
    }
}


