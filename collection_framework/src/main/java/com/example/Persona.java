package com.example;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public record Persona(
		String nombre,
		String primerApellido,
		String segundoApellido,
		LocalDate fechaNacimiento,
		Genero genero,
		double salario
		
		// Ordenamiento natural hay que implementar la interfaz comparable:
		) implements Comparable<Persona> { 
	@Override
	public int compareTo(Persona persona) {
		// Resultado de la comparación por el primer apellido de dos personas lista personas
		int cmpPrimerApellido = this.primerApellido
				.compareTo(persona.primerApellido());
		// Resultado comparación por segundo apellido:
		int cmpSegundoApellido = this.segundoApellido
				.compareTo(persona.segundoApellido());
		// Resultado comparación por nombre:
		int cmpNombre = this.nombre
				.compareTo(persona.nombre());
			
		// TODO Auto-generated method stub
		// operador ternario, primero comparamos primer apellido a ver si es diferente.
		// despues de los : preguntamos a por el segundo apellido a ver si es igual.
		// Por último asumimos que el nombre es diferente y sera lo que use short para ordenar la lista
		return cmpPrimerApellido != 0 ? cmpPrimerApellido : 
			cmpSegundoApellido != 0 ? cmpSegundoApellido : 
				cmpNombre;
		// jodete un ternario anidado.
	}

}
