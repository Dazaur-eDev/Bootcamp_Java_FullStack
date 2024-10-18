package com.daza.m5_sesion2_evaluation.service;

import com.daza.m5_sesion2_evaluation.dto.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {
    List<ProductoResponseDTO> listarProductosDTO();
}
