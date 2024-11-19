package servicios;

public class Servicio implements Inclusivo{

    private boolean enMantenimiento;
    private boolean aptoInfantil;
    private boolean inclusivo;

    public Servicio(boolean esInclusivo) {
        this.inclusivo = esInclusivo;
    }

    @Override
    public int nivelDeInclusion() {
        return inclusivo ? 5 : 1;  // Si es inclusivo, nivel 5, sino nivel 1
    }


    public void setEnMantenimiento(){
        this.enMantenimiento = true;
    }

    public void setAptoInfantil(){
        this.aptoInfantil = true;
    }

    public boolean estaEnMantenimiento(){
        return this.enMantenimiento;
    }

    public boolean esAptoInfantil(){
        return this.aptoInfantil;
    }

    public boolean esInclusivo() {
        return inclusivo;
    }

}
