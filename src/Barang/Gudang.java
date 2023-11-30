package Barang;

import Supplier.Supplier;

import java.util.HashMap;
import java.util.Map;

public class Gudang {
    private Map<String, Inventory> dataBarang;
    private String kodeGudang;
    private boolean status;

    public Gudang() {
        dataBarang = new HashMap<>();
        this.status = false;
    }

    public void setKodeGudang(String kodeGudang) {
        this.kodeGudang = "AREA" + kodeGudang;
    }
    public String getKodeGudang() {
        return kodeGudang;
    }

    public boolean isStatus() {
        return status;
    }

    public void simpanBarang(Inventory inventory) {
        dataBarang.put(getKodeGudang(), inventory);
        status = true;
    }
    public void keluarkanBarang(Inventory inventory) {
        dataBarang.remove(inventory);
    }
    public void tampilkanDaftarBarang() {
        System.out.println(dataBarang);
    }
}
