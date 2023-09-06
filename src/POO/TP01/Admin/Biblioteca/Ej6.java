package POO.TP01.Admin.Biblioteca;

import java.util.Scanner;

public class Ej6 {
    private Biblioteca biblioteca = new Biblioteca();
    Scanner scanner = new Scanner(System.in);

    private Libro crear_Libro(){
        System.out.println("Ingrese el Nombre del Libro:");
        String nombre  = scanner.nextLine();
        System.out.println("Ingrese el Nombre del Autor:");
        String autor  = scanner.nextLine();
        System.out.println("Ingrese el ISBN: (ingrese 0 si no lo conoce)");
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Dato incorrecto:");
        }
        int isbn  = scanner.nextInt();
        System.out.println("Ingrese la cantidad de paginas:");
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Dato incorrecto:");
        }
        int cant_pagi  = scanner.nextInt();
        System.out.println("Ingrese la cantidad de ejemplares:");
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Dato incorrecto:");
        }
        int cant_ejem  = scanner.nextInt();
        return new Libro(autor,nombre,isbn,cant_pagi,cant_ejem);
    }

    private void Agregar_Libro(){
        if (!this.biblioteca.Agregar_Libro(this.crear_Libro())){
            System.out.println("Libro existente en la biblioteca. Se agrego un ejemplar.");
        }else{
            System.out.println("Libro agregado con exito.");
        }
    }

    public void Agregar_Libros(){
        System.out.println("Ingrese la cantidad de Libros a ingresar");
        while(!scanner.hasNextInt()){
            scanner.next();
            System.out.println("Dato incorrecto:");
        }
        int cant = scanner.nextInt();
        for (int i = 0; i < cant ; i++) {
            this.Agregar_Libro();
        }
    }

    public void Prestar(){
        System.out.println("Prestar un libro con 10 Ejemplares: ");
        this.biblioteca.Agregar_Libro(new Libro("Libro ","Con 10 Ejemplares",1234567,120,10));
        this.biblioteca.Agregar_Libro(new Libro("Libro ","Con 1 Ejemplar",1234567,120,1));
        System.out.println("Busqueda por nombre 'Libro' :");
        Biblioteca resulta = this.biblioteca.Buscar_parecidos(Biblioteca.Busqueda.NOMBRE,"Libro");
        System.out.println(resulta.toString());
        System.out.println("\n-------------------------------------\n");
        Libro libro = resulta.recuperar_Libro(1);
        System.out.println("Prestar un libro con 10 Ejemplar: \n");
        if(resulta.Prestar(libro)){
            System.out.println("Libro Prestado");
        }else{
            System.out.println("Libro no prestado");
        }
        System.out.println(libro.toString()+"\n");
        System.out.println("\n-------------------------------------\n");
        System.out.println("Prestar un libro con 1 Ejemplar: \n");
        libro = resulta.recuperar_Libro(2);
        if(resulta.Prestar(libro)){
            System.out.println("Libro Prestado");
        }else{
            System.out.println("Libro no prestado");
        }
        System.out.println(libro.toString()+"\n");


    }


    public void Catidad_Prestamos(){
        System.out.println("Cantidad de prestamos realizados : "+this.biblioteca.Cantidad_de_Prestamos_Actuales());
    }

    public void punto6(){
        this.Prestar();
        this.Catidad_Prestamos();
    }

}
