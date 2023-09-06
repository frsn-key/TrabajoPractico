package POO.TP01.Fecha;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/*
    Se requiere crear una clase que ayude a realizar operaciones con fechas. Las operaciones requeridas son:

    Devolver una fecha a partir de un string, con un formato específico. Los formatos pueden ser 2:
        dd-MM-yyyy
        MM-dd-yyyy
        Determinar si una fecha se encuentra entre otras dos fechas.
        Determinar si una fecha es mayor a otra fecha.
        Determinar si una fecha es menor a otra fecha.

    Se pueden ayudar del paquete java.time
    Objetivos:
        Definir estructura y comportamiento.
        Crear una clase que la utilice enviando mensajes para probar el correcto funcionamiento.
 */

public class Fecha {
    static public LocalDate fecha(String fecha, String formato ){
        if(((!(formato.equals("dd-MM-yyyy")))&&(!(formato.equals("MM-dd-yyyy"))))){
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        try {
            return LocalDate.parse(fecha, formatter);
        }catch(DateTimeParseException e){
            return null;
        }
    }
    static public Boolean entre(LocalDate fecha,LocalDate fechamin, LocalDate fechamax){
        if((fecha == null)||(fechamin == null)||(fechamax == null)){
            return false;
        }
        return (fechamin.isBefore(fecha)&&fechamax.isAfter(fecha));
    }
    static public Boolean mayor(LocalDate fecha,LocalDate fechamin){
        if((fecha == null)||(fechamin == null)){
            return false;
        }
        return (fechamin.isBefore(fecha));
    }
    static public Boolean menor(LocalDate fecha,LocalDate fechamax){
        if((fecha == null)||(fechamax == null)){
            return false;
        }
        return  (fechamax.isAfter(fecha));
    }


}
