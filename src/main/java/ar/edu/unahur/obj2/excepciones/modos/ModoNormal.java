package ar.edu.unahur.obj2.excepciones.modos;

public class ModoNormal extends Modo{
    @Override
    public Integer getConsumo(){
        return 9;
    }

    @Override
    public Integer getVelocidadMax(){
        return 220;
    }
}
