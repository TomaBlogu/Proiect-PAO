package entities;

public class Artist {
    private String nume;
    private String genMuzical;
    private Integer idArtist;

    public Artist(String nume, String genMuzical, Integer idArtist) {
        this.nume = nume;
        this.genMuzical = genMuzical;
        this.idArtist = idArtist;
    }

    public Artist() {
    }

    public String getNume() {
        return nume;
    }

    public String getGenMuzical() {
        return genMuzical;
    }

    public Integer getIdArtist() {
        return idArtist;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setGenMuzical(String genMuzical) {
        this.genMuzical = genMuzical;
    }

    public void setIdArtist(Integer idArtist) {
        this.idArtist = idArtist;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "nume='" + nume + '\'' +
                ", genMuzical='" + genMuzical + '\'' +
                ", idArtist=" + idArtist +
                '}';
    }
}
