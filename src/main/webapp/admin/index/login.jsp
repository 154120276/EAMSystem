<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>后台登录</title>
    <link rel="stylesheet" type="text/css" href="../../static/admin/layui/css/layui.css"/>
    <link rel="stylesheet" type="text/css" href="../../static/admin/css/login.css"/>
    <link href="../../static/admin/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="m-login-bg">
    <div class="m-login">
        <h3>学生信息管理系统登录</h3>
        <div class="m-login-warp">
            <form class="layui-form" action="../../login">
                <div class="layui-form-item">
                    <input type="text" name="username" required lay-verify="required" placeholder="用户名"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <input type="password" name="password" required lay-verify="required" placeholder="密码"
                           autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-item">
                    <select name="type">
                        <option value="teacher">教师</option>
                        <option value="student">学生</option>
                        <option value="root">管理员</option>
                    </select>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <input type="text" name="verity" required lay-verify="required" placeholder="验证码"
                               autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-inline">
                        <img class="verifyImg" onclick="this.src=this.src+'?c='+Math.random();" src="../../checkcode"/>
                    </div>
                </div>
                <div class="layui-form-item m-login-btn">
                    <div class="layui-inline">
                        <button class="layui-btn layui-btn-normal" lay-submit lay-filter="login">登录</button>
                    </div>
                    <div class="layui-inline">
                        <button type="reset" class="layui-btn layui-btn-primary">取消</button>
                    </div>
                </div>
            </form>

            <!-- 出错显示的信息框 -->
            <div class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert">
                    <span>&times;</span></button>
                <strong>${Error_Message}</strong>
            </div>
        </div>
        <p class="copyright">Copyright 2021 by zcj</p>
    </div>
</div>
<script src="../../static/admin/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<script src="../../static/admin/js/vue-2.6.10.js"></script>
<script src="../../static/admin/js/jquery-3.3.1.min.js"></script>
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form(),
            layer = layui.layer;


        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            },
            password: [/(.+){6,18}$/, '密码必须6到12位'],
            verity: [/(.+){6}$/, '验证码必须是6位'],

        });


    });
</script>
</body>

</html>