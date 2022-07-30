package atos;

import java.io.File;
import java.util.Scanner;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator(new File("eurofxref-daily.xml"));
        SwingUtilities.invokeLater(() -> GUI.showGUI(calculator));

//  wersja konsolowa
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        double value = 0;
        String currencyCode;
        boolean isCurrencyOk = false, isValueOk = false;

//        for (boolean b = true; b;) {
//            System.out.print("Podaj kwotę w EUR: ");
//            do {
//                String val = scanner.nextLine();
//                if (GUI.isNumeric(val)){
//                    value = Double.parseDouble(val);
//                    isValueOk = true;
//                } else {
//                    System.out.print("Kwota musi być liczbą!: ");
//                }
//            } while (!isValueOk);
//
//            System.out.println(calculator.getAllCurrencies());
//            System.out.print("Wpisz kod waluty z podanych wyżej: ");
//
//            do {
//                currencyCode = scanner.nextLine();
//
//                if (calculator.getAllCurrencies().contains(currencyCode)) {
//                    System.out.println("Wartośc po przeliczeniu na " + currencyCode + ": "
//                            + calculator.getCalculatedValue(value, currencyCode));
//                    isCurrencyOk = true;
//                    System.out.print("Czy kontynuować? (T/N): ");
//                    if(!scanner.nextLine().equals("T")) {
//                        b = false;
//                        System.out.println("Dziękujemy za skorzystanie z usług!");
//                    }
//                } else {
//                    System.out.print("Wprowadz poprawny kod waluty: ");
//                }
//            } while (!isCurrencyOk);
//        }
    }
}
