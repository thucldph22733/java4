
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Khách Hàng</title>
    <link rel="stylesheet"
          href="/assignment_war_exploded/css/bootstrap.min.css"/>
</head>
<body>
<h2><center style="color: #0b5ed7;font-style: normal;margin: 40px">Create Khách Hàng</center></h2>
<div class="col-8 offset-2">
    <form method="POST"
          action="/assignment_war_exploded/khach-hang/store">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" />
                <span style="color:red;font-size: 16px">${trungMa}</span>
                <span style="color:red;font-size: 16px">${checkMa}</span>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <input type="text" name="ho" class="form-control" />
                <span style="color:red;font-size: 16px">${checkHo}</span>

            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <input type="text" name="tenDem" class="form-control" />
                <span style="color:red;font-size: 16px">${checkTenDem}</span>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" />
                <span style="color:red;font-size: 16px">${checkTen}</span>

            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày sinh</label>
                <input type="date" name="ngaySinh" class="form-control" />
                <span style="color:red;font-size: 16px">${checkNgaySinh}</span>
            </div>
            <div class="col-6">
                <label>SDT</label>
                <input type="tel" name="sdt" class="form-control" />
                <span style="color:red;font-size: 16px">${checkSDT}</span>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <input type="text" name="diaChi" class="form-control" />
                <span style="color:red;font-size: 16px">${checkDiaChi}</span>
            </div>
            <div class="col-6">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" class="form-control" />
                <span style="color:red;font-size: 16px">${checkMatKhau}</span>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Quốc gia</label>
                <select name="quocGia" class="form-select">
                    <option value="vi">Việt Nam</option>
                    <option value="us">Mỹ</option>
                </select>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <select name="thanhPho" class="form-select">
                    <option value="ha_noi">Hà Nội</option>
                    <option value="new_york">New York</option>
                </select>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <button class="btn btn-primary">Thêm mới</button>
            </div>
            <div class="col-6"></div>
        </div>
    </form>
</div>
<script src="/assignment_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
