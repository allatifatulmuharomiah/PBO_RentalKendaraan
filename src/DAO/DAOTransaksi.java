/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOTransaksi;
import Helper.koneksi;
import Model.Transaksi;

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
public class DAOTransaksi implements IDAOTransaksi{
    
    public DAOTransaksi() {
        con = koneksi.getConnection();
    }
    
    public List<Transaksi> getAll() {
        List<Transaksi> ls = null;
        try {
            ls = new ArrayList<Transaksi>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strread);
            while (rs.next()) {
                Transaksi tr = new Transaksi();
                tr.setId_t(rs.getInt("id_t"));
                tr.setPeminjam(rs.getString("peminjam"));
                tr.setNo_telp(rs.getString("no_telp"));
                tr.setTipe(rs.getString("tipe"));
                tr.setId_k(rs.getInt("id_k"));
                tr.setHari(rs.getInt("hari"));
                tr.setTotal(rs.getInt("total"));
                tr.setStatus(rs.getString("status"));
                ls.add(tr);
            }
        } catch (SQLException e) {
            System.out.println("error : " + e);
        }
        return ls;
    }
    
    @Override
    public void insert(Transaksi t) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(strinsert);
            statement.setInt(1, t.getId_t());
            statement.setString(2, t.getPeminjam());
            statement.setString(3, t.getNo_telp());
            statement.setString(4, t.getTipe());
            statement.setInt(5, t.getId_k());
            statement.setInt(6, t.getHari());
            statement.setInt(7, t.getTotal());
            statement.setString(8, t.getStatus());
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
    
    Connection con;
    
    String strread = "select * from tbltransaksi;";
    String strinsert = "insert into tbltransaksi (id_t, peminjam, no_telp, tipe, id_k, hari, total, status) values (?,?,?,?,?,?,?,?);";
    
}
