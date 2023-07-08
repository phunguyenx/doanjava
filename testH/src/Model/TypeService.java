/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Norris
 */
public class TypeService {
    private String Id_tSer;
    private String name;

    public TypeService(String Id_tSer, String name) {
        this.Id_tSer = Id_tSer;
        this.name = name;
    }

    public String getId_tSer() {
        return Id_tSer;
    }

    public void setId_tSer(String Id_tSer) {
        this.Id_tSer = Id_tSer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
