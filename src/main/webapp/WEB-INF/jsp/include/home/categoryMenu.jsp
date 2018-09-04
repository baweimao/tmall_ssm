<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="categoryMenu">
	<c:forEach items="${cs}" var="c">
		<div cid="${c.id}" class="eachCategory">
			<span class="glyphicon glyphicon-link">
				<a href="forecategory?cid=${c.id}">${c.name}</a>
			</span>
		</div>
	</c:forEach>
</div>