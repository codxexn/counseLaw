// 드롭다운 js

const optionMenu = document.querySelector(".select-Menu"),
    selectBtn = optionMenu.querySelector(".select-Btn"),
    options = optionMenu.querySelectorAll(".option"),
    sBtn_text = optionMenu.querySelector(".sBtn-Text");

selectBtn.addEventListener("click", () => optionMenu.classList.toggle("show"));

options.forEach(option => {
    option.addEventListener("click", () => {
        var selectedOption = option.querySelector(".option-Text").innerText;
        sBtn_text.innerText = selectedOption;
        optionMenu.classList.remove("show");
    })
});

