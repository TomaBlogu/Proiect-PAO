package service;

import daos.EvaluareDao;
import daos.UserDao;
import entities.*;

import java.util.List;

public class UserService {
    private EvaluareDao evaluareDao;
    private UserDao userDao;
    private AuditService auditService = AuditService.getInstance();
    public UserService(EvaluareDao evaluareDao, UserDao userDao) {
        this.evaluareDao = evaluareDao;
        this.userDao = userDao;
    }

    public void creareEvaluare (Evaluare evaluare){
        evaluareDao.save(evaluare);
        auditService.AuditEvaluare(evaluare, "a fost creata");

    }

    public void stergereEvaluare (Evaluare evaluare){
        evaluareDao.delete(evaluare.getIdEvaluare());
        auditService.AuditEvaluare(evaluare, "a fost stearsa");
    }

    public void creareUser (User user){
        userDao.save(user);
        auditService.AuditUser(user, "a fost creat");
    }

    public List<Evaluare> evaluari (User user){
        auditService.AuditUser(user, "si-a listat evaluarile");
        return evaluareDao.getEvaluari(user.getIdUser());
    }

    public void salvareAlbum (Album album,Integer idUser){userDao.addAlbumeSalvate(album,idUser);}

    public void salvareMelodie (Melodie melodie, User user){
        userDao.addMelodiiSalvate(melodie,user.getIdUser());
        auditService.AuditUser(user, melodie, "a salvat melodia");
    }

    public void adaugareMelodiePlaylist(Playlist playlist, Melodie melodie){
        playlist.adaugareMelodie(melodie);
        auditService.AuditPlaylist(playlist, melodie, "a fost adaugata in playlist-ul");
    }

    public void stergereMelodiePlaylist(Playlist playlist, Melodie melodie){
        auditService.AuditPlaylist(playlist, melodie, "a fost stearsa din playlist-ul");
        playlist.stergereMelodie(melodie);
    }

    public void sortareAlfabeticaPlaylist(Playlist playlist){
        playlist.getMelodii().sort((object1, object2) -> object1.getNume().compareTo(object2.getNume()));
        auditService.AuditPlaylist(playlist, "a fost sortata");

    }

    public void adaugareMelodieAlbum(
            Album album, Melodie melodie){album.adaugareMelodie(melodie);
        auditService.AuditAlbum(album, melodie, "a fost adaugata in albumul");
    }

}
