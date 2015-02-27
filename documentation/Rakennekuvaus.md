Ohjelmassa on pääpaketin lisäksi interface paketti, käyttöliittymäpaketti, käyttöliittymäkuuntelijapaketti, logiikkapaketti ja tiedostonkäsittelypaketti.

**Käyttöliittymä**

Käyttöliittymäpakettiin sisältyy kaikki käyttöliittymässä käytetyt luokat. Suurin osa luokista extendaa JPaneelin ja täten luon hierarkisen rakenteen käyttöliittymään.

MainPaneeli sisältää valikon, jonka avulla vaihdetaan pelin eri tiloja, kuten pelistä tuloslistaan.

Mainpanel pitää sisällään siis myös itse pelin ja muut tilat.

Peli luokka pitää sisällään pari JLabelia esim rahamäärän kertomiseen tai peli loppui viestiin, Peli myös sisältää nappulan jolla uudent kortit jaetaan tai uusi peli luodaan. Tärkein asia pelissä on kuitenkin käsipanel joka taas sisältää 5 korttiPaneelia.

Käyttöliittymäluokat hoitavat myös kommunikoinnin logiikalle, joka taas kertoo käyttöliittymälle mitä kortteja esittää ja mikä on sen hetkinen rahamäärä.

**Käyttöliittymä kuuntelijat**

Käyttöliittymä tarvitsee toimiakseen pari kuuntelijaa, jotka on laitettu omaan pakkaukseen. Kuuntelijoissa ei ole mitään sen ihmeenpää kuin että ne kuuntelee ja kertovat käyttöliittymälle milloin toimia.

**Logiikka**

Logiikka taas pitää yllä Pakka ja käsi luokkia, jotka taas pitävät Kortti luokkia. Logiikka pitää yllä pelin kulkua näiden muiden luokkien avulla. Muut luokat ovat enemmänkin tietorakenteita. Esimerkiksi käsi pitää yllä viittä korttia, jotka logiikka antaa sille. Käsi luokka osaa myös laskea käden arvon.

Logiikka pakkauksessa on myös tuloslistaa laskeva luokka, joka hakee kaikki pelaajat ja laskee järjestyksen heille. Käyttöliittymä sitten hakee tältä luokalta tiedot ja esittää ne tuloslistassa.

**Tiedostokäsittelijät**
Tiedostokäsittelijä pakkauksessa on luokat jotka kirjoittavat ja lukevat tiedostoja. niille annetaan vain alin kansio ja tiedoston nimi ja ne hoitavat muut ongelmat kuten tiedostojen luonnin ja lukemisen tai kirjoittamisen. Kirjoittajalle annetaan lista stringejä, ja se kirjoittaa ne riveiksi, kun taas lukija palauttaa listan stringejä, joita se luki.

**Interfacet**

Ohjelma käyttää yhtä rajapintaa, KoonMuuttajaa. KoonMuuttaja rajapinnan toteuttaja saa vanhemman tai jonkin isovanhemman koon aina kun se muuttuu, ja laskee näiden tietojen avulla oman koon ja sijainnin. Se myös kertoo omille lapsilleen uuden koonsa.