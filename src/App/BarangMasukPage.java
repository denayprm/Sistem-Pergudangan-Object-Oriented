package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarangMasukPage extends JFrame {
    private JPanel barangMasukPanel;
    private JLabel logo;
    private JButton berandaNav;
    private JButton barangMasukNav;
    private JButton barangKeluarNav;
    private JButton dataBarangNav;
    private JButton informasiSupplierNav;
    private JButton logoutButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JRadioButton pakaianRadioButton;
    private JRadioButton elektronikRadioButton;
    private JRadioButton bahanMakananRadioButton;
    private JRadioButton dokumenRadioButton;
    private JButton SAVEButton;
    private JButton CANCELButton;

    public BarangMasukPage() {
        setContentPane(barangMasukPanel);
        setTitle("IndoGudang.com/barang-masuk");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        berandaNav.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                SwingUtilities.getWindowAncestor(barangMasukPanel).dispose();
            }
        });
    }
    private void createUIComponents() {
        ImageIcon imageLogo = new ImageIcon("logo-indogudang.png");
        Image setLogo = imageLogo.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        logo = new JLabel(new ImageIcon(setLogo));
    }
}
