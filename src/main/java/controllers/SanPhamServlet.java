package controllers;

import Repository.ChiTietSanPhamRepository;
import Repository.SanPhamRepository;
import domain_model.ChiTietSP;
import domain_model.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import utils.Validate;
import view_model.QLSanPham;

import java.io.IOException;


@WebServlet({
        "/san-pham/create",   // GET
        "/san-pham/edit",     // GET
        "/san-pham/delete",   // GET
        "/san-pham/index",
        "/san-pham/store",    // POST
        "/san-pham/update",   // POST
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository sR = new SanPhamRepository();
    private ChiTietSanPhamRepository ctR = new ChiTietSanPhamRepository();
    public SanPhamServlet(){
    }
    private String error;
    private String errorMa;
    private String errorTen;
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request,response);
        } else if (uri.contains("delete")) {
            this.delete(request,response);
        } else {
            this.index(request, response);
        }
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("trungMa", error);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("checkMa", errorMa);

        request.setAttribute("view","/views/san_pham/create.jsp");
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request,response);

    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham doMainModelSP = this.sR.findByMa(ma);
        this.sR.delete(doMainModelSP);
        response.sendRedirect("/assignment_war_exploded/san-pham/index");
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        SanPham doMainModelSP = this.sR.findByMa(ma);
        request.setAttribute("s",doMainModelSP);
        request.setAttribute("view","/views/san_pham/edit.jsp");
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request,response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
//        request.setAttribute("danhSachCT",this.ctR.findAll());
        request.setAttribute("danhSachSP",this.sR.findAll());
        request.setAttribute("view","/views/san_pham/index.jsp");
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
            response.sendRedirect("/assignment_war_exploded/san-pham/index");
        }
    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        SanPham doMainModelSP = new SanPham();

        try{
            BeanUtils.populate(doMainModelSP,request.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        errorTen = Validate .checkValues(doMainModelSP.getTen(), "Tên");
        errorMa = Validate.checkValues(doMainModelSP.getMa(), "Mã");
        SanPham check = sR.findByMa(doMainModelSP.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            response.sendRedirect("/assignment_war_exploded/san-pham/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty()) {
            response.sendRedirect("/assignment_war_exploded/san-pham/create");
            return;
        }
        this.sR.update(doMainModelSP);
        response.sendRedirect("/assignment_war_exploded/san-pham/index");
    }
    protected void update(
            HttpServletRequest req,
            HttpServletResponse res
    )throws ServletException, IOException {
        String ma = req.getParameter("ma");
        SanPham doMainModelSP =this.sR.findByMa(ma);
        try{

            BeanUtils.populate(doMainModelSP,req.getParameterMap());

        }catch (Exception e){
            e.printStackTrace();
        }errorTen = Validate.checkValues(doMainModelSP.getTen(), "Tên");
        if (!errorTen.isEmpty()) {
            res.sendRedirect("/assignment_war_exploded/san-pham/edit?ma=" + doMainModelSP.getMa());
            return;
        }
        this.sR.update(doMainModelSP);
        res.sendRedirect("/assignment_war_exploded/san-pham/index");
    }
}
