/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import javax.swing.JOptionPane;

/**
 *
 * @author Issei
 */
/* Instrucciones
    Al ejecutarse el menu debe elegir la opcion 1 e inserte nodos uno por uno asignandoles tambien un nombre
    Despues de insertar sus nodos podra elegir las demas opciones dependiendo de lo que quiera hacer
    Y listo
*/

public class Main {

    public static void main(String[] args){
        
        int opcion=0, elemento;
        String nombre;
        ArbolBinario arbolito = new ArbolBinario();
        do{
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,     //en este caso se hizo un menu
                        "1. Agregar un nodo\n"
                        + "2. Recorrer el Arbol InOrden\n"
                        + "3. Recorrer el Arbol PreOrden\n"
                        + "4. Recorrer el Arbol PostOrden\n"
                        + "5. Buscar un nodo en el Arbol\n"
                        + "6. Eliminar un nodo del Arbol\n"
                        + "7. Salir\n"
                        + "Elige una opcion","Arboles Binarios",JOptionPane.QUESTION_MESSAGE));
                switch(opcion){
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el numero del nodo","Agregando nodo",JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null,
                                "Ingresa el nombre del nodo","Agregando nodo",JOptionPane.QUESTION_MESSAGE);
                        arbolito.agregarNodo(elemento, nombre);
                        break;
                    case 2:
                        if(!arbolito.estaVacio()){ //si no esta vacio recorremos
                            System.out.println();
                            arbolito.inOrden(arbolito.raiz); //recibe la raiz
                        }else{ //si esta vacio
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio","Inserta nodos primero",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        if(!arbolito.estaVacio()){//si el arbol no esta vacio hacemos el recorrido
                            System.out.println();
                            arbolito.preOrden(arbolito.raiz);//enviamos de parametro la raiz
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio","Inserta nodos primero",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        if(!arbolito.estaVacio()){//si el arbol no esta vacio hacemos el recorrido
                            System.out.println();
                            arbolito.postOrden(arbolito.raiz);//enviamos de parametro la raiz
                        }else{
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio","Inserta nodos primero",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 5:
                        if(!arbolito.estaVacio()){//si el arbol no esta vacio
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el numero del nodo a buscar", "Buscando nodo",JOptionPane.QUESTION_MESSAGE));
                            
                            if(arbolito.buscarNodo(elemento)==null){//si es igual a null quiere decir que no lo encontro
                                JOptionPane.showMessageDialog(null, "El nodo no se encuentra en el Arbol","Nodo no encontrado",JOptionPane.INFORMATION_MESSAGE);
                            }else{//en caso contrario significa que si lo encontro
                                System.out.println("Nodo encontrado, el resultado es:" + arbolito.buscarNodo(elemento));
                            }
                            
                        }else{//si esta vacio entonces
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio","Inserta nodos primero",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6:
                        if(!arbolito.estaVacio()){//si el arbol no esta vacio hay algo que eliminar
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el numero del nodo a eliminar", "Eliminando nodo",JOptionPane.QUESTION_MESSAGE));
                            
                            if(arbolito.eliminar(elemento)==false){//si esto es igual a false quiere decir que no encontro al nodo
                                JOptionPane.showMessageDialog(null, "El nodo no se encuentra en el Arbol","Nodo no encontrado",JOptionPane.INFORMATION_MESSAGE);
                            }else{//en caso contrario 
                                JOptionPane.showMessageDialog(null, "El nodo ha sido eliminado del Arbol","Nodo eliminado",JOptionPane.INFORMATION_MESSAGE);
                            }
                            
                        }else{//si esta vacio entonces
                            JOptionPane.showMessageDialog(null, "El arbol esta vacio","Inserta nodos primero",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "Ejecucion Finalizada","Fin",JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion incorecta","Intentalo de nuevo",JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(NumberFormatException n){//en caso de error
                JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
            }
        }while(opcion!=7);
    }
    
}
//Para hacer el arbol me ayude de Youtube
