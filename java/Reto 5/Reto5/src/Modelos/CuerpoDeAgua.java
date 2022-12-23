
package Modelos;


public class CuerpoDeAgua extends ObjetoGeografico{
    //atributos
    private String TipoCuerpoAgua;
    private String TipoDeAgua;
    private float irca;
    
    //Constructores

    public CuerpoDeAgua(String TipoCuerpoAgua, String TipoDeAgua, float irca) {
        this.TipoCuerpoAgua = TipoCuerpoAgua;
        this.TipoDeAgua = TipoDeAgua;
        this.irca = irca;
    }

    public CuerpoDeAgua(String TipoCuerpoAgua, String TipoDeAgua, float irca, String nombre, String municipio, int id) {
        super(nombre, municipio, id);
        this.TipoCuerpoAgua = TipoCuerpoAgua;
        this.TipoDeAgua = TipoDeAgua;
        this.irca = irca;
    }
         
      
    public CuerpoDeAgua () {
        super();
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
    
    
   
    public String nivel() {
        if (this.irca > 80 && this.irca <= 100){
            return "INVIABLE SANITARIAMENTE";
        }
        else if (this.irca > 35 && this.irca <= 80){
            return "ALTO";
        }
        else if (this.irca> 14 && this.irca <= 35){
            return "MEDIO";
        }
        else if (this.irca  > 5 && this.irca <= 14){
            return "BAJO";
        }
        else if (this.irca >= 0 && this.irca <= 5){
            return "SIN RIESGO";
        }
        return "No clasifica";
    }
}
    

    