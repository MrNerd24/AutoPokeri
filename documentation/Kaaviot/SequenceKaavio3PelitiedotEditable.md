title Pelitietojen tallentaminen ja lukeminen

MainPanel->TiedostoLukija: new
note over MainPanel,TiedostoLukija: Lukee viimeisinKayttaja tiedostoa.
MainPanel->TiedostoLukija: tiedostoOlemassa()
MainPanel->TiedostoLukija: getRivit()

MainPanel->Peli: new
Peli->Pelaaja: new

note over Peli: aina kun uusiJako:

Peli->Pelaaja: setSuurinRahamaara()
Peli->Pelaaja: setkaynnissaRahamaara()
Peli->Pelaaja: setkaynnissaPanos()
Peli->Pelaaja: tallennaTiedot()
Pelaaja->TiedostoKirjoittaja: new
Pelaaja->TiedostoKirjoittaja: kirjoita()