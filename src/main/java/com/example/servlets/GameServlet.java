package com.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String playerName = request.getParameter("playerName");
        String playerIpAddress;
        String action = request.getParameter("action");

        Integer gamesPlayed = (Integer) session.getAttribute(playerName + "_gamesPlayed");
        if (gamesPlayed == null) {
            gamesPlayed = 0;
        }
        // Отладочные сообщения
        System.out.println("Player Name: " + playerName);
        System.out.println("Games Played: " + gamesPlayed);


        if (action.equals("start")) {
            // Получаем имя игрока и сохраняем в сессии

            playerIpAddress = request.getRemoteAddr();
            session.setAttribute("playerName", playerName);
            session.setAttribute("playerIpAddress", playerIpAddress);

            // Устанавливаем количество игр в сессии
            session.setAttribute(playerName + "_gamesPlayed", gamesPlayed);

            request.getRequestDispatcher("/ALFsQuestion.jsp").forward(request, response);

        } else if (action.equals("declineALF")) {        //отклонение вызова НЛО
            request.getRequestDispatcher("/ALFsEnd.jsp").forward(request, response);
        } else if (action.equals("reject")) {            //принятие вызова НЛО
            request.getRequestDispatcher("/onBoard.jsp").forward(request, response);

        } else if (action.equals("declineToBridge")) {        //отклоненить приглашение
            request.getRequestDispatcher("/onBoardEnd.jsp").forward(request, response);
        } else if (action.equals("goToBridge")) {             //принять приглашение
            request.getRequestDispatcher("/bridge.jsp").forward(request, response);

        } else if (action.equals("lie")) {            // солгать о себе
            request.getRequestDispatcher("/bridgeEnd.jsp").forward(request, response);
        } else if (action.equals("tellTruth")) {      // рассказать правду о себе
            request.getRequestDispatcher("/result.jsp").forward(request, response);

        } else if (action.equals("restart")) {       // рестарт

            // Получаем имя игрока из сессии
            playerName = (String) session.getAttribute("playerName");

            // Увеличиваем количество игр
            gamesPlayed = (Integer) session.getAttribute(playerName + "_gamesPlayed");
            if (gamesPlayed == null) {
                gamesPlayed = 0;
            }

            gamesPlayed++;
            session.setAttribute(playerName + "_gamesPlayed", gamesPlayed);

            // Отладочные сообщения
            System.out.println("Player Name after restart: " + playerName);
            System.out.println("Games Played after restart: " + gamesPlayed);

            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }





    }
}
