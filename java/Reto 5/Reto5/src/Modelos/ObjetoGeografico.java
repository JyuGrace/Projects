
package Modelos;


public class ObjetoGeografico {
    
    private String nombre;
    private int id;
    private String municipio;
    
    
        
    public ObjetoGeografico (){
    }

    public ObjetoGeografico(String nombre, String municipio, int id) {
        this.nombre = nombre;
        this.municipio = municipio;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
    
    

    