package Projekt.fxml;

import Projekt.Main;
import Projekt.TableCreator;
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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    private static RootController instance;
    public int dialog_type;
    @FXML
    public MenuButton menu;
    public AnchorPane alert_box;
    public Button close_button;
    public VBox vbox_tabela;
    public RootController() {
        instance = this;
    }

    public static RootController getInstance() {
        return instance;
    }

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
        TableView table = TableCreator.getTableKlient();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetPracownicy() throws SQLException {
        menu.setText("Pracownicy");
        TableView table = TableCreator.getTablePracownik();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetStanowiska() throws SQLException {
        menu.setText("Stanowiska");
        TableView table = TableCreator.getTableStanowisko();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetUslugi() throws SQLException {
        menu.setText("Uslugi");
        TableView table = TableCreator.getTableUsluga();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetZamowienia() throws SQLException {
        menu.setText("Zamowienia");
        TableView table = TableCreator.getTableZamowienie();
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
}
