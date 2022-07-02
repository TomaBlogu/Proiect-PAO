package entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Playlist {
    private String nume;
    private User user;
    private List<Melodie> melodii = new ArrayList<>();

    public Playlist(String nume, User user) {
        this.nume = nume;
        this.user = user;
    }

    public String getNume() {
        return nume;
    }


    public void adaugareMelodie(Melodie melodie){
        melodii.add(melodie);
    }

    public void stergereMelodie(Melodie melodie){melodii.remove(melodie);}

    public void sortareAlfabetica(){
        melodii.sort(Comparator.comparing(Melodie::getNume));
    }

    public List<Melodie> getMelodii() {
        return melodii;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "nume='" + nume + '\'' +
                ", user=" + user +
                ", melodii=" + melodii +
                '}';
    }
}
