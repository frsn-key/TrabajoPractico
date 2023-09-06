package POO.TP01.Contrasenas;

import java.util.Random;

/*
Se requiere diseñar un objeto que dando de parámetro una longitud determinada genera un password aleatorio.
Por defecto, la longitud será de 8, pero existe la posibilidad que se requiera una longitud más larga.
En ambos casos, genera una contraseña aleatoria con esa longitud automáticamente ante su creación.
Además, se requiere saber si el password es fuerte.
Considere que una contraseña fuerte es aquella que tiene más de 2 mayúsculas, más de 1 minúscula y al menos dos números.
En caso de que la contraseña no sea fuerte, debe existir alguna forma de regenerarla y asegurarse de que el password sea fuerte.
En cualquier caso, debo poder obtener la contraseña y su longitud, y poder cambiar su longitud.
 */
public class Contrasena {

    private void setFortaleza(Fortaleza fortaleza) {
        this.fortaleza = fortaleza;
    }

    private enum Fortaleza {Debil,Fuerte};
    static private final String Caracteres_Disponibles = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private String contrasena="";
    private Integer longitud = 8;
    private Fortaleza fortaleza;

    public Contrasena() {
        this(8);
    }

    public Contrasena(Integer longitud) {
        this.setLongitud(longitud);
        this.generar_Contrasena();
    }

    public void reGenerar_Contrasena(){
        this.limpiarContrasena();
        this.generar_Contrasena();
    }

    public void reGenerar_Contrasena(int longitud){
        this.limpiarContrasena();
        this.setLongitud(longitud);
        this.generar_Contrasena();
    }

    public void reGenerar_Contrasena_Fuerte(){
        this.reGenerar_Contrasena();
        while(this.getFortaleza()!=Fortaleza.Fuerte){
            this.reGenerar_Contrasena();
        }
    }

    public void reGenerar_Contrasena_Fuerte(int longitud){
        this.reGenerar_Contrasena(longitud);
        while(this.getFortaleza()!=Fortaleza.Fuerte){
            this.reGenerar_Contrasena(longitud);
        }
    }

    private void generar_Contrasena(){
        Random random = new Random();
        for (int i = 0; i < this.longitud; i++) {
            this.contrasena=this.contrasena.concat(String.valueOf(Caracteres_Disponibles.charAt(random.nextInt(Caracteres_Disponibles.length()-1))));
        }
        this.setFortaleza(this.calcular_fortaleza());
    }

    public String getContrasena() {
        return contrasena;
    }

    private void setLongitud(Integer longitud) {
        if(longitud<8){
            this.longitud=8;
            return;
        }
        this.longitud = longitud;
    }

    private Fortaleza calcular_fortaleza(){
        int Mayus = 0;
        int Minus = 0;
        int Num = 0;
        for (int i = 0; i < this.contrasena.length(); i++) {
            if (this.contrasena.charAt(i) >= '0' && this.contrasena.charAt(i) <= '9'){
                Num++;
            }else if (this.contrasena.charAt(i) >= 'a' && this.contrasena.charAt(i) <= 'z'){
                Minus++;
            }else if (this.contrasena.charAt(i) >= 'A' && this.contrasena.charAt(i) <= 'Z'){
                Mayus++;
            }
        }
        if ((Num >= 2 )&&(Mayus>2) && (Minus>1)){
            return Fortaleza.Fuerte;
        }
        return Fortaleza.Debil;
    }
    public Fortaleza getFortaleza() {
        return fortaleza;
    }

    private void limpiarContrasena(){
        this.contrasena="";
        this.setLongitud(8);
    }

    public String toString(){
        return "<"+this.getContrasena()+"> --> ["+this.getFortaleza()+"]";
    }

}
