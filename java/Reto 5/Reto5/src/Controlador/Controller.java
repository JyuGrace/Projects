
package Controlador;

import Modelos.CuerpoDeAgua;
import Modelos.DensidadPoblacional;
import Vista.Vista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class Controller extends Vista{
    private DefaultTableModel datosTablaDensidadPoblacional;
    
    CuerpoDeAgua C_Agua = new CuerpoDeAgua();
    List <CuerpoDeAgua> AguaList = new ArrayList <>();
    
    DensidadPoblacional Poblacion = new DensidadPoblacional();
    List <DensidadPoblacional> Poblacion_List = new ArrayList<>();
    
    
    //constructor de la vista
    public Controller (){
        inicializarTabla();
        eventosBtnIngresarIngresar();
        eventosBtnIngresarLimpiar();
        eventosBtnProcesarObtenerDatos();
        eventosBtnProcesarProcesarDatos();
        eventosBtnEdit_DelConsultar();
        eventosBtnEdit_DelEditar();
        eventosBtnEdit_DelEliminar();
        eventosBbtnDensidadPoblacionalRegistrar();
        eventosBtnDensidadPoblacional_LimpiarCampos();
        eventosBtnDensidadPoblacionalProcesar();
        setVisible(true);
    }
    
    //eventos botones
    private void eventosBtnIngresarIngresar() {
        btnIngresarIngresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                //C_Agua = new CuerpoDeAgua("nombre", 0, "minicipio", "tcagua", "tipoagua", 30);
                CuerpoDeAgua C_Agua = new CuerpoDeAgua();

                C_Agua.setNombre(txtIngresarNombre.getText());
                C_Agua.setId(Integer.parseInt(txtIngresarId.getText()));
                C_Agua.setMunicipio(txtIngresarMunicipio.getText());
                C_Agua.setTipoCuerpoAgua(txtIngresarTC_agua.getText());
                C_Agua.setTipoDeAgua(txtIngresarTAgua.getText());
                C_Agua.setIrca(Float.parseFloat(txtIngresarIrca.getText()));

                guardarCuerpoAgua(C_Agua);//llena la lista con los registros
                JOptionPane.showMessageDialog(null, "Cuerpo de agua Guardado");
                  }
         });
    }
    
    private void eventosBtnIngresarLimpiar() {
        btnIngresarLimpiar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                limpiarCamposIngresar();
                }
        });
    }
    
    private void eventosBtnProcesarObtenerDatos() {
        btnProcesarObtenerDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                txtAreaObtenerdatos.setText("");
                llenarTextAreaProcesar ();
                }
        });
    }
    
    private void eventosBtnProcesarProcesarDatos() {
        btnProcesarProcesarDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                int contador = 0;
                String riesgo;

                jTextArea2.setText("");

                String datos [] = new String [6];

                for (int i = 0; i < AguaList.size(); i++) {
                    riesgo = AguaList.get(i).nivel();
                    jTextArea2.append(riesgo +"\n");

                    if (AguaList.get(i).getIrca() >= 0 && AguaList.get(i).getIrca() <= 35){
                    contador ++;
                    }
                }
                jTextArea2.append(contador + "\n");

                if (contador > 0){
                    for (int i = 0; i < AguaList.size(); i++) {
                    riesgo = AguaList.get(i).nivel();
                        if ("MEDIO".equals(riesgo)){
                            jTextArea2.append(AguaList.get(i).getNombre()+"\n");
                        } 
                    }
                       }else {
                            jTextArea2.append("NA");
                              }

                // find lesser
                float menor =  AguaList.get(0).getIrca();// vector[0].getIrca();
                String nomb = AguaList.get(0).getNombre();
                int cod = AguaList.get(0).getId();

                for (int i = 0; i < AguaList.size(); i++) {
                    if(AguaList.get(i).getIrca() < menor){
                        menor = AguaList.get(i).getIrca();
                        nomb = AguaList.get(i).getNombre();
                        cod = AguaList.get(i).getId();
                    }
                }
                jTextArea2.append(nomb+ " "+cod);
                }
        });
    }
    
    private void eventosBtnEdit_DelConsultar() {
        btnEdit_DelConsultar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                int x = Integer.parseInt(txtEdit_DelIdConsulta.getText());
                boolean finded = false;
                int index = 0;
                 
                for (int i =0; i < AguaList.size(); i++) {
                    if (AguaList.get(i).getId() == x) {
                        finded = true;
                        index = i;
                    }
                    
                }
                if (finded) {
                txtEdit_Del_Nombre.setText(AguaList.get(index).getNombre());
                txtEdit_Del_Id.setText(""+AguaList.get(index).getId());
                txtEdit_Del_Municipio.setText(AguaList.get(index).getMunicipio());
                txtEdit_Del_TC_Agua.setText(AguaList.get(index).getTipoCuerpoAgua());
                txtEdit_Del_TAgua.setText(AguaList.get(index).getTipoDeAgua());
                txtEdit_Del_Irca.setText(""+AguaList.get(index).getIrca());
                            }
                else {
                        JOptionPane.showMessageDialog(null,"Este Cuerpo de agua no se encuentra registrado");
                        limpiarCamposUpdateDelete();
                    }
            }
        });
    }
    
    private void eventosBtnEdit_DelEditar() {
        btnEdit_DelEditar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                String nombre = txtEdit_Del_Nombre.getText();
                String municipio = txtEdit_Del_Municipio.getText();
                String tc_agua = txtEdit_Del_TC_Agua.getText();
                String t_agua = txtEdit_Del_TAgua.getText();
                float irca = Float.parseFloat(txtEdit_Del_Irca.getText());
                int id = Integer.parseInt(txtEdit_Del_Id.getText());

                CuerpoDeAgua C_Agua = new CuerpoDeAgua();
                C_Agua.setNombre(nombre);
                C_Agua.setId(id);
                C_Agua.setMunicipio(municipio);
                C_Agua.setTipoCuerpoAgua(tc_agua);
                C_Agua.setTipoDeAgua(t_agua);
                C_Agua.setIrca(irca);
                

                if (ActualizarCuerpoAgua(C_Agua)){
                    JOptionPane.showMessageDialog(null,"El Cuerpo de Agua ha sido actualziado!");
                }
                else {
                    JOptionPane.showMessageDialog(null,"Error actualziando el Cuerpo de Agua" );
                }
                }
        });
    }
    
    private void eventosBtnEdit_DelEliminar() {
        btnEdit_DelEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                int id = Integer.parseInt(txtEdit_Del_Id.getText());
                if (EliminarCuerpoAgua(id)){
                    JOptionPane.showMessageDialog(null,"El Cuerpo de Agua ha sido eliminado");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar el Cuerpo de Agua");
                }
                }
        });
    }
    
    private void eventosBbtnDensidadPoblacionalRegistrar() {
        btnDensidadPoblacionalRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                DensidadPoblacional Poblacion = new DensidadPoblacional();
                Poblacion.setId(Integer.parseInt(txtDensidadPoblacionalId.getText()));
                Poblacion.setNombre(txtDensidadPoblacionalNombre.getText());
                Poblacion.setNum_habitantes(Integer.parseInt(txtDensidadPoblacionalDensidad.getText()));
                
                guardarDensidadPoblacional(Poblacion);//llena la lista con los registros
                JOptionPane.showMessageDialog(null, "Dato Registrado");
                  }
         });
    }
   
    private void eventosBtnDensidadPoblacional_LimpiarCampos() {
        btnDensidadPoblacional_LimpiarCampos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                limpiarCamposDensidadPoblacional();
                }
        });
    }
    private void eventosBtnDensidadPoblacionalProcesar() {
        btnDensidadPoblacionalProcesar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                
                int x;
                int id;
                String name;
                int num_habitantes;
                int datos [] = new int [Poblacion_List.size()];
                
                for (int i = 0 ; i < Poblacion_List.size(); i++) {
                    
                    String data_Table [] = new String [4];
                    x = Poblacion_List.get(i).nivelAfeccion();
                   id = Poblacion_List.get(i).getId();
                    name = Poblacion_List.get(i).getNombre();
                    num_habitantes = Poblacion_List.get(i).getNum_habitantes();
                    datos [i] = x;
                    data_Table [0] = Integer.toString(id);
                    data_Table [1] = name;
                    data_Table [2] = Integer.toString(num_habitantes);
                    data_Table [3] = Integer.toString(x);
                    
                    datosTablaDensidadPoblacional.addRow(data_Table);
                }
                }
        });
    }
     
    //metodos para guardar datos en lista
    
    private void guardarCuerpoAgua (CuerpoDeAgua C_Agua) {
        AguaList.add(C_Agua);
    }
    
     private void guardarDensidadPoblacional (DensidadPoblacional poblacion) {
        Poblacion_List.add(poblacion);
    }
    
    private void limpiarCamposIngresar (){
            txtIngresarNombre.setText("");
            txtIngresarId.setText("");
            txtIngresarMunicipio.setText("");
            txtIngresarTC_agua.setText("");
            txtIngresarTAgua.setText("");
            txtIngresarIrca.setText("");
    }
    
    private void llenarTextAreaProcesar (){
        String datos [] = new String [6];
        
        for (int i = 0; i < AguaList.size(); i++) {
            datos [0] = AguaList.get(i).getNombre();
            datos [1] = Integer.toString(AguaList.get(i).getId());
            datos [2] = AguaList.get(i).getMunicipio();
            datos [3] = AguaList.get(i).getTipoCuerpoAgua();
            datos [4] = AguaList.get(i).getTipoDeAgua();
            datos [5] = Float.toString(AguaList.get(i).getIrca());
            //datosTablaClientes.addRow(datos);
            txtAreaObtenerdatos.append(datos [0]+" "+datos [1]+ " "+datos [2]+" "+datos [3]+" "+datos [4]+" "+datos [5]+"\n");
        }
    }
    
    private void limpiarCamposUpdateDelete (){
            txtEdit_Del_Nombre.setText("");
            txtEdit_Del_Id.setText("");
            txtEdit_Del_Municipio.setText("");
            txtEdit_Del_TC_Agua.setText("");
            txtEdit_Del_TAgua.setText("");
            txtEdit_Del_Irca.setText("");
    }
    private void limpiarCamposDensidadPoblacional (){
            txtDensidadPoblacionalId.setText("");
            txtDensidadPoblacionalNombre.setText("");
            txtDensidadPoblacionalDensidad.setText("");
    }
    
    private boolean ActualizarCuerpoAgua (CuerpoDeAgua C_Agua){
        
        boolean encontrado = false;
        int index = 0;
        for (int i = 0; i < AguaList.size(); i++) {
            if (AguaList.get(i).getId() == C_Agua.getId()){
                encontrado = true;
                index = i;
            }
        }
        AguaList.get(index).setNombre(C_Agua.getNombre());
        AguaList.get(index).setId(C_Agua.getId());
        AguaList.get(index).setMunicipio(C_Agua.getMunicipio());
        AguaList.get(index).setTipoCuerpoAgua(C_Agua.getTipoCuerpoAgua());
        AguaList.get(index).setTipoDeAgua(C_Agua.getTipoDeAgua());
        AguaList.get(index).setIrca(C_Agua.getIrca());
        return encontrado;
    }
    
     private boolean EliminarCuerpoAgua (int id){
        
        boolean encontrado = false;
        for (int i = 0; i < AguaList.size(); i++) {
            if (AguaList.get(i).getId() == id){
                encontrado = true;
                AguaList.remove(i);
            }
        }
        return encontrado;
    }
    
     private void inicializarTabla() {
        //poblacion = new ArrayList<>();
        String[] cabeceraPoblacion = {"Id", "Nombre", "Num. de Habitantes", "Nivel de Afectacion"};
        datosTablaDensidadPoblacional = new DefaultTableModel(cabeceraPoblacion, 0);
        tbl_DensidadPoblacional.setModel(datosTablaDensidadPoblacional);
        
    }
    
}
