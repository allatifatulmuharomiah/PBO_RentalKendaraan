/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Kendaraan;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface IDAOKendaraan {
    public List<Kendaraan> getAll();
    
    /**
     *
     * @param k
     */
    public void insert(Kendaraan k);

    public void update(Kendaraan k);
    
    public void delete (int Id_k);
    
    public List<Kendaraan> getAllByName(String tipe);
    
}
