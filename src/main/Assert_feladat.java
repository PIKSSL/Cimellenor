
package main;

import java.util.Scanner;

public class Assert_feladat {

    public static void main(String[] args) {
        
        program();
        
        
    }
    public static void program(){
        Scanner scn = new Scanner(System.in, "ISO-8859-1");
        String beker = scn.nextLine();
        assert !beker.isBlank():"Hiba:Üres mező";
        String ujadat = beker.replaceAll("\\s+", " ");
        System.out.println(valid(ujadat));
    }
    static boolean valid(String adat){
        String[] tarolo = new String[2];
        String[] szavak ={"út","utca","tér"};
        if(!Character.isUpperCase(adat.charAt(0))){return false;}
        String ujadat =adat.toLowerCase();
        if(!szavak(ujadat)){return false;}
        if(!(adat.charAt(ujadat.length()-1) == '.')){return false;}
        tarolo = sp(ujadat);
        if(!tartalmaz(tarolo, szavak)){return false;}
        if(!szam(tarolo)){return false;}
        return true;
    }
    
    static boolean szavak(String adat){
        int szavak=0;
        if(adat.charAt(adat.length()-1) == ' '){
            adat = adat.substring(0,adat.length()-1);
        }
        for (int i = 0; i < adat.length(); i++) {
            if(adat.charAt(i)==' '){
                szavak++;
            }
        }
        boolean hossz = szavak > 2 ? false:true;
        return hossz;
    }
    static boolean tartalmaz(String[] adat, String[] tomb){
        for (String szo : tomb) {
            if(adat[1].contains(szo)){
                return true;
            }
        }
        return false;
    }
    static boolean szam(String[] adat){
        String ujadat = adat[2].substring(0,adat[2].length()-1);
        for (int i = 0; i < ujadat.length(); i++) {
            if(!Character.isDigit(ujadat.charAt(i))){
                return false;
            }
        }
        if(Integer.parseInt(ujadat) <1 || Integer.parseInt(ujadat) >500 ){
            return false;}
        return true;
    }
    static String[] sp(String adat){
        String[] tomb = adat.split(" ");
        return tomb;
    }
    }
