[Logiikka] ->1 [Pakka]
[Pakka] ->0..52 [Kortti]
[Logiikka] ->1 [Kasi]
[Kasi] ->0..5 [kortti]

[Main] -> [KayttoLiittyma]
[KayttoLiittyma] -> [MainPanel]
[MainPanel] -> [Valikko]
[MainPanel] -> [Peli]
[MainPanel] -> [topLista]
[Valikko] -> [valikkoNappulaKuuntelija]
[valikkoNappulaKuuntelija] -> [MainPanel]
[Peli] -> [PakkaPanel]
[Peli] <-> [KasiPanel]
[KorttiPanel] -> [Peli]
[KasiPanel] ->0..5 [KorttiPanel]


[KorttiPanel] -> [KorttiKuuntelija]
[KorttiKuuntelija] -> [Peli]

[Peli] -> [Logiikka]
[Peli] -> [Pelaaja]
[Pelaaja] -.-> [TiedostoKirjoittaja]
[Pelaaja] -.-> [TiedostoLukija]
[TopLista] ->* [Pelaaja]