
const emailContent = document.getElementById("sign-up-email");
const emailError = document.getElementById('sign-up-email-valid-message');

const passwordContent = document.getElementById("sign-up-password");
const passwordError = document.getElementById('sign-up-password-validator-message');

const passwordConfirmContent = document.getElementById("sign-up-password-confirm");
const passwordConfirmError = document.getElementById('sign-up-passwordConfirm-validator-message');

const nameContent = document.getElementById("sign-up-name");

const phoneContent = document.getElementById("sign-up-phone");
const phoneError = document.getElementById('sign-up-phone-validator-message');
const certificationButton = document.getElementById('certify-phone-number-button');

const ageError = document.getElementById('sign-up-user-age-check-validator-message');
const checking = document.getElementById('sign-up-user-age-check');

const marketingAcceptCheckbox = document.getElementById('marketing-accept');
const emailMarketingCheckbox = document.getElementById('email-marketing-accept');
const smsMarketingCheckbox = document.getElementById('sms-marketing-accept');

const allAgree = document.getElementById('sign-up-agree-all');
const lawyerAgreement = document.getElementById('lawyer-sign-up-agreement');
const privacyPolicy = document.getElementById('privacy-policy');
const personalInfo = document.getElementById('personal-info');
const userAgeCheck = document.getElementById('sign-up-user-age-check');

const checkboxes = [lawyerAgreement, privacyPolicy, personalInfo, userAgeCheck];

const joinButton = document.querySelector(".law-auth-card-footer-button");

// 모든 input 값 입력, 비밀번호와 비밀번호 확인란 값 일치
// 전체 동의에 check 되면 가입신청 버튼 활성화
function checkFormValidity() {
    if (
        emailContent.value.length > 0 &&
        passwordContent.value.length > 0 &&
        passwordConfirmContent.value.length > 0 &&
        passwordContent.value === passwordConfirmContent.value &&
        nameContent.value.length > 0 &&
        phoneContent.value.length > 0 &&
        allAgree.checked
    ) {
        joinButton.disabled = false;
    } else {
        joinButton.disabled = true;
    }
}

emailContent.addEventListener('input', checkFormValidity);
passwordContent.addEventListener('input', checkFormValidity);
passwordConfirmContent.addEventListener('input', checkFormValidity);
nameContent.addEventListener('input', checkFormValidity);
phoneContent.addEventListener('input', checkFormValidity);
allAgree.addEventListener('change', checkFormValidity);

checkFormValidity();

// 비밀번호 입력시 확인창과 다르면 에러 메세지
passwordContent.addEventListener('input', function(){
    const passwordValue = passwordContent.value;
    const confirmPasswordValue = passwordConfirmContent.value;

    if (passwordValue !== confirmPasswordValue) {
        displayError(passwordConfirmError, passwordConfirmContent);
    } else {
        hideError(passwordConfirmError, passwordConfirmContent);
    }
})

// 비밀번호 확인창 입력시 비밀번호 창과 다르면 에러 메세지
passwordConfirmContent.addEventListener('input', function(){
    const passwordValue = passwordContent.value;
    const confirmPasswordValue = passwordConfirmContent.value;

     if (passwordValue !== confirmPasswordValue) {
          displayError(passwordConfirmError, passwordConfirmContent);
        } else {
          hideError(passwordConfirmError, passwordConfirmContent);
        }
    checkFormValidity();
})


// 만 14세 이상입니다.
checking.addEventListener("click", function(){
    if(this.checked){
        hideError(ageError, checking);
    } else {
        displayError(ageError, checking);
    }
})


// 전화번호 입력
phoneContent.addEventListener("keyup", function(){
    if(isEmpty(phoneContent.value)){
            phoneError.style.display = 'block';
            phoneContent.style = "border-bottom-color: #cb3725;";
        } else{
         phoneError.style.display = 'none';
         phoneContent.style = "border-bottom-color: #e2e4e5;";
        }
})



// 이메일 입력
emailContent.addEventListener("keyup", function(){
    if(isEmpty(emailContent.value)){
        displayError(emailError, emailContent)
    } else{
     hideError(emailError, emailContent)
    }
})

// 비번 에러메세지
passwordContent.addEventListener("keyup", function(){
    if(isEmpty(passwordContent.value)){
            displayError(passwordError, passwordContent)
    } else{
    hideError(passwordError, passwordContent)
    }
})


// 비어있는 지 확인
function isEmpty(target) {
    return target == null || target == undefined || target.trim() === '';
}
// 에러 부분
function displayError(errorElement, contentElement) {
  errorElement.style.display = 'block';
  contentElement.style.borderBottomColor = '#c50000';
}

function hideError(errorElement, contentElement) {
  errorElement.style.display = 'none';
  contentElement.style.borderBottomColor = '#e2e4e5';
}





document.addEventListener('DOMContentLoaded', function () {

    allAgree.addEventListener('change', function () {
        checkboxes.forEach(checkbox => {
            checkbox.checked = allAgree.checked;
        });
    });

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function () {
            allAgree.checked = checkboxes.every(cb => cb.checked);
        });
    });

});
















