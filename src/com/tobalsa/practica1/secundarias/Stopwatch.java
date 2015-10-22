package com.tobalsa.practica1.secundarias;

public class Stopwatch { 

    private final long start;

   /** Create a stopwatch object. */
    public Stopwatch() {
        start = System.currentTimeMillis();
    } 

   /**
     * Return elapsed time (in seconds) since this object was created.
     */
    public long elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start);
    }
} 
