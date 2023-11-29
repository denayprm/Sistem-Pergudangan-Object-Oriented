package Supplier;

public class Supplier implements DataSupplier {
    private String idSupplier;
    private String namaPT;
    private String noTelp;
    private String alamat;

    public Supplier(String idSupplier, String namaPT, String noTelp, String alamat) {
        this.idSupplier = "SP" + idSupplier;
        this.namaPT = namaPT;
        this.noTelp = kodeTelp + noTelp;
        this.alamat = alamat;
    }

    @Override
    public String showData() {
        return "=========Data Supplier=======\n" +
                "ID Supplier : " +idSupplier+ "\n" +
                "Nama PT \t: " +namaPT+ "\n" +
                "No. Telepon : " +noTelp+ "\n" +
                "Alamat \t\t: " +alamat+ "\n" +
                "=============================";
    }
}
