import POO.TP01.Contrasenas.Ej8;
import POO.TP01.Admin.Biblioteca.Ej6;
import POO.TP01.Fecha.Ej9;
import POO.TP01.ListaTarea.Ej5;
import POO.TP01.Estructuras.Ej1234;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------------------Punto 1-2-3-4:---------------------------------\n\n");
        Ej1234 ej1234 = new Ej1234();
        ej1234.punto1();
        System.out.println("-----------------------------Punto 5:---------------------------------\n\n");
        Ej5 ej5 = new Ej5();
        ej5.Cargar();
        System.out.println("-----------------------------Punto 6:---------------------------------\n");
        Ej6 ej6 = new Ej6();
        ej6.punto6();
        System.out.println("-----------------------------Punto 8:---------------------------------\n");
        Ej8 ej8 = new Ej8();
        ej8.punto8();
        System.out.println("-----------------------------Punto 9:---------------------------------\n");
        Ej9 ej9 = new Ej9();
        ej9.Comparar();



    }

}