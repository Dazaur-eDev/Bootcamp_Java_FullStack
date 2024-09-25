package M4_Sesion13;

import M4_Sesion13.utils.ReadConsole;

import java.util.ArrayList;
import java.util.ListIterator;

public class S13_Rebound {
    //List to save all the inserted values from console and process the sum, media, etc
    ArrayList<Integer> insertedValues = new ArrayList<>();
    int sum = 0;
    int media = 0;
    int numbersAboveMedia = 0;
    int numbersBelowMedia = 0;

    public void arrayListNumerico() {
        menu();
        readValues();
        calculates(insertedValues);
        showResults(insertedValues, sum, media, numbersAboveMedia, numbersBelowMedia);
    }

    public void menu() {
        System.out.println("________________________________________________________________________________________");
        System.out.println("Welcome to a program for practice Collections:");
        System.out.println("Please enter any number, the specific number -99 finish the program and do the maths");
        System.out.println("________________________________________________________________________________________");
    }

    public void readValues() {
        int value = 0;
        while (true) {
            value = ReadConsole.dataInputInt();
            if (value == (-99)) {
                break;
            } else {
                insertedValues.add(value);
            }
        }
    }

    public void calculates(ArrayList<Integer> insertedValues) {
        sum = 0;
        media = 0;
        numbersAboveMedia = 0;
        numbersBelowMedia = 0;
        ListIterator<Integer> iterator = insertedValues.listIterator();
        while (iterator.hasNext()) {
            sum = sum + iterator.next();
        }
        media = sum / insertedValues.size();
        while (iterator.hasPrevious()) {
            int value = iterator.previous();
            if (value > media) {
                numbersAboveMedia++;
            } else if (value < media){
                numbersBelowMedia++;
            }
        }
    }

    public void showResults(ArrayList<Integer> insertedValues, int sum, int media, int numbersAboveMedia, int numbersBelowMedia) {
        System.out.println("Total Values inserted by console are : " + insertedValues.size());
        System.out.println("Sum of values inserted by console is: " + sum);
        System.out.println("Media of values inserted by console is: " + media);
        System.out.println("The quantity of number above the media are: " + numbersAboveMedia);
        System.out.println("The quantity of number below the media are: " + numbersBelowMedia);
        System.out.println("All the values inserted are: " + insertedValues);
    }
}
