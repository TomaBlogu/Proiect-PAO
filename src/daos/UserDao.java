package daos;

import entities.Album;
import entities.Evaluare;
import entities.Melodie;
import entities.User;

import java.util.Map;

public class UserDao {
    private Map<Integer, User> userDB;

    public UserDao(Map<Integer, User> userDB) {
        this.userDB = userDB;
    }

    public void save (User user){
        userDB.put(user.getIdUser(),user);
    }

    public void addAlbumeSalvate(Album album,Integer id){userDB.get(id).getAlbumeSalvate().add(album);}

    public void addMelodiiSalvate(Melodie melodie, Integer id){userDB.get(id).getMelodiiSalvate().add(melodie);}
}
