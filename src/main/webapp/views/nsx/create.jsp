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
    <title>Create NSX</title>
    <link rel="stylesheet"
          href="/assignment_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<h2><center style=";color: #0b5ed7;font-style: normal;margin: 40px">Create NSX</center></h2>
<div class="col-8 offset-2">
    <form method="POST"
          action="/assignment_war_exploded/nsx/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
                <span style="color:red;font-size: 16px">${trungMa}</span>
                <span style="color:red;font-size: 16px">${checkMa}</span>
            </div>
            <div class="col-6">
                <label>Tên SP</label>
                <input type="text" name="ten" class="form-control" />
                <span style="color:red;font-size: 16px">${checkTen}</span>
            </div>
        </div>


        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
<script src="/assignment_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
