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
        if (barang != null) {
            if (jumlah > barang.getStok()) {
                System.out.println("Jumlah yang dikeluarkan melebihi " +
                        "stok.");
            } else {
                barang.kurangiStok(jumlah);
                System.out.println("Stok telah dikurangi.");
            }
        } else {
            System.out.println("Barang dengan kode "
                    +barang.getKodeBarang()+ " tidak ditemukan.");
        }
    }

    public void berhentiMenyimpan(Barang barang) {
        daftarBarang.remove(barang);
        System.out.println("Barang dengan kode " + barang.getKodeBarang()+
                " berhenti menyewa.");
    }

    public Barang cariBarang(String kodeBarang) {
        for (Supplier supplier : daftarBarang.keySet()) {
            List <Barang> listBarang = daftarBarang.get(supplier);
            for (Barang barang : listBarang) {
                if (barang.getKodeBarang().equals(kodeBarang))
                    return barang;
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

    public void tandaTerimaBarang(Barang barang) {
        System.out.println("======== TANDA TERIMA BARANG ========");
        try {
            tampilkanData();
        } catch (Exception e) {
            System.out.println("Exception " +e);
        }
    }
//
//
//
//
//
//
//
//    List<Barang> daftarBarang;
//    public Inventory() {
//        daftarBarang = new ArrayList<>();
//    }
//    public void terimaBarang(Barang barang) {
//        daftarBarang.add(barang);
//    }
//    public void kurangiBarang(Barang barang, int jumlah) {
//            if (jumlah > barang.getStok()) {
//                System.out.println("Jumlah yang dikeluarkan melebihi stok.");
//            } else {
//                barang.kurangiStok(jumlah);
//                System.out.println("Stok telah dikurangi.");
//            }
//    }
//    public void keluarkanBarang(Barang barang) {
//        daftarBarang.remove(barang);
//        System.out.println("Barang dengan kode " + barang.getKodeBarang()+
//                " berhenti menyewa.");
//    };
//
//    public Barang cariBarang(String kodeBarang) {
//        for (Barang barang : daftarBarang) {
//            if (barang.getKodeBarang().equals(kodeBarang)) {
//                return barang;
//            }
//        }
//        return null;
//    }
//    public void tandaTerimaBarang(Barang barang) {
//        System.out.println("======== TANDA TERIMA BARANG ========");
//        try {
//            System.out.println(barang.getSupplier().showData());
//            for (Barang cetak : daftarBarang) {
//                System.out.println(cetak.infoBarang());
//            }
//        } catch (Exception e) {
//            System.out.println("Exception " +e);
//        }
//    }
//
//    public void dataInventory() {
//        try {
//            for (Barang supplier : daftarBarang) {
//                System.out.println(supplier.getSupplier().showData());
//                for (Barang barang : daftarBarang) {
//                    System.out.println(barang.infoBarang());
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Exception " +e);
//        }
//    }
//    public void dataSupplier() {
//        try {
//            for (Barang barang : daftarBarang) {
//                Supplier supplier = barang.getSupplier();
//                System.out.println(supplier.showData());
//            }
//        } catch (Exception e) {
//            System.out.println("Exception " +e);
//        }
//    }
}
