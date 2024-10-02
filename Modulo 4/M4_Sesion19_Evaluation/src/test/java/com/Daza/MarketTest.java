package com.Daza;

import com.Daza.modules.Market;
import com.Daza.modules.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@DisplayName("Test for Product and Market Class")
public class MarketTest {
    Product productReal;
    Product productMock;
    List<Product> mockedProductList = new ArrayList<>();
    List<Product> realProductList = new ArrayList<>();
    Market marketReal;
    Market marketMock;

    @BeforeEach
    void setUp() {
        productReal = new Product("Laptop", 101, "New", 1000);
        realProductList.add(productReal);
        marketReal = new Market(realProductList);

        productMock = mock(Product.class);
        marketMock = mock(Market.class);
    }

    @Test
    @DisplayName("Test Create Advertisement")
    public void testCreateAdvertisement() {
        when(productMock.createAdvertising("Laptop", 101, "New", 1000)).thenReturn(productReal);
        Product createdProduct = productMock.createAdvertising("Laptop", 101, "New", 1000);
        verify(productMock).createAdvertising("Laptop", 101, "New", 1000);
        Assertions.assertNotNull(createdProduct);
        Assertions.assertEquals(productReal, createdProduct);
    }

    @Test
    @DisplayName("Test Publish Advertisement")
    public void testPublishAdvertisement() {
        when(marketMock.publishAdvertisement(mockedProductList, productMock)).thenReturn(realProductList);
        List<Product> createdMarket = marketMock.publishAdvertisement(mockedProductList, productMock);
        verify(marketMock).publishAdvertisement(mockedProductList, productMock);
        Assertions.assertNotNull(createdMarket);
        Assertions.assertEquals(realProductList, createdMarket);
    }

    @Test
    @DisplayName("Verify the orden of invocations")
    public void verifyOrderOfInvocations() {
        productMock.createAdvertising("Laptop", 101, "New", 1000);
        mockedProductList.add(productMock);
        marketMock.publishAdvertisement(mockedProductList, productMock);
        marketMock.allAdvertisement(mockedProductList);

        InOrder inOrder = inOrder(productMock, marketMock);
        inOrder.verify(productMock).createAdvertising("Laptop", 101, "New", 1000);
        inOrder.verify(marketMock).publishAdvertisement(mockedProductList, productMock);
        inOrder.verify(marketMock).allAdvertisement(mockedProductList);
    }
}


