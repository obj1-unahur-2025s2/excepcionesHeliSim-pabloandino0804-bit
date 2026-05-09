package ar.edu.unahur.obj2.excepciones.modos;

public class ModoAgresivo extends Modo{
    @Override
    public Integer getConsumo(){
        return 6;
    }

    @Override
    public Integer getVelocidadMax(){
        return 280;
    }
}
