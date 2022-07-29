package atos;

import java.io.File;
import java.util.Scanner;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator(new File("eurofxref-daily.xml"));
        SwingUtilities.invokeLater(() -> GUI.showGUI(calculator));

//  wersja konsolowa
//        @SuppressWarnings("resource")
//        Scanner scanner = new Scanner(System.in);
//        double value;
//        String currencyCode;
//        boolean isCurrencyOk;

//        for (boolean b = true; b;) {
//            System.out.print("Podaj kwotę w EUR: ");
//            value = Double.parseDouble(scanner.nextLine());
//
//            System.out.println(calculator.getAllCurrencies());
//            System.out.print("Wpisz kod waluty z podanych wyżej: ");
//
//            isCurrencyOk = true;
//            do {
//                currencyCode = scanner.nextLine();
//
//                if (calculator.getAllCurrencies().contains(currencyCode)) {
//                    System.out.println("Wartośc po przeliczeniu na " + currencyCode + ": "
//                            + calculator.getCalculatedValue(value, currencyCode));
//                    isCurrencyOk = false;
//                    System.out.print("Czy kontynuować? (T/N): ");
//                    if(!scanner.nextLine().equals("T")) {
//                        b = false;
//                        System.out.println("Dziękujemy za skorzystanie z usług!");
//                    }
//                } else {
//                    System.out.print("Wprowadz poprawny kod waluty: ");
//                }
//            } while (isCurrencyOk);
//        }
    }
}
