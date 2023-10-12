
const emailContent = document.getElementById("sign-up-email");
const emailError = document.getElementById('sign-up-email-valid-message');

const signUpContent = document.getElementById("sign-up-username");
const signUpError = document.getElementById('sign-up-username-validator-message');

const passwordContent = document.getElementById("sign-up-password");
const passwordError = document.getElementById('sign-up-password-validator-message');

const passwordConfirmContent = document.getElementById("sign-up-password-confirm");
const passwordConfirmError = document.getElementById('sign-up-passwordConfirm-validator-message');



const phoneContent = document.getElementById("sign-up-phone");
const phoneError = document.getElementById('sign-up-phone-validator-message');
const certificationButton = document.getElementById('certify-phone-number-button');

const ageError = document.getElementById('sign-up-user-age-check-validator-message');
const checking = document.getElementById('sign-up-user-age-check');

const marketingAcceptCheckbox = document.getElementById('marketing-accept');
const emailMarketingCheckbox = document.getElementById('email-marketing-accept');
const smsMarketingCheckbox = document.getElementById('sms-marketing-accept');


passwordConfirmContent.addEventListener('input', function(){
    const passwordValue = passwordContent.value;
    const confirmPasswordValue = passwordConfirmContent.value;

     if (passwordValue !== confirmPasswordValue) {
          displayError(passwordConfirmError, passwordConfirmContent);
        } else {
          hideError(passwordConfirmError, passwordConfirmContent);
        }
})



checking.addEventListener("click", function(){
    if(this.checked){
        hideError(ageError, checking);
    } else {
        displayError(ageError, checking);
    }
})



phoneContent.addEventListener("keyup", function(){
    if(isEmpty(phoneContent.value)){
            phoneError.style.display = 'block';
            phoneContent.style = "border-bottom-color: #cb3725;";
        } else{
         phoneError.style.display = 'none';
         phoneContent.style = "border-bottom-color: #e2e4e5;";
        }
})

certificationButton.addEventListener("click", function(){
     if(isEmpty(phoneContent.value)){
                phoneError.style.display = 'block';
                phoneContent.style = "border-bottom-color: #cb3725;";
            } else{
             phoneError.style.display = 'none';
             phoneContent.style = "border-bottom-color: #e2e4e5;";
            }
})


emailContent.addEventListener("keyup", function(){
    if(isEmpty(emailContent.value)){
        displayError(emailError, emailContent)
    } else{
     hideError(emailError, emailContent)
    }
}
)

signUpContent.addEventListener("keyup", function(){
    if(isEmpty(signUpContent.value)){
        displayError(signUpError, signUpContent)
    } else{
     hideError(signUpError, signUpContent)
    }
}
)

