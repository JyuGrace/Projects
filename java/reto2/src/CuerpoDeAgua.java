public class CuerpoDeAgua {
    //caracteristicas
    public String nombre;
    public int id;
    public String municipio;
    public float irca;

    // constructor 
    
    //metodo IRCA
    public String nivel () {

        if (this.irca> 80 && this.irca <= 100){
            return "INVIABLE SANITARIAMENTE";
        }
        else if (this.irca > 35 && this.irca <= 80){
            return "ALTO";
        }
        else if (this.irca > 14 && this.irca <= 35){
            return "MEDIO";
        }
        else if (this.irca > 5 && this.irca <= 14){
            return "BAJO";
        }
        else if (this.irca >= 0 && this.irca <= 5){
            return "SIN RIESGO";
        }
        return "ENTRADA NO VALIDA";
        
    }

    public CuerpoDeAgua(String nombre, int id, String municipio, float irca) {
        this.nombre = nombre;
        this.id = id;
        this.municipio = municipio;
        this.irca = irca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public float getIrca() {
        return irca;
    }

    public void setIrca(float irca) {
        this.irca = irca;
    } 
    
    //getters and setters
    
}
