
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<link rel="stylesheet"
      href="/assignment_war_exploded/css/banhang.css"/>
<div class="row" >
    <h2 ><center style="color: #0b5ed7;margin: 40px">Sản Phẩm</center></h2>
<hr>
    <c:forEach items="${danhSachCT}" var="ct">
        <div class="col-md-3" style="margin-bottom: 10px">
            <div class="card">
                <div class="bg-image hover-zoom"> <a ><img class="card-img-top" src="/assignment_war_exploded/img/${ct.img}" alt=""></a></div>
                <div class="card-body">
                    <h5 class="card-title">${ct.sanPham.ten}</h5>
                    <span class="card-text2">${ct.giaBan}Đ</span>
                    <a href="/assignment_war_exploded/detail?id=${ct.id}" class="btn btn-primary">Xem Chi Tiết...</a>
                </div>
                <div class="card-footer text-muted">
                    <marquee style="font-weight: bold;" direction="right">Tất cả Sản Phẩm đang giảm giá 15%</marquee>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
