<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>
        function addCourse(courseName, credits) {
            $.post("/addCourse",
                "courseName=" + courseName + "&credits=" + credits,
                function (data) {
                    if (data == 'success') {
                        alert('添加课程成功');
                        document.getElementById("result").innerHTML = "“" + courseName + "”" + "添加成功";
                    } else {
                        alert('1111111')
                        document.getElementById("result").innerHTML = '“' + courseName + '”' + '添加失败，已有该课程';
                    }
                })
        }
    </script>
</head>
<body>
<div class="container">
    <center><h3>添加课程</h3></center>
    <form action="/addCourse" method="post">
        <div class="form-group">
            <label for="courseName">课程名：</label>
            <input type="text" class="form-control" id="courseName" name="courseName" placeholder="请输入课程名">
        </div>

        <div class="form-group">
            <label for="credits">学分：</label>
            <input type="text" class="form-control" id="credits" name="credits" placeholder="请输入学分">
        </div>

        <div style="text-align: center" id="result"/>
        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="button" onclick="javascript:addCourse(courseName.value,credits.value);"
                   value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <a><input class="btn btn-default" type="button" onclick="javascript:history.back(-1);" value="返回"/></a>
        </div>
    </form>
</div>
</body>
</html>