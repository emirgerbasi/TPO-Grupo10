package paquetes;

import servicios.Servicio;

public class PaqueteExperienciaCompleta extends Paquete {

	public boolean puedoIngresar(Servicio servicioAIngresar)  {
		return !servicioAIngresar.estaEnMantenimiento();
	}

}
