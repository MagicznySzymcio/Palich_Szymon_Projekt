package Projekt.bazy;

import Projekt.fxml.EditController;
import Projekt.fxml.RootController;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class Pracownik {
    int id_pracownika;
    int id_stanowiska;
    String nazwisko;
    String imie;
    Date data_zatrudnienia;
    Date data_zwolnienia;
    Float wynagrodzenie;
    private Button edit;

    public Pracownik(int id_pracownika, int id_stanowiska, String nazwisko, String imie, Date data_zatrudnienia, Date data_zwolnienia, Float wynagrodzenie) {
        this.id_pracownika = id_pracownika;
        this.id_stanowiska = id_stanowiska;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.data_zatrudnienia = data_zatrudnienia;
        this.data_zwolnienia = data_zwolnienia;
        this.wynagrodzenie = wynagrodzenie;
        this.edit = new Button();
        this.edit.getStyleClass().add("edit_button");
        this.edit.setOnAction(e -> {
            try {
                RootController.getInstance().openDialog();
                if (this.data_zwolnienia == null)
                    EditController.getInstance().pracownikEditInit(this.id_pracownika, this.id_stanowiska, this.nazwisko, this.imie, this.data_zatrudnienia, Date.valueOf("1899-12-31"), this.wynagrodzenie);
                else
                    EditController.getInstance().pracownikEditInit(this.id_pracownika, this.id_stanowiska, this.nazwisko, this.imie, this.data_zatrudnienia, this.data_zwolnienia, this.wynagrodzenie);
            } catch (IOException | SQLException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public int getId_stanowiska() {
        return id_stanowiska;
    }

    public void setId_stanowiska(int id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
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

    public Date getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(Date data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public Date getData_zwolnienia() {
        return data_zwolnienia;
    }

    public void setData_zwolnienia(Date data_zwolnienia) {
        this.data_zwolnienia = data_zwolnienia;
    }

    public Float getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(Float wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id_pracownika=" + id_pracownika +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", data_zatrudnienia=" + data_zatrudnienia +
                ", data_zwolnienia=" + data_zwolnienia +
                ", wynagrodzenie=" + wynagrodzenie +
                '}';
    }
}
