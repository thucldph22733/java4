package controllers;

import Repository.NhanVienRepository;
import domain_model.NhanVien;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    private NhanVienRepository nvR = new NhanVienRepository();
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {
        req.setAttribute("view", "/views/login.jsp");
        req.getRequestDispatcher("/views/layout2.jsp")
                .forward(req, res);
    }
    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse res)
            throws ServletException, IOException {
        String ma = req.getParameter("ma");
        String matKhau = req.getParameter("matKhau");
        NhanVien nv = this.nvR.login(ma,matKhau);
        HttpSession session = req.getSession();
        if(nv==null){
            session.setAttribute("errorMessage","Sai Tài Khoản Hoặc Mật Khẩu!");
            res.sendRedirect("/assignment_war_exploded/login");
        }else{
            session.setAttribute("nv",nv);
            res.sendRedirect("/assignment_war_exploded/ban-hang");
        }
    }
}
