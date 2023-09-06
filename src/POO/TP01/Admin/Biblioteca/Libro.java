package POO.TP01.Admin.Biblioteca;
/*
     Necesitamos implementar la clase Libro para un sistema de administración de bibliotecas y todas las clases relacionadas que correspondan.
     Generalmente las búsquedas se hacen por Título o Autor, es casi imposible que quieran buscar un libro por ISBN y
     en ciertos casos no se tiene el dato para completarlo. Si solo queda un Ejemplar disponible, no se puede prestar el libro
     porque tiene que quedar disponible para consultar dentro de la biblioteca. El sistema debería mostrar la descripción del
     libro como: El libro <su_titulo> creado por el autor <su_autor> tiene <num_paginas> páginas, quedan <num_ejemplares>
     disponibles y se prestaron <num_ejemplares_prestados>. También se necesita determinar la cantidad de préstamos realizados,
     teniendo en cuenta todos los libros disponibles.
        Objetivos:
            -Definir responsabilidad, estructura y comportamiento de las clases.
            -Crear una clase que utilice a las anteriores y que cree 2 objetos Libro (los valores que se quieran),
             mostrarlos por pantalla e indique cuál de los 2 tiene más páginas.
            -Intentar prestar un libro con 10 ejemplares y uno con 1 solo ejemplar.
            -Mostrar cantidad total hecha de préstamos.
*/
public class Libro {

    private String Nombre;
    private String Autor;
    private int ISBN;
    private int cant_paginas;
    private int num_ejemplares;
    private int num_ejemplares_prestados;

    public int getUbicacion_en_biblioteca() {
        return ubicacion_en_biblioteca;
    }

    private int ubicacion_en_biblioteca;

    public Libro(String nombre, String autor, int ISBN, int cant_paginas, int num_ejemplares) {
        this.Nombre = nombre;
        this.Autor = autor;
        this.ISBN = ISBN;
        this.cant_paginas = cant_paginas;
        this.num_ejemplares = num_ejemplares;
        this.num_ejemplares_prestados = 0;
    }

    public Boolean Disponibilidad(){
        return ((this.num_ejemplares-this.num_ejemplares_prestados)>1);
    }
    public Boolean Prestar(){
        if (!this.Disponibilidad()){return false;}
        this.num_ejemplares_prestados ++;
        return true;
    }

    public Boolean Devolver(){
        if (this.num_ejemplares_prestados==0){return false;}
        this.num_ejemplares_prestados--;
        return true;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public String getAutor() {
        return this.Autor;
    }

    public int getISBN() {
        return this.ISBN;
    }

    public int getCant_paginas() {
        return this.cant_paginas;
    }

    public int getNum_ejemplares() {
        return this.num_ejemplares;
    }

    public int getNum_ejemplares_prestados() {
        return this.num_ejemplares_prestados;
    }

    public void setUbicacion_en_biblioteca(int pos) {
        this.ubicacion_en_biblioteca = pos;
    }

    public Boolean setNum_ejemplares(int num_ejemplares){
        if ((num_ejemplares<this.num_ejemplares_prestados)||(num_ejemplares<=0)){
            return false;
        }
        this.num_ejemplares = num_ejemplares;
        return true;
    }

    public Boolean equals(Libro libro){
        return (this.Nombre.equalsIgnoreCase(libro.getNombre())&&this.Autor.equalsIgnoreCase(libro.getAutor()));
    }

    public void agregar_Ejemplar(){
        this.num_ejemplares+=1;
    }

    public int getDisponibiles(){
        return this.num_ejemplares-this.num_ejemplares_prestados;
    }

    public String toString(){
        return ("El libro '"+ this.Nombre+ "' creado por el autor '"+this.Autor+"' tiene '"+this.cant_paginas+"' páginas, " +
                "\nquedan '"+this.getDisponibiles()+"' disponibles y se prestaron '"+this.num_ejemplares_prestados+"'.\n");
    }
}
