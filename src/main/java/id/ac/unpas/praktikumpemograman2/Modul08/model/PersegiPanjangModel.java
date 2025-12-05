/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.praktikumpemograman2.Modul08.model;

/**
 *
 * @author Amaliyah
 */

public class PersegiPanjangModel {
    private double panjang;
    private double lebar;
    private double luas;
    
    // latihan 2 (variabel untuk keliling)
    private double keliling;

    // Menghitung luas (Logika Bisnis)
    public void hitungLuas() {
        this.luas = this.panjang * this.lebar;
    }
    
    // latihan 2
    public void hitungKeliling() {
        this.keliling = 2 * (this.panjang + this.lebar);
    }

    // Setters
    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }

    // Getter
    public double getLuas() {
        return luas;
    }
    
    // getter latihan 2 (mengambil nilai keliling)
    public double getKeliling() {
        return keliling;
    }
}