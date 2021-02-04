package com.gmail.kar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Converter extends JFrame {
    private JButton button = new JButton("Convert");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input temperature:");
    private JRadioButton celsius = new JRadioButton("Celsius");
    private JRadioButton fahrenheit = new JRadioButton("Fahrenheit");

    public Converter() {
        super("Converter");
        this.setBounds(100, 100, 300, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(celsius);
        group.add(fahrenheit);
        container.add(celsius);

        celsius.setSelected(true);
        container.add(fahrenheit);
        button.addActionListener(new Converter.ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String getText = input.getText();
            int textToInt = Integer.parseInt(getText);
            double toCelsius = (double) (textToInt - 32) / 9 * 5;
            double toFahrenheit = (double) (textToInt * 9) / 5 + 32;
            String convertToFahrenheit = String.format("%.2f", toFahrenheit);
            String convertToCelsius = String.format("%.2f", toCelsius);

            String message = "";
            message += (celsius.isSelected() ? "You choice to convert to Celsius" + "\n" : "You choice to convert to Fahrenheit" + "\n");
            message += "Your input: " + input.getText() + "\n";
            if (celsius.isSelected()) {
                message += "Result of conversion: " + convertToCelsius + "\n";
            } else {
                message += "Result of conversion: " + convertToFahrenheit + "\n";
            }

            JOptionPane.showMessageDialog(null,
                    message,
                    "Conversion result",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Converter app = new Converter();
        app.setVisible(true);
    }
}
