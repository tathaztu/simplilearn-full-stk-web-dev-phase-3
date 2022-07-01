<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>List Product Categories</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h1>List Product Categories</h1>
    </div>
</div>
<div id="container">
    <div id="content">
    	<input type="button" value="Add Todo" onclick="window.location.href='/productcategory/add'; return false;" class="addButton">
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th/>
            </tr>
            
            <c:forEach var="prodCategory" items="${prodCategories}"> 
            
            	<c:url var="updateLink" value="/productcategory/update">
            		<c:param name="prodCategoryId" value="${prodCategory.longCategoryId}"/>
            	</c:url>
            	<c:url var="deleteLink" value="/productcategory/delete">
            		<c:param name="prodCategoryId" value="${prodCategory.longCategoryId}"/>
            	</c:url>
	            
	            <tr>
	                <td>${prodCategory.longCategoryId}</td>
	                <td>${prodCategory.strCategoryName}</td>
	                <td>
	                	<a href="${updateLink}">Update</a>
	                	|
	                	<a href="${deleteLink}" 
	                		onclick="if(!confirm('Are you sure you want to Delete this Product Category?')) {return false;}">Delete</a>
	                </td>
	            </tr>
            </c:forEach>
        </table>
        
        
    </div>
</div>
</body>
</html>