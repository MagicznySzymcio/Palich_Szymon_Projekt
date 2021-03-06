package Projekt.bazy;

import Projekt.Main;
import Projekt.fxml.EditController;
import Projekt.fxml.RootController;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class Zamowienie {
    private int id_zamowienia;
    private int id_pracownika;
    private int id_klienta;
    private int id_uslugi;
    private Date data_zamowienia;
    private Date data_realizacji;
    private int zrealizowano;
    private String temp_klient;
    private String temp_pracownik;
    private String temp_usluga;
    private Button delete;
    private Button edit;
    private String zrealizowano_string;

    public Zamowienie(int id_zamowienia, int id_klienta, int id_pracownika, int id_uslugi, Date data_zamowienia, Date data_realizacji, int zrealizowano) {
        this.id_zamowienia = id_zamowienia;
        this.id_pracownika = id_pracownika;
        this.id_klienta = id_klienta;
        this.id_uslugi = id_uslugi;
        this.data_zamowienia = data_zamowienia;
        this.data_realizacji = data_realizacji;
        String temp_klient = null;
        String temp_pracownik = null;
        String temp_usluga = null;
        this.zrealizowano = zrealizowano;
        this.zrealizowano_string = this.zrealizowano == 1 ? "TAK" : "NIE";
        this.delete = new Button();
        this.delete.getStyleClass().add("remove_button");
        this.delete.setOnAction(
                e -> {
                    try {
                        Main.DbInstance.removeZamowienie(this.id_zamowienia);
                        RootController.getInstance().menuSetZamowienia();
                    } catch (SQLException throwables) {
                        RootController.getInstance().show_error(Main.getTime() + " To nie powinno wyskoczyć, chyba, że nie masz połączenia z bazą danych");
                    }
                });
        this.edit = new Button();
        this.edit.getStyleClass().add("edit_button");
        this.edit.setOnAction(e -> {
            try {
                RootController.getInstance().openDialog();
                EditController.getInstance().zamowienieEditInit(this.id_zamowienia, this.id_klienta, this.id_pracownika, this.id_uslugi, this.data_zamowienia, this.data_realizacji, this.zrealizowano);
            } catch (IOException | SQLException ioException) {
                RootController.getInstance().show_error(Main.getTime() + " To nie powinno wyskoczyć, chyba, że nie masz połączenia z bazą danych");
            }
        });
    }


    public String getTemp_klient() {
        return temp_klient;
    }

    public void setTemp_klient(String temp_klient) {
        this.temp_klient = temp_klient;
    }

    public String getTemp_pracownik() {
        return temp_pracownik;
    }

    public void setTemp_pracownik(String temp_pracownik) {
        this.temp_pracownik = temp_pracownik;
    }

    public String getTemp_usluga() {
        return temp_usluga;
    }

    public void setTemp_usluga(String temp_usluga) {
        this.temp_usluga = temp_usluga;
    }

    public int getId_zamowienia() {
        return id_zamowienia;
    }

    public void setId_zamowienia(int id_zamowienia) {
        this.id_zamowienia = id_zamowienia;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public int getId_uslugi() {
        return id_uslugi;
    }

    public void setId_uslugi(int id_uslugi) {
        this.id_uslugi = id_uslugi;
    }

    public Date getData_zamowienia() {
        return data_zamowienia;
    }

    public void setData_zamowienia(Date data_zamowienia) {
        this.data_zamowienia = data_zamowienia;
    }

    public Date getData_realizacji() {
        return data_realizacji;
    }

    public void setData_realizacji(Date data_realizacji) {
        this.data_realizacji = data_realizacji;
    }

    public int getZrealizowano() {
        return zrealizowano;
    }

    public void setZrealizowano(int zrealizowano) {
        this.zrealizowano = zrealizowano;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public String getZrealizowano_string() {
        return zrealizowano_string;
    }

    public void setZrealizowano_string(String zrealizowano_string) {
        this.zrealizowano_string = zrealizowano_string;
    }
}
