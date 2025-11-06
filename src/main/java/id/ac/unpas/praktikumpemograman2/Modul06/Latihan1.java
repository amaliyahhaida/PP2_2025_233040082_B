/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul06;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Amaliyah
 */

public class Latihan1 {
    public static void main(String[] args) {
        // 1. Buat Frame
        JFrame frame = new JFrame("Kalkulator Sederhana");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400); 

        // 2. Buat layar di bagian atas menggunakan JTextField
        JTextField layar = new JTextField();
        layar.setFont(new Font("Arial", Font.BOLD, 28));
        frame.add(layar, BorderLayout.NORTH); 

        // 3. Buat panel untuk tombol menggunakan GridLayout 4 baris, 4 kolom
        JPanel panelTombol = new JPanel();
        panelTombol.setLayout(new GridLayout(4, 4, 5, 5)); 

        // 4. Tambahkan 16 komponen (10 angka 0-9 dan 4 operator +,-,*,/)
        panelTombol.add(new JButton("7"));
        panelTombol.add(new JButton("8"));
        panelTombol.add(new JButton("9"));
        panelTombol.add(new JButton("/"));

        panelTombol.add(new JButton("4"));
        panelTombol.add(new JButton("5"));
        panelTombol.add(new JButton("6"));
        panelTombol.add(new JButton("*"));

        panelTombol.add(new JButton("1"));
        panelTombol.add(new JButton("2"));
        panelTombol.add(new JButton("3"));
        panelTombol.add(new JButton("-"));
        
        panelTombol.add(new JButton("0"));
        panelTombol.add(new JButton(".")); 
        panelTombol.add(new JButton("=")); 
        panelTombol.add(new JButton("+"));

        // 5. Tambahkan panel tombol ke frame di bagian CENTER
        frame.add(panelTombol, BorderLayout.CENTER);

        // 6. Tampilkan frame
        frame.setVisible(true);
    }
}



