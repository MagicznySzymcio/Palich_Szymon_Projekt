package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.bazy.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static Controller instance;

    public Controller() {
        instance = this;
    }

    public static Controller getInstance()
    {
        return instance;
    }


    @FXML
    public MenuButton menu;
    public AnchorPane alert_box;
    public Button close_button;
    public VBox vbox_tabela;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            menuSetKlienci();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    public void close() {
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void menuSetKlienci() throws SQLException {
        menu.setText("Klienci");
        TableView<Klient> table = TableViewT.getTableKlient();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetPracownicy() throws SQLException {
        menu.setText("Pracownicy");
        TableView<Pracownik> table = TableViewT.getTablePracownik();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetStanowiska() throws SQLException {
        menu.setText("Stanowiska");
        TableView<Stanowisko> table = TableViewT.getTableStanowisko();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetUslugi() throws SQLException {
        menu.setText("Uslugi");
        TableView<Usluga> table = TableViewT.getTableUsluga();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetZamowienia() throws SQLException {
        menu.setText("Zamowienia");
        TableView<Zamowienie> table = TableViewT.getTableZamowienie();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void openDialog() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("edit.fxml"));
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(Main.STAGE);
        dialog.setScene(new Scene(root, 600, 400));
        dialog.show();
    }
}
