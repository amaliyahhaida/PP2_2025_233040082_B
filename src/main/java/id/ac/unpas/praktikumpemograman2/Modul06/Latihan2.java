/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Amaliyah
 */

public class Latihan2 {
    public static void main(String[] args) {
        // Inisialisasi Frame
        JFrame frame = new JFrame("Konverter Suhu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout()); 

        // 1. Buat Komponen
        JLabel labelCelsius = new JLabel("Celsius:");
        JTextField inputCelsius = new JTextField(10); 
        JButton tombolKonversi = new JButton("Konversi");
        JLabel labelFahrenheit = new JLabel("Fahrenheit:");
        JTextField outputFahrenheit = new JTextField(10);
        outputFahrenheit.setEditable(false); // agar tidak bisa diketik

        // 2. Tambahkan ActionListener ke tombol
        tombolKonversi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teksCelsius = inputCelsius.getText();

                try {
                    double celsius = Double.parseDouble(teksCelsius);
                    double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;
                    outputFahrenheit.setText(String.format("%.2f °F", fahrenheit));
                } catch (NumberFormatException ex) {
                    // Buat penanganan jika input bukan angka
                    JOptionPane.showMessageDialog(
                            frame,
                            "Input tidak valid. Harap masukkan angka.",
                            "Kesalahan Input",
                            JOptionPane.ERROR_MESSAGE
                    );
                    outputFahrenheit.setText("ERROR");
                }
            }
        });

        // 3. Tambahkan komponen ke frame
        frame.add(labelCelsius);
        frame.add(inputCelsius);
        frame.add(tombolKonversi);
        frame.add(labelFahrenheit);
        frame.add(outputFahrenheit);

        // 4. Tampilkan frame
        frame.setVisible(true);
    }
}

