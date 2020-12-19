package Projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {
    public static DbAccess test;
    public static Stage STAGE;

    static {
        try {
            test = new DbAccess();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/root.fxml"));
        primaryStage.setTitle("MagicznyProgram");
        Scene scena = new Scene(root, 1280, 720);
        primaryStage.setScene(scena);
        STAGE = primaryStage;
        primaryStage.show();
    }
}
