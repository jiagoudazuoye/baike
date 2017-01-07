<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-md-4">
		<img alt="互动百科系统" src="${pageContext.request.contextPath}/static/images/logo.png">
	</div>
	<div class="col-md-8">

		<div class="row">
			<div class="col-sm-10">
				<div style="background-color: red"></div>
			</div>


		<c:choose>
			<c:when test="${user==null}">
				<div class="col-sm-2" style="margin-top: 10px;margin-bottom: 10px">
					<li style="float: right"><a href=""> 注册 </a></li>
					<li style="float: right">&nbsp; | &nbsp;</li>
					<li style="float: right"><a href=""> 登陆 </a></li>
				</div>
			</c:when>
			<c:otherwise>
				<div class="col-sm-2" style="margin-top: 10px;margin-bottom: 10px">
					<li style="float: right"><a href="">注销账号</a></li>
					<li style="float: right">&nbsp; | &nbsp;</li>
					<li style="float: right"><a href="" target="_blank">${user.userName}</a></li>
				</div>
				<%--个人中心--%>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</div>