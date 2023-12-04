package InformasiSupplier;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
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
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        prosesDataSupplier();

        tbSimpan.addActionListener(e -> {
            simpanDataSupplier();
            tampilDataPreview();

            tfIdSupplier.setText("");
            tfNamaPerusahaan.setText("");
            tfAlamatPerusahaan.setText("");
            tfNomorTelepon.setText("");
            tfInfoPembayaran.setText("");

            rbMakanan.setSelected(false);
            rbDokumen.setSelected(false);
            rbElektronik.setSelected(false);
            rbPakaian.setSelected(false);
        });

        tpDataPreview.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                tampilDataPreview();
            }
        });
    }

    private void prosesDataSupplier() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(userFile)));
            dataSupplier = new JSONArray(content);
        } catch (IOException e) {
            dataSupplier = new JSONArray();
        }
    }

    private void simpanDataSupplier() {
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

        dataSupplier.put(newData);

        try (FileWriter file = new FileWriter(userFile)) {
            file.write(dataSupplier.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void tampilDataPreview() {
        JSONObject lastData = dataSupplier.length() > 0 ? dataSupplier.getJSONObject(dataSupplier.length() - 1) : new JSONObject();

        StringBuilder previewText = new StringBuilder();

        previewText.append("Data Supplier Terakhir:\n");
        previewText.append(formatKeyValue("ID Supplier", lastData.optString("idSupplier", "")));
        previewText.append(formatKeyValue("Nama Supplier", lastData.optString("namaSupplier", "")));
        previewText.append(formatKeyValue("Alamat Supplier", lastData.optString("alamatSupplier", "")));
        previewText.append(formatKeyValue("No. Telepon Supplier", lastData.optString("noTelpSupplier", "")));
        previewText.append(formatKeyValue("Jenis Produk", lastData.optString("jenisProduk", "")));
        previewText.append(formatKeyValue("Info Pembayaran", lastData.optString("infoPembayaran", "")));

        tpDataPreview.setText(previewText.toString());
    }

    private String formatKeyValue(String key, String value) {
        return String.format("%-15s : %s\n", key, value);
    }
    public static void main(String[] args) {
        new tambahDataSupplier();
    }
}
