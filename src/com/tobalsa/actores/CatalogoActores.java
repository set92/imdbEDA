package com.tobalsa.actores;

import com.tobalsa.models.Actor;

/**
 * Created by toburi on 01/10/2015.
 * Creado por toburi el 01/10/2015.
 */
public class CatalogoActores {
    // atributos
    private ListaActores lista;
    private static CatalogoActores miCatalogo = new CatalogoActores();


    // constructora
    private CatalogoActores(){
        this.lista = new ListaActores();
    }

    // otros métodos
    public static CatalogoActores getCatalogo(){
        return miCatalogo;
    }
//TODO mirar entero
    public Actor buscarActor(String nombre){
        return this.lista.buscarActorPorNombre(nombre);
    }

    public void prestarLibro(int pIdLibro, int pIdUsuario){
        Libro unLibro = this.lista.buscarLibroPorId(pIdLibro);
        Usuario unUsuario = ListaUsuarios.getListaUsuarios().quienLoTienePrestado(unLibro);
        if (unUsuario==null){
            unUsuario = ListaUsuarios.getListaUsuarios().buscarUsuarioPorId(pIdUsuario);
            if (!unUsuario.haAlcanzadoElMaximo()){
                unUsuario.anadirLibro(unLibro);
            }else{
                System.out.println("El usuario tiene el maximo de libros.");
            }
        }else{
            System.out.println("El libro ya ha sido prestado.");
        }

    }

    public void devolverLibro(int pIdLibro){
        Libro unLibro = this.lista.buscarLibroPorId(pIdLibro);
        Usuario unUsuario = ListaUsuarios.getListaUsuarios().quienLoTienePrestado(unLibro);
        unUsuario.eliminarLibro(unLibro);
    }

    public void catalogarLibro(Libro pLibro){
        this.lista.anadirLibro(pLibro);
    }

    public void descatalogarLibro(int pIdLibro){
        Libro unLibro = this.lista.buscarLibroPorId(pIdLibro);
        Usuario unUsuario = ListaUsuarios.getListaUsuarios().quienLoTienePrestado(unLibro);
        if (unUsuario==null){
            this.lista.eliminarLibro(unLibro);
        }else {
            System.out.println("El libro lo tiene un usuario, no se pude descatalogar.");
        }
    }

    public void imprimir(){
        System.out.println("El catálogo tiene un total de " + this.lista.obtenerNumLibros() + " títulos.");
        this.lista.imprimir();
    }

    public void resetear(){
        this.lista = new ListaLibros();
    }

}
