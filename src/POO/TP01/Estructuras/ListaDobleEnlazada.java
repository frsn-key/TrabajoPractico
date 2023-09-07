package POO.TP01.Estructuras;

import POO.TP01.Estructuras.Nodos.NodoDobleEnlace;

/*
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
public class ListaDobleEnlazada {
    private NodoDobleEnlace primero = null;
    private void setPrimero(NodoDobleEnlace primero) {
        this.primero = primero;
    }
    private NodoDobleEnlace getPrimero() {
        return this.primero;
    }
    public Boolean estaVacia(){
        return this.primero==null;
    }
    public int cantidad(){
        if (this.estaVacia()){return 0;}
        int cant =  1;
        NodoDobleEnlace iterator = this.getPrimero();
        while(iterator.getSiguiente()!=null){
            iterator = iterator.getSiguiente();
            cant++;
        }
        return cant;
    }
    public void agregar(Object Dato){
        NodoDobleEnlace nodo = new NodoDobleEnlace();
        nodo.setDato(Dato);
        if(this.primero==null) {
            this.setPrimero(nodo);
            return ;
        };
        NodoDobleEnlace iterator = this.getPrimero();
        while(iterator.getSiguiente()!=null){
            iterator = iterator.getSiguiente();
        }
        nodo.setAnterior(iterator);
        iterator.setSiguiente(nodo);
        return;
    }
    public Object  recuperar(int pos){
        if (this.estaVacia()){return null;}
        int index =  1;
        NodoDobleEnlace iterator = this.getPrimero();
        while((iterator.getSiguiente()!=null)||(index < pos)){
            iterator = iterator.getSiguiente();
            index++;
        }
        if(index == pos){return iterator.getDato();}
        return null;
    }
    public Boolean insertar(int pos, Object Dato) {
        NodoDobleEnlace nodo = new NodoDobleEnlace();
        nodo.setDato(Dato);
        NodoDobleEnlace iterator = this.getPrimero();
        if (pos == 1 || iterator == null) {
            nodo.setSiguiente(iterator);
            if (iterator != null) {
                iterator.setAnterior(nodo);
            }
            this.setPrimero(nodo);
            return true;
        }

        int index = 1;
        while (iterator.getSiguiente() != null && index < pos) {
            iterator = iterator.getSiguiente();
            index++;
        }

        if (index != pos) {
            return false; // La posición no existe en la lista
        }

        nodo.setAnterior(iterator.getAnterior());
        nodo.setSiguiente(iterator);
        iterator.setAnterior(nodo);

        return true;
    }
    public Boolean Eliminar(int pos) {
        NodoDobleEnlace iterator = this.getPrimero();

        if (iterator == null) {
            return false; // La lista está vacía
        }

        if (pos == 1) {
            this.setPrimero(iterator.getSiguiente());
            if (iterator.getSiguiente() != null) {
                iterator.getSiguiente().setAnterior(null);
            }
            return true;
        }

        int index = 1;
        while (iterator.getSiguiente() != null && index < pos) {
            iterator = iterator.getSiguiente();
            index++;
        }

        if (index != pos) {
            return false; // La posición no existe en la lista
        }

        iterator.getAnterior().setSiguiente(iterator.getSiguiente());

        if (iterator.getSiguiente() != null) {
            iterator.getSiguiente().setAnterior(iterator.getAnterior());
        }

        return true;
    }

    @Override
    public String toString() {
        String result = "{ListaDobleEnlace: ";
        NodoDobleEnlace iterator = this.getPrimero();
        while(iterator!=null){
            result = result.concat(iterator.getDato().toString()+",");
            iterator = iterator.getSiguiente();
        }
        return result+"}\n";
    }
}
