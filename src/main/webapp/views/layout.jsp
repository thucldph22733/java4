<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bán Hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet"
          href="/assignment_war_exploded/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="/assignment_war_exploded/css/index.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
          integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous" />
</head>
<body class="container-fluid">
<div class="row">
    <center>

        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a href="/assignment_war_exploded/ban-hang"><img   style="height: 30px;width: 80px;margin-right: 20px;" src="/assignment_war_exploded/img/logo3.png" alt=""></a>
                <a class="navbar-brand" href="/assignment_war_exploded/ban-hang" style="margin-right: 40px">Home</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item" style="margin-right: 60px">
                            <a class="nav-link active" aria-current="page" href="/assignment_war_exploded/khach-hang/index">Khách hàng</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a  style="margin-right: 60px" class="nav-link dropdown-toggle" href="/assignment_war_exploded/nhan-vien/index" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Nhân Viên
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/assignment_war_exploded/nhan-vien/index">Nhân Viên</a></li>
                                <li><a class="dropdown-item" href="/assignment_war_exploded/chuc-vu/index">Chức Vụ</a></li>
                            </ul>
                        </li>

                        <li class="nav-item dropdown">
                            <a  style="margin-right: 60px" class="nav-link dropdown-toggle" href="/assignment_war_exploded/san-pham/index" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Sản Phẩm
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="/assignment_war_exploded/san-pham/index">Sản Phẩm</a></li>
                                <li><a class="dropdown-item" href="/assignment_war_exploded/ct-sp/index">Chi Tiết</a></li>
                                <li><a class="dropdown-item" href="/assignment_war_exploded/mau-sac/index">Màu Sắc</a></li>
                                <li><a class="dropdown-item" href="/assignment_war_exploded/nsx/index">NSX</a></li>
                                <li><a class="dropdown-item" href="/assignment_war_exploded/dong-sp/index">Dòng SP</a></li>
                            </ul>
                        </li>
<%--                        <li class="nav-item" style="margin-right: 60px">--%>
<%--                            <a class="nav-link active" aria-current="page" href="/assignment_war_exploded/san-pham/index">Sản Phẩm</a>--%>
<%--                        </li>--%>
                        <li class="nav-item" style="margin-right: 60px">
                            <a class="nav-link active" aria-current="page" href="/assignment_war_exploded/cua-hang/index">Cửa Hàng</a>
                        </li>
                        <li class="nav-item" style="margin-right: 60px ">
                            <a class="nav-link" href="/assignment_war_exploded/gio-hang/index">Giỏ hàng</a>
                        </li>
                        <li class="nav-item " style="margin-right: 60px">
                            <a class="nav-link disabled">Disabled</a>
                        </li>
                        <form class="d-flex" role="search" style="margin-left:180px ">
                            <input class="form-control me-2 "  type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success " style="background-color: rgb(13, 12, 19);" type="submit">Search</button>
                        </form>
                    </ul>
                </div>
            </div>
        </nav>
