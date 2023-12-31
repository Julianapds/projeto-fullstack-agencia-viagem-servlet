<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard - Admin</title>
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
                <li class="nav-item active">
                    <a class="nav-link" href="/dashboard_admin">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
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
        <h1>Bem-vindo(a)</h1>
        <p>Aqui você pode gerenciar clientes, visualizar relatórios, etc.</p>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
