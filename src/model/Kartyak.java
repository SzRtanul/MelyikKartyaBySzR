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

    public int getHossz() {
        return hossz;
    }

    public int getOszlop() {
        return oszlop;
    }

    public int getMenet() {
        return menet;
    }

    public int[] getKartyak() {
        return Arrays.copyOf(this.kartyak, this.kartyak.length);
    }

    public int[] getMenetvalaszt() {
        return Arrays.copyOf(menetvalaszt, menetvalaszt.length);
    }
    
    public int getOszlopHossz(){
        return this.hossz/this.oszlop;
    }
    
    public Kartyak(){
        this.hossz = 21;
        this.oszlop = 3;
        this.menet = 0;
        this.kartyak = doGeneral();
        this.menetvalaszt = new int[3];
        this.lehetseges = new int[this.hossz/this.oszlop];
    }
    
    private int[] Kever(int oszlop){
        int[] kartyarend = new int[this.kartyak.length];
        int oszl = oszlop;
        int oszl05 = this.oszlop / 2;
        menetvalaszt[menet] = oszl;
        int ij = 0;
        for(int i = 0, k = 0; i < this.oszlop; i++){
            ij = i == oszlop ? oszl05 : (i == oszl05 ? oszlop : i);
            for(int j = kartyak.length-this.oszlop; j > -1; j -= this.oszlop, k++){
                kartyarend[k] = kartyak[ij + j];
            }
        }
        return kartyarend;
    }
    
    private int[] doGeneral(){
        int[] tomb =  new int[this.hossz];
        for(int i = 0; i < this.hossz; i++){
            tomb[i] = i;
        }
        return tomb;
    }
    
    public boolean hasMenet(){
        return this.menet < this.menetvalaszt.length;
    }
    
    public boolean Melyik(int oszlop){
        boolean both = hasMenet() && oszlop > -1 && oszlop < this.oszlop;
        if(both){
            this.kartyak = Kever(oszlop);
            this.menet++;
        }
        return both;
    }
    
    public int EzVolt(){
        return !hasMenet() ? kartyak[(kartyak.length / 2)] : -1;
    }
}
