package POO.TP01.Juego;

import java.util.ArrayList;

public class Game {

    static private String Letras_suman_mas= "kzxywq";
    static private Diccionario diccionario;
    private ArrayList<Jugador> jugadores ;


    public Boolean agregar_palabra_valida(String palabra){
        return diccionario.Agregar_Palabra_Valida(palabra);
    }

    public int Puntos_segun_palabra(String palabra,Jugador jugador){
        if(!(diccionario.Valida(palabra))){
            return 0;
        }
        int puntos = 0;
        for (int i = 0; i < palabra.length() ; i++) {
            if(Letras_suman_mas.contains(String.valueOf(palabra.toLowerCase().charAt(i)))) {
                puntos++;
            }
            puntos++;
        }
        return puntos;

    }




}
