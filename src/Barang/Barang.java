package Barang;

import Supplier.Supplier;

public abstract class Barang {
    protected String kodeBarang;
    private String namaBarang;
    protected int stok;
    private Supplier supplier;

    public Barang(String kodeBarang, String namaBarang, int stok, Supplier supplier) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.supplier = supplier;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getStok() {
        return stok;
    }

    public Supplier getSupplier() { return supplier; }

    public abstract void uniqueCode();

    public abstract String infoBarang();
}
