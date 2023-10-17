// 제목 및 내용 textarea 클릭 시 팁 내용 및 글자수 보이게 하는 js
// + 제목, 내용, 동의사항 다 만족 시에만 등록하기 버튼 색상 변경

const titleTextarea = document.querySelector(".Compose-Title-Textarea");
const bodyTextarea = document.querySelector(".Compose-Body-Textarea");
const titleTip = document.querySelector(".Title-Textarea .Compose-Title-Guide");
const bodyTip = document.querySelector(".Body-Textarea .Compose-Title-Guide");
const submitButton = document.querySelector(".Compose-Form-Button");
const agreeCheck = document.querySelector(".Compose-Form-Agreement-Checkbox");
const titleCount = document.querySelector(".Title-Count");
const bodyCount = document.querySelector(".Body-Count");
const titleCountWrapper = document.querySelector(".Title-Count-Wrapper");
const bodyCountWrapper = document.querySelector(".Body-Count-Wrapper");
const resultTextarea = document.querySelector(".Compose-Result-Textarea");

function onTitleClickShowTip(){
    titleTip.style.display = "block";
}

function onTitleClickShowCount() {
    titleCountWrapper.style.display = "block";
}

function onTitleBlurHideTip() {
    titleTip.style.display = "none";
}

function onTitleBlurHideCount() {
    titleCountWrapper.style.display = "none";
}

function onBodyClickShowTip(){
    bodyTip.style.display = "block";
}

function onBodyClickShowCount() {
    bodyCountWrapper.style.display = "block";
}

function onBodyBlurHideTip(){
    bodyTip.style.display = "none";
}

function onBodyBlurHideCount(){
    bodyCountWrapper.style.display = "none";
}

function validateButton() {
    submitButton.style.color = "#c50000";
    submitButton.disabled = false;
}

function invalidateButton() {
    submitButton.style.color = "#c4c8cb";
    submitButton.disabled = true;
}

titleTextarea.addEventListener("keyup", (e) => {
    let titleContent = titleTextarea.value.length;
    titleCount.innerText = `${titleContent}자`;
    let bodyContent = bodyTextarea.value.length;
    let resultContent = resultTextarea.value.length;
    let check = agreeCheck.checked;
    if (titleContent >= 10 && bodyContent >= 200 && resultContent > 0 && check) {
        validateButton();
    } else {
        invalidateButton();
    }
})

bodyTextarea.addEventListener("keyup", (e) => {
    let titleContent = titleTextarea.value.length;
    let bodyContent = bodyTextarea.value.length;
    bodyCount.innerText = `${bodyContent}자`;
    let resultContent = resultTextarea.value.length;
    let check = agreeCheck.checked;
    if (titleContent >= 10 && bodyContent >= 200 && resultContent > 0 && check) {
        validateButton();
    } else {
        invalidateButton();
    }
})

resultTextarea.addEventListener("keyup", (e) => {
    let titleContent = titleTextarea.value.length;
    let bodyContent = bodyTextarea.value.length;
    let resultContent = resultTextarea.value.length;
    let check = agreeCheck.checked;
    if (titleContent >= 10 && bodyContent >= 200 && resultContent > 0 && check) {
        validateButton();
    } else {
        invalidateButton();
    }
})

agreeCheck.addEventListener("click", (e) => {
    let titleContent = titleTextarea.value.length;
    let bodyContent = bodyTextarea.value.length;
    let resultContent = resultTextarea.value.length;
    let check = agreeCheck.checked;
    if (titleContent >= 10 && bodyContent >= 200 && resultContent > 0 && check) {
        validateButton();
    } else {
        invalidateButton();
    }
})

const file = document.querySelector("input[name=files]");
const imgWrapper = document.querySelector(".upload-image-wrapper");
const deleteBtn = document.querySelector(".image-input-btn-wrapper button");
let selFiles = [];
let f;
file.addEventListener("change", (e) => {
    let files = e.target.files;
    let fileArr = Array.prototype.slice.call(files);
    for (f of fileArr) {
        imageLoader(f);
    }
})

imageLoader = function(file){
    selFiles.push(file);
    let reader = new FileReader();
    reader.onload = function(ee){
        let img = document.createElement("img");
        img.setAttribute("class", "uploaded-image");
        img.src = ee.target.result.toString();
        imgWrapper.appendChild(img);
    }
    reader.readAsDataURL(file);
};

function deleteImages(){
    file.value = "";
    let length = imgWrapper.children.length-1;
    while(imgWrapper.hasChildNodes()){
        imgWrapper.removeChild(imgWrapper.childNodes[length--]);
    }
}
