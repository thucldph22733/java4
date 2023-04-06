package controllers;

import Repository.ChiTietSanPhamRepository;
import Repository.SanPhamRepository;
import domain_model.ChiTietSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({
        "/ban-hang",
})

public class BanHangServlet extends HttpServlet {
    private ChiTietSanPhamRepository ctR  = new ChiTietSanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        this.index(req, resp);
    }
    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("danhSachCT",this.ctR.findAll());
        request.setAttribute("view","/views/ban_hang/danhsach.jsp");
        request.getRequestDispatcher("/views/layout.jsp")
                .forward(request, response);
    }
}
