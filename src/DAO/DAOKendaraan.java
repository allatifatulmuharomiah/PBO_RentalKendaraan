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
    
    
    Connection con;
    //SQL Query
    String strread = "select * from tblkendaraan;";
}
