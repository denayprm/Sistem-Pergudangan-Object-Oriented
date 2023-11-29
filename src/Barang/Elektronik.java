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
