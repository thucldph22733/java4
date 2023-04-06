package controllers;

import Repository.GioHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLGioHang;

import java.io.IOException;


@WebServlet({
        "/gio-hang/create",
        "/gio-hang/store",
        "/gio-hang/index",
        "/gio-hang/delete",
        "/gio-hang/edit",
        "/gio-hang/update",

})
public class GioHangServlet extends HttpServlet {
    private GioHangRepository gR = new GioHangRepository();
    public GioHangServlet(){

    }
    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
       String uri = req.getRequestURI();
       if(uri.contains("create")){
           this.create(req,res);
       }else if(uri.contains("edit")){
           this.edit(req,res);
       }else if(uri.contains("update")){
//           this.edit(req,res);
       }else if(uri.contains("delete")){
           this.delete(req,res);
       }else {
           this.index(req,res);
       }
    }
    protected void create(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        req.setAttribute("view","/views/gio_hang/create.jsp");
        req.getRequestDispatcher("/views/layout2.jsp")
                .forward(req,res);
    }
    protected void edit(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        QLGioHang g = this.gR.findByMa(ma);
        req.setAttribute("g",g);
        req.setAttribute("view","/views/gio_hang/edit.jsp");
        req.getRequestDispatcher("/views/layout2.jsp")
                .forward(req,res);
    }
    protected void delete(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        QLGioHang g = this.gR.findByMa(ma);
        this.gR.delete(g);
        res.sendRedirect("/assignment_war_exploded/gio-hang/index");
    }
    protected void index(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        req.setAttribute("danhSachGioHang",this.gR.findAll());
        req.setAttribute("view","/views/gio_hang/index.jsp");
        req.getRequestDispatcher("/views/layout2.jsp")
                .forward(req,res);
    }

    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req, res);
        } else if (uri.contains("update")) {
            this.update(req, res);
        } else {
            res.sendRedirect("/assignment_war_exploded/gio-hang/index");
        }
    }
    protected void store(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        String ngay_tao = req.getParameter("ngay_tao");
        String ngay_thanh_toan= req.getParameter("ngay_thanh_toan");
        String ten_nguoi_nhan = req.getParameter("ten_nguoi_nhan");
        String dia_chi = req.getParameter("dia_chi");
        String sdt = req.getParameter("sdt");
        int tinh_trang = Integer.parseInt(req.getParameter("tinh_trang"));
        String nhan_vien  = req.getParameter("nhan_vien");
        String khach_hang = req.getParameter("khach_hang");
        QLGioHang g= new QLGioHang(ma,ngay_tao,ngay_thanh_toan,ten_nguoi_nhan,dia_chi,sdt,tinh_trang,khach_hang,nhan_vien);
        this.gR.insert(g);
        res.sendRedirect("/assignment_war_exploded/gio-hang/index");
    }
    protected void update(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        QLGioHang g = new QLGioHang();
        try {
            BeanUtils.populate(g,req.getParameterMap());
            this.gR.update(g);
        } catch (Exception e) {
            e.printStackTrace();
        }
        res.sendRedirect("/assignment_war_exploded/gio-hang/index");
    }
}
