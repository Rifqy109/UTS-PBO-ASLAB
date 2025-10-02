/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemReservasi;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author p
 */
public class SistemReservasi implements OperasiSistem {

    // Menggunakan ArrayList untuk menyimpan list objek
    private ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    private ArrayList<Penyewa> daftarPenyewa = new ArrayList<>();
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SistemReservasi sistem = new SistemReservasi();
        
        int pilihan;

        do {
            System.out.println("\n===== SISTEM RESERVASI KENDARAAN =====");
            System.out.println("1. Tambah Data Kendaraan");
            System.out.println("2. Tambah Data Penyewa");
            System.out.println("3. Lakukan Penyewaan");
            System.out.println("4. Tampilkan Semua Data");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan Anda: ");

            // INPUT
            Scanner scanner = new Scanner(System.in);
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline character dari buffer

            // BRANCHING
            switch (pilihan) {
                case 1:
                    sistem.tambahDataKendaraan();
                    break;
                case 2:
                    sistem.tambahDataPenyewa();
                    break;
                case 3:
                    sistem.lakukanPenyewaan();
                    break;
                case 4:
                    sistem.tampilkanSemuaData();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem kami.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
    }

    @Override
    public void tambahDataKendaraan() {
        System.out.print("Tambah Kendaraan (1: Mobil, 2: Motor): ");
        int jenis = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan No. Plat: ");
        String noPlat = scanner.nextLine();
        System.out.print("Masukkan Merk: ");
        String merk = scanner.nextLine();

        // BRANCHING (Percabangan)
        if (jenis == 1) {
            System.out.print("Masukkan Tipe Mobil (MPV/SUV/Sedan): ");
            String tipe = scanner.nextLine();
            daftarKendaraan.add(new Mobil(noPlat, merk, tipe));
        } else if (jenis == 2) {
            System.out.print("Masukkan Jenis Transmisi (Manual/Matic): ");
            String transmisi = scanner.nextLine();
            daftarKendaraan.add(new Motor(noPlat, merk, transmisi));
        } else {
            System.out.println("Pilihan jenis tidak valid.");
        }
        System.out.println("Data kendaraan berhasil ditambahkan.");
    }

    @Override
    public void tambahDataPenyewa() {
        System.out.print("Masukkan Nama Penyewa: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan No. KTP: ");
        String noKtp = scanner.nextLine();
        daftarPenyewa.add(new Penyewa(nama, noKtp));
        System.out.println("Data penyewa berhasil ditambahkan.");
    }
    
    @Override
    public void lakukanPenyewaan() {
        System.out.println("\n--- Daftar Kendaraan Tersedia ---");
        for (int i = 0; i < daftarKendaraan.size(); i++) {
            // Hanya tampilkan kendaraan yang belum disewa
            if (!daftarKendaraan.get(i).isDisewa()) {
                System.out.println((i + 1) + ". " + daftarKendaraan.get(i).getMerk() + " (" + daftarKendaraan.get(i).getNoPlat() + ")");
            }
        }
        System.out.print("Pilih nomor kendaraan: ");
        int pilKendaraan = scanner.nextInt() - 1;

        System.out.println("\n--- Daftar Penyewa ---");
        for (int i = 0; i < daftarPenyewa.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPenyewa.get(i).getNama());
        }
        System.out.print("Pilih nomor penyewa: ");
        int pilPenyewa = scanner.nextInt() - 1;
        
        System.out.print("Masukkan lama sewa (hari): ");
        int lamaSewa = scanner.nextInt();
        scanner.nextLine();

        // Validasi input
        if (pilKendaraan >= 0 && pilKendaraan < daftarKendaraan.size() && pilPenyewa >= 0 && pilPenyewa < daftarPenyewa.size()) {
            Kendaraan kendaraanDipilih = daftarKendaraan.get(pilKendaraan);
            Penyewa penyewaDipilih = daftarPenyewa.get(pilPenyewa);
            
            // Set status kendaraan menjadi disewa
            kendaraanDipilih.setDisewa(true);
            
            // Membuat objek transaksi baru
            Transaksi transaksiBaru = new Transaksi(penyewaDipilih, kendaraanDipilih, lamaSewa);
            daftarTransaksi.add(transaksiBaru);
            
            System.out.println("Penyewaan berhasil!");
            transaksiBaru.displayInfo();
            
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    @Override
    public void tampilkanSemuaData() {
        System.out.println("\n===== DATA KENDARAAN =====");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Tidak ada data kendaraan.");
        } else {
            for (Kendaraan k : daftarKendaraan) {
                k.displayInfo();
                System.out.println();
            }
        }

        System.out.println("\n===== DATA PENYEWA =====");
        if (daftarPenyewa.isEmpty()) {
            System.out.println("Tidak ada data penyewa.");
        } else {
            for (Penyewa p : daftarPenyewa) {
                p.displayInfo();
            }
        }
        
        System.out.println("\n===== DATA TRANSAKSI =====");
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Tidak ada data transaksi.");
        } else {
            for (Transaksi t : daftarTransaksi) {
                t.displayInfo();
            }
        }
    }
}
