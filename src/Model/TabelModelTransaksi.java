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
public class TabelModelTransaksi extends AbstractTableModel{
    
    public TabelModelTransaksi(List<Transaksi> ls)
    {
        this.ls = ls;
    }

    @Override
    public int getRowCount() {
        return this.ls.size();
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
                return "ID Transaksi";
            case 1:
                return "Nama Peminjam";
            case 2:
                return "Nomor Telepon";
            case 3:
                return "tipe";
            case 4:
                return "ID Kendaraan";
            case 5:
                return "Hari";
            case 6:
                return "Total Harga";
            case 7:
                return "status";
            default:
                return null;  
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch (columnIndex)
        {
            case 0:
                return ls.get(rowIndex).getId_k();
            case 1:
                return ls.get(rowIndex).getPeminjam();
            case 2:
                return ls.get(rowIndex).getNo_telp();
            case 3:
                return ls.get(rowIndex).getTipe();
            case 4:
                return ls.get(rowIndex).getId_k();
            case 5:
                return ls.get(rowIndex).getHari();
            case 6:
                return ls.get(rowIndex).getTotal();
            case 7:
                return ls.get(rowIndex).getStatus();
            default:
                return null;  
        }
    }
    List<Transaksi> ls;
          
}
