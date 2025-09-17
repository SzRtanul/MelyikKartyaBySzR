/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Kartyak;
import model.Lap;

/**
 *
 * @author SzabóRoland(SZF_2024
 */
public class KartyaView {
    Lap[] lapok;
    Kartyak kartyak;
    public String[] szinek = new String[]{
        "P", "T", "Z", "M"
    };
    public String[] ertekek = new String[]{
        "Ász", "Kir", "Fel", "X", "IX", "VIII"
    };
    
    public KartyaView(Kartyak kartyak){
        this.kartyak = kartyak;
        lapok = new Lap[kartyak.getHossz()];
    }
    
    public void doGenLap(){
        for (int i = 0, f = 0, g = 0; i < kartyak.getHossz(); i++) {
            if(f < szinek.length && g >= ertekek.length){
                f++;
                g = 0;
            }
            if(f < szinek.length){
                lapok[i] = new Lap(i, szinek[f] + "_" + ertekek[g], "");
                g++;
            }
            else{
                lapok[i] = new Lap(i, i+"", "");
            }
        }
    }
    
    public Lap getLap(int elem){
        return elem  > -1 && elem < lapok.length ? lapok[elem].clone() : null;
    }
}
