package POO.TP01.Polinomio;
/*  Se requiere implementar una clase que represente y pueda resolver una ecuación de segundo grado. Dada una ecuación de
    2do grado de la forma y = a * x^2 + b * x + c, la fórmula para el cálculo de las raíces es (-b ± √((b^2) - (4 * a * c))) / (2 * a).
    Una vez que se crea una instancia de la clase no se podrán modificar sus coeficientes.
    Recordar que puede darse el caso donde exista una única raíz y para que esto ocurra el discriminante ((b^2) - 4 * a * c) debe ser igual a 0.
    En este último caso, en vez de retornar 2 raíces se debería retornar una sola. Existe el caso también donde necesitemos calcular el valor de y
    en base al valor de x, que se pasa como parámetro.
    Objetivos:
    Definir estructura y comportamiento.
    Crear una clase que utilice a la anterior y que pruebe todos los métodos con varios resultados.
*/

public class Polinomio {
    final private double A;
    final private double B;
    final private double C;

    public Polinomio(double a, double b, double c) {
        A = a;
        B = b;
        C = c;
    }

    public Raices Calcular_Raices(){
        Raices raices =  new Raices();
        double result = + ((((Math.sqrt(Math.pow(B,2))-(4*A*C))))/2*A);
        if (((Math.pow(B,2) - 4 * A * C)==0)){
            raices.setRaiz1(-B + result);
            raices.setRaiz2(raices.getRaiz1());
        }else{
            raices.setRaiz1(-B + result);
            raices.setRaiz2(-B - result);
        }
        return raices;
    }

    public Double Calcular_valor_de_Y(int x){
        return ((A*Math.pow(x,2))+(B*x)+C);
    }

}
