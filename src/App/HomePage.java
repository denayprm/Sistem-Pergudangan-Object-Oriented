package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePage extends JFrame {
    private JPanel HomePanel;
    private JLabel logo;
    private JButton berandaNav;
    private JButton barangMasukButton;
    private JButton barangKeluarButton;
    private JButton dataBarangButton;
    private JButton infoSupplierButton;
    private JButton barangMasukNav;
    private JButton barangKeluarNav;
    private JButton dataBarangNav;
    private JButton informasiSupplierNav;
    private JButton logoutButton;
    private JPanel barangMasukPanel;

    public HomePage() {
        setContentPane(HomePanel);
        setTitle("IndoGudang.com");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        barangMasukButton.setBorderPainted(false);

        barangMasukButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                barangMasukButton.setContentAreaFilled(true); // Menandakan bahwa area konten harus diisi
                barangMasukButton.setBackground(Color.LIGHT_GRAY); // Warna latar belakang ketika mouse masuk
            }

            @Override
            public void mouseExited(MouseEvent e) {
                barangMasukButton.setContentAreaFilled(false); // Menandakan bahwa area konten tidak perlu diisi
            }
        });

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BarangMasukPage barangMasuk = new BarangMasukPage();
                SwingUtilities.getWindowAncestor(HomePanel).dispose();
            }
        };
        barangMasukNav.addActionListener(listener);
        barangMasukButton.addActionListener(listener);
    }

    private void createUIComponents() {
        ImageIcon imageLogo = new ImageIcon("logo-indogudang.png");
        Image setLogo = imageLogo.getImage().getScaledInstance(100, 50, Image.SCALE_DEFAULT);
        logo = new JLabel(new ImageIcon(setLogo));
    }
}

