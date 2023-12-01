package Sistem;

import Barang.*;
import Supplier.Supplier;
import java.util.Scanner;

public class Dashboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int idPK = 0, idEL = 0, idBM = 0, idDK = 0, idGudang = 0;
        Gudang gudang = new Gudang();

        System.out.println("=====SELAMAT DATANG DI SISTEM GUDANG=====");
        while (true) {
            System.out.println("\nSilahkan pilih menu kelola berikut");
            System.out.println("1. Penerimaan Barang");
            System.out.println("2. Pengeluaran Barang");
            System.out.println("3. Data Barang");
            System.out.println("4. Informasi Supplier");
            System.out.println("0. Logout");
            System.out.print("Masukkan pilihan: ");

            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    Inventory inventory = new Inventory();
                    idGudang += 1;
                    String kodeGudang = "0" + idGudang;

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
                            idPK += 1;
                            String kodeBarang = "0" + idPK;
                            barang = new Pakaian(kodeBarang, namaBarang, stok);
                        } else if (kategori == 2) {
                            idEL += 1;
                            String kodeBarang = "0" + idEL;
                            barang = new Elektronik(kodeBarang, namaBarang, stok);
                        } else if (kategori == 3) {
                            idBM += 1;
                            String kodeBarang = "0" + idBM;
                            barang = new BahanMakanan(kodeBarang, namaBarang, stok);
                        } else {
                            idDK += 1;
                            String kodeBarang = "0" + idDK;
                            barang = new Dokumen(kodeBarang, namaBarang, stok);
                        }
                        inventory.terimaBarang(supplier, barang);

                        System.out.print("\n\t+Tambah Barang (y/n): ");
                        String tambahBarang = scanner.nextLine();
                        if (tambahBarang.equals("n")) {
                            gudang.setKodeGudang(kodeGudang);
                            gudang.simpanBarang(inventory);
                            System.out.println("Barang telah tersimpan.\n");
                            System.out.println("======== TANDA TERIMA BARANG ========");
                            inventory.tampilkanData();
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("\n=====PENGELUARAN BARANG=====");
                    System.out.print("\nMasukkan kode barang: ");
                    String kodeBarang = scanner.nextLine();
                    Barang barang = inventory.cariBarang(kodeBarang);
                    if (barang != null) {
                        System.out.println("Barang ditemukan.");
                        barang.infoBarang();
                        System.out.println("Pilih tindakan berikut");
                        System.out.println("1. Kurangi stok \t2. Berhenti menyimpan");
                        System.out.print("Pilihan : ");
                        int pilihan = scanner.nextInt();
                        scanner.nextLine();

                        switch (pilihan) {
                            case 1 :
                                System.out.println("Masukkan jumlah yang dikurangi : ");
                                int jumlah = scanner.nextInt();
                                scanner.nextLine();
                                inventory.kurangiBarang(barang, jumlah);
                                break;
                            case 2 :
                                gudang.keluarkanBarang(inventory);
                                inventory.berhentiMenyimpan(barang);
                                break;
                            default :
                                System.out.println("Invalid option.");
                        }
                    } else {
                        System.out.println("Barang dengan kode: " +kodeBarang+ " tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.println("\n=====DATA BARANG=====");
                    gudang.dataBarang();
                    break;
                case 4:
                    System.out.println("\n=====INFORMASI SUPPLIER=====");
                    gudang.dataSupplier();
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
