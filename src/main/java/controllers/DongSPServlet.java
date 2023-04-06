package controllers;

import Repository.DongSPRepository;
import domain_model.ChucVu;
import domain_model.DongSP;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import view_model.QLDongSp;

import java.io.IOException;

@WebServlet({
        "/dong-sp/create",   // GET
        "/dong-sp/store",
        "/dong-sp/index",
        "/dong-sp/delete",
        "/dong-sp/edit",
})
public class DongSPServlet extends HttpServlet {
   private DongSPRepository dR = new DongSPRepository();
   public DongSPServlet(){

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
        request.setAttribute("view","/views/dong_sp/create.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);

    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        DongSP doMainModelSP = this.dR.findByMa(ma);
        this.dR.delete(doMainModelSP);
        response.sendRedirect("/assignment_war_exploded/dong-sp/index");
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
       String ma = request.getParameter("ma");
       DongSP doMainModelSP = this.dR.findByMa(ma);
       request.setAttribute("d",doMainModelSP);
        request.setAttribute("view","/views/dong_sp/edit.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request,response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachDSP",this.dR.findAll());
        request.setAttribute("view","/views/dong_sp/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
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
            response.sendRedirect("/assignment_war_exploded/dong-sp/index");
        }
    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try{
            DongSP doMainModelSP = new DongSP();
            BeanUtils.populate(doMainModelSP,request.getParameterMap());
            this.dR.update(doMainModelSP);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/assignment_war_exploded/dong-sp/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try{
            String ma = request.getParameter("ma");
            DongSP doMainModelSP = this.dR.findByMa(ma);
            BeanUtils.populate(doMainModelSP,request.getParameterMap());
            this.dR.update(doMainModelSP);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/assignment_war_exploded/dong-sp/index");
    }
}
