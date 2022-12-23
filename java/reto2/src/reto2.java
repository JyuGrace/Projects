import java.util.Scanner;
public class reto2 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, contar_medio = 0;
        //solicita el numero de muestras a tomar
        System.out.println("ingrese el # de cuerpos de agua a evaluar: ");
        n = input.nextInt();

        //sin esta linea da error, why?
        input.nextLine();

        CuerpoDeAgua data [] = new CuerpoDeAgua[n];
        //solicita y almacena los datos en array de objetos
        for (int i = 0; i < n; i++){
            System.out.println("ingrese el irca de la muestra "+(i)+" : ");
            String datos_str [] = input.nextLine().split(" ");
            int id_integer = Integer.parseInt(datos_str[1]);
            float irca_float = Float.parseFloat(datos_str[3]);
            data [i] = new CuerpoDeAgua(datos_str[0], id_integer, datos_str[2], irca_float);

        }
        //llama la funcion nivel y determina el nivel de riesgo de cada muestra
        for (int i = 0; i < data.length; i++) {
            String x = data[i].nivel();//preguntar tutoria
            System.out.println(x);
            //cuenta el numero de muestras con nivel de riesgo medio
            if (data[i].getIrca() >= 0 && data[i].getIrca() < 35) {
                contar_medio ++;
            }
       }
       System.out.println(contar_medio);
       //imprime el nombre si la muestra es posee nivel de riesgo medio
       if (contar_medio > 0) {
            for (int i = 0; i < data.length; i++) {
                if (data[i].getIrca() > 14 && data[i].getIrca() <= 35) {
                    System.out.print(data[i].getNombre()+" "); //espacio para match output
                }
            }        
        } 
        else {
            System.out.println("NA");
        }
        //agregamos un salto de linea
        System.out.println();
        // imprime el nombre e id de muestra conmenor nivel de riesgo
        String nombre_menor = data[0].getNombre();
        float irca_menor = data[0].getIrca();
        int id_menor = data[0].getId();

        for (int i = 0; i < data.length; i++) {
            if (data[i].getIrca() < irca_menor) {
                irca_menor = data[i].getIrca();
                nombre_menor = data[i].getNombre();
                id_menor = data[i].getId();
            }
        }
        System.out.println(nombre_menor+" "+ id_menor);

        

    }

}