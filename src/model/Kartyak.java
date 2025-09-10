/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Arrays;

/**
 *
 * @author SzabóRoland(SZF_2024
 */
public class Kartyak {
    
    private int hossz;
    private int oszlop;
    private int menet;
    private int[] kartyak;
    private int[] menetvalaszt;
    private int[] lehetseges;
    private String[] szinek;
    private String[] ertekek;

    public int getHossz() {
        return hossz;
    }

    public int getOszlop() {
        return oszlop;
    }

    public int getMenet() {
        return menet;
    }

    public int[] getKartya() {
        return Arrays.copyOf(this.kartyak, this.kartyak.length);
    }

    public int[] getMenetvalaszt() {
        return Arrays.copyOf(menetvalaszt, menetvalaszt.length);
    }
    
    public int getOszlopHossz(){
        return this.hossz/this.oszlop;
    }
    
    public Kartyak(){
        this.hossz = 48;
        this.oszlop = 3;
        this.menet = 0;
        this.kartyak = doGeneral();
        this.menetvalaszt = new int[3];
        this.lehetseges = new int[this.hossz/this.oszlop];
        /*this.szinek = new String[]{
            "P", "T", "Z", "M"
        };
        this.ertekek = new String[]{
            "Ász", "Kir", "Fel", "", "", ""
        };*/
    }
    
    private int[] Kever(){
        return new int[this.hossz];
    }
    
    private int[] doGeneral(){
        int[] tomb =  new int[this.hossz];
        for(int i = 0; i < this.oszlop; i++){
            tomb[i] = i;
        }
        return tomb;
    }
    
    public boolean hasMenet(){
        return this.menet < this.menetvalaszt.length;
    }
    
    public boolean Melyik(int oszlop){
        boolean both = hasMenet() && oszlop>0 && oszlop-1 < this.oszlop;
        if(both){
            int oszl = oszlop-1;
            int oszlen = lehetseges.length;
            menetvalaszt[menet] = oszl;
            if(this.menet == 0){
                System.arraycopy(this.kartyak, oszl*oszlen, this.lehetseges, oszl*oszlen, (oszl+1) * oszl - oszl*oszlen);
            }
            else{
                boolean benne = false;
                int aktual = -1;
                for(int i = 0; i < this.lehetseges.length; i++){
                    benne = false;
                    aktual = this.lehetseges[i];
                    for(int j = oszl*oszlen; j < (oszl+1) * oszl && !benne; j++){
                        benne = this.kartyak[i] == aktual;
                    }
                    if(!benne) this.lehetseges[i] = -1;
                }
                
                int llen = 0;
                for(int i = 0; i < this.lehetseges.length; i++){
                    if(this.lehetseges[i] > -1){
                        if(llen != i) this.lehetseges[llen] = this.lehetseges[i];
                        llen++;
                    }
                }
                this.lehetseges = Arrays.copyOf(this.lehetseges, llen);
            }
        }
        this.menet++;
        return both;
    }
    
    public int EzVolt(){
        return hasMenet() && lehetseges.length > 0 ? lehetseges[0] : -1;
    }
}
