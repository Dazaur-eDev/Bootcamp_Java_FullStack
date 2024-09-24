package com.Daza.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private String path;
    private String file;

    public ReadFile(String path, String file) {
        this.path = path;
        this.file = file;
    }

    public ReadFile() {
    }

    public void read(String path, String file) {
        String filePath = path + file;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error trying to read the file " + e.getMessage());
        }
    }

    public List extractData(String path, String file) {
        String filePath = path + file;
        List<String> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error trying to read the file " + e.getMessage());
        }
        return data;
    }

    public void read() {
        String filePath = this.path + this.file;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error trying to read the file " + e.getMessage());
        }
    }
}
