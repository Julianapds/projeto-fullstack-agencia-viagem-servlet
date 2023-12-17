package com.rotasdosol.servlet.cliente;

import com.rotasdosol.dao.ClienteDAO;
import com.rotasdosol.model.ClienteModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard_admin/clientes")
public class ListarClienteServlet extends HttpServlet {

    private final ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ClienteModel> listaClientes = clienteDAO.buscar();
        req.setAttribute("clientes", listaClientes);
        req.getRequestDispatcher("/WEB-INF/views/admin/gerenciar_clientes.jsp").forward(req, resp);
    }
}

