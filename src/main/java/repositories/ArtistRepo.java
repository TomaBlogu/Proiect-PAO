package repositories;

import entities.Artist;
import service.ConexiuneBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepo {
    public ArtistRepo(boolean initDB) {
        if (initDB) {
            try {
                Connection con = ConexiuneBD.getConnection();

                String createTable = "create table if not exists artist(" +
                        "   id int primary key auto_increment," +
                        "   nume varchar(30) not null," +
                        "   genMuzical varchar(30) not null" +
                        ");";
                con.createStatement().executeUpdate(createTable);

                String deleteAll = "delete from artist;";
                con.createStatement().executeUpdate(deleteAll);

                String insertStmt = "insert into artist(nume,genMuzical)" +
                        " values ('Logic','Hip-Hop');";
                con.createStatement().executeUpdate(insertStmt);

                insertStmt = "insert into artist(nume,genMuzical)" +
                        " values ('Alt-J','Alt Rock');";
                con.createStatement().executeUpdate(insertStmt);
            }
            catch (SQLException e) {
                System.out.println("Unable to execute SQL statements");
            }
        }
    }

    public List<Artist> getAll() {
        List<Artist> artisti = new ArrayList<>();

        try {
            Connection con = ConexiuneBD.getConnection();

            String selectSql = "select * from artist;";
            ResultSet resultSet = con.createStatement().executeQuery(selectSql);

            while (resultSet.next()) {
                Artist artist = new Artist();
                  artist.setNume(resultSet.getString("nume"));
                  artist.setGenMuzical(resultSet.getString("genMuzical"));
                  artist.setIdArtist(resultSet.getInt("id"));
                artisti.add(artist);
            }
        }
        catch (SQLException e) {
            System.out.println("Unable to execute SQL statements");
        }

        return artisti;
    }

    public Artist getById(Integer id) {
        Artist artist = null;

        try {
            Connection con = ConexiuneBD.getConnection();

            String selectSql = "select * from artist where id=" + id + ";";
            ResultSet resultSet = con.createStatement().executeQuery(selectSql);

            if (resultSet.next()) {
                artist = new Artist();
                artist.setNume(resultSet.getString("nume"));
                artist.setGenMuzical(resultSet.getString("genMuzical"));
                artist.setIdArtist(resultSet.getInt("id"));
            }
        }
        catch (SQLException e) {
            System.out.println("Unable to execute SQL statements");
        }

        return artist;
    }

    public void insertArtist(Artist artist) {
        try {
            Connection con = ConexiuneBD.getConnection();

            String insertSql = "insert into artist(nume,genMuzical) " +
                    " values(?,?);";
            PreparedStatement prep = con.prepareStatement(insertSql);
            prep.setString(1,artist.getNume());
            prep.setString(2,artist.getGenMuzical());

            prep.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Unable to execute SQL statements");
        }
    }

    public void updateArtist(Artist artist) {
        try {
            Connection con = ConexiuneBD.getConnection();

            String updateSql = "update artist set" +
                    "   id=?," +
                    "   nume=?," +
                    "   genMuzical=?" +
                    "   where id=?;";

            PreparedStatement prep = con.prepareStatement(updateSql);

            prep.setInt(1, artist.getIdArtist());
            prep.setString(2,artist.getNume());
            prep.setString(3,artist.getGenMuzical());
            prep.setInt(4, artist.getIdArtist());

            prep.executeUpdate();

        }
        catch (SQLException e) {
            System.out.println("Unable to execute SQL statements");
        }
    }

    public void deleteById(Integer id) {
        try {
            Connection con = ConexiuneBD.getConnection();

            String deleteSql = "delete from artist where id=?;";
            PreparedStatement prep = con.prepareStatement(deleteSql);

            prep.setInt(1, id);

            prep.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Unable to execute SQL statements");
        }
    }
}
