<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="../assets/imagens/icone.ico" type="image/x-icon">
        <title>Cadastro de Cliente</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script>
            function redirecionarAposIntervalo(url, intervalo) {
                setTimeout(function () {
                    window.location.href = url;
                }, intervalo);
            }
        </script>
    </head>

    <body>
        <div class="container mt-5 mb-5">
            <a href="/" class="w-100 d-flex justify-content-center">
                <img class="img-fluid mb-2 w-25" src="/assets/imagens/logotipo.png" alt="Rota do sol" style="max-width: 100px;">
            </a>
            <h3 class="text-center">Cadastro de Cliente</h3>
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <form action="cadastro_cliente" method="post" class="mb-2">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Digite seu email" required>
                        </div>
                        <div class="form-group">
                            <label for="cpf">CPF</label>
                            <input type="text" class="form-control" id="cpf" name="cpf" placeholder="Digite seu CPF" required>
                        </div>
                        <div class="form-group">
                            <label for="telefone">Telefone</label>
                            <input type="text" class="form-control" id="telefone" name="telefone" placeholder="Digite seu telefone" required>
                        </div>
                        <div class="form-group">
                            <label for="endereco">Endereço</label>
                            <input type="text" class="form-control" id="endereco" name="endereco" placeholder="Digite seu endereço" required>
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha</label>
                            <input type="password" class="form-control" id="senha" name="senha" placeholder="Digite sua senha" required>
                        </div>
                        <button type="submit" class="btn btn-success btn-block">Cadastrar</button>
                    </form>
                    <div class="row p-0 d-flex justify-content-center">
                        Já tem cadastro?<a href="/login"> Faça login agora</a>

                    </div>
                    <% if (request.getAttribute("mensagemErro") !=null) { %>
                        <div class="alert alert-danger" role="alert">
                            <%= request.getAttribute("mensagemErro") %>
                        </div>
                        <% } %>

                            <% if (session.getAttribute("mensagemSucesso") !=null) { %>
                                <div class="alert alert-success" role="alert">
                                    <%= session.getAttribute("mensagemSucesso") %>
                                </div>
                                <script>
                                    redirecionarAposIntervalo("/login", 3000);
                                </script>
                                <% session.removeAttribute("mensagemSucesso"); %>
                                    <% } %>
                </div>

            </div>

        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>

    </html>