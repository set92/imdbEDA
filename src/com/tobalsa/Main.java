package com.tobalsa;

import com.tobalsa.proyectos.Fichero;
import com.tobalsa.proyectos.Stopwatch;

/**
 * Created by toburi on 30/09/2015.
 * Creado por toburi el 30/09/2015.
 */
public class Main {

    public static void main(String[] args) {
        long time = timeTrial();
        System.out.printf("%d ms\n", time);
    }

    public static long timeTrial() {
        Stopwatch timer = new Stopwatch();
        Fichero f = new Fichero();

        f.cargarFichero();
        //f.guardarFichero();

        return timer.elapsedTime();
    }

}
