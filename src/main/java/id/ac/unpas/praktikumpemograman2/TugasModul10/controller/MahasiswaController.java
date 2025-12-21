/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.TugasModul10.controller;

/**
 *
 * @author Amaliyah
 */

import id.ac.unpas.praktikumpemograman2.Modul10.KoneksiDB;
import id.ac.unpas.praktikumpemograman2.TugasModul10.model.Mahasiswa;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MahasiswaController {

    public void loadData(DefaultTableModel model) {
        model.setRowCount(0);
        try {
            Connection conn = KoneksiDB.configDB();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM mahasiswa");

            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("jurusan")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean cekNIM(String nim) {
        try {
            Connection conn = KoneksiDB.configDB();
            PreparedStatement ps =
                conn.prepareStatement("SELECT nim FROM mahasiswa WHERE nim=?");
            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            return false;
        }
    }

    public void tambahData(Mahasiswa m) throws Exception {
        Connection conn = KoneksiDB.configDB();
        PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO mahasiswa VALUES (?,?,?)"
        );
        ps.setString(1, m.getNama());
        ps.setString(2, m.getNim());
        ps.setString(3, m.getJurusan());
        ps.execute();
    }

    public void cari(DefaultTableModel model, String keyword) {
        model.setRowCount(0);
        try {
            Connection conn = KoneksiDB.configDB();
            PreparedStatement ps =
                conn.prepareStatement("SELECT * FROM mahasiswa WHERE nama LIKE ?");
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            int no = 1;
            while (rs.next()) {
                model.addRow(new Object[]{
                    no++,
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("jurusan")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}