package POO.TP01.Admin.Biblioteca;

import java.util.ArrayList;

public class Biblioteca {
    public Biblioteca() {
        this.libros = new ArrayList<Libro>();
    }

    enum Busqueda {NOMBRE,AUTOR,AMBOS};
    private final ArrayList<Libro> libros;
    public Biblioteca Buscar_parecidos(Busqueda tipo, String dato){
        Biblioteca parecidos = new Biblioteca();
        for (Libro libro: this.libros) {
            if (tipo == Busqueda.AUTOR){
                if (libro.getAutor().toLowerCase().contains(dato.toLowerCase())){
                    parecidos.Agregar_Libro(libro);
                }
            }else{
                if (libro.getNombre().toLowerCase().contains(dato.toLowerCase())){
                    parecidos.Agregar_Libro(libro);
                }
            }
        }
        return parecidos;
    }
    private Libro Buscar(Busqueda tipo, Libro dato){
        for (Libro libro: this.libros) {
            if (tipo == Busqueda.AUTOR){
                if (libro.getAutor().equalsIgnoreCase(dato.getAutor())){
                    return libro;
                }
            }else if(tipo==Busqueda.NOMBRE){
                if (libro.getNombre().equalsIgnoreCase(dato.getNombre())) {
                    return libro;
                }
            }else if(libro.equals(dato)){
                return libro;

            }
        }
        return null;
    }
    public Libro Busqueda_por_Nombre(Libro dato){
        return this.Buscar(Busqueda.NOMBRE,dato);
    }
    public Libro Busqueda_por_Autor(Libro dato){
        return this.Buscar(Busqueda.AUTOR,dato);
    }
    public Boolean Prestar(Libro libro){
        return this.libros.get(libro.getUbicacion_en_biblioteca()).Prestar();
    }
    public Boolean Devolver(Libro libro){
        return this.libros.get(libro.getUbicacion_en_biblioteca()).Devolver();
    }
    public int Cantidad_de_Prestamos_Actuales(){
        int count = 0;
        for (Libro libro: this.libros){
            count+=libro.getNum_ejemplares_prestados();
        }
        return count;
    }
    public Boolean Agregar_Libro(Libro libro){
        Libro ejemplar = (this.Buscar(Busqueda.AMBOS,libro));
        if (ejemplar !=null){
            ejemplar.agregar_Ejemplar();;
            return false;
        }
        libro.setUbicacion_en_biblioteca(this.libros.size());
        this.libros.add(libro);
        return true;
    }
    public Libro recuperar_Libro(int pos){
        if((pos<0)||(pos>this.libros.size())){
            return null;
        }
        return this.libros.get(pos-1);
    }
    public Libro libroMas_Paginas(){
        Libro masPagina = null;
        int count = 0;
        for (Libro libro : this.libros) {
            if (libro.getCant_paginas()>count){
                masPagina = libro;
                count = libro.getCant_paginas();
            }
        }
        return masPagina;
    }

    public String toString(){
        String bibilioteca = "";
        for (Libro libro : this.libros) {
            bibilioteca = bibilioteca.concat(libro.toString());
        }
        return bibilioteca;
    }

}
