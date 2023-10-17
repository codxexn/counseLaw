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


const searchForm = document.getElementById("searchForm");
const inputElement = document.getElementById("search_keyword");
const selectedOption = document.getElementById("selectedOption").value;

searchForm.addEventListener("submit", function(event) {
    event.preventDefault();
    const keyword = inputElement.value;

    if (keyword.trim() === "") {
        window.location.href = `/manager/manager-mainpage?selectedOption=${selectedOption}`;
    } else {
        window.location.href = `/manager/manager-mainpage?keyword=${encodeURIComponent(keyword)}&selectedOption=${selectedOption}`;
    }
});
// Pagination buttons
const paginationButtons = document.querySelectorAll(".footerButton");

paginationButtons.forEach(button => {
    button.addEventListener("click", function(event) {
        event.preventDefault();
        const buttonpage = this.getAttribute("data-page");

        if (buttonpage) {
            window.location.href = `/manager/manager-mainpage?selectedOption=${selectedOption}&keyword=${encodeURIComponent(keyword)}&page=${buttonpage}`;
        }
    });
});