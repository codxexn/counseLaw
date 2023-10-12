// 즐겨찾기 버튼 클릭 시 색상 변경
globalThis.flag = false;
const likeButton = document.querySelector(".Online-List-Card-Bookmark-Icon-Wrapper svg");

likeButton.addEventListener("click", (e) => {
    e.preventDefault();
    if (!globalThis.flag) {
        likeButton.style.color = "#c50000";
        globalThis.flag = true;
    } else {
        likeButton.style.color = "#999";
        globalThis.flag = false;
    }
})