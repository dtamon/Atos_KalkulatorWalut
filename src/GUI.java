import javafx.scene.layout.Pane;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class GUI {
    public static void showGUI(Calculator calculator){
        JFrame frame = new JFrame("Kalkulator walut");
//        frame.setMinimumSize(new Dimension(500, 500));

        Panel panel = new Panel();
        panel.setLayout(new BorderLayout());

        Panel pInsValue = new Panel();
        pInsValue.setLayout(new GridLayout(1,2));
        JLabel labelInsValue = new JLabel("Podaj kwotę w EUR: ");
        JTextField inputValue = new JTextField();
        pInsValue.add(labelInsValue);
        pInsValue.add(inputValue);
        panel.add(pInsValue, BorderLayout.NORTH);

        Panel pCalcValue = new Panel();
        pCalcValue.setLayout(new GridLayout(1, 3));
        JLabel labelCalcValue = new JLabel("Kwota po przeliczeniu na ");
        JComboBox currencies = new JComboBox(calculator.GetAllCurrencies().toArray(new String[0]));
        JLabel finalValue = new JLabel();
        pCalcValue.add(labelCalcValue);
        pCalcValue.add(currencies);
        pCalcValue.add(finalValue);
        panel.add(pCalcValue, BorderLayout.SOUTH);

        currencies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isNumeric(inputValue.getText())) {
                    double value = calculator.GetCalculatedValue(Double.parseDouble(inputValue.getText())
                            , (String) currencies.getSelectedItem());
                    finalValue.setText(String.valueOf(value));
                } else {
                    JOptionPane.showMessageDialog(frame, "Wprowadź poprawną liczbę!");
                }
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    static boolean isNumeric(String strNum){
        if (strNum == null){
            return false;
        }
        return Pattern.matches("-?\\d+(\\.\\d+)?", strNum);
    }
}
