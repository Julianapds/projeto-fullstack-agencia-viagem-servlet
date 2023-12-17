package com.rotasdosol.servlet.login;

import com.rotasdosol.dao.ClienteDAO;
import com.rotasdosol.model.ClienteModel;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final ClienteDAO clienteRepositorio;
    private final String ADMIN = "admin@rotasdosol.com";

    public LoginServlet() {
        this.clienteRepositorio = new ClienteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("password");

        if(email.equals(ADMIN) && senha.equals("admin")){
            request.getSession().setAttribute("clienteLogado", email);
            response.sendRedirect(request.getContextPath() + "/dashboard_admin");
        }

        ClienteModel cliente = clienteRepositorio.buscarPorEmailESenha(email, senha);

        if (cliente != null && BCrypt.checkpw(senha, cliente.getSenhaHash())) {
            request.getSession().setAttribute("clienteLogado", cliente);
            response.sendRedirect(request.getContextPath() + "/dashboard");
        } else {
            request.setAttribute("errorMessage", "Credenciais inválidas. Tente novamente.");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
