package com.Daza;

import com.Daza.modules.Market;
import com.Daza.modules.Product;
import com.Daza.utils.ReadConsole;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Product product = new Product();
        Market market = new Market();
        List<Product> listOfProductsInMarket = new ArrayList<>();

        System.out.println("Welcome");
        //Just for get two advertisement to test
        for (int i = 0; i < 2; i++) {
            System.out.println("Please enter the name of the advertising product");
            String name = ReadConsole.dataInputString();
            System.out.println("Please enter the id of the advertising product");
            int idProduct = ReadConsole.dataInputInt();
            System.out.println("Please enter the condition of the advertising product");
            String condition = ReadConsole.dataInputString();
            System.out.println("Please enter the price of the advertising product");
            int price = ReadConsole.dataInputInt();
            Product newProduct = product.createAdvertising(name, idProduct, condition, price);
            System.out.println("__________________________________________");
            System.out.println("Uploading the product to the market...");
            System.out.println(newProduct);
            market.publishAdvertisement(listOfProductsInMarket, newProduct);
            System.out.println("__________________________________________");
            market.allAdvertisement(listOfProductsInMarket);
        }

    }
}
