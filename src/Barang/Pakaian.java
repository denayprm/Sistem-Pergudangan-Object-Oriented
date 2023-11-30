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
        this.kodeBarang = "PK" + getKodeBarang();
    }

    @Override
    public String infoBarang() {
        return "=========Data Barang=========\n" +
                "Kode Barang \t: " +getKodeBarang()+ "\n" +
                "Nama Barang \t: " +getNamaBarang()+ "\n" +
                "Stok Barang \t: " +getStok()+ "\n" +
                "Kategori Barang : " +getKategori()+ "\n" +
                "=============================";
    }
}
