package ar.edu.unahur.obj2.excepciones.helicopteros;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.excepciones.modos.Modo;

public class Helicoptero {
    protected Modo modoDeVuelo;
    protected Integer combustible;
    protected Integer kilometraje;
    protected Integer capacidad;
    protected Integer reserva;
    protected List<String> bitácora = new ArrayList<>();
}