<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改信息</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="../../static/admin/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="../../static/admin/js/jquery-3.3.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="../../static/admin/js/bootstrap.js"></script>

    <script>
        function updateTeacher(id,name,sex,phonenumber,email,username,password){
            $.post("/updateTeacher",
                "id="+id+"&name="+name+"&sex="+sex+"&phonenumber="+phonenumber+"&email="+email+"&username="+username+"&password="+password,
                function(data) {
                    if (data == 'success') {
                        document.getElementById("result").innerHTML="修改成功";
                    }
                })
        }
    </script>
</head>
<body>


<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改信息列表</h3>
    <form action="/updateTeacher" method="post">
        <%--隐藏域 提交id--%>
        <input type="hidden" name="id" value = ${param.id}>
            <div class="form-group">
                <label for="nameTeacher">姓名：</label>
                <input type="text" class="form-control" id="nameTeacher" name="nameTeacher" placeholder="请输入姓名">
            </div>

            <div class="form-group">
                <label>性别：</label>
                <input type="radio" name="sex" value="男" checked="checked"/>男
                <input type="radio" name="sex" value="女"/>女
            </div>

            <div class="form-group">
                <label for="phonenumber">手机号：</label>
                <input type="text" class="form-control" id="phonenumber" name="phonenumber" placeholder="请输入手机号">
            </div>

            <div class="form-group">
                <%--@declare id="email"--%><label for="email">邮箱：</label>
                <input type="text" class="form-control" name="email" placeholder="请输入邮箱地址"/>
            </div>

            <div class="form-group">
                <%--@declare id="username"--%><label for="username">用户名：</label>
                <input type="text" class="form-control" name="username" placeholder="请输入用户名"/>
            </div>

            <div class="form-group">
                <%--@declare id="password"--%><label for="password">密码：</label>
                <input type="text" class="form-control" name="password" placeholder="请输入密码"/>
            </div>

            <div style="text-align: center" id="result"></div>

            <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" onclick="javascript:updateTeacher(${param.id},nameTeacher.value,sex.value,phonenumber.value,email.value,username.value,password.value);" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <a><input class="btn btn-default" type="button" onclick="javascript:history.back(-1);" value="返回" /></a>
            </div>
    </form>
</div>
</body>
</html>