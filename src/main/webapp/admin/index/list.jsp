<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri ="http://java.sun.com/jsp/jstl/core"%>


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
    <title>教师信息管理系统</title>

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
        function deleteUser(id) {
            //判断，安全提示
            if (confirm("您确定要删除吗？")){
                //访问路径
            location.href="${pageContext.request.contextPath}/delTeacherServlet?id="+id;
            }
        }
        window.onload=function () {
            //给删除选择添加单击事件
            document.getElementById("delSelected").onclick=function () {
                //判断是否有选中条目
                if (confirm("您确定要删除吗？")) {
                    var flag=false;
                    var cbs=document.getElementsByName("uid");
                    for (let i = 0; i <cbs.length; i++) {
                       if (cbs[i].checked){
                           flag=true;
                           break;
                       }
                    }
                    if (flag) {
                        document.getElementById("form").submit();
                    }
               }
            }

            //全选全不选按钮
            document.getElementById("firstCK").onclick=function () {
                    //获取所有CB
                var cbs=document.getElementsByName("uid");
                for (let i = 0; i <cbs.length; i++) {
                        cbs[i].checked=this.checked;
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">教师信息列表</h3>
    <div style="float:left;margin: 5px">
        <form class="form-inline" action="/findTeacherByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" name="name" value="" class="form-control" id="exampleInputName2" >
                <input type="hidden" name="rows" value="10">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>


    <div   style="float: right;margin: 5px">
        <a class="btn btn-primary" href="/admin/index/add.jsp">添加教师</a>
        <a class="btn btn-primary" href="javascript:void(0)" id="delSelected">删除选中</a>
    </div>


    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="firstCK"></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>手机号</th>
            <th>邮箱</th>
            <th>用户名</th>
            <th>密码</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${list}" var="user" varStatus="s">
            <tr>
                <th><input type="checkbox" name="uid" value="${user.id}"></th>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.sex}</td>
                <td>${user.phonenumber}</td>
                <td>${user.email}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td><a class="btn btn-default btn-sm" href="/admin/index/update.jsp?id=${user.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id}); ">删除</a></td>
            </tr>
        </c:forEach>


    </table>
    </form>
    <div>
        <nav>
            <ul class="pagination">
                <c:if test="${currentPage == 1}">
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                </c:if>

                <c:if test="${currentPage != 1}">
                    <li>
                    <a href="/findTeacherByPageServlet?currentPage=${currentPage-1}&rows=10&name=${name}" aria-label="Previous">
                </c:if>
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

               <c:forEach begin="1" end="${totalPage}" var="i">
                   <c:if test="${currentPage ==i}">
                       <li class="active">
                           <a href="javascript:void(0)">${i}</a>
                       </li>
                   </c:if>
                   <c:if test="${currentPage !=i}">
                       <li ><a href="/findTeacherByPageServlet?currentPage=${i}&rows=10&name=${name}">${i}
                       </a></li>
                   </c:if>
               </c:forEach>

                    <c:if test="${currentPage == totalPage}">
                    <li class="disabled">
                        <a href="#" aria-label="Previous">
                    </c:if>

                    <c:if test="${currentPage != totalPage}">
                    <li>
                        <a href="/findTeacherByPageServlet?currentPage=${currentPage+1}&rows=10&name=${name}" aria-label="Previous">
                     </c:if>
                        <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                <span style="font-size: 25px;margin-left: 5px">
                    共${totalCount}条记录 ，共${totalPage}页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
