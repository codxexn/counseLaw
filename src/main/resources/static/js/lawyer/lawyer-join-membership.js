
const emailContent = document.getElementById("sign-up-email");
const emailError = document.getElementById('sign-up-email-valid-message');

const signUpContent = document.getElementById("sign-up-username");
const signUpError = document.getElementById('sign-up-username-validator-message');

const passwordContent = document.getElementById("sign-up-password");
const passwordError = document.getElementById('sign-up-password-validator-message');

const passwordConfirmContent = document.getElementById("sign-up-password-confirm");
const passwordConfirmError = document.getElementById('sign-up-passwordConfirm-validator-message');

const companytelContent = document.getElementById("lawyer-sign-up-company-telephone");
const companytelError = document.getElementById('lawyer-sign-up-lawyerOfficePhone-validator-message');

const phoneContent = document.getElementById("lawyer-sign-up-cellphone");
const phoneError = document.getElementById('lawyer-sign-up-cellphone-validator-message');



const ageError = document.getElementById('sign-up-user-age-check-validator-message');

const marketingAcceptCheckbox = document.getElementById('marketing-accept');
const emailMarketingCheckbox = document.getElementById('email-marketing-accept');
const smsMarketingCheckbox = document.getElementById('sms-marketing-accept');

companytelContent.addEventListener("keyup", function(){
    if(isEmpty(companytelContent.value)){
        displayError(companytelError, companytelContent)
    } else{
     hideError(companytelError, companytelContent)
    }
}
)


passwordConfirmContent.addEventListener('input', function(){
    const passwordValue = passwordContent.value;
    const confirmPasswordValue = passwordConfirmContent.value;

     if (passwordValue !== confirmPasswordValue) {
          displayError(passwordConfirmError, passwordConfirmContent);
        } else {
          hideError(passwordConfirmError, passwordConfirmContent);
        }
})

phoneContent.addEventListener("keyup", function(){
    if(isEmpty(phoneContent.value)){
        displayError(phoneError, phoneContent)
    } else{
     hideError(phoneError, phoneContent)
    }
}
)


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




const switchCheckbox = document.getElementById('sns-accept');











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







document.addEventListener('DOMContentLoaded', function () {
    const dropdownMenus = document.querySelectorAll('.material-dropdown-menu');

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

// 라디오 버튼 요소들을 가져옵니다.
const radioButtons = document.querySelectorAll('.recommender-selects input[type=radio]');
// 입력 요소들을 가져옵니다.
const nameInput = document.getElementById('lawyer-sign-up-recommender-name');
const idInput = document.getElementById('lawyer-sign-up-recommender');
const emptyInput = document.getElementById('sign-up-recommender-type-empty');

console.log(radioButtons)

// 페이지 로드 시 초기 상태 설정
window.addEventListener('load', () => {
  // 추천 변호사 이름을 기본 선택 상태로 설정합니다.
  radioButtons[0].checked = true;
  nameInput.style.display = 'block';
  idInput.style.display = 'none';
});

// 라디오 버튼의 체크 상태가 변경될 때 이벤트 리스너를 추가합니다.
radioButtons.forEach(radioButton => {
  radioButton.addEventListener('change', () => {
    // 모든 입력 요소를 숨깁니다.
    nameInput.style.display = 'none';
    idInput.style.display = 'none';

    // 선택한 라디오 버튼에 따라 해당 입력 요소를 보여줍니다.
    if (radioButton.value === 'recommenderName') {
    console.log(radioButton)
      nameInput.style.display = 'block';
      radioButtons[1].checked = false;
      radioButtons[2].checked = false;
    } else if (radioButton.value === 'recommenderId') {
      idInput.style.display = 'block';
      radioButtons[0].checked = false;
      radioButtons[2].checked = false;
    } else{
    radioButtons[0].checked = false;
    radioButtons[1].checked = false;
    }
  });
});

// lawyer-agreement-kin 체크박스 엘리먼트를 가져옵니다.
const agreementKinCheckbox = document.getElementById('lawyer-agreement-kin');

// lawyer-naiver-id 입력란 엘리먼트를 가져옵니다.
const naiverIdInput = document.getElementById('lawyer-naiver-id');

// lawyer-naiver-id-validator-message 엘리먼트를 가져옵니다.
const naiverIdValidatorMessage = document.getElementById('lawyer-naiver-id-validator-message');

// lawyer-agreement-kin 체크박스의 상태가 변경될 때 이벤트 리스너를 추가합니다.
agreementKinCheckbox.addEventListener('change', () => {
  // 체크박스가 체크된 상태인지 확인합니다.
  if (agreementKinCheckbox.checked) {
    // 입력란에 내용이 없거나 공백 문자열인 경우
    naiverIdInput.addEventListener("keyup", function(){
        if(isEmpty(naiverIdInput.value)){
            displayError(naiverIdValidatorMessage, naiverIdInput)
        } else{
         hideError(naiverIdValidatorMessage, naiverIdInput)
        }
    }
    )
  } else {
    // 체크박스가 해제된 경우 validator 메시지를 감춥니다.
    naiverIdValidatorMessage.style.display = 'none';
    naiverIdInput.style.borderBottomColor = '#e2e4e5';
  }
});

// lawyer-naiver-id 입력란의 내용이 변경될 때 이벤트 리스너를 추가합니다.
naiverIdInput.addEventListener('input', () => {
  // 체크박스가 체크된 상태이고 입력란에 내용이 있으면 validator 메시지를 감춥니다.
  if (agreementKinCheckbox.checked && naiverIdInput.value.trim() !== '') {
    naiverIdValidatorMessage.style.display = 'none';
    naiverIdInput.style.borderBottomColor = '#e2e4e5';
  }
});




const dialog =  document.getElementById('dialog');
const dialogButton = document.querySelector('.yes');


    dialogButton.addEventListener("click", function(){
        dialog.style.display= 'none';
    })

    dialogButton.addEventListener("click", function(){
        dialog.style.display= 'none';
    })



// 전체 동의시 동의 버튼 자동 활성화
const agreeAllCheckbox = document.querySelector('.allAgree');
const mustAgrees = document.querySelectorAll('.mustAgree');
const choiceAgree = document.querySelector('.choiceAgree');
const agreements = document.querySelector('.agreement');

agreeAllCheckbox.addEventListener('click', (e) => {
    mustAgrees.forEach((agreeButton) => {
        agreeButton.checked = agreeAllCheckbox.checked;
    })
    choiceAgree.checked = agreeAllCheckbox.checked;
});


agreements.forEach((checkbox)=> {
    checkbox.addEventListener('click', () => {
        agreements.forEach((agreement) => {
            if (agreement.checked === false) {
                agreeAllCheckbox.checked = false;
            }
        })
        agreeAllCheckbox.checked = true;
    })
})








