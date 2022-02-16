package com.sofkau.practice2.utils;

import java.util.Random;

public class DNI {
    Random random = new Random();

    /**
     * Genera un DNI aleatorio de 8 characteres y lo asigna a la propiedad DNI de la persona (instancia)
     */
    public String generateDNI() {
        String dni = "";
        int[] randomNumbers = generateNumbers(8,0,7);
        for (int i = 0; i < randomNumbers.length; i++) {
            dni += characterController(randomNumbers[i]);
        }
        return dni;
    }

    /**
     * Genera un array de numeros aleatorios
     * @param size El tamaño deseado de numeros a generar
     * @param initial valor de origin
     * @param bound limite
     * @return Array de numeros
     */
    private int[] generateNumbers(int size, int initial, int bound) {
        return random.ints(size, initial, bound).toArray();
    }

    /**
     * Genera un character de acuerdo a un numero(int) que recibe como parametro
     * @param randomNumber
     * @return
     */
    private String characterController(int randomNumber) {
        String [] character = { "A", "B", "C", "D", "E", "F", "X", "L"};
        return character[randomNumber];
    }
}
