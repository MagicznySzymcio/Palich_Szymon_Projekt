package Projekt.bazy;

import Projekt.fxml.EditController;
import Projekt.fxml.RootController;
import javafx.scene.control.Button;

import java.io.IOException;

public class Stanowisko {
    int id_stanowiska;
    String nazwa;
    private Button edit;

    public Stanowisko(int id_stanowiska, String nazwa) {
        this.id_stanowiska = id_stanowiska;
        this.nazwa = nazwa;
        this.edit = new Button();
        this.edit.getStyleClass().add("edit_button");
        this.edit.setOnAction(e -> {
            try {
                RootController.getInstance().openDialog();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            EditController.getInstance().stanowiskoEditInit(this.id_stanowiska, this.nazwa);
        });
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

    @Override
    public String toString() {
        return "Stanowisko{" +
                "id_stanowiska=" + id_stanowiska +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}

