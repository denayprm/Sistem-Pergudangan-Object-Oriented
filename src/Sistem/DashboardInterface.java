package Sistem;

import Warehouse.Gudang;

public interface DashboardInterface {
    void penerimaanBarang(Gudang gudang);
    void pengeluaranBarang(Gudang gudang);
    void dataBarang(Gudang gudang);
    void dataSupplier(Gudang gudang);
    void logout();
}
