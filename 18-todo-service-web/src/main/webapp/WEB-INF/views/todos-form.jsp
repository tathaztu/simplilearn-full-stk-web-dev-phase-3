<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>Save Todo</title>
    
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-todo-style.css">
    
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1>Todos App.</h1>
    </div>
</div>


<div id="container">
	<h3>Save Todo</h3>
	<form:form action="saveTodos" modelAttribute="todos" method="post">
		<form:hidden path="id"/>
		<table>
			<tbody>
				<tr>
					<td><label>Description</label></td>
					<td><form:input path="description"/></td>
				</tr>
				<tr>
					<td><label>Target Date</label></td>
					<fmt:formatDate value="${todos.targetDate}" var="dates" pattern="MM/dd/yyyy"/>
					<td><form:input path="targetDate" value=""/></td>
				</tr>
				<tr>
					<td><label>Is Done</label></td>
					<td><form:input path="done"/></td>
				</tr>
				<tr>
					<td colspan="2"> <input type="submit" value="Save" class="save"/></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</div>
<div style="clear; both;"></div>
<a href="${pageContext.request.contextPath}/users/todos">Back to List</a>
</body>
</html>