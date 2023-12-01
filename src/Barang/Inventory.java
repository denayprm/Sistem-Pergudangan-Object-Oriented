package Barang;

import Supplier.Supplier;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Barang> daftarBarang;
    public Inventory() {
        daftarBarang = new ArrayList<>();
    }
    public void terimaBarang(Barang barang) {
        daftarBarang.add(barang);
    }
    public void kurangiBarang(Barang barang, int jumlah) {
            if (jumlah > barang.getStok()) {
                System.out.println("Jumlah yang dikeluarkan melebihi stok.");
            } else {
                barang.kurangiStok(jumlah);
                System.out.println("Stok telah dikurangi.");
            }
    }
    public void keluarkanBarang(Barang barang) {
        daftarBarang.remove(barang);
        System.out.println("Barang dengan kode " + barang.getKodeBarang()+
                " berhenti menyewa.");
    };

    public Barang cariBarang(String kodeBarang) {
        for (Barang barang : daftarBarang) {
            if (barang.getKodeBarang().equals(kodeBarang)) {
                return barang;
            }
        }
        return null;
    }
    public void tandaTerimaBarang(Barang barang) {
        System.out.println("======== TANDA TERIMA BARANG ========");
        try {
            System.out.println(barang.getSupplier().showData());
            for (Barang cetak : daftarBarang) {
                System.out.println(cetak.infoBarang());
            }
        } catch (Exception e) {
            System.out.println("Exception " +e);
        }
    }

    public void dataInventory() {
        try {
            for (Barang supplier : daftarBarang) {
                System.out.println(supplier.getSupplier().showData());
                for (Barang barang : daftarBarang) {
                    System.out.println(barang.infoBarang());
                }
            }
        } catch (Exception e) {
            System.out.println("Exception " +e);
        }
    }
    public void dataSupplier() {
        try {
            for (Barang barang : daftarBarang) {
                Supplier supplier = barang.getSupplier();
                System.out.println(supplier.showData());
            }
        } catch (Exception e) {
            System.out.println("Exception " +e);
        }
    }
}
