package ar.edu.unahur.obj2.excepciones.modos;

public class ModoEficiente implements Modo{
    @Override
    public double getConsumoPorLitro(){
        return 14.0;
    }

    @Override
    public double getVelocidadMax(){
        return 180.0;
    }

    @Override 
    public String getNombre(){
        return "Eficiente";
    }
}
