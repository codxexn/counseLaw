const sortOptions = document.getElementsByClassName("sort-Options-Btn");

for(var i = 0; i < sortOptions.length; i++) {
    sortOptions[i].addEventListener("click", function() {
        const current = document.getElementsByClassName("active");
        current[0].className = current[0].className.replace(" active", "");
        this.className += " active";
    });
}

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




























// mobile

const sortOptionsMobile = document.getElementsByClassName("sort-Options-Btn-mobile");

for(var i = 0; i < sortOptionsMobile.length; i++) {
    sortOptionsMobile[i].addEventListener("click", function() {
        const current = document.getElementsByClassName("activeMobile");
        current[0].className = current[0].className.replace(" activeMobile", "");
        this.className += " activeMobile";
    });
}


const optionMenuMobile = document.querySelector(".select-Menu-mobile"),
    selectBtnMobile = optionMenuMobile.querySelector(".select-Btn-mobile"),
    optionsMobile = optionMenuMobile.querySelectorAll(".option-mobile"),
    sBtn_textMobile = optionMenuMobile.querySelector(".sBtn-Text-mobile");

selectBtnMobile.addEventListener("click", () => optionMenuMobile.classList.toggle("showMobile"));

optionsMobile.forEach(option => {
    option.addEventListener("click", () => {
        var selectedOptionMobile = option.querySelector(".option-Text-mobile").innerText;
        sBtn_textMobile.innerText = selectedOptionMobile;
        optionMenuMobile.classList.remove("showMobile");
    })
});
