package POO.TP01.Estructuras;

import POO.TP01.Estructuras.Nodos.Nodo;

public class Cola {
    private Nodo comienzo = null;
    private int cantidad = 0;
    public Nodo getComienzo() {
        return this.comienzo;
    }
    private void setComienzo(Nodo comienzo) {
        this.comienzo = comienzo;
    }
    public Boolean estaVacia(){
        return this.comienzo == null;
    }
    public void encolar(Object Dato){
        Nodo nodo = new Nodo();
        nodo.setDato(Dato);
        if (this.estaVacia()){
            this.setComienzo(nodo);
            this.cantidad++;
            return;
        }
        Nodo iterator = this.comienzo;
        while (iterator.getSiguiente()!=null){
            iterator=iterator.getSiguiente();
        }
        iterator.setSiguiente(nodo);
        this.cantidad++;
        return;
    }
    public Object Desencolar(){
        Nodo comienzo = this.comienzo;
        this.setComienzo(comienzo.getSiguiente());
        this.cantidad--;
        return comienzo.getDato();
    }
    public Object recuperar(){return this.comienzo.getDato();}

    public String toString() {
        String result = "{Cola: ";
        Nodo iterator = this.getComienzo();
        while(iterator.getSiguiente()!=null){
            result = result.concat(iterator.getDato().toString()+",");
            iterator = iterator.getSiguiente();
        }
        return result+"}\n";
    }

    public int getCantidad() {
        return cantidad;
    }
}
