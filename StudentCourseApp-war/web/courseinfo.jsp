<%@page import="com.joseph.model.Course"%>
<%@page import="java.util.List"%>

<%
    Course course = (Course) request.getAttribute("course");
    List<Course> allCourses =
            (List<Course>) request.getAttribute("allCourses");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Information</title>
</head>
<body>

    <h1>Course Information</h1>

    <form action="CourseServlet" method="post">

        <table>

            <tr>
                <td>Course ID:</td>
                <td>
                    <input type="text"
                           name="courseId"
                           value="<%= course != null
                                   ? course.getCourseId() : "" %>">
                </td>
            </tr>

            <tr>
                <td>Course Code:</td>
                <td>
                    <input type="text"
                           name="courseCode"
                           value="<%= course != null
                                   && course.getCourseCode() != null
                                   ? course.getCourseCode() : "" %>">
                </td>
            </tr>

            <tr>
                <td>Course Name:</td>
                <td>
                    <input type="text"
                           name="courseName"
                           value="<%= course != null
                                   && course.getCourseName() != null
                                   ? course.getCourseName() : "" %>">
                </td>
            </tr>

            <tr>
                <td>Number of Credits:</td>
                <td>
                    <input type="text"
                           name="numberOfCredits"
                           value="<%= course != null
                                   ? course.getNumberOfCredits() : "" %>">
                </td>
            </tr>

            <tr>
                <td>Semester:</td>
                <td>
                    <input type="text"
                           name="semester"
                           value="<%= course != null
                                   && course.getSemester() != null
                                   ? course.getSemester() : "" %>">
                </td>
            </tr>

            <tr>
                <td>Number of Admitted Students:</td>
                <td>
                    <input type="text"
                           name="numberOfAdmittedStudents"
                           value="<%= course != null
                                   ? course.getNumberOfAdmittedStudents()
                                   : "" %>">
                </td>
            </tr>

        </table>

        <br>

        <input type="submit" name="action" value="Add">
        <input type="submit" name="action" value="Edit">
        <input type="submit" name="action" value="Delete">
        <input type="submit" name="action" value="Search">

    </form>

    <hr>

    <h2>All Courses</h2>

    <table border="1">

        <tr>
            <th>Course ID</th>
            <th>Course Code</th>
            <th>Course Name</th>
            <th>Credits</th>
            <th>Semester</th>
            <th>Admitted Students</th>
        </tr>

        <%
            if (allCourses != null) {
                for (Course c : allCourses) {
        %>

        <tr>
            <td><%= c.getCourseId() %></td>
            <td><%= c.getCourseCode() %></td>
            <td><%= c.getCourseName() %></td>
            <td><%= c.getNumberOfCredits() %></td>
            <td><%= c.getSemester() %></td>
            <td><%= c.getNumberOfAdmittedStudents() %></td>
        </tr>

        <%
                }
            }
        %>

    </table>

</body>
</html>
