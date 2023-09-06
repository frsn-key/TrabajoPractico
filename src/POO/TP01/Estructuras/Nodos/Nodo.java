package POO.TP01.Estructuras.Nodos;

public class Nodo {
    private Object dato;
    private Nodo siguiente = null;
    public void setDato(Object dato){
        this.dato = dato;
        return;
    }
    public Object getDato() {
        return this.dato;
    }
    public void setSiguiente(Nodo nodo){
        this.siguiente = nodo;
        return;
    }
    public Nodo getSiguiente() {
        return this.siguiente;
    }
}
