package controllers;

import Repository.*;
import domain_model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import utils.Validate;

import java.io.IOException;
import java.util.UUID;

@WebServlet({
        "/ct-sp/create",
        "/ct-sp/store",
        "/ct-sp/delete",
        "/ct-sp/index",
        "/ct-sp/update",
        "/ct-sp/edit",
})
public class ChiTietSanPhamServlet extends HttpServlet {
   private ChiTietSanPhamRepository ctR = new ChiTietSanPhamRepository();
    private MauSacRepository mR = new MauSacRepository();
    private DongSPRepository dR = new DongSPRepository();
    private SanPhamRepository sR = new SanPhamRepository();
    private NsxRepository nR = new NsxRepository();


    private String errorNamBH;
    private String errorMoTa;
    private String errorSoLuongTon;
    private String errorGiaNhap;
    private String errorGiaBan;
    private String errorAnh;
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("create")){
            this.create(request, response);
        }else {
            this.index(request,response);
        }
    }
    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("checkNamBH", errorNamBH);
        request.setAttribute("checkMoTa", errorMoTa);
        request.setAttribute("checkSoLuongTon", errorSoLuongTon);
        request.setAttribute("checkGiaNhap", errorGiaNhap);
        request.setAttribute("checkGiaBan", errorGiaBan);
        request.setAttribute("checkAnh", errorAnh);

        request.setAttribute("view","/views/ct_sp/create.jsp");
        request.setAttribute("danhSachSP",this.sR.findAll());
        request.setAttribute("danhSachMS",this.mR.findAll());
        request.setAttribute("danhSachNSX",this.nR.findAll());
        request.setAttribute("danhSachDSP",this.dR.findAll());

        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChiTietSP doMainModelCT = this.ctR.findByMa(ma);
        this.ctR.delete(doMainModelCT);
        response.sendRedirect("/assignment_war_exploded/ct-sp/index");
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("checkNamBH", errorNamBH);
        request.setAttribute("checkMoTa", errorMoTa);
        request.setAttribute("checkSoLuongTon", errorSoLuongTon);
        request.setAttribute("checkGiaNhap", errorGiaNhap);
        request.setAttribute("checkGiaBan", errorGiaBan);
        request.setAttribute("checkAnh", errorAnh);

        String ma = request.getParameter("ma");
        ChiTietSP doMainModelCT = this.ctR.findByMa(ma);
        request.setAttribute("ct", doMainModelCT);
        request.getRequestDispatcher("/views/ct_sp/edit.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachCT",this.ctR.findAll());
        request.setAttribute("view","/views/ct_sp/index.jsp");
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request .getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else {
            response.sendRedirect("/assignment_war_exploded/ct-sp/index");
        }

    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        ChiTietSP doMainModelCT = new ChiTietSP();
        try{
            BeanUtils.populate(doMainModelCT,request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        String idMauSac = request.getParameter("idMauSac");
        String idSP = request.getParameter("idSP");
        String idNsx = request.getParameter("idNsx");
        String idDongSP = request.getParameter("idDongSP");

        UUID idMS = UUID.fromString(idMauSac);
        UUID idSP2 = UUID.fromString(idSP);
        UUID idNsx2 = UUID.fromString(idNsx);
        UUID idDongSP2 = UUID.fromString(idDongSP);

        MauSac DomainModelMs = this.mR.findByID(idMS);
        SanPham DomainModelSP = this.sR.findById(idSP2);
        NSX DomainModelNSx = this.nR.findById(idNsx2);
        DongSP DomainModelDSp = this.dR.findById(idDongSP2);

        doMainModelCT.setNsx(DomainModelNSx);
        doMainModelCT.setDongSP(DomainModelDSp);
        doMainModelCT.setSanPham(DomainModelSP);
        doMainModelCT.setMauSac(DomainModelMs);

        errorMoTa = Validate.checkValues(doMainModelCT.getMoTa(),"Mô tả");
        errorNamBH = Validate.checkValues(doMainModelCT.getNamBH(),"Năm bảo hành");
        errorSoLuongTon = Validate.checkValues(doMainModelCT.getMoTa(),"Số lượng tồn");
        errorGiaNhap = Validate.checkValues(doMainModelCT.getMoTa(),"Giá nhập");
        errorGiaBan = Validate.checkValues(doMainModelCT.getMoTa(),"Giá bán");
        errorAnh = Validate.checkValues(doMainModelCT.getImg(),"Img");


        if (!errorNamBH.isEmpty()||!errorMoTa.isEmpty()||!errorSoLuongTon.isEmpty()||!errorGiaNhap.isEmpty()||!errorGiaBan.isEmpty()||!errorAnh.isEmpty()){
            response.sendRedirect("/assignment_war_exploded/ct-sp/create");
            return;
        }

        this.ctR.insert(doMainModelCT);
        response.sendRedirect("/assignment_war_exploded/ct-sp/index");
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChiTietSP spct = this.ctR.findById(id);
        try {
            BeanUtils.populate(spct, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String idMauSac = request.getParameter("idMauSac");
        String idSanPham = request.getParameter("idSanPham");
        String idNSX = request.getParameter("idNSX");
        String idDongSP = request.getParameter("idDongSP");

        UUID idMS = UUID.fromString(idMauSac);
        UUID idSP = UUID.fromString(idSanPham);
        UUID idNsx2 = UUID.fromString(idNSX);
        UUID idDongSP2 = UUID.fromString(idDongSP);

        MauSac ms = this.mR.findByID(idMS);
        SanPham sp = this.sR.findById(idSP);
        NSX nsx = this.nR.findById(idNsx2);
        DongSP dsp = this.dR.findById(idDongSP2);

        spct.setMauSac(ms);
        spct.setSanPham(sp);
        spct.setNsx(nsx);
        spct.setDongSP(dsp);
        errorNamBH = Validate.checkValues(spct.getNamBH(),"Năm bảo hành");
        errorMoTa = Validate.checkValues(spct.getMoTa(),"Mô tả");
        errorSoLuongTon = Validate.checkValues(spct.getMoTa(),"Số lượng tồn");
        errorGiaNhap = Validate.checkValues(spct.getMoTa(),"Giá nhập");
        errorGiaBan = Validate.checkValues(spct.getMoTa(),"Giá bán");
        errorAnh = Validate.checkValues(spct.getImg(),"Img");


        if (!errorNamBH.isEmpty()||!errorMoTa.isEmpty()||!errorSoLuongTon.isEmpty()||!errorGiaNhap.isEmpty()||!errorGiaBan.isEmpty()||!errorAnh.isEmpty()){
            response.sendRedirect("/assignment_war_exploded/ct-sp/create");
            return;
        }
        this.ctR.update(spct);
        response.sendRedirect("/assignment_war_exploded/ct-sp/index");
    }
}
