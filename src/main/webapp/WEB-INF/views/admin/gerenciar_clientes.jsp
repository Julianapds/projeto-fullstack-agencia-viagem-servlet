<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gerenciamento de Clientes</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
     <link rel="icon" href="../assets/imagens/icone.ico" type="image/x-icon">
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
                    <a class="nav-link" href="/dashboard_admin/destinos">Destinos</a>
                </li>
                <li class="nav-item">
                                                    <a class="nav-link" href="/">Sair</a>
                                                </li>
            </ul>
        </div>
    </nav>
    <div class="container mt-4">
        <h4  class="mb-2">Gerenciamento de Clientes</h4>
        <a href="/cadastro_cliente?origem=admin" class="btn btn-success btn-sm mb-4">Adicionar novo cliente</a>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>CPF</th>
                    <th>Email</th>
                    <th>Endereço</th>
                    <th>Telefone</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${clientes}" var="cliente">
                    <tr>
                        <td>${cliente.idCliente}</td>
                        <td>${cliente.cpf}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.endereco}</td>
                        <td>${cliente.telefone}</td>
                        <td>
                            <a href="/dashboard_admin/clientes/editar?id=${cliente.idCliente}" class="btn btn-primary btn-sm">Editar</a>
                            <a href="/dashboard_admin/clientes/excluir?id=${cliente.idCliente}" class="btn btn-danger btn-sm">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
