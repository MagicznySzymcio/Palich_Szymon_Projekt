package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import sample.bazy.Klient;
import sample.bazy.Pracownik;
import sample.bazy.TableViewT;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public MenuButton menu;

    @FXML
    private VBox vbox_tabela;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
}
