<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поражение</title>
    <style>
        .container {
            max-width: 600px; /* Максимальная ширина контейнера */
            margin: 0 auto; /* Центрирование контейнера */
            padding: 20px; /* Отступы внутри контейнера */
            background-color: #fff; /* Цвет фона контейнера */
            border-radius: 8px; /* Закругление углов */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Тень для контейнера */
        }
    </style>
</head>
<body>
<div class="container">
    <p>Ты не прошел переговоры.</p>
    <h1>Поражение.</h1>
    <form action="game" method="post">
        <button type="submit" name="action" value="restart">Начать с начала</button>
    </form>
</body>
</html>
