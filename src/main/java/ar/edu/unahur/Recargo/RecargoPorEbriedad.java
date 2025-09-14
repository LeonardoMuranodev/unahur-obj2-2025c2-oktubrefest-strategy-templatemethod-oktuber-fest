package ar.edu.unahur.Recargo;

import ar.edu.unahur.obj2.Carpa;

public class RecargoPorEbriedad implements Recargable{
    @Override
    public Double precioRecargo(Carpa unaCarpa) {
        var precio = unaCarpa.getMarcaDeCerveza().getPrecioPorLitro();
        if (unaCarpa.ebrios().size() >= unaCarpa.getCantidadPersonas() * 0.75) {
            return precio * 0.5;
        } else {
            return precio * 0.20;
        }
    }
}
