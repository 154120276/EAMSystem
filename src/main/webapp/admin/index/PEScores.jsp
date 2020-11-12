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
    <title>用户信息管理系统</title>

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
</head>
<body>
<div class="container">
    <h3 style="text-align: center">体侧成绩</h3>
    <form id="form" action="${pageContext.request.contextPath}/" method="post">
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">

            <th>编号</th>
            <th>身高(cm)</th>
            <th>体重(kg)</th>
            <th>50m</th>
            <th>50m分数</th>
            <th>肺活量</th>
            <th>肺活量得分</th>
        </tr>
        <tr class="success">

            <th>${pe.id}</th>
            <th>${pe.hight}</th>
            <th>${pe.weight}</th>
            <th>${pe.shortrun}</th>
            <th>${pe.shortrunscore}</th>
            <th>${pe.lungcapacity}</th>
            <th>${pe.lungcapacityscore}</th>
        </tr>
        <tr class="success">

            <th>跳远(cm)</th>
            <th>跳远得分</th>
            <th>引体向上(次,女为仰卧起坐)</th>
            <th>引体向上得分</th>
            <th>1000m(女为800m)</th>
            <th>1000m分数</th>
            <th>总得分</th>
        </tr>
        <tr class="success">
            <th>${pe.jump}</th>
            <th>${pe.jumpscore}</th>
            <th>${pe.pull_up}</th>
            <th>${pe.pull_upscore}</th>
            <th>${pe.longrun}</th>
            <th>${pe.longrunscore}</th>
            <th>${pe.longrunscore*0.25+pe.pull_upscore*0.15+pe.lungcapacityscore*0.2+pe.shortrunscore*0.25+pe.jumpscore*0.15}</th>
        </tr>


    </table>
    </form>

</div>
</body>
</html>
