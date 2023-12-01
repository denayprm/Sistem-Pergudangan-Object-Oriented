package Barang;

import java.util.HashMap;
import java.util.Map;
import Supplier.*;

public class Gudang {
    private Map<String, Inventory> dataInventory;
    private String kodeGudang;

    public Gudang() {
        this.dataInventory = new HashMap<>();
    }

    public void setKodeGudang(String kodeGudang) {
        this.kodeGudang = "AREA" + kodeGudang;
    }
    public String getKodeGudang() {
        return kodeGudang;
    }


    public void simpanBarang(Inventory inventory) {
        dataInventory.put(getKodeGudang(), inventory);
    }
    public void keluarkanBarang(Inventory inventory) {
        dataInventory.remove(inventory);
    }
    public void dataBarang() {
        for (String kodeGudang : dataInventory.keySet()) {
            System.out.println("\nKode Gudang : " +kodeGudang);
            Inventory inventory = dataInventory.get(kodeGudang);
            inventory.tampilkanData();
        }
    }
    public void dataSupplier() {
        for (String kodeGudang : dataInventory.keySet()) {
            Inventory inventory = dataInventory.get(kodeGudang);
            inventory.dataSupplier();
        }
    }
}
