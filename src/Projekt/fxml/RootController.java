package Projekt.fxml;

import Projekt.Main;
import Projekt.TableCreator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    private static RootController instance;
    @FXML
    public Button search;
    @FXML
    private MenuButton menu;
    @FXML
    private VBox vbox_tabela;
    @FXML
    private CheckBox checkbox_real;
    @FXML
    private TextArea error_log_area;
    @FXML
    private TextField search_text;

    public RootController() {
        instance = this;
    }

    public static RootController getInstance() {
        return instance;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        search_text.addEventFilter(KeyEvent.ANY, keyEvent -> {
            try {
                search();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        try {
            menuSetKlienci();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void show_error(String msg) {
        error_log_area.setText(msg);
    }

    @FXML
    public void menuSetKlienci() throws SQLException {
        menu.setText("Klienci");
        TableView<Projekt.bazy.Klient> table = TableCreator.getTableKlient(search_text.getText());
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetPracownicy() throws SQLException {
        menu.setText("Pracownicy");
        TableView<Projekt.bazy.Pracownik> table = TableCreator.getTablePracownik(search_text.getText());
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetStanowiska() throws SQLException {
        menu.setText("Stanowiska");
        TableView<Projekt.bazy.Stanowisko> table = TableCreator.getTableStanowisko(search_text.getText());
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetUslugi() throws SQLException {
        menu.setText("Uslugi");
        TableView<Projekt.bazy.Usluga> table = TableCreator.getTableUsluga(search_text.getText());
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetZamowienia() throws SQLException {
        menu.setText("Zamowienia");
        TableView<Projekt.bazy.Zamowienie> table = TableCreator.getTableZamowienie(checkbox_real.isSelected(), search_text.getText());
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void openDialog() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        Stage dialog = new Stage();
        dialog.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));
        dialog.setTitle("Kreator");
        dialog.setResizable(false);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(Main.STAGE);
        dialog.setScene(new Scene(root, 600, 400));
        dialog.show();
    }

    @FXML
    public void pracownikDialog() throws IOException, SQLException {
        openDialog();
        EditController.getInstance().pracownikAddInit();
    }

    @FXML
    public void uslugaDialog() throws IOException {
        openDialog();
        EditController.getInstance().uslugaAddInit();
    }

    @FXML
    public void klientDialog() throws IOException {
        openDialog();
        EditController.getInstance().klientAddInit();
    }

    @FXML
    public void stanowiskoDialog() throws IOException {
        openDialog();
        EditController.getInstance().stanowiskoAddInit();
    }

    @FXML
    public void zamowienieDialog() throws IOException, SQLException {
        openDialog();
        EditController.getInstance().zamowienieAddInit();
    }

    @FXML
    public void checbox_real() throws SQLException {
        if (menu.getText().equals("Zamowienia"))
            menuSetZamowienia();
    }

    @FXML
    public void search() throws SQLException {
        switch (menu.getText()) {
            case "Klienci" -> menuSetKlienci();
            case "Pracownicy" -> menuSetPracownicy();
            case "Stanowiska" -> menuSetStanowiska();
            case "Uslugi" -> menuSetUslugi();
            case "Zamowienia" -> menuSetZamowienia();
        }
    }

}
