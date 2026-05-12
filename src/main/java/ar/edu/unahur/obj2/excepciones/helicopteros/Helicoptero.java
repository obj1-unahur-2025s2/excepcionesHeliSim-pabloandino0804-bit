package ar.edu.unahur.obj2.excepciones.helicopteros;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.excepciones.misExepciones.CombustibleException;
import ar.edu.unahur.obj2.excepciones.modos.Modo;
import ar.edu.unahur.obj2.excepciones.modos.ModoEficiente;

public abstract class Helicoptero {
    
    protected double combustible;
    protected double kilometraje = 0.0;
    protected double capacidad;
    protected List<String> bitácora = new ArrayList<>();
    protected Modo modoVuelo;

    public Helicoptero(double combustibleInicial, double capacidad, Modo modoVuelo){
        if (combustibleInicial < 0){
            throw new CombustibleException(
                "No se puede inicializar un helicoptero con combustible negativo"
                + "valor recibido: " + combustibleInicial
            );
        }
        this.combustible = combustibleInicial;
        this.capacidad = capacidad;
        this.modoVuelo = new ModoEficiente();
    }

    //Metodos que modifican el objeto
    public void volar(Double distanciaKm, Boolean volarHastaDondePueda){
        validarEstadoDeDespegue();

        prepararVuelo();

        ejecutarVuelo(distanciaKm, volarHastaDondePueda);

        finalizarVuelo(kilometraje);
    }
    
    private void ejecutarVuelo(Double distanciaKm, booleanvolarHastaDonde){
        Double combustibleNecesario = calcularCombustibleNecesario(distanciaKm);
    }

    private void validarEstadoDeDespegue() {
        throw new UnsupportedOperationException("Unimplemented method 'validarEstadoDeDespegue'");
    }

    private void prepararVuelo() {
        throw new UnsupportedOperationException("Unimplemented method 'prepararVuelo'");
    }

    private void ejecutarVuelo(Double distanciaKm, Boolean volarHastaDondePueda) {
        throw new UnsupportedOperationException("Unimplemented method 'ejecutarVuelo'");
    }

    private void finalizarVuelo(double kilometrajeDado) {
        throw new UnsupportedOperationException("Unimplemented method 'finalizarVuelo'");
    }

    //Getters
    public double getCombustible(){
        return combustible;
    }
    
    public double getKilometraje(){
        return kilometraje;
    }

    public double getCapacidad(){
        return capacidad;
    }
    
    //
    private double getReserva(){
        return capacidad * 0.1;
    }

    public Modo getModoVuelo(){
        return modoVuelo;
    }


    public void agregarMensaje(String mensaje){
        this.bitácora.add(mensaje);
    }

    public void antesDeVolar(){
        agregarMensaje(this.doAntesDeVolar());
    }

    protected abstract String doAntesDeVolar();
}