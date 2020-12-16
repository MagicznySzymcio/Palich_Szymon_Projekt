package sample.fxml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;
import sample.TableView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    public int dialog_type;
    private static RootController instance;

    public RootController() {
        instance = this;
    }

    public static RootController getInstance()
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
        javafx.scene.control.TableView table = TableView.getTableKlient();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetPracownicy() throws SQLException {
        menu.setText("Pracownicy");
        javafx.scene.control.TableView table = TableView.getTablePracownik();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetStanowiska() throws SQLException {
        menu.setText("Stanowiska");
        javafx.scene.control.TableView table = TableView.getTableStanowisko();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetUslugi() throws SQLException {
        menu.setText("Uslugi");
        javafx.scene.control.TableView table = TableView.getTableUsluga();
        vbox_tabela.getChildren().clear();
        vbox_tabela.getChildren().addAll(table);
    }

    @FXML
    public void menuSetZamowienia() throws SQLException {
        menu.setText("Zamowienia");
        javafx.scene.control.TableView table = TableView.getTableZamowienie();
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
    public void uslugaDialog() throws IOException, SQLException {
        openDialog();
        EditController.getInstance().uslugaAddInit();
    }
}
