package mule.model;

/**
 * Created by ryyanj on 11/21/15.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {


    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void saveDataBase(Game game) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://162.243.230.25:3306/Mule?"
                            + "user=stevej&password=chublove_88");
            // Statements allow to issue SQL queries to the database
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(game);
            byte[] gameAsBytes = baos.toByteArray();
            statement = connect.createStatement();

            String sql = "Delete From Mule.SerialNumber";

            statement.execute(sql);
            // Result set get the result of the SQL query
//            resultSet = statement
//                    .executeQuery("INSERT into Mule.SerialNumber values(4)");
//            //writeResultSet(resultSet);
//
//            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("insert into  Mule.SerialNumber values (?)");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1
            ByteArrayInputStream bais = new ByteArrayInputStream(gameAsBytes);
            preparedStatement.setBinaryStream(1, bais, gameAsBytes.length);

              preparedStatement.executeUpdate();


        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    public Game readDataBase() throws Exception {
        // ResultSet is initially before the first data set
        Game game = null;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://162.243.230.25:3306/Mule?"
                            + "user=stevej&password=chublove_88");
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            String sql = "Select * From Mule.SerialNumber";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                //System.out.println(resultSet.getString("serialNumber"));
                byte[] st = (byte[]) resultSet.getObject(1);
                ByteArrayInputStream baip = new ByteArrayInputStream(st);
                ObjectInputStream ois = new ObjectInputStream(baip);
                game = (Game) ois.readObject();
            }
            return game;

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }




}
