
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Create Nhân Viên</title>
    <link rel="stylesheet"
          href="/assignment_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<h2><center style="color: #0b5ed7;font-style: normal;margin-top: 40px">Create Nhân Viên</center></h2>
<div class="col-8 offset-2">
    <center><div class="alert"style="color: red">${ errorMessage }</div></center>
    <form method="POST"
          action="/assignment_war_exploded/nhan-vien/store">
        <div class="row ">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
                <span style="color:red;font-size: 16px">${trungMa}</span>
                <span style="color:red;font-size: 16px">${checkMa}</span>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" />
                <span style="color:red;font-size: 16px">${checkTen}</span>

            </div>

        </div>
        <div class="row">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="tenDem" class="form-control" />
                <span style="color:red;font-size: 16px">${checkTenDem}</span>
               </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" />
                <span style="color:red;font-size: 16px">${checkHo}</span>
            </div>

        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giới Tính</label>
                <select id="inputState" class="form-select" name="gioiTinh">
                    <option value="nam">Nam</option>
                    <option value="nữ">Nữ</option>
                </select>
            </div>
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngaySinh" class="form-control" />
                <span style="color:red;font-size: 16px">${checkNgaySinh}</span>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">

                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" />
                <span style="color:red;font-size: 16px">${checkDiaChi}</span>
            </div>
            <div class="col-6">
                <label>SDT</label>
                <input type="text" name="sdt" class="form-control" />
                <span style="color:red;font-size: 16px">${checkSDT}</span>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Cửa Hàng</label>
                <select  class="form-select" name="idCH">
                    <c:forEach items="${danhSachCH}" var="ch">
                    <option value="${ch.id}">${ch.ten}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-6">
                    <label>Chức Vụ</label>
                <select  class="form-select" name="idCV">
                    <c:forEach items="${danhSachCV}" var="cv">
                        <option value="${cv.id}">${cv.ten}</option>
                    </c:forEach>
                </select>
            </div>
<%--        </div>--%>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" class="form-control" />
                <span style="color:red;font-size: 16px">${checkMatKhau}</span>
            </div>
            <div class="col-6">
                <label>Trạng thái</label>
                <select id="" class="form-select" name="trangThai">
                    <option value="0">Đang Làm</option>
                    <option value="1">Nghỉ Làm</option>
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
</html>
