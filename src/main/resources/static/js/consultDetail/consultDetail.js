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


const heartButtonContainer = document.querySelectorAll(".questionUtilsButton");


heartButtonContainer.forEach((container) => {
    let firstImg = container.firstElementChild.children[0];
    let secondImg = container.firstElementChild.children[1];

    firstImg.addEventListener("click", (e) => {
        e.preventDefault();
        e.target.style.display = "none";
        secondImg.style.display = "block";
    });
    secondImg.addEventListener("click", (e) => {
        e.preventDefault();
        e.target.style.display = "none";
        firstImg.style.display = "block";
    });
});