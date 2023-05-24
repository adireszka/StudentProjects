function calculate() {
    var num1 = parseFloat(document.getElementById("num1").value);
    var num2 = parseFloat(document.getElementById("num2").value);
    var operation = document.getElementById("operation").value;
    var resultElement = document.getElementById("result");

    var result;
    switch (operation) {
        case "add":
            result = num1 + num2;
            break;
        case "subtract":
            result = num1 - num2;
            break;
        case "multiply":
            result = num1 * num2;
            break;
        case "divide":
            if (num2 === 0) {
                resultElement.textContent = "ERROR!";
                resultElement.classList.add("error");
                return;
            }
            result = (num1 / num2).toFixed(10);
            break;
        default:
            resultElement.textContent = "ERROR!";
            resultElement.classList.add("error");
            return;
    }

    resultElement.textContent = result;
}