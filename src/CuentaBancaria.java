/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fer
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class  CuentaBancaria implements Imprimible {
    protected double saldo;
    protected String iban;
    Persona p1 = new Persona();



    /*
    Constructores
     */

    public CuentaBancaria() {
    }

    /**
     *
     * @param saldo
     * @param iban
     * @param p1
     */
    public CuentaBancaria(double saldo, String iban, Persona p1) {
        this.saldo = saldo;
        this.iban = iban;
        this.p1 = p1;
    }

    /*
    métodos get y set
     */

    /**
     *
     * @return saldo, iban, cliente, iban
     */
    public double getSaldo() {
        return saldo;
    }

    public String getIban() {
        return iban;
    }

    public Persona getP1() {
        return p1;
    }

    public void setSaldo(double v, double saldo) {
        this.saldo = saldo;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setP1(Persona p1) {
        this.p1 = p1;
    }

    //COMPROBAR IBAN

    /**
     *
     * @param iban
     * @return comprobacion iban
     */
    public static boolean cIban(String iban) {
        boolean comprobar = true;
        Pattern matr = Pattern.compile("[ES]+([0-9]{20})");
        Matcher mat = matr.matcher(iban);
        comprobar = mat.matches();
        return comprobar;
    }

    /**
     *
     * @return
     */

    @Override
    public String devolverInfoString() {
        return "Cuenta Bancaria con un saldo de " +
                this.saldo +
                " euros, cuyo IBAN es " + this.iban + " pertenece a " + this.p1.devolverInfoString() +
                ".";
    }

    //Suma del ingreso.

    /**
     *
     * @param ingreso
     */
    public void saldoActualizado(double ingreso){
        this.saldo += ingreso;
    }


    //Retirada de dinero.

    /**
     *
     * @param retirada
     */
    public void saldoRetirado(double retirada){
        this.saldo -= retirada;
    }

    public boolean retiradaCuenta(double retirada){
        if ((saldo-retirada) >= 0) {
            saldo = saldo - retirada;
            return true;
        } else {
            return false;
        }
    }


}