passwordContent.addEventListener("keyup", function(){
    if(isEmpty(passwordContent.value)){
//        passwordError.style.display = 'block';
//        passwordContent.style = "border-bottom-color: #cb3725;";
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
  contentElement.style.borderBottomColor = '#cb3725';
}

function hideError(errorElement, contentElement) {
  errorElement.style.display = 'none';
  contentElement.style.borderBottomColor = '#e2e4e5';
}

//document.addEventListener('DOMContentLoaded', function () {
//
//// 버튼과 드롭다운 메뉴를 선택합니다.
//const dropdownButton = document.querySelectorAll("material-form-control");
//const dropdownMenu = document.querySelector(".material-dropdown-menu");
//console.log(dropdownButton)
//dropdownButton.forEach((dropdownItem) => {
//    console.log(dropdownItem)
//    dropdownItem.addEventListener("click", function () {
//                  // 드롭다운 메뉴의 상태를 토글합니다.
//                  dropdownMenu.classList.toggle("active");
//                })
//
//    document.addEventListener("click", function (event) {
//         if (!event.target.matches("#dropdown-button")) {
//       dropdownMenu.classList.remove("active");
//     }
//     })
//});
//
//})



const switchContainer = document.getElementsByClassName('law-switch');
const switchCheckbox = document.getElementById('sns-accept');


switchContainer[0].addEventListener('click', function () {
  // 클릭 시 체크 상태를 토글합니다.
  switchCheckbox.checked = !switchCheckbox.checked;
});





const agreeAllCheckbox = document.getElementById('sign-up-agree-all');
const consentCheckboxes = document.querySelectorAll('.contract-consensus-checkbox');

agreeAllCheckbox.addEventListener('change', function () {
  const isChecked = agreeAllCheckbox.checked;

  consentCheckboxes.forEach(function (checkbox) {
    checkbox.checked = isChecked;
      emailMarketingCheckbox.checked = isChecked;
      smsMarketingCheckbox.checked = isChecked;
  });
});




// 하위 체크박스 변경 시 이벤트 리스너 추가
emailMarketingCheckbox.addEventListener('change', updateMarketingAcceptCheckbox);
smsMarketingCheckbox.addEventListener('change', updateMarketingAcceptCheckbox);

function updateMarketingAcceptCheckbox() {
  const emailChecked = emailMarketingCheckbox.checked;
  const smsChecked = smsMarketingCheckbox.checked;

  // 두 하위 체크박스가 모두 선택되면 상위 체크박스도 선택
  marketingAcceptCheckbox.checked = emailChecked && smsChecked;
}

// 상위 체크박스 변경 시 이벤트 리스너 추가
marketingAcceptCheckbox.addEventListener('change', function () {
  const isChecked = marketingAcceptCheckbox.checked;
  emailMarketingCheckbox.checked = isChecked;
  smsMarketingCheckbox.checked = isChecked;
});



//document.addEventListener('DOMContentLoaded', function () {
//  const dropdown = document.querySelector('.material-dropdown-menu');
//  const dropdownContent = dropdown.querySelector('.material-dropdown-menu-content');
//  const referSelect = document.getElementById('sign-up-refer');
//  const dropdownButton = document.getElementById('dropdown-button');
//
//  // 모든 li 요소를 선택
//  const dropdownItems = dropdownContent.querySelectorAll('li');
//
//  dropdownItems.forEach((item) => {
//  item.addEventListener('mouseenter', function () {
//        item.style.backgroundColor = '#e2e2e2'; // 배경색 변경
//      });
//
//      item.addEventListener('mouseleave', function () {
//        item.style.backgroundColor = ''; // 마우스가 벗어나면 원래 배경색으로 되돌림
//      });
//
//    item.addEventListener('click', function () {
//      const selectedOptionText = item.textContent; // 선택한 li의 텍스트
//      referSelect.value = selectedOptionText; // select의 value를 선택한 li의 텍스트로 업데이트
//      dropdownButton.textContent = selectedOptionText; // button의 텍스트를 선택한 li의 텍스트로 업데이트
//    });
//  });
//});




const dialog =  document.getElementById('dialog');
const dialogButton = document.querySelector('.yes');



    dialogButton.addEventListener("click", function(){
        dialog.style.display= 'none';
    })

document.addEventListener('DOMContentLoaded', function () {
    const dropdownMenus = document.querySelectorAll('.material-dropdown-menu');
    console.log(dropdownMenus)

    dropdownMenus.forEach((dropdown) => {
        const dropdownContent = dropdown.querySelector('.material-dropdown-menu-content');
        const selectElement = dropdown.querySelector('select');
        const dropdownButton = dropdown.querySelector('button');

        // 모든 li 요소를 선택
        const dropdownItems = dropdownContent.querySelectorAll('li');

        // 드롭다운 버튼 클릭 시 이벤트 핸들러
        dropdownButton.addEventListener('click', function (event) {
            event.stopPropagation(); // 다른 클릭 이벤트와 충돌 방지
            dropdown.classList.toggle('active');
        });

        // 문서의 다른 부분을 클릭 시 드롭다운 메뉴 비활성화
        document.addEventListener("click", function (event) {
            if (!event.target.matches("#dropdown-button-sex") && !event.target.matches("#dropdown-button-birth-year")) {
                dropdown.classList.remove("active");
            }
        });

        dropdownItems.forEach((item) => {
            item.addEventListener('mouseenter', function () {
                item.style.backgroundColor = '#e2e2e2'; // 배경색 변경
            });

            item.addEventListener('mouseleave', function () {
                item.style.backgroundColor = ''; // 마우스가 벗어나면 원래 배경색으로 되돌림
            });

            item.addEventListener('click', function (event) {
                event.preventDefault(); // 기본 이벤트 중단
                const selectedOptionText = item.textContent; // 선택한 li의 텍스트
                const selectedOptionValue = item.querySelector('a').getAttribute('href'); // 선택한 li의 value
                selectElement.value = selectedOptionValue; // select의 value를 선택한 li의 value로 업데이트
                dropdownButton.textContent = selectedOptionText; // button의 텍스트를 선택한 li의 텍스트로 업데이트
                dropdown.classList.remove('active');
            });
        });
    });
});


const signupAgreement = document.getElementById('lawyer-sign-up-agreement');
const privacyPolicy = document.getElementById('privacy-policy');
const personalInfo = document.getElementById('personal-info');

const buttonSubmit = document.querySelectorAll('law-auth-card-footer-button')

















