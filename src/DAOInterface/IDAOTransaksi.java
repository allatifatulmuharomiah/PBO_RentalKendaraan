/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Transaksi;
import java.util.List;
/**
 *
 * @author LENOVO
 */
public interface IDAOTransaksi {
    public List<Transaksi> getAll();
    
    public void insert(Transaksi t);
    
    public void update (Transaksi t);
    
    public void delete (int Id_t);
    
    public List<Transaksi> getAllByName(String peminjam);
}


