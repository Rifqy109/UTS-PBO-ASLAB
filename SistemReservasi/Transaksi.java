/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemReservasi;

/**
 *
 * @author p
 */
public class Transaksi {
    private Penyewa penyewa;
    private Kendaraan kendaraan;
    private int lamaSewa;
    private double totalBiaya;
    
    public Transaksi(Penyewa penyewa, Kendaraan kendaraan, int lamaSewa) {
        this.penyewa = penyewa;
        this.kendaraan = kendaraan;
        this.lamaSewa = lamaSewa;
        // Biaya dihitung saat transaksi dibuat, memanfaatkan polymorphism
        this.totalBiaya = kendaraan.hitungBiayaSewa(lamaSewa); 
    }
    
    public void displayInfo() {
        System.out.println("\n--- BUKTI TRANSAKSI ---");
        penyewa.displayInfo();
        System.out.println("Menyewa Kendaraan:");
        kendaraan.displayInfo();
        System.out.println("Lama Sewa: " + lamaSewa + " hari");
        System.out.printf("Total Biaya: Rp. %,.2f\n", totalBiaya);
        System.out.println("-------------------------");
    }
}
