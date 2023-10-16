function deleteCareer(experienceId){
    Swal.fire({
        title: '해당 경력을 삭제하시겠습니까?',
        text: "삭제하신 게시물은 복구할 수 없습니다.",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '삭제',
        cancelButtonText: '취소'
    }).then((result) => {
        let f = document.createElement("form");
        let obj;
        obj = document.createElement("input");
        obj.setAttribute("type", "hidden");
        obj.setAttribute("name", "experienceId");
        obj.setAttribute("value", experienceId);

        f.appendChild(obj);
        f.setAttribute("method", "post");
        f.setAttribute("action", "/mypage-lawyer/info-update-career-delete");
        document.body.appendChild(f);
        f.submit();
    })
}

const defaultImg = document.querySelector(".mypage-profile-image");
const file = document.querySelector("input[name=file]");
const imageWrapper = document.querySelector(".mypage-profile-image-wrapper");
file.addEventListener("change", (e) => {
    if (file.files && file.files[0]){
        let reader = new FileReader();
        reader.onload = function(e){
            defaultImg.src = e.target.result;
        };
        reader.readAsDataURL(file.files[0]);
    } else {
        defaultImg.src = "/image/defaultLawyerProfile/defaultLawyerProfile.png";
    }
})