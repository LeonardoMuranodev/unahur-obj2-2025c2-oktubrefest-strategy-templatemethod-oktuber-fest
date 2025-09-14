package ar.edu.unahur.obj2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

import ar.edu.unahur.obj2.Nacionalidad.Nacionalidad;
import ar.edu.unahur.obj2.marcas.Marca;

public class Persona {
    private Double peso;
    private List <Jarra> jarrasCompradas = new ArrayList<Jarra>();
    private Boolean escuchaMusicaTradicional;
    private Integer aguante;
    private Nacionalidad nacionalidad;

    //Constructor

    public Persona(Double peso, List<Jarra> jarrasCompradas, Boolean escuchaMusicaTradicional, Integer aguante, Nacionalidad nacionalidad) {
        this.peso = peso;
        this.jarrasCompradas = jarrasCompradas;
        this.escuchaMusicaTradicional = escuchaMusicaTradicional;
        this.aguante = aguante;
        this.nacionalidad = nacionalidad;
    }

    //Getters

    public Boolean getEscuchaMusicaTradicional() {
        return escuchaMusicaTradicional;
    }

    public List<Jarra> getJarrasCompradas() {
        return jarrasCompradas;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public Set<Marca> getMarcas() {
        return jarrasCompradas.stream().map(j -> j.getMarca()).collect(Collectors.toSet());
    }

    //Setters

    public void comprarJarra(Jarra unaJarra) {
        jarrasCompradas.add(unaJarra);
    }

    //Requerimientos 1ra parte

    public  Double alcoholIngerido() {
        return jarrasCompradas.stream().mapToDouble(j -> j.contenidoDeAlcohol()).sum();
    }

    public Boolean estaEbria() {
        return (this.alcoholIngerido() * peso) > this.aguante;
    }

    public Boolean leGusta(Marca unaMarca) {
        return switch(nacionalidad.toString()) {
            case "BELGA" ->
                unaMarca.getLupuloPorLitro() > 4;
            case "CHECO" ->
                unaMarca.graduacionAlcohol() > 0.08;
            case "ALEMAN" ->
                true;
            default ->
                false;
        };
    }

    //Requerimientos 2da parte

    public Boolean quiereEntrar(Carpa unaCarpa) {
        return this.leGusta(unaCarpa.getMarcaDeCerveza()) && this.escuchaMusicaTradicional.equals(unaCarpa.getTieneBanda()) && (nacionalidad.name().equals("ALEMAN") && unaCarpa.getCantidadPersonas() % 2 == 0);
    }

    
    public Boolean esEbrioEmpedernido() {
        return this.estaEbria() && jarrasCompradas.stream().allMatch(j -> j.getCapacidad() > 1.0) ;
    }

    public Boolean esPatriota() {
        return this.jarrasCompradas.stream().allMatch(j -> j.getNacionalidad().equals(this.nacionalidad));
    }

    //Requerimientos avanzados

    public Boolean sonCompatibles(Persona unaPersona) {
        return this.coincidencias(unaPersona) > this.diferencias(unaPersona);
    }

    public Integer coincidencias(Persona unaPersona) {
        return jarrasCompradas.stream().filter(j -> unaPersona.getMarcas().contains(j.getMarca())).toList().size();
    }

    public Integer diferencias(Persona unaPersona) {
        return jarrasCompradas.stream().filter(j -> !unaPersona.getMarcas().contains(j.getMarca())).toList().size();
    }

    public Set<Carpa> carpasDondeLeSirvieron() {
        return jarrasCompradas.stream().map(j -> j.getCarpaOrigen()).collect(Collectors.toSet());
    }

    public Boolean estaEntrandoEnVicio() {
        for(int i = 0; i < jarrasCompradas.size() - 1; i++) {
            if (jarrasCompradas.get(i).getCapacidad() > jarrasCompradas.get(i + 1).getCapacidad()) {
                return false;
            }
        }

        return true;
    }

    //Bonus

    public Double gastoTotal() {
        return jarrasCompradas.stream().mapToDouble(j -> j.precioVentaFinal()).sum();
    }

    public Jarra jarrasMasCara() {
        Double maxPrecio = jarrasCompradas.stream().mapToDouble(j -> j.precioVentaFinal()).max().orElse(0.0);
        return jarrasCompradas.stream().filter(j -> j.precioVentaFinal() == maxPrecio).findFirst().orElse(null);
    }
}
