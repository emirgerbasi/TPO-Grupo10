package servicios;

public class Restaurant extends Servicio {

	private boolean vegano;

	public Restaurant(boolean esInclusivo, boolean esVegano) {
		super(esInclusivo);
		this.vegano = esVegano;
	}

	public boolean esVegano() {
		return vegano;
	}
}