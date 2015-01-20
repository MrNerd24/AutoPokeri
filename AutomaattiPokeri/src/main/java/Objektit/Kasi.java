/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objektit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 *
 * @author Juuso
 */
public class Kasi {

    private Kortti[] kortit;
    private int arvo;
    private int maara;
    private ArrayList<Integer> numerot = new ArrayList<Integer>();
    private ArrayList<Integer> maat = new ArrayList<Integer>();

    public Kasi() {
        this.kortit = new Kortti[5];
        maara = 0;
    }

    public Kortti[] getKortit() {
        return kortit;
    }
    
    public Kortti getKortti(int index) {
        return kortit[index];
    }

    public int getArvo() {
        laskeArvo();
        return arvo;
    }
    
    public void lisaaKortti(Kortti kortti) {
        for (int i = 0; i < kortit.length; i++) {
            if (kortit[i] == null) {
                kortit[i] = kortti;
                maara++;
                return;
            }
        }
        throw new Error("Yritit lisätä kortteja täyteen käteen");
    }
    
    public void poistaKortti(Kortti kortti) {
        for (int i = 0; i < kortit.length; i++) {
            if (kortit[i].equals(kortti)) {
                kortit[i] = null;
                maara--;
                return;
            }
        }
        throw new Error("Korttia jota yritettiin poistaa ei ollut kädessä");
    }
    
    public void poistaKortti(int index) {
        if (index < 0 || index >= kortit.length) {
            throw new Error("index jonka perusteella kortti yritettiin poistaa ei vastaa yhtäkään korttia");
        }
        kortit[index] = null;
        maara--;
    }
    
    public int size() {
        return maara;
    }
    
    public boolean voiLisata() {
        return maara < 5;
    }

    private void laskeArvo() {
        jarjestaNumerotJaMaat();
        

        if (onReeti()) {
            arvo = Kasi.ARVO_REETI;
            return;
        }

        if (onVarisuora()) {
            arvo = Kasi.ARVO_VARISUORA;
            return;
        }

        if (onNeloset()) {
            arvo = Kasi.ARVO_NELOSET;
            return;
        }

        if (onTaysikasi()) {
            arvo = Kasi.ARVO_TAYSIKASI;
            return;
        }

        if (onVari()) {
            arvo = Kasi.ARVO_VARI;
            return;
        }

        if (onSuora()) {
            arvo = Kasi.ARVO_SUORA;
            return;
        }

        if (onKolmoset()) {
            arvo = Kasi.ARVO_KOLMOSET;
            return;
        }

        if (onKaksiparia()) {
            arvo = Kasi.ARVO_KAKSIPARIA;
            return;
        }

        if (onPari()) {
            arvo = Kasi.ARVO_PARI;
            return;
        }

        if (onHai()) {
            arvo = Kasi.ARVO_HAI;
        }

    }

    private void jarjestaNumerotJaMaat() {
        numerot.clear();
        maat.clear();
        
        for (int i = 0; i < kortit.length; i++) {
            if (kortit[i] == null) {
                continue;
            }
            numerot.add(kortit[i].getNumero());
            if (kortit[i].getNumero() == Kortti.NUMERO_ASSA) {
                numerot.add(14);
            }
            maat.add(kortit[i].getMaa());
        }
        
        Collections.sort(maat);
        Collections.sort(numerot);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Arrays.deepHashCode(this.kortit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kasi other = (Kasi) obj;

        HashSet<Kortti> korttiSet = new HashSet<Kortti>();
        for (int i = 0; i < this.kortit.length; i++) {
            korttiSet.add(kortit[i]);
        }

        for (int i = 0; i < other.getKortit().length; i++) {
            korttiSet.remove(other.getKortit()[i]);
        }

        if (!korttiSet.isEmpty()) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        String vastaus = "Kortit: ";
        for (int i = 0; i < this.kortit.length - 1; i++) {
            vastaus += this.kortit[i] + ", ";
        }
        vastaus += this.kortit[this.kortit.length - 1];
        return vastaus;
    }

    public static final int ARVO_REETI = 0;
    public static final int ARVO_VARISUORA = 1;
    public static final int ARVO_NELOSET = 2;
    public static final int ARVO_TAYSIKASI = 3;
    public static final int ARVO_VARI = 4;
    public static final int ARVO_SUORA = 5;
    public static final int ARVO_KOLMOSET = 6;
    public static final int ARVO_KAKSIPARIA = 7;
    public static final int ARVO_PARI = 8;
    public static final int ARVO_HAI = 9;

    private boolean onHai() {
        for (int i = 0; i < kortit.length; i++) {
            if (kortit[i] != null) {
                return true;
            }
        }
        return false;
    }

    private boolean onPari() {
        return samojaNumeroita(2, 1);
    }

    private boolean onKaksiparia() {
        return samojaNumeroita(2, 2);
    }

    private boolean onKolmoset() {
        return samojaNumeroita(3, 1);
    }

    private boolean onSuora() {
        int suoranPituus = 1;
        for (int i = 1; i < numerot.size(); i++) {
            if (numerot.get(i-1)+1 == numerot.get(i)) {
                suoranPituus++;
            } else {
                suoranPituus = 1;
            }
        }
        return suoranPituus >= 5;
    }

    private boolean onVari() {
        Integer ekaMaa = maat.get(0);
        for (int i = 1; i < maat.size(); i++) {
            if (maat.get(i) != ekaMaa) {
                return false;
            }
        }
        return true;
    }

    private boolean onTaysikasi() {
        int[] maarat = new int[15];
        for (int i = 0; i < numerot.size(); i++) {
            maarat[numerot.get(i)]++;
        }
        
        boolean kolmoset = false;
        boolean kakkoset = false;
        for (int i = 0; i < maarat.length; i++) {
            if (maarat[i] == 2) {
                kakkoset = true;
            }
            if (maarat[i] == 3) {
                kolmoset = true;
            }
        }
        return kakkoset && kolmoset;
    }

    private boolean onNeloset() {
        return samojaNumeroita(4, 1);
    }

    private boolean onVarisuora() {
        return onSuora() && onVari();
    }

    private boolean onReeti() {
        boolean numerotTasmaa = true;
        for (int i = 1; i < numerot.size(); i++) {
            if (numerot.get(i) != i+9) {
                numerotTasmaa = false;
            }
        }
        return numerotTasmaa && onVari();
    }

    private boolean samojaNumeroita(int maara, int kertaa) {
        int[] maarat = new int[15];
        for (int i = 0; i < numerot.size(); i++) {
            maarat[numerot.get(i)]++;
        }
        
        int kertoja = 0;
        for (int i = 1; i < maarat.length; i++) {
            if (maarat[i] >= maara) {
                kertoja++;
            }
        }
        
        return kertoja >= kertaa;

    }
    

}
