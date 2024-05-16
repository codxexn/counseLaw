// 에러 메시지 출력 (화면에서 하는 유효성 검사)

// const emailErrorMsg = document.querySelector(".Missing-Email-Message");
const newPwInput = document.querySelector("input[name=newPassword]");
const newPwRepeat = document.querySelector("input[name=newPasswordRepeat]");
const newPwRepeatNoProblemMsg = document.querySelector(".New-Password-Same");
const newPwRepeatErrorMsg = document.querySelector(".New-Password-Different");
// const emailInput = document.querySelector("input[name=email]");
const phoneInput = document.querySelector("input[name=phone]");
const phoneErrorMsg = document.querySelector(".Missing-Phone-Message");
const phoneValidateButton = document.querySelector(".Authenticate-Phone-Button");
const phoneAuthNoProblemMsg = document.querySelector(".Phone-Auth-Code-Same");
const phoneAuthErrorMsg = document.querySelector(".Phone-Auth-Code-Error");
const phoneAuthCodeInputWrapper = document.querySelector(".Phone-Auth-Code-Wrapper");
const phoneAuthCodeInput = document.querySelector("input[name=phoneAuthCode]");
const phoneAuthCodeCheckButton = document.querySelector(".Authenticate-Phone-Check-Button");

// emailInput.addEventListener("blur", (e) => {
//     if (!emailInput.value) {
//         emailErrorMsg.style.display = "block";
//     }
// })
//
// emailInput.addEventListener("keyup", (e) => {
//     if (emailInput.value){
//         emailErrorMsg.style.display = "none";
//     }
// })

phoneInput.addEventListener("blur", (e) => {
    if (!phoneInput.value) {
        phoneErrorMsg.style.display = "block";
    }
})

phoneInput.addEventListener("keyup", (e) => {
    if (phoneInput.value){
        phoneErrorMsg.style.display = "none";
    }
})

newPwInput.addEventListener("keyup", (e) => {
    if (newPwInput.value !== newPwRepeat.value) {
        newPwRepeatErrorMsg.style.display = "block";
        newPwRepeatNoProblemMsg.style.display = "none";
    } else {
        newPwRepeatErrorMsg.style.display = "none";
        newPwRepeatNoProblemMsg.style.display = "block";
    }
})

newPwRepeat.addEventListener("keyup", (e) => {
    if (newPwInput.value !== newPwRepeat.value) {
        newPwRepeatErrorMsg.style.display = "block";
        newPwRepeatNoProblemMsg.style.display = "none";
    } else {
        newPwRepeatErrorMsg.style.display = "none";
        newPwRepeatNoProblemMsg.style.display = "block";
    }
})

phoneInput.addEventListener("focus", () => {
    phoneValidateButton.style.display = "block";
})

phoneValidateButton.addEventListener("click", (e) => {
    e.preventDefault();
    phoneAuthCodeInputWrapper.style.display = "block";
})

phoneAuthCodeCheckButton.addEventListener("click", () => {
    // 아직 인증번호를 생성하진 못하므로, 우선 정상 입력 메시지만 출력되도록 했습니다.
    phoneAuthNoProblemMsg.style.display = "block";
})

phoneAuthCodeInput.addEventListener("keyup", () => {
    phoneAuthCodeCheckButton.style.display = "block";
})
