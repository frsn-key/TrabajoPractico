package POO.TP01.Fecha;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Ej9 {
    Scanner scanner = new Scanner(System.in);
    public void fecha (){
        System.out.println("Ingrese el Formato de la fecha <<dd-MM-yyyy>||<MM-dd-yyyy>> :");
        String formato  = scanner.nextLine();
        System.out.println("Ingrese la fecha:");
        String fecha  = scanner.nextLine();
        LocalDate fecha_ = Fecha.fecha(fecha,formato);
        if(fecha_ == null){
            System.out.println("Fecha o formato erroneo.");
        }else{
            System.out.println("Fecha: "+fecha_+"\n");
        }

    }

    public void Comparar(){
        Integer i = 1;
        System.out.println("Ingrese el Formato de la fecha"+i+"<<dd-MM-yyyy>||<MM-dd-yyyy>> :");
        String formato  = scanner.nextLine();
        System.out.println("Ingrese la fecha:");
        String fecha  = scanner.nextLine();
        LocalDate fecha1 = Fecha.fecha(fecha,formato);
        if(fecha1 == null){
            System.out.println("Fecha o formato erroneo.");
        }else{
            System.out.println("Fecha: "+fecha1+"\n");
        }

        i++;
        System.out.println("Ingrese el Formato de la fecha"+i+"<<dd-MM-yyyy>||<MM-dd-yyyy>> :");
        formato  = scanner.nextLine();
        System.out.println("Ingrese la fecha:");
        fecha  = scanner.nextLine();
        LocalDate fecha2 = Fecha.fecha(fecha,formato);
        if(fecha2 == null){
            System.out.println("Fecha o formato erroneo.");
        }else{
            System.out.println("Fecha: "+fecha2+"\n");
        }

        i++;
        System.out.println("Ingrese el Formato de la fecha"+i+"<<dd-MM-yyyy>||<MM-dd-yyyy>> :");
        formato  = scanner.nextLine();
        System.out.println("Ingrese la fecha:");
        fecha  = scanner.nextLine();
        LocalDate fecha3 = Fecha.fecha(fecha,formato);
        if(fecha3 == null){
            System.out.println("Fecha o formato erroneo.");
        }else{
            System.out.println("Fecha: "+fecha3+"\n");
        }

        if(Fecha.entre(fecha1,fecha2,fecha3)){
            System.out.println("Fecha:"+fecha1+ " esta entre "+ fecha2 + " y "+fecha3);
        }

        if(Fecha.mayor(fecha1,fecha2)){
            System.out.println("Fecha: "+fecha1+ " es mayor que "+ fecha2);
        }

        if(Fecha.menor(fecha1,fecha3)){
            System.out.println("Fecha: "+fecha1+ " es menor que "+ fecha3);
        }

    }



}
