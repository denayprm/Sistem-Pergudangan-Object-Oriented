package InformasiSupplier;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainInformasiSupplier {
    private JRadioButton rbBahanMakanan;
    private JRadioButton rbDokumen;
    private JRadioButton rbElektronik;
    private JRadioButton rbPakaian;
    private JRadioButton rbSemuanya;
    private JComboBox comboBox1;
    private JTable table2;
    private JTable table1;


    public MainInformasiSupplier() {
        rbBahanMakanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rbBahanMakanan.isSelected()) {

                } else {

                }
            }
        });
    }
}
