package com.example.servlets;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import static org.mockito.Mockito.*;

public class GameServletTest {

    private GameServlet gameServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp() {
        gameServlet = new GameServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        requestDispatcher = mock(RequestDispatcher.class);

        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
    }

    @Test
    public void testStartAction() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("start");
        when(request.getParameter("playerName")).thenReturn("Tim");
        when(request.getRemoteAddr()).thenReturn("127.0.0.1");

        gameServlet.doPost(request, response);

        verify(session).setAttribute("playerName", "Tim");
        verify(session).setAttribute("playerIpAddress", "127.0.0.1");
        verify(session).setAttribute("Tim_gamesPlayed", 0);
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testRestartAction() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("restart");
        when(session.getAttribute("playerName")).thenReturn("Tim");
        when(session.getAttribute("Tim_gamesPlayed")).thenReturn(1);

        gameServlet.doPost(request, response);

        verify(session).setAttribute("Tim_gamesPlayed", 2);
        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDeclineALFAction() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("declineALF");

        gameServlet.doPost(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testRejectAction() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("reject");

        gameServlet.doPost(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testDeclineToBridgeAction() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("declineToBridge");

        gameServlet.doPost(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testGoToBridgeAction() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("goToBridge");

        gameServlet.doPost(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testLieAction() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("lie");

        gameServlet.doPost(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    public void testTellTruthAction() throws ServletException, IOException {
        when(request.getParameter("action")).thenReturn("tellTruth");

        gameServlet.doPost(request, response);

        verify(requestDispatcher).forward(request, response);
    }
}
