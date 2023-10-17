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


const searchForm = document.getElementById("searchForm");
const inputElement = document.getElementById("search_keyword");
const selectedOption = document.getElementById("selectedOption").value;

searchForm.addEventListener("submit", function(event) {
    event.preventDefault();
    const keyword = inputElement.value;

    if (keyword.trim() === "") {
        window.location.href = `/manager/manager-mainpage?selectedOption=${selectedOption}`;
    } else {
        window.location.href = `/manager/manager-mainpage?keyword=${encodeURIComponent(keyword)}&selectedOption=${selectedOption}`;
    }
});
// Pagination buttons
const paginationButtons = document.querySelectorAll(".footerButton");

paginationButtons.forEach(button => {
    button.addEventListener("click", function(event) {
        event.preventDefault();
        const buttonpage = this.getAttribute("data-page");

        if (buttonpage) {
            window.location.href = `/manager/manager-mainpage?selectedOption=${selectedOption}&keyword=${encodeURIComponent(keyword)}&page=${buttonpage}`;
        }
    });
});

//
// // 게시물 삭제 클릭 시 실행 함수
// const postId = document.querySelector(".detailContent-DeleteButton input");
// function deletePost(seq){
//     Swal.fire({
//         title: '게시물을 삭제하시겠습니까?',
//         text: "삭제하신 게시물은 복구할 수 없습니다.",
//         icon: 'warning',
//         showCancelButton: true,
//         confirmButtonColor: '#3085d6',
//         cancelButtonColor: '#d33',
//         confirmButtonText: '삭제',
//         cancelButtonText: '취소'
//     }).then((result) => {
//         if (result.value) {
//             //"삭제" 버튼을 눌렀을 때 작업할 내용을 이곳에 넣어주면 된다.
//             let f = document.createElement('form');
//
//             let obj;
//             obj = document.createElement('input');
//             obj.setAttribute('type', 'hidden');
//             obj.setAttribute('name', 'postId');
//             obj.setAttribute('value', postId.value);
//
//             f.appendChild(obj);
//             f.setAttribute('method', 'post');
//             f.setAttribute('action', '/community/detail-delete');
//             document.body.appendChild(f);
//             f.submit();
//         }
//     })
// }

function deletePost(postType, postId) {
    if (confirm("게시물을 삭제하시겠습니까?")) {
        $.post("/manager/posts-delete", {
            legalGuideId: (postType === 'legalGuide' ? postId : null),
            solutionCaseId: (postType === 'solutionCase' ? postId : null),
            consultingCaseId: (postType === 'consultingCase' ? postId : null)
        }, function(data) {
            // Handle the response here
            if (data.success) {
                // Delete was successful, you can redirect or perform other actions
                window.location.href = "/manager/manager-mainpage";
            } else {
                // Handle errors, if any
                alert("게시물 삭제에 실패했습니다.");
            }
        }).fail(function() {
            alert("게시물 삭제 요청 중 오류가 발생했습니다.");
        });
    }
}