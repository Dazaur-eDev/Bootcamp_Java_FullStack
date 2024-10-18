package com.daza.m5_sesion2_evaluation.service;

import com.daza.m5_sesion2_evaluation.dto.ProductoResponseDTO;
import com.daza.m5_sesion2_evaluation.model.Producto;
import com.daza.m5_sesion2_evaluation.repository.ProductoRepository;
import com.daza.m5_sesion2_evaluation.repository.ProductoRepositoryImplementation;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoServiceImplementation implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImplementation() {
        this.productoRepository = new ProductoRepositoryImplementation();
    }

    @Override
    public List<ProductoResponseDTO> listarProductosDTO() {

        List<Producto> productos = productoRepository.listarProductos();
        if (productos.isEmpty()) {
            throw new RuntimeException("No se encontraron productos");
        }
        List<ProductoResponseDTO> productosMap =
                productos.stream()
                        .map(this::convertToResponseDTO)
                        .collect(Collectors.toList());
        return productosMap;

    }

    private ProductoResponseDTO convertToResponseDTO(Producto producto) {
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecioUnitario()
        );
    }
}
