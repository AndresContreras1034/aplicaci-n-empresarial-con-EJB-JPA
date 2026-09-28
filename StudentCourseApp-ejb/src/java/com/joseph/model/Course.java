package com.joseph.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "Course.getAll", query = "SELECT c FROM Course c")
})
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int courseId;

    @Column
    private String courseCode;

    @Column
    private String courseName;

    @Column
    private int numberOfCredits;

    @Column
    private String semester;

    @Column
    private int numberOfAdmittedStudents;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<Student>();

    public Course() {
    }

    public Course(int courseId, String courseCode, String courseName,
                  int numberOfCredits, String semester,
                  int numberOfAdmittedStudents) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.numberOfCredits = numberOfCredits;
        this.semester = semester;
        this.numberOfAdmittedStudents = numberOfAdmittedStudents;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getNumberOfAdmittedStudents() {
        return numberOfAdmittedStudents;
    }

    public void setNumberOfAdmittedStudents(int numberOfAdmittedStudents) {
        this.numberOfAdmittedStudents = numberOfAdmittedStudents;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

