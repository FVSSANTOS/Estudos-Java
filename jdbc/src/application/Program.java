package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class Program {
    public static void main(String[] args) throws Exception {


        //Transações
        Connection conn = null;
        Statement st = null;
        try{
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rowns1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            int rowns2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
            
            conn.commit();

            System.out.println("rowns1"+ rowns1);
            System.out.println("rowns2"+rowns2);
        }
        catch(SQLException e){
            try {
                conn.rollback();
                throw new DbException("Transaction roller back! Caused by:"+ e.getMessage());               
            } catch (SQLException el) {
                throw new DbException("Error trying to rollback! Cause by:"+el.getMessage());
            }
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }




        //Deletar dados
        /*
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = DB.getConnection();
            
            st = conn.prepareStatement(
                "DELETE FROM department"
                +"WHERE "
                +"Id = ?"
            );

            st.setInt(1, 2);
            
            int rowsAffected = st.executeUpdate();
            
            System.out.println("Done! Rows affected: "+rowsAffected);
        }
        catch(SQLException e){
            throw new DbIntegrityException(e.getMessage());
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }

        //Atualizar dados
        /*  
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = DB.getConnection();
            
            st = conn.prepareStatement(
                "UPDATE seller "
                +"SET BaseSalary = BaseSalary + ? "
                +"WHERE "
                +"DepartmentId = ?"
                );
                
                st.setDouble(1, 200.0);
                st.setInt(2, 2);
                
                int rowsAffected = st.executeUpdate();
                
                System.out.println("Done! Rows affected: "+rowsAffected);
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            finally{
                DB.closeStatement(st);
                DB.closeConnection();
            }
            */
        
            
        //Inserir dados
        /*     
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = DB.getConnection();
            
            st = conn.prepareStatement(
                "INSERT INTO seller "
                +"(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                +"VALUES "
                +"(?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, "Carl Purple");
            st.setString(2, "carl@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);
            
            int rowsAffected = st.executeUpdate();
            
            if(rowsAffected > 0){
            ResultSet rs = st.getGeneratedKeys();
            while(rs.next()){
                int id = rs.getInt(1);
                System.out.println("Done! Id = "+id);
            }
        }
        else{
            System.out.println("No rown affected");
        }
    }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    */
    


        //Recuperar dados usando Statement e ResultSet
        /* 
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        
        try{
            conn =  DB.getConnection();
            
            st = conn.createStatement();
            
            rs = st.executeQuery("SELECT * FROM department");
            
            while(rs.next()){
                System.out.println(rs.getInt("Id") + ", "+ rs.getString("Name"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            DB.closeResultSet(rs);;
            DB.closeStatement(st);
            DB.closeConnection();
        }
        */ 
    }
}
