
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | Cursos online de tecnologia</title>
    <style>
        *, :after, :before {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            background-color: #f9fbfd;
        }
        body, input, select, textarea {
            font: normal 14px sans-serif;
        }
        a {
            outline: none;
        }
        ul {
            list-style: none;
        }
        .container {
            margin: 0 auto;
            max-width: 1200px;
            width: 96%;
        }
        .auth {
            color: #747c81;
            display: flex;
            align-items: center;
            align-content: center;
            flex-direction: column;
        }
        .login {
            background-color: #fff;
            text-align: center;
            padding: 3em;
            max-width: 500px;
        }
        .login__title {
            font-weight: 800;
            letter-spacing: -.5px;
            font-size: 2em;
        }
        .login__subtitle {
            font-size: 1.2em;
            letter-spacing: -.3px;
            margin-bottom: 1em;
        }
        .login__form label {
            display: block;
            text-align: left;
            font-size: 1.1em;
        }
        .login__form input {
            border: 1px solid #eee;
            border-radius: 3px;
            margin-bottom: 1em;
            padding: 1em;
            width: 100%;
        }
        .login__button {
            color: #fff;
            border: none;
            font-size: 1em;
            font-weight: 700;
            text-transform: uppercase;
            border-radius: 3px;
            background-color: #747c81;
            min-width: 195px;
            height: 50px;
            cursor: pointer;
            margin-top: 1em;
            padding: .4em 0;
        }
        .signup {
            margin-top: 3em;
            text-align: center;
            max-width: 600px;
        }
        .signup__title {
            display: inline-block;
            font-size: 2em;
            font-weight: 800;
            letter-spacing: -.7px;
            text-align: center;
            border-bottom: 3px solid #747c81;
            margin-bottom: 5px;
        }
        .signup__text {
            font-size: 1.5em;
            letter-spacing: -.3px;
            margin-top: .5em;
        }
        .categories {
            margin-top: 1.5em;
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
        .category-card {
            border: 5px solid hsla(0,0%,100%,.3);
            margin-right: 5px;
            margin-left: 5px;
            margin-bottom: 1em;
            width: 45%;
        }
        .category-card__link {
            color: inherit;
            text-decoration: none;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-between;
            width: 100%;
            padding: 1em;
        }
        .category-card__icon {
            opacity: .6;
            width: 100%;
        }
        .category-card__icon img {
            max-width: 128px;
        }
        .category-card__title {
            font-size: 1em;
            font-weight: 700;
            width: 100%;
            margin-top: .5em;
        }
        .category-card__details {
            font-size: .95em;
            opacity: .6;
            margin-top: .25em;
        }
        @media (min-width: 1024px) {
            .category-card {
                max-width: 180px;
            }
        }
        @media (min-width: 540px) {
            .category-card {
                width: 30%;
            }
        }
        @media (min-width: 940px) {
            .auth {
                flex-direction: row;
                justify-content: space-between;
            }
            .login {
                width: 45%;
            }
            .signup {
                width: 50%;
            }
            .signup__title {
                font-size: 2.5em;
            }
        }
    </style>
</head>
<body>
<main class="container">
    <section class="auth">
        <section class="login">
            <h1 class="login__title">Já estuda com a gente?</h1>
            <p class="login__subtitle">Faça seu login e boas aulas!</p>
            <form class="login__form" action="/login" method="POST">
                <label for="login-email">E-mail</label>
                <input type="email" name="username"  id="login-email" autofocus>
                <label for="login-password">Senha</label>
                <input type="password" name="password" id="login-password" autocomplete="off">
                <button class="login__button" type="submit">Entrar</button>
            </form>
        </section>
        <section class="signup">
            <h2 class="signup__title">Ainda não estuda com a gente?</h2>
            <p class="signup__text">São mais de mil cursos nas seguintes áreas</p>
            <ul class="categories">
                <li class="category-card">
                    <a href="" class="category-card__link" href="/programacao">
                            <span class="category-card__icon">
                                <img src="https://www.alura.com.br/assets/api/formacoes/categorias/128/programacao.png">
                            </span>
                        <h3 class="category-card__title">Programação</h3>
                        <p class="category-card__details">
                            Lógica de programação, Python, Dart, e mais...
                        </p>
                    </a>
                </li>
                <li class="category-card">
                    <a href="" class="category-card__link" href="/front-end">
                            <span class="category-card__icon">
                                <img src="https://www.alura.com.br/assets/api/formacoes/categorias/128/front-end.png">
                            </span>
                        <h3 class="category-card__title">Front-end</h3>
                        <p class="category-card__details">
                            HTML e CSS, React, Angular, e mais...
                        </p>
                    </a>
                </li>
                <li class="category-card">
                    <a href="" class="category-card__link" href="/data-science">
                            <span class="category-card__icon">
                                <img src="https://www.alura.com.br/assets/api/formacoes/categorias/128/data-science.png">
                            </span>
                        <h3 class="category-card__title">Data Science</h3>
                        <p class="category-card__details">
                            SQL e Banco de Dados, Engenharia de Dados, Data Visualization, e mais...
                        </p>
                    </a>
                </li>
                <li class="category-card">
                    <a href="" class="category-card__link" href="/devops">
                            <span class="category-card__icon">
                                <img src="https://www.alura.com.br/assets/api/formacoes/categorias/128/devops.png">
                            </span>
                        <h3 class="category-card__title">DevOps</h3>
                        <p class="category-card__details">
                            Linux, Google Cloud Platform, Azure, e mais...
                        </p>
                    </a>
                </li>
                <li class="category-card">
                    <a href="" class="category-card__link" href="/design-ux">
                            <span class="category-card__icon">
                                <img src="https://www.alura.com.br/assets/api/formacoes/categorias/128/design-ux.png">
                            </span>
                        <h3 class="category-card__title">Design & UX</h3>
                        <p class="category-card__details">
                            User Interface, User Experience, Design Gráfico, e mais...
                        </p>
                    </a>
                </li>
                <li class="category-card">
                    <a href="" class="category-card__link" href="/mobile">
                            <span class="category-card__icon">
                                <img src="https://www.alura.com.br/assets/api/formacoes/categorias/128/mobile.png">
                            </span>
                        <h3 class="category-card__title">Mobile</h3>
                        <p class="category-card__details">
                            Multiplataforma, Flutter, Android, e mais...
                        </p>
                    </a>
                </li>
            </ul>
        </section>
    </section>
</main>
</body>
</html>
