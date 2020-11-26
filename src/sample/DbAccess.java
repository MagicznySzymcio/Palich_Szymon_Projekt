package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.bazy.*;

import java.sql.*;

public class DbAccess {
    String url;
    String user;
    String pass;
    Class<?> driver;
    Connection connection;
    Statement statement;

    public DbAccess(String url, String user, String pass, Class<?> driver) throws SQLException {
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.driver = driver;
        this.connection = DriverManager.getConnection(url, user, pass);
        this.statement = connection.createStatement();
    }

    public ObservableList<Klient> loadKlient() throws SQLException {
        ObservableList<Klient> lista_klientow = FXCollections.observableArrayList();
        ResultSet result = statement.executeQuery("SELECT * FROM klient");

        while (result.next()) {
            lista_klientow.add(new Klient(result.getInt(1), result.getString(2), result.getString(3),
                    result.getString(4), result.getString(5), result.getString(6)));
        }
        return lista_klientow;
    }

    public ObservableList<Pracownik> loadPracownik() throws SQLException {
        ObservableList<Pracownik> lista_pracownikow = FXCollections.observableArrayList();
        ResultSet result = statement.executeQuery("SELECT * FROM pracownik");

        while (result.next()) {
            lista_pracownikow.add(new Pracownik(result.getInt(1), result.getString(2), result.getString(3),
                    result.getDate(4), result.getDate(5), result.getFloat(6)));
        }
        return lista_pracownikow;
    }

    public ObservableList<Stanowisko> loadStanowisko() throws SQLException {
        ObservableList<Stanowisko> lista_stanowisk = FXCollections.observableArrayList();
        ResultSet result = statement.executeQuery("SELECT * FROM stanowisko");

        while (result.next()) {
            lista_stanowisk.add(new Stanowisko(result.getInt(1), result.getString(2)));
        }
        return lista_stanowisk;
    }

    public ObservableList<Usluga> loadUsluga() throws SQLException {
        ObservableList<Usluga> lista_uslug = FXCollections.observableArrayList();
        ResultSet result = statement.executeQuery("SELECT * FROM usluga");

        while (result.next()) {
            lista_uslug.add(new Usluga(result.getInt(1), result.getString(2),
                    result.getFloat(3)));
        }
        return lista_uslug;
    }

    public ObservableList<Zamowienie> loadZamowienie() throws SQLException {
        ObservableList<Zamowienie> lista_zamowien = FXCollections.observableArrayList();
        ResultSet result = statement.executeQuery("SELECT * FROM zamowienie");

        while (result.next()) {
            lista_zamowien.add(new Zamowienie(result.getInt(1), result.getInt(2),
                    result.getInt(3), result.getInt(4), result.getDate(5),
                    result.getDate(6), result.getInt(7)));
        }
        return lista_zamowien;
    }


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DbAccess bbb = new DbAccess("jdbc:mysql://localhost:3306/projekt", "root",
                "", Class.forName("com.mysql.cj.jdbc.Driver"));
        //bbb.test();
        bbb.loadKlient();
    }

}