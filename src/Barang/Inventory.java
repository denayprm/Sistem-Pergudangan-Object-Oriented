package Barang;

import Supplier.Supplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<Supplier, List<Barang>> daftarBarang;

    public Inventory() {
        this.daftarBarang = new HashMap<>();
    }

    public void terimaBarang(Supplier supplier, Barang barang) {
        if (daftarBarang.containsKey(supplier)) {
            List<Barang> listBarang = daftarBarang.get(supplier);
            listBarang.add(barang);
        } else {
            List<Barang> listBarang = new ArrayList<>();
            listBarang.add(barang);
            daftarBarang.put(supplier, listBarang);
        }
    }

    public void kurangiBarang(Barang barang, int jumlah) {
        if (jumlah > barang.getStok()) {
            System.out.println("Jumlah yang dikeluarkan melebihi stok.");
        } else {
            barang.kurangiStok(jumlah);
            System.out.println("Stok barang berhasil dikurangi sebanyak " + jumlah);
        }
    }

    public void berhentiMenyimpan(String kodeBarang) {
        Barang barang = cariBarang(kodeBarang);
        if (barang != null) {
            for (Supplier supplier : daftarBarang.keySet()) {
                List<Barang> listBarang = daftarBarang.get(supplier);
                if (listBarang.remove(barang)) {
                    System.out.println("Barang dengan kode " + barang.getKodeBarang() +
                            " berhenti menyimpan.");
                    if (listBarang.isEmpty()) {
                        daftarBarang.remove(supplier);
                        System.out.println("Supplier berhenti menyimpan barang");
                    }
                    return;
                }
            }
            System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan.");
        } else {
            System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan.");
        }
    }

    public Barang cariBarang(String kodeBarang) {
        for (List<Barang> listBarang : daftarBarang.values()) {
            for (Barang barang : listBarang) {
                if (barang.getKodeBarang().equals(kodeBarang)) {
                    return barang;
                }
            }
        }
        return null;
    }

    public void dataSupplier() {
        for (Supplier supplier : daftarBarang.keySet()) {
            System.out.println(supplier.showData());
        }
    }
    public void tampilkanData() {
        try {
            for (Supplier supplier : daftarBarang.keySet()) {
                System.out.println(supplier.showData());
                List<Barang> listBarang = daftarBarang.get(supplier);
                for (Barang barang : listBarang) {
                    System.out.println(barang.infoBarang());
                }
            }
        } catch (Exception e) {
            System.out.println("Exception " +e);
        }
    }
}
