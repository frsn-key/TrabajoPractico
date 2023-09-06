package POO.TP01.ListaTarea;
import POO.TP01.Estructuras.Cola;

import java.util.ArrayList;
public class ListadeTareas {
    private ArrayList<Tarea> Tareas;
    private int cantidadTareas = 0;
    public enum Filtro {PRIORIDAD,FECHA,VENCIDAS,COMPLETAS}
    private ArrayList<Colaborador> Colaboradores;


    public ListadeTareas() {
        this.Tareas = new ArrayList<Tarea>();
        this.Colaboradores = new ArrayList<Colaborador>();
    }

    public void anadirTarea(Tarea tarea){
        this.Tareas.add(tarea);
    }

    public void anadirColaborador(Colaborador colaborador){
        this.Colaboradores.add(colaborador);
    }

    public void actualizar_vencidas(){
        Boolean aBoolean;
        for (Tarea tarea : this.Tareas) {
             aBoolean = tarea.meVenci();
        }
    }

    public int getCantidadTareas() {
        return cantidadTareas;
    }

    private void setCantidadTareas(int cantidadTareas) {
        this.cantidadTareas = cantidadTareas;
    }

    private ListadeTareas Filtrar(Tarea.Estado estado){
            ListadeTareas filtradas = new ListadeTareas();
        for (Tarea tarea: this.Tareas) {
            if (tarea.getEstado()== estado){
                filtradas.anadirTarea(tarea);
            }
        }
        return filtradas;
    }

    private ListadeTareas Filtrar(Tarea.Prioridad prioridad){
        ListadeTareas filtradas = new ListadeTareas();
        for (Tarea tarea: this.Tareas) {
            if (tarea.getPrioridad() == prioridad){
                filtradas.anadirTarea(tarea);
            }
        }
        return filtradas;
    }

    public String toString(){
        String result ="";
        int i = 0;
        for (Tarea tarea:this.Tareas) {
            i++;
            result=result.concat("Tarea N^"+i+" :\t"+tarea.toString()+"\n");
        }
        return result;
    }

    private ListadeTareas Unir_Lista(ListadeTareas lista){
        ListadeTareas Union =  new ListadeTareas();
        for (Tarea tarea: this.Tareas) {
            Union.anadirTarea(tarea);
        }
        for (Tarea tarea: lista.Tareas) {
            Union.anadirTarea(tarea);
        }
        return Union;
    }

    private void Oredenar(Filtro filtro){
        int n = this.Tareas.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Tarea tarea1 = this.Tareas.get(j);
                Tarea tarea2 = this.Tareas.get(j + 1);
                switch (filtro) {
                    case PRIORIDAD -> {
                        if (tarea1.getPrioridad().ordinal() > tarea2.getPrioridad().ordinal()) {
                            this.Tareas.set(j, tarea2);
                            this.Tareas.set(j + 1, tarea1);
                        }
                    }
                    case FECHA -> {
                        if (tarea1.getFechaLimite().isAfter(tarea2.getFechaLimite())) {
                            this.Tareas.set(j, tarea2);
                            this.Tareas.set(j + 1, tarea1);
                        }
                    }
                    default -> {

                    }
                }
            }
        }
    }



    public void Realizada(Tarea tarea){
        tarea.Realizada();
    }

    public void Realizada(Tarea tarea,Colaborador colaborador){
        tarea.Realizada();
        colaborador.anadirTareaRealizada(tarea);
    }

    public ListadeTareas Buscar(String descripcion){
        ListadeTareas result = new ListadeTareas();
        for (Tarea tarea:this.Tareas) {
            if (tarea.getDescripcion().toLowerCase().contains(descripcion.toLowerCase())){
                result.anadirTarea(tarea);
            }
        }
        return result;
    }

    public Tarea RecuperarTarea(int index){
        if(index>this.Tareas.size()){
            return null;
        }
        return this.Tareas.get(index-1);
    }

    public ListadeTareas sin_vencer_Ordenadas(Filtro filtro){
        ListadeTareas result =  null;
        if (filtro==Filtro.PRIORIDAD) {
            result = this.Filtrar(Tarea.Estado.INCOMPLETA).Unir_Lista(this.Filtrar(Tarea.Estado.POR_VENCER));
            result.Oredenar(Filtro.PRIORIDAD);
            return result;
        }

        if (filtro==Filtro.FECHA) {
            result = this.Filtrar(Tarea.Estado.INCOMPLETA).Unir_Lista(this.Filtrar(Tarea.Estado.POR_VENCER));
            result.Oredenar(Filtro.FECHA);
            return result;
        }
        return null;
    }

    public ListadeTareas sin_vencer_Ordenadas(){
        ListadeTareas result = this.Filtrar(Tarea.Estado.INCOMPLETA).Unir_Lista(this.Filtrar(Tarea.Estado.POR_VENCER));
        ListadeTareas alta = result.Filtrar(Tarea.Prioridad.ALTA);
        ListadeTareas baja = result.Filtrar(Tarea.Prioridad.BAJA);
        alta.Oredenar(Filtro.FECHA);
        baja.Oredenar(Filtro.FECHA);
        return alta.Unir_Lista(baja);
    }

}
