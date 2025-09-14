package ar.edu.unahur.Recargo;

import ar.edu.unahur.obj2.Carpa;

public class RecargoFijo implements Recargable{

    @Override
    public Double precioRecargo(Carpa unaCarpa) {
        return unaCarpa.getMarcaDeCerveza().getPrecioPorLitro() * 0.3;
    }
}
