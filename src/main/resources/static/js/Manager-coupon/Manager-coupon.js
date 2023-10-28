const modalOpenButton = document.getElementById('modalOpenButton');
const modalCloseButton = document.getElementById('modalCloseButton');
const modal = document.getElementById('modalContainer');
const pagination = document.querySelector(".review-pagination");

modalOpenButton.addEventListener('click', () => {
    modal.classList.remove('hidden');
    pagination.style.display = "none";
});

modalCloseButton.addEventListener('click', () => {
    modal.classList.add('hidden');
    pagination.style.display = "block";
});




// 모달창으로 쿠폰 추가하기
const couponTitle = document.querySelector(".couponTitle");
const couponExpireDate = document.querySelector(".couponExpireDate");
const couponAvailableType = document.querySelector(".couponAvailableType");
const couponDiscountRate = document.querySelector(".couponDiscountRate");
const couponNumber = document.querySelector(".couponNumber");
const memberId = document.querySelector(".memberId");
const addCouponBtn = document.querySelector(".coupon-add");

function validateBtn(){
    if (!couponTitle.value || !couponAvailableType.value || !couponDiscountRate.value){
        addCouponBtn.disabled = true;
    } else {
        addCouponBtn.disabled = false;
    }
}

let url;
function addCoupon(){
    if (!couponTitle.value || !couponAvailableType.value || !couponDiscountRate.value){
        return;
    }
    Swal.fire({
        title: '쿠폰을 등록하시겠습니까?',
        text: "등록하신 쿠폰은 수정하실 수 없습니다.\n수정을 원하시면 삭제 후 다시 등록해주세요.",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '등록',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.value) {
            url = "/manager/coupon-insert?couponTitle=" + couponTitle.value + "&couponExpireDate=" + (!couponExpireDate.value ? "false" : couponExpireDate.value) +
                "&couponAvailableType=" + couponAvailableType.value + "&couponDiscountRate=" + couponDiscountRate.value +
                "&couponNumber=" + (!couponNumber.value ? 'false' : couponNumber.value) + "&memberId=" + (!memberId.value ? "false" : memberId.value);
            fetch(url, {
                method: "POST"
            }).then((response) => response.text())
                .then((data) => {
                    if (data === "fail") {
                        alert("서버 오류가 발생했습니다. 다시 시도해주세요.");
                    } else if (data === "success") {
                        alert("쿠폰이 등록되었습니다.");
                        location.reload();
                    } else {
                        alert("알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
                    }
                })
                .catch((error) => {
                    console.log("오류 발생 : " + error);
                });
        }
})}

function deleteCoupon(couponId){
    Swal.fire({
        title: '쿠폰을 삭제하시겠습니까?',
        text: "삭제하신 쿠폰은 복구할 수 없으며, 의뢰인이 보유한 해당 쿠폰도 삭제됩니다.",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '삭제',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.value) {
            url = "/manager/coupon-delete?couponId=" + couponId;
            fetch(url, {
                method: "POST"
            })
                .then((response) => response.text())
                .then((data) => {
                    if (data === "fail"){
                        alert("서버 오류가 발생했습니다. 다시 시도해주세요.");
                    } else if (data === "success"){
                        alert("쿠폰이 삭제되었습니다.");
                        location.reload();
                    } else {
                        alert("알 수 없는 오류가 발생했습니다. 다시 시도해주세요.");
                    }
                })
                .catch((error) => {
                    console.log("오류 발생 : " + error);
                });
        }
    })
}