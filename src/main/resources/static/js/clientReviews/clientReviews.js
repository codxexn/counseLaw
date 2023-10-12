
// 신고하기 버튼 나오는 것
const moreButtons = document.querySelectorAll(".profile-review-more");


moreButtons.forEach((button) => {
    let first = button.firstElementChild.firstElementChild;
    let second = button.lastElementChild;
    first.addEventListener('click', (e) => {
       if (second.style.display === 'flex') {
           second.style.display = 'none'
       } else {
           second.style.display = 'flex'
       }
    })
})


// 후기 슬라이드 효과
const element = document.querySelector('.best-reviews__container');
const prev = document.querySelector('.prevArrow');
const next = document.querySelector('.nextArrow');
let count = 0;
const current = document.querySelector('.current');



prev.addEventListener('click', () => {
    count--;
    if (count < 1) {
        count = 0;
        element.style.transition = 'transform 0s';
        element.style.transform = 'translate(-' + 722 * count + 'px';
    } else {
        element.style.transition = 'transform 0s';
        element.style.transform = 'translate(-' + 722 * count + 'px';
    }
    current.innerText = count + 1;
});

next.addEventListener('click', () => {
    count++;
    if (count > 9) {
        count = 9;
        element.style.transition = 'transform 0s';
        element.style.transform = 'translate(-' + 722 * count + 'px';
    } else {
        element.style.transition = 'transform 0s';
        element.style.transform = 'translate(-' + 722 * count + 'px';
    }
    current.innerText = count + 1;
});

// 모든 분야 버튼
const filterButton = document.querySelector('.review-filter');
const buttonImg = document.querySelector('.filterArrow');
const lists = document.querySelector('.filter-list');

filterButton.addEventListener('click', () => {
    if (lists.style.display === 'block') {
        buttonImg.src = 'down.png'
        lists.style.display = 'none'
    } else {
        buttonImg.src = 'up.png'
        lists.style.display = 'block'
    }
})

// 즐겨 찾기 별 이미지 변환
const starImage = document.querySelector('.star');
starImage.addEventListener("click",
    (e) =>  {
        if(e.target.src.includes("yellowStar.png")){
            e.target.src = "./blankedStar.png"
        } else {
            e.target.src = "./yellowStar.png"
        }
    })

// 상담 예약하기 누르면 예약 module 띄우기
const reservationButton = document.querySelector('.ReservationPricePanel-module_reserveButtonBottom__iUPKk');
const  module = document.querySelector('.profile-page__reservation-sheet');
const closeButton = document.querySelector('.closeWhite');

reservationButton.addEventListener('click', ()=> {
    module.className = module.className + '--visible';
})

closeButton.addEventListener('click', () => {
    module.className = 'profile-page__reservation-sheet';
})


// 화살표 누르면
const children = document.querySelectorAll('.IconDropdown-module_iconDropdownHeader__URGu7');
children.forEach((child) => {
    child.addEventListener('click', (e) => {
        if (child.parentElement.className.includes('IconDropdown-module_isOpened__iilty')) {
            child.parentElement.className = 'IconDropdown-module_iconDropdown__zgosj';
        } else {
            child.parentElement.className = 'IconDropdown-module_iconDropdown__zgosj IconDropdown-module_isOpened__iilty';
        }
    })
})

// 버튼 선택시
let typeselect = false;
let dateselect = false;
let timeselect = false;


const typeButtons = document.querySelectorAll('.ReservationSheet-module_typeButton__Yj3zD');
const dateButtons = document.querySelectorAll('.ReservationSheet-module_dateButton__4uTaz');
const timeButtons = document.querySelectorAll('.ReservationSheet-module_timeIndexButton__Dr2YA');
const reservationNextButton = document.querySelector('.ReservationSheet-module_nextButton__-mYex-disabled');
typeButtons.forEach((type) => {
    type.addEventListener('click', (e)=> {
        typeButtons.forEach((button) => {
            button.className = 'ReservationSheet-module_typeButton__Yj3zD';
        })

        if (type.className.includes('select')) {
            type.className = 'ReservationSheet-module_typeButton__Yj3zD';
        } else {
            type.className = 'ReservationSheet-module_typeButton__Yj3zD-select';
            typeselect = true;
        }

        if (typeselect && dateselect && timeselect) {
            reservationNextButton.className = 'ReservationSheet-module_nextButton__-mYex';
        }
    })
})

dateButtons.forEach((data) => {
    data.addEventListener('click', (e)=> {
        dateButtons.forEach((button) => {
            button.className = 'ReservationSheet-module_dateButton__4uTaz';
        })

        if (data.className.includes('select')) {
            data.className = 'ReservationSheet-module_dateButton__4uTaz';
        } else {
            data.className = 'ReservationSheet-module_dateButton__4uTaz-select';
            dateselect = true;
        }

        if (typeselect && dateselect && timeselect) {
            reservationNextButton.className = 'ReservationSheet-module_nextButton__-mYex';
        }
    })
})

timeButtons.forEach((time) => {
    time.addEventListener('click', (e)=> {
        timeButtons.forEach((button) => {
            button.className = 'ReservationSheet-module_timeIndexButton__Dr2YA';
        })

        if (time.className.includes('select')) {
            time.className = 'ReservationSheet-module_timeIndexButton__Dr2YA';
        } else {
            time.className = 'ReservationSheet-module_timeIndexButton__Dr2YA-select';
            timeselect = true;
        }

        if (typeselect && dateselect && timeselect) {
            reservationNextButton.className = 'ReservationSheet-module_nextButton__-mYex';
        }
    })
})


// 쿠폰 발급시
const couponButton = document.querySelector('.ReservationPricePanel-module_couponButton__SuusI');
const alreadyDownloaded = document.querySelector('.ReservationPricePanel-module_isAlreadyDownloadedCoupon__0jwVU');
couponButton.addEventListener('click', (e)=> {
    couponButton.style.display = 'none';
    Swal.fire(
        '쿠폰 발급 완료',
        '쿠폰이 정상 발급되었습니다. <br> 내 쿠폰함을 확인해주세요.',
        'success'
    )
    alreadyDownloaded.style.display = 'flex';
})

