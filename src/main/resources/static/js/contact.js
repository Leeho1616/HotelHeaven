function toggleAnswer(answerId) {
    var answerElement = document.getElementById(answerId);
    var symbol = answerElement.previousElementSibling.querySelector('.toggle-symbol');
    if (answerElement.classList.contains("hidden")) {
        answerElement.classList.remove("hidden");
        symbol.textContent = "−";
    } else {
        answerElement.classList.add("hidden");
        symbol.textContent = "+";
    }
}
