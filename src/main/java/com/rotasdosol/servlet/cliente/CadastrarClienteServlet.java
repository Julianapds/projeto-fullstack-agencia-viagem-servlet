package com.rotasdosol.servlet.cliente;

import com.rotasdosol.dao.ClienteDAO;
import com.rotasdosol.model.ClienteModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cadastro_cliente")
public class CadastrarClienteServlet extends HttpServlet {

    private final ClienteDAO clienteDAO;

    public CadastrarClienteServlet() {
        this.clienteDAO = new ClienteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String origem = request.getParameter("origem");

        if(origem != null && origem.equals("admin")){
            request.setAttribute("origem", "admin");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/cadastrar_cliente.jsp");
            dispatcher.forward(request, response);

        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cadastro.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String origem = request.getParameter("origem");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String senha = request.getParameter("senha");
        String senhaHash = criptografar(senha);

        if (!clienteDAO.existePorCpf(cpf)) {
            ClienteModel cliente = new ClienteModel();
            cliente.setEmail(email);
            cliente.setCpf(cpf);
            cliente.setTelefone(telefone);
            cliente.setEndereco(endereco);
            cliente.setSenhaHash(senhaHash);

            clienteDAO.salvar(cliente);

            if(origem.equals("admin")){
                response.sendRedirect("/dashboard_admin/clientes");
                return;
            }

            request.getSession().setAttribute("mensagemSucesso", "Cliente cadastrado com sucesso! Redirecionando para login...");
            response.sendRedirect("/cadastro_cliente");

        } else {
            request.setAttribute("mensagemErro", "Já existe um cliente cadastrado com este CPF.");
            request.getRequestDispatcher("/cadastro_cliente").forward(request, response);
        }
    }

    private String criptografar(String senha) {
        return senha;
    }
}