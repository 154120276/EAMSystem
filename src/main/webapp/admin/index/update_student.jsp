<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="../../static/admin/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="../../static/admin/js/jquery-3.3.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="../../static/admin/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
    <center><h3>修改班级页面</h3></center>
    <form action="${pageContext.request.contextPath}/updatestudent" method="post">
        <div class="form-group">
            <input type="hidden" value="${student.id}" name="id"/>
        </div>
        <div class="form-group">
            <label>姓名：</label>
            <input type="text"  class="form-control" id="name" value="${student.name}" name="name"/>
        </div>
        <div class="form-group">
            <label>班级：</label>
            <select name="sno" class="form-control" >
                <c:forEach items="${classes}" var="class" varStatus="s">
                    <option value="${class.sno}">${class.classname}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>电话号码：</label>
            <input type="text"  class="form-control" id="phonenumber" value="${student.phonenumber}" name="phonenumber"/>
        </div>
        <div class="form-group">
            <label>用户名：</label>
            <input type="text" class="form-control" id="username" value="${student.username}" name="username"/>
        </div>
        <div class="form-group">
            <label>密码：</label>
            <input type="text" class="form-control" id="password" value="${student.password}" name="password"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <a href="${pageContext.request.contextPath}/students"><input class="btn btn-default" type="button" value="返回" /></a>
        </div>
    </form>
</div>
</body>
</html>