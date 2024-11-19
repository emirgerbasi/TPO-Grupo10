package paquetes;

import servicios.Parque;
import servicios.Servicio;

public class PaqueteParqueFav extends Paquete {
	
	private Parque parqueFav;

	public PaqueteParqueFav (Parque parqueElegido) {
		this.parqueFav = parqueElegido;
	}

	public boolean puedoIngresar(Servicio servicioAIngresar) {
		return (parqueFav.contieneServicio(servicioAIngresar)&& !servicioAIngresar.estaEnMantenimiento());
		 
	}

}
