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
    <h2 ><center style="color: #0b5ed7;margin: 40px">Hóa Đơn Chi Tiết</center></h2>
    <c:if test="${f:length(danhSachHDCT) == 0}">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${f:length(danhSachHDCT) != 0}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Số lượng</th>
                <th scope="col">Đơn Giá</th>
                <th scope="col">Thao tác</th>

            </tr>
            </thead>

            <c:forEach items="${ danhSachHDCT}" var="h">
                <tr>
                    <td scope="col">${ h.so_luong}</td>
                    <td scope="col">${ h.don_gia}</td>
                    <td>
                        <a class="btn btn-primary"
                           href="/assignment_war_exploded/hoa-don/index">
                            Hóa Đơn
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-primary"
                           href="/assignment_war_exploded/ct-sp/index">
                            Hóa Đơn
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
