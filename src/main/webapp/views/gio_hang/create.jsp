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
<h2><center style="color: #0b5ed7;font-style: normal;margin: 40px">Create Giỏ Hàng</center></h2>
<div class="col-8 offset-2">
    <form method="POST"
          action="/assignment_war_exploded/gio-hang/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
            </div>
            <div class="col-6">

            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày tạo</label>
                <input type="date" name="ngay_tao" class="form-control" />
            </div>
            <div class="col-6">
                <label>Ngày Thanh Toán</label>
                <input type="date" name="ngay_thanh_toan" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên Người Nhận</label>
                <input type="text" name="ten_nguoi_nhan" class="form-control" />
            </div>
            <div class="col-6">
                <label>Địa Chỉ</label>
                <input type="text" name="dia_chi" class="form-control" />
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>SDT</label>
                <input type="text" name="sdt" class="form-control" />
            </div>
            <div class="col-6">
            <label>Trạng thái</label>
            <select id="" class="form-select" name="tinh_trang">
                <option value="0" >0</option>
                <option value="1">1</option>
            </select>
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

