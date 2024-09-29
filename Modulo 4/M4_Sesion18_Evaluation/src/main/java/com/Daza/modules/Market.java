package com.Daza.modules;

import java.util.List;

public class Market {
    private List<Product> listOfProducts;

    public Market(List<Product> products) {
        this.listOfProducts = products;
    }

    public List<Product> getProducts() {
        return listOfProducts;
    }

    public void setProducts(List<Product> products) {
        this.listOfProducts = products;
    }

    public static List<Product> publishAdvertisement(List<Product> listOfProducts, Product product) {
        listOfProducts.add(product);
        System.out.println("Your product have been uploaded to the online market");
        return listOfProducts;
    }

    public static void allAdvertisement(List<Product> listOfProducts) {
        System.out.println("Products available in the online market are : ");
        for(Product product : listOfProducts) {
            System.out.println(product);
        }
    }

    @Override
    public String toString() {
        return "Market{" +
                "products=" + listOfProducts +
                '}';
    }
}
