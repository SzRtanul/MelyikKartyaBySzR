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
    
    public static String getKartyaKimenet(int[] kartyak, int oszlophossz, int oszlop){
        String kartyakimenet = "";
        for(int i = 0; i < oszlophossz; i++){
            for (int j = 0; j < oszlop; j += oszlophossz) {
                kartyakimenet += kartyak[j+i] + "-";
            }
            kartyakimenet += "\n";
        }
    }
    public static void main(String[] args) {
        Kartyak kartyajatek = new Kartyak();
        System.out.println(getKartyaKimenet(kartyajatek.getKartya(), kartyajatek.getOszlopHossz(), kartyajatek.getOszlop()));
    }
}
