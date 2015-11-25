package com.tobalsa;

import com.tobalsa.practica1.secundarias.Fichero;
import com.tobalsa.practica1.secundarias.Stopwatch;

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

        f.cargarFichero("actors-small.txt");
        //f.guardarFichero();

        return timer.elapsedTime();
    }

}
