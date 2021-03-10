/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fer
 */
public class CuentaCorrienteEmpresa extends CuentaBancaria{
    double interes_descubierto;
    double maximo_descubierto;
    double comision_descubierto;
    String entidades_cobro;

    /*
    Constructor
     */

    public CuentaCorrienteEmpresa(double saldo, String iban, Persona p1, String entidades_cobro, double interes_descubierto, double maximo_descubierto, double comision_descubierto) {
        super(saldo, iban, p1);
        this.interes_descubierto = interes_descubierto;
        this.maximo_descubierto = maximo_descubierto;
        this.comision_descubierto = comision_descubierto;
        this.entidades_cobro = entidades_cobro;
    }

    /*
    Getter y setter
     */

    public String getEntidades_cobro() {
        return entidades_cobro;
    }

    public void setEntidades_cobro(String entidades_cobro) {
        this.entidades_cobro = entidades_cobro;
    }

    public double getInteres_descubierto() {
        return interes_descubierto;
    }

    public void setInteres_descubierto(double interes_descubierto) {
        this.interes_descubierto = interes_descubierto;
    }

    public double getMaximo_descubierto() {
        return maximo_descubierto;
    }

    public void setMaximo_descubierto(double maximo_descubierto) {
        this.maximo_descubierto = maximo_descubierto;
    }

    public double getComision_descubierto() {
        return comision_descubierto;
    }

    public void setComision_descubierto(double comision_descubierto) {
        this.comision_descubierto = comision_descubierto;
    }

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + " con un interés de descibierto de  "  + interes_descubierto + "%, con una cantidad máxima disponible por descubierto de "
                + maximo_descubierto + " euros,una comisión por descubierto de " + comision_descubierto + " euros. Entidades de cobro: " + entidades_cobro + ".";

    }

    @Override
    public boolean retiradaCuenta(double retirada){
        if ((saldo - retirada) > - maximo_descubierto) {
            double sacado = saldo - retirada;
            saldo = sacado - ( -sacado * (interes_descubierto / 100)) - comision_descubierto;
            System.out.println("Retirada realizada correctamente.");
        }else if ((saldo - retirada) < -maximo_descubierto)
            System.out.println("No puede disponer de más fondos. Ha superado el descubierto permitido.");
        return false;
    }
}