title Vaihda kayttajaa

note over ValikkoNappulaKuuntelija: kayttaja klikkaa "vaihda kayttajaa"

ValikkoNappulaKuuntelija->MainPanel: muutaPanel()
MainPanel->PelaajaNimiKysyja: new
PelaajaNimiKysyja->NimikenttaKuuntelija: new

note over NimikenttaKuuntelija: kayttaja on syotanyt nimen ja klikannut enter

NimikenttaKuuntelija->PelaajaNimiKysyja: setNimi()
PelaajaNimiKysyja->MainPanel: setNimi()
MainPanel-> Valikko: vaihdaKayttajaNimi()
MainPanel-> TiedostoKirjoittaja: new (tiedostoon viimeisinKayttaja)
MainPanel-> TiedostoKirjoittaja: kirjoita()