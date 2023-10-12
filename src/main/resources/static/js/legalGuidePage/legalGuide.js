
// 조회순 최신순 클릭
const sortOptions = document.getElementsByClassName("sort-Options-Btn");


// 드롭다운
const optionMenu = document.querySelector(".select-Menu"),
    selectBtn = optionMenu.querySelector(".select-Btn"),
    options = optionMenu.querySelectorAll(".option"),
    sBtn_text = optionMenu.querySelector(".sBtn-Text");


// slider banner
let slides = document.querySelector('.slick-Track'),
    slide = document.querySelectorAll('.slick-Track .slick-Slide'),
    currentIdx = 0,
    slideCount = slide.length,
    orgslideCount = slide.length,
    prevBtn  =  document.querySelector('.rolling-Banner-Left-Btn'),
    slideWidth = 436,
    slideMargin = 24,
    nextBtn = document.querySelector('.rolling-Banner-Right-Btn');

const lastDIVParent= document.querySelector('.slick-Track');
const lastDIV = document.querySelector('.last-Slick-Slide');
const lastSecondDiv = document.querySelector('.last-Second-Slick-Slide');

// 조회순 최신순 클릭

for(let i = 0; i < sortOptions.length; i++) {
    sortOptions[i].addEventListener("click", function() {
        const current = document.getElementsByClassName("active");
        current[0].className = current[0].className.replace(" active", "");
        this.className += " active";
    });
}


// 드롭다운

selectBtn.addEventListener("click", () => optionMenu.classList.toggle("show"));

options.forEach(option => {
    option.addEventListener("click", () => {
        let selectedOption = option.querySelector(".option-Text").innerText;
        sBtn_text.innerText = selectedOption;
        optionMenu.classList.remove("show");
    })
});

// 배너
makeClone();
function makeClone(){
    for(let i = 0; i < slideCount; i++){
        let cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides.appendChild(cloneSlide);
    }
    for(let i = orgslideCount - 1; i >= 0; i--){
        let cloneSlide = slide[i].cloneNode(true);
        cloneSlide.classList.add('clone');
        slides.prepend(cloneSlide);
    }
    updateWidth();
    setInitialPos();
    setTimeout(function(){
        slides.classList.add('animated');
    },100);
}

function updateWidth(){
    let currentSlides = document.querySelectorAll('.slick-Track .slick-Slide');
    slideCount = currentSlides.length;
    let newWidth = (slideWidth + slideMargin) * slideCount + slideWidth + 921 + 'px';
    slides.style.width = newWidth;
}

function setInitialPos(){
    let initialTransLateValue = -(slideWidth + slideMargin) * orgslideCount;
    console.log(initialTransLateValue);

    slides.style.transform = 'translateX('+initialTransLateValue+'px)';
}

function moveSlide(num){
    // slides.style.left = -num * (slideWidth + slideMargin) + 'px';
    slides.style.left = -num * (slideWidth + slideMargin) + 460 + 'px'
    currentIdx = num
    if(orgslideCount == currentIdx || currentIdx == -(orgslideCount - 1)) {
        //slides.classList.remove('animated');
        setTimeout(function(){
            slides.style.left = '460px';
            currentIdx = 0;
            slides.classList.remove('animated');
        },500);
        setTimeout(function(){
            slides.classList.add('animated');
        },700);

    }

}

// clearInterval(timer);
let timer = undefined;
function autoSlide() {
    if(timer == undefined) {
        timer = setInterval(function(){
            moveSlide(currentIdx + 1)
        }, 3000);
    }

}
autoSlide();

// clearInterval(timer);
function stopSlide() {
    clearInterval(timer);
    timer = undefined;
    autoSlide();
}

nextBtn.addEventListener('click', function(){
    moveSlide(currentIdx + 1);
    stopSlide();
});
prevBtn.addEventListener('click', function(){
    moveSlide(currentIdx - 1);
    stopSlide();
});

lastDIVParent.insertBefore(lastDIV, lastDIVParent.firstChild);
lastDIVParent.insertBefore(lastSecondDiv, lastDIVParent.firstChild);
// if(lastDIV.nextSibling) {
//     lastDIVParent.insertBefore(lastSecondDiv, lastDIV.nextSibling);
// } else {
//     lastDIVParent.appendChild(lastSecondDiv);
// }
// lastDIV



