/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fer
 */
public class CuentaAhorro extends CuentaBancaria{
    double tipo_interes;

    /**
     *
     * @param saldo
     * @param iban
     * @param p1
     * @param tipo_interes
     */
/*
Constructores.
 */
    public CuentaAhorro(double saldo, String iban, Persona p1, double tipo_interes) {
        super(saldo, iban, p1);
        this.tipo_interes = tipo_interes;
    }



    public CuentaAhorro() {
    }

    /*
    Métodos get y set.
     */
    public double getTipo_interes() {
        return tipo_interes;
    }

    public void setTipo_interes(double tipo_interes) {
        this.tipo_interes = tipo_interes;
    }

    @Override
    public boolean retiradaCuenta(double retirada) {

        if (retirada < saldo){
            saldo = saldo-retirada;
            return true;
        }else if (saldo < retirada);
            System.out.println("la cantidad tiene que ser inferior al saldo.");
        return false;
    }

    public double getSaldo(double saldo, double tipo_interes){
        double dinero =saldo+ (saldo*tipo_interes);
        return dinero;
    }
    /**
     * ToString que devuelve
     * @return tipo_interes, saldo e iban
     */
    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + " con un tipo de interés porcentual de " + tipo_interes + " %.";

    }




}