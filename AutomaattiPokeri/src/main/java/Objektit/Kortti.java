package Objektit;

public class Kortti implements Comparable<Kortti>, Cloneable {
    private final Integer numero;
    private final Integer maa;
    
    public static final int MAA_PATA = 0;
    public static final int MAA_RISTI = 1;
    public static final int MAA_HERTTA = 2;
    public static final int MAA_RUUTU = 3;
    
    public static final int NUMERO_ASSA = 1;
    public static final int NUMERO_JATKA = 11;
    public static final int NUMERO_KUNINGATAR = 12;
    public static final int NUMERO_KUNINGAS = 13;
    

    public Kortti(int numero, int maa) {
        if (numero <= 0 || numero > 13) {
            throw new Error("Kortin numero on valittu väärin, käytä numeroita 2-10 tai esim Kortti.NUMERO_JATKA");
        }
        this.numero = numero;
        if (maa <= 0 || maa > 4 ) {
            throw new Error("Kortin maa valittu väärin, käytä esim Kortti.MAA_HERTTA");
        }
        this.maa = maa;
    }

    public int getNumero() {
        return numero;
    }

    public int getMaa() {
        return maa;
    }
    
    public String getKoodi() {
        return maa + "_" + numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.numero;
        hash = 47 * hash + this.maa;
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
        final Kortti other = (Kortti) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.maa != other.maa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (maa == Kortti.MAA_RUUTU) {
            return "Hertta " + numero;
        }
        
        if (maa == Kortti.MAA_RISTI) {
            return "Risti " + numero;
        }
        
        if (maa == Kortti.MAA_PATA) {
            return "Pata " + numero;
        }
        
        if (maa == Kortti.MAA_HERTTA) {
            return "Hertta " + numero;
        }
        
        throw new Error("Kortin maa valittu väärin, käytä esim Kortti.MAA_HERTTA");
    }

    @Override
    public int compareTo(Kortti o) {
        if (this.maa.compareTo(o.maa) != 0) {
            return this.maa.compareTo(o.maa);
        } else {
            return this.numero.compareTo(o.numero);
        }
    }
    
    @Override
    public Kortti clone() {
        return new Kortti(numero, maa);
    }
    
    
}
