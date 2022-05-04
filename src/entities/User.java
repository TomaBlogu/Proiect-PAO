package entities;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer idUser;
    private String nume;
    private String bio;
    private List<Album> albumeSalvate;
    private List<Melodie> melodiiSalvate;

    public User(String nume, String bio, Integer idUser) {
        this.idUser = idUser;
        this.nume = nume;
        this.bio = bio;
        this.albumeSalvate = new ArrayList<>();
        this.melodiiSalvate = new ArrayList<>();
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getNume() {
        return nume;
    }

    public String getBio() {
        return bio;
    }

    public List<Album> getAlbumeSalvate() {
        return albumeSalvate;
    }

    public List<Melodie> getMelodiiSalvate() {
        return melodiiSalvate;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", nume='" + nume + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
