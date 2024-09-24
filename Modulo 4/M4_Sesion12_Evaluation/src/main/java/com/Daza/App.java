package com.Daza;

import com.Daza.module.Product;
import com.Daza.utils.Excel;
import com.Daza.utils.ReadConsole;
import com.Daza.utils.WriteFile;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.Daza.utils.Excel.addProductExcel;

public class App {
    static List<Product> products = new ArrayList<>();
    static List<Product> shopingCar = new ArrayList<>();

    public static void main(String[] args) {

        int option = 0;
        while (option != 6) {
            menu();
            option = ReadConsole.dataInputInt();
            switch (option) {
                case 1:
                    createListProducts();
                    break;
                case 2:
                    listProducts();
                    break;
                case 3:
                    addProduct();
                    break;
                case 4:
                    shoppingCar();
                    break;
                case 5:
                    payProducts();
                    break;
                case 6:
                    System.out.println("Thanks for coming to the shop buddy");
                    break;
                default:
                    System.out.println("No valid option");
                    break;
            }
        }

    }

    public static void menu() {
        System.out.println("___________________________________________________________");
        System.out.println("Welcome to the shop");
        System.out.println("Select the option you want: ");
        System.out.println("1 - Create a new list of product on excel doc based on example");
        System.out.println("2 - See the list of available products on console throw excel doc");
        System.out.println("3 - Add a product to the list in the excel doc");
        System.out.println("4 - Add Product to shopping car");
        System.out.println("5 - See the shopping cart and pay");
        System.out.println("6 - Quit");
        System.out.println("___________________________________________________________");
    }

    public static void createListProducts() {

        products.add(new Product("Laptop", 1000, "L001"));
        products.add(new Product("Mouse", 100, "M001"));
        products.add(new Product("Keyboard", 150, "K001"));
        Excel.create(products, "products.xlsx");

    }

    public static void listProducts() {
        products = Excel.readExcel("products.xlsx");
        int index = 1;
        for (Product product : products) {
            System.out.println(index + " - " + product.getName() + " - $ " + product.getPrice() + " - Code: " + product.getCode());
            index++;
        }
    }

    public static void addProduct() {
        System.out.println("Write the name for the new product:");
        String name = ReadConsole.dataInputString();
        System.out.println("Write the price for the new product:");
        int price = ReadConsole.dataInputInt();
        System.out.println("Write the code for the new product:");
        String code = ReadConsole.dataInputString();
        addProductExcel("products.xlsx", name, price, code);
    }

    public static void shoppingCar() {
        boolean token = false;
        while (!token) {
            System.out.println("You want to add more products to your shopping car?, write yes or no");
            String dataInput = ReadConsole.dataInputString();
            if (dataInput.equalsIgnoreCase("yes")) {
                System.out.println("Select the product you want to add to the shoping car: ");
                products = Excel.readExcel("products.xlsx");
                int index = 1;
                for (Product product : products) {
                    System.out.println(index + " - " + product.getName() + " $ " + product.getPrice());
                    index++;
                }
                int productSelected = ReadConsole.dataInputInt();
                if (productSelected > products.size() || productSelected < 1) {
                    System.out.println("There is no product for that selection");
                } else {
                    shopingCar.add(products.get(productSelected - 1));
                    System.out.println((products.get(productSelected - 1)).getName() + " added to your shopping car");
                }
            } else if (dataInput.equalsIgnoreCase("no")) {
                System.out.println("Shopping car closed and ready for pay");
                token = true;
            } else {
                System.out.println("Not valid option");
            }
        }
    }

    public static void payProducts() {
        if (shopingCar.isEmpty()) {
            System.out.println("Empty shopping car, go to buy before");
        } else {
            System.out.println("You shopping car have the next items:");
            int index = 1;
            double total = 0;
            for (Product products : shopingCar) {
                System.out.println(index + " - " + shopingCar.get(index-1).getName() + " $ " + shopingCar.get(index-1).getPrice());
                total = total + shopingCar.get(index-1).getPrice();
                index++;
            }

            System.out.println("You have to pay for all the products the total amount of $" + total);
            System.out.println("Generating your receipt in a txt file...");
            WriteFile wf = new WriteFile();
            String directory = "Modulo 4/M4_Sesion12_Evaluation/";
            String file = "receipt.txt";
            String details = "You have bought the following items";
            wf.writeOver("receipt.txt","", Collections.singletonList(details));
            index = 1;
            for (Product products : shopingCar) {
                String line = (index + " - " + shopingCar.get(index-1).getName() + " $ " + shopingCar.get(index-1).getPrice());
                wf.writeAppend("receipt.txt","", Collections.singletonList(line));
                index++;
            }
            String endingText = "Total amount paid was : $" + total;
            wf.writeAppend("receipt.txt","", Collections.singletonList(endingText));

        }


    }
}
