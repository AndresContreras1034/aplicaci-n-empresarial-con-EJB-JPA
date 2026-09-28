<%@page import="com.joseph.model.Student"%>
<%@page import="java.util.List"%>

<%
    Student student = (Student) request.getAttribute("student");
    List<Student> allStudents = (List<Student>) request.getAttribute("allStudents");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information</title>
</head>
<body>

    <h1>Student Information</h1>

    <form action="StudentServlet" method="post">

        <table>
            <tr>
                <td>Student ID:</td>
                <td>
                    <input type="text"
                           name="studentId"
                           value="<%= student != null ? student.getStudentId() : "" %>">
                </td>
            </tr>

            <tr>
                <td>First Name:</td>
                <td>
                    <input type="text"
                           name="firstname"
                           value="<%= student != null && student.getFirstname() != null
                                   ? student.getFirstname() : "" %>">
                </td>
            </tr>

            <tr>
                <td>Last Name:</td>
                <td>
                    <input type="text"
                           name="lastname"
                           value="<%= student != null && student.getLastname() != null
                                   ? student.getLastname() : "" %>">
                </td>
            </tr>

            <tr>
                <td>Year Level:</td>
                <td>
                    <input type="text"
                           name="yearLevel"
                           value="<%= student != null ? student.getYearLevel() : "" %>">
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

    <h2>All Students</h2>

    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
        </tr>

        <%
            if (allStudents != null) {
                for (Student s : allStudents) {
        %>

        <tr>
            <td><%= s.getStudentId() %></td>
            <td><%= s.getFirstname() %></td>
            <td><%= s.getLastname() %></td>
            <td><%= s.getYearLevel() %></td>
        </tr>

        <%
                }
            }
        %>

    </table>

</body>
</html>