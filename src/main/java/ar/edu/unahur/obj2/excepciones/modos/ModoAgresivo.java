package ar.edu.unahur.obj2.excepciones.modos;

public class ModoAgresivo implements Modo{
    @Override
    public double getConsumo(){
        return 6.0;
    }

    @Override
    public double getVelocidadMax(){
        return 280.0;
    }

    @Override
    public String getNombre(){
        return "Agresivo";
    }
}
