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
    
    // List<Persona> personas = new ArrayList<>();
    var personas = new ArrayList<Persona>(); // alternativa a la forma anterior var es un generico para List<Persona>
    // siempre que uses var hay que darle al compilador alguna pista de lo que realmente es.
    
    
    var persona1 = Persona.builder()
    	.nombre("Douglas")
    	.primerApellido("Tay")
    	.segundoApellido("Gon")
    	.fechaNacimiento(LocalDate.of(1995, Month.JANUARY, 20))
    	.genero(Genero.HOMBRE)
    	.build();
    
    var persona2 = Persona.builder()
    	.nombre("Carolina")
    	.primerApellido("Garzon")
    	.segundoApellido("Becerra")
    	.fechaNacimiento(LocalDate.of(2000, Month.OCTOBER, 10))
    	.genero(Genero.MUJER)
    	.build();
    
    var persona3 = Persona.builder()
        	.nombre("Maria")
        	.primerApellido("Garzon")
        	.segundoApellido("González")
        	.fechaNacimiento(LocalDate.of(2005, Month.OCTOBER, 22))
        	.genero(Genero.MUJER)
        	.build();
    
    var persona4 = Persona.builder()
        	.nombre("Jerónimo")
        	.primerApellido("Arenal")
        	.segundoApellido("Gomez")
        	.fechaNacimiento(LocalDate.of(1989, Month.MAY, 30))
        	.genero(Genero.HOMBRE)
        	.build();
    
    // Estamos usando variables que vamos a usar una sola vez para crear el array, nos sobran.
    
    personas.add(persona1); // esto así nos da null pointer exception por intentar agrgar un elemento sin reservar memoria.
    personas.add(persona2);
    personas.add(persona3);
    personas.add(persona4);
    
    /* En lugar de invocar el metodo 4 veces, como arriba, se hace todo de una vez... o no.*/
    
    personas = (ArrayList<Persona>) Arrays.asList(persona1, persona2, persona3, persona4);
    
    
    /* Si la lista de personas apunta a null,  entonces no podemos agregar elementos Persona
     * a dicha lista, porque no hemos reservado memoria para la lista de personas
     * 
     * Para reservar memoria para la lista de persona
     * Utilizando el constructor de alguna de las clases que implementa la interfaz List 
     * */
    
    }
}
