package POO.TP01.ListaTarea;

public class Colaborador {
    private String Nombre;
    private Integer ID;
    private ListadeTareas Realizadas;
    public void anadirTareaRealizada(Tarea tarea){
        if (tarea.getEstado() == Tarea.Estado.COMPLETA){
            this.Realizadas.anadirTarea(tarea);
        }
        return;
    }

}
