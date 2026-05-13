package ar.edu.unahur.obj2.excepciones.helicopteros;

import ar.edu.unahur.obj2.excepciones.modos.Modo;

public class HelicopteroCivil extends Helicoptero{

    public HelicopteroCivil(double combustibleInicial, double capacidad, Modo modoVuelo) {
        super(combustibleInicial, capacidad, modoVuelo);
    }

    @Override
    protected String mensaje() {;
        return "Pasajeros y equipaje verificados. Listo para despegue"; 
    }

    @Override
    protected void finalizarVuelo(double kilometrajeDado) {
        agregarMensaje("Vuelo civil completado" + kilometraje + "km. Pasajeros desembarcados.");
    }
}
