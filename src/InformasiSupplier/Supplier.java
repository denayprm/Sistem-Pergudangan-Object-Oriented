package InformasiSupplier;

public class Supplier {
    private int idSupplier;
    private String namaSupplier;
    private String alamatSupplier;
    private String noTelpSupplier;
    private String jenisProduk;
    private String infoPembayaran;
    public Supplier(int idSupplier, String namaSupplier, String alamatSupplier,
                    String noTelpSupplier, String jenisProduk, String infoPembayaran) {
        this.idSupplier = idSupplier;
        this.namaSupplier = namaSupplier;
        this.alamatSupplier = alamatSupplier;
        this.noTelpSupplier = noTelpSupplier;
        this.jenisProduk = jenisProduk;
        this.infoPembayaran = infoPembayaran;
    }

    public int getIdSupplier() {return idSupplier;}
    public String getNamaSupplier() {return namaSupplier;}
    public String getAlamatSupplier() {return alamatSupplier;}
    public String getNoTelpSupplier() {return noTelpSupplier;}
    public String getJenisProduk() {return jenisProduk;}
    public String getInfoPembayaran() {return infoPembayaran;}
}
