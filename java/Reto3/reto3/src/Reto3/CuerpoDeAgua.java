
package Reto3;


public class CuerpoDeAgua extends ObjetoGeografico{
    //atributos
    
    
    public CuerpoDeAgua(String nombre, int id, String municipio, float irca, String TipoDeAgua, String TipoCuerpoAgua){
        super(nombre, id, municipio, irca, TipoDeAgua, TipoCuerpoAgua);
    }

    public String nivel() {
        if (getIrca () > 80 && getIrca () <= 100){
            return "INVIABLE SANITARIAMENTE";
        }
        else if (getIrca () > 35 && getIrca () <= 80){
            return "ALTO";
        }
        else if (getIrca () > 14 && getIrca () <= 35){
            return "MEDIO";
        }
        else if (getIrca () > 5 && getIrca () <= 14){
            return "BAJO";
        }
        else if (getIrca () >= 0 && getIrca () <= 5){
            return "SIN RIESGO";
        }
        return "No clasifica";
    }
}
    

    