
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <link rel="stylesheet"
          href="/assignment_war_exploded/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="/assignment_war_exploded/layout"/>
    <title>Title</title>
</head>
<body class="container" style="margin: 5px">
<div class="row" style="margin: auto" >
    <h2 ><center style="color: #0b5ed7;margin: 40px">Thông Tin Sảm Phẩm</center></h2>
    <a class="btn btn-primary " style="width: 60px"
       href="/assignment_war_exploded/san-pham/create">
        Thêm
    </a>
    <c:if test="${f:length(danhSachSP) == 0}">
        <h3 class="alert alert-warning">Không có dữ liệu</h3>
    </c:if>
    <c:if test="${f:length(danhSachSP) != 0}">
        <table class="table table-hover" >
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Thao tác</th>
                <th scope="col"></th>
                <th scope="col"></th>

            </tr>
            </thead>

            <c:forEach items="${ danhSachSP}" var="s">
                <tr>
                    <td scope="col">${ s.ma}</td>
                    <td scope="col">${ s.ten}</td>

                    <td>
                        <a class="btn btn-primary"
                           href="/assignment_war_exploded/san-pham/edit?ma=${ s.ma }">
                            Cập nhật
                        </a>
                    </td>
                    <td>
                        <a class="btn btn-danger"
                           href="/assignment_war_exploded/san-pham/delete?ma=${ s.ma }">
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
