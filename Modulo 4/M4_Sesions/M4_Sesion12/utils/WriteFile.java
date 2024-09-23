package M4_Sesion12.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    private String path;
    private String file;
    private List<?> resources;

    public WriteFile(String path, String file, List<?> resources) {
        this.path = path;
        this.file = file;
        this.resources = resources;
    }

    public WriteFile(){

    }

    public void writeOver(String path, String file, List<?> resources) {
        String filePath = path + file;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.newLine();
            for (Object object : resources) {
                String[] atributes = object.toString().split(", ");
                for (String atribute : atributes) {
                    bw.write(atribute.replace("=", ": "));
                }
            }
            System.out.println("File wrote successfully");
        } catch (IOException e) {
            System.out.println("Error trying to write the file " + e.getMessage());
        }
    }

    public void writeAppend(String path, String file, List<?> resources) {
        String filePath = path + file;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.newLine();
            for (Object object : resources) {
                String[] atributes = object.toString().split(", ");
                for (String atribute : atributes) {
                    bw.write(atribute.replace("=", ": "));
                }
            }
            System.out.println("File wrote successfully");
        } catch (IOException e) {
            System.out.println("Error trying to write the file " + e.getMessage());
        }
    }

//    public void write() {
//        String filePath = this.path + this.file;
//
//        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
//            for (Object object : resources) {
//                String[] atributes = object.toString().split(", ");
//                bw.write(object.getClass().getSimpleName() + ":");
//                bw.newLine();
//                for (String atribute : atributes) {
//                    bw.write(" " + atribute.replace("=", ": "));
//                    bw.newLine();
//                }
//                bw.newLine();
//            }
//            System.out.println("File wrote successfully");
//        } catch (IOException e) {
//            System.out.println("Error trying to write the file " + e.getMessage());
//        }
//    }
}
