import POO.TP01.Contrasenas.Ej8;
import POO.TP01.Admin.Biblioteca.Ej6;
import POO.TP01.Fecha.Ej9;
public class Main {
    public static void main(String[] args) {
        Ej8 ej8 = new Ej8();
        ej8.generarContrasenas();
        System.out.println("------------------------------------------------------------------");
        ej8.generarContrasenasFuertes();
        System.out.println("\n------------------------------------------------------------------\n");
        Ej6 ej6 = new Ej6();
        ej6.Prestar();
        ej6.Catidad_Prestamos();
        Ej9 ej9 = new Ej9();
        ej9.Comparar();


    }

}