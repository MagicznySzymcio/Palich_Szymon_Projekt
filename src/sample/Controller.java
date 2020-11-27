package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.bazy.Klient;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView<Klient> tabela_pracownicy;

    @FXML
    private TableColumn<Klient, Integer> id_klienta;

    @FXML
    private TableColumn<Klient, String> nazwisko;

    @FXML
    private TableColumn<Klient, String> imie;

    @FXML
    private TableColumn<Klient, String> nazwa_firmy;

    @FXML
    private TableColumn<Klient, String> miasto;

    @FXML
    private TableColumn<Klient, String> ulica_nr_domu;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Klient> cos = null;

        DbAccess bbb;
        try {
            bbb = new DbAccess();
            cos = bbb.loadKlient();
            System.out.println(cos);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        final ObservableList<Klient> data = FXCollections.observableArrayList(
                new Klient(12, "Jacob", "24", "dsfs", "jac", "jaco"));

        id_klienta.setCellValueFactory(new PropertyValueFactory<Klient,Integer>("id_klienta"));
        nazwisko.setCellValueFactory(new PropertyValueFactory<Klient,String>("nazwisko"));
        imie.setCellValueFactory(new PropertyValueFactory<Klient,String>("imie"));
        nazwa_firmy.setCellValueFactory(new PropertyValueFactory<Klient,String>("nazwa_firmy"));
        miasto.setCellValueFactory(new PropertyValueFactory<Klient,String>("miasto"));
        ulica_nr_domu.setCellValueFactory(new PropertyValueFactory<Klient,String>("ulica_nr_domu"));


        tabela_pracownicy.setItems(cos);
        //tabela_pracownicy.getColumns().addAll(id_klienta, nazwisko, imie, nazwa_firmy, miasto, ulica_nr_domu);

    }
}
