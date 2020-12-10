package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    private static EditController instance;

    public EditController() throws SQLException, ClassNotFoundException {
        instance = this;
    }

    public static EditController getInstance()
    {
        return instance;
    }

    
    public Controller prev = Controller.getInstance();
    public DbAccess tescik = new DbAccess();

    public AnchorPane alert_box;
    public GridPane grid_pane;

    @FXML
    private Button close_button;
    @FXML
    private Button accept_button;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        uslugaAddInit(0);
    }

    @FXML
    public void uslugaAddInit(int id)    {
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
                tescik.add(nazwa_text.getText(), Float.parseFloat(cena_text.getText()));
                prev.menuSetUslugi();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            close();
        });
    }

    @FXML
    public void uslugaEditInit(int id)    {
        Label nazwa = new Label("Nazwa");
        Label cena = new Label("Cena");
        TextField nazwa_text = new TextField();
        TextField cena_text = new TextField();
        nazwa_text.setText("dadads");
        cena_text.setText("14.22");
        grid_pane.add(nazwa, 0, 0);
        grid_pane.add(cena, 0, 1);
        grid_pane.add(nazwa_text, 1, 0);
        grid_pane.add(cena_text, 1, 1);
        accept_button.setOnAction(e -> {
            try {
                tescik.update(id, nazwa_text.getText(), Float.parseFloat(cena_text.getText()));
                prev.menuSetUslugi();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            close();
        });
    }

    @FXML
    public void close() {
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }
}

