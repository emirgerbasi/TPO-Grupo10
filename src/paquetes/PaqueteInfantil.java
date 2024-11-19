package paquetes;

import servicios.Servicio;

public class PaqueteInfantil extends Paquete{
    @Override
    public boolean puedoIngresar(Servicio servicioAIngresar) {
        return (servicioAIngresar.esAptoInfantil() && !servicioAIngresar.estaEnMantenimiento());
    }
}
