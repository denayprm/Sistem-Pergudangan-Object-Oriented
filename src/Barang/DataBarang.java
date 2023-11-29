package Barang;

import java.util.ArrayList;
import java.util.List;

public class DataBarang{
    List<Barang> daftarBarang;
    public DataBarang() {
        daftarBarang = new ArrayList<>();
    }
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }
    public void kurangiBarang(String kodeBarang) {
        daftarBarang.removeIf(barang -> barang.getKodeBarang().equals(kodeBarang));
    }
    public Barang cariBarang(String kodeBarang) {
        for (Barang barang : daftarBarang) {
            if (barang.getKodeBarang().equals(kodeBarang)) {
                return barang;
            }
        }
        return null;
    }
    public void tampilkanDaftarBarang() {
        for (Barang barang : daftarBarang) {
            System.out.println(barang);
        }
    }
}
