package automaattiPokeri.KayttoliittymaKuuntelijat;

import automaattiPokeri.Kayttoliittyma.PelaajanNimiKysyja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NimiKenttaKuuntelija implements ActionListener {
    
    private PelaajanNimiKysyja kysyja;

    public NimiKenttaKuuntelija(PelaajanNimiKysyja kysyja) {
        this.kysyja = kysyja;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nimi = e.getActionCommand();
        if (nimi.length() <= 100 && !nimi.isEmpty()) {
            kysyja.setNimi(nimi);
        }
        
    }

}
