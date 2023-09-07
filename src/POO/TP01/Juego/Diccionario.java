package POO.TP01.Juego;

import java.util.ArrayList;

public class Diccionario {
    static private ArrayList<String> Palabras;

    public Diccionario() {
        Palabras.add("Hola");
        Palabras.add("Quiosco");
        Palabras.add("Kiosco");
        Palabras.add("Zorro");
        Palabras.add("yoyo");
        Palabras.add("windows");
        Palabras.add("Perro");
        Palabras.add("Gato");
        Palabras.add("Auto");
        Palabras.add("Avion");
    }

    public Boolean Valida(String palabra){
        return Palabras.contains(palabra.toLowerCase());
    }

    public Boolean Agregar_Palabra_Valida(String palabra){
        if (this.Valida(palabra)){
            return false;
        }else{
            Palabras.add(palabra.toLowerCase());
            return true;
        }
    }



}
