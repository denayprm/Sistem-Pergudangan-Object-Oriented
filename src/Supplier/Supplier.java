package Supplier;

public class Supplier implements DataSupplier {
    private String idSupplier;
    private String namaPT;
    private String noTelp;
    private String alamat;

    public Supplier(String idSupplier, String namaPT, String noTelp, String alamat) {
        this.idSupplier = idSupplier;
        this.namaPT = namaPT;
        this.noTelp = kodeTelp + noTelp;
        this.alamat = alamat;
    }

    @Override
    public String showData() {
        return "ID Supplier: " +idSupplier+
                "Nama PT: " +namaPT+
                "No. Telepon: " +noTelp+
                "Alamat: " +alamat;
    }
}
