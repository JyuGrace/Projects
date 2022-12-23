function validar_formulario() {
    let usuario=document.formRegistro.usuario;
    let password=document.formRegistro.password;
    let email=document.formRegistro.correo;

    let longitudUsuario=usuario.value.length;
    if (longitudUsuario==0 || longitudUsuario<8) {
        alert("Debes ingresar un nombre de usario minimo con 8 caracteres")
        usuario.focus();
        return false;
        
    }
    let formato_email= /^\w+([\.-]?\w+)@\w+([\.-]?\w+)(\.\w{2,3})+$/;
    if (!email.value.match(formato_email)) {
        alert("Debes ingresar un correo valido");
        email.focus();
        return false;
        
    }


    let longitudpassword=password.value.length;
    if (longitudpassword==0 || longitudpassword<8) {
        alert("Debes ingresar un password de  minimo con 8 caracteres")
        password.focus();
        return false;
        
    }  
}

function mostrarPassword() {
    var obj=document.getElementById("password");
    obj.type="text";   
}

function ocultarPassword(){
    var obj=document.getElementById("password");
    obj.type="password";
}

function ocultarFormulario() {    
    document.getElementById("formRegistro").style.display = "none";
    // document.getElementById("formRegistro").style.visibility = "hidden";
    
}

function mostrarFormulario() {
    document.getElementById("formRegistro").style.display = "block";
    // document.getElementById("formRegistro").style.visibility = "visible";
}