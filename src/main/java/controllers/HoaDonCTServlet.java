package controllers;

import Repository.HoaDonCTRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view_model.QlHoaDonCT;

import java.io.IOException;

@WebServlet({
        "/hd-ct/index",
})
public class HoaDonCTServlet extends HttpServlet {
    private HoaDonCTRepository hdctR = new HoaDonCTRepository();
    public HoaDonCTServlet(){

    }

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {
            this.index(req,res);
    }

    protected void index(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {
       req.setAttribute("danhSachHDCT",this.hdctR.findAll());
       req.setAttribute("view","/views/hd_ct/index.jsp");
        req.getRequestDispatcher("/views/layout2.jsp")
                .forward(req,res);
    }
    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {
        this.store(req,res);
    }
    protected void store(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        String hoa_don = req.getParameter("hoa_don");
        String ct_sp  = req.getParameter("ct_sp");
        int so_luong = Integer.parseInt(req.getParameter("so_luong"));
        String don_gia = req.getParameter("don_gia");
        QlHoaDonCT hdct = new QlHoaDonCT(hoa_don,ct_sp,so_luong,don_gia);
        this.hdctR.insert(hdct);
        res.sendRedirect("/assignment_war_exploded/hd-ct/index");
    }
}
