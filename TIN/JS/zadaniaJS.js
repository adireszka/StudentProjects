// 1. Napisz funkcję, sprawdzającą, czy dane trzy liczby tworzą „trójkę pitagorejską” (uwaga – liczby nie muszą być podane w kolejności rosnącej).
function czyPitagoras(a, b, c){
    const sorted = [a, b, c].sort();
    if (sorted[0] + sorted[1] > sorted[2])
        console.log('Z liczb ' + sorted[0] + ', ' + sorted[1] + ' i ' + sorted[2] + ' można utworzyć trójkąt pitagorejski');
    else
        console.log('Z liczb ' + sorted[0] + ', ' + sorted[1] + ' i ' + sorted[2] + ' nie można utworzyć trójkąta pitagorejskiego');
}

// 2. Napisz funkcję wypisującą wszystkie liczby z przedziału a-b, podzielne przez c.
function wypiszPodzielne(a, b, c){
    while (a != b+1){
        if(a%c == 0)
            console.log(a);
        a++;
    }
}

// 3. Napisz funkcję wypisującą w konsoli tabliczkę mnożenia o boku podanym jako parametr.
function tabliczkaMnozenia(n){
    for (let i = 1; i <= n; i++) {
        let row = '';
        for (let j = 1; j <= n; j++) {
          row += (i * j) + ' ';
        }
        console.log(row.trim());
      }
}

// 4. Napisz funkcję wypisującą w konsoli ciąg Fibonacciego o długości podanej jako parametr.
function ciagFibonacciego(n){
    let a = 0, b = 1;
    for (let i = 0; i < n; i++) {
        console.log(a);
        let temp = a;
        a = b;
        b = temp + b;
    }
}

// 5. Napisz funkcję rysującą choinkę o podanej wysokości.
function rysujChoinke(n){
    let i = 1;
    for (let i = 1; i <= n; i++){
        let row = '';
        for (let j = 1; j <= i; j++){
            row += '*';
        }
        console.log(row);
    }
}

// 6. Napisz funkcję rysującą „choinkę nocą” o podanej wysokości (szerokość jest tu nieco większa niż wysokość).
function choinkaNoca(n) {
    let podstawa = '';
    let wiersz = '';
    let iloscSpacji = 1;
    iloscGwiazdek = n+3

    for (let i = 1; i <= iloscGwiazdek+2; i++){
        podstawa += '*';
    }

    console.log(podstawa);

    for (let i = 0; i < n; i++) {
        let wiersz = '*'.repeat(iloscGwiazdek/2);
    
        for (let j = 0; j < iloscSpacji; j++) {
          wiersz += ' ';
        }
    
        for (let j = iloscGwiazdek/2; j >= 0; j--) {
          wiersz += '*';
        }
    
        console.log(wiersz);

        iloscGwiazdek--;
        iloscSpacji += 2;
    }
    
    console.log(podstawa);
}

// 7. Napisz funkcję liczącą pole wybranej figury (prostokąt, trapez, równoległobok, trójkąt) z wykorzystaniem instrukcji switch. Każda figura powinna mieć osobną funkcję do liczenia pola.
function obliczPole(figura, ...parametry) {
    switch(figura){
        case 'prostokąt':
            return poleProstokata(...parametry);
        case 'trapez':
            return poleTrapezu(...parametry);
        case 'równoległobok':
            return poleRownolegloboku(...parametry);
        case 'trójkat':
            return poleTrojkata(...parametry);
        default:
            console.log('Nie ma takiej figury!')
    }
}

function poleProstokata(a, b){
    wynik = a * b;
    console.log("Pole zadanego prostokąta wynosi " + wynik);
}
function poleTrapezu(a, b, h){
    wynik = (a + b) * h / 2;
    console.log("Pole zadanego trapezu wynosi " + wynik);
}
function poleRownolegloboku(a, h){
    wynik = a * h;
    console.log("Pole zadanego równoległoboku wynosi " + wynik);
}
function poleTrojkata(a, h){
    wynik = a * h / 2;
    console.log("Pole zadanego trójkąta wynosi " + wynik);
}

