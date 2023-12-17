package com.rotasdosol.servlet.destino;

import com.rotasdosol.dao.DestinoDAO;
import com.rotasdosol.model.DestinoModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard_admin/destinos")
public class ListarDestinoServlet extends HttpServlet {

    private final DestinoDAO destinoDAO = new DestinoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DestinoModel> destinos = destinoDAO.listar();
        req.setAttribute("destinos", destinos);
        req.getRequestDispatcher("/WEB-INF/views/destino/listar_destinos.jsp").forward(req, resp);
    }
}
