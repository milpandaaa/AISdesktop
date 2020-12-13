package ru.itmo.app;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private final static String dbHost = "localhost";
    private final static String dbPost = "3306";
    private final static String dbUser = "root";
    private final static String dbPass = "1234";
    private final static String dbName = "pp";
    private final static String filePath = "C:\\Users\\milpa\\IdeaProjects\\pract\\dump";

    public DatabaseConnection() throws SQLException {
        try {
            String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPost + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    static public String dump(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        File file = new File(filePath, dtf.format(now) +".sql");
        return "mysqldump -u "+dbUser+" -p"+dbPass+" "+dbName+" -r "+file;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

}
