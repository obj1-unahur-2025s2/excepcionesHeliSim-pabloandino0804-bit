package ar.edu.unahur.obj2.excepciones.helicopteros;

import java.util.List;
import ar.edu.unahur.obj2.excepciones.modos.Modo;

public abstract class HelicopteroCivil extends Helicoptero{

    public HelicopteroCivil(double combustibleInicial, double capacidad, Modo modoVuelo) {
        super(combustibleInicial, capacidad, modoVuelo);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected  String doAntesDeVolar() {
        agregarMensaje("Unimplemented method 'doAntesDeVolar'");
    }

    public void doAlFinalizar(){
        agregarMensaje("Vuelo civil completado [] km. Pasajeros desembarcados.")
    }
}
