// 후기 슬라이드 효과
const element = document.querySelector('.best-reviews__container');
const prev = document.querySelector('.prevArrow');
const next = document.querySelector('.nextArrow');
let count = 0;
const current = document.querySelector('.current');
let reviewLength = document.querySelector("input[name=reviewCounts]").value;


if (reviewLength > 0){
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
        if (count > reviewLength - 1) {
            count = reviewLength - 1;
            element.style.transition = 'transform 0s';
            element.style.transform = 'translate(-' + 722 * count + 'px';
        } else {
            element.style.transition = 'transform 0s';
            element.style.transform = 'translate(-' + 722 * count + 'px';
        }
        current.innerText = count + 1;
    });
}


// 즐겨 찾기 별 이미지 변환
const starImage = document.querySelector('.star');
if (starImage != null){
    starImage.addEventListener("click",
            (e) =>  {
                if(e.target.src.includes("yellowStar.png")){
                    e.target.src = "/image/lawyerHome/blankedStar.png";
                } else {
                    e.target.src = "/image/lawyerHome/yellowStar.png";
                }
    });
}


// 상담 예약하기 누르면 예약 module 띄우기
const reservationButton = document.querySelector('.ReservationPricePanel-module_reserveButtonBottom__iUPKk');
const  module = document.querySelector('.profile-page__reservation-sheet');
const closeButton = document.querySelector('.closeWhite');

reservationButton.addEventListener('click', ()=> {
    module.className = module.className + '--visible';
    closeButton.style.display = "inline";
});

closeButton.addEventListener('click', () => {
    module.className = 'profile-page__reservation-sheet';
    closeButton.style.display = "none";
});


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
// const couponButton = document.querySelector('.ReservationPricePanel-module_couponButton__SuusI');
// const alreadyDownloaded = document.querySelector('.ReservationPricePanel-module_isAlreadyDownloadedCoupon__0jwVU');
// couponButton.addEventListener('click', (e)=> {
//     couponButton.style.display = 'none';
//     Swal.fire(
//         '쿠폰 발급 완료',
//         '쿠폰이 정상 발급되었습니다. <br> 내 쿠폰함을 확인해주세요.',
//         'success'
//     )
//     alreadyDownloaded.style.display = 'flex';
// })

// 공유 버튼 클릭 시 클립보드에 url 복사하기
function clipCopy() {
    let dummy = document.createElement("textarea");
    document.body.appendChild(dummy);
    dummy.value = window.document.location.href;
    dummy.select();
    document.execCommand("copy");
    document.body.removeChild(dummy);
    Swal.fire(
        'URL 복사 완료',
        '주소가 클립보드에 복사되었습니다. <br> 원하는 곳에 붙여넣기 해주세요.',
        'success'
    );
}

// 상담예약 부분----------

const phoneSelect = document.querySelector(".phone-select");
const videoSelect = document.querySelector(".video-select");
const visitSelect = document.querySelector(".visit-select");
const totalPrice = document.querySelector(".total-price");
const callPrice = document.querySelector("input[name='callPrice']");
const videoPrice = document.querySelector("input[name='videoPrice']");
const visitPrice = document.querySelector("input[name='visitPrice']");
let consultingType = "";
phoneSelect.addEventListener("click", () => {
    totalPrice.innerText = callPrice.value + '원';
    consultingType = "PHONE";
})
videoSelect.addEventListener("click", () => {
    totalPrice.innerText = videoPrice.value + '원';
    consultingType = "VIDEO";
})
visitSelect.addEventListener("click", () => {
    totalPrice.innerText = visitPrice.value + '원';
    consultingType = "VISIT";
})

// 오늘 날짜 기준으로 날짜 넣기
const days = document.querySelectorAll(".days");
const weekdays = document.querySelectorAll(".weekdays");
let today = new Date();
function getDateByMonth(month, day){
    if ([1, 3, 5, 7, 8, 10, 12].includes(month)){
        if (day > 31) {
            day -= 31;
        }
    } else if (month === 2){
        if (day > 28) {
            day -= 28;
        }
    } else {
        if (day > 30){
            day -= 30;
        }
    }
    return day;
}

function getWeekday(weekday){
    if (weekday > 6){
        weekday -= 7;
    }
    switch (weekday){
        case 0:
            return "일";
        case 1:
            return "월";
        case 2:
            return "화";
        case 3:
            return "수";
        case 4:
            return "목";
        case 5:
            return "금";
        case 6:
            return "토";
    }
}
let month = today.getMonth() + 1;
for (let i=0; i < 7; i++){
    days[i].innerText = getDateByMonth(month, today.getDate() + i);
    weekdays[i].innerText = getWeekday(today.getDay() + i);
}
weekdays[0].innerText = "오늘";

// 선택 후 예약 페이지로 데이터 전송



const lawyerId = document.querySelector("input[name=lawyerId]");
const submitBtn = document.getElementById("final-submit-btn");
submitBtn.addEventListener("click", (e) => {
    Swal.fire({
        title: '예약을 진행하시겠습니까?',
        text: "예약 유형, 날짜와 시간을 다시 한 번 확인하십시오.",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '예약하기',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.value) {
            let selectedMonth = 0;
            let selectedDay = 0;
            for (let i=0; i < dateButtons.length; i++){
                if (dateButtons[i].className.includes('select')){
                    selectedDay = days[i].innerText;
                    break;
                }
            }
            if (selectedDay < today.getDate()) {
                selectedMonth = month + 1;
            } else selectedMonth = month;

            let selectedTime = "";
            for (let timeButton of timeButtons){
                if (timeButton.className.includes('select')){
                    selectedTime = timeButton.innerText;
                    break;
                }
            }
            let timeSplit = selectedTime.split(":");

            let reservationDate = new Date();
            reservationDate.setMonth(selectedMonth-1);
            reservationDate.setDate(selectedDay);
            reservationDate.setHours(parseInt(timeSplit[0]));
            reservationDate.setMinutes(parseInt(timeSplit[1]));

            let price = totalPrice.innerText;
            price = price.substring(0, price.length-1).split(",").join("");

            let f = document.createElement('form');

            let obj;
            obj = document.createElement('input');
            obj.setAttribute('type', 'hidden');
            obj.setAttribute('name', 'consultingType');
            obj.setAttribute('value', consultingType);
            f.appendChild(obj);

            obj = document.createElement('input');
            obj.setAttribute('type', 'hidden');
            obj.setAttribute('name', 'reservationDate');
            obj.setAttribute('value', reservationDate.toISOString());
            f.appendChild(obj);

            obj = document.createElement('input');
            obj.setAttribute('type', 'hidden');
            obj.setAttribute('name', 'totalPrice');
            obj.setAttribute('value', price);
            f.appendChild(obj);

            obj = document.createElement('input');
            obj.setAttribute('type', 'hidden');
            obj.setAttribute('name', 'lawyerId');
            obj.setAttribute('value', lawyerId.value);
            f.appendChild(obj);

            f.setAttribute('method', 'get');
            f.setAttribute('action', '/lawyer-home/reservation');
            document.body.appendChild(f);
            f.submit();

        }
})});
