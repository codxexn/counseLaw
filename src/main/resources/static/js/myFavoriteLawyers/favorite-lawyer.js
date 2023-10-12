// 변호사 이름 옆 별 누르면 해제
NodeList.prototype.indexOf = Array.prototype.indexOf;
const filledStars = document.querySelectorAll(".My-Lawyer-Star-Wrapper .bi-star-fill");
const emptyStars = document.querySelectorAll(".My-Lawyer-Star-Wrapper .bi-star");

filledStars.forEach((star) => {
    let starIndex = filledStars.indexOf(star);
    star.addEventListener("click", (e) => {
        console.log(e.target);
        e.preventDefault();
        star.style.display = "none";
        emptyStars[starIndex].style.display = "inline";
    })
})

emptyStars.forEach((star) => {
    let starIndex = emptyStars.indexOf(star);
    star.addEventListener("click", (e) => {
        console.log(e.target);
        e.preventDefault();
        star.style.display = "none";
        filledStars[starIndex].style.display = "inline";
    })
})
