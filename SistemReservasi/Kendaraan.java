/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemReservasi;

/**
 *
 * @author p
 */
public abstract class Kendaraan {
    private String noPlat;
    private String merk;
    private boolean isDisewa;

    // CONSTRUCTOR: Method khusus yang dipanggil saat sebuah objek dibuat ('new Kendaraan(...)').
    // Berguna untuk menginisialisasi nilai awal properti.
    public Kendaraan(String noPlat, String merk) {
        this.noPlat = noPlat;
        this.merk = merk;
        this.isDisewa = false; // Setiap kendaraan baru statusnya tidak disewa
    }

    // ENCAPSULATION: Contoh Getter (untuk mendapatkan nilai)
    public String getNoPlat() {
        return noPlat;
    }

    public String getMerk() {
        return merk;
    }

    public boolean isDisewa() {
        return isDisewa;
    }

    // ENCAPSULATION: Contoh Setter (untuk mengubah nilai)
    public void setDisewa(boolean disewa) {
        isDisewa = disewa;
    }

    // METHOD ABSTRACT: Method tanpa isi. Kelas turunan (child class) WAJIB
    // memberikan implementasi/isi untuk method ini. Ini adalah kunci dari Polymorphism.
    public abstract double hitungBiayaSewa(int lamaSewa);

    // Method biasa untuk menampilkan info
    public void displayInfo() {
        System.out.println("No. Plat: " + noPlat);
        System.out.println("Merk: " + merk);
        System.out.println("Status: " + (isDisewa ? "Disewa" : "Tersedia"));
    }
}
