<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/03/2023
  Time: 12:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <link rel="stylesheet"
          href="/assignment_war_exploded/css/bootstrap.min.css"/>
    <title>Index Nhân Viên</title>
</head>
<body class="container">
<div class="row" style="margin: auto" >
    <h2 ><center style="color: #0b5ed7;margin: 40px">Thông Tin Nhân VIên</center></h2>
    <a class="btn btn-primary " style="width: 60px"
       href="/assignment_war_exploded/nhan-vien/create">
        Thêm
    </a>
    <c:if test="${f:length(danhSachNV) == 0}">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${f:length(danhSachNV) != 0}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Tên Đêm</th>
                <th scope="col">Họ</th>
                <th scope="col">Giới Tính</th>
                <th scope="col">Ngày Sinh</th>
                <th scope="col">Địa Chỉ</th>
                <th scope="col">Số Điện thoại</th>
                <th scope="col">Mật Khẩu</th>
                <th scope="col">Cửa Hàng</th>
                <th scope="col">Chức Vụ</th>

                <th scope="col">Trạng Thái</th>
                <th scope="col">Thao tác</th>

            </tr>
            </thead>

            <c:forEach items="${ danhSachNV}" var="n">
                <tr>
                    <td scope="col">${ n.ma}</td>
                    <td scope="col">${ n.ten}</td>
                    <td scope="col">${ n.tenDem}</td>
                    <td scope="col">${ n.ho}</td>
                    <td scope="col">${ n.gioiTinh == "nam" ? "Nam" : "Nữ"}</td>
                    <td scope="col">${ n.ngaySinh}</td>
                    <td scope="col">${ n.diaChi}</td>
                    <td scope="col">${ n.sdt}</td>
                    <td scope="col">${ n.matKhau}</td>
                    <td scope="col">${ n.cuaHang.ten}</td>
                    <td scope="col">${ n.chucVu.ten}</td>

                    <td scope="col">${ n.trangThai == 0 ? "Đang Làm" : "Nghỉ Làm" }</td>
                    <td>
                        <a href="../nhan-vien/edit?ma=${n.ma}" class="btn btn-primary">Cập nhật</a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/assignment_war_exploded/nhan-vien/delete?ma=${ n.ma }">
                            Xóa
                        </a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </c:if>


</div>
<script src="/assignment_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
