package com.tobalsa.proyectos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by toburi on 01/10/2015.
 * Creado por toburi el 01/10/2015.
 */
public class Fichero {
    public void cargarFichero(){//String path
//TODO regex, separar en los distintos arrays // arraylist
        try {
            BufferedReader bf = new BufferedReader(new FileReader("actors-small.txt"));
            String line = "";
            while (line != null){
                line = bf.readLine();
                if (line != null) System.out.println(line);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
