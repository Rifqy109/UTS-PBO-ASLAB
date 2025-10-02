/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemReservasi;

/**
 *
 * @author p
 */
public class Penyewa {
    private String nama;
    private String noKtp;

    public Penyewa(String nama, String noKtp) {
        this.nama = nama;
        this.noKtp = noKtp;
    }

    public String getNama() {
        return nama;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void displayInfo() {
        System.out.println("Nama Penyewa: " + nama + " (KTP: " + noKtp + ")");
    }
}
