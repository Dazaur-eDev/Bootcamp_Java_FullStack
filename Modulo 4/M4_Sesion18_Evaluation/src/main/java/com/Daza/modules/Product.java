package com.Daza.modules;

public class Product {
    private String name;
    private int idProduct;
    private String condition;
    private int price;

    public Product(String name, int idProduct, String condition, int price) {
        this.name = name;
        this.idProduct = idProduct;
        this.condition = condition;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static Product createAdvertising(String name, int idProduct, String condition, int price) {
        System.out.println("Advertising product created");
        return new Product(name, idProduct, condition, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", idProduct=" + idProduct +
                ", condition='" + condition + '\'' +
                ", price=" + price +
                '}';
    }
}

