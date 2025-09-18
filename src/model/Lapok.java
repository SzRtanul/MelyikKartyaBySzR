/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author szabo.roland
 */
public class Lapok {
    public Lap[] lapok;
    
    public String[] szinek = new String[]{
        "P", "T", "Z", "M"
    };
    public String[] ertekek = new String[]{
        "Ász", "Kir", "Fel", "X", "IX", "VIII"
    };
    public Lapok(int hossz, int[] kartyak){
        this.lapok = new Lap[hossz];
        doGenLap();
    }
    
    public final void doGenLap(){
        for (int i = 0, f = 0, g = 0; i < lapok.length; i++) {
            if(f < szinek.length && g >= ertekek.length){
                f++;
                g = 0;
            }
            if(f < szinek.length){
                lapok[i] = new Lap(i, szinek[f] + "_" + ertekek[g], "");
                g++;
            }
            else{
                lapok[i] = new Lap(i, String.format("%03d", i), "");
            }
        }
    }
}
