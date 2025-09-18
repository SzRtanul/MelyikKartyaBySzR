/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import java.util.Scanner;
import model.Kartyak;
import model.Lap;
import model.Lapok;

/**
 *
 * @author SzabóRoland(SZF_2024
 */
public class KartyaView {
    Lapok lapok;
    Kartyak kartyak;
    int menet = 1;
    int[] gettedKartyak;
    
    public KartyaView(Kartyak kartyak){
        this.kartyak = kartyak;
        gettedKartyak = kartyak.getKartyak();
        lapok = new Lapok(kartyak.getHossz(), gettedKartyak);
    }
    
    Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    
    String[] glecky = new String[]{
        "Jelöld meg az oszlopot,ahol a kártyát látod! (0-tól kezdve számolunk): "
    };
    
   int getSCint(){
        int outl = -1;
        String out = "";
        boolean hritt = true;
        System.out.print(glecky[0]);
        do {
            out = sc.nextLine();
            try{
                outl = Integer.parseInt(out);
            }
            catch(Exception e){}
            hritt = outl < 0 || outl > 2;
            if(hritt) System.out.print("Hibás oszlop! Mégegyszer kérem!: ");
        } while (hritt);
        return outl;
    }
    
    public Lap getLap(int elem){
        return elem  > -1 && elem < lapok.lapok.length ? lapok.lapok[elem].clone() : null;
    }
    
    public String getKartyaKimenet(int[] kartyak, int hossz, int oszlop){
        String kartyakimenet = menet + ". elrendezés:\n";
        gettedKartyak = this.kartyak.getKartyak();
        for(int i = 0, j = 0; i < hossz; i++, j++){
            kartyakimenet += getLap(this.gettedKartyak[i]).lapnev + "\t";
            if(j==oszlop-1){
                kartyakimenet += "\n";
                j=-1;
            }
        }
        menet++;
        return kartyakimenet;
    }
    
    public void doKiir(Kartyak kartyajatek){
        System.out.println(getKartyaKimenet(kartyajatek.getKartyak(), kartyajatek.getHossz(), kartyajatek.getOszlop()));
    }
    
    public void indit(){
        System.out.println("Válassz ki a pakliból egy kártyát, jelöld meg, melyik oszlopban van épp! Kitalálom, melyikre  gondoltál.");
        while(kartyak.hasMenet()){
            doKiir(kartyak);
            kartyak.Melyik(getSCint());
        }
        System.out.println("A " + getLap(kartyak.EzVolt()).lapnev +" kártya volt az, amire gondoltál.");
    }
}
