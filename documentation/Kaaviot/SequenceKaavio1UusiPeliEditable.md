title Uusi peli


MainPanel->Peli: new
Peli -> Logiikka: new
Logiikka -> Pakka: new
Logiikka -> Kasi: new
Peli -> Logiikka: taytaKasi()
Logiikka -> Pakka: sekoitaKortit()

loop voiLisata()
    Logiikka -> Pakka: otaKortti()
    Logiikka -> Kasi: lisaaKortti()
end

Peli -> PakkaPanel: new
Peli -> kokoKuuntelija: new
PakkaPanel -> kokoKuuntelija: this

Peli -> KasiPanel: new

loop 0..4
    KasiPanel->KorttiPanel: new
end



note over Peli: Myös kun uusiJako():

Peli -> Logiikka: poistaPanos()
Peli -> Logiikka: tyhjennaKasi()

loop 0..4
    Logiikka->Pakka: lisaaKortti()
    Logiikka -> kasi: poistaKortti()
end

Peli -> Logiikka: TaytaKasi()
Logiikka -> Pakka: sekoitaKortit()

loop voiLisata()
    Logiikka-> Pakka: otaKortti()
    Logiikka->Kasi: lisaaKortti()
end