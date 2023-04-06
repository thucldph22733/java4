package controllers;

import domain_model.KhachHang;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import Repository.KhachHangRepository;
import utils.Validate;

import java.io.IOException;

@WebServlet({
        "/khach-hang/index",    // GET
        "/khach-hang/create",   // GET
        "/khach-hang/edit",     // GET
        "/khach-hang/delete",   // GET
        "/khach-hang/store",    // POST
        "/khach-hang/update",   // POST
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khr;
    public KhachHangServlet()
    {
        this.khr = new KhachHangRepository();
    }
    private String error;
    private String errorMa;
    private String errorTen;
    private String errorHo;
    private String errorTenDem;
    private String errorNgaySinh;
    private String errorDiaChi;
    private String errorMatKhau;
    private String errorSDT;
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        request.setAttribute("trungMa", error);
        request.setAttribute("checkMa", errorMa);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("checkHo", errorHo);
        request.setAttribute("checkTenDem", errorTenDem);
        request.setAttribute("checkNgaySinh", errorNgaySinh);
        request.setAttribute("checkMatKhau", errorMatKhau);
        request.setAttribute("checkDiaChi", errorDiaChi);
        request.setAttribute("checkSDT", errorSDT);
        request.setAttribute("view","/views/khach_hang/create.jsp");
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
       String ma = request.getParameter("ma");
       KhachHang domainModelKH = this.khr.findByMa(ma);
       this.khr.delete(domainModelKH);
       response.sendRedirect("/assignment_war_exploded/khach-hang/index");
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        KhachHang domainModelKH = this.khr.findByMa(ma);
        request.setAttribute("kh", domainModelKH);
        request.setAttribute("view","/views/khach_hang/edit.jsp");
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request,response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachKH", this.khr.findAll());
        request.setAttribute("view","/views/khach_hang/index.jsp" );
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/assignment_war_exploded/khach-hang/index");
        }
    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        KhachHang kh = new KhachHang();
        try {

            BeanUtils.populate(kh, request.getParameterMap());

        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(kh.getTen(), "Tên");
        errorMa = Validate.checkValues(kh.getMa(), "Mã");
        errorTenDem = Validate.checkValues(kh.getTenDem(), "Tên đệm");
        errorNgaySinh = Validate.checkValues(kh.getNgaySinh(), "Ngày sinh");
        errorDiaChi = Validate.checkValues(kh.getDiaChi(), "Địa chỉ");
        errorHo = Validate.checkValues(kh.getHo(), "Họ");
        errorMatKhau = Validate.checkValues(kh.getMatKhau(), "Mật khẩu");
        errorSDT = Validate.checkValues(kh.getSdt(), "Số điện thoại");
        KhachHang check = khr.findByMa(kh.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            response.sendRedirect("/assignment_war_exploded/khach-hang/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty() || !errorHo.isEmpty() || !errorTenDem.isEmpty() || !errorDiaChi.isEmpty() || !errorNgaySinh.isEmpty() || !errorSDT.isEmpty() || !errorMatKhau.isEmpty()) {
            response.sendRedirect("/assignment_war_exploded/khach-hang/create");
            return;
        }
        this.khr.insert(kh);
        response.sendRedirect("/assignment_war_exploded/khach-hang/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try {
            String ma = request.getParameter("ma");
            KhachHang domainModelKH = this.khr.findByMa(ma);
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            this.khr.update(domainModelKH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/assignment_war_exploded/khach-hang/index");
    }

}

