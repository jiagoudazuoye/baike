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
</head>
<body>
<div class="container">
    <jsp:include page="/common/head.jsp"/>

    <jsp:include page="/common/menu.jsp"/>

    <div class="row">
        <div class="col-md-9">
            <%--<jsp:include page="${mainPage }"></jsp:include>--%>
            <%--<jsp:include page="/entry/editEntry.jsp"></jsp:include>--%>
                <%--<jsp:include page="${mainPage }"></jsp:include>--%>
                <div class="jumbotron">
                    <h1>欢迎来到互动百科系统!</h1>
                    <p>内容开放、自由的网络百科全书，
                        旨在创造一个涵盖所有领域知识、服务所有互联网用户的中文知识性百科全书</p>
                    <p><a class="btn btn-primary btn-lg" href="#" role="button">了解更多</a></p>
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <img src="${pageContext.request.contextPath}/static/images/240.jpg" alt="240x200">
                            <div class="caption">
                                <h3>Thumbnail label</h3>
                                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <img src="${pageContext.request.contextPath}/static/images/240.jpg"  alt="240x200">
                            <div class="caption">
                                <h3>Thumbnail label</h3>
                                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4">
                        <div class="thumbnail">
                            <img src="${pageContext.request.contextPath}/static/images/240.jpg"  alt="240x200">
                            <div class="caption">
                                <h3>Thumbnail label</h3>
                                <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                            </div>
                        </div>
                    </div>
                </div>

                <ul style="margin: 0px; padding: 30px 0px 30px 30px; float: left; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(235, 235, 235); height: 140px; width: 206px; color: rgb(51, 51, 51); font-family: arial, tahoma, &#39;Microsoft Yahei&#39;, 宋体, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);" class=" list-paddingleft-2">
                    <li>
                        <h2 style="margin: 0px; padding: 0px; font-size: 18px; line-height: 20px; font-weight: 400;">
                            <a href="https://baike.baidu.com/renwu" target="_blank" style="color: rgb(34, 34, 34); text-decoration: none;">人物</a>
                        </h2>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E6%94%BF%E6%B2%BB%E4%BA%BA%E7%89%A9" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">政治人物</a><br/><a href="https://baike.baidu.com/fenlei/%E5%8E%86%E5%8F%B2%E4%BA%BA%E7%89%A9" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">历史人物</a><br/><a href="https://baike.baidu.com/fenlei/%E6%96%87%E5%8C%96%E4%BA%BA%E7%89%A9" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">文化人物</a><br/><a href="https://baike.baidu.com/fenlei/%E8%99%9A%E6%8B%9F%E4%BA%BA%E7%89%A9" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">虚拟人物</a><br/><a href="https://baike.baidu.com/fenlei/%E7%BB%8F%E6%B5%8E%E4%BA%BA%E7%89%A9" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">经济人物</a>
                        </p>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E8%AF%9D%E9%A2%98%E4%BA%BA%E7%89%A9" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">话题人物</a>
                        </p>
                    </li>
                    <li>
                        <h2 style="margin: 0px; padding: 0px; font-size: 18px; line-height: 20px; font-weight: 400;">
                            <a href="https://baike.baidu.com/ziran" target="_blank" style="color: rgb(34, 34, 34); text-decoration: none;">自然</a>
                        </h2>
                    </li>
                    <li>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E5%8A%A8%E7%89%A9" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">动物</a><br/><a href="https://baike.baidu.com/fenlei/%E6%A4%8D%E7%89%A9" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">植物</a><br/><a href="https://baike.baidu.com/fenlei/%E8%87%AA%E7%84%B6%E7%81%BE%E5%AE%B3" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">自然灾害</a><br/><a href="https://baike.baidu.com/fenlei/%E8%87%AA%E7%84%B6%E8%B5%84%E6%BA%90" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">自然资源</a><br/><a href="https://baike.baidu.com/fenlei/%E8%87%AA%E7%84%B6%E7%8E%B0%E8%B1%A1" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">自然现象</a>
                        </p>
                    </li>
                </ul>
                <ul style="margin: 0px; padding: 30px 0px 30px 30px; float: left; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(235, 235, 235); height: 140px; width: 206px; color: rgb(51, 51, 51); font-family: arial, tahoma, &#39;Microsoft Yahei&#39;, 宋体, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);" class=" list-paddingleft-2">
                    <li>
                        <h2 style="margin: 0px; padding: 0px; font-size: 18px; line-height: 20px; font-weight: 400;">
                            <a href="https://baike.baidu.com/wenhua" target="_blank" style="color: rgb(34, 34, 34); text-decoration: none;">文化</a>
                        </h2>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E7%BE%8E%E6%9C%AF" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">美术</a><br/><a href="https://baike.baidu.com/fenlei/%E6%88%8F%E5%89%A7" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">戏剧</a><br/><a href="https://baike.baidu.com/fenlei/%E8%88%9E%E8%B9%88" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">舞蹈</a><br/><a href="https://baike.baidu.com/fenlei/%E6%91%84%E5%BD%B1" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">摄影</a><br/><a href="https://baike.baidu.com/fenlei/%E6%9B%B2%E8%89%BA" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">曲艺</a>
                        </p>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E4%B9%A6%E7%94%BB" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">书画</a><br/><a href="https://baike.baidu.com/fenlei/%E5%BB%BA%E7%AD%91" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">建筑</a><br/><a href="https://baike.baidu.com/fenlei/%E8%AF%AD%E8%A8%80" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">语言</a>
                        </p>
                    </li>
                </ul>
                <ul style="margin: 0px; padding: 30px 0px 30px 30px; float: left; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(235, 235, 235); height: 140px; width: 206px; color: rgb(51, 51, 51); font-family: arial, tahoma, &#39;Microsoft Yahei&#39;, 宋体, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);" class=" list-paddingleft-2">
                    <li>
                        <h2 style="margin: 0px; padding: 0px; font-size: 18px; line-height: 20px; font-weight: 400;">
                            <a href="https://baike.baidu.com/tiyu" target="_blank" style="color: rgb(34, 34, 34); text-decoration: none;">体育</a>
                        </h2>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E4%BD%93%E8%82%B2%E7%BB%84%E7%BB%87" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">体育组织</a><br/><a href="https://baike.baidu.com/fenlei/%E4%BD%93%E8%82%B2%E5%A5%96%E9%A1%B9" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">体育奖项</a><br/><a href="https://baike.baidu.com/fenlei/%E4%BD%93%E8%82%B2%E8%AE%BE%E6%96%BD" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">体育设施</a><br/><a href="https://baike.baidu.com/fenlei/%E4%BD%93%E8%82%B2%E9%A1%B9%E7%9B%AE" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">体育项目</a>
                        </p>
                    </li>
                </ul>
                <ul class="noBorder list-paddingleft-2" style="margin: 0px; padding: 30px 0px 30px 30px; float: left; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(235, 235, 235); height: 140px; width: 206px; color: rgb(51, 51, 51); font-family: arial, tahoma, &#39;Microsoft Yahei&#39;, 宋体, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);">
                    <li>
                        <h2 style="margin: 0px; padding: 0px; font-size: 18px; line-height: 20px; font-weight: 400;">
                            <a href="https://baike.baidu.com/shehui" target="_blank" style="color: rgb(34, 34, 34); text-decoration: none;">社会</a>
                        </h2>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E7%BB%84%E7%BB%87%E6%9C%BA%E6%9E%84" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">组织机构</a><br/><a href="https://baike.baidu.com/fenlei/%E6%94%BF%E6%B2%BB" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">政治</a><br/><a href="https://baike.baidu.com/fenlei/%E5%86%9B%E4%BA%8B" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">军事</a><br/><a href="https://baike.baidu.com/fenlei/%E6%B3%95%E5%BE%8B" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">法律</a><br/><a href="https://baike.baidu.com/fenlei/%E6%B0%91%E6%97%8F" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">民族</a>
                        </p>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E4%BA%A4%E9%80%9A" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">交通</a><br/><a href="https://baike.baidu.com/fenlei/%E7%BB%8F%E6%B5%8E" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">经济</a>
                        </p>
                    </li>
                </ul>
                <ul style="margin: 0px; padding: 30px 0px 30px 30px; float: left; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(235, 235, 235); height: 140px; width: 206px; color: rgb(51, 51, 51); font-family: arial, tahoma, &#39;Microsoft Yahei&#39;, 宋体, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);" class=" list-paddingleft-2">
                    <li>
                        <h2 style="margin: 0px; padding: 0px; font-size: 18px; line-height: 20px; font-weight: 400;">
                            <a href="https://baike.baidu.com/lishi" target="_blank" style="color: rgb(34, 34, 34); text-decoration: none;">历史</a>
                        </h2>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E5%90%84%E5%9B%BD%E5%8E%86%E5%8F%B2" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">各国历史</a><br/><a href="https://baike.baidu.com/fenlei/%E5%8E%86%E5%8F%B2%E4%BA%8B%E4%BB%B6" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">历史事件</a><br/><a href="https://baike.baidu.com/fenlei/%E5%8E%86%E5%8F%B2%E8%91%97%E4%BD%9C" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">历史著作</a><br/><a href="https://baike.baidu.com/fenlei/%E6%96%87%E7%89%A9%E8%80%83%E5%8F%A4" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">文物考古</a>
                        </p>
                    </li>
                </ul>
                <ul style="margin: 0px; padding: 30px 0px 30px 30px; float: left; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(235, 235, 235); height: 140px; width: 206px; color: rgb(51, 51, 51); font-family: arial, tahoma, &#39;Microsoft Yahei&#39;, 宋体, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);" class=" list-paddingleft-2">
                    <li>
                        <h2 style="margin: 0px; padding: 0px; font-size: 18px; line-height: 20px; font-weight: 400;">
                            <a href="https://baike.baidu.com/dili" target="_blank" style="color: rgb(34, 34, 34); text-decoration: none;">地理</a>
                        </h2>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E8%A1%8C%E6%94%BF%E5%8C%BA%E5%88%92" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">行政区划</a><br/><a href="https://baike.baidu.com/fenlei/%E5%9C%B0%E5%BD%A2%E5%9C%B0%E8%B2%8C" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">地形地貌</a>
                        </p>
                    </li>
                </ul>
                <ul style="margin: 0px; padding: 30px 0px 30px 30px; float: left; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(235, 235, 235); height: 140px; width: 206px; color: rgb(51, 51, 51); font-family: arial, tahoma, &#39;Microsoft Yahei&#39;, 宋体, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);" class=" list-paddingleft-2">
                    <li>
                        <h2 style="margin: 0px; padding: 0px; font-size: 18px; line-height: 20px; font-weight: 400;">
                            <a href="https://baike.baidu.com/keji" target="_blank" style="color: rgb(34, 34, 34); text-decoration: none;">科技</a>
                        </h2>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E7%A7%91%E7%A0%94%E6%9C%BA%E6%9E%84" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">科研机构</a><br/><a href="https://baike.baidu.com/fenlei/%E4%BA%92%E8%81%94%E7%BD%91" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">互联网</a><br/><a href="https://baike.baidu.com/fenlei/%E8%88%AA%E7%A9%BA%E8%88%AA%E5%A4%A9" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">航空航天</a><br/><a href="https://baike.baidu.com/fenlei/%E5%8C%BB%E5%AD%A6" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">医学</a><br/><a href="https://baike.baidu.com/fenlei/%E7%94%B5%E5%AD%90%E4%BA%A7%E5%93%81" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">电子产品</a>
                        </p>
                    </li>
                </ul>
                <ul style="margin: 0px; padding: 30px 0px 30px 30px; float: left; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(235, 235, 235); height: 140px; width: 206px; color: rgb(51, 51, 51); font-family: arial, tahoma, &#39;Microsoft Yahei&#39;, 宋体, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);" class=" list-paddingleft-2">
                    <li>
                        <h2 style="margin: 0px; padding: 0px; font-size: 18px; line-height: 20px; font-weight: 400;">
                            <a href="https://baike.baidu.com/fenlei/%E5%A8%B1%E4%B9%90" target="_blank" style="color: rgb(34, 34, 34); text-decoration: none;">娱乐</a>
                        </h2>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E5%8A%A8%E6%BC%AB" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">动漫</a><br/><a href="https://baike.baidu.com/fenlei/%E7%94%B5%E5%BD%B1" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">电影</a><br/><a href="https://baike.baidu.com/fenlei/%E7%94%B5%E8%A7%86%E5%89%A7" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">电视剧</a><br/><a href="https://baike.baidu.com/fenlei/%E5%B0%8F%E8%AF%B4" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">小说</a><br/><a href="https://baike.baidu.com/fenlei/%E7%94%B5%E8%A7%86%E8%8A%82%E7%9B%AE" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">电视节目</a>
                        </p>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E6%BC%94%E5%87%BA" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">演出</a>
                        </p>
                    </li>
                </ul>
                <ul class="noBorder list-paddingleft-2" style="margin: 0px; padding: 30px 0px 30px 30px; float: left; border-bottom-width: 1px; border-bottom-style: solid; border-bottom-color: rgb(235, 235, 235); height: 140px; width: 206px; color: rgb(51, 51, 51); font-family: arial, tahoma, &#39;Microsoft Yahei&#39;, 宋体, sans-serif; font-size: 12px; line-height: 18px; white-space: normal; background-color: rgb(255, 255, 255);">
                    <li>
                        <h2 style="margin: 0px; padding: 0px; font-size: 18px; line-height: 20px; font-weight: 400;">
                            <a href="https://baike.baidu.com/shenghuo" target="_blank" style="color: rgb(34, 34, 34); text-decoration: none;">生活</a>
                        </h2>
                        <p>
                            <a href="https://baike.baidu.com/fenlei/%E7%BE%8E%E5%AE%B9" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">美容</a><br/><a href="https://baike.baidu.com/fenlei/%E6%97%B6%E5%B0%9A" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">时尚</a><br/><a href="https://baike.baidu.com/fenlei/%E6%97%85%E6%B8%B8" target="_blank" style="color: rgb(102, 102, 102); text-decoration: none; line-height: 23px;">旅游</a>
                        </p>
                    </li>
                </ul>
        </div>

        <div class="col-md-3" style="font-size: 15px;font-weight: bold;border-bottom: 1px solid #E5E5E5;padding-bottom: 10px;padding-top: 5px;">
            <div class="data_list">
                <div class="data_list_title"  style="font-size: 20px;font-weight: bold;border-bottom: 1px solid #E5E5E5;padding-bottom: 10px;padding-top: 5px;">
                    <%--<img src="${pageContext.request.contextPath}/static/images/user_icon.png"/>--%>
                    公告栏
                </div>
                <ul>
                    <li><span><a href="">欢迎来到互动百科</a></span></li>
                    <li><span><a href="">快去创建词条吧</a></span></li>
                    <li><span><a href="">评论也可以加积分</a></span>！</li>
                </ul>
            </div>

            <div class="data_list">
                <div class="data_list_title" style="font-size: 20px;font-weight: bold;border-bottom: 1px solid #E5E5E5;padding-bottom: 10px;padding-top: 5px;">
                    <%--<img src="${pageContext.request.contextPath}/static/images/byType_icon.png"/>--%>
                    分类
                </div>
                <div class="datas" >
                    <ul>
                        <c:forEach var="category" items="${categoryList }">
                            <li><span><a href="${pageContext.request.contextPath}/category?categoryId=${category.categoryId }">${category.categoryName }</a></span></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>


        </div>


    </div>

    <jsp:include page="/common/foot.jsp"/>
</div>
</body>
</html>
