package ar.edu.unahur.obj2.marcas;

public class Reglamento {
    private Double graduacionReglamentaria = 10.0;
    private static Reglamento instance = new Reglamento();

    private Reglamento() {};

    public Double getGraduacionReglamentaria() {
        return graduacionReglamentaria;
    }

    public static Reglamento getInstance() {
        return instance;
    }

    public void setGraduacionReglamentaria(Double graduacionReglamentaria) {
        this.graduacionReglamentaria = graduacionReglamentaria;
    }
}
