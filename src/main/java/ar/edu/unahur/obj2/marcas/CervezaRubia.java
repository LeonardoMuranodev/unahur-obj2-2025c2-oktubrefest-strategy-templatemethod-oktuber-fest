package ar.edu.unahur.obj2.marcas;

public class CervezaRubia extends Marca{

    private Double graduacionAlcohol;

    public CervezaRubia(Double graduacionAlcohol) {
        this.graduacionAlcohol = graduacionAlcohol;
    }

    @Override
    public Double graduacionAlcohol() {
        return graduacionAlcohol;
    }
}
