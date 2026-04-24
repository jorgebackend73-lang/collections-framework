package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * El Framework de Colecciones está en: 
 * 
 * https://docs.oracle.com/javase/tutorial/collections/index.html
 * 
 */
public class App {
    public static void main(String[] args) {
    
    /*
     * Colección de números enteros a partir de un array de números enteros.
     * */
    	
    Integer[] arrayNumerosEnteros = {1, 2, 3, 4, 5};
    
    List<Integer> numerosEnteros = Arrays.asList(arrayNumerosEnteros);
    
    /*Una coleccion obtenida directamente a partir de un array es una coleccion de tamaño fijo que no se
     * puede agregar, ni eliminar elementos. Si, modificar esos elementos o sería inmutable.
     * */
    
    // numerosEnteros.add(6); esto falla, estamos intentando meter un elemento adicional.
    
    /*Ejemplo de creación de lista (colección) utilizando el metodo add(), que es 
     * polimorfico, para agregar elementos a la lista */
    
    List<Persona> personas = null;
    
    
    
    Persona persona1 = Persona.builder()
    	.nombre("Douglas")
    	.primerApellido("Tay")
    	.segundoApellido("Gon")
    	.fechaNacimiento(LocalDate.of(1995, Month.JANUARY, 20))
    	.genero(Genero.HOMBRE)
    	.build();
    
    persona.add(persona1); // esto así nos da null pointer exception por intentar agrgar un elemento sin reservar memoria.
    
    /*Si la lista de personas apunta a null (me falta este comentario, añadirlo al revisar grabación)*/
    
    }
}
