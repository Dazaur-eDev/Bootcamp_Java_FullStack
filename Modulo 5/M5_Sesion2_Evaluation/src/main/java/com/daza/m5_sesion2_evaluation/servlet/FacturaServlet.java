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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "FacturaServlet", value = "/factura")
public class FacturaServlet extends HttpServlet {

    private ProductoService ProductoService;

    @Override
    public void init() {
        ProductoService = new ProductoServiceImplementation();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./factura.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nombre = (String) session.getAttribute("nombre");
        String direccion = (String) session.getAttribute("direccion");

        List<ProductoResponseDTO> productos = ProductoService.listarProductosDTO();
        List<ProductoResponseDTO> productosSeleccionados = new ArrayList<>();
        Map<Long, Integer> totalproducto = new HashMap<>();
        Map<Long, Integer> cantidadProducto = new HashMap<>();
        int total = 0;

        for (ProductoResponseDTO producto : productos) {
            String cantidadParam = request.getParameter("cantidad_" + producto.getId());
            if (cantidadParam != null && !cantidadParam.isEmpty()) {
                int cantidad = Integer.parseInt(cantidadParam);
                if (cantidad != 0) {
                    productosSeleccionados.add(producto);
                    total += producto.getPrecioUnitario() * cantidad;
                    totalproducto.put(producto.getId(), producto.getPrecioUnitario() * cantidad);
                    cantidadProducto.put(producto.getId(), cantidad);
                }
            }
        }

        request.setAttribute("direccion", direccion);
        request.setAttribute("nombre", nombre);
        request.setAttribute("productosSeleccionados", productosSeleccionados);
        request.setAttribute("totalProducto", totalproducto);
        request.setAttribute("total", total);
        request.setAttribute("cantidadProducto", cantidadProducto);

        request.getRequestDispatcher("factura.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
    }
}