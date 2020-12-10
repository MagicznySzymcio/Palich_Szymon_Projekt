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

    public DbAccess() throws SQLException, ClassNotFoundException {
        this.url = "jdbc:mysql://localhost:3306/projekt";
        this.user = "root";
        this.pass = "";
        this.driver = Class.forName("com.mysql.cj.jdbc.Driver");
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
            lista_pracownikow.add(new Pracownik(result.getInt(1), result.getInt(2),
                    result.getString(3), result.getString(4),
                    result.getDate(5), result.getDate(6), result.getFloat(7)));
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


    public void add(String nazwisko, String imie, String nazwa_firmy, String miasto, String ulica_nr_domu) throws SQLException   {
        String sql = "INSERT INTO `klient` VALUES (NULL, '" + nazwisko + "', '" + imie +  "', '" + nazwa_firmy +  "', '" + miasto +  "', '" + ulica_nr_domu +"')";
        statement.executeUpdate(sql);
    }

    public void add(int id_stanowiska, String nazwisko, String imie, Date data_zatrudnienia, Date data_zwolnienia, Float wynagrodzenie) throws SQLException   {
        String sql = "INSERT INTO `pracownik` VALUES (NULL, '" + id_stanowiska + "', '" + nazwisko +  "', '" + imie +  "', '" + data_zatrudnienia +  "', '" + data_zwolnienia +"', '" + wynagrodzenie +"')";
        statement.executeUpdate(sql);
    }

    public void add(String nazwa) throws SQLException   {
        String sql = "INSERT INTO `stanowisko` VALUES (NULL, '" + nazwa + "')";
        statement.executeUpdate(sql);
    }

    public void add(String nazwa, float cena) throws SQLException   {
        String sql = "INSERT INTO `usluga` VALUES (NULL, '" + nazwa + "', '" + cena + "')";
        statement.executeUpdate(sql);
    }

    public void update(int id, String nazwa, float cena) throws SQLException   {
        String sql = "UPDATE `usluga` SET `nazwa` = '" + nazwa +"', `cena` = '"+ cena + "' WHERE `usluga`.`id_uslugi` = " + id;
        statement.executeUpdate(sql);
    }

    public void add(int id_klienta, int id_pracownika, int id_uslugi, Date data_zamowienia, Date data_realizacji, int zrealizowano) throws SQLException   {
        String sql = "INSERT INTO `zamowienie` VALUES (NULL, '" + id_klienta + "', '" + id_pracownika +  "', '" + id_uslugi +  "', '"
                + data_zamowienia +  "', '" + data_realizacji +"', '" + zrealizowano +"')";
        statement.executeUpdate(sql);
    }

    public void removeKlient(int id) throws SQLException {
        String sql = "DELETE FROM `klient` WHERE `klient`.`id_klienta` = " + id;
        statement.executeUpdate(sql);
    }

    public void removeZamowienie(int id) throws SQLException {
        String sql = "DELETE FROM `zamowienie` WHERE `zamowienie`.`id_zamowienia` = " + id;
        statement.executeUpdate(sql);
    }



    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DbAccess bbb = new DbAccess("jdbc:mysql://localhost:3306/projekt", "root",
                "", Class.forName("com.mysql.cj.jdbc.Driver"));
        bbb.loadPracownik();
    }

}