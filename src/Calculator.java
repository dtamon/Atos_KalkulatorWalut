import java.io.File;
import java.io.IOException;
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

    public Calculator(File file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // pobieranie danych
        Document document = builder.parse(file);

        // normalizacja
        document.getDocumentElement().normalize();
        document.getElementsByTagName("currency");
        NodeList nodeList = document.getElementsByTagName("Cube");

        for (int i = 2; i < nodeList.getLength(); i++) {
            currencies.put(nodeList.item(i).getAttributes().getNamedItem("currency").getNodeValue(),
                    Double.parseDouble(nodeList.item(i).getAttributes().getNamedItem("rate").getNodeValue()));
        }
    }

    public double GetCalculatedValue(double value, String currCode) {
        return value * currencies.get(currCode);
    }

    public Set<String> GetAllCurrencies() {
        return currencies.keySet();
    }
}
