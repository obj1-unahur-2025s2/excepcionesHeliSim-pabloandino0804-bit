package ar.edu.unahur.obj2.excepciones.helicopteros;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unahur.obj2.excepciones.modos.Modo;

public class Helicoptero {
    protected Modo modoDeVuelo;
    protected Integer combustible;
    protected Integer kilometraje;
    protected Integer capacidad;
    protected double reserva = capacidad * 0.1;
    protected List<String> bitácora = new ArrayList<>();


    public boolean elCombustibleEsNegatgivo(Integer combustible){
        return this.combustible < 0;
    }

    public void inicializar(Modo vuelo, Integer cantidad) throws Exception{
        try {
            this.gastarCombustible(vuelo, cantidad);
        } catch (Exception combustible) {
            throw new Exception(combustible);
        }
    };

    public void gastarCombustible(Modo vuelo, Integer cantidad){
        this.kilometraje = vuelo.getVelocidadMax() * cantidad;
        this.combustible =- cantidad;
    }
}