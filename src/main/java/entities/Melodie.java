package entities;

public class Melodie {
    private String nume;
    private Integer idArtist;
    private Integer durata;
    private Integer idMelodie;

    public Melodie(String nume, Integer idArtist, Integer durata, Integer idMelodie) {
        this.nume = nume;
        this.idArtist = idArtist;
        this.durata = durata;
        this.idMelodie = idMelodie;
    }

    public Melodie() {
    }

    public Integer getIdMelodie() {
        return idMelodie;
    }

    public String getNume() {
        return nume;
    }

    public Integer getIdArtist() {
        return idArtist;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    public void setIdArtist(Integer idArtist) {
        this.idArtist = idArtist;
    }

    public void setIdMelodie(Integer idMelodie) {
        this.idMelodie = idMelodie;
    }

    @Override
    public String toString() {
        return "Melodie{" +
                "nume='" + nume + '\'' +
                ", idArtist=" + idArtist +
                ", durata=" + durata +
                ", idMelodie=" + idMelodie +
                '}';
    }
}
