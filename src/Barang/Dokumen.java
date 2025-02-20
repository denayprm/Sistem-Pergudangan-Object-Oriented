package Barang;

import Supplier.Supplier;

public class Dokumen extends Barang {
    private String kategori;

    public Dokumen(String kodeBarang, String namaBarang, int stok, Supplier supplier) {
        super(kodeBarang, namaBarang, stok, supplier);
        this.kategori = "Elektronik";
        uniqueCode();
    }

    public String getKategori() {
        return kategori;
    }

    @Override
    public void uniqueCode() {
        kodeBarang = "DK" + getKodeBarang();
    }

    @Override
    public String infoBarang() {
        return "=========Data Barang=========\n" +
                "Kode Barang \t: " +getKodeBarang()+ "\n" +
                "Nama Barang \t: " +getNamaBarang()+ "\n" +
                "Stok Barang \t: " +getStok()+ "\n" +
                "Kategori Barang : " +getKategori()+ "\n" +
                "=============================\n" +
                getSupplier().showData();
    }
}
