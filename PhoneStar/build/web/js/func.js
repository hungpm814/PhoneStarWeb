
function increaseQuantity() {
    var quantityInput = document.getElementById("quantity");
    var currentValue = parseInt(quantityInput.value);
    var maxQuantity = document.querySelector(".kho").innerHTML;
    console.log(maxQuantity);
    if (currentValue < maxQuantity) {
        quantityInput.value = currentValue + 1;
    }
}

function decreaseQuantity() {
    var quantityInput = document.getElementById("quantity");
    var currentValue = parseInt(quantityInput.value);
    if (currentValue > 1) {
        quantityInput.value = currentValue - 1;
    }
}

let quantityInput = document.getElementById("quantity");
let maxQuantity = document.querySelector(".kho").innerHTML;
quantityInput.addEventListener('input', () =>{
    quantity = quantityInput.value;
    quan = parseInt(quantity);
    quan = isNaN(quan)?1:quan;
    quan = (quan>maxQuantity)?maxQuantity:quan;
    quantityInput.value = quan;
})

function buy(series, type){
    document.f.action = "cart?series="+series+"&quantity="+quantityInput.value+"&type="+type;
    document.f.submit();
}


  // Kích hoạt toast
  $(document).ready(function(){
    $('.toast').toast();
  });

  // Hiển thị toast khi cần thiết
  function showToast(message) {
    $('.toast-body').text(message);
    $('.toast').toast('show');
  }

