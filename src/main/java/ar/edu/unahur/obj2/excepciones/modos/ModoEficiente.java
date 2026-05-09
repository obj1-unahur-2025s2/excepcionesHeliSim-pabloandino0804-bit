package ar.edu.unahur.obj2.excepciones.modos;

public class ModoEficiente extends Modo{
    @Override
    public Integer getConsumo(){
        return 14;
    }

    @Override
    public Integer getVelocidadMax(){
        return 180;
    }
}
