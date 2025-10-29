/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul05;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author MSI GF63
 */

public class Latihan3 {
    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JFrame frame = new JFrame("Label dan Tombol");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 1. Atur Layout Manager
            // FlowLayout akan menyusun komponen dari kiri ke kanan.
            frame.setLayout(new FlowLayout());

            // 2. Buat komponen GUI
            JLabel label = new JLabel("Teks Awal");
            JButton button = new JButton("Klik Saya!");

            /* 3. Tambahkan Aksi (ActionListener) ke tombol
               Penambahan ini menggunakan lambda untuk mempersingkat
               penggunaan anonymous inner class */
            button.addActionListener(e -> {
                // Aksi ini akan mengubah teks pada label
                label.setText("Tombol berhasil diklik!");
            });

            // 4. Tambahkan komponen ke JFrame
            frame.add(label);
            frame.add(button);

            // 5. Tampilkan jendela
            frame.setVisible(true);
        }
    });
  }
}
