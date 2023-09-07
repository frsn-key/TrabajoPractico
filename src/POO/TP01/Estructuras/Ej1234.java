package POO.TP01.Estructuras;

public class Ej1234 {

    private ListaEnlazada listaemlazada = new ListaEnlazada();
    private ListaDobleEnlazada listaedobleenlazada = new ListaDobleEnlazada();
    private Pila pila = new Pila();
    private Cola cola = new Cola();

    public void Cargar(){
        for (int i = 1; i < 11; i++) {
            Integer element = i;
            pila.apilar(element);
            listaemlazada.agregar(element);
            listaedobleenlazada.agregar(element);
            cola.encolar(element);
        }
        System.out.println(listaedobleenlazada.toString());
        System.out.println("-------------------------------------");
        System.out.println(listaemlazada.toString());
        System.out.println("-------------------------------------");
        System.out.println(pila.toString());
        System.out.println("-------------------------------------");
        System.out.println(cola.toString());
    }

    public void Cantidad(){
        System.out.println("\nCantidad Lista:"+this.listaemlazada.Cantidad());
        System.out.println("\nCantidad Doble Enlace"+this.listaedobleenlazada.cantidad());
        System.out.println("\nCantidad Pila"+this.pila.getCantidad());
        System.out.println("\nCantidad Cola"+this.cola.getCantidad());
    }

    public void insertar_Eliminar(){
        System.out.println(listaedobleenlazada.toString());
        System.out.println("-------------------------------------");
        System.out.println(listaemlazada.toString());

        System.out.println("----------------Insertar en pos 5--------------");
        listaedobleenlazada.insertar(5,123);
        listaemlazada.insertar(5,123);
        System.out.println(listaedobleenlazada.toString());
        System.out.println("-------------------------------------");
        System.out.println(listaemlazada.toString());
        System.out.println("\nCantidad Lista:"+this.listaemlazada.Cantidad());
        System.out.println("\nCantidad Doble Enlace"+this.listaedobleenlazada.cantidad());

        System.out.println("----------------Eliminar en pos 6--------------");
        listaedobleenlazada.Eliminar(6);
        listaemlazada.Eliminar(6);
        System.out.println(listaedobleenlazada.toString());
        System.out.println("-------------------------------------");
        System.out.println(listaemlazada.toString());

        System.out.println("----------------Eliminar en pos 1--------------");
        listaedobleenlazada.Eliminar(1);
        listaemlazada.Eliminar(1);
        System.out.println(listaedobleenlazada.toString());
        System.out.println("-------------------------------------");
        System.out.println(listaemlazada.toString());

        System.out.println("----------------Eliminar en pos 6--------------");
        listaedobleenlazada.Eliminar(8);
        listaemlazada.Eliminar(8);
        System.out.println(listaedobleenlazada.toString());
        System.out.println("-------------------------------------");
        System.out.println(listaemlazada.toString());
    }

    public void punto1(){
        this.Cargar();
        this.Cantidad();
        this.insertar_Eliminar();
        this.Cantidad();
    }


}
