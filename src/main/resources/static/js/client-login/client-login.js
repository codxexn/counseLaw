 document.addEventListener("DOMContentLoaded", function () {
    const formGroupElements = document.querySelectorAll(".form-group");

    formGroupElements.forEach(function (formGroup) {
      formGroup.addEventListener("click", function () {
        const boxElement = this.querySelector(".box");
        boxElement.classList.toggle("active");
      });
    });
  });
//
  const idContent = document.getElementById("username");
  const idError = document.getElementById('username-validator-message');

  const clientidContent = document.getElementById("clientusername");
  const clientidError = document.getElementById('client-username-validator-message');

  const passwordContent = document.getElementById("password");

  const buttons = document.querySelectorAll('.sign-in-section-form-button');

  buttons.forEach((button) => {
      button.addEventListener("click", (e) => {
          button.submit;
      })
  })
//
const clientform =  document.getElementById('client-login-form');
const lawyerform =  document.getElementById('lawyer-login-form');


const dialog =  document.getElementById('dialog');
const dialogButton = document.querySelector('.yes');

console.log(dialogButton)

    dialogButton.addEventListener("click", function(){
        dialog.style.display= 'none';
    })
//
//
  idContent.addEventListener("keyup", function(){
      if(isEmpty(idContent.value)){
          idError.style.display = 'block';
          idContent.style = "border-bottom-color: #cb3725;";
      } else{
       idError.style.display = 'none';
        idContent.style = "border-bottom-color: #e2e4e5;";
      }
  }
  )

    clientidContent.addEventListener("keyup", function(){
        if(isEmpty(clientidContent.value)){
            clientidError.style.display = 'block';
            clientidContent.style = "border-bottom-color: #cb3725;";
        } else{
         clientidError.style.display = 'none';
          clientidContent.style = "border-bottom-color: #e2e4e5;";
        }
    }
    )
//
//
// clientform.addEventListener("submit", function(event){
//   if(isEmpty(idContent.value)){
//               event.preventDefault();
//               idError.style.display = 'block';
//               idContent.style.borderBottomColor = '#cb3725';
//               idContent.focus();
//     } else if(!isEmpty(idContent.value) && isEmpty(passwordContent.value)){
//     event.preventDefault();
//      passwordContent.focus();
//     }
//
//
// })
//
// lawyerform.addEventListener("submit", function(event){
//   if(isEmpty(idContent.value)){
//               event.preventDefault();
//               idError.style.display = 'block';
//               idContent.style.borderBottomColor = '#cb3725';
//               idContent.focus();
//     } else if(!isEmpty(idContent.value) && isEmpty(passwordContent.value)){
//     event.preventDefault();
//      passwordContent.focus();
//     }
//
//
// })
//
//
//   function isEmpty(target) {
//       return target == null || target == undefined || target.trim() === '';
//   }
//
//
 // 로그인 버튼 클릭 시 변호사 로그인 섹션 표시, 클라이언트 로그인 섹션 숨김
 const lawyerLoginButton = document.querySelectorAll('.sign-in-section-tab');
 const clientLoginButton = document.querySelector('.sign-in-section-tab.left-tab');
 const lawyerLoginSection = document.querySelector('.lawyer-sign-in-section');
 const clientLoginSection = document.querySelector('.client-sign-in-section');

 console.log(clientLoginButton)

 lawyerLoginButton[3].addEventListener('click', function () {
     lawyerLoginButton[3].classList.add('active'); // 활성화 클래스 추가
     clientLoginButton.classList.remove('active'); // 비활성화 클래스 제거
     lawyerLoginSection.style.display = 'block'; // 변호사 로그인 섹션 표시
     clientLoginSection.style.display = 'none'; // 클라이언트 로그인 섹션 숨김
 });

 clientLoginButton.addEventListener('click', function () {
     clientLoginButton.classList.add('active'); // 활성화 클래스 추가
     lawyerLoginButton[3].classList.remove('active'); // 비활성화 클래스 제거
     clientLoginSection.style.display = 'block'; // 클라이언트 로그인 섹션 표시
     lawyerLoginSection.style.display = 'none'; // 변호사 로그인 섹션 숨김
 });
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
