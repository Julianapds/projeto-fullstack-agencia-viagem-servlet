package com.rotasdosol.servlet.destino;

import com.rotasdosol.dao.DestinoDAO;
import com.rotasdosol.model.DestinoModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dashboard_admin/destinos/cadastrar")
public class CadastrarDestinoServlet extends HttpServlet {

    private final DestinoDAO destinoDAO = new DestinoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/destino/cadastrar_destino.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String pais = req.getParameter("pais");
        String cidade = req.getParameter("cidade");

        DestinoModel destinoModel = new DestinoModel();
        destinoModel.setNome(nome);
        destinoModel.setPais(pais);
        destinoModel.setCidade(cidade);

        destinoDAO.criar(destinoModel);

        resp.sendRedirect(req.getContextPath() + "/dashboard_admin/destinos");
    }
}
