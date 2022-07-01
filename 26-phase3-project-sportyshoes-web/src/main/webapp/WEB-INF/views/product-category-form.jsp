<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>Save Product Category</title>
    
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-todo-style.css">
    
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h1>Product Category App.</h1>
    </div>
</div>


<div id="container">
	<h3>"${pageHeader}"</h3>
	<form:form action="save" modelAttribute="productCategory" method="post">
		<%-- <form:hidden path="id"/> --%>
		<table>
			<tbody>
				<tr>
					<td><label>Category Name</label></td>
					<td><form:input path="strCategoryName"/></td>
				</tr>
				<tr>
					<td colspan="2"> <input type="submit" value="Save" class="save"/></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</div>
<div style="clear; both;"></div>
<a href="${pageContext.request.contextPath}/productcategory/list">Back to List</a>
</body>
</html>