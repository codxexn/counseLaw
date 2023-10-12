const posting = document.querySelector(".title-text");
const mainpost = document.querySelector(".post-mainPost");
globalThis.flag = false;
const postBtn = document.querySelector(".storageBtn");
const postPost = document.querySelector(".post-post");
posting.addEventListener("keyup", () => {
    if(posting.value){
        postBtn.disabled = false;
    } else {
        postBtn.disabled = true;
    }
});

posting.addEventListener("keyup", () => {
    if(mainpost.value && posting.value) {
        postPost.disabled = false;
    } else {
        postPost.disabled = true;
    }
});

mainpost.addEventListener("keyup", () => {
    if(mainpost.value && posting.value) {
        postPost.disabled = false;
    } else {
        postPost.disabled = true;
    }
})