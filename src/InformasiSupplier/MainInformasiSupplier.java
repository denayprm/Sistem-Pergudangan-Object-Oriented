package InformasiSupplier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInformasiSupplier {
    private JRadioButton rbBahanMakanan;
    private JRadioButton rbDokumen;
    private JRadioButton rbElektronik;
    private JRadioButton rbPakaian;
    private JRadioButton rbSemuanya;
    private JTable table1;

    public MainInformasiSupplier() {
        rbBahanMakanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
