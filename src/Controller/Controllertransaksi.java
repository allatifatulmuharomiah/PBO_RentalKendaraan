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
    
    private int harga;
    
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
        t.setTipe(frmTransaksi.gettxtTipe().getSelectedItem().toString());
        t.setId_k(frmTransaksi.setId_k().getSelectedItem().toString());
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
        frmTransaksi.gettxtTipe().setSelectedItem("Daihatsu SUV");
        frmTransaksi.setId_k().setSelectedItem("111  Daihatsu SUV");
        frmTransaksi.setHari().setSelectedItem("1");
        frmTransaksi.gettxtTotal().setText("");
        frmTransaksi.setStatus().setSelectedItem("Proses");
        
    }
    
    public void isiField(int row)
    {
        frmTransaksi.gettxtID_t().setEnabled(false);
        frmTransaksi.gettxtID_t().setText(ls.get(row).getId_t().toString());
        frmTransaksi.gettxtPeminjam().setText(ls.get(row).getPeminjam());
        frmTransaksi.gettxtNo().setText(ls.get(row).getNo_telp());
        frmTransaksi.gettxtTipe().setSelectedItem(ls.get(row).getTipe());
        frmTransaksi.setId_k().setSelectedItem(ls.get(row).getId_k());
        frmTransaksi.setHari().setSelectedItem(ls.get(row).getHari().toString());
        frmTransaksi.gettxtTotal().setText(ls.get(row).getTotal().toString());
        frmTransaksi.setStatus().setSelectedItem(ls.get(row).getStatus());
    }
    
    public void update (){
        Transaksi t = new Transaksi();
        t.setPeminjam(frmTransaksi.gettxtPeminjam().getText());
        t.setNo_telp(frmTransaksi.gettxtNo().getText());
        t.setTipe(frmTransaksi.gettxtTipe().getSelectedItem().toString());
        t.setId_k(frmTransaksi.setId_k().getSelectedItem().toString());
        t.setHari(Integer.parseInt(frmTransaksi.setHari().getSelectedItem().toString()));
        t.setTotal(Integer.parseInt(frmTransaksi.gettxtTotal().getText()));
        t.setStatus(frmTransaksi.setStatus().getSelectedItem().toString());
        t.setId_t(Integer.parseInt(frmTransaksi.gettxtID_t().getText()));
        iTransaksi.update(t);
        JOptionPane.showMessageDialog(null, "update berhasil");
    }
    
    public void delete() {
        Transaksi t = new Transaksi();
        iTransaksi.delete(Integer.parseInt(frmTransaksi.gettxtID_t().getText()));
        JOptionPane.showMessageDialog(null, "delete berhasil");
    }
    
    
    public void cbtipe() {
    String selectedTipe = (String) frmTransaksi.gettxtTipe().getSelectedItem().toString();
    
        if (selectedTipe.equals("Daihatsu SUV")) 
        {
            harga = 300000;
            frmTransaksi.gettxtTotal().setText(String.valueOf(harga));
        } 
         else 
            if(selectedTipe.equals("Daihatsu MPV"))
            {
               harga = 310000;
               frmTransaksi.gettxtTotal().setText(String.valueOf(harga));         
            }
         else 
            if(selectedTipe.equals("Toyota MPV"))
            {
               harga = 350000;
               frmTransaksi.gettxtTotal().setText(String.valueOf(harga));         
            }
        else 
            if(selectedTipe.equals("Toyota SUV"))
            {
               harga = 360000;
               frmTransaksi.gettxtTotal().setText(String.valueOf(harga));         
            }
        else 
            if(selectedTipe.equals("Honda Scooter"))
            {
               harga = 80000;
               frmTransaksi.gettxtTotal().setText(String.valueOf(harga));         
            }
        else 
            if(selectedTipe.equals("Honda Sport"))
            {
               harga = 90000;
               frmTransaksi.gettxtTotal().setText(String.valueOf(harga));         
            }
        else 
            if(selectedTipe.equals("Yamaha Scooter"))
            {
               harga = 85000;
               frmTransaksi.gettxtTotal().setText(String.valueOf(harga));         
            }
        else 
            if(selectedTipe.equals("Yamaha Sport"))
            {
               harga = 95000;
               frmTransaksi.gettxtTotal().setText(String.valueOf(harga));         
            }
        
    }
    
    public void hitung()
    {
        int harga = Integer.parseInt(frmTransaksi.gettxtTotal().getText().toString());
        int hari = Integer.parseInt(frmTransaksi.setHari().getSelectedItem().toString());
        int total = harga*hari;
        frmTransaksi.gettxtTotal().setText(String.valueOf(total));         
    }
    
    public void resethitung()
    {
        frmTransaksi.setHari().setSelectedItem("1");
        frmTransaksi.gettxtTotal().setText(String.valueOf(harga));
    }
    
    public void cari() {
        ls = iTransaksi.getAllByName(frmTransaksi.gettxtCariNama().getText());
        TabelModelTransaksi tabeltr = new TabelModelTransaksi(ls);
        frmTransaksi.getTableTransaksi().setModel(tabeltr);
    }

    FormTransaksi frmTransaksi;
    IDAOTransaksi iTransaksi;
    List<Transaksi> ls;
}
