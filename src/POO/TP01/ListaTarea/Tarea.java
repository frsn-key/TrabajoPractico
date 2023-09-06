package POO.TP01.ListaTarea;
/*
    Ejercicio 5: Lista de Tareas
    Una tarea es una acción que debe realizarse. Habitualmente todas las tareas que tenemos pendientes las ponemos
    en una lista, y en la medida que las vamos cumpliendo, las vamos "tachando".
    Queremos empezar a construir una app que gestione esta lista de tareas.
    Una tarea es una descripción, que además contiene una prioridad y un estado (Si está completa o incompleta).
    Además, una tarea puede tener una fecha límite. Si la tarea sobrepasa esta fecha y su estado es incompleta,
    vamos a decir que la tarea está vencida.
    A una tarea, le podemos modificar su descripción, cambiarle la prioridad y avisar que está terminada.
    Además, podemos querer mostrar la tarea, en cuyo caso muestra la descripción. Pero, si la tarea está terminada,
    el mensaje debería iniciar con el string "(Vencida)...".
    A una tarea queremos poder preguntarle si se encuentra vencida o no, como así también le podemos consultar si está completa o no.
        Se pide:
            Generar un diagrama de clase simple de la clase Tarea.
            Generar el código en Java que represente la tarea. Debe incluir todos los métodos derivados de la descripción.
            Generar un programa en Java que haga uso de la clase Tarea, y cree las siguientes tareas:

        "Ir al supermercado mañana". Debe tener la fecha límite establecida y estar incompleta.
        "Consultar repuesto del auto". Debe tener la fecha límite para ayer y estar completa.
        "Ir al cine a ver la nueva película de Marvel". Debe tener fecha límite de ayer y estar incompleta.



    Este último programa debe configurar el estado especificado en cada objeto, y mostrar sus mensajes respectivos.
    Tip: Es posible que deba revisar el funcionamiento de la clase java.time.LocalDate de Java.

*/

import java.time.LocalDate;
import java.util.Objects;

public class Tarea {
        public enum Prioridad {ALTA,BAJA,MEDIA}
        public enum Estado {COMPLETA,INCOMPLETA,POR_VENCER,VENC_COMP,VENCIDA}
        private String descripcion;
        private Estado estado;
        private Prioridad prioridad;
        private LocalDate fechaLimite;
        private LocalDate fechaFinalizacion;
        private LocalDate fechaRecordatorio;

        public Tarea(String descripcion, Prioridad prioridad, LocalDate fechaLimite, LocalDate fecharRecordatorio) {
                this.descripcion = descripcion;
                this.setEstado(Estado.INCOMPLETA);
                this.setPrioridad(prioridad) ;
                //this.setFechaLimite(fechaLimite);
                this.fechaLimite = fechaLimite;
                this.setFechaRecordatorio(fecharRecordatorio);

        }
        public Tarea(String descripcion,Prioridad prioridad, LocalDate fechaLimite) {
                this( descripcion,prioridad,fechaLimite,null);
        }

        public void setEstado(Estado estado) {
                if (this.getEstado() == Estado.VENCIDA){
                        if(estado==Estado.COMPLETA){
                                this.estado=Estado.VENC_COMP;
                        }
                        return;
                }
                if(this.getEstado()==Estado.COMPLETA){
                        return;
                }
                if(this.getEstado()==Estado.VENC_COMP){
                        return;
                }

                this.estado=estado;
        }

        public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
                this.fechaFinalizacion = fechaFinalizacion;
        }

        public String getDescripcion() {
                return descripcion;
        }
        public LocalDate getFechaFinalizacion() {
                return fechaFinalizacion;
        }

        public Estado getEstado() {
                return estado;
        }

        public Prioridad getPrioridad() {
                return prioridad;
        }

        public LocalDate getFechaLimite() {
                return fechaLimite;
        }

        public void setFechaLimite(LocalDate fechaLimite) {
                if (LocalDate.now().isBefore(fechaLimite)){
                        this.fechaLimite=fechaLimite;
                }
        }

        public LocalDate getFechaRecordatorio() {
                return fechaRecordatorio;
        }

        public void setFechaRecordatorio(LocalDate fechaRecordatorio) {
                if (fechaRecordatorio==null){
                        return;
                }
                if(this.getFechaLimite().isBefore(fechaRecordatorio)){
                     return;
                }
                this.fechaRecordatorio = fechaRecordatorio;
        }
        public void setDescripcion(String descripcion) {
                this.descripcion = descripcion;
        }

        public void setPrioridad(Prioridad prioridad) {
                this.prioridad = prioridad;
        }

        public String toString(){
                return ("<"+this.getEstado().toString()+">\n"+"Descripcion: " +
                        this.getDescripcion()+"\nPrioridad: "+this.getPrioridad().toString() +
                        "\nFecha Limite: "+this.getFechaLimite().toString()+
                        "\nFecha Recordatorio: "+ Objects.toString(this.getFechaRecordatorio(),"<Null>")+
                        "\nFinalizada el: "+Objects.toString(this.getFechaFinalizacion(),"<Null>")+"\n");
        }
        public Boolean Completa(){
                if ((this.estado==Estado.INCOMPLETA)&&(!this.meVenci())){this.estado = Estado.COMPLETA;return true;}
                return false;
        }
        public Boolean meVenci(){
                LocalDate fechaActual =  LocalDate.now();
                if (this.fechaLimite.isBefore(fechaActual)){
                        this.setEstado(Estado.VENCIDA);
                        return true;
                }
                if (fechaRecordatorio==null){
                        return false;
                }
                if((this.getFechaRecordatorio().isBefore(LocalDate.now())||(this.getFechaRecordatorio().isEqual(LocalDate.now())))){
                        this.setEstado(Estado.POR_VENCER);
                        this.setPrioridad(Prioridad.ALTA);
                }
                return false;
        }

        public void Realizada(){
                this.fechaFinalizacion=LocalDate.now();
                this.setEstado(Estado.COMPLETA);
        }



}
