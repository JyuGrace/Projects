
package reto4;


public class ObjetoGeografico {
    
    private String nombre;
    private int id;
    private String municipio;
    private String TipoCuerpoAgua;
    private String TipoDeAgua;
    private float irca;

    
    public ObjetoGeografico (){
    }
    
    public ObjetoGeografico(String nombre, int id, String municipio, String TipoCuerpoAgua, String TipoDeAgua, float irca) {
        this.nombre = nombre;
        this.id = id;
        this.municipio = municipio;
        this.TipoCuerpoAgua = TipoCuerpoAgua;
        this.TipoDeAgua = TipoDeAgua;
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

    public String getTipoCuerpoAgua() {
        return TipoCuerpoAgua;
    }

    public void setTipoCuerpoAgua(String TipoCuerpoAgua) {
        this.TipoCuerpoAgua = TipoCuerpoAgua;
    }

    public String getTipoDeAgua() {
        return TipoDeAgua;
    }

    public void setTipoDeAgua(String TipoDeAgua) {
        this.TipoDeAgua = TipoDeAgua;
    }

    public float getIrca() {
        return irca;
    }

    public void setIrca(float irca) {
        this.irca = irca;
    }
    
    

    
    
    
}
