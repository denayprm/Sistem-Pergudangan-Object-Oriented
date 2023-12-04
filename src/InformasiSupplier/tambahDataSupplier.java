package InformasiSupplier;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class tambahDataSupplier extends JFrame {

    private JPanel tambahDataSupplierPanel;
    private JTextField tfIdSupplier;
    private JTextField tfNamaPerusahaan;
    private JTextField tfAlamatPerusahaan;
    private JTextField tfNomorTelepon;
    private JRadioButton rbMakanan;
    private JRadioButton rbDokumen;
    private JRadioButton rbPakaian;
    private JRadioButton rbElektronik;
    private JTextField tfInfoPembayaran;
    private JButton tbSimpan;
    private JTextPane tpDataPreview;
    private static final String userFile = "DataSupplier.json";
    private JSONArray dataSupplier;

    public tambahDataSupplier() {
        setContentPane(tambahDataSupplierPanel);
        setTitle("Tambah Data Supplier");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        loadDataSupplier(); // Load existing data on initialization

        tfIdSupplier.addActionListener(e -> {
            // aksi untuk memasukkan data yang diisi ke array JSON dari DataSupplier.json sebagai value dengan key idSupplier
            // contoh implementasi:
            // dataSupplier.getJSONObject(0).put("idSupplier", tfIdSupplier.getText());
        });

        tfNamaPerusahaan.addActionListener(e -> {
            // aksi untuk memasukkan data yang diisi ke array JSON dari DataSupplier.json sebagai value dengan key namaSupplier
            // contoh implementasi:
            // dataSupplier.getJSONObject(0).put("namaSupplier", tfNamaPerusahaan.getText());
        });

        // Implementasi serupa untuk tfAlamatPerusahaan, tfNomorTelepon, rbMakanan, rbDokumen, rbElektronik, rbPakaian, dan tfInfoPembayaran

        tbSimpan.addActionListener(e -> {
            // aksi untuk memasukkan semua data yang dimasukkan di input di atas untuk dijadikan satu array baru JSON dari DataSupplier.json dengan format yang sama
            saveDataSupplier();
            displayDataPreview();

            // Mengosongkan nilai dari komponen inputan
            tfIdSupplier.setText("");
            tfNamaPerusahaan.setText("");
            tfAlamatPerusahaan.setText("");
            tfNomorTelepon.setText("");
            tfInfoPembayaran.setText("");

            // Menghilangkan seleksi pada RadioButton
            rbMakanan.setSelected(false);
            rbDokumen.setSelected(false);
            rbElektronik.setSelected(false);
            rbPakaian.setSelected(false);
        });


        tpDataPreview.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                // Menampilkan data preview untuk data array yang telah dimasukkan ke file DataSupplier.json terbaru
                displayDataPreview();
            }
        });
    }

    private void loadDataSupplier() {
        try {
            // Membaca file JSON dan mengubahnya menjadi JSONArray
            String content = new String(Files.readAllBytes(Paths.get(userFile)));
            dataSupplier = new JSONArray(content);
        } catch (IOException e) {
            // Jika file tidak ditemukan, inisialisasi dataSupplier dengan array kosong
            dataSupplier = new JSONArray();
        }
    }

    private void saveDataSupplier() {
        JSONObject newData = new JSONObject();
        newData.put("idSupplier", tfIdSupplier.getText());
        newData.put("namaSupplier", tfNamaPerusahaan.getText());
        newData.put("alamatSupplier", tfAlamatPerusahaan.getText());
        newData.put("noTelpSupplier", tfNomorTelepon.getText());

        if (rbMakanan.isSelected()) newData.put("jenisProduk", "Makanan");
        else if (rbDokumen.isSelected()) newData.put("jenisProduk", "Dokumen");
        else if (rbElektronik.isSelected()) newData.put("jenisProduk", "Elektronik");
        else if (rbPakaian.isSelected()) newData.put("jenisProduk", "Pakaian");

        newData.put("infoPembayaran", tfInfoPembayaran.getText());

        // Menambahkan data baru ke dalam array dataSupplier
        dataSupplier.put(newData);

        // Menyimpan array dataSupplier ke dalam file JSON
        try (FileWriter file = new FileWriter(userFile)) {
            file.write(dataSupplier.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayDataPreview() {
        // Menampilkan hanya key dan value dari data terakhir yang dimasukkan
        JSONObject lastData = dataSupplier.length() > 0 ? dataSupplier.getJSONObject(dataSupplier.length() - 1) : new JSONObject();

        StringBuilder previewText = new StringBuilder();

        previewText.append("Data Supplier Terakhir:\n");
        previewText.append(formatKeyValue("ID Supplier", lastData.optString("idSupplier", "")));
        previewText.append(formatKeyValue("Nama Supplier", lastData.optString("namaSupplier", "")));
        previewText.append(formatKeyValue("Alamat Supplier", lastData.optString("alamatSupplier", "")));
        previewText.append(formatKeyValue("No. Telepon Supplier", lastData.optString("noTelpSupplier", "")));
        previewText.append(formatKeyValue("Jenis Produk", lastData.optString("jenisProduk", "")));
        previewText.append(formatKeyValue("Info Pembayaran", lastData.optString("infoPembayaran", "")));

        // Menampilkan data preview pada JTextPane
        tpDataPreview.setText(previewText.toString());
    }

    // Metode helper untuk memformat key dan value
    private String formatKeyValue(String key, String value) {
        return String.format("%-30s: %s\n", key, value);
    }
    public static void main(String[] args) {
        new tambahDataSupplier();
    }
}
