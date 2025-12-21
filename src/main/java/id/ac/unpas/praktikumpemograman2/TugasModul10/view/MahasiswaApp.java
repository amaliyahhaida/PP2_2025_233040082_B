/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.TugasModul10.view;

/**
 *
 * @author Amaliyah
 */

import id.ac.unpas.praktikumpemograman2.TugasModul10.controller.MahasiswaController;
import id.ac.unpas.praktikumpemograman2.TugasModul10.model.Mahasiswa;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MahasiswaApp extends JFrame {

    JTextField txtNama, txtNIM, txtJurusan, txtCari;
    JButton btnSimpan, btnCari;
    JTable table;
    DefaultTableModel model;
    MahasiswaController controller = new MahasiswaController();

    public MahasiswaApp() {
        setTitle("MVC Mahasiswa - Modul 10");
        setSize(600, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel form = new JPanel(new GridLayout(4,2));
        txtNama = new JTextField();
        txtNIM = new JTextField();
        txtJurusan = new JTextField();

        form.add(new JLabel("Nama")); form.add(txtNama);
        form.add(new JLabel("NIM")); form.add(txtNIM);
        form.add(new JLabel("Jurusan")); form.add(txtJurusan);

        btnSimpan = new JButton("Simpan");
        form.add(btnSimpan);

        add(form, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"No","Nama","NIM","Jurusan"},0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel cari = new JPanel();
        txtCari = new JTextField(20);
        btnCari = new JButton("Cari");
        cari.add(new JLabel("Cari Nama"));
        cari.add(txtCari);
        cari.add(btnCari);
        add(cari, BorderLayout.SOUTH);

        btnSimpan.addActionListener(e -> simpan());
        btnCari.addActionListener(e ->
            controller.cari(model, txtCari.getText())
        );

        controller.loadData(model);
    }

    private void simpan() {
        if (txtNama.getText().isEmpty() || txtNIM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Data tidak boleh kosong!");
            return;
        }

        if (controller.cekNIM(txtNIM.getText())) {
            JOptionPane.showMessageDialog(this,"NIM sudah ada!");
            return;
        }

        try {
            controller.tambahData(new Mahasiswa(
                txtNama.getText(),
                txtNIM.getText(),
                txtJurusan.getText()
            ));
            controller.loadData(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Gagal simpan");
        }
    }
}