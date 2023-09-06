package POO.TP01.Juego;

import java.util.ArrayList;

public class Game {

    static private String Letras_suman_mas= "kzxywq";
    static private ArrayList<String> Dicconario;
    private ArrayList<Jugador> jugadores ;


    public Boolean existe(String palabra){
        return Dicconario.contains(palabra);
    }

    public int Puntos_segun_palabra(String palabra,Jugador jugador){
        if(!(this.existe(palabra))){
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
