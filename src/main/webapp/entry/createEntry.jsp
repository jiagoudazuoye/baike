<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>main_baike</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/bootstrap3/css/bootstrap-theme.min.css">
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/jquery-1.11.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/bootstrap3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCore.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/ueditor/third-party/SyntaxHighlighter/shCoreDefault.css">

    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/ueditor.all.min.js"> </script>

    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/ueditor/lang/zh-cn/zh-cn.js"></script>

    <script type="text/javascript">
        var ue = UE.getEditor('editor');

//        提交
        function submitData(){
            var entryName=$("#entryName").val();
            var keyword = $("#keyword").val();
            var content=UE.getEditor('editor').getContent();
            if(entryName==null || entryName==''){
                alert("请输入词条名！");
            }else if(content==null || content==''){
                alert("请输入内容！");
            }else{
                $.post("${pageContext.request.contextPath}/entry/createEntry",{'entryName':entryName,'content':content,'keyword':keyword},function(result){
                    if(result.success){
                        alert("词条提交成功！");
                        window.location("index");
                    }else{
                        alert("词条提交失败！");
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
            <div class="input-group">
                <span class="input-group-addon" style="font-weight: bold">词条名</span>
                <input type="text" id="entryName" class="form-control" placeholder="请输入词条的名称">
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon">关键字</span>
                <input  id="keyword" type="text" class="form-control" placeholder="请输入关键字，如有多个请用空格分开">
            </div>
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


</body>
</html>
