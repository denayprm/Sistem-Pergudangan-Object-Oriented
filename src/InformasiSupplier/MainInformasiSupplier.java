package InformasiSupplier;

import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MainInformasiSupplier extends  JFrame {
    private JRadioButton rbBahanMakanan;
    private JRadioButton rbDokumen;
    private JRadioButton rbElektronik;
    private JRadioButton rbPakaian;
    private JRadioButton rbSemuanya;
    private JPanel MainInformasiSupplierPanel;
    private JTextPane tpDataSupplier1;
    private static final String userFile = "DataSupplier.json";
    private JSONArray dataSupplier;

    public MainInformasiSupplier() {
        setContentPane(MainInformasiSupplierPanel);
        setTitle("Informasi Supplier");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        rbBahanMakanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbBahanMakanan.isSelected()) {
                    updateTpDataSupplier1("Makanan");
                }
            }
        });
        rbDokumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbDokumen.isSelected()) {
                    updateTpDataSupplier1("Dokumen");
                }
            }
        });
        rbElektronik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbElektronik.isSelected()) {
                    updateTpDataSupplier1("Elektronik");
                }
            }
        });
        rbPakaian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbPakaian.isSelected()) {
                    updateTpDataSupplier1("Pakaian");
                }
            }
        });
        rbSemuanya.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbSemuanya.isSelected()) {
                    updateTpDataSupplier1("Semuanya");
                }
            }
        });
    }
    private void loadSupplierData() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(userFile)));
            dataSupplier = new JSONArray(content);
        } catch (IOException e) {
            dataSupplier = new JSONArray();
        }
    }
    private void updateTpDataSupplier1(String category) {
        loadSupplierData();
        StringBuilder dataSupplierText = new StringBuilder();

        int nomorSupplier = 1;

        for (int i = 0; i < dataSupplier.length(); i++) {
            JSONObject supplier = dataSupplier.getJSONObject(i);
            String supplierCategory = supplier.getString("jenisProduk");

            if (category.equals("Semuanya") || supplierCategory.equals(category)) {
                // Ambil data yang sesuai dan tambahkan ke StringBuilder
                dataSupplierText.append("Data Supplier\t\t: ").append(nomorSupplier).append("\n");
                dataSupplierText.append("ID Supplier\t\t: ").append(supplier.getString("idSupplier")).append("\n");
                dataSupplierText.append("Nama Supplier\t\t: ").append(supplier.getString("namaSupplier")).append("\n");
                dataSupplierText.append("Alamat Supplier\t: ").append(supplier.getString("alamatSupplier")).append("\n");
                dataSupplierText.append("No. Telepon Supplier\t: ").append(supplier.getString("noTelpSupplier")).append("\n");
                dataSupplierText.append("Jenis Produk\t\t: ").append(supplier.getString("jenisProduk")).append("\n");
                dataSupplierText.append("Info Pembayaran\t: ").append(supplier.getString("infoPembayaran")).append("\n\n");
                nomorSupplier++; // Inkrementasi penomoran
            }
        }
        tpDataSupplier1.setText(dataSupplierText.toString());
    }
    public static void main(String[] args) {
        new MainInformasiSupplier();
    }
}