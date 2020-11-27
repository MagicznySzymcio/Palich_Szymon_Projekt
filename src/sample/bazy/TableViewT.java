package sample.bazy;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.DbAccess;

import java.sql.Date;
import java.sql.SQLException;

public class TableViewT {
    private static DbAccess db_access;

    static {
        try {
            db_access = new DbAccess();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static javafx.scene.control.TableView<Klient> getTableKlient() throws SQLException {
        TableView<Klient> table = new TableView<>();
        table.setPrefHeight(700.0);
        ObservableList<Klient> data = db_access.loadKlient();

        TableColumn<Klient, Integer> id_col = new TableColumn<>("ID");
        id_col.setMinWidth(100);
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_klienta")
        );
        TableColumn<Klient, String> naz_col = new TableColumn<>("Nazwisko");
        naz_col.setMinWidth(100);
        naz_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwisko")
        );
        TableColumn<Klient, String> imie_col = new TableColumn<>("Imie");
        imie_col.setMinWidth(100);
        imie_col.setCellValueFactory(
                new PropertyValueFactory<>("imie")
        );
        TableColumn<Klient, String> firma_col = new TableColumn<>("Firma");
        firma_col.setMinWidth(100);
        firma_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwa_firmy")
        );
        TableColumn<Klient, String> miasto_col = new TableColumn<>("Miasto");
        miasto_col.setMinWidth(100);
        miasto_col.setCellValueFactory(
                new PropertyValueFactory<>("miasto")
        );
        TableColumn<Klient, String> ulica_col = new TableColumn<>("Ulica, nr domu");
        ulica_col.setMinWidth(100);
        ulica_col.setCellValueFactory(
                new PropertyValueFactory<>("ulica_nr_domu")
        );

        table.setItems(data);
        table.getColumns().addAll(id_col, naz_col, imie_col, firma_col, miasto_col, ulica_col);
        return table;
    }

    public static javafx.scene.control.TableView<Pracownik> getTablePracownik() throws SQLException {
        TableView<Pracownik> table = new TableView<>();
        table.setPrefHeight(700.0);
        ObservableList<Pracownik> data = db_access.loadPracownik();

        TableColumn<Pracownik, Integer> id_col = new TableColumn<>("ID pracownika");
        id_col.setMinWidth(100);
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_pracownika")
        );
        TableColumn<Pracownik, Integer> id_stan_col = new TableColumn<>("ID stanowiska");
        id_stan_col.setMinWidth(100);
        id_stan_col.setCellValueFactory(
                new PropertyValueFactory<>("id_stanowiska")
        );
        TableColumn<Pracownik, Integer> naz_col = new TableColumn<>("Nazwisko");
        naz_col.setMinWidth(100);
        naz_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwisko")
        );
        TableColumn<Pracownik, String> imie_col = new TableColumn<>("Imie");
        imie_col.setMinWidth(100);
        imie_col.setCellValueFactory(
                new PropertyValueFactory<>("imie")
        );
        TableColumn<Pracownik, Date> data_zatr_col = new TableColumn<>("Data zatr.");
        data_zatr_col.setMinWidth(100);
        data_zatr_col.setCellValueFactory(
                new PropertyValueFactory<>("data_zatrudnienia")
        );
        TableColumn<Pracownik, Date> data_zwol_col = new TableColumn<>("Data zwol.");
        data_zwol_col.setMinWidth(100);
        data_zwol_col.setCellValueFactory(
                new PropertyValueFactory<>("data_zwolnienia")
        );
        TableColumn<Pracownik, Float> wynagr_col = new TableColumn<>("Wynagrodzenie");
        wynagr_col.setMinWidth(100);
        wynagr_col.setCellValueFactory(
                new PropertyValueFactory<>("wynagrodzenie")
        );

        table.setItems(data);
        table.getColumns().addAll(id_col, id_stan_col, naz_col, imie_col, data_zatr_col, data_zwol_col, wynagr_col);
        return table;
    }

}
