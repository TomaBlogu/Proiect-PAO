package repositories;

import entities.Melodie;
import service.ConexiuneBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MelodieRepo {
    public MelodieRepo(boolean initDB) {
        if (initDB) {
            try {
                Connection con = ConexiuneBD.getConnection();

                String createTable = "create table if not exists melodie(" +
                        "   id int primary key auto_increment," +
                        "   nume varchar(30) not null," +
                        "   durata int," +
                        "   id_artist int foreign key references artist(id)" +
                        ");";
                con.createStatement().executeUpdate(createTable);

                String deleteAll = "delete from melodie;";
                con.createStatement().executeUpdate(deleteAll);

                String insertStmt = "insert into melodie(nume,durata,id_artist)" +
                        " values ('Perfect','122','1');";
                con.createStatement().executeUpdate(insertStmt);

                insertStmt = "insert into artist(nume,durata,id_artist)" +
                        " values ('Nara','310','2');";
                con.createStatement().executeUpdate(insertStmt);
            }
            catch (SQLException e) {
                System.out.println("Unable to execute SQL statements");
            }
        }
    }

    public List<Melodie> getAll() {
        List<Melodie> melodii = new ArrayList<>();

        try {
            Connection con = ConexiuneBD.getConnection();

            String selectSql = "select * from melodie;";
            ResultSet resultSet = con.createStatement().executeQuery(selectSql);

            while (resultSet.next()) {
                Melodie melodie = new Melodie();
                melodie.setNume(resultSet.getString("nume"));
                melodie.setDurata(resultSet.getInt("durata"));
                melodie.setIdMelodie(resultSet.getInt("id"));
                melodie.setIdArtist(resultSet.getInt("id_artist"));
                melodii.add(melodie);
            }
        }
        catch (SQLException e) {
            System.out.println("Unable to execute SQL statements");
        }

        return melodii;
    }

    public Melodie getById(Integer id) {
        Melodie melodie = null;

        try {
            Connection con = ConexiuneBD.getConnection();

            String selectSql = "select * from melodie where id=" + id + ";";
            ResultSet resultSet = con.createStatement().executeQuery(selectSql);

            if (resultSet.next()) {
                melodie = new Melodie();
                melodie.setNume(resultSet.getString("nume"));
                melodie.setDurata(resultSet.getInt("durata"));
                melodie.setIdMelodie(resultSet.getInt("id"));
                melodie.setIdArtist(resultSet.getInt("id_artist"));
            }
        }
        catch (SQLException e) {
            System.out.println("Unable to execute SQL statements");
        }

        return melodie;
    }

    public void insertMelodie(Melodie melodie) {
        try {
            Connection con = ConexiuneBD.getConnection();

            String insertSql = "insert into melodie(nume,durata,id_artist) " +
                    " values(?,?,?);";
            PreparedStatement prep = con.prepareStatement(insertSql);
            prep.setString(1,melodie.getNume());
            prep.setInt(2,melodie.getDurata());
            prep.setInt(3,melodie.getIdArtist());

            prep.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Unable to execute SQL statements");
        }
    }

    public void updateMelodie(Melodie melodie) {
        try {
            Connection con = ConexiuneBD.getConnection();

            String updateSql = "update melodie set" +
                    "   id=?," +
                    "   nume=?," +
                    "   durata=?" +
                    "   id_artist=?" +
                    "   where id=?;";

            PreparedStatement prep = con.prepareStatement(updateSql);

            prep.setInt(1, melodie.getIdMelodie());
            prep.setString(2,melodie.getNume());
            prep.setInt(3,melodie.getDurata());
            prep.setInt(4, melodie.getIdArtist());
            prep.setInt(5, melodie.getIdMelodie());

            prep.executeUpdate();

        }
        catch (SQLException e) {
            System.out.println("Unable to execute SQL statements");
        }
    }

    public void deleteById(Integer id) {
        try {
            Connection con = ConexiuneBD.getConnection();

            String deleteSql = "delete from melodie where id=?;";
            PreparedStatement prep = con.prepareStatement(deleteSql);

            prep.setInt(1, id);

            prep.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println("Unable to execute SQL statements");
        }
    }
}