// 모달을 가져오고 버튼을 가져옵니다.
var modal = document.getElementById('shareModal');
var shareButton = document.getElementById('shareButton');
var closeModal = document.getElementById('closeModal');
var shareLink = document.getElementById('shareLink');
var link = document.location.href;

// 버튼을 클릭하면 모달을 엽니다.
shareButton.addEventListener('click', function() {
    // 공유할 링크를 설정합니다.
    var sharedLink = link; // 여기에 공유할 링크를 넣으세요.
    shareLink.value = sharedLink;

    // 모달을 나타나게 합니다.
    modal.style.display = 'block';
});

// 모달을 닫기 위해 X 버튼을 클릭하거나 모달 외부를 클릭하면 호출됩니다.
closeModal.onclick = function() {
    modal.style.display = 'none';
};

window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = 'none';
    }
};

// 링크를 클립보드로 복사하는 함수
function copyToClipboard() {
    shareLink.select();
    document.execCommand('copy');
    alert('링크가 복사되었습니다: ' + shareLink.value);
}



// 모달을 가져오고 버튼을 가져옵니다.
// 모든 공유하기 버튼과 모달을 선택합니다.
const shareButtons = document.querySelectorAll('.shareButton');
const shareModals = document.querySelectorAll('.shareModal');
const closeModalButtons = document.querySelectorAll('.closeModal');
const shareLinks = document.querySelectorAll('.shareLink');
const links = document.location.href;

// 각 버튼을 클릭하면 해당 모달을 엽니다.
shareButtons.forEach((shareButton, index) => {
    shareButton.addEventListener('click', function() {
        const sharedLink = links; // 여기에 공유할 링크를 넣으세요.
        shareLinks[index].value = sharedLink;
        shareModals[index].style.display = 'block';
    });
});

// 각 모달을 닫기 위해 X 버튼을 클릭하거나 모달 외부를 클릭하면 호출됩니다.
closeModalButtons.forEach((closeModalButton, index) => {
    closeModalButton.onclick = function() {
        shareModals[index].style.display = 'none';
    };
});

window.onclick = function(event) {
    shareModals.forEach((modal, index) => {
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    });
};

// 링크를 클립보드로 복사하는 함수
function copyToClipboard(index) {
    shareLinks[index].select();
    document.execCommand('copy');
    alert('링크가 복사되었습니다: ' + shareLinks[index].value);
}

//
// // 관심 버튼을 누를시 서버로 관련 정보가 넘어가도록 하는 JS
// function toggleImg() {
//     const button = document.getElementById('favoriteButton');
//     const caseTitle = button.getAttribute('data-case-title');
//     // const createDate = button.getAttribute('data-create-date');
//     const viewCount = button.getAttribute('data-view-count');
//     const lawyerReplyCount = button.getAttribute('data-lawyer-reply');
//     const caseId = button.getAttribute('data-case-id');
//     const memberIdInput = document.querySelector('input[name="memberId"]');
//     const memberId = memberIdInput.value;
//     const consultId=button.getAttribute('data-case-id');
//     const url = `/consult-detail/consult-detail/${consultId}`;
//
//     console.log("caseTitle:", caseTitle);
//     // console.log("createDate:", createDate);
//     console.log("viewCount:", viewCount);
//     console.log("lawyerReplyCount:", lawyerReplyCount);
//     console.log("caseId:", caseId);
//     console.log("memberId:", memberId);
//
//     // Ajax 요청을 통해 데이터를 서버로 전송
//     $.ajax({
//         url: url, // 저장용 URL로 변경해야 함
//         type: 'POST',
//         data: { caseTitle: caseTitle,
//                 viewCount:viewCount, lawyerReplyCount:lawyerReplyCount
//         , caseId:caseId, memberId:memberId},
//
//         success: function(response) {
//             // 요청이 성공하면 수행할 작업 추가
//             // 예: 버튼 이미지 업데이트, 알림 메시지 등
//             console.log("hey caseTitle:", caseTitle);
//             // console.log("createDate:", createDate);
//             console.log("hey viewCount:", viewCount);
//             console.log("hey lawyerReplyCount:", lawyerReplyCount);
//             console.log("hey caseId:", caseId);
//             console.log("hey memberId:", memberId);
//         }
//     });
// }

const heartImage=document.querySelector('.heartImg');
let memberId;
let url;
let consultId;
if(heartImage != null){
    heartImage.addEventListener("click",(e)=>{
        memberId = document.querySelector("input[name=memberId]").value;
        consultId = document.querySelector("input[name=consultId]").value;
        console.log(memberId);
        console.log(consultId);
        if(e.target.src.includes("fullHeart.png")){
            url="/consult-detail/delete?memberId="+memberId + "&consultingCaseId="+consultId;
            fetch(url)
                .then(response=>response.text())
                .then(data => {
                    if (data==="fail"){
                        // alert("서버 오류 발생");
                        return;
                    } else if(data==="success"){
                        // alert("관심목록에서 해제");
                    }
                    else {
                        // alert("알 수 없는 오류 발생");
                        return;
                    }

                }).catch((error)=>{
                    console.log("오류 발생 :" +error);
            })
            e.target.src="/image/consultDetail/emptyHeart.png";
        }else {
            url="/consult-detail/like?memberId="+memberId + "&consultingCaseId="+consultId;
            fetch(url)
                .then(response=>response.text())
                .then(data => {
                    if (data==="fail"){
                        // alert("이미 하트누른 관심글");
                        return;
                    } else if(data==="success"){
                        // alert("관심글로 설정 완료");
                        }
                    else {
                        // alert("알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
                        return;
                    }

                }).catch((error)=>{
                console.log("오류 발생 :" +error);
            })
            e.target.src="/image/consultDetail/fullHeart.png";
        }
    })
}
