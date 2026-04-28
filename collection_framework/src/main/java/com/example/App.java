package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.GZIPInputStream;

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
    	.salario(3500.50)
    	.build()
    	);
    
    personas.add(
    Persona.builder()
    	.nombre("Carolina")
    	.primerApellido("Garzon")
    	.segundoApellido("Becerra")
    	.fechaNacimiento(LocalDate.of(2000, Month.OCTOBER, 10))
    	.genero(Genero.MUJER)
    	.salario(3600.45)
    	.build()
    	);
    
    personas.add(
    Persona.builder()
        	.nombre("Maria")
        	.primerApellido("Garzon")
        	.segundoApellido("González")
        	.fechaNacimiento(LocalDate.of(2005, Month.OCTOBER, 22))
        	.genero(Genero.MUJER)
        	.salario(3640.30)
        	.build()
        	);
    
    personas.add(
    Persona.builder()
        	.nombre("Jerónimo")
        	.primerApellido("Arenal")
        	.segundoApellido("Gomez")
        	.fechaNacimiento(LocalDate.of(1989, Month.MAY, 30))
        	.genero(Genero.HOMBRE)
        	.salario(4200.25)
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
    
    /*
     * Variante #2 de Iterar o recorrer una colección con FOR mejorado.
     * 
     * Recorrer lista y eliminar las personas de genero mujer, para ver como no es posible
     * utilizando FOR mejorado.
     * */
    
    /*for (var p : personas) {
    	
    	if (p.genero().equals(Genero.MUJER))
    		personas.remove(p);  // sintacticamente correcto pero no funciona y falla.  	
    	}*/
    
    /*
     * Traversing Collections using Agregate Operations.
     * 
     * https://docs.oracle.com/javase/tutorial/collections/streams/index.html
     * 
     * ej. Calcular el salario promedio de las personas de genero Mujer.
     * 
     * Con el metodo tradicional hay que declarar variables para almacenar los salarios, y un contador para las
     * mujeres que aparezcan y luego dividir los salarios acumulados entre las mujeres contadas. Recorreriamos
     * la coleccion con for mejorado o iterador.
     * 
     * Operacines de agregado intenta convertir la colección en un flujo de elementos que pasan por una tuberia.
     * La cantidad de elementos puede ser mayor que la memoria disponible. 
     * Lo hacemos con el metodo stream: convierte la lista de personas en un flujo de personas.
     * Tb puede ser parallelStream, para usar la potencia de los nucleos del procesador y hacer flujo en paralelo.
     * Concepto de tuberia o pipeline: secuencia de operaciones de agregado. Implica convertir la colección en 
     * un flujo de elementos q comienzan a circular por una tubería o pipeline imaginario.
     * Pipeline = secuencia de metodos de la clase Stream. O secuencia operaciones agregado: metodos que
     * para obtener un resultado agrupan elementos del flujo.
     * 
     * Una tubería o pipeline, tiene un origen que puede ser un array, una colección, un socket, un fichero, una
     * consulta de DB, etc,.
     * 
     * Una tueria puede tener entre 0, 1 y muchas operaciones intermedias y una sola operación terminal.
     * 
     * Lo primero es utilizar el metodo stream, q tb puede ser parallelStream, para converir la colección en un
     * flujo de elementos del mismo tipo q la colec.
     * 
     * A partir de tener flujo elementos entran en funcionamiento los metodos de la clase Stream, operaciones
     * intermedias, como el metodo filter, para permitir q solamente circule al proximo nivel de la tuberia
     * las personas de genero mujer.
     * 
     * Metod filter necesita un predicado y deja o no pasar los elementos que le digamos, dependiendo de su carcterística
     * recibe un predicado <? super Persona> 
     * Stream<T> filter(Predicate<? super T> predicate) admite elementos de subtipo T
     * 
     * Predicate: Interfaz funcional, condición q tiene que cumplir un elemento q pasa por la tubería. Puede tener 
     * metodos por defecto, que tienen cuerpo, metodos estáticos, etc., pero solamente un metodo abstracto.
     * 
     * El metodo abstracto para el predicado(interface) de filter(metodo) es test(T t): evalua el predicado para el argumento dado, cumple con la condición 
     * verdaro o falso, vamos que deja pasar o no dependiendo de si el elemento que quiere pasar cumple
     * con la condición que hemos dado o no.
     * 
     * ¿Qué implemeta un interface? una clase (también puede ser un record). En el metodo filter hace falta una clase que implemente la interfaz
     * predicate
     * 
     */
    
    	// Stream<Persona> flujoDePersona = personas.stream(); // Establecemos el flujo de personas más o menos, pero no...
    	
    	// Filtro filtro = new Filtro();
    
    	// personas.stream().filter(filtro)
    
    	// personas.stream().filter(new Filtro());    	
    	
    /*
     * El código es una exageración por tener que declarar una clase externa solamente para
     * implementar la interfaz funcional Predicate.
     * 
     * Más eficiente crear una clase en el mismo sitio donde se va a instanciar el objeto.
     * El lo guisa y el se lo come.
     * 
     * Para esto => Clases anonimas: Clase que no tiene nombre. Se declara pero no sirve para instanciar
     * un objeto. Parece una clase pero no tiene nombre es una expresión de clase.
     * 
     * Se puede utilizar una clase anonima para instanciar un objeto a partir de una interfaz, pero 
     * también a partir de una clase abstracta.
     * 
     * Clase anonima permite declarar e instanciar un objeto al mismo tiempo. Hacemos sobre Persona
     * lo mismo que hicimos en la clase cuando la declaramos a parte dejar cursor sobre ello e implementar.
     * */
    
    	personas.stream().filter(new Predicate<Persona>() {

			@Override
			public boolean test(Persona p) {
				// TODO Auto-generated method stub
				return p.genero().equals(Genero.MUJER);
			}
		});
    	
    /*
     * El uso de la clase anonima, o expresión de clase anonima es mejor que implementar la clase
     * filtro a parte, pero sigue siendo una exageración si no se van a declarar variables 
     * adicionales, ni implementar otra cosa diferente del metodo abstracto de la interfaz predicate.
     * Si solo vamos a usar el metodo abstracto Test de la interfaz funcional Predicate.
     * 
     * Y llegamos a las EXPRESIONES LAMBDA. 
     * 
     * Es un metodo anonimo, sin nombre, para implementar los metodos de las interfaces funcionales,
     * como el predicado del filter que estamos utilizando.
     * 
     * Al metod FILTER de la clase STREAM le tengo q pasar una lambda q implemente el metodo TEST del 
     * interfaz funcinal PREDICATE.
     * 
     * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
     * 
     * Nota IMPORTANTE LAMBDAS Y CLASES ANONIMAS
     * Tanto clases anonimas com expresiones lambda solo se pueden relacionar con variables
     * locales (declaradas dentro de metodos) que sean explicitamente final o effectively final.
     *  
     * */
    	
    	// personas.stream().filter(test(Persona p){
    	//	return p.genero().equals(Genero.MUJER)
    	//	});
    		
    		
    	personas.stream().filter(p -> p.genero().equals(Genero.MUJER));
    	
    	/*
    	 * Empiezo el martes aquí con el ordenamiento de listas.
    	 * */
    	
    	Collections.sort(personas);
    	
    	// Mostar la lista de personas resultante:
    	personas.stream().forEach(persona -> System.out.println(persona));
    	
    }
}
