// 화살표 클릭 시 상세 faq 답변 내용 표시 및 화살표 방향 변경
NodeList.prototype.indexOf = Array.prototype.indexOf;

const faqContents = document.querySelectorAll(".faq-content");
const bottomBars = document.querySelectorAll(".faq-description-bottombar");
faqContents.forEach((content) => {
    let idx = faqContents.indexOf(content);
    console.log(idx);
    content.addEventListener("click", (e) => {
        e.preventDefault();
        content.classList.toggle("Active-content");
        bottomBars[idx].classList.toggle("false");
        bottomBars[idx].classList.toggle("Active-bottombar")
    })
})