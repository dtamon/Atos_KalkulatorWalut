import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        Calculator calculator = new Calculator(new File("eurofxref-daily.xml"));
//        @SuppressWarnings("resource")
//        Scanner scanner = new Scanner(System.in);
//        double value;
//        String currencyCode;
//        boolean isCurrencyOk;

        SwingUtilities.invokeLater(() -> GUI.showGUI(calculator));

//        for (boolean b = true; b;) {
//            System.out.print("Podaj kwotę w EUR: ");
//            value = Double.parseDouble(scanner.nextLine());
//
//            System.out.println(calculator.GetAllCurrencies());
//            System.out.print("Wpisz kod waluty z podanych wyżej: ");
//
//            isCurrencyOk = true;
//            do {
//                currencyCode = scanner.nextLine();
//
//                if (calculator.GetAllCurrencies().contains(currencyCode)) {
//                    System.out.println("Wartośc po przeliczeniu na " + currencyCode + ": "
//                            + calculator.GetCalculatedValue(value, currencyCode));
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
