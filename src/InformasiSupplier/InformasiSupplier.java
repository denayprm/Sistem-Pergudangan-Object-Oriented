package InformasiSupplier;

import java.util.Scanner;
public class InformasiSupplier {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            // Minta input dari pengguna
            System.out.print("Masukkan ID Supplier: ");
            int idSupplier = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline di buffer

            System.out.print("Masukkan Nama Supplier: ");
            String namaSupplier = scanner.nextLine();

            System.out.print("Masukkan Alamat Supplier: ");
            String alamatSupplier = scanner.nextLine();

            System.out.print("Masukkan Nomor Telepon Supplier: ");
            String noTelpSupplier = scanner.nextLine();

            System.out.print("Masukkan Jenis Produk: ");
            String jenisProduk = scanner.nextLine();

            System.out.print("Masukkan Informasi Pembayaran: ");
            String infoPembayaran = scanner.nextLine();

            // Buat objek DataSuplier dengan input pengguna
            DataSuplier supplier = new DataSuplier(idSupplier, namaSupplier, alamatSupplier,
                    noTelpSupplier, jenisProduk, infoPembayaran);

            // Tampilkan informasi supplier
            System.out.println("\nInformasi Supplier:");
            System.out.println("ID Supplier: " + supplier.getIdSupplier());
            System.out.println("Nama Supplier: " + supplier.getNamaSupplier());
            System.out.println("Alamat Supplier: " + supplier.getAlamatSupplier());
            System.out.println("Nomor Telepon Supplier: " + supplier.getNoTelpSupplier());
            System.out.println("Jenis Produk: " + supplier.getJenisProduk());
            System.out.println("Informasi Pembayaran: " + supplier.getInfoPembayaran());

            // Tutup scanner
            scanner.close();
    }
}
