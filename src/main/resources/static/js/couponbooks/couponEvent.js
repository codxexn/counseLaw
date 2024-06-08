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


// 다운로드 버튼 클릭시 alert

const downloadButton = document.getElementById("downloadButton");
downloadButton.addEventListener("click", () => {
    alert("이벤트 쿠폰이 다운로드 되었습니다. 마이 쿠폰에서 확인해보세요!")
})