package com.Daza.utils;

import com.Daza.module.Product;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Excel {

    public static void create(List<Product> products, String filepath) {
        try (Workbook workbook = new HSSFWorkbook()) {
            HSSFSheet sheet = (HSSFSheet) workbook.createSheet("Products");

            //Create headers
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Name");
            headerRow.createCell(1).setCellValue("Price");
            headerRow.createCell(2).setCellValue("Code");

            //Assign values for each column
            int rowNum = 1;
            for (Product product : products) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(product.getName());
                row.createCell(1).setCellValue(product.getPrice());
                row.createCell(2).setCellValue(product.getCode());
            }

            //Fit margin of cell to content
            for (int i = 0; i < products.size(); i++) {
                sheet.autoSizeColumn(i);
            }

            try (FileOutputStream fileOut = new FileOutputStream(filepath)) {
                workbook.write(fileOut);
            }

        } catch (IOException e) {
            System.out.println("Error trying to create excel doc");
        }
    }

    public static List<Product> readExcel(String filepath) {
        List<Product> products = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filepath)) {
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;
                String name = row.getCell(0).getStringCellValue();
                int price;
                if (row.getCell(1).getCellType() == CellType.NUMERIC) {
                    price = (int) row.getCell(1).getNumericCellValue();
                } else {
                    price = Integer.parseInt(row.getCell(1).getStringCellValue());
                }

                String code = row.getCell(2).getStringCellValue();
                products.add(new Product(name, price, code));
            }
        } catch (IOException e) {
            System.out.println("Error trying to reading excel doc");
        }
        return products;
    }

    public static void addProductExcel(String filepath, String name, int price, String code) {
        List<Product> products = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filepath)) {
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();

            HSSFRow newRow = sheet.createRow(lastRowNum + 1);

            newRow.createCell(0).setCellValue(name);
            newRow.createCell(1).setCellValue(price);
            newRow.createCell(2).setCellValue(code);

            try (FileOutputStream fos = new FileOutputStream(filepath)) {
                workbook.write(fos);
            }
        } catch (IOException e) {
            System.out.println("Error trying to reading excel doc");
        }
    }
}
