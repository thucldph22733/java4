<%--
  Created by IntelliJ IDEA.
  User: tiennh
  Date: 3/11/23
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/assignment_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<h2><center style=";color: #0b5ed7;font-style: normal;margin: 40px">Edit NSX</center></h2>
<div class="col-8 offset-2">
    <form method="POST"
          action="/assignment_war_exploded/nsx/update?ma=${n.ma}">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${n.ma}" disabled/>
            </div>
            <div class="col-6">
                <label>Tên SP</label>
                <input type="text" name="ten" class="form-control" value="${n.ten}"/>
            </div>
        </div>


        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Cập Nhật</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
<script src="/assignment_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
