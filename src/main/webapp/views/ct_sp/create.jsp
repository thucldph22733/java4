<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="/assignment_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<h2><center style="color: #0b5ed7;font-style: normal;margin: 40px">Create Chi Tiết Sản Phẩm</center></h2>
<div class="col-8 offset-2">
    <form method="POST"
          action="/assignment_war_exploded/ct-sp/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên Sản Phẩm</label>
                <select class="form-select" name="idSP">
                    <c:forEach items="${danhSachSP}" var="s">
                        <option value="${s.id}">${s.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>NSX</label>
                <select class="form-select" name="idNSX">
                    <c:forEach items="${danhSachNSX}" var="n">
                        <option value="${n.id}">${n.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Màu Sắc</label>
                <select class="form-select" name="idMauSac">
                    <c:forEach items="${danhSachMS}" var="m">
                        <option value="${m.id}">${m.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                <label>Dòng SP</label>
                <select class="form-select" name="idDongSP">
                    <c:forEach items="${danhSachDSP}" var="d">
                        <option value="${d.id}">${d.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Năm Bảo Hành</label>
                <input type="text" name="namBH" class="form-control" />
                <span style="color:red;font-size: 16px">${checkNamBH}</span>
            </div>
            <div class="col-6">
                <label>Số Lựợng</label>
                <input type="text" name="soLuongTon" class="form-control" />
                <span style="color:red;font-size: 16px">${checkSoLuongTon}</span>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mô tả</label>
                <input type="text" name="moTa" class="form-control" />
                <span style="color:red;font-size: 16px">${checkMoTa}</span>
            </div>
            <div class="col-6">
                <label>Ảnh</label>
                <input type="text" name="img" class="form-control" />
                <span style="color:red;font-size: 16px">${checkAnh}</span>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giá Nhập</label>
                <input type="text" name="giaNhap" class="form-control" />
                <span style="color:red;font-size: 16px">${checkGiaNhap}</span>
            </div>
            <div class="col-6">
                <label>Giá Bán</label>
                <input type="tel" name="giaBan" class="form-control" />
                <span style="color:red;font-size: 16px">${checkGiaBan}</span>
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
