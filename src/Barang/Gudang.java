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

    public void keluarkanBarang(Barang barang) {
        barang = cariBarang(barang.getKodeBarang());
        if (barang != null) {
            Inventory inventory = dataInventory.get(kodeGudang);
            inventory.berhentiMenyimpan(barang.getKodeBarang());
            dataInventory.remove(kodeGudang);
        } else {
            System.out.println("Ga ketemu");
        }


//        if (inventory != null) {
//            Barang barang = inventory.cariBarang(kodeBarang);
//            if (barang != null) {
//                inventory.berhentiMenyimpan(kodeBarang);
//                System.out.println("Barang dengan kode " + kodeBarang + " berhasil dikeluarkan dari gudang.");
//            } else {
//                System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan di inventory gudang.");
//            }
//        } else {
//            System.out.println("Gudang tidak ditemukan.");
//        }
    }

    public Barang cariBarang(String kodeBarang) {
        for (String kodeGudang : dataInventory.keySet()) {
            Inventory inventory = dataInventory.get(kodeGudang);
            Barang barang = inventory.cariBarang(kodeBarang);
            if (barang != null) {
                return barang;
            }
        }
        return null;
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
