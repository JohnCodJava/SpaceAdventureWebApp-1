<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.servlets.GameServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Принять вызов</title>
    <style>
        .container {
            max-width: 600px; /* Максимальная ширина контейнера */
            margin: 0 auto; /* Центрирование контейнера */
            padding: 20px; /* Отступы внутри контейнера */
            background-color: #fff; /* Цвет фона контейнера */
            border-radius: 8px; /* Закругление углов */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); /* Тень для контейнера */
        }
        .container + .container {
            margin-top: 20px; /* Отступ сверху для второго контейнера */
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Ты потерял память.</h1>
    <p>Принять вызов НЛО?</p>
    <form action="game" method="post">
        <input type="hidden" name="playerName" value="<%= session.getAttribute("playerName") %>">
        <button type="submit" name="action" value="reject">Принять вызов</button>
        <button type="submit" name="action" value="declineALF">Отклонить вызов</button>
    </form>
</div>

<div class="container">
    <p>Статистика</p>
    <p>IP address: <%= session.getAttribute("playerIpAddress") %></p>
    <p>Имя в игре: <%= session.getAttribute("playerName") %></p>
    <p>Колисчество игр: <%
        String playerName = (String) session.getAttribute("playerName");
        Integer gamesPlayed = (Integer) session.getAttribute(playerName + "_gamesPlayed");
        if (gamesPlayed != null) {
            out.print(gamesPlayed);
        } else {
            out.print(0);
        }
    %></p>
</div>
</body>
</html>
