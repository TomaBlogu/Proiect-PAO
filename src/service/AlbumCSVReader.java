package service;

import entities.Album;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlbumCSVReader {
 /*   public static AlbumCSVReader instance = null;
    final private List<Album> albume = new ArrayList<>();

    private AlbumCSVReader(){}

    public static AlbumCSVReader getInstance(){
        if(instance == null)
            instance = new AlbumCSVReader();
        return instance;
    }

    public List<Album> readFromCSV(String file) throws IOException {
        BufferedReader data = new BufferedReader(new FileReader(file));
        String line;

        while((line =  data.readLine()) != null){
            String [] Informatii = line.split(",");
            Album album = new Album(Informatii[0], Informatii[1], Integer.parseInt(Informatii[2]));
            this.albume.add(album);
        }

        return this.albume;
    }*/
}
