package ar.edu.unahur.obj2.marcas;

import ar.edu.unahur.obj2.Nacionalidad.Nacionalidad;

public abstract class Marca {
    protected Double lupuloPorLitro;
    private Nacionalidad paisFabricante;
    private Double precioPorLitro;

    public abstract Double graduacionAlcohol();

    public Double getLupuloPorLitro() {
        return lupuloPorLitro;
    }

    public Nacionalidad getPaisFabricante() {
        return paisFabricante;
    }

    public Double getPrecioPorLitro() {
        return precioPorLitro;
    }
}
