package Sistem;

import Barang.*;
import InformasiSupplier.InformasiSupplier;
import Supplier.Supplier;

import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                    Inventory inventory = new Inventory();
                    Gudang gudang = new Gudang();

                    System.out.println("\n=====PENERIMAAN BARANG=====");
                    System.out.println("\n=====ISI DATA SUPPLIER=====");
                    System.out.print("ID Supplier : ");
                    String idSupplier = scanner.nextLine();
                    System.out.print("Nama PT \t: ");
                    String namaPT = scanner.nextLine();
                    System.out.print("No. Telepon : ");
                    String noTelp = scanner.nextLine();
                    System.out.print("Alamat \t\t: ");
                    String alamat = scanner.nextLine();
                    Supplier supplier = new Supplier(idSupplier, namaPT, noTelp, alamat);
                    while (true) {
                        Barang barang;
                        id += 1;
                        String kodeBarang = "0" +id;

                        System.out.println("\n=====ISI DATA BARANG=====");
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
                        scanner.nextLine();


                        if (kategori == 1) {
                            barang = new Pakaian(kodeBarang, namaBarang, stok, supplier);
                        } else if (kategori == 2) {
                            barang = new Elektronik(kodeBarang, namaBarang, stok, supplier);
                        } else if (kategori == 3) {
                            barang = new BahanMakanan(kodeBarang, namaBarang, stok, supplier);
                        } else {
                            barang = new Dokumen(kodeBarang, namaBarang, stok, supplier);
                        }
                        inventory.terimaBarang(barang);

                        System.out.print("\n\t+Tambah Barang (y/n): ");
                        String tambahBarang = scanner.nextLine();
                        if (tambahBarang.equals("n")) {
                            String kodeGudang = "0" + id;
                            gudang.simpanBarang(kodeGudang, inventory);
                            System.out.println("Barang telah tersimpan.");
                            System.out.println("Cetak bukti penyimpanan.\n");
                            inventory.tandaTerimaBarang(barang);
//================================Cetak Bukti Penyimpanan=============================================
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n=====PENGELUARAN BARANG=====");
                    break;
                case 3:
                    System.out.println("\n=====CEK STOK=====");
                    break;
                case 4:
                    System.out.println("\n=====INFORMASI SUPPLIER=====");
                    InformasiSupplier informasiSupplier = new InformasiSupplier();

                    informasiSupplier.showInformation();
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
