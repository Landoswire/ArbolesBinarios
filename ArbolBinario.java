/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

/**
 *
 * @author Issei        

 */
public class ArbolBinario {
    NodoArbol raiz;
    
    public ArbolBinario(){//Inicializa la raiz en null
        raiz = null;
    }
    //Metodo para insertar un nodo en el arbol
    public void agregarNodo(int d, String nom){
        NodoArbol nuevo = new NodoArbol(d, nom);
        if(raiz==null){
            raiz=nuevo;    
        }else{
            NodoArbol auxiliar=raiz;//apunta la raiz
            NodoArbol padre;
            while(true){
                padre=auxiliar;//el padre tambien apuntara a la raiz
                if(d<auxiliar.dato){//si el dato que me dan es menor a auxiliar.dato entonces ira a la izquierda
                    auxiliar=auxiliar.hijoIzquierdo;
                    if(auxiliar==null){ //aqui es donde debe insertarse
                        padre.hijoIzquierdo=nuevo;
                        return;//salios del metodo
                    }
                    
                }else{ //en caso contrario es mayor e ira a la derecha
                    auxiliar=auxiliar.hijoDerecho;
                    if(auxiliar==null){
                        padre.hijoDerecho=nuevo;
                        return; //como ya enconro su lugar retornamos
                    }
                }
            }
        }
    }
    //Metodo para saber si el arbol esta vacio
    public boolean estaVacio(){
        return raiz==null;
    }
    //Metodo para recorrer el arbol InOrden
    public void inOrden(NodoArbol r){
        if(r!=null){//si raiz es diferente de null recorre en inOrden
            inOrden(r.hijoIzquierdo);//a partir de la raiz hijo izquierdo
            System.out.print(r.dato + ", ");//nos muestra el dato que tiene la raiz
            inOrden(r.hijoDerecho);//por ultimo el hijo derecho
            
        }
    }
    //Metodo para recorrer el arbol PreOrden
    public void preOrden(NodoArbol r){
        if(r!=null){//si el arbol no esta vacio
            System.out.print(r.dato + ", ");//primero mostramos la raiz
            preOrden(r.hijoIzquierdo);//mostramos el hijo izquierdo
            preOrden(r.hijoDerecho);//por ultimo el derecho
        }
    }
    //Metodo para recorrer el arbol PostOrden
    public void postOrden(NodoArbol r){
        if(r!=null){
           postOrden(r.hijoIzquierdo);//mostramos primero el hijo izquierdo
           postOrden(r.hijoDerecho);//despues el derecho
           System.out.print(r.dato + ", ");//al ultimo mostramos la raiz
        }
    }
    
    
    //Metodo para buscar un nodo en el Arbol
    public NodoArbol buscarNodo(int d){
        NodoArbol aux = raiz;//crear un nodo auxiliar de tipo nodoarbol y lo apuntamos a raiz
        while(aux.dato!=d){//mientras auxiliar de dato es diferente al dato que buscamos
            if(d<aux.dato){//si es menor a auxiliar de dato
                aux=aux.hijoIzquierdo;//apuntamos a auxiliar de hijoizquierdo
            }else{//si es mayor
                aux=aux.hijoDerecho;//apuntamos a auxiliar de hijoderecho
            }
            if(aux==null){//si llego al final y no lo encontro
                return null;//entocnes nos retorna un nulo que sgnifica que no lo encontro
            }
        }
        return aux;//si retornamos a aux quiere decir que si lo encontramos
    }
    //Metodo para eliminar un nodo del Arbol
    public boolean eliminar(int d){
        NodoArbol auxiliar = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzq = true;//cuando sea hijoIzq va inicializar en True, y en caso contrario(false) sera hijoDer
        while(auxiliar.dato!=d){//cuando sea diferente de d quiere decir que aun no lo encuentra
            padre=auxiliar;
            if(d<auxiliar.dato){//cuando d sea menor a aux.dato
                esHijoIzq=true;//se va a la izquiera
                auxiliar=auxiliar.hijoIzquierdo;//apuntamos para ir recorriendo hacia la izqauerda
            }else{//en caso contrario buscamos por la derecha
                esHijoIzq=false;
                auxiliar=auxiliar.hijoDerecho;
            }
            if(auxiliar==null){//si aux llega a null quiere decir que no encontro el nodo
                return false;//entonces retornamos un false
            }
        }//Fin del while
        if(auxiliar.hijoIzquierdo==null && auxiliar.hijoDerecho==null){//cuando ambos hijos apuntan a nulo quiere decir que es hoja
            if(auxiliar==raiz){
                raiz=null;
            }else if(esHijoIzq){
                padre.hijoIzquierdo=null;//padre de hijoizq lo vamos a apuntar a nulo
            }else{
                padre.hijoDerecho=null;//en otro caso padre hijoder lo apuntamos a null
            }
        }else if(auxiliar.hijoDerecho==null){
            if(auxiliar==raiz){//si auxiliar es igual a raiz
                raiz=auxiliar.hijoIzquierdo;//aux lo vamos a apuntar a hijoizq
            }else if(esHijoIzq){
                padre.hijoIzquierdo=auxiliar.hijoIzquierdo;//padre de hijoizq lo vamos a apuntar a hijoizq
            }else{
                padre.hijoDerecho=auxiliar.hijoIzquierdo;//
            }
        }else if(auxiliar.hijoIzquierdo==null){//reacomodamos los punteros
            if(auxiliar==raiz){//si auxiliar es igual a raiz
                raiz=auxiliar.hijoDerecho;//raiz = aux de hijo derecho
            }else if(esHijoIzq){
                padre.hijoIzquierdo=auxiliar.hijoDerecho;
            }else{
                padre.hijoDerecho=auxiliar.hijoIzquierdo;//
            }
        }else{//si no entra ninguno
            NodoArbol reemplazo = obtenerNodoReemplazo(auxiliar);//este metodo nos va retornar el nodo que va a reemplazar al nodo que queremos eliminar
            if(auxiliar==raiz){
                raiz=reemplazo;
            }else if(esHijoIzq){//si es hijo izq
                padre.hijoIzquierdo=reemplazo;
            }else{//si no
                padre.hijoDerecho=reemplazo;
            }
            reemplazo.hijoIzquierdo=auxiliar.hijoIzquierdo;
        }
        return true;//si llega hasta esta parte quiere decir que si encontro a nuestro nodo a eliminar
    }
    
    //Metodo para devolvernos el nodo reemplazo
    public NodoArbol obtenerNodoReemplazo(NodoArbol nodoReemp){
        NodoArbol reemplazarPadre = nodoReemp;
        NodoArbol reemplazo = nodoReemp;
        NodoArbol auxiliar = nodoReemp.hijoDerecho;
        
        while(auxiliar!=null){//vamos a recorrer para encontrar el nodo candidato a reemplaxar
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar=auxiliar.hijoIzquierdo;
        }
        if(reemplazo!=nodoReemp.hijoDerecho){
            reemplazarPadre.hijoIzquierdo=reemplazo.hijoDerecho;//para reacomodar los enlaces
            reemplazo.hijoDerecho=nodoReemp.hijoDerecho;
        }
        System.out.println("El nodo reemplazo es " + reemplazo);
        return reemplazo;
    }
}
