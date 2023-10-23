// const filterWrapper = document.querySelector(".upDownButtonWrapper");
// const  upImg = filterWrapper.firstElementChild;
// const downImg = filterWrapper.lastElementChild;
// const option = document.querySelector('.filter-item-option');
//
// filterWrapper.addEventListener('click', () => {
//     if (upImg.style.display === 'none') {
//         downImg.style.display = 'none';
//         upImg.style.display = 'block';
//         option.style.display = 'none';
//     } else {
//         upImg.style.display = 'none';
//         downImg.style.display = 'block';
//         option.style.display = 'block';
//     }
// });



const buttons = document.querySelectorAll('.filter-item-button__label');

buttons.forEach((button)=> {
    button.addEventListener('click', (e) => {
        const target = e.target;
        if (target.className === 'filter-item-button__label') {
            target.className = 'filter-item-button__label_click';
        } else {
            target.className = 'filter-item-button__label';
        }
    })
})

const loc = document.querySelector(".premium-lawyer-section--title").offsetTop;
const aside = document.querySelector(".aside-section");
const hidden = document.querySelector(".hidden-div").offsetTop;
window.addEventListener("scroll", (e) => {
    let cur = window.scrollY;
    if (cur >= loc){
        if (!aside.classList.contains("fixed")){
            aside.classList.add("fixed");
        }
    } else {
        if (aside.classList.contains("fixed")){
            aside.classList.remove("fixed");
        }
    }
    if (cur >= hidden - 800){
        if (!aside.classList.contains("bottom-fix")){
            aside.classList.add("bottom-fix");
        }
    } else {
        if (aside.classList.contains("bottom-fix")){
            aside.classList.remove("bottom-fix");
        }
    }
})