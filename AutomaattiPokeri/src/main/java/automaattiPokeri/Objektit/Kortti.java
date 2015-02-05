package automaattiPokeri.Objektit;

/**
 *
 * @author Juuso
 */
public class Kortti implements Comparable<Kortti>, Cloneable {

    private final Integer numero;
    private final Integer maa;

    /**
     * Pataa kuvaava integer arvo
     */
    public static final int MAA_PATA = 0;

    /**
     * Ristia kuvaava integer arvo
     */
    public static final int MAA_RISTI = 1;

    /**
     * Herttaa kuvaava integer arvo
     */
    public static final int MAA_HERTTA = 2;

    /**
     * Ruutua kuvaava integer arvo
     */
    public static final int MAA_RUUTU = 3;

    /**
     * Assaa kuvaava integer arvo 1
     */
    public static final int NUMERO_ASSA = 1;

    /**
     * Jatkaa kuvaava integer arvo 11
     */
    public static final int NUMERO_JATKA = 11;

    /**
     * Kuningatarta kuvaava integer arvo 12
     */
    public static final int NUMERO_KUNINGATAR = 12;

    /**
     * Kuningasta kuvaava integer arco 13
     */
    public static final int NUMERO_KUNINGAS = 13;

    /**
     * Luo kortin
     * @param numero Kortin numero, oltava valilta 1 - 13
     * @param maa Kortin maa, oltava valilta 0 - 3 , kayta Kortti.MAA_* muuttujia.
     */
    public Kortti(int numero, int maa) {
        if (numero <= 0 || numero > 13) {
            throw new Error("Kortin numero on valittu väärin, käytä numeroita 2-10 tai esim Kortti.NUMERO_JATKA");
        }
        this.numero = numero;
        if (maa < 0 || maa > 3) {
            throw new Error("Kortin maa valittu väärin, käytä esim Kortti.MAA_HERTTA");
        }
        this.maa = maa;
    }

    /**
     * 
     * @return Palauttaa kortin numero arvon
     */
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @return Palauttaa kortin maa arvon.
     */
    public int getMaa() {
        return maa;
    }

    /**
     * 
     * @return Palauttaa kortin koodin: numero_maa
     */
    public String getKoodi() {
        return numero + "_" + maa;
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
        String maaStr = "";
        String numeroStr = "";

        if (numero == Kortti.NUMERO_ASSA) {
            numeroStr = "ässä";
        } else if (numero == Kortti.NUMERO_JATKA) {
            numeroStr = "jätkä";
        } else if (numero == Kortti.NUMERO_KUNINGATAR) {
            numeroStr = "kuningatar";
        } else if (numero == Kortti.NUMERO_KUNINGAS) {
            numeroStr = "kuningas";
        } else {
            numeroStr = numero.toString();
        }

        if (maa == Kortti.MAA_RUUTU) {
            maaStr = "Ruutu";
        } else if (maa == Kortti.MAA_RISTI) {
            maaStr = "Risti";
        } else if (maa == Kortti.MAA_PATA) {
            maaStr = "Pata";
        } else if (maa == Kortti.MAA_HERTTA) {
            maaStr = "Hertta";
        }

        return maaStr + " " + numeroStr;
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
