package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection(){
        if(connection == null){
            try {
                Properties properties = loadProperties();
                String url = properties.getProperty("dburl");
                connection = DriverManager.getConnection(url,properties);

            }

            catch (SQLException sqlException){
                throw new DbException(sqlException.getMessage());

            }
        }
        return connection;
    }


  public static void closeConnection(){
        if (connection != null){
            try {
                connection.close();
            }
            catch (SQLException sqlException){
                throw new DbException(sqlException.getMessage());

            }

        }
  }


  public static Properties loadProperties(){
        try (FileInputStream fileInputStream = new FileInputStream("db.properties")){
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        }
        catch (IOException ioException){
            throw new DbException(ioException.getMessage());
        }
  }

  public static void closeStatement(Statement statement){
        if(statement != null){
            try{
                statement.close();
            }
            catch (SQLException sqlException){
                throw new DbException(sqlException.getMessage());
            }

        }
  }

  public static void closeResult(ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            }
            catch (SQLException sqlException){
                throw  new DbException(sqlException.getMessage());
            }

        }
  }

}
