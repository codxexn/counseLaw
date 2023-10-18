// 드롭다운 js

const optionMenu = document.querySelector(".select-Menu"),
    selectBtn = optionMenu.querySelector(".select-Btn"),
    options = optionMenu.querySelectorAll(".option"),
    sBtn_text = optionMenu.querySelector(".sBtn-Text");

selectBtn.addEventListener("click", () => optionMenu.classList.toggle("show"));

options.forEach(option => {
    option.addEventListener("click", () => {
        var selectedOption = option.querySelector(".option-Text").innerText;
        sBtn_text.innerText = selectedOption;
        optionMenu.classList.remove("show");
    })
});


// const searchForm = document.getElementById("searchForm");
// const inputElement = document.getElementById("search_keyword");
// const selectedOption = document.getElementById("selectedOption").value;
//
// searchForm.addEventListener("submit", function(event) {
//     event.preventDefault();
//     const keyword = inputElement.value;
//
//     if (keyword.trim() === "") {
//         window.location.href = `/manager/manager-mainpage?selectedOption=${selectedOption}`;
//     } else {
//         window.location.href = `/manager/manager-mainpage?keyword=${encodeURIComponent(keyword)}&selectedOption=${selectedOption}`;
//     }
// });
// // Pagination buttons
// const paginationButtons = document.querySelectorAll(".footerButton");
//
// paginationButtons.forEach(button => {
//     button.addEventListener("click", function(event) {
//         event.preventDefault();
//         const buttonpage = this.getAttribute("data-page");
//
//         if (buttonpage) {
//             window.location.href = `/manager/manager-mainpage?selectedOption=${selectedOption}&keyword=${encodeURIComponent(keyword)}&page=${buttonpage}`;
//         }
//     });
// });

// function submitForm() {
//     // 선택한 옵션, 검색어, 페이지 값을 가져옴
//     var selectedOption = document.getElementById("selectedOption").value;
//     var keyword = document.querySelector(".member-searchBar").value;
//     var page = 1; // 페이지 번호를 여기서 설정 (필요에 따라 변경)
//
//     // URL 생성
//     var url = '/manager/manager-mainpage?selectedOption=' + selectedOption + '&keyword=' + keyword + '&page=' + page;
//
//     // 페이지 이동
//     window.location.href = url;
// }
// 게시물 삭제 클릭 시 실행 함수

function deletePost(postId, postType){
    Swal.fire({
        title: '게시물을 삭제하시겠습니까?',
        text: "삭제하신 게시물은 복구할 수 없습니다.",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '삭제',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.value) {
            //"삭제" 버튼을 눌렀을 때 작업할 내용을 이곳에 넣어주면 된다.
            let f = document.createElement('form');

            let obj;
            obj = document.createElement('input');
            obj.setAttribute('name', postType + 'Id');
            obj.setAttribute('value', postId);

            f.appendChild(obj);
            f.setAttribute('method', 'post');
            f.setAttribute('action', '/manager/posts-delete');
            document.body.appendChild(f);
            f.submit();
        }
    })
}

