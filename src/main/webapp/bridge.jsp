<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Мостик</title>
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
<h1>Ты поднялся на мостик.</h1>
<p>Ты кто?</p>
<form action="game" method="post">
  <button type="submit" name="action" value="tellTruth">Рассказать правду о себе</button>
  <button type="submit" name="action" value="lie">Солгать о себе</button>
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
