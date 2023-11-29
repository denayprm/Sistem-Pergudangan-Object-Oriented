package Sistem;

import Barang.*;
import java.util.Scanner;

public class Dashboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id = 0;

        System.out.println("=====SELAMAT DATANG DI SISTEM GUDANG=====");
        while (true) {
            System.out.println("\nSilahkan pilih menu kelola berikut");
            System.out.println("1. Penerimaan Barang");
            System.out.println("2. Pengeluaran Barang");
            System.out.println("3. Cek Stok");
            System.out.println("4. Informasi Supplier");
            System.out.println("0. Logout");
            System.out.print("Masukkan pilihan: ");

            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    while (true) {
                        Inventory inventory = new Inventory();
                        id += 1;
                        String kodeBarang = "0" +id;

                        System.out.println("\n=====PENERIMAAN BARANG=====");
                        System.out.println("\nSilahkan isi form barang");
                        System.out.print("Nama Barang\t\t: ");
                        String namaBarang = scanner.nextLine();
                        System.out.print("Jumlah Barang\t: ");
                        int stok = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Kategori Barang");
                        System.out.println("1. Pakaian \t2. Elektronik " +
                                "\t3. Bahan Makanan \t4. Dokumen");
                        System.out.print("Kategori Pilihan : ");
                        int kategori = scanner.nextInt();
//====================================================================================================
                        System.out.print("\nMasukkan ID Supplier : "); // BELUM DIBUAT !!!!!
                        String idSupplier = scanner.nextLine();
                        System.out.print("Masukkan nama \t: ");
                        String namaSupplier = scanner.nextLine();
//====================================================================================================
                        if (kategori == 1) {
                            Barang pakaian = new Pakaian(kodeBarang, namaBarang, stok);
                            inventory.terimaBarang(pakaian);
                        } else if (kategori == 2) {
                            Barang elektronik = new Elektronik(kodeBarang, namaBarang, stok);
                            inventory.terimaBarang(elektronik);
                        } else if (kategori == 3) {
                            Barang bahanMakanan = new BahanMakanan(kodeBarang, namaBarang, stok);
                            inventory.terimaBarang(bahanMakanan);
                        } else {
                            Barang dokumen = new Dokumen(kodeBarang, namaBarang, stok);
                            inventory.terimaBarang(dokumen);
                        }

                        System.out.print("\n\t+Tambah Barang (y/n): ");
                        String tambahBarang = scanner.nextLine();
                        if (tambahBarang == "n") {
                            System.out.println("Barang telah tersimpan.");
                            System.out.println("Cetak bukti penyimpanan.");
//================================Cetak Bukti Penyimpanan=============================================
                            break;
                        }
                    }
                case 2:
                    System.out.println("\n=====PENGELUARAN BARANG=====");
                    break;
                case 3:
                    System.out.println("\n=====CEK STOK=====");
                    break;
                case 4:
                    System.out.println("\n=====INFORMASI SUPPLIER=====");
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("\n=====NOT FOUND=====");
            }
        }
    }
}
