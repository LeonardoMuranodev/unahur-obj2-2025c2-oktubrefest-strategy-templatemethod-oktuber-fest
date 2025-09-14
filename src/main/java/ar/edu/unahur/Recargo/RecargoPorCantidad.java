package ar.edu.unahur.Recargo;

import ar.edu.unahur.obj2.Carpa;

public class RecargoPorCantidad implements Recargable{
    @Override
    public Double precioRecargo(Carpa unaCarpa) {
        var precio = unaCarpa.getMarcaDeCerveza().getPrecioPorLitro();
        if (unaCarpa.getCantidadPersonas() >= unaCarpa.getLimiteGente()) {
            return precio * 0.4;
        } else {
            return precio * 0.25;
        }
    }
}
