/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul07;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Amaliyah
 */

public class TugasModul07 extends JFrame {

    private JTextField inputNama;
    private JTextField inputNilai;
    private JComboBox<String> inputMatkul;

    private JTable tableData;
    private DefaultTableModel tableModel;

    private JTabbedPane tabPane;

    public TugasModul07() {
        setTitle("Manajemen Nilai Siswa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabPane = new JTabbedPane();

        tabPane.addTab("Input Data", createInputPanel());
        tabPane.addTab("Daftar Nilai", createTablePanel());

        add(tabPane);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelNama = new JLabel("Nama Siswa:");
        JLabel labelNilai = new JLabel("Nilai:");
        JLabel labelMatkul = new JLabel("Mata Kuliah:");

        inputNama = new JTextField();
        inputNilai = new JTextField();

        inputMatkul = new JComboBox<>(new String[]{
                "Algoritma",
                "Basis Data",
                "Pemrograman II",
                "Matematika"
        });

        JButton btnSimpan = new JButton("Simpan Data");
        btnSimpan.addActionListener(e -> prosesSimpan());

        // Tugas Modifikasi 4: Tambahkan tombol reset pada Tab Input Data 
        // yang berfungsi untuk membersihkan semua inputan (Nama dan Nilai)
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(e -> {
            inputNama.setText("");
            inputNilai.setText("");
            inputNama.requestFocus();
        });

        panel.add(labelNama);
        panel.add(inputNama);

        panel.add(labelNilai);
        panel.add(inputNilai);

        panel.add(labelMatkul);
        panel.add(inputMatkul);

        panel.add(btnSimpan);
        panel.add(btnReset);

        return panel;
    }

    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(
                new Object[]{"Nama", "Nilai", "Mata Kuliah", "Grade"},0);

        tableData = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableData);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Tugas Modifikasi 2: Tambah tombol hapus di panel bagian bawah Tab Daftar Nilai
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnHapus = new JButton("Hapus Data");

        btnHapus.addActionListener(e -> {
            int selectedRow = tableData.getSelectedRow();

            if (selectedRow > -1) {
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this,
                        "Data berhasil dihapus!",
                        "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Pilih baris data yang ingin dihapus terlebih dahulu!",
                        "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });

        buttonPanel.add(btnHapus);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void prosesSimpan() {
        String nama = inputNama.getText().trim();
        String strNilai = inputNilai.getText().trim();
        String matkul = (String) inputMatkul.getSelectedItem();

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Nama tidak boleh kosong!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tugas Modifikasi 3: Tambahkan validasi untuk memastikan nama 
        // siswa minimal terdiri dari 3 karakter
        if (nama.length() < 3) {
            JOptionPane.showMessageDialog(this,
                    "Nama harus terdiri dari minimal 3 karakter!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int nilai;

        try {
            nilai = Integer.parseInt(strNilai);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Nilai harus berupa angka!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nilai < 0 || nilai > 100) {
            JOptionPane.showMessageDialog(this,
                    "Nilai harus antara 0 - 100!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tugas Modifikasi 1: Ubah logika untuk menentukan grade 
        // menjadi menggunakan switch case
        String grade;
        switch (nilai / 10) {
        case 10:
        case 9:
        case 8:
            grade = "A";
            break;
        case 7:
        case 6:
            grade = "AB";
            break;
        case 5:
            grade = "B";
            break;
        case 4:
            grade = "BC";
            break;
        case 3:
            grade = "C";
            break;
        case 2:
            grade = "D";
            break;
        default: 
            grade = "E";
            break;
    }

        tableModel.addRow(new Object[]{
                nama, nilai, matkul, grade
        });

        JOptionPane.showMessageDialog(this,
                "Data berhasil disimpan!",
                "Sukses", JOptionPane.INFORMATION_MESSAGE);

        inputNama.setText("");
        inputNilai.setText("");
        inputNama.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TugasModul07().setVisible(true);
        });
    }
}