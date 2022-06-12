<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title> List Todos </title>
    
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1> List Todos </h1>
    </div>
</div>
<div id="container">
    <div id="content">
    	<input type="button" value="Add Todo" onclick="window.location.href='/users/todos/showFormForAdd'; return false;" class="addButton">
        <table>
            <tr>
                <th>Description</th>
                <th>Date</th>
                <th> Is Done ? </th>
                <th/>
            </tr>
            
            <c:forEach var="tempTodo" items="${todos}"> 
            
            	<c:url var="updateLink" value="/users/todos/showFormForUpdate">
            		<c:param name="todoId" value="${tempTodo.id}"/>
            	</c:url>

            	<c:url var="deleteLink" value="/users/todos/delete">
            		<c:param name="todoId" value="${tempTodo.id}"/>
            	</c:url>
	            
	            <tr>
	                <td>${tempTodo.description}</td>
	                <td><fmt:formatDate type="date" value="${tempTodo.targetDate}"/></td>
	                <td>${tempTodo.done}</td>
	                <td>
	                	<a href="${updateLink}">Update</a>
	                	|
	                	<a href="${deleteLink}" 
	                		onclick="if(!confirm('Are you sure you want to Delete this Todo?')) {return false;}">Delete</a>
	                </td>
	            </tr>
            </c:forEach>
        </table>
        
        
    </div>
</div>
</body>
</html>