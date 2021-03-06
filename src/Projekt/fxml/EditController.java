package Projekt.fxml;

import Projekt.AutoCompleteComboBoxListener;
import Projekt.Main;
import Projekt.bazy.Klient;
import Projekt.bazy.Pracownik;
import Projekt.bazy.Stanowisko;
import Projekt.bazy.Usluga;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EditController implements Initializable {
    private static EditController instance;
    private final RootController root_instance = RootController.getInstance();
    private int primo = -1;
    private int secundo = -1;
    private int terzo = -1;
    @FXML
    private GridPane grid_pane;
    @FXML
    private Button close_button;
    @FXML
    private Button accept_button;
    @FXML
    private TextArea error_log;

    public EditController() {
        instance = this;
    }

    public static EditController getInstance() {
        return instance;
    }

    public void show_error(String msg) {
        error_log.setText(Main.getTime() + " " + msg);
    }

    private static boolean checkString(String text) {
        return (text.length() <= 20 && text.length() >= 1);
    }

    private static boolean checkStringNull(String text) {
        if (text == null)
            return true;
        return (text.length() <= 20);
    }

    private static boolean checkDate(LocalDate date) {
        return date != null;
    }

    private static boolean checkFloat(String text) {
        try {
            Float.parseFloat(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void klientAddInit() {
        Label nazwisko = new Label("Nazwisko");
        Label imie = new Label("Imię");
        Label nazwa_firmy = new Label("Nazwa firmy");
        Label miasto = new Label("Miasto");
        Label ul_nr_domu = new Label("Ulica, nr domu");

        TextField nazwisko_control = new TextField();
        TextField imie_control = new TextField();
        TextField nazwa_firmy_control = new TextField();
        TextField miasto_control = new TextField();
        TextField ul_nr_domu_control = new TextField();

        grid_pane.add(nazwisko, 0, 0);
        grid_pane.add(imie, 0, 1);
        grid_pane.add(nazwa_firmy, 0, 2);
        grid_pane.add(miasto, 0, 3);
        grid_pane.add(ul_nr_domu, 0, 4);

        grid_pane.add(nazwisko_control, 1, 0);
        grid_pane.add(imie_control, 1, 1);
        grid_pane.add(nazwa_firmy_control, 1, 2);
        grid_pane.add(miasto_control, 1, 3);
        grid_pane.add(ul_nr_domu_control, 1, 4);

        accept_button.setOnAction(e -> {
            try {
                if (checkString(nazwisko_control.getText()) && checkString(imie_control.getText()) &&
                        checkStringNull(nazwa_firmy_control.getText()) && checkString(miasto_control.getText()) && checkString(ul_nr_domu_control.getText())) {
                    Main.DbInstance.add(nazwisko_control.getText(), imie_control.getText(), nazwa_firmy_control.getText(), miasto_control.getText(), ul_nr_domu_control.getText());
                    root_instance.menuSetKlienci();
                    close();
                } else {
                    if (!checkString(nazwisko_control.getText()))
                        show_error("Nazwisko musi mieć od 1 do 20 znaków");
                    else if (!checkString(imie_control.getText()))
                        show_error("Imię musi mieć od 1 do 20 znaków");
                    else if (!checkStringNull(nazwa_firmy_control.getText()))
                        show_error("Nazwa firmy musi mieć od 1 do 20 znaków");
                    else if (!checkString(miasto_control.getText()))
                        show_error("Miasto musi mieć od 1 do 20 znaków");
                    else if (!checkString(ul_nr_domu_control.getText()))
                        show_error("Ul i numer domu musi mieć od 1 do 20 znaków");
                    else
                        show_error("Easter egg");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    public void klientEditInit(int id, String nazwisko_t, String imie_t, String nazwa_firmy_t, String miasto_t, String ulica_nr_domu_t) {
        Label nazwisko = new Label("Nazwisko");
        Label imie = new Label("Imię");
        Label nazwa_firmy = new Label("Nazwa firmy");
        Label miasto = new Label("Miasto");
        Label ul_nr_domu = new Label("Ulica, nr domu");

        TextField nazwisko_control = new TextField();
        TextField imie_control = new TextField();
        TextField nazwa_firmy_control = new TextField();
        TextField miasto_control = new TextField();
        TextField ul_nr_domu_control = new TextField();

        nazwisko_control.setText(nazwisko_t);
        imie_control.setText(imie_t);
        nazwa_firmy_control.setText(nazwa_firmy_t);
        miasto_control.setText(miasto_t);
        ul_nr_domu_control.setText(ulica_nr_domu_t);


        grid_pane.add(nazwisko, 0, 0);
        grid_pane.add(imie, 0, 1);
        grid_pane.add(nazwa_firmy, 0, 2);
        grid_pane.add(miasto, 0, 3);
        grid_pane.add(ul_nr_domu, 0, 4);

        grid_pane.add(nazwisko_control, 1, 0);
        grid_pane.add(imie_control, 1, 1);
        grid_pane.add(nazwa_firmy_control, 1, 2);
        grid_pane.add(miasto_control, 1, 3);
        grid_pane.add(ul_nr_domu_control, 1, 4);

        accept_button.setOnAction(e -> {
            try {
                if (checkString(nazwisko_control.getText()) && checkString(imie_control.getText()) &&
                        checkStringNull(nazwa_firmy_control.getText()) && checkString(miasto_control.getText()) && checkString(ul_nr_domu_control.getText())) {
                    Main.DbInstance.update(id, nazwisko_control.getText(), imie_control.getText(), nazwa_firmy_control.getText(), miasto_control.getText(), ul_nr_domu_control.getText());
                    root_instance.menuSetKlienci();
                    close();
                } else {
                    if (!checkString(nazwisko_control.getText()))
                        show_error("Nazwisko musi mieć od 1 do 20 znaków");
                    else if (!checkString(imie_control.getText()))
                        show_error("Imię musi mieć od 1 do 20 znaków");
                    else if (!checkStringNull(nazwa_firmy_control.getText()))
                        show_error("Nazwa firmy musi mieć od 1 do 20 znaków");
                    else if (!checkString(miasto_control.getText()))
                        show_error("Miasto musi mieć od 1 do 20 znaków");
                    else if (!checkString(ul_nr_domu_control.getText()))
                        show_error("Ul i numer domu musi mieć od 1 do 20 znaków");
                    else
                        show_error("Easter egg");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    public void pracownikAddInit() throws SQLException {
        MenuButton id_stan_menu = new MenuButton("Wybierz Stanowisko");
        ObservableList<Stanowisko> table = Main.DbInstance.loadStanowisko();
        for (Stanowisko stanowisko : table) {
            MenuItem temp = new MenuItem(stanowisko.getNazwa());
            temp.setOnAction(e -> {
                id_stan_menu.setText(stanowisko.getNazwa());
                primo = stanowisko.getId_stanowiska();
            });
            id_stan_menu.getItems().add(temp);
        }


        Label id_stanowiska = new Label("Wybierz Stanowisko");
        Label nazwisko = new Label("Nazwisko");
        Label imie = new Label("Imię");
        Label data_zatrudnienia = new Label("Data zatrudnienia");
        Label data_zwolnienia = new Label("Data zwolnienia");
        Label wynagrodzenie = new Label("Wynagrodzenie");


        TextField nazwisko_control = new TextField();
        TextField imie_control = new TextField();
        DatePicker data_zatr_control = new DatePicker();
        data_zatr_control.setEditable(false);
        DatePicker data_zwol_control = new DatePicker();
        data_zwol_control.setEditable(false);
        data_zwol_control.setMaxWidth(245);
        TextField wynagrodzenie_control = new TextField();

        Button clear_control = new Button("虚");
        clear_control.setOnAction(
                e -> data_zwol_control.setValue(null));
        GridPane.setMargin(clear_control, new Insets(0, 0, 0, 242));
        grid_pane.add(clear_control, 1, 4);


        grid_pane.add(id_stanowiska, 0, 0);
        grid_pane.add(nazwisko, 0, 1);
        grid_pane.add(imie, 0, 2);
        grid_pane.add(data_zatrudnienia, 0, 3);
        grid_pane.add(data_zwolnienia, 0, 4);
        grid_pane.add(wynagrodzenie, 0, 5);
        grid_pane.add(id_stan_menu, 1, 0);
        grid_pane.add(nazwisko_control, 1, 1);
        grid_pane.add(imie_control, 1, 2);
        grid_pane.add(data_zatr_control, 1, 3);
        grid_pane.add(data_zwol_control, 1, 4);
        grid_pane.add(wynagrodzenie_control, 1, 5);

        accept_button.setOnAction(e -> {
            try {
                if (checkString(nazwisko_control.getText()) && checkString(imie_control.getText()) &&
                        checkFloat(wynagrodzenie_control.getText()) && primo != -1 && checkDate(data_zatr_control.getValue())) {
                    if (checkDate(data_zwol_control.getValue()))
                        Main.DbInstance.add(primo, nazwisko_control.getText(), imie_control.getText(), Date.valueOf(data_zatr_control.getValue()),
                                Date.valueOf(data_zwol_control.getValue()), Float.parseFloat(wynagrodzenie_control.getText()));
                    else
                        Main.DbInstance.add(primo, nazwisko_control.getText(), imie_control.getText(), Date.valueOf(data_zatr_control.getValue()),
                                Float.parseFloat(wynagrodzenie_control.getText()));
                    root_instance.menuSetPracownicy();
                    close();
                } else {
                    if (!checkString(nazwisko_control.getText()))
                        show_error("Nazwisko musi mieć od 1 do 20 znaków");
                    else if (!checkString(imie_control.getText()))
                        show_error("Imię musi mieć od 1 do 20 znaków");
                    else if (!checkFloat(wynagrodzenie_control.getText()))
                        show_error("Wynagrodzenie musi być liczbą zmiennoprzecinkową (Użyj kropki)");
                    else if (!checkDate(data_zatr_control.getValue()))
                        show_error("Data zatrudnienia jest wymagana");
                    else
                        show_error("Wybierz pracownika");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    public void pracownikEditInit(int id, int id_stanowiska_t, String nazwisko_t, String imie_t, Date data_zatrudnienia_t, Date data_zwolnienia_t, Float wynagrodzenie_t) throws SQLException {
        ObservableList<Stanowisko> l_stanowisk = Main.DbInstance.loadStanowisko();
        MenuButton id_stan_menu = null;
        primo = id_stanowiska_t;

        for (Stanowisko stanowisko : l_stanowisk) {
            if (stanowisko.getId_stanowiska() == id_stanowiska_t)
                id_stan_menu = new MenuButton(stanowisko.getNazwa());
        }

        for (Stanowisko stanowisko : l_stanowisk) {
            if (stanowisko.getId_stanowiska() == id)
                id_stan_menu.setText(stanowisko.getNazwa());
        }

        for (Stanowisko stanowisko : l_stanowisk) {
            MenuItem temp = new MenuItem(stanowisko.getNazwa());
            MenuButton finalId_stan_menu = id_stan_menu;
            temp.setOnAction(e -> {
                finalId_stan_menu.setText(stanowisko.getNazwa());
                primo = stanowisko.getId_stanowiska();
            });
            id_stan_menu.getItems().add(temp);
        }

        Label id_stanowiska = new Label("Wybierz Stanowisko");
        Label nazwisko = new Label("Nazwisko");
        Label imie = new Label("Imię");
        Label data_zatrudnienia = new Label("Data zatrudnienia");
        Label data_zwolnienia = new Label("Data zwolnienia");
        Label wynagrodzenie = new Label("Wynagrodzenie");

        TextField nazwisko_control = new TextField();
        TextField imie_control = new TextField();
        DatePicker data_zatr_control = new DatePicker();
        data_zatr_control.setEditable(false);
        DatePicker data_zwol_control = new DatePicker();
        data_zwol_control.setEditable(false);
        data_zwol_control.setMaxWidth(245);
        TextField wynagrodzenie_control = new TextField();

        Button clear_control = new Button("虚");
        clear_control.setOnAction(
                e -> data_zwol_control.setValue(null));
        GridPane.setMargin(clear_control, new Insets(0, 0, 0, 242));
        grid_pane.add(clear_control, 1, 4);


        nazwisko_control.setText(nazwisko_t);
        imie_control.setText(imie_t);
        data_zatr_control.setValue(data_zatrudnienia_t.toLocalDate());
        if (!data_zwolnienia_t.equals(Date.valueOf("1899-12-31")))
            data_zwol_control.setValue(data_zwolnienia_t.toLocalDate());
        wynagrodzenie_control.setText(String.valueOf(wynagrodzenie_t));


        grid_pane.add(id_stanowiska, 0, 0);
        grid_pane.add(nazwisko, 0, 1);
        grid_pane.add(imie, 0, 2);
        grid_pane.add(data_zatrudnienia, 0, 3);
        grid_pane.add(data_zwolnienia, 0, 4);
        grid_pane.add(wynagrodzenie, 0, 5);
        grid_pane.add(id_stan_menu, 1, 0);
        grid_pane.add(nazwisko_control, 1, 1);
        grid_pane.add(imie_control, 1, 2);
        grid_pane.add(data_zatr_control, 1, 3);
        grid_pane.add(data_zwol_control, 1, 4);
        grid_pane.add(wynagrodzenie_control, 1, 5);

        accept_button.setOnAction(e -> {
            try {
                if (checkString(nazwisko_control.getText()) && checkString(imie_control.getText()) &&
                        checkFloat(wynagrodzenie_control.getText()) && primo != -1 && checkDate(data_zatr_control.getValue())) {
                    if (checkDate(data_zwol_control.getValue()))
                        Main.DbInstance.update(id, primo, nazwisko_control.getText(), imie_control.getText(), Date.valueOf(data_zatr_control.getValue()),
                                Date.valueOf(data_zwol_control.getValue()), Float.parseFloat(wynagrodzenie_control.getText()));
                    else
                        Main.DbInstance.update(id, primo, nazwisko_control.getText(), imie_control.getText(), Date.valueOf(data_zatr_control.getValue()),
                                Float.parseFloat(wynagrodzenie_control.getText()));
                    root_instance.menuSetPracownicy();
                    close();
                } else {
                    if (!checkString(nazwisko_control.getText()))
                        show_error("Nazwisko musi mieć od 1 do 20 znaków");
                    else if (!checkString(imie_control.getText()))
                        show_error("Imię musi mieć od 1 do 20 znaków");
                    else if (!checkFloat(wynagrodzenie_control.getText()))
                        show_error("Wynagrodzenie musi być liczbą zmiennoprzecinkową (Użyj kropki)");
                    else if (!checkDate(data_zatr_control.getValue()))
                        show_error("Data zatrudnienia jest wymagana");
                    else
                        show_error("Wybierz pracownika");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    public void stanowiskoAddInit() {
        Label nazwa = new Label("Nazwa stanowiska");
        TextField nazwa_text = new TextField();

        grid_pane.add(nazwa, 0, 0);
        grid_pane.add(nazwa_text, 1, 0);

        accept_button.setOnAction(e -> {
            try {
                if (checkString(nazwa_text.getText())) {
                    Main.DbInstance.add(nazwa_text.getText());
                    root_instance.menuSetStanowiska();
                    close();
                } else {
                    if (!checkString(nazwa_text.getText()))
                        show_error("Nazwa stanowiska musi mieć od 1 do 20 znaków");
                    else
                        show_error("Easter egg");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    public void stanowiskoEditInit(int id, String nazwa_t) {
        Label nazwa = new Label("Nazwa stanowiska");
        TextField nazwa_text = new TextField();
        nazwa_text.setText(nazwa_t);
        grid_pane.add(nazwa, 0, 0);
        grid_pane.add(nazwa_text, 1, 0);
        accept_button.setOnAction(e -> {
            try {
                if (checkString(nazwa_text.getText())) {
                    Main.DbInstance.update(id, nazwa_text.getText());
                    root_instance.menuSetStanowiska();
                    close();
                } else {
                    if (!checkString(nazwa_text.getText()))
                        show_error("Nazwa stanowiska musi mieć od 1 do 20 znaków");
                    else
                        show_error("Easter egg");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    public void uslugaAddInit() {
        Label nazwa = new Label("Nazwa usługi");
        Label cena = new Label("Cena");

        TextField nazwa_text = new TextField();
        TextField cena_text = new TextField();

        grid_pane.add(nazwa, 0, 0);
        grid_pane.add(cena, 0, 1);
        grid_pane.add(nazwa_text, 1, 0);
        grid_pane.add(cena_text, 1, 1);
        accept_button.setOnAction(e -> {
            try {
                if (checkString(nazwa_text.getText()) && checkFloat(cena_text.getText())) {
                    Main.DbInstance.add(nazwa_text.getText(), Float.parseFloat(cena_text.getText()));
                    root_instance.menuSetUslugi();
                    close();
                } else {
                    if (!checkString(nazwa_text.getText()))
                        show_error("Nazwa musi mieć od 1 do 20 znaków");
                    else if (!checkFloat(cena_text.getText()))
                        show_error("Cena musi być liczbą zmiennoprzecinkową (Użyj kropki)");
                    else
                        show_error("Easter egg");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    public void uslugaEditInit(int id, String nazwa_t, float cena_t) {
        Label nazwa = new Label("Nazwa usługi");
        Label cena = new Label("Cena");
        TextField nazwa_text = new TextField();
        TextField cena_text = new TextField();
        nazwa_text.setText(nazwa_t);
        cena_text.setText(String.valueOf(cena_t));
        grid_pane.add(nazwa, 0, 0);
        grid_pane.add(cena, 0, 1);
        grid_pane.add(nazwa_text, 1, 0);
        grid_pane.add(cena_text, 1, 1);
        accept_button.setOnAction(e -> {
            try {
                if (checkString(nazwa_text.getText()) && checkFloat(cena_text.getText())) {
                    Main.DbInstance.update(id, nazwa_text.getText(), Float.parseFloat(cena_text.getText()));
                    root_instance.menuSetUslugi();
                    close();
                } else {
                    if (!checkString(nazwa_text.getText()))
                        show_error("Nazwa musi mieć od 1 do 20 znaków");
                    else if (!checkFloat(cena_text.getText()))
                        show_error("Cena musi być liczbą zmiennoprzecinkową (Użyj kropki)");
                    else
                        show_error("Easter egg");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public int getKlientFromList(String nazwisko, ObservableList<Klient> lista_temp) {
        if (nazwisko == null) nazwisko = "none";
        nazwisko = nazwisko.split("\\s+")[0];
        for (Klient x : lista_temp) {
            if (nazwisko.equals(x.getNazwisko()))
                return x.getId_klienta();
        }
        return -1;
    }

    public int getPracownikFromList(String nazwisko, ObservableList<Pracownik> lista_temp) {
        if (nazwisko == null) nazwisko = "none";
        nazwisko = nazwisko.split("\\s+")[0];
        for (Pracownik x : lista_temp) {
            if (nazwisko.equals(x.getNazwisko()))
                return x.getId_pracownika();
        }
        return -1;
    }

    @FXML
    public void zamowienieAddInit() throws SQLException {
        ObservableList<Klient> l_klientow = Main.DbInstance.loadKlient();
        ObservableList<Pracownik> l_pracownikow = Main.DbInstance.loadPracownik();
        ObservableList<Usluga> l_uslug = Main.DbInstance.loadUsluga();

        MenuButton menu_klient = new MenuButton("Wybierz klienta");
        MenuButton menu_pracownik = new MenuButton("Wybierz pracownika");
        MenuButton menu_usluga = new MenuButton("Wybierz usługe");

        ObservableList<String> lista = FXCollections.observableArrayList();
        ObservableList<String> lista_p = FXCollections.observableArrayList();


        for (Klient klient : l_klientow) {
            lista.add(klient.getNazwisko() + " " + klient.getImie());
            MenuItem temp = new MenuItem(klient.getNazwisko() + " " + klient.getImie());
            temp.setOnAction(e -> {
                menu_klient.setText(klient.getNazwisko() + " " + klient.getImie());
                primo = klient.getId_klienta();
            });
            menu_klient.getItems().add(temp);
        }

        for (Pracownik pracownik : l_pracownikow) {
            lista_p.add(pracownik.getNazwisko() + " " + pracownik.getImie());
            MenuItem temp = new MenuItem(pracownik.getNazwisko() + " " + pracownik.getImie());
            temp.setOnAction(e -> {
                menu_pracownik.setText(pracownik.getNazwisko() + " " + pracownik.getImie());
                secundo = pracownik.getId_pracownika();
            });
            menu_pracownik.getItems().add(temp);
        }

        for (Usluga usluga : l_uslug) {
            MenuItem temp = new MenuItem(String.valueOf(usluga.getNazwa()));
            temp.setOnAction(e -> {
                menu_usluga.setText(String.valueOf(usluga.getNazwa()));
                terzo = usluga.getId_uslugi();
            });
            menu_usluga.getItems().add(temp);
        }


        ComboBox<String> combo_klienci = new ComboBox<>(lista);
        new AutoCompleteComboBoxListener<>(combo_klienci);

        ComboBox<String> combo_pracownicy = new ComboBox<>(lista_p);
        new AutoCompleteComboBoxListener<>(combo_pracownicy);


        Label id_klienta_label = new Label("Klient");
        Label id_pracownika_label = new Label("Pracownik");
        Label id_uslugi_label = new Label("Usługa");
        Label data_zamowienia_label = new Label("Data zamówienia");
        Label data_realizacji_label = new Label("Data realizacji");
        Label zrealizowano_label = new Label("Zrealizowano");


        DatePicker data_zam_control = new DatePicker();
        data_zam_control.setEditable(false);
        DatePicker data_real_control = new DatePicker();
        data_real_control.setEditable(false);
        CheckBox zrealizowano_control = new CheckBox();

        grid_pane.add(id_klienta_label, 0, 0);
        grid_pane.add(id_pracownika_label, 0, 1);
        grid_pane.add(id_uslugi_label, 0, 2);
        grid_pane.add(data_zamowienia_label, 0, 3);
        grid_pane.add(data_realizacji_label, 0, 4);
        grid_pane.add(zrealizowano_label, 0, 5);
        grid_pane.add(combo_klienci, 1, 0);
        grid_pane.add(combo_pracownicy, 1, 1);
        grid_pane.add(menu_usluga, 1, 2);
        grid_pane.add(data_zam_control, 1, 3);
        grid_pane.add(data_real_control, 1, 4);
        grid_pane.add(zrealizowano_control, 1, 5);


        accept_button.setOnAction(e -> {
            try {
                if (checkDate(data_real_control.getValue()) && checkDate(data_zam_control.getValue()) && getKlientFromList(combo_klienci.getValue(), l_klientow) !=-1
                        && getPracownikFromList(combo_pracownicy.getValue(), l_pracownikow) != -1 && terzo != -1) {
                    Main.DbInstance.add(getKlientFromList(combo_klienci.getValue(), l_klientow), getPracownikFromList(combo_pracownicy.getValue(), l_pracownikow), terzo, Date.valueOf(data_real_control.getValue()),
                            Date.valueOf(data_zam_control.getValue()), zrealizowano_control.isSelected() ? 1 : 0);
                    root_instance.menuSetZamowienia();
                    close();
                } else {
                    if (!checkDate(data_real_control.getValue()))
                        show_error("Data realizacji jest wymagana");
                    else if (!checkDate(data_zam_control.getValue()))
                        show_error("Data zamówienia jest wymagana");
                    else
                        show_error("Uzupełnij wartości z listy rozwijanej");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    public void zamowienieEditInit(int id, int id_klienta_t, int id_pracownika_t, int id_uslugi_t, Date data_zamowienia_t, Date data_realizacji_t, int zrealizowano_t) throws SQLException {
        ObservableList<Klient> l_klientow = Main.DbInstance.loadKlient();
        ObservableList<Pracownik> l_pracownikow = Main.DbInstance.loadPracownik();
        ObservableList<Usluga> l_uslug = Main.DbInstance.loadUsluga();

        MenuButton menu_klient = new MenuButton();
        MenuButton menu_pracownik = new MenuButton();
        MenuButton menu_usluga = new MenuButton();

        ObservableList<String> lista = FXCollections.observableArrayList();
        ObservableList<String> lista_p = FXCollections.observableArrayList();

        for (Usluga usluga : l_uslug) {
            if (usluga.getId_uslugi() == id_uslugi_t)
                menu_usluga.setText(usluga.getNazwa());
        }

        for (Klient klient : l_klientow) {
            lista.add(klient.getNazwisko() + " " + klient.getImie());
            MenuItem temp = new MenuItem(klient.getNazwisko() + " " + klient.getImie());
            temp.setOnAction(e -> {
                menu_klient.setText(klient.getNazwisko() + " " + klient.getImie());
                primo = klient.getId_klienta();
            });
            menu_klient.getItems().add(temp);
        }

        for (Pracownik pracownik : l_pracownikow) {
            lista_p.add(pracownik.getNazwisko() + " " + pracownik.getImie());
            MenuItem temp = new MenuItem(pracownik.getNazwisko() + " " + pracownik.getImie());
            temp.setOnAction(e -> {
                menu_pracownik.setText(pracownik.getNazwisko() + " " + pracownik.getImie());
                secundo = pracownik.getId_pracownika();
            });
            menu_pracownik.getItems().add(temp);
        }

        for (Usluga usluga : l_uslug) {
            MenuItem temp = new MenuItem(String.valueOf(usluga.getNazwa()));
            temp.setOnAction(e -> {
                menu_usluga.setText(String.valueOf(usluga.getNazwa()));
                terzo = usluga.getId_uslugi();
            });
            menu_usluga.getItems().add(temp);
        }


        primo = id_klienta_t;
        secundo = id_pracownika_t;
        terzo = id_uslugi_t;

        for (Klient klient : l_klientow) {
            MenuItem temp = new MenuItem(klient.getNazwisko() + " " + klient.getImie());
            temp.setOnAction(e -> {
                menu_klient.setText(klient.getNazwisko() + " " + klient.getImie());
                primo = klient.getId_klienta();
            });
            menu_klient.getItems().add(temp);
        }

        for (Pracownik pracownik : l_pracownikow) {
            MenuItem temp = new MenuItem(pracownik.getNazwisko() + " " + pracownik.getImie());
            temp.setOnAction(e -> {
                menu_pracownik.setText(pracownik.getNazwisko() + " " + pracownik.getImie());
                secundo = pracownik.getId_pracownika();
            });
            menu_pracownik.getItems().add(temp);
        }

        for (Usluga usluga : l_uslug) {
            MenuItem temp = new MenuItem(usluga.getNazwa());
            temp.setOnAction(e -> {
                menu_usluga.setText(usluga.getNazwa());
                terzo = usluga.getId_uslugi();
            });
            menu_usluga.getItems().add(temp);
        }


        Label id_klienta_label = new Label("Klient");
        Label id_pracownika_label = new Label("Pracownik");
        Label id_uslugi_label = new Label("Usługa");
        Label data_zamowienia_label = new Label("Data zamówienia");
        Label data_realizacji_label = new Label("Data realizacji");
        Label zrealizowano_label = new Label("Zrealizowano");

        DatePicker data_zam_control = new DatePicker();
        data_zam_control.setEditable(false);
        DatePicker data_real_control = new DatePicker();
        data_real_control.setEditable(false);
        CheckBox zrealizowano_control = new CheckBox();

        data_zam_control.setValue(data_zamowienia_t.toLocalDate());
        data_real_control.setValue(data_realizacji_t.toLocalDate());

        zrealizowano_control.setSelected(zrealizowano_t == 1);

        ComboBox<String> combo_klienci = new ComboBox<>(lista);
        new AutoCompleteComboBoxListener<>(combo_klienci);

        ComboBox<String> combo_pracownicy = new ComboBox<>(lista_p);
        new AutoCompleteComboBoxListener<>(combo_pracownicy);

        for (Klient klient : l_klientow) {
            if (klient.getId_klienta() == id_klienta_t) {
                combo_klienci.setValue(klient.getNazwisko() + " " + klient.getImie());
            }
        }

        for (Pracownik pracownik : l_pracownikow) {
            if (pracownik.getId_pracownika() == id_pracownika_t)
                combo_pracownicy.setValue(pracownik.getNazwisko() + " " + pracownik.getImie());
        }

        grid_pane.add(id_klienta_label, 0, 0);
        grid_pane.add(id_pracownika_label, 0, 1);
        grid_pane.add(id_uslugi_label, 0, 2);
        grid_pane.add(data_zamowienia_label, 0, 3);
        grid_pane.add(data_realizacji_label, 0, 4);
        grid_pane.add(zrealizowano_label, 0, 5);
        grid_pane.add(combo_klienci, 1, 0);
        grid_pane.add(combo_pracownicy, 1, 1);
        grid_pane.add(menu_usluga, 1, 2);
        grid_pane.add(data_zam_control, 1, 3);
        grid_pane.add(data_real_control, 1, 4);
        grid_pane.add(zrealizowano_control, 1, 5);


        accept_button.setOnAction(e -> {
            try {
                if (checkDate(data_real_control.getValue()) && checkDate(data_zam_control.getValue()) && getKlientFromList(combo_klienci.getValue(), l_klientow) !=-1
                        && getPracownikFromList(combo_pracownicy.getValue(), l_pracownikow) != -1  && terzo != -1) {
                    Main.DbInstance.update(id, getKlientFromList(combo_klienci.getValue(), l_klientow), getPracownikFromList(combo_pracownicy.getValue(), l_pracownikow),
                            terzo, Date.valueOf(data_zam_control.getValue()), Date.valueOf(data_real_control.getValue()), zrealizowano_control.isSelected() ? 1 : 0);
                    root_instance.menuSetZamowienia();
                    close();
                } else {
                    if (!checkDate(data_real_control.getValue()))
                        show_error("Data realizacji jest wymagana");
                    else if (!checkDate(data_zam_control.getValue()))
                        show_error("Data zamówienia jest wymagana");
                    else
                        show_error("Uzupełnij wartości z listy rozwijanej");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    @FXML
    public void close() {
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }
}

