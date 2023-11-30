package Barang;

import Supplier.Supplier;

public class BahanMakanan extends Barang {
    private String kategori;

    public BahanMakanan(String kodeBarang, String namaBarang, int stok, Supplier supplier) {
        super(kodeBarang, namaBarang, stok, supplier);
        this.kategori = "Bahan Makanan";
        uniqueCode();
    }

    public String getKategori() {
        return kategori;
    }

    @Override
    public void uniqueCode() {
        this.kodeBarang = "BM" + getKodeBarang();
    }

    @Override
    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
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