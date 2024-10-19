package com.daza.m5_sesion3_evaluation.sessions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LogoutServletConSessions", value = "/logoutServletConSessions")
public class LogoutServletConSessions extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("index.jsp?mensaje2=Parametros de Sessions invalidados");
    }

    @Override
    public void destroy() {
    }
}
