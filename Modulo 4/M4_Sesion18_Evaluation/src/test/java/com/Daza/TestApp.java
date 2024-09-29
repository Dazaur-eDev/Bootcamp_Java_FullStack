package com.Daza;

import com.Daza.modules.Market;
import com.Daza.modules.Product;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests para la App")
public class TestApp {
    private Market market;
    private Product product;
    private List<Product> listProducts = new ArrayList<Product>();


    @Test
    @DisplayName("Test Create Advertising")
    void testCreateAdvertising() {
        product = Product.createAdvertising("Laptop", 1, "used", 300000);
        assertNotNull(product);
    }

    @Test
    @DisplayName("Test Publish in Market")
    void testPublishInMarket() {
        product = Product.createAdvertising("Laptop", 1, "used", 300000);
        market = new Market(listProducts);
        Market.publishAdvertisement(listProducts,product);
        assertEquals(listProducts.get(0).getName(), product.getName());
    }


}
