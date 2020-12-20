package Projekt.bazy;

import Projekt.Main;
import Projekt.fxml.EditController;
import Projekt.fxml.RootController;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;

public class Zamowienie {
    int id_zamowienia;
    int id_pracownika;
    int id_klienta;
    int id_uslugi;
    Date data_zamowienia;
    Date data_realizacji;
    int zrealizowano;
    private Button delete;
    private Button edit;
    String zrealizowano_string;

    public Zamowienie(int id_zamowienia, int id_klienta, int id_pracownika, int id_uslugi, Date data_zamowienia, Date data_realizacji, int zrealizowano) {
        this.id_zamowienia = id_zamowienia;
        this.id_pracownika = id_pracownika;
        this.id_klienta = id_klienta;
        this.id_uslugi = id_uslugi;
        this.data_zamowienia = data_zamowienia;
        this.data_realizacji = data_realizacji;
        this.zrealizowano = zrealizowano;
        this.zrealizowano_string = this.zrealizowano == 1 ? "Jeszcze jak" : "Ojoj";
        this.delete = new Button();
        this.delete.getStyleClass().add("remove_button");
        this.delete.setOnAction(
                e -> {
                    try {
                        Main.test.removeZamowienie(this.id_zamowienia);
                        RootController.getInstance().menuSetZamowienia();
                    } catch (SQLException throwables) {
                        RootController.getInstance().show_error(Main.getTime() + " Nie można usunąć wartości id=" + this.id_zamowienia + " ponieważ jest ona połączona z inną tabelą");
                    }
                });
        this.edit = new Button();
        this.edit.getStyleClass().add("edit_button");
        this.edit.setOnAction(e -> {
            try {
                RootController.getInstance().openDialog();
                EditController.getInstance().zamowienieEditInit(this.id_zamowienia, this.id_klienta, this.id_pracownika, this.id_uslugi, this.data_zamowienia, this.data_realizacji, this.zrealizowano);
              } catch (IOException | SQLException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    public String getZrealizowano_string() {
        return zrealizowano_string;
    }

    public void setZrealizowano_string(String zrealizowano_string) {
        this.zrealizowano_string = zrealizowano_string;
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
}
