package atos;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Calculator {
    Map<String, Double> currencies = new LinkedHashMap<>();

    public Calculator(File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            // pobieranie danych
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            // normalizacja
            document.getDocumentElement().normalize();
            document.getElementsByTagName("currency");
            NodeList nodeList = document.getElementsByTagName("Cube");

            for (int i = 2; i < nodeList.getLength(); i++) {
                currencies.put(nodeList.item(i).getAttributes().getNamedItem("currency").getNodeValue(),
                        Double.parseDouble(nodeList.item(i).getAttributes().getNamedItem("rate").getNodeValue()));
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCalculatedValue(double value, String currCode) {
        DecimalFormatSymbols sym = DecimalFormatSymbols.getInstance();
        sym.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.##");
        df.setDecimalFormatSymbols(sym);
        return df.format(value * currencies.get(currCode));
    }

    public Set<String> getAllCurrencies() {
        return currencies.keySet();
    }
}
