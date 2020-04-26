package Loginpage; 







import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zolana
 */
public class MyConnection {
    
        private static final   String servername = "localhost"; 
        private static final   String username = "root";
        private static final  String dbname = "user_db";
        private static final  Integer portnumber = 3306;
        private static final String password = "";
        
    
    public static Connection getConnection (){
        
        Connection con = null;
        
        
      MysqlDataSource datasource = new MysqlDataSource(); 
      
      datasource.setServerName(servername);
      datasource.setUser(username);
      datasource.setPassword(password);
      datasource.setDatabaseName(dbname);
      datasource.setPortNumber(portnumber);
      
            try {
                con  = datasource.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        return con;
    }
    
    
    
}
