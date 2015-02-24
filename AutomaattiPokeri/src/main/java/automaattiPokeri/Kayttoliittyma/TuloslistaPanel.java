package automaattiPokeri.Kayttoliittyma;

import automaattiPokeri.Interfaces.KoonMuuttaja;
import automaattiPokeri.Logiikka.TulosLista;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TuloslistaPanel extends JScrollPane implements KoonMuuttaja {
    private int x;
    private int y;
    private listaPanel lista;
    private TulosLista logiikka;

    public TuloslistaPanel(int x, int y, listaPanel lista) {
        super(lista);
        this.lista = lista;
        this.x = x;
        this.y = y;
        muutaKokoa(y, x);
        asetukset();
        tulostaPelaajatStatsit();
    }

    @Override
    public void muutaKokoa(int y, int x) {
        this.y = y;
        this.x = x;
        this.setBounds((x-800)/2, 100, 800, y-150);
    }

    private void tulostaPelaajatStatsit() {
        lista.poistakaikkiLabelit();
        ArrayList<String> pelaajat = logiikka.getPelaajaStringit();
        ArrayList<String> rahat = logiikka.getRahaStringit();
        ArrayList<String> voitot = logiikka.getVoittoStringit();
        for (int i = 0; i < pelaajat.size(); i++) {
            String tulos = i+1 + ". ";
            tulos += pelaajat.get(i);
            tulos += ": Suurin rahamäärä: ";
            tulos += rahat.get(i);
            tulos += " Suurin voitto: ";
            tulos += voitot.get(i);
            lista.lisaaLable(tulos);
        }
        lista.paivitaNakyma();
    }

    private void asetukset() {
        this.getViewport().setOpaque(false);
        this.setOpaque(false);
        this.setBorder(null);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        logiikka = new TulosLista();
    }
    
    
    
}
