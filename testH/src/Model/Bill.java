/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
// *
 * @author Admin
 */
public class Bill {
    private String Id;
    private String idEmployee;
    private String startTime;
    private String endTime;
    private ArrayList<Bill_Furniture> bFur;
    private ArrayList<Bill_Service> bSer;
    private int idroom_reservation;
    
    public Bill() {
    }

    public Bill(String Id, String idEmployee, String startTime, String endTime, int idroom_reservation) {
        this.Id = Id;
        this.idEmployee = idEmployee;
        this.startTime = startTime;
        this.endTime = endTime;
        this.idroom_reservation = idroom_reservation;
    }

    public Bill(String Id, String idEmployee, String timeCheckin, String timeCheckout, int idroom_reservation, ArrayList<Bill_Furniture> bFur, ArrayList<Bill_Service> bSer) {
        this.Id = Id;
        this.idEmployee = idEmployee;
        this.startTime = timeCheckin;
        this.endTime = timeCheckout;
        this.idroom_reservation = idroom_reservation;
        this.bFur = bFur;
        this.bSer = bSer;
    }
    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getIdroom_reservation() {
        return idroom_reservation;
    }

    public void setIdroom_reservation(int idroom_reservation) {
        this.idroom_reservation = idroom_reservation;
    }
    public ArrayList<Bill_Furniture> getbFur() {
        return bFur;
    }

    public void setbFur(ArrayList<Bill_Furniture> bFur) {
        this.bFur = bFur;
    }

    public ArrayList<Bill_Service> getbSer() {
        return bSer;
    }

    public void setbSer(ArrayList<Bill_Service> bSer) {
        this.bSer = bSer;
    }
}
