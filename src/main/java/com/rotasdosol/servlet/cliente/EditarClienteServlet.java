package com.rotasdosol.servlet.cliente;

import com.rotasdosol.dao.ClienteDAO;
import com.rotasdosol.model.ClienteModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dashboard_admin/clientes/editar")
public class EditarClienteServlet extends HttpServlet {

    private final ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            ClienteModel cliente = clienteDAO.buscarPorId(id);
            req.setAttribute("cliente", cliente);
            req.getRequestDispatcher("/WEB-INF/views/admin/editar_cliente.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));

            ClienteModel clienteModel =  clienteDAO.buscarPorId(id);

            if(clienteModel == null){
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
                return;
            }

            String cpf = req.getParameter("cpf");
            String email = req.getParameter("email");
            String endereco = req.getParameter("endereco");
            String telefone = req.getParameter("telefone");

            clienteModel.setCpf(cpf);
            clienteModel.setEmail(email);
            clienteModel.setEndereco(endereco);
            clienteModel.setTelefone(telefone);

            clienteDAO.atualizar(clienteModel);

            resp.sendRedirect(req.getContextPath() + "/dashboard_admin/clientes");

        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao atualizar cliente");
        }
    }

}