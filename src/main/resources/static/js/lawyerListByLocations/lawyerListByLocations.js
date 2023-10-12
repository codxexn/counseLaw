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

