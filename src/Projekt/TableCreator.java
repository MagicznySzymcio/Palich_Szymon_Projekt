package Projekt;

import Projekt.bazy.*;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.sql.Date;
import java.sql.SQLException;

public class TableCreator {

    public static javafx.scene.control.TableView<Klient> getTableKlient() throws SQLException {
        javafx.scene.control.TableView<Klient> table = new javafx.scene.control.TableView<>();
        table.setPrefHeight(700.0);
        ObservableList<Klient> data = Main.DbInstance.loadKlient();

        TableColumn<Klient, Integer> id_col = new TableColumn<>("ID");
        id_col.setResizable(false);
        id_col.setPrefWidth(50);
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_klienta")
        );
        TableColumn<Klient, String> naz_col = new TableColumn<>("Nazwisko");
        naz_col.setResizable(false);
        naz_col.setPrefWidth(400);
        naz_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwisko")
        );
        TableColumn<Klient, String> imie_col = new TableColumn<>("Imię");
        imie_col.setResizable(false);
        imie_col.setPrefWidth(150);
        imie_col.setCellValueFactory(
                new PropertyValueFactory<>("imie")
        );
        TableColumn<Klient, String> firma_col = new TableColumn<>("Firma");
        firma_col.setResizable(false);
        firma_col.setPrefWidth(100);
        firma_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwa_firmy")
        );
        TableColumn<Klient, String> miasto_col = new TableColumn<>("Miasto");
        miasto_col.setResizable(false);
        miasto_col.setPrefWidth(150);
        miasto_col.setCellValueFactory(
                new PropertyValueFactory<>("miasto")
        );
        TableColumn<Klient, String> ulica_col = new TableColumn<>("Ulica, nr domu");
        ulica_col.setResizable(false);
        ulica_col.setPrefWidth(100);
        ulica_col.setCellValueFactory(
                new PropertyValueFactory<>("ulica_nr_domu")
        );
        TableColumn<Klient, Button> edit_col = new TableColumn<>("Edytuj");
        edit_col.setResizable(false);
        edit_col.setPrefWidth(49);
        edit_col.setCellValueFactory(
                new PropertyValueFactory<>("edit")
        );
        TableColumn<Klient, Button> del_col = new TableColumn<>("Usuń");
        del_col.setResizable(false);
        del_col.setPrefWidth(49);
        del_col.setCellValueFactory(
                new PropertyValueFactory<>("delete")
        );

        table.setItems(data);
        table.getColumns().addAll(id_col, naz_col, imie_col, firma_col, miasto_col, ulica_col, edit_col, del_col);
        return table;
    }

    public static javafx.scene.control.TableView<Pracownik> getTablePracownik() throws SQLException {
        ObservableList<Pracownik> data = Main.DbInstance.loadPracownik();
        ObservableList<Stanowisko> data2 = Main.DbInstance.loadStanowisko();
        for (Pracownik pracownik: data) {
            for (Stanowisko stanowisko: data2) {
                if (pracownik.getId_stanowiska() == stanowisko.getId_stanowiska()) {
                    pracownik.setTemp_stanowisko(stanowisko.getNazwa());
                }
            }
        }
        javafx.scene.control.TableView<Pracownik> table = new javafx.scene.control.TableView<>();
        table.setPrefHeight(700.0);

        TableColumn<Pracownik, Integer> id_col = new TableColumn<>("ID");
        id_col.setResizable(false);
        id_col.setPrefWidth(50);
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_pracownika")
        );
        TableColumn<Pracownik, String> id_stan_col = new TableColumn<>("Stanowisko");
        id_stan_col.setResizable(false);
        id_stan_col.setPrefWidth(100);
        id_stan_col.setCellValueFactory(
                new PropertyValueFactory<>("temp_stanowisko")
        );
        TableColumn<Pracownik, Integer> naz_col = new TableColumn<>("Nazwisko");
        naz_col.setResizable(false);
        naz_col.setPrefWidth(200);
        naz_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwisko")
        );
        TableColumn<Pracownik, String> imie_col = new TableColumn<>("Imię");
        imie_col.setResizable(false);
        imie_col.setPrefWidth(200);
        imie_col.setCellValueFactory(
                new PropertyValueFactory<>("imie")
        );
        TableColumn<Pracownik, Date> data_zatr_col = new TableColumn<>("Data zatrudnienia");
        data_zatr_col.setResizable(false);
        data_zatr_col.setPrefWidth(150);
        data_zatr_col.setCellValueFactory(
                new PropertyValueFactory<>("data_zatrudnienia")
        );
        TableColumn<Pracownik, Date> data_zwol_col = new TableColumn<>("Data zwolnienia");
        data_zwol_col.setResizable(false);
        data_zwol_col.setPrefWidth(125);
        data_zwol_col.setCellValueFactory(
                new PropertyValueFactory<>("data_zwolnienia")
        );
        TableColumn<Pracownik, Float> wynagr_col = new TableColumn<>("Wynagrodzenie");
        wynagr_col.setResizable(false);
        wynagr_col.setPrefWidth(125);
        wynagr_col.setCellValueFactory(
                new PropertyValueFactory<>("wynagrodzenie")
        );
        TableColumn<Pracownik, Button> edit_col = new TableColumn<>("Edytuj");
        edit_col.setResizable(false);
        edit_col.setPrefWidth(49);
        edit_col.setCellValueFactory(
                new PropertyValueFactory<>("edit")
        );
        TableColumn<Pracownik, Button> del_col = new TableColumn<>("Usuń");
        del_col.setResizable(false);
        del_col.setPrefWidth(49);
        del_col.setCellValueFactory(
                new PropertyValueFactory<>("delete")
        );

        table.setItems(data);
        table.getColumns().addAll(id_col, id_stan_col, naz_col, imie_col, data_zatr_col, data_zwol_col, wynagr_col, edit_col, del_col);

        return table;
    }

    public static javafx.scene.control.TableView<Stanowisko> getTableStanowisko() throws SQLException {
        javafx.scene.control.TableView<Stanowisko> table = new javafx.scene.control.TableView<>();
        table.setPrefHeight(700.0);
        ObservableList<Stanowisko> data = Main.DbInstance.loadStanowisko();

        TableColumn<Stanowisko, Integer> id_col = new TableColumn<>("ID");
        id_col.setResizable(false);
        id_col.setPrefWidth(50);
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_stanowiska")
        );
        TableColumn<Stanowisko, String> naz_col = new TableColumn<>("Nazwa stanowiska");
        naz_col.setResizable(false);
        naz_col.setPrefWidth(900);
        naz_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwa")
        );
        TableColumn<Stanowisko, Button> edit_col = new TableColumn<>("Edytuj");
        edit_col.setResizable(false);
        edit_col.setPrefWidth(49);
        edit_col.setCellValueFactory(
                new PropertyValueFactory<>("edit")
        );
        TableColumn<Stanowisko, Button> del_col = new TableColumn<>("Usuń");
        del_col.setResizable(false);
        del_col.setPrefWidth(49);
        del_col.setCellValueFactory(
                new PropertyValueFactory<>("delete")
        );

        table.setItems(data);
        table.getColumns().addAll(id_col, naz_col, edit_col, del_col);
        return table;
    }

    public static javafx.scene.control.TableView<Usluga> getTableUsluga() throws SQLException {
        javafx.scene.control.TableView<Usluga> table = new javafx.scene.control.TableView<>();
        table.setPrefHeight(700.0);
        ObservableList<Usluga> data = Main.DbInstance.loadUsluga();

        TableColumn<Usluga, Integer> id_col = new TableColumn<>("ID");
        id_col.setResizable(false);
        id_col.setPrefWidth(50);
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_uslugi")
        );
        TableColumn<Usluga, String> naz_col = new TableColumn<>("Nazwa usługi");
        naz_col.setResizable(false);
        naz_col.setPrefWidth(800);
        naz_col.setCellValueFactory(
                new PropertyValueFactory<>("nazwa")
        );
        TableColumn<Usluga, Float> cena_col = new TableColumn<>("Cena");
        cena_col.setResizable(false);
        cena_col.setPrefWidth(100);
        cena_col.setCellValueFactory(
                new PropertyValueFactory<>("cena")
        );
        TableColumn<Usluga, Button> edit_col = new TableColumn<>("Edytuj");
        edit_col.setResizable(false);
        edit_col.setPrefWidth(49);
        edit_col.setCellValueFactory(
                new PropertyValueFactory<>("edit")
        );
        TableColumn<Usluga, Button> del_col = new TableColumn<>("Usuń");
        del_col.setResizable(false);
        del_col.setPrefWidth(49);
        del_col.setCellValueFactory(
                new PropertyValueFactory<>("delete")
        );

        table.setItems(data);
        table.getColumns().addAll(id_col, naz_col, cena_col, edit_col, del_col);
        return table;
    }

    public static javafx.scene.control.TableView<Zamowienie> getTableZamowienie(boolean show_all) throws SQLException {
        ObservableList<Zamowienie> data = Main.DbInstance.loadZamowienie();
        ObservableList<Klient> data_klient = Main.DbInstance.loadKlient();
        ObservableList<Pracownik> data_pracownik = Main.DbInstance.loadPracownik();
        ObservableList<Usluga> data_usluga = Main.DbInstance.loadUsluga();

        for (Zamowienie zamowienie: data) {
            for (Klient klient: data_klient) {
                if (zamowienie.getId_klienta() == klient.getId_klienta()) {
                    zamowienie.setTemp_klient(klient.getNazwisko() + " " + klient.getImie());
                }
            }
        }

        for (Zamowienie zamowienie: data) {
            for (Pracownik pracownik: data_pracownik) {
                if (zamowienie.getId_pracownika() == pracownik.getId_pracownika()) {
                    zamowienie.setTemp_pracownik(pracownik.getNazwisko() + " " + pracownik.getImie());
                }
            }
        }

        for (Zamowienie zamowienie: data) {
            for (Usluga usluga: data_usluga) {
                if (zamowienie.getId_uslugi() == usluga.getId_uslugi()) {
                    zamowienie.setTemp_usluga(usluga.getNazwa());
                }
            }
        }



        javafx.scene.control.TableView<Zamowienie> table = new javafx.scene.control.TableView<>();
        table.setPrefHeight(700.0);

        if (!show_all) {
            data.removeIf(zam -> zam.getZrealizowano() == 1);
        }

        TableColumn<Zamowienie, Integer> id_col = new TableColumn<>("ID");
        id_col.setResizable(false);
        id_col.setPrefWidth(50);
        id_col.setCellValueFactory(
                new PropertyValueFactory<>("id_zamowienia")
        );
        TableColumn<Zamowienie, String> id_kl_col = new TableColumn<>("Klient");
        id_kl_col.setResizable(false);
        id_kl_col.setPrefWidth(267);
        id_kl_col.setCellValueFactory(
                new PropertyValueFactory<>("temp_klient")
        );
        id_kl_col.setCellFactory
                (
                        column ->
                                new TableCell<>() {
                                    @Override
                                    protected void updateItem(String item, boolean empty) {
                                        super.updateItem(item, empty);
                                        setText(item);
                                        for (Klient klient: data_klient) {
                                            if ((klient.getNazwisko() + " " + klient.getImie()).equals(this.getText())) {
                                                setTooltip(new Tooltip(klient.toString()));
                                            }
                                        }
                                    }
                                });
        TableColumn<Zamowienie, String> id_prac_col = new TableColumn<>("Pracownik");
        id_prac_col.setResizable(false);
        id_prac_col.setPrefWidth(135);
        id_prac_col.setCellValueFactory(
                new PropertyValueFactory<>("temp_pracownik")
        );
        id_prac_col.setCellFactory
                (
                        column ->
                                new TableCell<>() {
                                    @Override
                                    protected void updateItem(String item, boolean empty) {
                                        super.updateItem(item, empty);
                                        setText(item);
                                        for (Pracownik pracownik: data_pracownik) {
                                            if ((pracownik.getNazwisko() + " " + pracownik.getImie()).equals(this.getText())) {
                                                setTooltip(new Tooltip(pracownik.toString()));
                                            }
                                        }
                                    }
                                });
        TableColumn<Zamowienie, String> id_usl_col = new TableColumn<>("Usługa");
        id_usl_col.setResizable(false);
        id_usl_col.setPrefWidth(136);
        id_usl_col.setCellValueFactory(
                new PropertyValueFactory<>("temp_usluga")
        );
        id_usl_col.setCellFactory
                (
                        column ->
                                new TableCell<>() {
                                    @Override
                                    protected void updateItem(String item, boolean empty) {
                                        super.updateItem(item, empty);
                                        setText(item);
                                        for (Usluga usluga: data_usluga) {
                                            if (usluga.getNazwa().equals(this.getText())) {
                                                setTooltip(new Tooltip(usluga.toString()));
                                            }
                                        }
                                    }
                                });
        TableColumn<Zamowienie, Date> data_zam_col = new TableColumn<>("Data zamówienia");
        data_zam_col.setResizable(false);
        data_zam_col.setPrefWidth(136);
        data_zam_col.setCellValueFactory(
                new PropertyValueFactory<>("data_zamowienia")
        );
        TableColumn<Zamowienie, Date> data_real_col = new TableColumn<>("Data realizacji");
        data_real_col.setResizable(false);
        data_real_col.setPrefWidth(136);
        data_real_col.setCellValueFactory(
                new PropertyValueFactory<>("data_realizacji")
        );
        TableColumn<Zamowienie, String> real_col = new TableColumn<>("Zrealizowano");
        real_col.setResizable(false);
        real_col.setPrefWidth(90);
        real_col.setCellValueFactory(
                new PropertyValueFactory<>("zrealizowano_string")
        );

        TableColumn<Zamowienie, Button> edit_col = new TableColumn<>("Edytuj");
        edit_col.setResizable(false);
        edit_col.setPrefWidth(49);
        edit_col.setCellValueFactory(
                new PropertyValueFactory<>("edit")
        );
        TableColumn<Zamowienie, Button> del_col = new TableColumn<>("Usuń");
        del_col.setResizable(false);
        del_col.setPrefWidth(49);
        del_col.setCellValueFactory(
                new PropertyValueFactory<>("delete")
        );

        table.setItems(data);
        table.getColumns().addAll(id_col, id_kl_col, id_prac_col, id_usl_col, data_zam_col, data_real_col, real_col, edit_col, del_col);
        return table;
    }
}
