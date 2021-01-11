package Projekt.bazy;

import Projekt.Main;
import Projekt.fxml.EditController;
import Projekt.fxml.RootController;
import javafx.scene.control.Button;

import java.io.IOException;
import java.sql.SQLException;

public class Stanowisko {
    private int id_stanowiska;
    private String nazwa;
    private Button edit;
    private Button delete;

    public Stanowisko(int id_stanowiska, String nazwa) {
        this.id_stanowiska = id_stanowiska;
        this.nazwa = nazwa;
        this.delete = new Button();
        this.delete.getStyleClass().add("remove_button");
        this.delete.setOnAction(
                e -> {
                    try {
                        Main.DbInstance.removeStanowisko(this.id_stanowiska);
                        RootController.getInstance().menuSetStanowiska();
                    } catch (SQLException throwables) {
                        RootController.getInstance().show_error(Main.getTime() + " Nie można usunąć wartości id=" + this.id_stanowiska + " ponieważ jest ona połączona z inną tabelą");
                    }
                });
        this.edit = new Button();
        this.edit.getStyleClass().add("edit_button");
        this.edit.setOnAction(e -> {
            try {
                RootController.getInstance().openDialog();
                EditController.getInstance().stanowiskoEditInit(this.id_stanowiska, this.nazwa);
            } catch (IOException ioException) {
                RootController.getInstance().show_error(Main.getTime() + " To nie powinno wyskoczyć, chyba, że nie masz połączenia z bazą danych");
            }
        });
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public int getId_stanowiska() {
        return id_stanowiska;
    }

    public void setId_stanowiska(int id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }
}

