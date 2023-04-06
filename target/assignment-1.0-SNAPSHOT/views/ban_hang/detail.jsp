
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<link rel="stylesheet"
      href="/assignment_war_exploded/css/banhang.css"/>
<div class="container">
<div class="row" >
    <h3 ><center style="color: #0b5ed7;margin: 40px">${detail.sanPham.ten}</center></h3>
    <hr>

        <div class="col-3">

        </div>
        <div class="col-3" style="margin-bottom: 10px">
            <div class="card">
                <div class="bg-image hover-zoom"> <a ><img class="card-img-top" src="/assignment_war_exploded/img/${detail.img}" alt=""></a></div>
                <div class="card-body">
                    <h5 class="card-title">${detail.sanPham.ten}</h5>
                    <span class="card-text2">${detail.giaBan} Đ</span>
                </div>
            </div>
        </div>
        <div class="col-5">
            <h5 class="card-title"style="font-weight: bold"><p style="font-weight: bold;color: #0a53be">Mô tả:</p>${detail.moTa}</h5>
            <span class="card-text2"><p style="font-weight: bold;color: #0a53be">Năm bảo hành:</p>  ${detail.namBH}</span>
        </div>
        <div class="col-1">

        </div>


</div>
</div>