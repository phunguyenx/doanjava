/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Norris
 */
public class TypeRoom {
    private String id_tRoom;
    private String name;
    private int price;

    public TypeRoom(String id_tRoom, String name, int price) {
        this.id_tRoom = id_tRoom;
        this.name = name;
        this.price = price;
    }

    public String getId_tRoom() {
        return id_tRoom;
    }

    public void setId_tRoom(String id_tRoom) {
        this.id_tRoom = id_tRoom;
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
