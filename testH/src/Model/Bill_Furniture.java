/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Bill_Furniture {
    private String idBill;
    private String idFur;

    public Bill_Furniture(String idBill, String idFur) {
        this.idBill = idBill;
        this.idFur = idFur;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public String getIdFur() {
        return idFur;
    }

    public void setIdFur(String idFur) {
        this.idFur = idFur;
    }
    
    
}
