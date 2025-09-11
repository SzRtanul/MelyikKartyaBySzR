/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package program;

import java.util.Scanner;
import model.Kartyak;

/**
 *
 * @author SzabóRoland(SZF_2024
 */
public class MelyikKartyaBySzR {
    static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    
   static int getSCint(){
        int outl = -1;
        String out = "";
        System.out.print("Kérek egy számot 0 és 2 között: ");
        do {
            out = sc.nextLine();
            try{
                outl = Integer.parseInt(out);
            }
            catch(Exception e){
                System.out.print("Kérek egy számot 0 és 2 között: ");
            }
        } while (outl < 0 && outl > 2);
        return outl;
    }
    
    public static String getKartyaKimenet(int[] kartyak, int hossz, int oszlop){
        String kartyakimenet = "ONTREEE:\n";
        for(int i = 0, j = 0; i < hossz; i++, j++){
            kartyakimenet += kartyak[i] + "-";
            if(j==oszlop-1){
                kartyakimenet += "\n";
                j=-1;
            }
        }
        return kartyakimenet;
    }
    
    public static void doKiir(Kartyak kartyajatek){
        System.out.println(getKartyaKimenet(kartyajatek.getKartya(), kartyajatek.getHossz(), kartyajatek.getOszlop()));
    }
    
    public static void main(String[] args) {
        System.out.println("Válassz ki a pakliból egy kártyát, jelöld meg, melyik oszlopban van épp! Kitalálom, melyikre  gondoltál.");
        Kartyak kartyajatek = new Kartyak();
        doKiir(kartyajatek);
        kartyajatek.Melyik(getSCint()); // YEEEY 1
        doKiir(kartyajatek);
        kartyajatek.Melyik(getSCint()); // YEEEY 2
        doKiir(kartyajatek);
        kartyajatek.Melyik(getSCint()); // YEEEY 3
        doKiir(kartyajatek);
        
        System.out.println("A " + kartyajatek.EzVolt()+" számú kártya volt az, amire gondoltál.");
    }
}
