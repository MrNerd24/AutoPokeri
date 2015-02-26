title palautaPakkaan

loop Käyttäjä painaa korttia
    KorttiKuuntelija -> Peli: korttiPainettu(index)
    Peli -> KasiPanel: aktivoiKortti(index)
    KasiPanel -> KorttiPanel: valinta(index)
end

note over Peli: Kayttaja painaa palauta pakkaan nappulaa

loop Kaikille ei painetuille korteille
    Peli-> Logiikka: palautaPakkaan()
    Logiikka -> Pakka: lisaaKortti()
    Logiikka -> Kasi: poistaKortti()
    Peli -> KasiPanel: aktivoiKortti(index)
end

Peli -> Logiikka: taytaKasi()
loop voiLisata()
    Logiikka->Pakka: otaKortti()
    Logiikka->Kasi: lisaaKortti()
end

Peli -> Logiikka: palkitse()
Logiikka -> Kasi: getArvo()