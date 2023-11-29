package Barang;

import Supplier.Supplier;

import java.util.HashMap;
import java.util.Map;

public class Gudang {
    private Map<String, Inventory> dataBarang;
    private String kodeGudang;

    public Gudang() {
        dataBarang = new HashMap<>();
        this.kodeGudang = "AREA" + kodeGudang;
    }

    public String getKodeGudang() {
        return kodeGudang;
    }

    public void simpanBarang(String kodeGudang, Inventory inventory) {

        dataBarang.put(kodeGudang, inventory);
    }
    public void keluarkanBarang(String kodeBarang, Inventory inventory) {
        dataBarang.remove(kodeBarang, inventory);
    }
    public void tampilkanDaftarBarang() {
        System.out.println(dataBarang);
    }
}
