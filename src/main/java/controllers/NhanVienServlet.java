package controllers;

import Repository.ChucVuRepository;
import Repository.CuaHangRepository;
import Repository.NhanVienRepository;
import domain_model.ChucVu;
import domain_model.CuaHang;
import domain_model.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import utils.Validate;
import view_model.QLNhanVien;

import java.io.IOException;
import java.util.UUID;

@WebServlet({
        "/nhan-vien/index",
        "/nhan-vien/create",   // GET
        "/nhan-vien/edit",     // GET
        "/nhan-vien/delete",   // GET
        "/nhan-vien/store",    // POST
        "/nhan-vien/update",   // POST
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nR = new NhanVienRepository();
    private ChucVuRepository cvR = new ChucVuRepository();
    private CuaHangRepository chR = new CuaHangRepository();

    private String error;
    private String errorMa;
    private String errorTen;
    private String errorHo;
    private String errorTenDem;
    private String errorNgaySinh;
    private String errorDiaChi;
    private String errorMatKhau;
    private String errorSDT;
    public NhanVienServlet(){
       }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request, response);
        }else if(uri.contains("edit")){
            this.edit(request,response);
        }else if(uri.contains("delete")){
            this.delete(request,response);
        }else {
            this.index(request,response);
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

        request.setAttribute("danhSachCH",this.chR.findAll());
        request.setAttribute("danhSachCV",this.cvR.findAll());
        request.setAttribute("view","/views/nhan_vien/create.jsp");
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
       String ma = request.getParameter("ma");
       NhanVien doMainModelNV = this.nR.findByMa(ma);
        this.nR.delete(doMainModelNV);
        response.sendRedirect("/assignment_war_exploded/nhan-vien/index");
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachCH",this.chR.findAll());
        request.setAttribute("danhSachCV",this.cvR.findAll());
        String ma = request.getParameter("ma");
        NhanVien doMainModelNV = this.nR.findByMa(ma);
        request.setAttribute("n",doMainModelNV);
        request.setAttribute("view","/views/nhan_vien/edit.jsp");
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request,response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachNV",this.nR.findAll());
        request.setAttribute("view","/views/nhan_vien/index.jsp");
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request,response);
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
            response.sendRedirect("/assignment_war_exploded/nhan-vien/index");
        }
    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        NhanVien nv = new NhanVien();
        try {
//
//            DateTimeConverter converter = new DateConverter(new Date());
//            converter.setPattern("MM/dd/yyyy");
//            ConvertUtils.register(converter,Date.class);
            BeanUtils.populate(nv, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
//            NhanVien doMainModelNV = new NhanVien();
//            String maCv = request.getParameter("idCV");
//            String maCh = request.getParameter("idCH");
//            UUID idCV = UUID.fromString(maCv);
//            UUID idCH = UUID.fromString(maCh);
//            ChucVu DomainModelCv = this.cvR.findById(idCV);
//            CuaHang DomainModelCh = this.chR.findById(idCH);
//
//            doMainModelNV.setMa(doMainModelNV.getMa());
//            doMainModelNV.setTen(doMainModelNV.getTen());
//            doMainModelNV.setTenDem(doMainModelNV.getTenDem());
//            doMainModelNV.setHo(doMainModelNV.getHo());
//            doMainModelNV.setGioiTinh(doMainModelNV.getGioiTinh());
//            doMainModelNV.setNgaySinh(doMainModelNV.getNgaySinh());
//            doMainModelNV.setDiaChi(doMainModelNV.getDiaChi());
//            doMainModelNV.setSdt(doMainModelNV.getSdt());
//            doMainModelNV.setMatKhau(doMainModelNV.getMatKhau());
//            doMainModelNV.setCuaHang(DomainModelCh);
//            doMainModelNV.setChucVu(DomainModelCv);
//            doMainModelNV.setTrangThai(doMainModelNV.getTrangThai());

        String maCV  = request.getParameter("idCV");
        String maCH  = request.getParameter("idCH");
        UUID idCV  = UUID.fromString(maCV);
        UUID idCH = UUID.fromString(maCH);
        ChucVu chucVu = this.cvR.findById(idCV);
        CuaHang cuaHang = this.chR.findById(idCH);
        nv.setChucVu(chucVu);
        nv.setCuaHang(cuaHang);
        errorTen = Validate.checkValues(nv.getTen(), "Tên");
        errorMa = Validate.checkValues(nv.getMa(), "Mã");
        errorTenDem = Validate.checkValues(nv.getTenDem(), "Tên đệm");
        errorNgaySinh = Validate.checkValues(nv.getNgaySinh(), "Ngày sinh");
        errorDiaChi = Validate.checkValues(nv.getDiaChi(), "Địa chỉ");
        errorHo = Validate.checkValues(nv.getHo(), "Họ");
        errorMatKhau = Validate.checkValues(nv.getMatKhau(), "Mật khẩu");
        errorSDT = Validate.checkValues(nv.getSdt(), "Số điện thoại");
        NhanVien check = nR.findByMa(nv.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            response.sendRedirect("/assignment_war_exploded/nhan-vien/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty()|| !errorHo.isEmpty()|| !errorTenDem.isEmpty()|| !errorDiaChi.isEmpty()|| !errorNgaySinh.isEmpty()|| !errorSDT.isEmpty()|| !errorMatKhau.isEmpty()) {
            response.sendRedirect("/assignment_war_exploded/nhan-vien/create");
            return;
        }
        this.nR.insert(nv);
            response.sendRedirect("/assignment_war_exploded/nhan-vien/index");
        }



    protected void update(
            HttpServletRequest req,
            HttpServletResponse res
    )throws ServletException, IOException {
        String ma = req.getParameter("ma");
        NhanVien nv = this.nR.findByMa(ma);
        try {

//            DateTimeConverter converter = new DateConverter(new Date());
//            converter.setPattern("MM/dd/yyyy");
//            ConvertUtils.register(converter,Date.class);
            BeanUtils.populate(nv, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String maCV  = req.getParameter("idCV");
        String maCH  = req.getParameter("idCH");
        UUID idCV  = UUID.fromString(maCV);
        UUID idCH = UUID.fromString(maCH);
        ChucVu chucVu = this.cvR.findById(idCV);
        CuaHang cuaHang = this.chR.findById(idCH);
        nv.setChucVu(chucVu);
        nv.setCuaHang(cuaHang);
        errorTen = Validate.checkValues(nv.getTen(), "Tên");
        errorTenDem = Validate.checkValues(nv.getTenDem(), "Tên đệm");
        errorNgaySinh = Validate.checkValues(nv.getNgaySinh(), "Ngày sinh");
        errorDiaChi = Validate.checkValues(nv.getDiaChi(), "Địa chỉ");
        errorHo = Validate.checkValues(nv.getHo(), "Họ");
        errorMatKhau = Validate.checkValues(nv.getMatKhau(), "Mật khẩu");
        errorSDT = Validate.checkValues(nv.getSdt(), "Số điện thoại");
        if (!errorTen.isEmpty() ||!errorHo.isEmpty()|| !errorTenDem.isEmpty()|| !errorDiaChi.isEmpty()|| !errorNgaySinh.isEmpty()|| !errorSDT.isEmpty()|| !errorMatKhau.isEmpty()) {
            res.sendRedirect("/assignment_war_exploded/nhan-vien/edit?ma="+nv.getMa());
            return;
        }
        nR.update(nv);
        res.sendRedirect("/assignment_war_exploded/nhan-vien/index");
    }
}

