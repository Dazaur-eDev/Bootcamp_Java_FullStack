package com.Daza.Servicios;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
@DisplayName("Test del resultado del método Calcular Promedio")
class PromedioServicioImpTest {
    PromedioServicioImp promedioTest = new PromedioServicioImp();
    List<Double> notasTest = Arrays.asList(6.0, 7.0, 5.0);
    Double sumaNotas = 0.0;
    Double promedioEsperado = 0.0;

    @BeforeEach
    void setUp() {
        for (Double notas : notasTest) {
            sumaNotas += notas;
        }
        promedioEsperado = sumaNotas / notasTest.size();
    }

    @Test
    @DisplayName("Test para método cálculo promedio")
    void testCalcularPromedio() {
        Assertions.assertEquals(promedioEsperado, promedioTest.calcularPromedio(notasTest));
        System.out.println("Esperado  : " + promedioEsperado);
        System.out.println("Resultado : " + promedioTest.calcularPromedio(notasTest));
    }
}