import daos.EvaluareDao;
import daos.UserDao;
import entities.*;
import service.CSVWriteService;
import service.UserService;

import java.io.IOException;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {


        User user1 = new User("Toma01","Hello, welcome to my profile!",1);
        UserDao userDao = new UserDao(new TreeMap<>());
        EvaluareDao evaluareDao = new EvaluareDao(new TreeMap<>());
        UserService userService = new UserService(evaluareDao,userDao);

        Artist artist1 = new Artist("Logic","Hip-Hop",1);
        Album album1 = new Album("No pressure", artist1 ,1);
        Melodie melodie1 = new Melodie("Celebration",1,120, 1);
        Melodie melodie2 = new Melodie("Perfect",1,202, 2);
        Melodie melodie3 = new Melodie("A2Z",1,180, 3);
        Playlist playlist1 = new Playlist("Workout",user1);
        Evaluare evaluare1, evaluare2;
        evaluare1 = new EvaluareAlbum(user1,1,album1,6,8);
        evaluare2 = new EvaluareMelodie(user1,2,melodie1,8,9);


        userService.creareUser(user1);
        userService.creareEvaluare(evaluare1);
        userService.creareEvaluare(evaluare2);
        userService.adaugareMelodieAlbum(album1, melodie1);
        userService.salvareAlbum(album1,user1.getIdUser());
        userService.salvareMelodie(melodie1,user1);
        userService.adaugareMelodiePlaylist(playlist1, melodie1);
        userService.adaugareMelodiePlaylist(playlist1, melodie3);
        System.out.println(userService.evaluari(user1));
        userService.sortareAlfabeticaPlaylist(playlist1);
        System.out.println(playlist1);

        CSVWriteService writer = CSVWriteService.getInstance();
        writer.write(Album.class, album1, "albume.csv");
        writer.write(Artist.class, artist1, "artisti.csv");
        writer.write(Melodie.class, melodie1, "melodii.csv");
        writer.write(Playlist.class, playlist1, "playlists.csv");
    }

}
