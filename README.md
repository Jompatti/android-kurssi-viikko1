# TODO App
Sovellus täyttää kaikki tehtävän vaatimukset

## Datamalli

Projektissa on Task -data class, joka kuvaa yhden tehtävän.  
Jokaisella taskilla on seuraavat kentät:

- `id: Int` - yksilöllinen tunniste
- `title: String` - tehtävän otsikko
- `description: String` – tehtävän kuvaus
- `priority: Int` - prioriteetti (1 = matala, suurempi = korkeampi)
- `dueDate: String` - eräpäivä
- `done: Boolean` - kertoo, onko tehtävä valmis

Mock-data sisältää 6 esimerkkitehtävää, joita sovellus näyttää aluksi.

## Funktiot

Sovelluksessa on puhtaita Kotlin-funktioita, jotka käsittelevät task-listaa:

- `addTask(list, task): List<Task>`  
  Lisää uuden taskin listan loppuun ja palauttaa uuden listan.
  
- `toggleDone(list, id): List<Task>`  
  Kääntää tietyn taskin `done`-tilan päinvastaiseksi. Parametrina annetaan taskin `id`.
  
- `filterByDone(list, done): List<Task>`  
  Palauttaa listan, joka sisältää vain ne taskit, joiden `done`-tila vastaa parametria.
  
- `sortByDueDate(list): List<Task>`  
  Järjestää listan `dueDate`-kentän mukaan.

## Sovelluksen toiminta

- Sovellus käynnistyy ja näyttää listan tehtävistä.  
- Käyttäjä voi lisätä uusia tehtäviä, merkitä tehtäviä valmiiksi, suodattaa valmiit tehtävät ja järjestää tehtävät eräpäivän mukaan.
- Tällä hetkellä käyttäjä voi lisätä ainoastaan taskille otsikon, eli ei pysty säätämään itse prioriteettia, kuvausta tai eräpäivää.
- Taskit ovat LazyColumnin sisällä, joten niitä pystyy scrollaamaan


## Kuva käyttöliittymästä
<img width="360" height="780" alt="image" src="https://github.com/user-attachments/assets/7f791136-eeae-41ab-8d01-6775fa358bc6" />



