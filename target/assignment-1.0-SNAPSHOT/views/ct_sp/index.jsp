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
    <h2 ><center style="color: #0b5ed7;margin: 40px">Thông Tin Chi Tiết Sản Phẩm</center></h2>

    <a class="btn btn-primary " style="width: 60px"
       href="/assignment_war_exploded/ct-sp/create">
        Thêm
    </a>
    <c:if test="${f:length(danhSachCT) == 0}">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${f:length(danhSachCT) != 0}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Sản Phẩm</th>
                <th scope="col">Nhà Sản Xuất</th>
                <th scope="col">Màu Sắc</th>
                <th scope="col">Dòng Sản Phẩm</th>
                <th scope="col">Năm Bảo Hành</th>
                <th scope="col">Số Lượng</th>
                <th scope="col">Mô Tả</th>
                <th scope="col">Giá Nhập</th>
                <th scope="col">Giá Bán</th>
<%--                <th scope="col">Thao tác</th>--%>

            </tr>
            </thead>

            <c:forEach items="${ danhSachCT}" var="ct">
                <tr>
                    <td scope="col">${ ct.sanPham.ten}</td>
                    <td scope="col">${ ct.nsx.ten}</td>
                    <td scope="col">${ ct.mauSac.ten}</td>
                    <td scope="col">${ ct.dongSP.ten}</td>
                    <td scope="col">${ ct.namBH}</td>
                    <td scope="col">${ ct.soLuongTon}</td>
                    <td scope="col">${ ct.moTa}</td>
                    <td scope="col">${ ct.giaNhap}</td>
                    <td scope="col">${ ct.giaBan}</td>
<%--                    <td>--%>
<%--                        <a class="btn btn-primary"--%>
<%--                           href="/assignment_war_exploded/ct-sp/edit?Id=${ kh.Id }">--%>
<%--                            Cập nhật--%>
<%--                        </a>--%>
<%--                    </td>--%>
<%--                    <td>--%>
<%--                        <a class="btn btn-danger"--%>
<%--                           href="/assignment_war_exploded/ct-sp/delete?Id=${ kh.Id }">--%>
<%--                            Xóa--%>
<%--                        </a>--%>
<%--                    </td>--%>
                </tr>
            </c:forEach>

        </table>
    </c:if>


</div>
<script src="/assignment_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
