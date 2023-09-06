package POO.TP01.Estructuras;
/*
    Implementar un equivalente orientado a objetos de la Lista enlazada simple.
    En particular, es necesario que la lista implemente la siguiente interfaz:
        Crear lista.
        Consultar si la lista está vacía.
        Consultar la longitud de la lista.
        Agregar elemento al final de la lista.
        Eliminar elemento de la lista.
        Recuperar elemento de la lista.
        Insertar elemento en la lista en una posición específica.
    ¿Cuántos objetos están involucrados? Pensar bien los tipos de retorno de cada método.?

*/

import POO.TP01.Estructuras.Nodos.Nodo;
import POO.TP01.Estructuras.Nodos.NodoDobleEnlace;

public class ListaEnlazada {

    private Nodo primero = null;
    private Nodo ultimo = null;
    private void setPrimero(Nodo nodo){
        this.primero=nodo;
        return;
    }
    private void setUltimo(Nodo nodo){
        this.ultimo = nodo;
        return;
    }
    public Nodo getPrimero() {
        return primero;
    }
    public Nodo getUltimo() {
        return ultimo;
    }
    public Boolean estaVacia(){
        return this.primero==null;
    }
    public void agregarUltimo(Object Dato){
        Nodo nodo = new Nodo();
        nodo.setDato(Dato);
        if(this.primero==null) {
            this.setPrimero(nodo);
            this.setUltimo(nodo);
            return ;
        };
        this.getUltimo().setSiguiente(nodo);
        this.setUltimo(nodo);
        return ;
    }
    public void agregar(Object Dato){
        Nodo nodo = new Nodo();
        nodo.setDato(Dato);
        if(this.primero==null) {
            this.setPrimero(nodo);
            this.setUltimo(nodo);
            return ;
        };
        Nodo iterator = this.getPrimero();
        while(iterator.getSiguiente()!=null){
           iterator = iterator.getSiguiente();
        }
        iterator.setSiguiente(nodo);
        this.setUltimo(nodo);
        return;

    }
    public Object  recuperar(int pos){
        if (this.estaVacia()){return null;}
        int index =  1;
        Nodo iterator = this.getPrimero();
        while((iterator.getSiguiente()!=null)&&(index <= pos)){
            iterator = iterator.getSiguiente();
            if(index == pos){return iterator.getDato();}
            index++;
        }
        return null;
    }
    public Boolean insertar(int pos,Object Dato){
        if (this.estaVacia()){return false;}
        Nodo nodo = new Nodo();
        nodo.setDato(Dato);
        Nodo iterator = this.getPrimero();
        if (pos == 1){
            nodo.setSiguiente(iterator);
            this.setPrimero(nodo);
            return true;
        }
        int index =  1;
        Nodo Anterior = iterator;
        while((iterator.getSiguiente()!=null)&&(index < pos)){
            iterator = iterator.getSiguiente();
            index++;
        }
        if(index != pos){return false;}
        nodo.setSiguiente(iterator);
        Anterior.setSiguiente(nodo);
        return true;
    }
    public Boolean Eliminar(int pos){
        if (this.estaVacia()){return false;}
        Nodo iterator = this.getPrimero();
        if (pos == 1){
            this.setPrimero(this.primero.getSiguiente());
            return true;
        }
        int index =  1;
        Nodo Anterior = iterator;
        while((iterator.getSiguiente()!=null)&&(index >= pos)){
            if(index == pos){
                Anterior.setSiguiente(iterator.getSiguiente());
                if (iterator==this.ultimo){
                    this.setUltimo(iterator.getSiguiente());
                }
                return true;
            }
            iterator = iterator.getSiguiente();
            index++;
        }
        return false;
    }
    public int Cantidad(){
        if (this.estaVacia()){return 0;}
        int cant =  1;
        Nodo iterator = this.getPrimero();
        while(iterator.getSiguiente()!=null){
            iterator = iterator.getSiguiente();
            cant++;
        }
        return cant;
    }

    public String toString() {
        String result = "{Lista: ";
        Nodo iterator = this.getPrimero();
        while(iterator.getSiguiente()!=null){
            result = result.concat(iterator.getDato().toString()+",");
            iterator = iterator.getSiguiente();
        }
        return result+"}\n";
    }
}