<%--    <nav class="navbar navbar-expand-lg bg-body-tertiary">--%>
<%--        <div class="container-fluid">--%>
<%--            <a class="navbar-brand" href="#">Navbar</a>--%>
<%--            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--                <span class="navbar-toggler-icon"></span>--%>
<%--            </button>--%>
<%--            <div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
<%--                <ul class="navbar-nav me-auto mb-2 mb-lg-0">--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link active" aria-current="page" href="#">Home</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link" href="#">Link</a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item dropdown">--%>
<%--                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                            Dropdown--%>
<%--                        </a>--%>
<%--                        <ul class="dropdown-menu">--%>
<%--                            <li><a class="dropdown-item" href="#">Action</a></li>--%>
<%--                            <li><a class="dropdown-item" href="#">Another action</a></li>--%>
<%--                            <li><hr class="dropdown-divider"></li>--%>
<%--                            <li><a class="dropdown-item" href="#">Something else here</a></li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a class="nav-link disabled">Disabled</a>--%>
<%--                    </li>--%>
<%--                </ul>--%>
<%--                <form class="d-flex" role="search">--%>
<%--                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                    <button class="btn btn-outline-success" type="submit">Search</button>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </nav>--%>
    </center>
    <div class="row mt-10" style="min-height: 600px;">
        <div class="col-3 bg-light">
            <h3><center style="font-family: 'Arial Narrow';margin-top: 50px">Ưu Đãi Khi Thanh Toán Online</center></h3>
            <div id="carouselExampleFade" class="carousel slide carousel-fade">
                <div class="carousel-inner" style="margin-top: 20px">
                    <div class="carousel-item active">
                        <img style="width: auto;height: 250px;" src="/assignment_war_exploded/img/qc1.webp" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img style="width: auto;height: 250px;" src="/assignment_war_exploded/img/qc2.webp" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img style="width: auto;height: 250px;" src="/assignment_war_exploded/img/qc3.webp" class="d-block w-100"
                             alt="...">
                    </div>
                    <div class="carousel-item">
                        <img style="width: auto;height: 250px;" src="/assignment_war_exploded/img/qc4.webp" class="d-block w-100"
                             alt="...">
                    </div>
                    <div class="carousel-item">
                        <img style="width: auto;height: 250px;" src="/assignment_war_exploded/img/qc5.webp" class="d-block w-100"
                             alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleFade"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleFade"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
            <div style="background-color: #31d2f2">
                <center>
                    <p sty style="margin-top: 40px">Tư vấn mua hàng(Miễn phí)</p>
                    <span style="color: red;margin-bottom: 20px;font-style: italic;font-weight: bold">1800 6601</span>
                    <p style="margin-top: 20px">Góp ý, khiếu nại (8h00 - 22h00)</p>
                    <span style="color: red;margin-bottom: 20px;font-style: italic;font-weight: bold">1800 6616</span>

                </center>
            </div>
             </div>
        <div class="col-9">
            <jsp:include page="${ view }" />
        </div>
    </div>

    <footer style=" background: -webkit-linear-gradient(left, #abcbf1, #5bc6e4,rgb(0, 247, 255),rgb(84, 203, 224),rgb(83, 236, 190),rgb(181, 94, 252))" class="footer-59391">
        <div class="border-bottom pb-5 mb-4">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-3">
                        <form action="#" class="subscribe mb-4 mb-lg-0">
                            <div class="form-group">

                                <input type="email" class="form-control" placeholder="Enter your email" >

                                <button><i class="fas fa-paper-plane"></i></button>
                            </div>
                        </form>
                    </div>
                    <div class="col-lg-6 text-lg-center">
                        <ul class="list-unstyled nav-links nav-left mb-4 mb-lg-0">
                            <li><a style="color: black;"  href="#">Liên Hệ</a></li>
                            <li><a style="color: black;"  href="#">Blog</a></li>
                            <li><a style="color: black;"  href="#">Công Việc</a></li>
                            <li><a style="color: black;"  href="#">Services</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-3">
                        <ul class="list-unstyled nav-links social nav-right text-lg-right">
                            <a href="https://www.facebook.com/thuc.doanl"><i style="font-size: 35px;" class="fab fa-facebook"></i></a>
                            <a href="https://www.youtube.com/channel/UCf649N3zU8ux0mHRhZ1qurw"><i style="font-size: 35px;margin-left: 40px;" class="fab fa-youtube"></i></a>
                            <a href="#"><i style="font-size: 35px;margin-left: 40px;" class="fab fa-tiktok"></i></a>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-4 text-lg-center site-logo order-1 order-lg-2 mb-3 mb-lg-0">
                    <a href="#!/trang-chu"><img style="height: 50px;width: 50px;margin-right: 20px;color: #000;" src="/assignment_war_exploded/img/logo.jpg" alt=""></a>
                    <a style="color: black;" href="#" class="m-0 p-0">Play Boys Shop</a>
                </div>
                <div class="col-lg-4 order-2 order-lg-1 mb-3 mb-lg-0">
                    <ul class="list-unstyled nav-links m-0 nav-left">
                        <li><a style="color: black;"  href="#">Terms</a></li>
                        <li><a style="color: black;"  href="#">About</a></li>
                        <li><a style="color: black;"  href="#">Privacy</a></li>
                    </ul>
                </div>

                <div class="col-lg-4 text-lg-right order-3 order-lg-3">
                    <p style="color: black;"  class="m-0 text-muted"><small>&copy; 2019. All Rights Reserved.</small></p>
                </div>
            </div>
        </div>

    </footer>

</div>

</body>
<script src="/assignment_war_exploded/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</html>