// 8. Napisz funkcję liczącą pole wybranej figury (prostokąt, trapez, równoległobok, trójkąt) bez użycia instrukcji warunkowej (bez if, switch, pętli). Wykorzystaj funkcje anonimowe i callback.
function obliczPoleV2(figura, ...parametry){
    const figury = {
        prostokat: (a, b) => a * b,
        trapez: (a, b, h) => (a + b) * h / 2,
        rownoleglobok: (a, h) => a * h,
        trojkat: (a, h) => a * h / 2
    };
    const pole = figury[figura]?.(...parametry);
    if (!pole)
        throw new Error('Nieznany typ figury!');
    console.log("Pole wybranej figury (" + figura + ") wynosi " + pole);
}

// 9. Napisz funkcję wypisującą w konsoli trójkąt Pascala o wysokości podanej jako parametr.
function rysujTrojkat(n) {
    let trojkat = [];
    for (let i = 0; i < n; i++) {
        trojkat[i] = [];
        trojkat[i][0] = 1;
        for (let j = 1; j < i; j++) 
            trojkat[i][j] = trojkat[i - 1][j - 1] + trojkat[i - 1][j];
        trojkat[i][i] = 1;
    }

    for (let i = 0; i < n; i++) {
        let wiersz = "";
        for (let j = 0; j <= i; j++) 
            wiersz += trojkat[i][j] + " ";
        console.log(wiersz);
    }
}

// 10. Napisz funkcję cenzurującą zdanie. Funkcja ma otrzymać 2 parametry: tablicę niedozwolonych słów oraz zdanie do ocenzurowania. Każde niedozwolone słowo ma zostać zastąpione znakiem *.
function cenzuruj(niedozwolone, zdanie) {
    zdanie = zdanie.replace(/[.,!?_]/g, "");
    let slowa = zdanie.split(' ');

    for (let i = 0; i < slowa.length; i++) {
        if (niedozwolone.includes(slowa[i])) {
            slowa[i] = '*'.repeat(slowa[i].length);
        }
    }
  
    console.log(slowa.join(' '));
}

// Zadanie 11
class Auto {
    constructor(rok, przebieg, cena_wyjsciowa, cena_koncowa) {
        this.rok = rok;
        this.przebieg = przebieg;
        this.cena_wyjsciowa = cena_wyjsciowa;
        this.cena_koncowa = cena_koncowa;
    }

    zwiekszCene = function(){this.cena_wyjsciowa += 1000}
    obnizCeneWgWieku = function(){
        let wiek = new Date().getFullYear() - this.rok;
        let obnizka = Math.floor(wiek * 1000);
        this.cena_koncowa -= obnizka;
    }
    obnizCeneWgPrzebiegu = function(){
        let obnizka = Math.floor(this.przebieg / 100000) * 10000;
        this.cena_koncowa -= obnizka;
    }
    dodajPrzebiegIRok = function(przebieg, rok){
        this.przebieg = przebieg;
        this.rok = rok;
        this.obnizCeneWgWieku();
        this.obnizCeneWgPrzebiegu();
    }
}

let samochody = [];

function dodajAuto(rok, przebieg, cena_wyjsciowa, cena_koncowa) {
    let noweAuto = new Auto(rok, przebieg, cena_wyjsciowa, cena_koncowa);
    if (noweAuto.cena_wyjsciowa > 10000) {
      samochody.push(noweAuto);
    }
}

function zwiekszRok() {
    samochody.forEach(function(auto) {
      auto.rok++;
    });
}

let BMW = new Auto(2004, 200000, 35000, 30000);

// Zadanie 12
class Ocena{
    constructor(przedmiot, wartosc){
        this.przedmiot = przedmiot;
        this.wartosc = wartosc;
    }
}

class Student{
    constructor(imie, nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this._oceny = [];
        this.srednia = 0;
    }

    hello = function(){
        return (`Witaj ${this.imie} ${this.nazwisko}, Twoja średnia ocen to: ${this.srednia}`);
    }

    get oceny(){
        let tekst = "";
        for (const ocena of this._oceny){
            tekst += `Przedmiot: ${ocena.przedmiot} - ocena ${ocena.wartosc}. `;
        }
        return tekst;
    }

    set oceny(x){
        if (x instanceof Ocena){
            this._oceny.push(x);
            this.srednia = this._oceny.reduce((a,b) => a+b.wartosc, 0) / this._oceny.length;
        } else {
            throw new Error("Eror");
        }
    }
}

let s = new Student("Mateusz", "Gdański");
s.oceny = new Ocena("PRI", 3);
s.oceny = new Ocena("SKOA", 2);
s.oceny = new Ocena("TIN", 5);
