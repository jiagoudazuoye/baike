<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${entry.entryName}_baike</title>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
	<script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">

	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js"> </script>

	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/lang/zh-cn/zh-cn.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/my.css">
<script type="text/javascript">


	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue = UE.getEditor('editor');
	var content = '${entry.content}';
	ue.addListener("ready",function(){

		UE.getEditor('editor').setContent(content);
	});
	function submitData(){
		var keyword = $("#keyword").val();
		var entryId = '${entry.entryId}';
//		alert(entryId);
			$.post("${pageContext.request.contextPath}/entry/edit",{'entryId':entryId,'content':content,'keyword':keyword},function(result){
				if(result.success){
					alert("词条修改成功！");
					var url = "/entry/"+entryId;
					window.location(url);
//					resetValue();
				}else{
					alert("词条提交失败！");
				}
			},"json");
	}
</script>

</head>
<body>

	<div class="container">
		<jsp:include page="/common/head.jsp"/>
		<jsp:include page="/common/menu.jsp"/>
			<div class="row">
				<div class="col-md-9">

					<br>
					<div class="row">
						<table>
							<tr>
								<td class="col-md-1" valign="top">&nbsp;内&nbsp;容：</td>
								<td class="col-md-11">
									<script id="editor" type="text/plain" style="width:100%;height:500px;"></script>
								</td>
							</tr>
						</table>


					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">关键字</span>
						<input  id="keyword" type="text" value="${entry.keyword}" class="form-control" placeholder="请输入关键字，如有多个请用空格分开">
					</div>
					<button class="btn btn-primary" style="float: right" type="button" onclick="submitData()">提交</button>
				</div>
				<div class="col-md-3" style="font-size: 15px;font-weight: bold;border-bottom: 1px solid #E5E5E5;padding-bottom: 10px;padding-top: 5px;">
					<div>
						<div style="font-size: 20px;font-weight: bold;border-bottom: 1px solid #E5E5E5;padding-bottom: 10px;padding-top: 5px;">
							<%--<img src="${pageContext.request.contextPath}/static/images/byType_icon.png"/>--%>
							模版
						</div>
						<div class="datas" >
							<ul>
								<c:forEach var="t" items="${templateList }">
									<li style="margin: 2px;">${t.templateName }
										<button class="btn btn-primary btn-xs" id="${t.templateId}" type="button"  onclick="UseTemplate(this)">应用</button>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>

	</div>
	<jsp:include page="/common/foot.jsp"/>
</body>



		<%----%>
		<%--<form>--%>
			<%--<table>--%>

				<%--<tr>--%>
					<%--<td>--%>
						<%--<script id="editor"  type="text/plain" style="width:95%;height:400px;"></script>--%>
					<%--</td>--%>
				<%--</tr>--%>
				<%--<tr>--%>
					<%--<td></td>--%>
					<%--<td>--%>
						<%--<div style="text-align: right">--%>
							<%--<button  class ="btn btn-primary" style="margin-right: 50px" value="提交" onclick="getContent()">提交</button>--%>
						<%--</div>--%>
					<%--</td>--%>
				<%--</tr>--%>
			<%--</table>--%>
		<%--</form>--%>
	<%--</div>--%>
<%--</body>--%>

