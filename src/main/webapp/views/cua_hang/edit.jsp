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
<h2><center style="color: #0b5ed7;font-style: normal;margin: 40px">Edit Cửa Hàng</center></h2>
<div class="col-8 offset-2">
    <form method="POST"
          action="/assignment_war_exploded/cua-hang/update?ma=${ch.ma}">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ch.ma}" disabled/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${ch.ten}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa Chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${ch.diaChi}"/>
            </div>
            <div class="col-6">
                <label>Thành Phố</label>
                <input type="text" name="thanhPho" class="form-control" value="${ch.thanhPho}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option value="vi" ${ kh.quocGia == "vi" ? "selected" : "" }>Việt Nam</option>
                    <option value="us" ${ kh.quocGia == "us" ? "selected" : "" }>Mỹ</option>
                </select>
            </div>
            <div class="col-6">

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
