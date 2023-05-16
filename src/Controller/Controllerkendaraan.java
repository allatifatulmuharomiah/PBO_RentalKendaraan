/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOKendaraan;
import DAOInterface.IDAOKendaraan;
import Model.Kendaraan;
import Model.TabelModelKendaraan;
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
        frmKendaraan.gettxtID_k().setText(" ");
        frmKendaraan.setJenis().setSelectedItem("Mobil");
        frmKendaraan.gettxtMerek().setText(" ");
        frmKendaraan.gettxtTipe().setText(" ");
        frmKendaraan.gettxtTahun().setText(" ");
        frmKendaraan.gettxtNomor().setText(" ");
        frmKendaraan.gettxtHarga().setText(" ");
        frmKendaraan.setStatus().setSelectedItem("Tersedia");
        
    }
    
    FormKendaraan frmKendaraan;
    IDAOKendaraan iKendaraan;
    List<Kendaraan> lst;
}
