package sample.bazy;

import javafx.scene.control.Button;

import java.sql.Date;

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
