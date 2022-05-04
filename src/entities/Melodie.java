package entities;

public class Melodie {
    private String nume;
    private Artist artist;
    private Integer durata;
    private Integer idMelodie;

    public Melodie(String nume, Artist artist, Integer durata, Integer idMelodie) {
        this.nume = nume;
        this.artist = artist;
        this.durata = durata;
        this.idMelodie = idMelodie;
    }

    public String getNume() {
        return nume;
    }

    public Artist getArtist() {
        return artist;
    }

    public Integer getDurata() {
        return durata;
    }

    @Override
    public String toString() {
        return "Melodie{" +
                "nume='" + nume + '\'' +
                ", artist=" + artist +
                ", durata=" + durata +
                ", idMelodie=" + idMelodie +
                '}';
    }
}
