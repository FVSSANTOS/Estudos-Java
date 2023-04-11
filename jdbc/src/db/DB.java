package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
<<<<<<< HEAD
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

=======
import java.sql.SQLException;
import java.util.Properties;

public class DB {
    
>>>>>>> 6a57770123dfb98647d72bc7ec05d0686ba64b83
    private static Connection conn = null;

    public static Connection getConnection(){
        if(conn == null){
            try{
<<<<<<< HEAD
            Properties props = loadProperties();
            String url = props.getProperty("dburl");
            conn = DriverManager.getConnection(url, props);
            }
            catch(SQLException e){
             throw new DbException(e.getMessage());
            }
        } 
=======
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            }
             catch(SQLException e){
                throw new DbException(e.getMessage());
             }   
        }
>>>>>>> 6a57770123dfb98647d72bc7ec05d0686ba64b83
        return conn;
    }

    public static void closeConnection(){
        if(conn != null){
            try{
                conn.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
<<<<<<< HEAD
    
=======

>>>>>>> 6a57770123dfb98647d72bc7ec05d0686ba64b83
    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
<<<<<<< HEAD
        }
=======
        } 
>>>>>>> 6a57770123dfb98647d72bc7ec05d0686ba64b83
        catch(IOException e){
            throw new DbException(e.getMessage());
        }
    }
<<<<<<< HEAD

    public static void closeStatement(Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
               throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
               throw new DbException(e.getMessage());
            }
        }
    }
=======
>>>>>>> 6a57770123dfb98647d72bc7ec05d0686ba64b83
}
