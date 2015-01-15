/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objektit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author Juuso
 */
public class Kasi {

    private Kortti[] kortit;
    private int arvo;

    public Kasi() {
        this.kortit = new Kortti[5];
    }

    public Kortti[] getKortit() {
        return kortit;
    }

    public int getArvo() {
        laskeArvo();
        return arvo;
    }

    private void laskeArvo() {

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
        TreeSet<Integer> numerot = new TreeSet<Integer>();

        for (int i = 0; i < kortit.length; i++) {
            if (numerot.contains(kortit[i].getNumero())) {
                return false;
            }
            
            numerot.add(kortit[i].getNumero());
            
            if (kortit[i].getNumero() == Kortti.NUMERO_ASSA) {
                numerot.add(14);
            }
        }
        Integer numero = numerot.first();
        while (true) {
            if (numero == null) {
                return true;
            }
            if (numero + 1 != numerot.higher(numero)) {
                return false;
            }
            numero = numerot.higher(numero);
        }
    }

    private boolean onVari() {
        Integer ekaVari = kortit[0].getMaa();
        for (int i = 1; i < 10; i++) {
            if (kortit[i].getMaa() != ekaVari) {
                return false;
            }
        }
        return true;
    }

    private boolean onTaysikasi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean onNeloset() {
        samojaNumeroita(4, 1);
    }

    private boolean onVarisuora() {
        return onSuora() && onVari();
    }

    private boolean onReeti() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean samojaNumeroita(int maara, int kertaa) {
        HashMap<Integer, Integer> maarat = new HashMap<Integer, Integer>();
        for (int i = 0; i < kortit.length; i++) {
            if (!maarat.containsKey(kortit[i].getNumero())) {
                maarat.put(kortit[i].getNumero(), 0);
            }
            maarat.put(kortit[i].getNumero(), maarat.get(kortit[i].getNumero()) + 1);
        }

        int kertoja = 0;
        for (Integer numero : maarat.values()) {
            if (numero >= maara) {
                kertoja++;
            }
            if (kertoja >= kertaa) {
                return true;
            }
        }
        return false;

    }

}
