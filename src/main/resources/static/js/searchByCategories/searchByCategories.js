// 카테고리 타이틀 마우스오버시 돋보기 img 추가 및 삭제

const listAll = document.querySelectorAll(".find-category__title");
const image = document.createElement('img');

listAll.forEach((list)=>{
    list.addEventListener('mouseover', (e)=> {
        e.target.appendChild(image);
        image.className = 'magnifier';
        image.src = './magnifier.png'
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