//        MagicznaProgram do obsługi bazy danych
//        Copyright (C) 2021 Palich Szymon
//
//        This program is free software: you can redistribute it and/or modify
//        it under the terms of the GNU General Public License as published by
//        the Free Software Foundation, either version 3 of the License, or
//        (at your option) any later version.
//
//        This program is distributed in the hope that it will be useful,
//        but WITHOUT ANY WARRANTY; without even the implied warranty of
//        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//        GNU General Public License for more details.
//
//        You should have received a copy of the GNU General Public License
//        along with this program.  If not, see <https://www.gnu.org/licenses/>.


package Projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static DbAccess DbInstance;
    public static Stage STAGE;
    private static boolean connected = true;

    static {
        try {
            DbInstance = new DbAccess();
        } catch (SQLException | ClassNotFoundException throwables) {
            connected = false;
        }
    }

    public static String getTime() {
        return "[" + LocalTime.now().format(FORMATTER) + "]";
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene;
        if (connected) {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/root.fxml"));
            primaryStage.setTitle("MagicznaProgram");
            scene = new Scene(root, 1280, 720);
        } else {
            Parent root = FXMLLoader.load(getClass().getResource("fxml/connectionError.fxml"));
            primaryStage.setTitle("Błąd połączenia");
            scene = new Scene(root, 250, 100);
        }
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("img/icon.png")));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
