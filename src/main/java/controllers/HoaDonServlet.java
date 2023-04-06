package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import Repository.HoaDonRepository;
import view_model.QLHoaDon;

import java.io.IOException;
@WebServlet({
        "/hoa-don/index",
        "/hoa-don/store",
        "/hoa-don/update",
        "/hoa-don/edit",
        "/hoa-don/delete",
        "/hoa-don/create",
})
public class HoaDonServlet extends HttpServlet {
    private HoaDonRepository hdR = new HoaDonRepository();
    public HoaDonServlet(){
        this.hdR = new HoaDonRepository();
        this.hdR.insert(new QLHoaDon("","","123","2023-3-23","2023-3-23","2023-3-23","2023-3-23",0,"aaa","HN","098777622"));
    }

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("create")){
            this.create(req,res);
        }else if(uri.contains("edit")){
            this.edit(req,res);
        }else if(uri.contains("delete")){
            this.delete(req,res);
        }else {
            this.index(req,res);
        }
    }
    protected void delete(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        QLHoaDon h = this.hdR.getByMa(ma);
        this.hdR.delete(h);
        res.sendRedirect("/assignment_war_exploded/hoa-don/index");
    }
    protected void edit(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
       String ma = req.getParameter("ma");
       QLHoaDon h = this.hdR.getByMa(ma);
       req.setAttribute("h",h);
        req.setAttribute("view","/views/hoa_don/edit.jsp");
        req.getRequestDispatcher("/views/layout.jsp")
                .forward(req,res);

    }
    protected void create(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        req.setAttribute("view","/views/hoa_don/create.jsp");
        req.getRequestDispatcher("/views/layout.jsp")
                .forward(req,res);
    }
    protected void index(
            HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {
        req.setAttribute("danhSachHoaDon",this.hdR.findAll());
        req.setAttribute("view","/views/hoa_don/index.jsp");
        req.getRequestDispatcher("/views/layout.jsp")
                .forward(req,res);
    }
    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res)
            throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req, res);
        } else if (uri.contains("update")) {
            this.update(req, res);
        } else {
            res.sendRedirect("/assignment_war_exploded/hoa-don/index");
        }
    }
    protected void store(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        String khach_hang = req.getParameter("khach_hang");
        String nhan_vien  = req.getParameter("nhan_vien");
        String ma = req.getParameter("ma");
        String ngay_tao = req.getParameter("ngay_tao");
        String ngay_thanh_toan= req.getParameter("ngay_thanh_toan");
        String ngay_ship= req.getParameter("ngay_ship");
        String ngay_nhan= req.getParameter("ngay_nhan");
        int tinh_trang = Integer.parseInt(req.getParameter("tinh_trang"));
        String ten_nguoi_nhan = req.getParameter("ten_nguoi_nhan");
        String dia_chi = req.getParameter("dia_chi");
        String sdt = req.getParameter("sdt");

        QLHoaDon h= new QLHoaDon(khach_hang,nhan_vien,ma,ngay_tao,ngay_thanh_toan,
                ngay_ship,ngay_nhan,tinh_trang,ten_nguoi_nhan,dia_chi,sdt);
        this.hdR.insert(h);
        res.sendRedirect("/assignment_war_exploded/hoa-don/index");
    }
    protected void update(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        QLHoaDon h = new QLHoaDon();
        try {
            BeanUtils.populate(h,req.getParameterMap());
            this.hdR.update(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        res.sendRedirect("/assignment_war_exploded/hoa-don/index");
    }

}
