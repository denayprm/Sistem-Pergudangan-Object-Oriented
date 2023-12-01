package Barang;

import java.util.HashMap;
import java.util.Map;
import Supplier.*;

public class Gudang {
    private Map<String, Inventory> dataInventory;
    private String kodeGudang;
    private boolean status;

    public Gudang() {
        dataInventory = new HashMap<>();
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
        dataInventory.put(getKodeGudang(), inventory);
        status = true;
    }
    public void keluarkanBarang(Inventory inventory) {
        dataInventory.remove(inventory);
    }
    public void dataBarang() {
        for (String kodeGudang : dataInventory.keySet()) {
            System.out.println("\nKode Gudang : " +kodeGudang);
            Inventory inventory = dataInventory.get(kodeGudang);
            inventory.dataInventory();
        }
    }
    public void dataSupplier() {
        for (String kodeGudang : dataInventory.keySet()) {
            Inventory inventory = dataInventory.get(kodeGudang);
            inventory.dataSupplier();
        }
    }
}
