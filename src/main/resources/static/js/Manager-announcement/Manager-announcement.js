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


function deletePost(postId){
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
            obj.setAttribute('name', 'noticeId');
            obj.setAttribute('value', postId);

            f.appendChild(obj);
            f.setAttribute('method', 'post');
            f.setAttribute('action', '/manager/notices-delete');
            document.body.appendChild(f);
            f.submit();
        }
    })
}






