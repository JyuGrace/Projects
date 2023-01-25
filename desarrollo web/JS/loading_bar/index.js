const counter = document.querySelector(".counter");
const loadingBar = document.querySelector(".loading-bar-front");

let loadingNumber = 0;

updateNumber ();

function updateNumber () {
    counter.innerHTML = loadingNumber + "%";
    loadingBar.style.width = loadingNumber + "%";

    loadingNumber++;
    if (loadingNumber < 101) {
        setTimeout(updateNumber, 50);
    };
};