package reto1;
import java.util.Scanner;
public class reto1 {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print(""); // solicita el numero de datos a ingresar
        int n = input.nextInt();
        int v_irca [] = new int[n];
        int resultados_a_evaluar [] = new int[3];
        int suma = 0, temporal;
        float promedio;
                
        for (int i = 0; i < n; i++) {
            System.out.print(""); //solicita los valores de entrada
            v_irca[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            suma += v_irca[i];
        }
        // calcular el promedio
        promedio = suma/n;
        
          
        // ordenar el vector
        for (int j = 0; j < v_irca.length - 1; j++) { 
            for (int i = 0; i < v_irca.length - 1; i++) {
                if (v_irca[i] > v_irca[i+1]){
                    temporal = v_irca[i];
                    v_irca[i] = v_irca[i+1];
                    v_irca[i+1] = temporal;
                }
            }
        }    
        
        //imprime el vector
        for (int i = 0; i < v_irca.length; i++) {
            System.out.println(v_irca[i]);
        }
        
        // se llama a la funcion
        nivelriesgo(promedio); // promedio
        nivelriesgo(v_irca[v_irca.length-1]); // mayor
        nivelriesgo(v_irca[0]); // menor
            
    }
        public static void nivelriesgo(float x){
            if (x > 80 && x <= 100){
                System.out.println("INVIABLE SANITARIAMENTE");
            }
            else if (x > 35 && x <= 80){
                System.out.println("ALTO");
            }
            else if (x > 14 && x <= 35){
                System.out.println("MEDIO");
            }
            else if (x > 5 && x <= 14){
                System.out.println("BAJO");
            }
            else if (x >= 0 && x <= 5){
                System.out.println("SIN RIESGO");
            }
        }
}
