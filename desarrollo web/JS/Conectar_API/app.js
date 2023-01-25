let lenguage = "en-US";
const btnLenguage = document.getElementById("btnLenguage");

btnLenguage.addEventListener("click", () => {
    if (lenguage === "en-US") {
        lenguage = "es-COL";
    } else {
        lenguage = "en-US";
    }
    loadMovie();
});
//controla la pagina de resultados q se muestra 
let pagina = 1;
const btnAnterior = document.getElementById("btnAnterior");
const btnSiguiente = document.getElementById("btnSiguiente");

btnSiguiente.addEventListener("click", () => {
    if(pagina < 1000) {
        pagina += 1;
        loadMovie();
    }
});
btnAnterior.addEventListener("click", () => {
    if(pagina > 1000) {
        pagina -= 1;
        loadMovie();
    }
});


//se coencta a la API
const loadMovie = async() => {
    try {
         // cuando pasas un fetch, el server te responde con una promesa
        const response = await fetch(`https://api.themoviedb.org/3/movie/popular?api_key=ece6da2757c4cb9785df25b1c3575a60&language=${lenguage}&page=${pagina}`);
        console.log(response);

        //si la respuesta es correcta
        if(response.status === 200) {
            const datos = await response.json();

            let peliculas = ``;
            datos.results.forEach(pelicula => {
                peliculas += `
                <div class="pelicula">
                    <img class="poster" src="https://image.tmdb.org/t/p/w500${pelicula.poster_path}">
                    <h3 class="titulo">${pelicula.title}</h3>
                </div>
                `
            }); 
            document.getElementById("contenedor").innerHTML = peliculas;

            //console.log(datos.results[0].poster_path);
        } else if (response.status === 401) {
            console.log("LLave equivocada.. no apunta a ninguna Movie");
        } else if (response.status === 404) {
            console.log("la pelicula que existes no existe!")
        } else {
            console.log("Somethig went wrong");
        };

        

    } catch (error) {
        console.log(error);
    }
   
};

loadMovie();