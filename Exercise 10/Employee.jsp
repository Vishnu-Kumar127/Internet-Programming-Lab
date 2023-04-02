<%-- 
    Document   : Employee
    Created on : Mar 27, 2023, 9:42:53 AM
    Author     : 21cse127
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Exercise_10.Employee" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Details</title>
        <style>
            table,th,td
            {
                border: 1px solid black;
            }
           
        </style>
    </head>
    <body>        
        
      

<%
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("Dinesh", "IT", 75000.0, new Date()));
    employees.add(new Employee("Vishnu Kumar", "HR", 105000.0, new Date()));
    employees.add(new Employee("Vikram Ganesh", "Finance", 95000.0, new Date()));
    employees.add(new Employee("Arun Kumar", "Developer", 85000.0, new Date()));
    Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
%>

<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Hire Date</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${employees}" var="employee">
            <tr style="${employee.salary > 100000 ? 'background-color: yellow;' : ''}">
                <td>${employee.name}</td>
                <td>${employee.department}</td>
                <td><fmt:formatNumber value="${employee.salary}" type="currency" /></td>
                <td><fmt:formatDate value="${employee.hireDate}" pattern="MM/dd/yyyy" /></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
  
    </body>
</html>