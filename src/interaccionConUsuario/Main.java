package interaccionConUsuario;

import paquetes.*;
import servicios.Atraccion;
import servicios.Parque;
import servicios.Restaurant;

public class Main {
	public static void main(String[] args) {
		
		// CREACION DE PARQUES
		Parque epcot = new Parque();
		Parque hollywood = new Parque();
		Parque magicKingdom = new Parque();
		Parque animalKingdom = new Parque();
			
		
		//CREACION DE PAQUETES
		PaqueteExperienciaCompleta paseDeEmir = new PaqueteExperienciaCompleta();
		PaqueteParqueFav paseDeVani = new PaqueteParqueFav(animalKingdom);
		PaquetePorCant paseDeTobi = new PaquetePorCant(2);
		PaqueteInfantil paseDeLalo = new PaqueteInfantil();
		
		
		//CREACION DE ATRACCIONES
		Atraccion pulpitoGiratorio = new Atraccion(true); //es inclusivo
		Atraccion simuladorSpiderman = new Atraccion(false); //no es inclusivo
		Atraccion simuladorEuropa = new Atraccion(false); //no es inclusivo


		//CREACION DE RESTAURANTES
		Restaurant restoAvengers = new Restaurant(false, true); //no es inclusivo, pero es vegano
		Restaurant restoAleman = new Restaurant(true, true); //es inclusivo y vegano
		Restaurant restoPrincesas = new Restaurant(true, false); //es inclusivo, pero no vegano
		
		
		//INCLUIR ATRACCIONES EN PARQUES
		animalKingdom.agregarAtraccion(pulpitoGiratorio);
		hollywood.agregarAtraccion(simuladorSpiderman);
		epcot.agregarAtraccion(simuladorEuropa);

		//INCLUIR RESTAURANTES EN PARQUES
		hollywood.agregarRestaurant(restoAvengers);
		epcot.agregarRestaurant(restoAleman);
		magicKingdom.agregarRestaurant(restoPrincesas);

		//SETEO DE ATRACCIONES Y RESTAURANTES APTAS PARA MENORES
		pulpitoGiratorio.setAptoInfantil();
		restoAvengers.setAptoInfantil();
		restoPrincesas.setAptoInfantil();

		//NIVEL DE INCLUSION DE PARQUES

		System.out.println("Nivel de inclusión de los parques (1: nada inclusivo, 5: totalmente inclusivo).");
		System.out.println("Parque Epcot: " + epcot.nivelDeInclusion());
		System.out.println("Parque Hollywood: " + hollywood.nivelDeInclusion());
		System.out.println("Parque Animal Kingdom: " + animalKingdom.nivelDeInclusion());
		System.out.println(" ");

		//PRUEBA DE CONTROLES DE INGRESO
		System.out.println("Controles de ingreso");
		System.out.println(paseDeVani.puedoIngresar(simuladorSpiderman)); //false: se espera que no pueda ingresar porque tiene pase para Animal Kingdom y la atraccion esta en Hollywood (Paquete Parque Fav)
		System.out.println(paseDeLalo.puedoIngresar(pulpitoGiratorio)); //true: se espera que pueda pasar porque es apto menor (Paquete Infantil)
		System.out.println(paseDeLalo.puedoIngresar(simuladorSpiderman)); //false: se espera que no pueda pasar porque no es apto menor (Paquete Infantil)
		System.out.println(paseDeEmir.puedoIngresar(restoAleman)); //true: se espera que pueda pasar (Paquete Experiencia Completa)

		//ATRACCION EN MANTENIMIENTO
		restoPrincesas.setEnMantenimiento(); //ponemos el restaurant en mantenimiento
		System.out.println(paseDeEmir.puedoIngresar(restoPrincesas)); //false: más allá del paquete, el restaurant esta en mantenimiento.
		System.out.println(" ");

		//PRUEBA DE EXCEPCION

		System.out.println("Prueba de Excepciones");

		try {
			System.out.println(paseDeTobi.puedoIngresar(pulpitoGiratorio));  //true: este acceso debería funcionar
			System.out.println(paseDeTobi.puedoIngresar(restoPrincesas)); //false: este acceso no tiene que funcionar ni restar usos porque la atraccion esta en mantenimiento
			System.out.println(paseDeTobi.puedoIngresar(restoAleman)); //true: este acceso debería funcionar también
			System.out.println(paseDeTobi.puedoIngresar(restoAvengers));  //excepcion: este acceso debería lanzar la excepción, ya que no hay más usos.
		} catch (PaqueteAgotadoException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}
		
		
	}
}
