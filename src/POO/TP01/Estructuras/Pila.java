package POO.TP01.Estructuras;

import POO.TP01.Estructuras.Nodos.Nodo;
import POO.TP01.Estructuras.Nodos.NodoDobleEnlace;

public class Pila {
    private Nodo top = null;

    public int getCantidad() {
        return cantidad;
    }

    private int cantidad = 0;
    private void setTop(Nodo nodo){
        this.top=nodo;
    }
    public Nodo getTop(){
        return this.top;
    }
    public Boolean estaVacia(){
        return this.top == null;
    }
    public void apilar(Object Dato){
        Nodo nodo = new Nodo();
        nodo.setDato(Dato);
        if (this.estaVacia()){
            this.setTop(nodo);
            this.cantidad++;
            return;
        }
        nodo.setSiguiente(this.top);
        this.setTop(nodo);
        this.cantidad++;
        return;
    }
    public Object desapilar(){
        Nodo tope = this.top;
        this.setTop(tope.getSiguiente());
        this.cantidad--;
        return tope.getDato();
    }
    public Object recuperar(){return this.top.getDato();}

    public String toString() {
        String result = "{Pila: ";
        Nodo iterator = this.getTop();
        while(iterator!=null){
            result = result.concat(iterator.getDato().toString()+",");
            iterator = iterator.getSiguiente();
        }
        return result+"}\n";
    }


}
