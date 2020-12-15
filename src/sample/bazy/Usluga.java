package sample.bazy;

import javafx.scene.control.Button;
import sample.Controller;
import sample.EditController;
import java.io.IOException;


public class Usluga {
    int id_uslugi;
    String nazwa;
    float cena;
    private Button edit;

    public Usluga(int id_uslugi, String nazwa, float cena) {
        this.id_uslugi = id_uslugi;
        this.nazwa = nazwa;
        this.cena = cena;
        this.edit = new Button();
        this.edit.getStyleClass().add("edit_button");
        this.edit.setOnAction(e -> {
            try {
                Controller.getInstance().openDialog();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            EditController.getInstance().uslugaEditInit(this.id_uslugi, this.nazwa, this.cena);
                });
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
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

    @Override
    public String   toString() {
        return "Usluga{" +
                "id_uslugi=" + id_uslugi +
                ", nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                '}';
    }
}
