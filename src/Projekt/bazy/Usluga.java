package Projekt.bazy;

import Projekt.Main;
import Projekt.fxml.EditController;
import Projekt.fxml.RootController;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.SQLException;

public class Usluga {
    private int id_uslugi;
    private String nazwa;
    private float cena;
    private Button edit;
    private Button delete;

    public Usluga(int id_uslugi, String nazwa, float cena) {
        this.id_uslugi = id_uslugi;
        this.nazwa = nazwa;
        this.cena = cena;
        this.delete = new Button();
        this.delete.getStyleClass().add("remove_button");
        this.delete.setOnAction(
                e -> {
                    try {
                        Main.DbInstance.removeUsluga(this.id_uslugi);
                        RootController.getInstance().menuSetUslugi();
                    } catch (SQLException throwables) {
                        RootController.getInstance().show_error(Main.getTime() + " Nie można usunąć wartości id=" + this.id_uslugi + " ponieważ jest ona połączona z inną tabelą");
                    }
                });
        this.edit = new Button();
        this.edit.getStyleClass().add("edit_button");
        this.edit.setOnAction(e -> {
            try {
                RootController.getInstance().openDialog();
                EditController.getInstance().uslugaEditInit(this.id_uslugi, this.nazwa, this.cena);
            } catch (IOException ioException) {
                RootController.getInstance().show_error(Main.getTime() + " To nie powinno wyskoczyć, chyba, że nie masz połączenia z bazą danych");
            }
        });
    }

    public int getId_uslugi() {
        return id_uslugi;
    }

    public void setId_uslugi(int id_uslugi) {
        this.id_uslugi = id_uslugi;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "ID: " + id_uslugi +
                "\n Nazwa usługi: " + nazwa +
                "\n Cena: " + cena;
    }
}
