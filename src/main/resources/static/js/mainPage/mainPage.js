//솔직한 베스트 후기 js

const element = document.querySelector('.BestReviewList-module_carouselTrack__hkZne');
const pArrow = document.querySelector('.bestReviewPrev');
const nArrow = document.querySelector('.bestReviewNext');
let count = 0;

pArrow.addEventListener('click', () => {
    count--;
    if (count < 1) {
        count = 0;
        element.style.transition = 'transform 1s ease';
        element.style.transform = 'translate(-' + 1125 * count + 'px';
    } else {
        element.style.transition = 'transform 1s ease';
        element.style.transform = 'translate(-' + 1125 * count + 'px';
    }
});

nArrow.addEventListener('click', () => {
    count++;
    if (count > 3) {
        count = 3;
        element.style.transition = 'transform 1s ease';
        element.style.transform = 'translate(-' + 1125 * count + 'px';
    } else {
        element.style.transition = 'transform 1s ease';
        element.style.transform = 'translate(-' + 1125 * count + 'px';
    }
});



// 법률 정보 js
// 슬라이크 전체 크기(width 구하기)
const slide = document.querySelector(".slick-track");
let slideWidth = 460;

// 슬라이드 전체를 선택해 값을 변경해주기 위해 슬라이드 전체 선택하기
let slideItems = document.querySelectorAll(".slick-slide");


// 버튼 클릭할 때 마다 현재 슬라이드가 어디인지 알려주기 위한 변수
let currSlide = 1;

// 무한 슬라이드를 위해 start, end 슬라이드 복사하기
const startSlide = slideItems[0];
const secondSlide = slideItems[1];
const thirdSlide = slideItems[2];
const endSlide = slideItems[slideItems.length - 1];
const startElem = document.createElement("div");
const endElem = document.createElement("div");
const startElem2 = document.createElement("div");
const startElem3 = document.createElement("div");

endSlide.classList.forEach((c) => {
    endElem.classList.add(c);
});
endElem.innerHTML = endSlide.innerHTML;

startSlide.classList.forEach((c) => {
    startElem.classList.add(c);
    startElem2.classList.add(c);
    startElem3.classList.add(c);
});
startElem.innerHTML = startSlide.innerHTML;
startElem2.innerHTML = secondSlide.innerHTML;
startElem3.innerHTML = thirdSlide.innerHTML;

// 각 복제한 엘리먼트 추가하기
slideItems[0].before(endElem);
slideItems = document.querySelectorAll(".slick-slide");
slideItems[slideItems.length-1].after(startElem);
slideItems = document.querySelectorAll(".slick-slide");
slideItems[slideItems.length-1].after(startElem2);
slideItems = document.querySelectorAll(".slick-slide");
slideItems[slideItems.length-1].after(startElem3);


let offset = 0;

// 현재 슬라이드 위치가 슬라이드 개수를 넘기지 않게 하기 위한 변수
const maxSlide = slideItems.length;
function nextMove() {
        currSlide++;
        offset = slideWidth * currSlide;
        // 마지막 슬라이드 이상으로 넘어가지 않게 하기 위해서
        if (currSlide === maxSlide-1) {
            slide.style.transition = 'transform 1s ease';
            slide.style.transform = "translate3d(-" + offset + "px, 0px, 0px)";
            currSlide = 0;
            setTimeout(() => {
                slide.style.transition = "none";
                slide.style.transform = "translate3d(-460px, 0px, 0px)";
            }, 0);
        } else {
            slide.style.transition = 'transform 1s ease';
            slide.style.transform = "translate3d(-" + offset + "px, 0px, 0px)";
        }
}



// 기본적으로 슬라이드 루프 시작하기
let loopInterval = setInterval(() => {
    nextMove();
}, 3000);

// 슬라이드에 마우스가 올라간 경우 루프 멈추기
slide.addEventListener("mouseover", () => {
    clearInterval(loopInterval);
});

// 슬라이드에서 마우스가 나온 경우 루프 재시작하기
slide.addEventListener("mouseout", () => {
    loopInterval = setInterval(() => {
        nextMove();
    }, 3000);
});


