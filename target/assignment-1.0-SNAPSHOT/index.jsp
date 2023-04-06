<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chào Mừng đến với Web của tui</title>
    <link rel="stylesheet"
          href="/assignment_war_exploded/css/bootstrap.min.css"/>
</head>
<body class="container">
<div class="row">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#" style="margin-right: 40px">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item" style="margin-right: 40px">
                        <a class="nav-link active" aria-current="page" href="/assignment_war_exploded/khach-hang/index">Khách hàng</a>
                    </li>
                    <li class="nav-item" style="margin-right: 40px">
                        <a class="nav-link active" aria-current="page" href="/assignment_war_exploded/nhan-vien/index">Nhân Viên</a>
                    </li>
                    <li class="nav-item" style="margin-right: 40px">
                        <a class="nav-link active" aria-current="page" href="/assignment_war_exploded/san-pham/index">Sản Phẩm</a>
                    </li>
                    <li class="nav-item" style="margin-right: 40px">
                        <a class="nav-link active" aria-current="page" href="/assignment_war_exploded/cua-hang/index">Cửa Hàng</a>
                    </li>
                    <li class="nav-item" style="margin-right: 40px ">
                        <a class="nav-link" href="/assignment_war_exploded/gio-hang/index">Giỏ hàng</a>
                    </li>
                    <li class="nav-item " style="margin-right: 40px">
                        <a class="nav-link disabled">Disabled</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
    <h1><%= "Hello World!" %>
    </h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>

</div>

</body>
<script src="/assignment_war_exploded/js/bootstrap.min.js"></script>
</html>