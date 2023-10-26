const info = document.querySelector(".location-lawyers__info-area");
const closedButton = document.querySelector(".location-lawyers__info-area-close");
const open = document.querySelector(".location-lawyers__info-button");


open.addEventListener('click', (e) => {
   if (info.style.visibility === 'visible') {
       info.style.visibility = 'hidden';
   } else {
       info.style.visibility = 'visible';
   }
})

closedButton.addEventListener('click', (e) => {
    info.style.visibility = 'hidden';
})

const loc = document.querySelector(".premium-lawyer-section--title").offsetTop;
const aside = document.querySelector(".aside-section");
const hidden = document.querySelector(".hidden-div").offsetTop;
window.addEventListener("scroll", (e) => {
    let cur = window.scrollY;
    if (cur >= loc + 200 && cur <= hidden-600){
        if (!aside.classList.contains("fixed")){
            aside.classList.add("fixed");
        }
    } else {
        if (aside.classList.contains("fixed")){
            aside.classList.remove("fixed");
        }
    }
    if (cur >= hidden - 600 && cur <= hidden){
        if (!aside.classList.contains("bottom-fix")){
            aside.classList.add("bottom-fix");
            if (aside.classList.contains("fixed")){
                aside.classList.remove("fixed");
            }
        }
    } else {
        if (aside.classList.contains("bottom-fix")){
            aside.classList.remove("bottom-fix");
        }
    }
})
