package POO.TP01.Juego;

import java.util.ArrayList;

public class Jugador {
    private String Nombre_Juagdor;
    private Integer Puntaje;
    private ArrayList<String> formadas;

    public Jugador(String nombre_Juagdor) {
        Nombre_Juagdor = nombre_Juagdor;
    }

    public Integer getPuntaje() {
        return Puntaje;
    }

    public String getValidas() {
        return formadas.toString();
    }

    public Boolean Agregar_Validas(String palabra,Diccionario diccionario){
        if (diccionario.Valida(palabra)){
            this.formadas.add(palabra);
            return true;
        }
        return false;
    }

    public void setPuntaje(Integer puntaje) {
        Puntaje += puntaje;
    }
}
