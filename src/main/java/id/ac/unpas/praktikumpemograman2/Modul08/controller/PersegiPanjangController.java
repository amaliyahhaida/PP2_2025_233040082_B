/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul08.controller;

/**
 *
 * @author Amaliyah
 */

import id.ac.unpas.praktikumpemograman2.Modul08.model.PersegiPanjangModel;
import id.ac.unpas.praktikumpemograman2.Modul08.view.PersegiPanjangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersegiPanjangController {
    // Atribut Model dan View
    private PersegiPanjangModel model;
    private PersegiPanjangView view;

    public PersegiPanjangController(PersegiPanjangModel model, PersegiPanjangView view) {
        this.model = model;
        this.view = view;
        
        // Menghubungkan tombol di View dengan logic di Controller
        this.view.addHitungListener(new HitungListener());
        
        // latihan 3 (listener untuk tombol reset)
        this.view.addResetListener(new ResetListener());
    }

    // Inner class untuk menangani event klik tombol
    class HitungListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // 1. Ambil data dari View
                double p = view.getPanjang();
                double l = view.getLebar();

                // 2. Kirim data ke Model
                model.setPanjang(p);
                model.setLebar(l);

                // 3. Jalankan logika bisnis di Model
                model.hitungLuas();
                
                // latihan 2 (method untuk manggil hitungKeliling())
                model.hitungKeliling();

                double hasilLuas = model.getLuas();
                double hasilKeliling = model.getKeliling();

                view.setHasilLuas(hasilLuas);
                view.setHasilKeliling(hasilKeliling);
                
            } catch (NumberFormatException ex) {
                // Handle jika user memasukkan huruf
                view.tampilkanPesanError("Masukkan angka yang valid!");
            }
        }
    }
    
    // latihan 3 (inner class reset)
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Panggil method reset() yang ada di View
            view.reset();
        }
    }
}