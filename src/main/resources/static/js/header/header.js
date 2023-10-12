// 상단 서치바 js
const button = document.querySelector(".deleteAllButton");
const input = document.querySelector(".searchInput");

input.addEventListener("keyup", () => {
    if(input.value) {
        button.style.visibility = "visible";
    } else {
        button.style.visibility = "hidden";
    }
})

button.addEventListener("click", () => {
    input.value = "";
    button.style.visibility = "hidden";
})


// NavMenu js
const menuListButtons = document.querySelectorAll(".realButton");

menuListButtons.forEach((button) => {
    button.addEventListener('click', (e) => {
        let target = e.target;
        menuListButtons.forEach((button) => {
            button.parentNode.className = 'menuItemButton';
        })

        target.parentNode.className = 'menuItemButtonActive';
    })
})


