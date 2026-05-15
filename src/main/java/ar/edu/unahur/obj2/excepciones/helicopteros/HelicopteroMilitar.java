package ar.edu.unahur.obj2.excepciones.helicopteros;

import ar.edu.unahur.obj2.excepciones.misExepciones.MisionAbortadaException;
import ar.edu.unahur.obj2.excepciones.modos.ModoAgresivo;

public class HelicopteroMilitar extends Helicoptero{
    private Double minimoAgresivo = 20.0;

    public HelicopteroMilitar(double combustibleInicial, double capacidad) {
        super(combustibleInicial, capacidad);
    }

    @Override
    protected void validarEstadoDeDespegue() {
        super.validarEstadoDeDespegue();
        Boolean esAgresivo = this.getModoVuelo() instanceof ModoAgresivo;
        Boolean tieneCombustiblebajo = this.getCombustible() < minimoAgresivo;
        if(esAgresivo && tieneCombustiblebajo){
            throw new MisionAbortadaException(
                "Modo agresivo activo con solo "
                + getCombustible() +
                " litros. Se requiere al menos "
                + minimoAgresivo +
                " litros para operar este modo."
            );
        }
    }

    @Override
    protected String mensaje() {
        return "Sistemas de armas y navegación activados";
    }

    @Override
    protected void finalizarVuelo(double kilometrajeDado) {
        agregarMensaje("Mision completa: " + kilometraje + " km. Regresando a base.");
    }

}
