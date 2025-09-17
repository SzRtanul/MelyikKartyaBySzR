/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author SzabóRoland(SZF_2024
 */
public class Lap implements Cloneable{
    public int lapszam;
    public String lapnev;
    public String leiras;
    
    public Lap(int lapszam, String lapnev, String leiras){
        this.lapszam = lapszam;
        this.lapnev = lapnev;
        this.leiras = leiras;
    }
    
    public int getLapszam() {
        return lapszam;
    }

    public String getLapnev() {
        return lapnev;
    }

    public String getLeiras() {
        return leiras;
    }
    
    @Override
    public Lap clone(){
        try {
            return (Lap) super.clone(); // sekély másolat
        } catch (CloneNotSupportedException e) {
            return null; 
        }
    }
}
