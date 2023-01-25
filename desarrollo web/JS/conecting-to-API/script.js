// Access DOM elements
const reportSection = document.getElementById('weather-report');
const cityForm = document.getElementById('city-form');
const cityInput = document.getElementById('city');

// create a request object
let apiRequest = new XMLHttpRequest();

cityForm.addEventListener('submit', ($event) => {
    $event.preventDefault();
    const chosenCity = cityInput.value;

    apiRequest.open('GET', 'https://api.openweathermap.org/data/2.5/weather?q=' + chosenCity + '&APPID=b34fddd3dae4a2eb0ad363b62f98ba1e');
    apiRequest.send();

    //im adding this right here just for testing purposes
    reportSection.style.border="thin solid black";
});

apiRequest.onreadystatechange = () => {
    if (apiRequest.readyState === 4) {
        console.log(apiRequest.readyState);
        if (apiRequest.status === 404){
            console.log(apiRequest.status);
            return reportSection.textContent = "City not Found!";
        };
        const response = JSON.parse(apiRequest.response);

        reportSection.textContent = 'The weather in ' + response.name + ' is ' + response.weather[0].main + '.';
    };
};