package Barang;

import Supplier.Supplier;

public class Elektronik extends Barang {
    private String kategori;

    public Elektronik(String kodeBarang, String namaBarang, int stok, Supplier supplier) {
        super(kodeBarang, namaBarang, stok, supplier);
        this.kategori = "Elektronik";
        uniqueCode();
    }

    public String getKategori() {
        return kategori;
    }

    @Override
    public void uniqueCode() {
        kodeBarang = "EL" + getKodeBarang();
    }

    @Override
    public void infoBarang() {
        System.out.println("Kode Barang : " +getKodeBarang()+
                "Nama Barang : " +getNamaBarang()+
                "Stok Barang : " +getStok()+
                "Kategori Barang : " +getKategori());
    }
}
