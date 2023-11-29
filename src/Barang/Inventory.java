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
    public void kurangiBarang(String kodeBarang, int stok) {
        daftarBarang.removeIf(barang -> barang.getKodeBarang().equals(kodeBarang));
    }
    public Barang cariBarang(String kodeBarang) {
        for (Barang barang : daftarBarang) {
            if (barang.getKodeBarang().equals(kodeBarang)) {
                return barang;
            }
        }
        return null;
    }
    public void tandaTerimaBarang() {
        for (Barang barang : daftarBarang) {
            barang.infoBarang();
        }
    }
}
