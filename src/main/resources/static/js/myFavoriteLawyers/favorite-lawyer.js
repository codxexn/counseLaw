// 즐겨 찾기 별 이미지 변환
const starImage = document.querySelector('.star');
let memberId;
let url;
if (starImage != null){
    starImage.addEventListener("click",
        (e) =>  {
            memberId = document.querySelector("input[name=memberId]").value;
            lawyerId = document.querySelector("input[name=lawyerId]").value;
            if(e.target.src.includes("yellowStar.png")){
                url = "/lawyer-home/like-delete?lawyerId=" + lawyerId + "&memberId=" + memberId;
                fetch(url)
                    .then(response => response.text())
                    .then(data => {
                        if (data === "fail"){
                            alert("서버 오류가 발생했습니다. 다시 시도해주세요.");
                            return;
                        } else if (data === "success"){
                            alert("즐겨찾기가 해제되었습니다.");
                        } else {
                            alert("알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
                            return;
                        }
                    })
                    .catch((error) => {
                        console.log("오류 발생 : " + error);
                    })
                e.target.src = "/image/lawyerHome/blankedStarYellow.png";
            } else {
                url = "/lawyer-home/like?lawyerId=" + lawyerId + "&memberId=" + memberId;
                fetch(url)
                    .then(response => response.text())
                    .then(data => {
                        if (data === "fail"){
                            alert("이미 즐겨찾기한 변호사입니다.");
                        } else if (data === "success"){
                            alert("즐겨찾기가 반영되었습니다.");
                        } else {
                            alert("알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
                            return;
                        }
                    })
                    .catch((error) => {
                        console.log("오류 발생 : " + error);
                    })
                e.target.src = "/image/lawyerHome/yellowStar.png";
            }
        });
}