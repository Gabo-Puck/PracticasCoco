
import java.util.Scanner;
import java.util.Formatter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Melkor/Gabo-Puck
 */
public class KaprekarV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean isNumber = false;
        Kaprekar kaprekar = new Kaprekar();
        while (!isNumber) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.print("Escribe un numero: ");
                int number;
                number = input.nextInt();
                System.out.println(number);
                isNumber = true;
                kaprekar.showKaprekar(number);
            } catch (Exception ex) {
                System.out.println("?");
                isNumber = false;
            }

        }

    }

    public static void showKaprekar(int number) {
        int numberSB = sortSB(number);
        int numberBS = sortBS(number);
        if (numberSB == numberBS) {
            System.out.println("Numeros con las 4 cifras iguales no funcionan");
        } else {
            int diff = numberBS - numberSB;

            System.out.println(String.format("%04d", numberBS) + " - " + String.format("%04d", numberSB) + " = " + diff);

            if (diff != 6174) {
                showKaprekar(diff);
            }
        }

    }

    public static int sortBS(Integer number) {
        String numberString = String.format("%04d", number);
        char[] numberStringArray = numberString.toCharArray();
        boolean isSorted;
        do {
            isSorted = true;
            for (int i = 0; i < numberStringArray.length - 1; i++) {
                if ((int) numberStringArray[i] < (int) numberStringArray[i + 1]) {
                    char temp;
                    temp = numberStringArray[i];
                    numberStringArray[i] = numberStringArray[i + 1];
                    numberStringArray[i + 1] = temp;
                }
            }
            for (int i = 0; i < numberStringArray.length - 1; i++) {
                if ((int) numberStringArray[i] < (int) numberStringArray[i + 1]) {
                    isSorted = false;
                }
            }
        } while (!isSorted);
        return Integer.parseInt(String.copyValueOf(numberStringArray));
    }

    public static int sortSB(Integer number) {

        String numberString = String.format("%04d", number);

        char[] numberStringArray = numberString.toCharArray();

        boolean isSorted;

        do {
            isSorted = true;
            for (int i = 0; i < numberStringArray.length - 1; i++) {
                if ((int) numberStringArray[i] > (int) numberStringArray[i + 1]) {
                    char temp;
                    temp = numberStringArray[i];
                    numberStringArray[i] = numberStringArray[i + 1];
                    numberStringArray[i + 1] = temp;
                }
            }
            for (int i = 0; i < numberStringArray.length - 1; i++) {
                if ((int) numberStringArray[i] > (int) numberStringArray[i + 1]) {
                    isSorted = false;
                }
            }
        } while (!isSorted);
        return Integer.parseInt(String.copyValueOf(numberStringArray));

    }

}

class Kaprekar {

    Integer contador;

    public Kaprekar() {
        this.contador = 0;
    }

    public int sortBS(int number) {
        String numberString = String.format("%04d", number);
        char[] numberStringArray = numberString.toCharArray();
        boolean isSorted;
        do {
            isSorted = true;
            for (int i = 0; i < numberStringArray.length - 1; i++) {
                if ((int) numberStringArray[i] < (int) numberStringArray[i + 1]) {
                    char temp;
                    temp = numberStringArray[i];
                    numberStringArray[i] = numberStringArray[i + 1];
                    numberStringArray[i + 1] = temp;
                }
            }
            for (int i = 0; i < numberStringArray.length - 1; i++) {
                if ((int) numberStringArray[i] < (int) numberStringArray[i + 1]) {
                    isSorted = false;
                }
            }
        } while (!isSorted);
        return Integer.parseInt(String.copyValueOf(numberStringArray));
    }

    public int sortSB(int number) {
        String numberString = String.format("%04d", number);

        char[] numberStringArray = numberString.toCharArray();

        boolean isSorted;

        do {
            isSorted = true;
            for (int i = 0; i < numberStringArray.length - 1; i++) {
                if ((int) numberStringArray[i] > (int) numberStringArray[i + 1]) {
                    char temp;
                    temp = numberStringArray[i];
                    numberStringArray[i] = numberStringArray[i + 1];
                    numberStringArray[i + 1] = temp;
                }
            }
            for (int i = 0; i < numberStringArray.length - 1; i++) {
                if ((int) numberStringArray[i] > (int) numberStringArray[i + 1]) {
                    isSorted = false;
                }
            }
        } while (!isSorted);
        return Integer.parseInt(String.copyValueOf(numberStringArray));
    }

    public void showKaprekar(int number) {
        contador++;
        int numberSB = sortSB(number);
        int numberBS = sortBS(number);
        if (numberSB == numberBS) {
            System.out.println("Numeros con las 4 cifras iguales o numeros iguales a 0 no funcionan ");
        } else {
            int diff = numberBS - numberSB;

            System.out.println(String.format("%04d", numberBS) + " - " + String.format("%04d", numberSB) + " = " + diff);

            if (diff != 6174) {
                showKaprekar(diff);
            } else {
                System.out.println("La constante de kaprekar se ha encontrado en: ".concat(contador.toString()).concat(" pasos"));
            }
        }

    }
}
