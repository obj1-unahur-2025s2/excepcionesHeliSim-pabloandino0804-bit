package ar.edu.unahur.obj2.excepciones.helicopteros;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.excepciones.misExepciones.EstadoInvalidoException;
import ar.edu.unahur.obj2.excepciones.misExepciones.UsoDeReservaException;
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
            throw new EstadoInvalidoException(
                "No se puede inicializar un helicoptero con combustible negativo"
                + "valor recibido: " + combustibleInicial
            );
        }
        this.combustible = combustibleInicial;
        this.capacidad = capacidad;
        this.modoVuelo = new ModoEficiente();
    }

    // Metodos que modifican el objeto
    // -------------------------------
    public void volar(Double distanciaKm, Boolean volarHastaDondePueda){
        validarEstadoDeDespegue();

        prepararVuelo();

        ejecutarVuelo(distanciaKm, volarHastaDondePueda);

        finalizarVuelo(kilometraje);
    }
    
    private void ejecutarVuelo(Double distanciaKm, Boolean volarHastaQuePueda){
        Double combustibleNecesario = this.calcularCombustibleNecesario(distanciaKm);

        Boolean usaReserva = this.consumeReserva(combustibleNecesario);

        if(!this.puedeVolar(distanciaKm)){

            if (volarHastaQuePueda){
                volarParcialmente();
                return;
            }

            throw new EstadoInvalidoException("No alcanza el combustible suficiente para vuelo completo");
        };

        this.combustible -= combustibleNecesario;
        this.kilometraje += distanciaKm;
        
        if (usaReserva) {
            throw new UsoDeReservaException(getReserva());
        }
        
    }

    private void volarParcialmente() {
        Double distanciaRecorrida = calcularDistanciaDisponible();

        kilometraje += distanciaRecorrida;

        combustible = 0.0;

        agregarMensaje(
            "Vuelo parcial"
            + distanciaRecorrida
            + "km recorridos hasta agotar combustible"
        );
    }

    protected void agregarMensaje(String mensaje){
        bitácora.add(mensaje);
    }

    private void validarEstadoDeDespegue() {
        if (combustible <= 0.0) {
            throw new EstadoInvalidoException("Combustible insufuciente");
        }
    }

    private void prepararVuelo(){
        this.antesDeVolar();
    }

    private void antesDeVolar(){
        this.agregarMensaje(this.mensaje());
    }

    protected abstract String mensaje();

    protected abstract void finalizarVuelo(double kilometrajeDado);

    protected void cambiarModo(Modo modoVuelo){
        this.modoVuelo = modoVuelo;
    }

    // Metodos de consulta
    // -------------------
    public Boolean consumeReserva(Double combustibleNecesario) {
        return (combustible - combustibleNecesario) < getReserva();
    }

    public Double calcularTiempoVuelo(Double distanciaKm){
        return distanciaKm / modoVuelo.getVelocidadMax();
    }

    public Double calcularDistanciaDisponible() {
        return combustible * modoVuelo.getConsumoPorLitro();
    }

    public boolean puedeVolar(Double distanciaKm) {
        return combustible >= this.calcularCombustibleNecesario(distanciaKm);
    }

    public Double calcularCombustibleNecesario(Double distanciaKm) {
        return distanciaKm / modoVuelo.getConsumoPorLitro();
    }

    // Getters
    // -------
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

    public List<String> getBitacora(){
        return bitácora;
    }
    

    //
    public  Boolean intentarVolar(Double distancia, Boolean puedeVolarHastaAqui){
        try {
            volar(distancia, puedeVolarHastaAqui);
            this.agregarMensaje("Vuelo exitoso");
            return true;
        }catch(UsoDeReservaException e){
            this.agregarMensaje("Vuelo fue realizado utilizando reserva de combustible");
            return true;
        }catch (EstadoInvalidoException e){
            this.agregarMensaje("Vuelo cancelado" + e.getMessage());
            return false;
        }

    }
}