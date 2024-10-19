package com.daza.m5_sesion3_evaluation.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LogoutServletConCookies", value = "/logoutServletConCookies")
public class LogoutServletConCookies extends HttpServlet {

    @Override
    public void init() {
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("logoutServlet - " + cookie.getName());
            // Asegurarse de que borra la que necesitamos
            if ("nombre3".equals(cookie.getName())) {
                cookie.setValue("");
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
                break;
            } else {
                //Por si acaso elimino todas
                cookie.setValue("");
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        response.sendRedirect("./index.jsp?mensaje3=Cookies eliminadas");
    }

    @Override
    public void destroy() {
    }
}
