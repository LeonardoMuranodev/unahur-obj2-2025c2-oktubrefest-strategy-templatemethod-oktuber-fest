package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.Recargo.Recargable;
import ar.edu.unahur.obj2.marcas.Marca;

public class Carpa {
    private Integer limiteGente;
    private final Boolean tieneBanda;
    private Marca marcaDeCerveza;
    private List<Persona> personas = new ArrayList<Persona>();
    private Recargable recargo;

    //Contructor

    public Carpa(Integer limiteGente, Boolean tieneBanda, Marca marcaDeCerveza, List<Persona> personas) {
        this.limiteGente = limiteGente;
        this.tieneBanda = tieneBanda;
        this.marcaDeCerveza = marcaDeCerveza;
        this.personas = personas;
    }

    // Getters y Setters
    public Integer getLimiteGente() {
        return limiteGente;
    }

    public Boolean getTieneBanda() {
        return tieneBanda;
    }

    public Marca getMarcaDeCerveza() {
        return marcaDeCerveza;
    }

    public Integer getCantidadPersonas() {
        return personas.size();
    }

    public Recargable getRecargo() {
        return recargo;
    }

    public void setRecargo(Recargable recargo) {
        this.recargo = recargo;
    }

    public List<Persona> ebrios() {
        return personas.stream().filter(p -> p.estaEbria()).toList();
    }

    //Requerimientos 2da parte

    public Boolean dejaIngresar(Persona unaPersona) {
        return this.limiteGente > this.getCantidadPersonas()  && !unaPersona.estaEbria();
    }

    public Boolean puedeIngresarUnaPersona(Persona unaPersona) {
        return unaPersona.quiereEntrar(this) && this.dejaIngresar(unaPersona);
    }

    public void personaIngresaEnLaCarpa(Persona unaPersona) {
        if (this.puedeIngresarUnaPersona(unaPersona)) {
            personas.add(unaPersona);
        } else {
            throw new RuntimeException("No puede ingresar a la carpa") ;
        }
    }

    public void servirJarra(Persona unaPersona, Double capacidad) {
        if (!personas.contains(unaPersona)) {
            throw new RuntimeException("La persona no esta en la carpa");
        } else {
            unaPersona.comprarJarra(new Jarra(capacidad, marcaDeCerveza, this));;
        }
    }

    public List<Persona> ebriosEmpedernidos() {
        return personas.stream().filter(p -> p.esEbrioEmpedernido()).toList();
    }

    //Requerimientos avanzados

    public Boolean esHomogenea() {
        var primeraNacionalidad = personas.get(0).getNacionalidad();
        return personas.stream().allMatch(p -> p.getNacionalidad() == primeraNacionalidad);
    }

    public List<Persona> noSeLesSirvio() {
        return personas.stream().filter(p -> !p.carpasDondeLeSirvieron().contains(this)).toList();
    }

    //Bonus

    public Double precioVentaCerveza() {
        return getMarcaDeCerveza().getPrecioPorLitro() + recargo.precioRecargo(this);
    }
}
