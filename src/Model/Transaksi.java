/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LENOVO
 */
public class Transaksi {

    /**
     * @return the id_t
     */
    public Integer getId_t() {
        return id_t;
    }

    /**
     * @param id_t the id_t to set
     */
    public void setId_t(Integer id_t) {
        this.id_t = id_t;
    }

    /**
     * @return the peminjam
     */
    public String getPeminjam() {
        return peminjam;
    }

    /**
     * @param peminjam the peminjam to set
     */
    public void setPeminjam(String peminjam) {
        this.peminjam = peminjam;
    }

    /**
     * @return the no_telp
     */
    public String getNo_telp() {
        return no_telp;
    }

    /**
     * @param no_telp the no_telp to set
     */
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    /**
     * @return the tipe
     */
    public String getTipe() {
        return tipe;
    }

    /**
     * @param tipe the tipe to set
     */
    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    /**
     * @return the id_k
     */
    public String getId_k() {
        return id_k;
    }

    /**
     * @param id_k the id_k to set
     */
    public void setId_k(String id_k) {
        this.id_k = id_k;
    }

    /**
     * @return the hari
     */
    public Integer getHari() {
        return hari;
    }

    /**
     * @param hari the hari to set
     */
    public void setHari(Integer hari) {
        this.hari = hari;
    }

    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    
    private Integer id_t;
    private String peminjam;
    private String no_telp;
    private String tipe;
    private String id_k;
    private Integer hari;
    private Integer total;
    private String status;
    
}
