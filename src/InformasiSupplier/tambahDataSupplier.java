package InformasiSupplier;

import org.json.JSONArray;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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

    public tambahDataSupplier(){
        setContentPane(tambahDataSupplierPanel);
        setTitle("Tambah Data Supplier");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        tfIdSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tfNamaPerusahaan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tfAlamatPerusahaan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tfNomorTelepon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rbMakanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rbDokumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rbElektronik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        rbPakaian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tfInfoPembayaran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tbSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        tpDataPreview.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
            }

            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
            }
        });
    }
    public static void main(String[] args) {
        new tambahDataSupplier();
    }
}

