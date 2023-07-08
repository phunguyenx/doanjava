/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Furniture {

    private String id;
    private String name;
    private int price;
    private String roomNumber;
    private int status;
    private String name_tRoom;

    public Furniture(String id, String name, int price, String roomNumber, String name_tRoom) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.roomNumber = roomNumber;
        this.name_tRoom = name_tRoom;
    }

    public Furniture(String id, String name, int price, String name_tRoom) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.name_tRoom = name_tRoom;
    }

    public Furniture(String name, int price, String name_tRoom) {
        this.name = name;
        this.price = price;
        this.name_tRoom = name_tRoom;
    }

    public Furniture(String id, String name, int price, int status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public Furniture() {
    }

    public String getName_tRoom() {
        return name_tRoom;
    }

    public void setName_tRoom(String name_tRoom) {
        this.name_tRoom = name_tRoom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setId_RoomNumber(String id_roomNumber) {
        this.roomNumber = id_roomNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setRoomNumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
