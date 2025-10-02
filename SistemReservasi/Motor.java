/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemReservasi;

/**
 *
 * @author p
 */
public class Motor extends Kendaraan {
    private String jenisTransmisi; 

    public Motor(String noPlat, String merk, String jenisTransmisi) {
        super(noPlat, merk);
        this.jenisTransmisi = jenisTransmisi;
    }

    @Override
    public double hitungBiayaSewa(int lamaSewa) {
        return 150000 * lamaSewa;
    }

    @Override
    public void displayInfo() {
        System.out.println("--- MOTOR ---");
        super.displayInfo();
        System.out.println("Transmisi: " + jenisTransmisi);
    }
}