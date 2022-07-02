package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexiuneBD {
    private static final String url = "jdbc:mysql://localhost:3306/proiectPAO";
    private static final String user = "toma";
    private static final String pass = "Parola123!";
    private static Connection con = null ;

    private static void initConnection() throws SQLException {
        con = DriverManager
                .getConnection(ConexiuneBD.getUrl(),
                        ConexiuneBD.getUser(), ConexiuneBD.getPass());
    }

    public static Connection getConnection() throws SQLException {
        if (con == null) {
            initConnection();
        }
        return con;
    }

    public static String getUrl() { return url; }
    public static String getUser() { return user; }
    public static String getPass() { return pass; }

    public static void close() throws SQLException {
        con.close();
    }
}
