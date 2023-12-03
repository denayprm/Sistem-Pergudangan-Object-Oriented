package InformasiSupplier;


public class DataSuplier extends Supplier {
    private String alamatSupplier;
    private String noTelpSupplier;
    private String jenisProduk;
    private String infoPembayaran;
    public DataSuplier(int idSupplier, String namaSupplier, String alamatSupplier,
                    String noTelpSupplier, String jenisProduk, String infoPembayaran) {
        super(idSupplier,namaSupplier);
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
