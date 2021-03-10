/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fer
 */
public class CuentaCorrientePersonal extends CuentaBancaria {
    double comision;
    String entidades_cobro;
/*
Constructor
 */

    /**
     * @param saldo
     * @param iban
     * @param p1
     * @param entidades_cobro
     * @param comision
     */
    public CuentaCorrientePersonal(double saldo, String iban, Persona p1, String entidades_cobro, double comision) {
        super(saldo, iban, p1);
        this.entidades_cobro = entidades_cobro;
        this.comision = comision;
    }

    /**
     * @return comision
     */
    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    /**
     * @return string con todos los datos de la cuenta corriente personal.
     */
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + " con una comisión de mantenimiento de "  + comision + "%, y pudiendo realizar cobros enla cuenta: " + entidades_cobro + ".";

    }
    public String toString() {
        return "CuentaCorrientePersonal{" +
                "saldo=" + saldo +
                ", iban='" + iban + '\'' +
                ", entidades_cobro='" + entidades_cobro + '\'' +
                ", comision=" + comision +
                '}';
    }

    @Override
    public double getSaldo() {
        return saldo - comision;
    }


    @Override
    public boolean retiradaCuenta(double retirada) {
        if (saldo > retirada) {
            saldo = saldo - retirada;

        } else
            System.out.println("No hay saldo disponible.");
        return false;

    }

}