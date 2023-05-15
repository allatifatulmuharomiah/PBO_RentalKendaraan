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
    
    
    FormKendaraan frmKendaraan;
    IDAOKendaraan iKendaraan;
    List<Kendaraan> lst;
}
