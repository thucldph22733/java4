<head><title>Đăng Nhập</title></head>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
    <div class="col-3"></div>
    <div class="col-6"style=" background-color: #31d2f2 ;height: 600px">
    <center><img   style="height: 80px;width: 240px;margin-right: 20px;margin-top: 20px" src="/assignment_war_exploded/img/logo4.png" alt=""></center>
    <center><h2 style="font-weight: bold;color:#1a1e21">Login</h2></center>
    <hr>
    <div class="alert" style="color: darkred;font-size: 20px;font-weight: bold">${ errorMessage }</div>
    <form method="post" action="/assignment_war_exploded/login" >
        <div class="mt-3 col-12">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control" />
        </div>
<%--        <div class="mt-3 col-6">--%>

<%--        </div>--%>
        <div class="mt-3 col-12">
            <label>Mật khẩu</label>
            <input type="password" name="matKhau" class="form-control" />
        </div>
<%--        <div class="mt-3 col-6">--%>

<%--        </div>--%>
        <center><div class="mt-3">
            <button class="btn btn-primary">Đăng nhập</button>
        </div></center>

    </form>
        <div class="col-3"></div>
</div>
    </div>
</div>
