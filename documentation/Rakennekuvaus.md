Ohjelmassa on p��paketin lis�ksi interface paketti, k�ytt�liittym�paketti, k�ytt�liittym�kuuntelijapaketti, logiikkapaketti ja tiedostonk�sittelypaketti.

**K�ytt�liittym�**

K�ytt�liittym�pakettiin sis�ltyy kaikki k�ytt�liittym�ss� k�ytetyt luokat. Suurin osa luokista extendaa JPaneelin ja t�ten luon hierarkisen rakenteen k�ytt�liittym��n.

MainPaneeli sis�lt�� valikon, jonka avulla vaihdetaan pelin eri tiloja, kuten pelist� tuloslistaan.

Mainpanel pit�� sis�ll��n siis my�s itse pelin ja muut tilat.

Peli luokka pit�� sis�ll��n pari JLabelia esim raham��r�n kertomiseen tai peli loppui viestiin, Peli my�s sis�lt�� nappulan jolla uudent kortit jaetaan tai uusi peli luodaan. T�rkein asia peliss� on kuitenkin k�sipanel joka taas sis�lt�� 5 korttiPaneelia.

K�ytt�liittym�luokat hoitavat my�s kommunikoinnin logiikalle, joka taas kertoo k�ytt�liittym�lle mit� kortteja esitt�� ja mik� on sen hetkinen raham��r�.

**K�ytt�liittym� kuuntelijat**

K�ytt�liittym� tarvitsee toimiakseen pari kuuntelijaa, jotka on laitettu omaan pakkaukseen. Kuuntelijoissa ei ole mit��n sen ihmeenp�� kuin ett� ne kuuntelee ja kertovat k�ytt�liittym�lle milloin toimia.

**Logiikka**

Logiikka taas pit�� yll� Pakka ja k�si luokkia, jotka taas pit�v�t Kortti luokkia. Logiikka pit�� yll� pelin kulkua n�iden muiden luokkien avulla. Muut luokat ovat enemm�nkin tietorakenteita. Esimerkiksi k�si pit�� yll� viitt� korttia, jotka logiikka antaa sille. K�si luokka osaa my�s laskea k�den arvon.

Logiikka pakkauksessa on my�s tuloslistaa laskeva luokka, joka hakee kaikki pelaajat ja laskee j�rjestyksen heille. K�ytt�liittym� sitten hakee t�lt� luokalta tiedot ja esitt�� ne tuloslistassa.

**Tiedostok�sittelij�t**
Tiedostok�sittelij� pakkauksessa on luokat jotka kirjoittavat ja lukevat tiedostoja. niille annetaan vain alin kansio ja tiedoston nimi ja ne hoitavat muut ongelmat kuten tiedostojen luonnin ja lukemisen tai kirjoittamisen. Kirjoittajalle annetaan lista stringej�, ja se kirjoittaa ne riveiksi, kun taas lukija palauttaa listan stringej�, joita se luki.

**Interfacet**

Ohjelma k�ytt�� yht� rajapintaa, KoonMuuttajaa. KoonMuuttaja rajapinnan toteuttaja saa vanhemman tai jonkin isovanhemman koon aina kun se muuttuu, ja laskee n�iden tietojen avulla oman koon ja sijainnin. Se my�s kertoo omille lapsilleen uuden koonsa.