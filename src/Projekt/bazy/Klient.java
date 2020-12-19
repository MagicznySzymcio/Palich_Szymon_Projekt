package Projekt.bazy;

import Projekt.fxml.EditController;
import Projekt.fxml.RootController;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.SQLException;

public class Klient {
    int id_klienta;
    String nazwisko;
    String imie;
    String nazwa_firmy;
    String miasto;
    String ulica_nr_domu;
    private Button delete;
    private Button edit;

    public Klient(int id_klienta, String nazwisko, String imie, String nazwa_firmy, String miasto, String ulica_nr_domu) {
        this.id_klienta = id_klienta;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.nazwa_firmy = nazwa_firmy;
        this.miasto = miasto;
        this.ulica_nr_domu = ulica_nr_domu;
        this.delete = new Button();
        this.delete.getStyleClass().add("remove_button");
        this.edit = new Button();
        this.edit.getStyleClass().add("edit_button");
        this.edit.setOnAction(e -> {
            try {
                RootController.getInstance().openDialog();
                EditController.getInstance().klientEditInit(this.id_klienta, this.nazwisko, this.imie, this.nazwa_firmy, this.miasto, this.ulica_nr_domu);
            } catch (IOException | SQLException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwa_firmy() {
        return nazwa_firmy;
    }

    public void setNazwa_firmy(String nazwa_firmy) {
        this.nazwa_firmy = nazwa_firmy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica_nr_domu() {
        return ulica_nr_domu;
    }

    public void setUlica_nr_domu(String ulica_nr_domu) {
        this.ulica_nr_domu = ulica_nr_domu;
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

    @Override
    public String toString() {
        return "Klient{" +
                "idklienta=" + id_klienta +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwa_firmy='" + nazwa_firmy + '\'' +
                ", miasto='" + miasto + '\'' +
                ", ulica_nr_domu='" + ulica_nr_domu + '\'' +
                '}';
    }
}
