package sample.bazy;

public class Klient {
    int idklienta;
    String nazwisko;
    String imie;
    String nazwa_firmy;
    String miasto;
    String ulica_nr_domu;

    public Klient(int idklienta, String nazwisko, String imie, String nazwa_firmy, String miasto, String ulica_nr_domu) {
        this.idklienta = idklienta;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.nazwa_firmy = nazwa_firmy;
        this.miasto = miasto;
        this.ulica_nr_domu = ulica_nr_domu;
    }

    public int getIdklienta() {
        return idklienta;
    }

    public void setIdklienta(int idklienta) {
        this.idklienta = idklienta;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwa_firmy() {
        return nazwa_firmy;
    }

    public void setNazwa_firmy(String nazwa_firmy) {
        this.nazwa_firmy = nazwa_firmy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica_nr_domu() {
        return ulica_nr_domu;
    }

    public void setUlica_nr_domu(String ulica_nr_domu) {
        this.ulica_nr_domu = ulica_nr_domu;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "idklienta=" + idklienta +
                ", nazwisko='" + nazwisko + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwa_firmy='" + nazwa_firmy + '\'' +
                ", miasto='" + miasto + '\'' +
                ", ulica_nr_domu='" + ulica_nr_domu + '\'' +
                '}';
    }
}
