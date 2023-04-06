package controllers;

import Repository.ChiTietSanPhamRepository;
import domain_model.ChiTietSP;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(
        "/detail"
)
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        index(req, resp);
    }

    protected void index(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String id = req.getParameter("id");
        ChiTietSanPhamRepository ctR = new ChiTietSanPhamRepository();
        ChiTietSP chiTietSP = ctR.findById(id);
        req.setAttribute("detail",chiTietSP);
        req.setAttribute("view", "/views/ban_hang/detail.jsp");
        req.getRequestDispatcher("/views/layout2.jsp")
                .forward(req, resp);
    }
}
