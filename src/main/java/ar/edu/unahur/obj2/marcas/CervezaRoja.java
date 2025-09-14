package ar.edu.unahur.obj2.marcas;

public class CervezaRoja extends Marca{
    @Override
    public Double graduacionAlcohol(){
        return new CervezaNegra(lupuloPorLitro).graduacionAlcohol() * 1.25;
    }
}
