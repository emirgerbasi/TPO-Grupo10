package servicios;

import java.util.HashSet;

public class Parque implements Inclusivo{


	private HashSet<Atraccion> atracciones = new HashSet<Atraccion>();
	private HashSet<Restaurant> restaurantes = new HashSet<Restaurant>();

	public void agregarAtraccion(Atraccion unaAtraccion){
		atracciones.add(unaAtraccion);
	}

	public void agregarRestaurant(Restaurant unRestaurant){
		restaurantes.add(unRestaurant);
	}

	public boolean contieneServicio(Servicio unServicio){
		return this.atracciones.contains(unServicio) || this.restaurantes.contains(unServicio);
	}

	//ESPACIOS INCLUSIVOS

	@Override
	public int nivelDeInclusion() {
		int total = 0;
		int count = 0;

		// Sumar el nivel de inclusión de todas las atracciones
		for (Atraccion atraccion : atracciones) {
			total += atraccion.nivelDeInclusion();
			count++;
		}

		// Sumar el nivel de inclusión de todos los restaurantes
		for (Restaurant restaurant : restaurantes) {
			total += restaurant.nivelDeInclusion();
			count++;
		}

		return count > 0 ? total / count : 1; // Promedio de inclusión de atracciones y restaurantes
	}

}
