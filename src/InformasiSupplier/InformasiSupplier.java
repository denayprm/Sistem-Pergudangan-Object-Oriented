package InformasiSupplier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformasiSupplier extends JFrame {
    private JButton tbDataSupplier;
    private JButton tbTambahSupplier;
    private JPanel informasiSupplierPanel;

    public InformasiSupplier() {
        setContentPane(informasiSupplierPanel);
        setTitle("Menu Informasi Supplier");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        tbDataSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> new MainInformasiSupplier());
            }
        });
        tbTambahSupplier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> new tambahDataSupplier());
            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InformasiSupplier());
    }
}
