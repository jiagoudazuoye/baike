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
		var ue = UE.getEditor('editor');

		//        提交
		function submitData(){
//			var templateName=$("#templateName").val();
			var entryId = ${entry.entryId};
			var content = $('#content').val();
			if(content==null || content==''){
				alert("请输入内容！");
			}else{
				$.post("${pageContext.request.contextPath}/comment/save",{'entryId':entryId,'content':content},function(result){
					if(result.success){
						alert("评论成功！");
						location.reload();
					}else{
						alert("评论失败！");
						alert(result.errorInfo);
					}
				},"json");
			}
		}
		//        应用模版
		function UseTemplate(obj){

//            alert(obj.Id);
			//通过ajax请求数据
			UE.ajax.request("${pageContext.request.contextPath}/template/findById",
					{
						method:"post",
						async : false,
						data:{"templateId":obj.id},
						onsuccess:function(result){
							result = eval("(" + result.responseText + ")");
//                            $("#title").val(result.title);
//                            $("#keyWord").val(result.keyWord);
//                            $("#blogTypeId").combobox("setValue",result.blogType.id);
							UE.getEditor('editor').setContent(result.content);
						}
					}
			);
		}
	</script>
</head>
<body>

<div class="container">
	<jsp:include page="/common/head.jsp"/>
	<jsp:include page="/common/menu.jsp"/>
	<div class="row">
		<div class="col-md-9">
			<font style="font-size: 30px;align:center"><strong>${entry.entryName}</strong></font>
			<div style="margin-top:20px;
	padding-bottom: 30px;">
				${entry.content}
			</div>
			<div style="margin-top:20px;
	padding-bottom: 30px;
	padding-left: 30px;color: black;
	font-style: italic;">
				<font><strong>关键字：</strong></font>

			<c:choose>
				<c:when test="${keyWords==null}">
					&nbsp;&nbsp;无
				</c:when>
				<c:otherwise>
					<c:forEach var="keyWord" items="${keyWords }">
						&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/entry/searchByKey?key=${keyWord}" target="_blank">${keyWord }</a>&nbsp;&nbsp;
					</c:forEach>
				</c:otherwise>
			</c:choose>
			</div>

			<div class="data_list">
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/comment_icon.png"/>
					评论信息
				</div>
				<div class="commentDatas">
					<c:choose>
						<c:when test="${commentList.size()==0}">
							暂无评论
						</c:when>
						<c:otherwise>
							<c:forEach var="comment" items="${commentList }" varStatus="status">
								<c:choose>
									<c:when test="${status.index<10 }">
										<div class="comment">
											<span><font>${status.index+1 }楼&nbsp;&nbsp;&nbsp;&nbsp;${comment.userId }：</font>${comment.content }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;<fmt:formatDate value="${comment.commentTime }" type="date" pattern="yyyy-MM-dd HH:mm"/>&nbsp;]</span>
										</div>
									</c:when>
									<c:otherwise>
										<div class="otherComment">
											<div class="comment">
												<span><font>${status.index+1 }楼&nbsp;&nbsp;&nbsp;&nbsp;${comment.userId }：</font>${comment.content }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[&nbsp;<fmt:formatDate value="${comment.commentTime }" type="date" pattern="yyyy-MM-dd HH:mm"/>&nbsp;]</span>
											</div>
										</div>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<div class="data_list" >
				<div class="data_list_title">
					<img src="${pageContext.request.contextPath}/static/images/publish_comment_icon.png"/>
					发表评论
				</div>
				<div class="publish_comment">
					<div>
						<textarea style="width: 100%" rows="3" id="content" name="content" placeholder="来说两句吧..."></textarea>
					</div>
					<div class="publishButton">
						<button class="btn btn-primary" type="button" onclick="submitData()">发表评论</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-md-3" style="font-size: 15px;font-weight: bold;border-bottom: 1px solid #E5E5E5;padding-bottom: 10px;padding-top: 5px;">
		</div>
	</div>

</div>

<jsp:include page="/common/foot.jsp"/>
</div>
</body>
</html>
