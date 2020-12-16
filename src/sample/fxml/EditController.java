package sample.fxml;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.DbAccess;
import sample.Main;
import sample.bazy.Stanowisko;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    private final int LIMIT = 20;
    public int first_id_value = -1;
    private static EditController instance;

    public EditController() throws SQLException, ClassNotFoundException {
        instance = this;
    }

    public static EditController getInstance()
    {
        return instance;
    }

    public static float round(float value) {
        return (float) (int) (value * 100) / 100;
    }

    public static boolean checkString(String text)    {
        return text.length() <= 20;
    }

    public static boolean checkFloat(String text) {
        try {
            Float.parseFloat(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public RootController prev = RootController.getInstance();
    public DbAccess tescik = new DbAccess();

    public AnchorPane alert_box;
    public GridPane grid_pane;

    @FXML
    private Button close_button;
    @FXML
    private Button accept_button;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void uslugaAddInit()    {
        Label nazwa = new Label("Nazwa");
        Label cena = new Label("Cena");
        
        TextField nazwa_text = new TextField();
        TextField cena_text = new TextField();
        
        grid_pane.add(nazwa, 0, 0);
        grid_pane.add(cena, 0, 1);
        grid_pane.add(nazwa_text, 1, 0);
        grid_pane.add(cena_text, 1, 1);
        accept_button.setOnAction(e -> {
            try {
                if (checkString(nazwa_text.getText()) && checkFloat(cena_text.getText())) {
                    tescik.add(nazwa_text.getText(), Float.parseFloat(cena_text.getText()));
                    prev.menuSetUslugi();
                    close();
                }
                else System.out.println("blad");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    public void pracownikAddInit() throws SQLException {
        MenuButton id_stan_menu = new MenuButton("Wybierz ID");
        ObservableList<Stanowisko> table = Main.test.loadStanowisko();
        for (Stanowisko stanowisko: table) {
            MenuItem temp = new MenuItem(stanowisko.getId_stanowiska() + " - " + stanowisko.getNazwa());
            temp.setOnAction(e -> {
                id_stan_menu.setText(stanowisko.getId_stanowiska() + " - " + stanowisko.getNazwa());
                first_id_value = stanowisko.getId_stanowiska();
            });
            id_stan_menu.getItems().add(temp);
        }


        Label id_stanowiska = new Label("ID Stanowiska");
        Label nazwisko = new Label("Nazwisko");
        Label imie = new Label("Imie");
        Label data_zatrudnienia = new Label("Data zatrudnienia");
        Label data_zwolnienia = new Label("Data zwolnienia");
        Label wynagrodzenie = new Label("Wynagrodzenie");


        TextField nazwisko_control = new TextField();
        TextField imie_control = new TextField();
        DatePicker data_zatr_control = new DatePicker();
        data_zatr_control.setEditable(false);
        DatePicker data_zwol_control = new DatePicker();
        data_zwol_control.setEditable(false);
        TextField wynagrodzenie_control = new TextField();


        grid_pane.add(id_stanowiska, 0, 0);
        grid_pane.add(nazwisko, 0, 1);
        grid_pane.add(imie, 0, 2);
        grid_pane.add(data_zatrudnienia, 0, 3);
        grid_pane.add(data_zwolnienia, 0, 4);
        grid_pane.add(wynagrodzenie, 0, 5);
        grid_pane.add(id_stan_menu, 1, 0);
        grid_pane.add(nazwisko_control, 1, 1);
        grid_pane.add(imie_control, 1, 2);
        grid_pane.add(data_zatr_control, 1, 3);
        grid_pane.add(data_zwol_control, 1, 4);
        grid_pane.add(wynagrodzenie_control, 1, 5);

        accept_button.setOnAction(e -> {
            try {
                if (checkString(nazwisko_control.getText()) && checkString(imie_control.getText()) && checkFloat(wynagrodzenie_control.getText()) && first_id_value != -1) {
                    tescik.add(first_id_value, nazwisko_control.getText(), imie_control.getText(), Date.valueOf(data_zatr_control.getValue()),
                            Date.valueOf(data_zwol_control.getValue()), Float.parseFloat(wynagrodzenie_control.getText()));
                    prev.menuSetPracownicy();
                    close();
                }
                else System.out.println("blad");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }


    @FXML
    public void uslugaEditInit(int id, String nazwa_t, float cena_t)    {
        Label nazwa = new Label("Nazwa");
        Label cena = new Label("Cena");
        TextField nazwa_text = new TextField();
        TextField cena_text = new TextField();
        nazwa_text.setText(nazwa_t);
        cena_text.setText(String.valueOf(cena_t));
        grid_pane.add(nazwa, 0, 0);
        grid_pane.add(cena, 0, 1);
        grid_pane.add(nazwa_text, 1, 0);
        grid_pane.add(cena_text, 1, 1);
        accept_button.setOnAction(e -> {
            try {
                if (checkString(nazwa_text.getText()) && checkFloat(cena_text.getText())) {
                    tescik.update(id, nazwa_text.getText(), Float.parseFloat(cena_text.getText()));
                    prev.menuSetUslugi();
                    close();
                }
                else System.out.println("blad");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    public void close() {
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }
}

