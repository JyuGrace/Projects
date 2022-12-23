
package Modelos;

public class DensidadPoblacional extends ObjetoGeografico{
    
    private int num_habitantes;

    //constructores
    public DensidadPoblacional (){
        super();
    }
    
    public DensidadPoblacional(int num_habitantes) {
        this.num_habitantes = num_habitantes;
    }

    public DensidadPoblacional(int num_habitantes, String nombre, String municipio, int id) {
        super(nombre, municipio, id);
        this.num_habitantes = num_habitantes;
    }

   
    //get and set

    public int getNum_habitantes() {
        return num_habitantes;
    }

    public void setNum_habitantes(int num_habitantes) {
        this.num_habitantes = num_habitantes;
    }
   


    public int nivelAfeccion() {
        if (this.num_habitantes < 10000) {
            return 0;
        }
        else if (this.num_habitantes >= 10000 && this.num_habitantes <= 50000) {
            return 1;
        }
        else  {
            return 2;
        }
    }
    
}
