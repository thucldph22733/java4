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
<h2><center style="color: #0b5ed7;font-style: normal;margin: 40px">Edit Chi Tiết Sản Phẩm</center></h2>
<div class="col-8 offset-2">
    <form method="POST"
          action="/assignment_war_exploded/ct-sp/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Năm Bảo Hành</label>
                <input type="text" name="namBH" class="form-control" value="${ct.namBH}" />
            </div>
            <div class="col-6">
                <label>Số Lựợng</label>
                <input type="text" name="soLuong" class="form-control" value="${ct.soLuongTon}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12">
                <label>Mô tả</label>
                <input type="text" name="moTa" class="form-control" value="${ct.moTa}" />
            </div>
            <div class="col-6">

            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giá Nhập</label>
                <input type="text" name="giaNhap" class="form-control" value="${ct.giaNhap}"/>
            </div>
            <div class="col-6">
                <label>Giá Bán</label>
                <input type="tel" name="giaBan" class="form-control" value="${ct.giaBan}"/>
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
