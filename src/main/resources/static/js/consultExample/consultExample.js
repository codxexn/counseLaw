const expand = document.getElementById('expand');
const content = document.getElementById('content');

function toggleContent() {
    if (content.style.maxHeight === '3000px') {
        content.style.maxHeight = '282px';
    } else {
        content.style.maxHeight = '3000px';
    }
}

expand.addEventListener('click', toggleContent);