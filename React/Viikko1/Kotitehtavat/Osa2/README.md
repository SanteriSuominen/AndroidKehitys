# LaskuriSovellus

Android-kehityksen kurssi — viikko 1, kotitehtävät, osa 2.

Yksinkertainen React Native -laskuri, joka on tehty Kotlinin ja Jetpack Composen käsitteiden opettelun jatkoksi. Toteutuksessa käytetään Expoa, TypeScriptiä ja Expo Routeria.

## Toiminnot

- Lisää kasvattaa lukua yhdellä.
- Vähennä pienentää lukua yhdellä.
- Nollaa palauttaa luvun nollaan.
- Tila säilytetään Reactin `useState`-hookilla; sitä ei tallenneta pysyvästi.

## Käynnistys

Avaa terminaali tässä kansiossa:

```bash
npm ci
npx expo start --go
```

Avaa projekti Expo Gossa. Puhelimen Expo Go -version on tuettava projektin Expo SDK 58:aa.

Androidin debug-yhteyden kautta voi käyttää porttiohjausta:

```bash
adb reverse tcp:8081 tcp:8081
npx expo start --go --localhost --port 8081
```

Avaa tämän jälkeen `exp://127.0.0.1:8081` Expo Gossa tai paina terminaalissa `a`, kun Android-laite on yhdistetty ADB:llä. Pidä kehityspalvelin käynnissä. Sulje mahdollinen toinen porttia 8081 käyttävä Expo-palvelin ensin.

## Tarkistukset

```bash
npx expo lint
npx tsc --noEmit
```

## Tärkeimmät tiedostot

- `src/app/index.tsx`: laskurin käyttöliittymä ja tila.
- `src/app/_layout.tsx`: Expo Routerin navigaation perusasettelu.
- `app.json`: Expon sovellusasetukset.
