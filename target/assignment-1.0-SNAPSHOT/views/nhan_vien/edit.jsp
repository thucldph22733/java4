<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Edit Nhân Viên</title>
    <link rel="stylesheet"
          href="/assignment_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<h2>
    <center style="color: #0b5ed7;font-style: normal;margin-top: 40px">Edit Nhân Viên</center>
</h2>
<div class="col-8 offset-2">
    <form method="POST"
          action="/assignment_war_exploded/nhan-vien/update?ma=${n.ma}">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${n.ma}" disabled/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${n.ten}"/>

            </div>

        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="tenDem" class="form-control" value="${n.tenDem}"/>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" value="${n.ho}"/>
            </div>

        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giới Tính</label>
                <select id="inputState" class="form-select" name="gioiTinh">
                    <option value="nam" ${ kh.gioiTinh == "nam" ? "selected" : "" }>Nam</option>
                    <option value="nữ" ${ kh.gioiTinh == "nữ" ? "selected" : "" }>Nữ</option>
                </select>
            </div>
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngaySinh" class="form-control" value="${n.ngaySinh}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" value="${n.diaChi}"/>
            </div>
            <div class="col-6">
                <label>SDT</label>
                <input type="text" name="sdt" class="form-control" value="${n.sdt}"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
<%--                <label class="form-label">Cửa hàng</label>--%>
<%--                <select class="form-select" name="idCH" aria-label="Default select example">--%>
<%--                    <c:forEach items="${ danhSachCH }" var="ch">--%>
<%--                        <option value="${ch.id}" ${ch.id == n.cuaHang ? "selected" :"" }>${ch.ten}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>

<%--                <div class="col-md-6">--%>
                    <label class="form-label">Cửa hàng</label>
                    <select name="idCH" class="form-select">
                        <c:forEach items="${danhSachCH}" var="ch">
                            <option value="${ch.id}" ${n.cuaHang.id == ch.id?"selected":""}>${ch.ten}</option>
                        </c:forEach>
                    </select>
            </div>
            <div class="col-md-6">
                <label class="form-label">Chức vụ</label>
                <select name="idCV" class="form-select">
                    <c:forEach items="${danhSachCV}" var="cv">
                        <option value="${cv.id}" ${n.chucVu.id == cv.id?"selected":""}>${cv.ten}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="text" name="matKhau" class="form-control" value="${n.matKhau}"/>
            </div>
            <div class="col-6">
                <label>Trạng thái</label>
                <select class="form-select" name="trangThai">
                    <option value="0" ${ kh.trangThai == 0 ? "selected" : "" }>Đang Làm</option>
                    <option value="1" ${ kh.trangThai == 1 ? "selected" : "" }>Nghỉ Làm</option>
                </select>
            </div>

        </div>

        <%--        <div class="row mt-3">--%>
        <%--            <div class="col-6">--%>
        <%--                <label>Chức Vụ</label>--%>
        <%--                <input type="password" name="chucVu" class="form-control" value=${n.chucVu}/>--%>
        <%--            <div class="col-6">--%>
        <%--                <label>Cửa Hàng</label>--%>
        <%--                <input type="password" name="cuaHang" class="form-control" value=${n.cuaHang}/>--%>
        <%--            </div>--%>

        <%--        </div>--%>

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
