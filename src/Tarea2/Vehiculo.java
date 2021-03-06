package Tarea2;


/**
 *
 * @author Fer
 */

import java.util.Comparator;

/**
 *
 * @author Fernando Fernández Robledo
 * Creamos la clase vehículo tal como nos pide el ejercicio
 * @return
 *
 */
class Vehiculo implements Comparable<Vehiculo>{

    private String marca, matricula, Nprop, descripcion, Dniprop;
    private int km;
    private double precio;


    public Vehiculo() {
    }

    public Vehiculo(String marca, String matricula, String Nprop, String descripcion, String Dniprop, int km, double precio) {
        this.marca = marca;
        this.matricula = matricula;
        this.Nprop = Nprop;
        this.descripcion = descripcion;
        this.Dniprop = Dniprop;
        this.km = km;
        this.precio = precio;


    }

    @Override
    public int compareTo (Vehiculo o){
        if (this.matricula.compareTo(o.matricula) >= 0){
            return 1;
        } else if (this.matricula.compareTo(o.matricula) <= 0){
            return -1;
        }
        return 0;

    }



    @Override
    public String toString() {
        return "[El vehiculo marca " + marca + ", con matricula "
                + matricula + ", pertenece a " + Nprop
                + ", con DNI " + Dniprop + ".\nTiene un total de "
                + km + " kms. y un precio de " + precio
                + " euros." + "\nDescripción: " + descripcion + "]";
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNprop() {
        return Nprop;
    }

    public void setNprop(String Nprop) {
        this.Nprop = Nprop;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDniprop() {
        return Dniprop;
    }

    public void setDniprop(String Dniprop) {
        this.Dniprop = Dniprop;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void masKm(int km){
        this.km += km;
    }


}


