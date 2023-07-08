/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Service {
    private String ID;
    private String name_tSer;
    private String id_tSer;
    private String name;
    private int price;
    private int quantity;
    public Service(String ID, String name_tSer, String name, int price) {
        this.ID = ID;
        this.name_tSer = name_tSer;
        this.name = name;
        this.price = price;
    }

    public Service(String name_tSer, String name, int price) {
        this.name_tSer = name_tSer;
        this.name = name;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Service() {
    }
    
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName_tSer() {
        return name_tSer;
    }

    public void setName_tSer(String name_tSer) {
        this.name_tSer = name_tSer;
    }

    public String getId_tSer() {
        return id_tSer;
    }

    public void setId_tSer(String id_tSer) {
        this.id_tSer = id_tSer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    
    
    
}
