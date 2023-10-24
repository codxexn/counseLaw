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

const coupons = document.querySelectorAll(".coupon-books");
const discounts = document.querySelectorAll(".discounted-price");
const minusPrice = document.querySelector(".discount-price-won");
const totalPayPrice = document.querySelector(".total-pay-price");
const totalPrice = document.querySelector(".total-pay-price-value");
const couponIds = document.querySelectorAll(".coupon-books input[name=couponIds]");
let selectedCouponId = null;
for (let i=0; i < coupons.length; i++){
    coupons[i].addEventListener("click", (e) => {
        couponLists.style.display = 'none';
        arrow.src = '/image/reservation/down.png';
        cancelButton.style.display = 'block';
        minusPrice.innerText = `-${parseInt(discounts[i].innerText).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')}원`;
        totalPayPrice.innerText = `${(parseInt(totalPrice.value) - parseInt(discounts[i].innerText)).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')}원`;
        selectedCouponId = couponIds[i].value;
    })
}

cancelButton.addEventListener('click', (e) => {
    couponPriceValue.innerHTML = '0원';
    totalPayPrice.innerText = `${parseInt(totalPrice.value).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')}원`;
    cancelButton.style.display = 'none';
    selectedCouponId = null;
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
            paymentButton.disabled = false;
        }
    } else {
        if (paymentButton.classList.contains("PaymentMethod-module_active")) {
            paymentButton.classList.remove("PaymentMethod-module_active");
            paymentButton.disabled = true;
        }
    }
}


textArea.addEventListener("keyup", validateBtn);
nameField.addEventListener("keyup", validateBtn);
phoneField.addEventListener("keyup", validateBtn);
agreementButton.addEventListener("click", validateBtn);


/////////////////////// 결제 api 관련 /////////////////////////
const reservationForm = document.getElementById("reservation-form");


function pay() {
    let payPrice = totalPayPrice.innerText.substring(0, totalPayPrice.innerText.length-1).split(",").join("");
    let productName = document.querySelector(".reservation-title").innerText;
    let itemName = document.querySelector(".consultingTypeToKorean").value;
    let uniqueKey = new Date().toString();
    BootPay.request({
        price: payPrice,
        application_id: '6537e05700be04001c8e27ba',
        name: productName,
        show_agree_window: 0,
        items: [
            {
                item_name: itemName,
                qty: 1,
                unique: uniqueKey,
                price: payPrice,
                cat1: itemName
            }
        ],
        order_id: uniqueKey,
    }).error(function (data) {
        alert("결제 오류가 발생했습니다. 다시 시도해주세요!");
    }).cancel(function (data) {
        alert("결제를 취소하셨습니다. 이전 페이지로 이동합니다.");
    }).confirm(function (data) {
        console.log(data);
        BootPay.transactionConfirm(data);
    }).done(function (data) {
        alert("결제가 완료되었습니다. 마이페이지로 이동합니다.");
        let obj;
        obj = document.createElement("input");
        obj.setAttribute("type", "hidden");
        obj.setAttribute("name", "paymentPrice");
        obj.setAttribute("value", payPrice);
        reservationForm.appendChild(obj);

        obj = document.createElement("input");
        obj.setAttribute("type", "hidden");
        obj.setAttribute("name", "paymentList");
        obj.setAttribute("value", productName);
        reservationForm.appendChild(obj);

        if (selectedCouponId != null){
            obj = document.createElement("input");
            obj.setAttribute("type", "hidden");
            obj.setAttribute("name", "couponId");
            obj.setAttribute("value", selectedCouponId);
            reservationForm.appendChild(obj);
        }

        reservationForm.submit();
    });

}
