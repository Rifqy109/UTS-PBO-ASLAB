/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemReservasi;

/**
 *
 * @author p
 */
public class Mobil extends Kendaraan {
    private String tipe;

    public Mobil(String noPlat, String merk, String tipe) {
        super(noPlat, merk);
        this.tipe = tipe;
    }

    public String getTipe() {
        return tipe;
    }

    @Override
    public double hitungBiayaSewa(int lamaSewa) {
        return 500000 * lamaSewa;
    }

    @Override
    public void displayInfo() {
        System.out.println("--- MOBIL ---");
        super.displayInfo();
        System.out.println("Tipe: " + tipe);
    }
    
}
