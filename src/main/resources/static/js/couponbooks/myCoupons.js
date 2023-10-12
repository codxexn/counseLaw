// 맨 아래 화살표 클릭 시 푸터 안보이게 하는 js (반대도 적용)

const openFooterButton = document.querySelector(".OpenFooter");
const hideTargets = document.querySelectorAll(".HideWhenClicked");
const buttonImage = document.querySelector(".OpenFooter svg");
openFooterButton.addEventListener("click", (e) => {
    if(buttonImage.style.transform === "rotate(180deg)"){
        buttonImage.style.transform = "";
    } else{
        buttonImage.style.transform = "rotate(180deg)";
    }
    hideTargets.forEach((hideTarget) => {
        if(hideTarget.style.display === "none"){
            hideTarget.style.display = "block";
        } else{
            hideTarget.style.display = "none";
        }
    });
});

// 쿠폰등록하기 창 show/hide 관련 js
const hideWrapper = document.querySelector(".CouponCode-Hide-Wrapper");
const openCouponButton = document.querySelector(".CouponRegisterWrapper");
const closeCouponButton = document.querySelector(".CouponRegister-Hide-Button");
const couponInput = document.querySelector(".CouponCode");
const registerCouponButton = document.querySelector(".CouponCode-Button");
couponInput.addEventListener("focus", () => {
    registerCouponButton.style.backgroundColor = "#c50000";
    registerCouponButton.disabled = false;
})

couponInput.addEventListener("blur", () => {
    registerCouponButton.style.backgroundColor = "#eee";
    registerCouponButton.disabled = true;
})

openCouponButton.addEventListener("click", () => {
    if (!hideWrapper.classList.contains("CouponCode-Show")){
        hideWrapper.classList.toggle("CouponCode-Show");
    }
})

closeCouponButton.addEventListener("click", (e) => {
    hideWrapper.classList.remove("CouponCode-Show");
})