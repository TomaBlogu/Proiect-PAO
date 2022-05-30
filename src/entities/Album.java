package entities;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String nume;
    private Artist artist;
    private Integer idAlbum;
    private List<Melodie> melodii = new ArrayList<>();

    public Album(String nume, Artist artist, Integer idAlbum) {
        this.nume = nume;
        this.artist = artist;
        this.idAlbum = idAlbum;
    }

    public String getNume() {
        return nume;
    }

    public Artist getArtist() {
        return artist;
    }

    public List<Melodie> getMelodii() {
        return melodii;
    }

    public void adaugareMelodie(Melodie melodie){
        melodii.add(melodie);
    }

    @Override
    public String toString() {
        return "Album{" +
                "nume='" + nume + '\'' +
                ", artist=" + artist +
                ", idAlbum=" + idAlbum +
                ", melodii=" + melodii +
                '}';
    }

}
