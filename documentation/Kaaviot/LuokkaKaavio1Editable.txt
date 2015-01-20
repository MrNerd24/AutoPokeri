http://yuml.me/diagram/scruffy/class/

[Logiikka] ->1 [Pakka]
[Pakka] ->0..52 [Kortti]
[Logiikka] ->1 [Kasi]
[Kasi] ->0..5 [kortti]

[Jarjestaja] -> [Logiikka]
[Jarjestaja] -> [TallennusPalvelu]
[Jarjestaja] -> [TulosPalvelu]

[TallennusPalvelu] -> [TiedostoLukija]
[TallennusPalvelu] -> [TiedostoKirjoittaja]
[TallennusPalvelu] -> [Tilanne]
[TulosPalvelu] -> [Tulos]
[TulosPalvelu] -> [TiedostoLukija]
[TulosPalvelu] -> [TiedostoKirjoittaja]

[KayttoLiittyma] -> [Jarjestaja]