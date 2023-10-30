const heart = document.querySelector(".useful");
const bxHeart = heart.querySelector(".bx-heart");
const bxsHeart = heart.querySelector(".bxs-heart");
const share = document.querySelector(".share");


heart.addEventListener("click", () => {
    if(bxHeart.style.display == "block") {
        bxHeart.style.display = "none";
        bxsHeart.style.display = "block";
        heart.style.color = "#ff6d37";
        bxsHeart.style.color = "#ff6d37";
    } else {
        bxHeart.style.display = "block";
        bxsHeart.style.display = "none";
        heart.style.color = "#aa999d";
        bxsHeart.style.color = "#aa999d";
    }
});

share.addEventListener("click", () => {
    Swal.fire({
        icon: 'success',
        title: 'URL 복사 완료!'
    });
});



function clip() {

    let url = '';
    let textarea = document.createElement("textarea");
    document.body.appendChild(textarea);
    url = window.document.location.href;
    textarea.value = url;
    textarea.select();
    document.execCommand("copy");
    document.body.removeChild(textarea);
}


// mobile

const heartMobile = document.querySelector(".useful-mobile");
const bxHeartMobile = heartMobile.querySelector(".bx-heart.mobile");
const bxsHeartMobile = heartMobile.querySelector(".bxs-heart.mobile");
const shareMobile = document.querySelector(".share-mobile");

heartMobile.addEventListener("click", () => {
    if(bxHeartMobile.style.display == "block") {
        bxHeartMobile.style.display = "none";
        bxsHeartMobile.style.display = "block";
        heartMobile.style.color = "#ff6d37";
        bxsHeartMobile.style.color = "#ff6d37";
    } else {
        bxHeartMobile.style.display = "block";
        bxsHeartMobile.style.display = "none";
        heartMobile.style.color = "#aa999d";
        bxsHeartMobile.style.color = "#aa999d";
    }
});

shareMobile.addEventListener("click", () => {
    Swal.fire({
        icon: 'success',
        title: 'URL 복사 완료!'
    });
});