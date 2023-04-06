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
    <title>Title</title>
</head>
<body class="container">
<div class="row" >
    <h2 ><center style="color: #0b5ed7;margin: 40px">Giỏ Hàng</center></h2>
    <a class="btn btn-primary " style="width: 60px"
       href="/assignment_war_exploded/gio-hang/create">
        Thêm
    </a>
    <c:if test="${f:length(danhSachGioHang) == 0}">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${f:length(danhSachGioHang) != 0}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Ngày Tạo</th>
                <th scope="col">Ngày Thanh Toán</th>
                <th scope="col">Tên Người Nhận</th>
                <th scope="col">Địa Chỉ</th>
                <th scope="col">Số Điện thoại</th>
                <th scope="col">Trạng Thái</th>
                <th scope="col">Thao tác</th>

            </tr>
            </thead>

            <c:forEach items="${ danhSachGioHang}" var="g">
                <tr>
                    <td scope="col">${ g.ma}</td>
                    <td scope="col">${ g.ngay_tao}</td>
                    <td scope="col">${ g.ngay_thanh_toan}</td>
                    <td scope="col">${ g.ten_nguoi_nhan}</td>
                    <td scope="col">${ g.dia_chi}</td>
                    <td scope="col">${ g.sdt}</td>
                    <td scope="col">${ g.tinh_trang == "0" ? "Đã Thanh Toán" : "Chưa Thanh Toán"}</td>
                    <td>
                        <a class="btn btn-primary"
                           href="/assignment_war_exploded/gio-hang/edit?ma=${ g.ma }">
                            Cập nhật
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/assignment_war_exploded/gio-hang/delete?ma=${ g.ma }">
                            Xóa
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-primary"
                           href="/assignment_war_exploded/ct-gh/index">
                            Chi tiết
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-primary"
                           href="/assignment_war_exploded/hoa-don/index">
                            Thanh Toán
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
