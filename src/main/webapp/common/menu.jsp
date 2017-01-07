<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function checkData(){
		var q=document.getElementById("q").value.trim();
		if(q==null || q==""){
			alert("请输入您要查询的关键字！");
			return false;
		}else{
			return true;
		}
	}
</script>
<div class="row">
	<div class="col-md-12" style="padding-top: 10px">
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar">11</span>
		        <span class="icon-bar">22</span>
		        <span class="icon-bar">33</span>
		      </button>
		      <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"><font color="black"><strong>首页</strong></font></a>
		    </div>

		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
		      <ul class="nav navbar-nav">
		        <li><a href="${pageContext.request.contextPath}/classify.html"><font color="black"><strong>分类</strong></font></a></li>
		        <li><a href="${pageContext.request.contextPath}/download.html"><font color="black"><strong>特色百科</strong></font></a></li>
				  <li><a href="${pageContext.request.contextPath}/download.html"><font color="black"><strong>用户</strong></font></a></li>
				  <li><a href="${pageContext.request.contextPath}/download.html"><font color="black"><strong>权威合作</strong></font></a></li>
				  <li><a href="${pageContext.request.contextPath}/download.html"><font color="black"><strong>手机百科</strong></font></a></li>
				  <%--<li style="float: right">&nbsp; | &nbsp;</li>--%>
		      </ul>
		      <form action="${pageContext.request.contextPath}/blog/q.html" class="navbar-form navbar-right" role="search" method="post" onsubmit="return checkData()">
		        <div class="form-group" >
		          <input type="text" id="q" name="q" value="${q }" class="form-control" placeholder="请输入要查询的关键字...">
		        </div>
		        <button type="submit" id="search" class="btn btn-default">搜索词条</button>
				  <button id="enterEntry" class="btn btn-default">进入词条</button>
		      </form>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	</div>
</div>