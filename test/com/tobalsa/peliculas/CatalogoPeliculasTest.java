package com.tobalsa.peliculas;

import com.tobalsa.models.Pelicula;
import com.tobalsa.secundarias.Fichero;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by toburi on 08/10/2015.
 * Creado por toburi el 08/10/2015.
 */
public class CatalogoPeliculasTest {
    Fichero lector;
    CatalogoPeliculas miCatalogoPeliculas;

    @Before
    public void setUp() throws Exception {
        lector = new Fichero();
        miCatalogoPeliculas = CatalogoPeliculas.getCatalogoPeliculas();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAnadirEliminarPeliculaTamanoBuscarPeliculaPorTituloImprimirLista() throws Exception {
        lector.cargarFichero("actors-movies-2015-2016.txt");
        miCatalogoPeliculas.imprimirLista();

        assertNotNull(miCatalogoPeliculas.buscarPeliculaPorTitulo("The Only Thing I Want"));
        assertNotNull(miCatalogoPeliculas.buscarPeliculaPorTitulo("Tiger: His Fall & Rise"));

        assertEquals(miCatalogoPeliculas.tamano(),238978);

        Pelicula p1 = new Pelicula("Batman vs Superman");
        miCatalogoPeliculas.anadirPelicula(p1);

        assertEquals(miCatalogoPeliculas.tamano(),238979);

        miCatalogoPeliculas.eliminarPelicula(p1);

        assertEquals(miCatalogoPeliculas.tamano(),238978);
    }
}