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

public class DAOKendaraan implements IDAOKendaraan {
    public DAOKendaraan() {
        con = koneksi.getConnection();
    }
    
    @Override
    public List<Kendaraan> getAll() {
        List<Kendaraan> lst = null;
        try {
            lst = new ArrayList<Kendaraan>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strread);
            while (rs.next()) {
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
        } catch (SQLException e) {
            System.out.println("error : " + e);
        }
        return lst;
    }
    
    @Override
    public void insert(Kendaraan k) {
        PreparedStatement statement = null;
        try {
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
        } catch (SQLException e) {
            System.out.println("gagal input");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal input");
            }
        }
    }
    
    @Override
    public void update(Kendaraan k) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strupdate);
            statement.setString(1, k.getJenis());
            statement.setString(2, k.getTipe());
            statement.setString(3, k.getMerek());
            statement.setString(4, k.getTahun());
            statement.setString(5, k.getNomor());
            statement.setInt(6, k.getHarga());
            statement.setString(7, k.getStatus());
            statement.setInt(8, k.getId_k());
            statement.execute();

            // ...
        } catch (SQLException e) {
            System.out.println("gagal update");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal update");
            }
        }
    }
    
    @Override
    public void delete(int Id_k) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strdelete);
            statement.setInt(1, Id_k);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("gagal delete");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal delete");
            }
        }
    }
    
    @Override
    public List<Kendaraan> getAllByName(String tipe) {
       List<Kendaraan> lst = null;
        try {
            lst = new ArrayList<Kendaraan>();
            PreparedStatement st = con.prepareStatement(strsearch);
            st.setString(1,"%"+tipe+"%" );
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
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
        } catch (SQLException e) {
            System.out.println("error : " + e);
        }
        return lst;
    }
    
   
    Connection con;
    // SQL Query
    String strread = "select * from tblkendaraan;";
    String strinsert = "insert into tblkendaraan (id_k, jenis, merek, tipe, tahun, nomor, harga, status) values (?,?,?,?,?,?,?,?);";
    String strupdate = "update `tblkendaraan` set `jenis`=?, `tipe`=?, `merek`=?, `tahun`=?, `nomor`=?, `harga`=?, `status`=? where `id_k` = ?";
    String strdelete = "delete from `tblkendaraan` where `id_k` =?";
    String strsearch = "select * from `tblkendaraan` where `tipe` like ?;";

    
    }

    