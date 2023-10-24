// 상세, 이름, 번호, 동의버튼 순으로 true 모두 true면 결제버튼 활성화
globalThis.flag = false;

// 글자수 up
const textArea = document.getElementById('adviceBody');
const textCount = document.querySelector('.input-advice-body__guide-text');
const textErrorMsg = document.querySelector('.text-count-error');

textArea.addEventListener('keyup', (e) => {
    textCount.innerHTML = textArea.value.length;
});

// 10자 이상시 에러메세지 및 border 색상 변경
textArea.addEventListener('blur', (e) => {
    if (textArea.value.length < 10) {
        textErrorMsg.style.display = 'block';
        textArea.style.borderColor = '#c50000';
    } else {
        textErrorMsg.style.display = 'none';
        textArea.style.borderColor = '#c4c8cb';
    }
});

// 쿠폰 리스트 display
// 적용취소 버튼
const cancelButton = document.querySelector('.PaymentMethod-module_cancelCouponButton');
const couponPriceValue = document.querySelector('.PaymentMethod-module_couponPriceValue');
const couponWrap = document.querySelector('.coupon-select');
const couponLists = document.querySelector('.coupon-content');
const arrow = document.querySelector('.coupon-arrow');

couponWrap.addEventListener('click', (e) => {
    if (couponLists.style.display === 'none') {
        couponLists.style.display = 'block';
        arrow.src = '/image/reservation/up.png';
    } else {
        couponLists.style.display = 'none';
        arrow.src = '/image/reservation/down.png';
    }
});

couponLists.addEventListener('click', (e) => {
    couponLists.style.display = 'none';
    arrow.src = '/image/reservation/down.png';
    cancelButton.style.display = 'block';
});

cancelButton.addEventListener('click', (e) => {
    couponPriceValue.innerHTML = '0원';
    cancelButton.style.display = 'none';
});

// 동의 버튼 색깔변화
const agreementButton = document.querySelector('.PaymentMethod-module_check path');

agreementButton.addEventListener('click', (e) => {
    if (e.target.style.fill === 'black') {
        e.target.style.fill = '#e2e4e5';
    } else {
        e.target.style.fill = 'black';
    }
})

// 이름, 전화번호 입력시 flag true
const nameField = document.querySelector('input[name="advice-name"]');
const phoneField = document.querySelector('input[name="advice-phone"]');

// 결제하기 버튼 활성화
const paymentButton = document.querySelector('.PaymentMethod-module_paymentButton');
function validateBtn() {
    if (textArea.value.length > 9 && nameField.value.length > 0 && phoneField.value.length === 11 && agreementButton.style.fill === 'black') {
        if (!paymentButton.classList.contains("PaymentMethod-module_active")){
            paymentButton.classList.add(("PaymentMethod-module_active"));
        }
    } else {
        if (paymentButton.classList.contains("PaymentMethod-module_active")) {
            paymentButton.classList.remove("PaymentMethod-module_active");
        }
    }
}


textArea.addEventListener("keyup", validateBtn);
nameField.addEventListener("keyup", validateBtn);
phoneField.addEventListener("keyup", validateBtn);
agreementButton.addEventListener("click", validateBtn);

