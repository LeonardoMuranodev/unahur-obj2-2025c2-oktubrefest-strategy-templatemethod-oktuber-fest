package ar.edu.unahur.obj2.marcas;

public class CervezaNegra extends Marca{

    public CervezaNegra(Double lupuloPorLitro) {
        this.lupuloPorLitro = lupuloPorLitro;
    }

    @Override
    public Double graduacionAlcohol() {
        return Math.min(lupuloPorLitro * 2, Reglamento.getInstance().getGraduacionReglamentaria());
    }
}
