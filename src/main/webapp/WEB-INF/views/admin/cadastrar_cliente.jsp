<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Cliente</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="icon" href="/assets/imagens/icone.ico" type="image/x-icon">
</head>
<body>
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
              <a href="/" class="navbar-brand">
                             <img class="img-fluid mb-2 w-25" src="/assets/imagens/logotipo.png" alt="Rota do sol" style="max-width: 150px;">
                         </a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarNav">
                  <ul class="navbar-nav">
                      <li class="nav-item">
                          <a class="nav-link" href="/dashboard_admin">Home <span class="sr-only">(current)</span></a>
                      </li>
                      <li class="nav-item  active">
                          <a class="nav-link" href="/dashboard_admin/clientes">Clientes</a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="/gerenciarRelatorios">Produtos</a>
                      </li>
                      <li class="nav-item">
                                                          <a class="nav-link" href="/">Sair</a>
                                                      </li>
                  </ul>
              </div>
          </nav>
    <div class="container mt-4 mb-4">
        <h4 class="mb-2">Cadastro de Cliente</h4>
        <form action="/cadastro_cliente?origem=admin" method="post">
            <div class="form-group">
                <label for="cpf">CPF</label>
                <input type="text" class="form-control" id="cpf" name="cpf" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="endereco">Endereço</label>
                <input type="text" class="form-control" id="endereco" name="endereco" required>
            </div>
            <div class="form-group">
                <label for="telefone">Telefone</label>
                <input type="text" class="form-control" id="telefone" name="telefone" required>
            </div>
            <div class="form-group">
                            <label for="senha">Senha</label>
                            <input type="password" class="form-control" id="senha" name="senha" required>
                        </div>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
            <a href="/dashboard_admin/clientes" class="btn btn-secondary">Cancelar</a>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
