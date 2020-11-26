package sample.bazy;

public class Usluga {
    int id_uslugi;
    String nazwa;
    float cena;

    public Usluga(int id_uslugi, String nazwa, float cena) {
        this.id_uslugi = id_uslugi;
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public int getId_uslugi() {
        return id_uslugi;
    }

    public void setId_uslugi(int id_uslugi) {
        this.id_uslugi = id_uslugi;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    @Override
    public String   toString() {
        return "Usluga{" +
                "id_uslugi=" + id_uslugi +
                ", nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                '}';
    }
}
