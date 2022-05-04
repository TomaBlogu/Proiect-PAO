package service;

import daos.EvaluareDao;
import daos.UserDao;
import entities.*;

import java.util.List;

public class UserService {
    private EvaluareDao evaluareDao;
    private UserDao userDao;

    public UserService(EvaluareDao evaluareDao, UserDao userDao) {
        this.evaluareDao = evaluareDao;
        this.userDao = userDao;
    }

    public void creareEvaluare (Evaluare evaluare){
        evaluareDao.save(evaluare);
    }

    public void stergereEvaluare (Integer idEvaluare){evaluareDao.delete(idEvaluare);}

    public void creareUser (User user){
        userDao.save(user);
    }

    public List<Evaluare> evaluari (Integer idUser){
        return evaluareDao.getEvaluari(idUser);
    }

    public void salvareAlbum (Album album,Integer idUser){userDao.addAlbumeSalvate(album,idUser);}

    public void salvareMelodie (Melodie melodie, Integer idUser){userDao.addMelodiiSalvate(melodie,idUser);}

    public void adaugareMelodiePlaylist(Playlist playlist, Melodie melodie){playlist.adaugareMelodie(melodie);}

    public void stergereMelodiePlaylist(Playlist playlist, int index){playlist.stergereMelodie(index);}

    public void sortareAlfabeticaPlaylist(Playlist playlist){playlist.getMelodii().sort((object1, object2) -> object1.getNume().compareTo(object2.getNume()));}

    public void adaugareMelodieAlbum(Album album, Melodie melodie){album.adaugareMelodie(melodie);}

}
