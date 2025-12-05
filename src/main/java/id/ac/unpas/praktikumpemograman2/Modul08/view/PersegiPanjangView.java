/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul08.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Amaliyah
 */

public class PersegiPanjangView extends JFrame {
    // Komponen UI sebagai atribut
    private JTextField txtPanjang = new JTextField(10);
    private JTextField txtLebar = new JTextField(10);
    
    // latihan 2 (modifikasi lblHasil menjadi lblHasilLuas)
    private JLabel lblHasilLuas = new JLabel("-");
    
    // latihan 2 ( label untuk hasil keliling)
    private JLabel lblHasilKeliling = new JLabel("-"); 
    private JButton btnHitung = new JButton("Hitung Luas & Keliling");
    
    // latihan 3 (tombol reset)
    private JButton btnReset = new JButton("Reset");
    
    public PersegiPanjangView() {
        // Inisialisasi UI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // ukuran diperbesar 
        this.setSize(300, 250);
        
        //latihan 3 (modifikasi 4 baris 2 kolom menjadi 5 baris 3 kolom)
        this.setLayout(new GridLayout(5, 3, 10, 10)); 
        this.setTitle("MVC Kalkulator");

        this.add(new JLabel("Panjang:"));
        this.add(txtPanjang);
        this.add(new JLabel(""));
        
        this.add(new JLabel("Lebar:"));
        this.add(txtLebar);
        this.add(new JLabel(""));
        
        // latihan 2 
        this.add(new JLabel("Hasil Luas:"));
        this.add(lblHasilLuas);
        this.add(new JLabel("")); 
        
        // latihan 2 (menampilkan hasil keliling)
        this.add(new JLabel("Hasil Keliling:"));
        this.add(lblHasilKeliling); 
        this.add(new JLabel("")); 
        
        // latihan 3 (tombol reset)
        this.add(btnReset); 
        this.add(btnHitung);
        this.add(new JLabel(""));
    }
    
    // Mengambil nilai panjang dari Textfield
    public double getPanjang() throws NumberFormatException {
        return Double.parseDouble(txtPanjang.getText());
    }

    // Mengambil nilai lebar dari Textfield
    public double getLebar() throws NumberFormatException {
        return Double.parseDouble(txtLebar.getText());
    }
    
    // latihan 2 (modifikasi setHasil menjadi setHasilLuas 
    public void setHasilLuas(double hasil) {
        lblHasilLuas.setText(String.valueOf(hasil));
    }
    
    // latihan 2 (menampilkan hasil keliling)
    public void setHasilKeliling(double hasil) { 
        lblHasilKeliling.setText(String.valueOf(hasil));
    }
    
    // latihan 3 (method untuk mereset semua input dan output)
    public void reset() {
        txtPanjang.setText("");
        txtLebar.setText("");
        lblHasilLuas.setText("-");
        lblHasilKeliling.setText("-");
    }
    
    // Menampilkan pesan error
    public void tampilkanPesanError(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }
    
    // Mendaftarkan Listener untuk tombol
    public void addHitungListener(ActionListener listener) {
        btnHitung.addActionListener(listener);
    }
    
    // latihan 3 (listener reset)
    public void addResetListener(ActionListener listener) {
        btnReset.addActionListener(listener);
    }
}