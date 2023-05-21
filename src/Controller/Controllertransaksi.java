/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOTransaksi;

import DAOInterface.IDAOTransaksi;


import Model.TabelModelTransaksi;
import Model.Transaksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import view.FormTransaksi;



/**
 *
 * @author LENOVO
 */
public class Controllertransaksi {
    
    public Controllertransaksi(FormTransaksi frmTransaksi)
    {
        this.frmTransaksi = frmTransaksi;
        
        iTransaksi = new DAOTransaksi();
        
        
    }
    
    public void isiTable()
    {
        ls = iTransaksi.getAll();
        TabelModelTransaksi tabeltr = new TabelModelTransaksi(ls);
        frmTransaksi.getTableTransaksi().setModel(tabeltr);
    }
    
    public void insert()
    {
        
        Transaksi t = new Transaksi();
        t.setId_t(Integer.parseInt(frmTransaksi.gettxtID_t().getText()));
        t.setPeminjam(frmTransaksi.gettxtPeminjam().getText());
        t.setNo_telp(frmTransaksi.gettxtNo().getText());
        t.setTipe(frmTransaksi.gettxtTipe().getText());
        t.setId_k(Integer.parseInt(frmTransaksi.setId_k().getSelectedItem().toString()));
        t.setHari(Integer.parseInt(frmTransaksi.setHari().getSelectedItem().toString()));
        t.setTotal(Integer.parseInt(frmTransaksi.gettxtTotal().getText()));
        
        t.setStatus(frmTransaksi.setStatus().getSelectedItem().toString());
        iTransaksi.insert(t);
        JOptionPane.showMessageDialog(null, "input berhasil");
    }
    
    public void reset()
    {
        if(!frmTransaksi.gettxtID_t().isEnabled())
        {
            frmTransaksi.gettxtID_t().setEnabled(true);
        }
        frmTransaksi.gettxtID_t().setText("");
        frmTransaksi.gettxtPeminjam().setText("");
        frmTransaksi.gettxtNo().setText("");
        frmTransaksi.gettxtTipe().setText("");
        frmTransaksi.setId_k().setSelectedItem("");
        frmTransaksi.setHari().setSelectedItem("1");
        frmTransaksi.gettxtTotal().setText("");
        frmTransaksi.setStatus().setSelectedItem("Proses");
        
    }
    
    
    
    FormTransaksi frmTransaksi;
    IDAOTransaksi iTransaksi;
    List<Transaksi> ls;
    

    
}
