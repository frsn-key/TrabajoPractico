package POO.TP01.Juego;

import java.util.ArrayList;

public class Game {
    public Game() {
        Letras_suman_mas= "kzxywq";
        diccionario = new Diccionario();
    }

    static private String Letras_suman_mas;
    static private Diccionario diccionario;
    private ArrayList<Jugador> jugadores ;

    public Game(ArrayList<String> palabras) {
        diccionario =  new Diccionario(palabras);
    }

    public Game(ArrayList<String> palabras,String letras_suman_mas) {
        diccionario =  new Diccionario(palabras);
        Letras_suman_mas = letras_suman_mas;
    }

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

    public void agregar_palabra_valida(String palabra, Jugador jugador){
        if (jugador.Agregar_Validas(palabra, diccionario)){
            jugador.setPuntaje(this.Puntos_segun_palabra(palabra,jugador));
        }
    }




}
