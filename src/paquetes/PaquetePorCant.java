package paquetes;

import servicios.Servicio;

public class PaquetePorCant extends Paquete {
	
	private int cantRestante = 0;

	public PaquetePorCant (int usosComprados) {
		this.cantRestante = usosComprados;
		}


	@Override
	public boolean puedoIngresar(Servicio servicioAIngresar) throws PaqueteAgotadoException {
		boolean validacion = false;
		if (this.cantRestante <= 0) {
			throw new PaqueteAgotadoException("El paquete ha agotado sus usos disponibles. Puede comprar más.");
		} else if (!servicioAIngresar.estaEnMantenimiento()) {
			this.cantRestante--;  // Decrementa los usos restantes
			validacion = true;
		}
		return validacion;
	}

	public void comprarMasUsos (int usosComprados) {
		this.cantRestante += usosComprados;
	}
}
