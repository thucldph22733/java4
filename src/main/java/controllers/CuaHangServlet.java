package controllers;

import Repository.CuaHangRepository;
import domain_model.CuaHang;
import domain_model.NSX;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import utils.Validate;
import view_model.QLCuaHang;

import java.io.IOException;

@WebServlet({
        "/cua-hang/create",
        "/cua-hang/store",
        "/cua-hang/index",
        "/cua-hang/delete",
        "/cua-hang/edit",
        "/cua-hang/update",
})
public class CuaHangServlet extends HttpServlet {
   private CuaHangRepository chR = new CuaHangRepository();

    public CuaHangServlet () {

    }
    private String error;
    private String errorMa;
    private String errorTen;

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("create")){
            this.create(req, res);
        }else if(uri.contains("edit")){
            this.edit(req,res);
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
        req.setAttribute("trungMa", error);
        req.setAttribute("checkTen", errorTen);
        req.setAttribute("checkMa", errorMa);
        req.setAttribute("view","/views/cua_hang/create.jsp");
        req.getRequestDispatcher("/views/layout2.jsp")
                .forward(req,res);
    }
    protected void delete(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
       String ma = req.getParameter("ma");
        CuaHang doMainModelCH = this.chR.findByMa(ma);
       this.chR.delete(doMainModelCH);
       res.sendRedirect("/assignment_war_exploded/cua-hang/index");
    }
    protected void edit(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        CuaHang doMainModelCH = this.chR.findByMa(ma);
        req.setAttribute("ch",doMainModelCH);
        req.setAttribute("view","/views/cua_hang/edit.jsp");
        req.getRequestDispatcher("/views/layout2.jsp")
                .forward(req,res);

    }
    protected void index(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        req.setAttribute("danhSachCH",this.chR.findAll());
        req.setAttribute("view","/views/cua_hang/index.jsp");
        req.getRequestDispatcher("/views/layout2.jsp").forward(req,res);
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
            res.sendRedirect("/assignment_war_exploded/cua-hang/index");
        }
    }
    protected void store(
            HttpServletRequest req,
            HttpServletResponse res
    ) throws ServletException, IOException {
        CuaHang doMainModelCH = new CuaHang();
        try {
            BeanUtils.populate(doMainModelCH, req.getParameterMap());

        } catch (Exception e) {
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(doMainModelCH.getTen(), "Tên");
        errorMa = Validate.checkValues(doMainModelCH.getMa(), "Mã");
        CuaHang check = chR.findByMa(doMainModelCH.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            res.sendRedirect("/assignment_war_exploded/nsx/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty()) {
            res.sendRedirect("/assignment_war_exploded/nsx/create");
            return;
        }
        this.chR.insert(doMainModelCH);
        res.sendRedirect("/assignment_war_exploded/cua-hang/index");
    }
    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        try {
            String ma = request.getParameter("ma");
            CuaHang doMainModelCH = this.chR.findByMa(ma);
            BeanUtils.populate(doMainModelCH, request.getParameterMap());
            this.chR.update(doMainModelCH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/assignment_war_exploded/cua-hang/index");
    }

}
