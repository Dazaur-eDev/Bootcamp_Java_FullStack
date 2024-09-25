package M4_Sesion14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S14_Rebound {

    int[] numerator = {4, 8, 16, 32, 64, 128, 256, 512};
    int[] denominator = {2, 0, 4, 4, 0, 8};

    int[] divisor = new int[numerator.length];

    public void calculator() {
        System.out.println("Division between : ");
        System.out.println("initial arrange of numerator   : " + Arrays.toString(numerator));
        System.out.println("initial arrange of denominator : " + Arrays.toString(denominator));
        try {
            divide(numerator, denominator);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of boundaries of the matrix, more details: " + e.getMessage());
        } finally {
            System.out.println("Changing length of denominator to fix the error");
            int[] denominator2 = {2, 1, 4, 4, 1, 8, 1, 1};
            divide(numerator, denominator2);
            System.out.println("Division between : ");
            System.out.println("initial arrange of numerator   : " + Arrays.toString(numerator));
            System.out.println("corrected arrange of denominator : " + Arrays.toString(denominator2));
            System.out.println("result in   :" + Arrays.toString(divisor));
        }

    }

    public void divide(int[] numerator, int[] denominator) {
        try {
            for (int i = 0; i < this.numerator.length; i++) {
                divisor[i] = numerator[i] / denominator[i];
            }
        } catch (ArithmeticException e) {
            System.out.println("Can not divide by zero, more details: " + e.getMessage());
        } finally {
            System.out.println("Changing zero by number one to fix the error");
            denominator[1] = 1;
            denominator[4] = 1;
        }

    }
}
