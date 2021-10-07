<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
    <title>班级信息管理系统</title>

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
        function deleteUser(sno) {
            //判断，安全提示
            if (confirm("您确定要删除吗？")) {
                //访问路径
                location.href = "${pageContext.request.contextPath}/deleteone?sno=" + sno;
            }
        }

        window.onload = function () {
            //给删除选择添加单击事件
            document.getElementById("delSelected").onclick = function () {
                //判断是否有选中条目
                if (confirm("您确定要删除吗？")) {
                    var flag = false;
                    var cbs = document.getElementsByName("uid");
                    for (let i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        document.getElementById("form").submit();
                    }
                }
            }

            //全选全不选按钮
            document.getElementById("firstCK").onclick = function () {
                //获取所有CB
                var cbs = document.getElementsByName("uid");
                for (let i = 0; i < cbs.length; i++) {
                    cbs[i].checked = this.checked;
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">班级列表</h3>
    <div style="float:left;margin: 5px">
        <form class="form-inline" action="${pageContext.request.contextPath}/selectclass" method="post">
            <div class="form-group">
                <label for="exampleInputName2">班级名</label>
                <input type="text" name="name" value="" class="form-control" id="exampleInputName2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
        <form class="form-inline" action="${pageContext.request.contextPath}/classExport" method="post">
            <button type="submit" class="btn btn-default">导出</button>
        </form>
    </div>
    <div style="float: right;margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/teachers">添加班级</a>
        <a class="btn btn-primary" href="javascript:void(0)" id="delSelected">删除选中</a>
    </div>
    <form id="form" action="../../deleteall" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCK"></th>
                <th>班级名</th>
                <th>班主任编号</th>
                <th>班主任名</th>
                <th>操作</th>

            </tr>
            <c:forEach items="${classes}" var="class" varStatus="s">
                <tr>
                    <th><input type="checkbox" name="uid" value="${class.sno}"></th>
                    <td>${class.classname}</td>
                    <td>${class.teacherid}</td>
                    <td>${class.teachername}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/updateclassjsp?Sno=${class.sno}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${class.sno}); ">删除</a></td>
                </tr>
            </c:forEach>


        </table>
    </form>

</div>
</body>
</html>
