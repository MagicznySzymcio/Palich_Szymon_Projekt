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

        //Step : 1# Create a person class that will represtent data

        //Step : 2# Define data in an Observable list and add data as you want to show inside table
        final ObservableList<Klient> data = FXCollections.observableArrayList(
                new Klient(1, "Jacob", "24", "", "jacob.smith", "jacob.smi"));


        //Step : 3#  Associate data with columns
        id_klienta.setCellValueFactory(new PropertyValueFactory<Klient,Integer>("id_klienta"));
        nazwisko.setCellValueFactory(new PropertyValueFactory<Klient,String>("nazwisko"));
        imie.setCellValueFactory(new PropertyValueFactory<Klient,String>("imie"));
        nazwa_firmy.setCellValueFactory(new PropertyValueFactory<Klient,String>("nazwa_firmy"));
        miasto.setCellValueFactory(new PropertyValueFactory<Klient,String>("miasto"));
        ulica_nr_domu.setCellValueFactory(new PropertyValueFactory<Klient,String>("ulica_nr_domu"));


        //Step 4: add data inside table
        tabela_pracownicy.setItems(data);
        tabela_pracownicy.getColumns().addAll(id_klienta, nazwisko, imie, nazwa_firmy, miasto, ulica_nr_domu);

    }
}
