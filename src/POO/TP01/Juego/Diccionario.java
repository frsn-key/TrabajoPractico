package POO.TP01.Juego;

import java.util.ArrayList;

public class Diccionario {
    static private ArrayList<String> Palabras;

    public Diccionario() {

    }

    public Diccionario(ArrayList<String> palabras){
        Palabras.addAll(palabras);
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
