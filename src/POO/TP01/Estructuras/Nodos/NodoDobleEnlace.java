package POO.TP01.Estructuras.Nodos;

public class NodoDobleEnlace  {
    private NodoDobleEnlace anterior = null;
    private NodoDobleEnlace siguiente = null;
    private Object dato;
    public void setDato(Object dato){
        this.dato = dato;
        return;
    }
    public Object getDato() {
        return this.dato;
    }
    public void setAnterior(NodoDobleEnlace nodoAnterior) {
        this.anterior = nodoAnterior;
    }
    public void setSiguiente(NodoDobleEnlace nodoSiguiente) {
        this.siguiente = nodoSiguiente;
    }
    public NodoDobleEnlace getAnterior() {
        return this.anterior;
    }
    public NodoDobleEnlace getSiguiente(){
        return this.siguiente;
    }
}
