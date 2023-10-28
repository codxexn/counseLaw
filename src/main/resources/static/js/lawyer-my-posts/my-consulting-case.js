const expand = document.getElementById('expand');
const content = document.getElementById('content');
const reduce = document.getElementById("reduce");

function showContent() {
    content.style.maxHeight = '3000px';
    expand.style.display = "none";
    reduce.style.display = "block";
}

function hideContent(){
    content.style.maxHeight = '282px';
    expand.style.display = "block";
    reduce.style.display = "none";
}

expand.addEventListener('click', showContent);
reduce.addEventListener("click", hideContent);