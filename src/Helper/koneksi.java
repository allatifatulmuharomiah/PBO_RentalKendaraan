/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author LENOVO
 */
public class koneksi {
    static Connection con;
    
    public static Connection getConnection()
    {
        if(con == null)
        {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_rental");
            data.setUser("root");
            data.setPassword("");
            try
            {
                con = data.getConnection();
                System.out.println("berhasil connect");
            }catch(SQLException e)
            {
                System.out.println("tidk connect");
            }
                
        }
        return con;
    }
}
