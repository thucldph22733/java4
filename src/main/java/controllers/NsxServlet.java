package controllers;

import Repository.NsxRepository;
import domain_model.NSX;
import domain_model.SanPham;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;
import utils.Validate;
import view_model.QLNsx;
import java.io.IOException;

@WebServlet({
        "/nsx/create",   // GET
        "/nsx/store",
        "/nsx/delete",
        "/nsx/update",
        "/nsx/index",
        "/nsx/edit",

})
public class NsxServlet extends HttpServlet {
    private NsxRepository nR = new NsxRepository();
    public NsxServlet(){
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
        request.setAttribute("view","/views/nsx/create.jsp");
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request,response);

    }
    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX doMainModelNSX = this.nR.findByMa(ma);
        this.nR.delete(doMainModelNSX);
        response.sendRedirect("/assignment_war_exploded/nsx/index");
    }
    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NSX doMainModelNSX = this.nR.findByMa(ma);
        request.setAttribute("n",doMainModelNSX);
        request.setAttribute("view","/views/nsx/edit.jsp");
        request.getRequestDispatcher("/views/layout2.jsp")
                .forward(request,response);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachNSX",this.nR.findAll());
        request.setAttribute("view","/views/nsx/index.jsp");
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
            response.sendRedirect("/assignment_war_exploded/nsx/index");
        }
    }
    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        NSX doMainModelNSX = new NSX();
            try{
                BeanUtils.populate(doMainModelNSX,request.getParameterMap());

            }catch (Exception e){
                e.printStackTrace();
            }
            errorTen = Validate.checkValues(doMainModelNSX.getTen(), "Tên");
            errorMa = Validate.checkValues(doMainModelNSX.getMa(), "Mã");
            NSX check = nR.findByMa(doMainModelNSX.getMa());
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
        this.nR.insert(doMainModelNSX);
            response.sendRedirect("/assignment_war_exploded/nsx/index");
        }


    protected void update(
            HttpServletRequest req,
            HttpServletResponse res
    )throws ServletException, IOException {

        try{
            String ma = req.getParameter("ma");
            NSX doMainModelNSX = this.nR.findByMa(ma);
            BeanUtils.populate(doMainModelNSX,req.getParameterMap());
            this.nR.update(doMainModelNSX);
        }catch (Exception e){
            e.printStackTrace();
        }
        res.sendRedirect("/assignment_war_exploded/nsx/index");
    }
}
