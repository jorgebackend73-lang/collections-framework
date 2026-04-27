package com.example;

import java.util.function.Predicate;

public class Filtro implements Predicate<Persona>{
	// Cambiamos la genericidad a Persona(ates había una T.
	
	// lo sigiente lo implementamos con el cursor sobre Filtro, el metodo abstracto que necesitamos.
	@Override
	public boolean test(Persona persona) { // argumeto O lo llamamos persona 
		// TODO Auto-generated method stub
		return persona.genero().equals(Genero.MUJER); // si se cumple da verdadero y este elemento podrá pasar por la tubería.
	}

}
