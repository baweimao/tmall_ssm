<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div>
	<a href="forehome">
	<img style="margin-left: 20px;margin-top: 10px" id="simplelogo" src="img/site/simpleLogo.png" class="simplelogo">
	</a>

	<form action="foresearch" method="post">
		<div class="simpleSearchDiv pull-right">
			<input name="keyword" type="text" placeholder="平衡车 原汁机">
			<button type="submit" class="searchButton">搜天猫</button>
			<div class="searchBelow">
				<c:forEach items="${cs}" var="c" varStatus="st">
					<c:if test="${st.count>=8 and st.count<=11}">
						<span>
							<a href="forecategory?cid=${c.id}">${c.name}</a>
							<if test="${st.count!=11}"><span>|</span></if>
						</span>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</form>
	<div style="clear: both"></div>
</div>