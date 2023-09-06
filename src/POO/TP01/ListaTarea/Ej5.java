package POO.TP01.ListaTarea;

import java.time.LocalDate;

public class Ej5 {
    ListadeTareas lista = new ListadeTareas();

    public void Cargar(){
        for (int i = 5; i > 0; i--) {
            Tarea tarea1 = new Tarea("Sin Recordatorio"+i , Tarea.Prioridad.ALTA, LocalDate.of(2023,9,3+(i*2)));
            Tarea tarea2 = new Tarea("Con Recordatorio"+i , Tarea.Prioridad.BAJA, LocalDate.of(2023,9,3+(i*2)),
                    LocalDate.of(2023,9,(3+i)));
            lista.anadirTarea(tarea1);
            lista.anadirTarea(tarea2);
        }
        System.out.println("----------------------Normal----------------------");
        System.out.println(lista.toString());
        lista.actualizar_vencidas();
        System.out.println("----------------------Actualizar vencidas----------------------");
        System.out.println(lista.toString());
        System.out.println("----------------------Ordenadas por prioridad y fecha----------------------");
        System.out.println(lista.sin_vencer_Ordenadas().toString());
        System.out.println("----------------------Ordenadas por fecha----------------------");
        System.out.println(lista.sin_vencer_Ordenadas(ListadeTareas.Filtro.FECHA).toString());
        System.out.println("----------------------Ordenadas por prioridad----------------------");
        System.out.println(lista.sin_vencer_Ordenadas(ListadeTareas.Filtro.PRIORIDAD).toString());

    }

}
