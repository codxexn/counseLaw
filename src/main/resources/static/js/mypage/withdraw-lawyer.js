function withdraw(){
    Swal.fire({
        title: '정말 탈퇴하시겠습니까?',
        text: "작성하신 모든 게시물 및 답글이 삭제되며, 복구할 수 없습니다.",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '탈퇴',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.value) {
            let lawyerId = document.querySelector("input[name=lawyerId]").value;
            let url = "/mypage-lawyer/withdraw?lawyerId=" + lawyerId;
            fetch(url)
                .then((response) => response.text())
                .then((data) => {
                    if (data === "fail"){
                        alert("서버 오류가 발생했습니다. 다시 시도해주세요.");
                        return;
                    } else if (data === "success"){
                        alert("회원탈퇴가 완료되었습니다. 메인페이지로 이동합니다.");
                        location.replace("/login/logout-finally");
                    } else {
                        alert("알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
                        return;
                    }
                })
                .catch((error) => {
                    console.log("오류 발생 : " + error);
                })
        }
    })
}
