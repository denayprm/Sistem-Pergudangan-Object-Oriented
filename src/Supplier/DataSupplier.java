package Supplier;

public class DataSupplier {
    protected String namaPT;
    protected String noTelp;
    protected String alamatPT;
    public DataSupplier(String namaPT, String noTelp, String alamatPT) {
        this.namaPT = namaPT;
        this.noTelp = noTelp;
        this.alamatPT = alamatPT;
    }

    public String showData() {
        return "Nama PT \t: " +namaPT+
                "No. Telp \t: " +noTelp+
                "Alamat \t\t: " +alamatPT;
    };

}
