package InformasiSupplier;

public class SupplierData {
    private String id_supplier;
    private String nama_supplier;
    private String alamat_supplier;
    private String no_telp_supplier;
    private String jenis_produk;
    private String info_pembayaran;

    public SupplierData(String id_supplier, String nama_supplier, String alamat_supplier, String no_telp_supplier, String jenis_produk, String info_pembayaran) {
        this.id_supplier = id_supplier;
        this.nama_supplier = nama_supplier;
        this.alamat_supplier = alamat_supplier;
        this.no_telp_supplier = no_telp_supplier;
        this.jenis_produk = jenis_produk;
        this.info_pembayaran = info_pembayaran;
    }
}


