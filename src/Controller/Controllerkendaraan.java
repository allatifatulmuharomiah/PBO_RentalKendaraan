/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOKendaraan;
import DAOInterface.IDAOKendaraan;
import Model.Kendaraan;
import Model.TabelModelKendaraan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import view.FormKendaraan;
/**
 *
 * @author LENOVO
 */
public class Controllerkendaraan {
    
    public Controllerkendaraan(FormKendaraan frmKendaraan)
    {
        this.frmKendaraan = frmKendaraan;
        
        iKendaraan = new DAOKendaraan();
        
    }
    
    public void isiTable()
    {
        lst = iKendaraan.getAll();
        TabelModelKendaraan tabelken = new TabelModelKendaraan(lst);
        frmKendaraan.getTableKendaraan().setModel(tabelken);
    }
    
    public void insert()
    {
        Kendaraan k = new Kendaraan();
        k.setId_k(Integer.parseInt(frmKendaraan.gettxtID_k().getText()));
        k.setJenis(frmKendaraan.setJenis().getSelectedItem().toString());
        k.setMerek(frmKendaraan.gettxtMerek().getText());
        k.setTipe(frmKendaraan.gettxtTipe().getText());
        k.setTahun(frmKendaraan.gettxtTahun().getText());
        k.setNomor(frmKendaraan.gettxtNomor().getText());
        k.setHarga(Integer.parseInt(frmKendaraan.gettxtHarga().getText()));
        k.setStatus(frmKendaraan.setStatus().getSelectedItem().toString());
        iKendaraan.insert(k);
        JOptionPane.showMessageDialog(null, "input berhasil");
    }
    
    public void reset()
    {
        if(!frmKendaraan.gettxtID_k().isEnabled())
        {
            frmKendaraan.gettxtID_k().setEnabled(true);
        }
        frmKendaraan.gettxtID_k().setText("");
        frmKendaraan.setJenis().setSelectedItem("Mobil");
        frmKendaraan.gettxtMerek().setText("");
        frmKendaraan.gettxtTipe().setText("");
        frmKendaraan.gettxtTahun().setText("");
        frmKendaraan.gettxtNomor().setText("");
        frmKendaraan.gettxtHarga().setText("");
        frmKendaraan.setStatus().setSelectedItem("Tersedia");
        
    }
    
    public void isiField(int row)
    {
        frmKendaraan.gettxtID_k().setEnabled(false);
        frmKendaraan.gettxtID_k().setText(lst.get(row).getId_k().toString());
        frmKendaraan.setJenis().setSelectedItem(lst.get(row).getJenis());
        frmKendaraan.gettxtTipe().setText(lst.get(row).getTipe());
        frmKendaraan.gettxtMerek().setText(lst.get(row).getMerek());
        frmKendaraan.gettxtTahun().setText(lst.get(row).getTahun());
        frmKendaraan.gettxtNomor().setText(lst.get(row).getNomor());
        frmKendaraan.gettxtHarga().setText(lst.get(row).getHarga().toString());
        frmKendaraan.setStatus().setSelectedItem(lst.get(row).getStatus());
    }
    
 
    public void update()
    {
       Kendaraan k = new Kendaraan();
        k.setJenis(frmKendaraan.setJenis().getSelectedItem().toString());
        k.setMerek(frmKendaraan.gettxtMerek().getText());
        k.setTipe(frmKendaraan.gettxtTipe().getText());
        k.setTahun(frmKendaraan.gettxtTahun().getText());
        k.setNomor(frmKendaraan.gettxtNomor().getText());
        k.setHarga(Integer.parseInt(frmKendaraan.gettxtHarga().getText()));
        k.setStatus(frmKendaraan.setStatus().getSelectedItem().toString());
        k.setId_k(Integer.parseInt(frmKendaraan.gettxtID_k().getText()));
        iKendaraan.update(k);
        JOptionPane.showMessageDialog(null, "Update berhasil");
        
    }
    
    public void delete()
    {
        Kendaraan k = new Kendaraan();
        iKendaraan.delete(Integer.parseInt(frmKendaraan.gettxtID_k().getText()));
        JOptionPane.showMessageDialog(null, "Delete berhasil");
        
    }
    
   public void cari()
    {
        lst = iKendaraan.getAllByName(frmKendaraan.gettxtCariTipe().getText());
        TabelModelKendaraan tabelken = new TabelModelKendaraan(lst);
        frmKendaraan.getTableKendaraan().setModel(tabelken);
    }
    
    
    FormKendaraan frmKendaraan;
    IDAOKendaraan iKendaraan;
    List<Kendaraan> lst;
}