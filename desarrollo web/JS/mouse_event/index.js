const coordinateX = document.getElementById("coordinate_x");
const coordinateY = document.getElementById("coordinate_y");

window.addEventListener('mousemove', (event) => {
  coordinateX.innerHTML = event.clientX;
  coordinateY.innerHTML = event.clientY;
});