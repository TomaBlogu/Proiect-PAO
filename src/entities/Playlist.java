package entities;

import java.util.ArrayList;

public class Playlist {
    private String nume;
    private User user;
    private ArrayList<Melodie> melodii = new ArrayList<Melodie>();

    public Playlist(String nume, User user) {
        this.nume = nume;
        this.user = user;
    }

    public void adaugareMelodie(Melodie melodie){
        melodii.add(melodie);
    }

    public void stergereMelodie(int index){melodii.remove(index);}

    public void sortareAlfabetica(){
        melodii.sort((object1, object2) -> object1.getNume().compareTo(object2.getNume()));
    }

    public ArrayList<Melodie> getMelodii() {
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
