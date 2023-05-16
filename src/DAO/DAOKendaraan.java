/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOKendaraan;
import Helper.koneksi;
import Model.Kendaraan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public class DAOKendaraan implements IDAOKendaraan{
    public DAOKendaraan()
    {
        con = koneksi.getConnection();
    }
    
    @Override
    public List<Kendaraan> getAll() {
       List<Kendaraan> lst = null;
       try
       {
           lst = new ArrayList<Kendaraan>();
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(strread);
           while(rs.next())
           {
               Kendaraan ken = new Kendaraan();
               ken.setId_k(rs.getInt("id_k"));
               ken.setJenis(rs.getString("jenis"));
               ken.setMerek(rs.getString("merek"));
               ken.setTipe(rs.getString("tipe"));
               ken.setTahun(rs.getString("tahun"));
               ken.setNomor(rs.getString("nomor"));
               ken.setHarga(rs.getInt("harga"));
               ken.setStatus(rs.getString("status"));
               lst.add(ken);
           }
       }
       catch(SQLException e)
       {
           System.out.println("error : "+e);
       }
       return lst;
    }
    
    @Override
    public void insert(Kendaraan k) 
    {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strinsert);
            statement.setInt(1, k.getId_k());
            statement.setString(2, k.getJenis());
            statement.setString(3, k.getMerek());
            statement.setString(4, k.getTipe());
            statement.setString(5, k.getTahun());
            statement.setString(6, k.getNomor());
            statement.setInt(7, k.getHarga());
            statement.setString(8, k.getStatus());
            statement.execute();
        }catch(SQLException e)
        {
            System.out.println("gagal input ");
        }
        finally
        {
            try
            {
                statement.close();
            } catch(SQLException ex)
            {
                System.out.println("gagal input ");
            }
        }
    }
    
    Connection con;
    //SQL Query
    String strread = "select * from tblkendaraan;";
    String strinsert = "insert into tblkendaraan (id_k, jenis, merek, tipe, tahun, nomor, harga, status) values (?,?,?,?,?,?,?,?);";
}
