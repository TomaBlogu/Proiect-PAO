package service;

import entities.*;

import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AuditService {
    private static String file_path = "Audit.csv";
    public static AuditService instance = null;
    public static AuditService getInstance(){
        if (instance == null)
            instance = new AuditService();
        return instance;
    }

    private AuditService() {}


    public void AuditUser(User user, String action) {
        write(user.getNume() + " " + action);
    }

    public void AuditUser(User user, Melodie melodie, String action) {
        write(user.getNume() + " " + action+" "+melodie.getNume());
    }

    public void AuditPlaylist(Playlist playlist, Melodie melodie, String action) {
        write(melodie.getNume()+" "+ action+" "+playlist.getNume());
    }

    public void AuditPlaylist(Playlist playlist, String action) {
        write(playlist.getNume()+" "+ action);
    }

    public void AuditAlbum(Album album, Melodie melodie, String action) {
        write(melodie.getNume()+" "+ action+" "+album.getNume());

    }

    public void AuditEvaluare( Evaluare evaluare, String action) {
        write("Evaluarea numarul #"+ evaluare.getIdEvaluare() + " " + action);
    }

    private void write(String action) {

        File file = new File(file_path);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Can't create audit file.");
                e.printStackTrace();
            }
        }

        try {
            OutputStream out = new FileOutputStream(file, true);

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String line = action + "," + formatter.format(date)+"\n";
            byte[] dataBytes = line.getBytes();

            out.write(dataBytes);

            out.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }


    }
}