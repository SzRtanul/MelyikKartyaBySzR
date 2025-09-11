/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import model.Kartyak;
import program.MelyikKartyaBySzR;

/**
 *
 * @author szabo.roland
 */
public class KartyakTest {
    public static void gamesTest(){
        Kartyak kartyajatek = new Kartyak();
        int games = kartyajatek.getHossz();
        int[] kartyak = new int[games];
        boolean[] kimenetek = new boolean[games];
        int[] kiments = new int[games];
        int talalt = -1;
        int oszlop = kartyajatek.getOszlop();
        
        for (int i = 0; i < games; i++) {
            for (int j = 0; kartyajatek.hasMenet(); j++) {
                kartyak = kartyajatek.getKartyak();
                MelyikKartyaBySzR.doKiir(kartyajatek);
                for (int k = 0; talalt == -1 && k < kartyak.length; k++) {
                    if(kartyak[k] == i) talalt = k;
                }
                System.out.println("Talalt: " + talalt +":"+oszlop);
                System.out.println("Melyik: " + talalt % oszlop);
                kartyajatek.Melyik(talalt % oszlop);
                talalt=-1;
            }
            System.out.println(i + ". #Ant: " + kartyajatek.EzVolt());
            kimenetek[i] = i == kartyajatek.EzVolt();
            kiments[i] = kartyajatek.EzVolt();
            kartyajatek = new Kartyak();
        }
        
        for (int i = 0; i < kimenetek.length; i++) {
            System.out.println(i+". " + kimenetek[i] +":"+kiments[i]);
        }
        
        for (int i = 0; i < kimenetek.length; i++) {
            assert kimenetek[i];
        }
    }
    
    public static void main(String[] args){
        gamesTest();
    }
}