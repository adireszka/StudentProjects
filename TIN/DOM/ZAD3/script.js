var cars = [
    { nazwa: "Audi", rok: 2004, przebieg: 10000, cena_wyjsciowa: 10000, cena_koncowa: 8000 },
    { nazwa: "Bugatti", rok: 2012, przebieg: 200, cena_wyjsciowa: 1000000, cena_koncowa: 800000 },
    { nazwa: "Lamborghini", rok: 2014, przebieg: 140, cena_wyjsciowa: 1000000, cena_koncowa: 700000 },
    { nazwa: "Cupra", rok: 2008, przebieg: 1000, cena_wyjsciowa: 600000, cena_koncowa: 400000 },
];

function generateTable() {
    var tableContainer = document.getElementById("table-container");
    var table = document.createElement("table");
    var thead = document.createElement("thead");
    var tbody = document.createElement("tbody");
    var headers = ["Nazwa", "Rok", "Przebieg [km]", "Cena wyjściowa [zł]", "Cena końcowa [zł]"];
    var headerRow = document.createElement("tr");
    headers.forEach(function (header) {
        var th = document.createElement("th");
        th.textContent = header;
        headerRow.appendChild(th);
    });
    thead.appendChild(headerRow);
    table.appendChild(thead);


    cars.forEach(function (car) {
        var row = document.createElement("tr");
        var nazwaCell = document.createElement("td");
        nazwaCell.textContent = car.nazwa;
        row.appendChild(nazwaCell);
        var rokCell = document.createElement("td");
        rokCell.textContent = car.rok;
        row.appendChild(rokCell);
        var przebiegCell = document.createElement("td");
        przebiegCell.textContent = car.przebieg;
        row.appendChild(przebiegCell);
        var cenaWyjsciowaCell = document.createElement("td");
        cenaWyjsciowaCell.textContent = car.cena_wyjsciowa;
        row.appendChild(cenaWyjsciowaCell);
        var cenaKoncowaCell = document.createElement("td");
        cenaKoncowaCell.textContent = car.cena_koncowa;
        row.appendChild(cenaKoncowaCell);
        tbody.appendChild(row);
    });
    table.appendChild(tbody);
    tableContainer.appendChild(table);
}
generateTable();