package com.daza.m5_sesion2_evaluation.servlet;

import com.daza.m5_sesion2_evaluation.dto.ProductoResponseDTO;
import com.daza.m5_sesion2_evaluation.service.ProductoService;
import com.daza.m5_sesion2_evaluation.service.ProductoServiceImplementation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListarProductosServlet", value = "/listarProductos")
public class ListarProductosServlet extends HttpServlet {

    private ProductoService ProductoService;

    @Override
    public void init() {
        ProductoService = new ProductoServiceImplementation();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductoResponseDTO> productos = ProductoService.listarProductosDTO();
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");

        HttpSession session = request.getSession();

        session.setAttribute("direccion", direccion);
        session.setAttribute("nombre", nombre);
        request.setAttribute("direccion", direccion);
        request.setAttribute("nombre", nombre);
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("listarProductos.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
    }
}