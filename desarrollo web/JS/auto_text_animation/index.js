const containerText = document.querySelector(".container");

const carrers = ["Chemical Engineer", "Teacher", "Passionate for Calisthenics", "Instructor"];
let carrersIndex = 0;
let characterIndex = 0;

updateText();

function updateText() {
    characterIndex++;
    containerText.innerHTML = `<h1>I'm ${carrers[carrersIndex].slice(0,1) === "I"? "an" : "a"} ${carrers[carrersIndex].slice(0, characterIndex)}</h1>`;

    if(characterIndex === carrers[carrersIndex].length){
        carrersIndex++;
        characterIndex = 0;
    };
    if (carrersIndex === carrers.length){
        carrersIndex = 0;
    };
    setTimeout(updateText, 300);
};
