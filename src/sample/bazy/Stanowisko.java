package sample.bazy;

public class Stanowisko {
    int id_stanowiska;
    String nazwa;

    public Stanowisko(int id_stanowiska, String nazwa) {
        this.id_stanowiska = id_stanowiska;
        this.nazwa = nazwa;
    }

    public int getId_stanowiska() {
        return id_stanowiska;
    }

    public void setId_stanowiska(int id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Stanowisko{" +
                "id_stanowiska=" + id_stanowiska +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}

