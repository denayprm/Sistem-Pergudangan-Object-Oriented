package Barang;

import Supplier.Supplier;

public class Pakaian extends Barang {
    private String kategori;

    public Pakaian(String kodeBarang, String namaBarang, int stok, Supplier supplier) {
        super(kodeBarang, namaBarang, stok, supplier);
        this.kategori = "Pakaian";
        uniqueCode();
    }

    public String getKategori() {
        return kategori;
    }

    @Override
    public void uniqueCode() {
        kodeBarang = "PK" + getKodeBarang();
    }

    @Override
    public void infoBarang() {
        System.out.println("Kode Barang : " +getKodeBarang()+
                "Nama Barang : " +getNamaBarang()+
                "Stok Barang : " +getStok()+
                "Kategori Barang : " +getKategori());
    }
}
