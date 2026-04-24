package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// import lombok.var;

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
    
    var personas = new ArrayList<Persona>();
    // var personas = new ArrayList<Persona>(); // alternativa a la forma anterior var es un generico para List<Persona>
    // siempre que uses var hay que darle al compilador alguna pista de lo que realmente es.
    
    personas.add(
    Persona.builder()
    	.nombre("Douglas")
    	.primerApellido("Tay")
    	.segundoApellido("Gon")
    	.fechaNacimiento(LocalDate.of(1995, Month.JANUARY, 20))
    	.genero(Genero.HOMBRE)
    	.build()
    	);
    
    personas.add(
    Persona.builder()
    	.nombre("Carolina")
    	.primerApellido("Garzon")
    	.segundoApellido("Becerra")
    	.fechaNacimiento(LocalDate.of(2000, Month.OCTOBER, 10))
    	.genero(Genero.MUJER)
    	.build()
    	);
    
    personas.add(
    Persona.builder()
        	.nombre("Maria")
        	.primerApellido("Garzon")
        	.segundoApellido("González")
        	.fechaNacimiento(LocalDate.of(2005, Month.OCTOBER, 22))
        	.genero(Genero.MUJER)
        	.build()
        	);
    
    personas.add(
    Persona.builder()
        	.nombre("Jerónimo")
        	.primerApellido("Arenal")
        	.segundoApellido("Gomez")
        	.fechaNacimiento(LocalDate.of(1989, Month.MAY, 30))
        	.genero(Genero.HOMBRE)
        	.build()
        	);
    
   /*La lista resultante: personas no es de tamaño fijo, pues no la hemos obtenido a paratir de un array.
    * Se le pueden añadir o quitar elemtos cuando sea necesario.
    * */
    
    System.out.println(personas);
    
    }
}
