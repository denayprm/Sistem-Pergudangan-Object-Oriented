package Barang;

public class Dokumen extends Barang {
    private String kategori;
    public Dokumen(String kodeBarang, String namaBarang, int stok) {
        super(kodeBarang, namaBarang, stok);
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
    public void infoBarang() {
        System.out.println("Kode Barang : " +getKodeBarang()+
                "Nama Barang : " +getNamaBarang()+
                "Stok Barang : " +getStok()+
                "Kategori Barang : " +getKategori());
    }
}
