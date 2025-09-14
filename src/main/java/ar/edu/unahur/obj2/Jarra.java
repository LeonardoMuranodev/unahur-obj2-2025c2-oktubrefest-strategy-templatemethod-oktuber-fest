package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.Nacionalidad.Nacionalidad;
import ar.edu.unahur.obj2.marcas.Marca;

public class Jarra {
    private Double capacidad;
    private Marca marca;
    private Carpa carpaOrigen;

    public Jarra(Double capacidad, Marca marca, Carpa carpaOrigen) {
        this.capacidad = capacidad;
        this.marca = marca;
        this.carpaOrigen = carpaOrigen;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public Marca getMarca() {
        return marca;
    }

    public Nacionalidad getNacionalidad() {
        return marca.getPaisFabricante();
    }

    public Carpa getCarpaOrigen() {
        return carpaOrigen;
    }

    public Double contenidoDeAlcohol() {
        return this.marca.graduacionAlcohol() * this.capacidad;
    }

    //Requerimientos Bonus
    public Double precioVentaFinal() {
        return carpaOrigen.precioVentaCerveza() * capacidad;
    }
}
