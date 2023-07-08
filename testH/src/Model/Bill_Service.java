/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Bill_Service {
    private String idBill;
    private String idSer;
    private int quantity;

    public Bill_Service(String idBill, String idSer) {
        this.idBill = idBill;
        this.idSer = idSer;
    }

    public Bill_Service(String idBill, String idSer, int quantity) {
        this.idBill = idBill;
        this.idSer = idSer;
        this.quantity = quantity;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public String getIdSer() {
        return idSer;
    }

    public void setIdSer(String idSer) {
        this.idSer = idSer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
