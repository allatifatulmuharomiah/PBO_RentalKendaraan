/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author LENOVO
 */
public class TabelModelKendaraan extends AbstractTableModel{
    
    public TabelModelKendaraan(List<Kendaraan> lst)
    {
        this.lst = lst;
    }
    @Override
    public int getRowCount() {
      return this.lst.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }
    
    @Override
    public String getColumnName(int column) 
    {
        switch (column)
        {
            case 0:
                return "ID Kendaraan";
            case 1:
                return "jenis";
            case 2:
                return "merek";
            case 3:
                return "tipe";
            case 4:
                return "Tahun Produksi";
            case 5:
                return "Nomor";
            case 6:
                return "Harga Sewa";
            case 7:
                return "status";
            default:
                return null;  
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
       switch (columnIndex)
        {
            case 0:
                return lst.get(rowIndex).getId_k();
            case 1:
                return lst.get(rowIndex).getJenis();
            case 2:
                return lst.get(rowIndex).getMerek();
            case 3:
                return lst.get(rowIndex).getTipe();
            case 4:
                return lst.get(rowIndex).getTahun();
            case 5:
                return lst.get(rowIndex).getNomor();
            case 6:
                return lst.get(rowIndex).getHarga();
            case 7:
                return lst.get(rowIndex).getStatus();
            default:
                return null;  
        }
        
    }

    List<Kendaraan> lst;
}
