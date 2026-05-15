package ar.edu.unahur.obj2.excepciones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

import ar.edu.unahur.obj2.excepciones.helicopteros.Helicoptero;
import ar.edu.unahur.obj2.excepciones.helicopteros.HelicopteroCivil;
import ar.edu.unahur.obj2.excepciones.helicopteros.HelicopteroMilitar;
import ar.edu.unahur.obj2.excepciones.modos.*;
import ar.edu.unahur.obj2.excepciones.misExepciones.EstadoInvalidoException;
import ar.edu.unahur.obj2.excepciones.misExepciones.MisionAbortadaException;


public class HelicopteroTest {

    private Helicoptero heliCivil;
    private Helicoptero heliMilitar;

    @BeforeEach
    void setUp(){
        heliCivil = new HelicopteroCivil(100.00, 350.0);
        heliMilitar = new HelicopteroMilitar(19.0, 350.0);
    }
    
    /*Tests constructores*/
    @Test
    void dadoCombustibleNegativo_CuandoSeCreaUnHeliCivil_SeLanzaraElEstadoInvalido() {
       assertThrows(
            EstadoInvalidoException.class, 
            () -> new HelicopteroCivil(-1.1, 200.0)
        );
    }
    
    @Test
    void dadoCombustibleNegativo_CuandoSeCreaUnHeliMilitar_SeLanzaraElEstadoInvalido() {
       assertThrows(EstadoInvalidoException.class, () -> new HelicopteroMilitar(-1.1, 200.0));
    }

    /*Tests de getters */
    @Test
    void cuandoSeConsultaSuCombustibleElHelicopteroDevuelveElCombustibleInicial() {
        assertEquals(heliCivil.getCombustible(), 100.0);
    }

    @Test
    void cuandoSeConsultaSuKmElHelicopteroEnviaElKilometraje() {
        assertEquals(heliCivil.getKilometraje(), 0.0);
    }

    @Test
    void cuandoSeConsultaSuCapacidadElHelicopteroDevuelveLaCpacidadMax() {
        assertEquals(heliCivil.getCapacidad(), 350.0);
    }

    /*Tests de consulta */
    @Test
    void EnModoEficienteElHelicopteroDevuelveElNombreDelModo() {
        Modo eficiente = new ModoEficiente();
        heliCivil.cambiarModo(eficiente);
        assertEquals(heliCivil.getModoVuelo().getNombre(), "Eficiente");
    }

    @Test
    void EnModoNormalElHelicopteroDevuelveElNombreDelModo1() {
        Modo normal = new ModoNormal();
        heliCivil.cambiarModo(normal);
        assertEquals(heliCivil.getModoVuelo().getNombre(), "Normal");
    }
    
    @Test
    void EnModoAgresivoElHelicopteroDevuelveElNombreDelModo() {
        Modo agresivo = new ModoAgresivo();
        heliCivil.cambiarModo(agresivo);
        assertEquals(heliCivil.getModoVuelo().getNombre(), "Agresivo");
    }

    
    /*Tests de helicoptero militar*/
    @Test
    void SiUnHeliMilitarTienePocoCombustibleYSuModoEsAgresivoLanzaraUnError() {
        Modo modoAgresivo = new ModoAgresivo();
        heliMilitar.cambiarModo(modoAgresivo);
        assertThrows(
            MisionAbortadaException.class, 
            () -> heliMilitar.volar(23.0, true)
        );
    }
}
