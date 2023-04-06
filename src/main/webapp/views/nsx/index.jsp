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
<div class="row" style="margin: auto"  >
    <h2 ><center style="color: #0b5ed7;margin: 40px">Thông Tin NSX</center></h2>
    <a class="btn btn-primary " style="width: 60px"
       href="/assignment_war_exploded/nsx/create">
        Thêm
    </a>
    <c:if test="${f:length(danhSachNSX) == 0}">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${f:length(danhSachNSX) != 0}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Thao tác</th>
                <th scope="col"></th>
            </tr>
            </thead>

            <c:forEach items="${ danhSachNSX}" var="n">
                <tr>
                    <td scope="col">${ n.ma}</td>
                    <td scope="col">${ n.ten}</td>
                    <td>
                        <a class="btn btn-primary"
                           href="/assignment_war_exploded/nsx/edit?ma=${ n.ma }">
                            Cập nhật
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/assignment_war_exploded/nsx/delete?ma=${ n.ma }">
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
