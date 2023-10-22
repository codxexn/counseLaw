// 카테고리 타이틀 마우스오버시 돋보기 img 추가 및 삭제

const listAll = document.querySelectorAll(".find-category__title");
const image = document.createElement('img');

listAll.forEach((list)=>{
    list.addEventListener('mouseover', (e)=> {
        e.target.appendChild(image);
        image.className = 'magnifier';
        image.src = '/image/searchByCategories/magnifier.png';
    });

    list.addEventListener('mouseout', (e) => {
        e.target.removeChild(image);
    })
});

// translate, transform

const option = document.querySelector(".wide-toggle__option-hovering");
option.addEventListener('click', (e) => {
    e.target.transform.translate = '(100px,0)';
})



// 탭 클릭 시 해당 위치로 스크롤 이동
const categoryTabs = document.querySelectorAll(".group-category-list__item");
const categories = document.querySelectorAll(".find-group-category");
categoryTabs[0].classList.add("active");
for (let i=0; i < categoryTabs.length; i++){
    categoryTabs[i].addEventListener("click", (e) => {
        e.preventDefault();
        for (let j=0; j < categoryTabs.length; j++){
            if (categoryTabs[j].classList.contains("active")){
                categoryTabs[j].classList.remove("active");
            }
        }
        categoryTabs[i].classList.add("active");
        let location = categories[i].offsetTop;
        window.scrollTo({top: location, behavior:'smooth'});
    })
}

let scrollYs = [];
categories.forEach((category) => {
    scrollYs.push(category.offsetTop);
})

const left = document.querySelector(".group-category-list-wrap");
const bottom = document.querySelector(".group-category-list");
window.addEventListener("scroll", (e) => {
    let cur = window.scrollY;
    let targetScroll = 0;
    for (let i=0; i < scrollYs.length; i++){
        if (cur >= scrollYs[i]){
            targetScroll = i;
        } else break;
    }
    categoryTabs.forEach((categoryTab) => {
        if (categoryTab.classList.contains("active")){
            categoryTab.classList.remove("active");
        }
    })
    categoryTabs[targetScroll].classList.add("active");
    if (cur >= scrollYs[0]){
        if (!left.classList.contains("fixed")){
            left.classList.add("fixed");
        }
    } else {
        if (left.classList.contains("fixed")){
            left.classList.remove("fixed");
        }
    }
    if (cur >= scrollYs[scrollYs.length-2]){
        left.classList.remove("fixed");
        bottom.classList.add("bottom-fix");
        bottom.style.maxHeight = "739px";
    } else {
        if (bottom.classList.contains("bottom-fix")){
            bottom.classList.remove("bottom-fix");
            bottom.style.maxHeight = "583px";
        }
    }
})