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
    
    static String[] szinek = new String[]{
        "P", "T", "Z", "M"
    };
    static String[] ertekek = new String[]{
        "Ász", "Kir", "Fel", "X", "IX", "VIII"
    };

    static String[] glecky = new String[]{
        "Jelöld meg az oszlopot,ahol a kártyát látod! (0-tól kezdve számolunk): "
    };
    static int menet = 1;
    
   static int getSCint(){
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
    
    public static String getKartyaKimenet(int[] kartyak, int hossz, int oszlop){
        String kartyakimenet = menet + ". elrendezés:\n";
        for(int i = 0, j = 0; i < hossz; i++, j++){
            kartyakimenet += String.format("%02d", kartyak[i]) + "-";
            if(j==oszlop-1){
                kartyakimenet += "\n";
                j=-1;
            }
        }
        menet++;
        return kartyakimenet;
    }
    
    public static void doKiir(Kartyak kartyajatek){
        System.out.println(getKartyaKimenet(kartyajatek.getKartyak(), kartyajatek.getHossz(), kartyajatek.getOszlop()));
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
