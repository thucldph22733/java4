package controllers;

import Repository.ChucVuRepository;
import domain_model.ChucVu;
import domain_model.CuaHang;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import utils.Validate;

import java.io.IOException;

@WebServlet({
        "/chuc-vu/create",
        "/chuc-vu/index",
        "/chuc-vu/store",
        "/chuc-vu/delete",
        "/chuc-vu/edit",
        "/chuc-vu/update",
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository cvR = new ChucVuRepository();
    public ChucVuServlet(){

}
    private String error;
    private String errorMa;
    private String errorTen;
    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse res
    )throws ServletException, IOException {
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
    )throws ServletException, IOException {
        req.setAttribute("trungMa", error);
        req.setAttribute("checkTen", errorTen);
        req.setAttribute("checkMa", errorMa);
        req.setAttribute("view","/views/chuc_vu/create.jsp");
        req.getRequestDispatcher("/views/layout2.jsp")
                .forward(req,res);
    }
    protected void delete(
            HttpServletRequest req,
            HttpServletResponse res
    )throws ServletException, IOException {
        String ma = req.getParameter("ma");
        ChucVu doMainModelCV = this.cvR.findByMa(ma);
        this.cvR.delete(doMainModelCV);
        res.sendRedirect("/assignment_war_exploded/chuc-vu/index");
    }
    protected void edit(
            HttpServletRequest req,
            HttpServletResponse res
    )throws ServletException, IOException {
        String ma = req.getParameter("ma");
        ChucVu doMainModelCV = this.cvR.findByMa(ma);
        req.setAttribute("cv", doMainModelCV);
        req.setAttribute("view","/views/chuc_vu/edit.jsp");
        req.getRequestDispatcher("/views/layout2.jsp")
                .forward(req,res);
    }

    protected void index(
            HttpServletRequest req,
            HttpServletResponse res
    )throws ServletException, IOException {
        req.setAttribute("danhSachCV",this.cvR.findAll());
        req.setAttribute("view","/views/chuc_vu/index.jsp");
        req.getRequestDispatcher("/views/layout2.jsp")
                .forward(req,res);
    }
    @Override
    protected void doPost(
            HttpServletRequest req,
            HttpServletResponse res
    )throws ServletException, IOException {
       String uri = req.getRequestURI();
        if (uri.contains("store")) {
            this.store(req, res);
        } else if (uri.contains("update")) {
            this.update(req, res);
        } else {
            res.sendRedirect("/assignment_war_exploded/chuc-vu/index");
        }
    }
    protected void store(
            HttpServletRequest req,
            HttpServletResponse res
    )throws ServletException, IOException {
        ChucVu doMainModelCV = new ChucVu();
        try{
            BeanUtils.populate(doMainModelCV,req.getParameterMap());
            this.cvR.insert(doMainModelCV);
        }catch (Exception e){
            e.printStackTrace();
        }
        errorTen = Validate.checkValues(doMainModelCV.getTen(), "Tên");
        errorMa = Validate.checkValues(doMainModelCV.getMa(), "Mã");
        ChucVu check = cvR.findByMa(doMainModelCV.getMa());
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
        this.cvR.insert(doMainModelCV);
        res.sendRedirect("/assignment_war_exploded/chuc-vu/index");
    }
    protected void update(
            HttpServletRequest req,
            HttpServletResponse res
    )throws ServletException, IOException {

        try{
            String ma = req.getParameter("ma");
            ChucVu doMainModelCV = this.cvR.findByMa(ma);
            BeanUtils.populate(doMainModelCV,req.getParameterMap());
            this.cvR.update(doMainModelCV);
        }catch (Exception e){
            e.printStackTrace();
        }
        res.sendRedirect("/assignment_war_exploded/chuc-vu/index");
    }
}