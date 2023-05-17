package es.studium.Slot;

import java.util.Random;

public class Modelo
{
	Modelo()
	{
		
	}
	
	// Método aleatorio()
	public int aleatorio()
	{
		Random aleatorio = new Random();
		int numero = aleatorio.nextInt(14)+1;
		return(numero);
	}
}
