package ar.edu.unahur.obj2.excepciones.misExepciones;

public class UsoDeReservaException extends RuntimeException{
    public UsoDeReservaException(Double reserva){
        super("El vuelo uso la reserva de combustible margen: " + reserva + "litros - Recargar antes del proximo vuelo");
    }
}
