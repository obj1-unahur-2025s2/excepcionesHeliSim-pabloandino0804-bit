package ar.edu.unahur.obj2.excepciones.modos;

public class ModoNormal implements Modo{
    @Override
    public double getConsumoPorLitro(){
        return 9.0;
    }

    @Override
    public double getVelocidadMax(){
        return 220.0;
    }

    @Override
    public String getNombre(){
        return "Normal";
    }
}
