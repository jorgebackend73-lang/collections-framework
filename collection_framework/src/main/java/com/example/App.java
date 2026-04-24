package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
    	
    // Integer[] arrayNumerosEnteros = {1, 2, 3, 4, 5};
    
    // List<Integer> numerosEnteros = Arrays.asList(arrayNumerosEnteros);
    
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
    
    System.out.println("----------------- Listado Original Personas ----------------------");
    System.out.println(personas);
    
    /* Traversing Collections
     * 
     * https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
     * 
     * Y en doc Arrays, Generics and Collection Framework
     * 
     * Existen 3 formas de recorrer una colección:
     * 
     * Mejor variante: Utilizando Operaciones de Agregado, es decir: Programación Funcional
     * metodos de clase Stream, metodos por referencia y operaciones lambda.
     * 
     * Otros metodos:
     * 
     * Iterador, interfaz Iterator<E>. Unica forma de eliminar un elemento a la vez que se recorre la colección.
     * 
     * For mejorado.
     * 
     * */
    
    /*
     * Variante #1 Iterador: recorrer colección y a la vez eliminar a los de Genero Hombre.
     * */
    
    /*System.out.println("----------------- Listado Original Personas ----------------------");
    System.out.println(personas);
    
    Iterator<Persona> it = personas.iterator(); // declaramos iterador it para recorrer persona. Iterator vincula it con lista personas.
    
    	// recorrer en bucle la lista de personas, en este caso al no conocer el tamaño de la lista while.
    	while (it.hasNext()) {
    		// hasNext verdadero si hay mas elementos en la colec.
    		
    		if (it.next().genero().equals(Genero.HOMBRE)) {
    			it.remove(); // metodo del iterator para cargarnos un elemento, que hemos comprobado que es hombre en la condición del if.
    		}
    	}
    
    System.out.println("----------- Personas tras eliminar las de genero hombre ----------");
    System.out.println(personas);
    
    /*
     * Ejercicio #1 utilizando un iterador eliminar del listado de personas, aquellas de genero hombre , 
     * cuyo nombre tenga 6 caracteres.
     * 
     * Para la solución hacer commit del estado actual y eliminar o comentar el código del iterador  anterior
     * para tener la lista de personas original.
     * */
    
    
    Iterator<Persona> it = personas.iterator();
    
    while(it.hasNext()) {
    	var persona = it.next();
    	
    	if (persona.genero().equals(Genero.HOMBRE) &&
    			persona.nombre().length() == 7)
    		it.remove();
    	
    }
    
    System.out.println("--- Listado resultante ---");
    System.out.println(personas);
    
    }
}
