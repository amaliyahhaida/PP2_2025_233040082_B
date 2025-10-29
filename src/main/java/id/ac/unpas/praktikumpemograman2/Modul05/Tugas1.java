/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul05;

/**
 *
 * @author MSI GF63
 */

import java.awt.BorderLayout;
import javax.swing.*;

public class Tugas1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Contoh BorderLayout dengan Aksi Tombol");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setLayout(new BorderLayout());

                JLabel label = new JLabel("Silakan klik tombol yang ada.");
                JButton buttonSouth = new JButton("SOUTH");
                JButton buttonNorth = new JButton("NORTH");
                JButton buttonWest = new JButton("WEST");
                JButton buttonEast = new JButton("EAST");
                JButton buttonCenter = new JButton("CENTER");

                // Aksi tombol SOUTH (sudah ada di latihan4)
                buttonSouth.addActionListener(e -> {
                    label.setText("Tombol di SOUTH diklik!");
                });

                // Aksi tombol NORTH
                buttonNorth.addActionListener(e -> {
                    label.setText("Tombol di NORTH diklik!");
                });

                // Aksi tombol WEST
                buttonWest.addActionListener(e -> {
                    label.setText("Tombol di WEST diklik!");
                });

                // Aksi tombol EAST
                buttonEast.addActionListener(e -> {
                    label.setText("Tombol di EAST diklik!");
                });

                // Aksi tombol CENTER
                buttonCenter.addActionListener(e -> {
                    label.setText("Tombol di CENTER diklik!");
                });

                // Tambahkan semua komponen ke frame sesuai posisinya
                frame.add(label, BorderLayout.NORTH);
                frame.add(buttonSouth, BorderLayout.SOUTH);
                frame.add(buttonWest, BorderLayout.WEST);
                frame.add(buttonEast, BorderLayout.EAST);
                frame.add(buttonCenter, BorderLayout.CENTER);

                frame.setVisible(true);
            }
        });
    }
 }    


