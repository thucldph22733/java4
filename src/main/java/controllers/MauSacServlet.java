package controllers;

import Repository.MauSacRepository;
import domain_model.MauSac;
import domain_model.NSX;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import utils.Validate;

import java.io.IOException;

@WebServlet({
        "/mau-sac/create",
        "/mau-sac/edit",
        "/mau-sac/update",
        "/mau-sac/store",
        "/mau-sac/delete",
        "/mau-sac/index",// GET

})
public class MauSacServlet extends HttpServlet {
   private MauSacRepository mR = new MauSacRepository();
   public MauSacServlet(){
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
        if(uri.contains("create")){
            this.create(request, response);
        }else if(uri.contains("edit")){
            this.edit(request,response);
        }else if(uri.contains("delete")){
            this.delete(request,response);
        }else if(uri.contains("update")){
            //this.update(req,res);
        }else {
            this.index(request,response);
        }
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
       request.setAttribute("trungMa", error);
        request.setAttribute("checkTen", errorTen);
        request.setAttribute("checkMa", errorMa);
        request.setAttribute("view","/views/mau_sac/create.jsp");
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request,response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac mS= this.mR.findByMa(ma);
        this.mR.delete(mS);
        response.sendRedirect("/assignment_war_exploded/mau-sac/index");
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        MauSac mS = this.mR.findByMa(ma);
        request.setAttribute("m",mS);
        request.setAttribute("view","/views/mau_sac/edit.jsp");
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request,response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachMS",this.mR.findAll());
        request.setAttribute("view","/views/mau_sac/index.jsp");
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
            response.sendRedirect("/assignment_war_exploded/mau-sac/index");
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        MauSac mS = new MauSac();
           try{

               BeanUtils.populate(mS,request.getParameterMap());

           }catch (Exception e){
               e.printStackTrace();
           } errorTen = Validate.checkValues(mS.getTen(), "Tên");
        errorMa = Validate.checkValues(mS.getMa(), "Mã");
        MauSac check = mR.findByMa(mS.getMa());
        if (check != null) {
            error = "Mã đã tồn tại!";
            response.sendRedirect("/assignment_war_exploded/nsx/create");
            return;
        } else {
            error = "";
        }
        if (!errorTen.isEmpty() || !errorMa.isEmpty()) {
            response.sendRedirect("/assignment_war_exploded/nsx/create");
            return;
        }
        this.mR.insert(mS);
           response.sendRedirect("/assignment_war_exploded/mau-sac/index");
       }



    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        try{
            String ma = request.getParameter("ma");
            MauSac mS = this.mR.findByMa(ma);
            BeanUtils.populate(mS,request.getParameterMap());
            this.mR.update(mS);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("/assignment_war_exploded/mau-sac/index");
    }
}
