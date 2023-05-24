function add_div() {
    var div = document.createElement("div");
    div.className = "box";
    container.appendChild(div);

}

function remove_div() {
    var divs = container.getElementsByClassName("box");
    if (divs.length > 0) {
        container.removeChild(divs[0]);
    }
}

function change_color() {
    var divs = container.getElementsByClassName("box");
    if (divs.length >= 3) {
        var randomColor = getRandomColor();
        divs[2].style.backgroundColor = randomColor;
    }
}

function getRandomColor(alpha = false) {
    var color = "";
    var values = [];
    for (var i = 0; i < 3; i++) {
        values.push(Math.floor(Math.random() * 256));
    }
    if (alpha) {
        var alphaValue = Math.random().toFixed(2);
        color = `rgba(${values.join(",")},${alphaValue})`;
    } else {
        color = `rgb(${values.join(",")})`;
    }
    return color;
}

function nowy_tekst() {
    var boxElements = Array.from(container.getElementsByClassName("box"));
    boxElements.forEach(function (boxElement) {
        boxElement.textContent = "NOWY TEKST";
    });
}