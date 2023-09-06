package POO.TP01.Contrasenas;

public class Ej8 {
    private Contrasena contrasena;

    public void generarContrasenas(){
        contrasena =  new Contrasena();
        System.out.println("Contraseña generada con el constructor: \n"+contrasena);
        System.out.println("Contraseñas generadas desde 1 a 20. Se toma el i como parametro de longitud:");
        for (int i = 1; i < 20 ; i++) {
            contrasena.reGenerar_Contrasena(i);
            System.out.println(contrasena);
        }
    }

    public void generarContrasenasFuertes(){
        contrasena =  new Contrasena();
        System.out.println("Contraseña generada con el constructor: \n"+contrasena);
        System.out.println("Contraseñas fuertes generadas  desde 1 a 20. Se toma el i como parametro de longitud:");
        for (int i = 1; i < 20 ; i++) {
            contrasena.reGenerar_Contrasena_Fuerte(i);
            System.out.println(contrasena);
        }
    }

}
