import java.util.LinkedList;

public class Banco {

    private LinkedList<CuentaBancaria> bancaria = new LinkedList<CuentaBancaria>();
    double ingreso;
    double retirada;
    double saldo;
    CuentaBancaria cuenta = new CuentaBancaria();

    //Constructor
    public Banco(){
        bancaria = new LinkedList<CuentaBancaria>();
    }

    //Get y set.

    public LinkedList<CuentaBancaria> getBancaria() {
        return bancaria;
    }

    public void setBancaria(LinkedList<CuentaBancaria> bancaria) {
        this.bancaria = bancaria;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public double getRetirada() {
        return retirada;
    }

    public void setRetirada(double retirada) {
        this.retirada = retirada;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    //ABRIR CUENTA.

    public boolean abrirCuenta(CuentaBancaria cuenta){
            bancaria.add(cuenta);
            System.out.println("Cuenta bancaria creada.");
            return true;
    }

    //LISTADO CUENTAS.
    public void listadoCuentas(){
        for (CuentaBancaria cuenta: bancaria){
            System.out.println(cuenta.devolverInfoString());
        }
    }



    //INFORMACIÓN CUENTA. PIDEN IBAN.

    public String informacionCuenta(String iban){
        for (CuentaBancaria cuenta: bancaria){
            if (cuenta.getIban().equalsIgnoreCase(iban)){
                System.out.println(cuenta.devolverInfoString());
                break;
            }
            System.out.println("No existe la cuenta.");
        }
        return null;
    }


    //INGRESO DINERO EN CUENTA. PIDE IBAN E INGRESO

    public boolean ingresoCuenta(String iban, double ingreso){
        if (ingreso == 0) {
            throw new IllegalArgumentException("El importe a ingresar no puede ser cero.");
        }
        if (ingreso < 0) {
            throw new IllegalArgumentException("El importe a ingresar no puede ser negativo.");
        }
        for (CuentaBancaria cuenta: bancaria){
            if (cuenta.getIban().equalsIgnoreCase(iban)){
                cuenta.saldoActualizado(ingreso);
                System.out.println("El ingreso de " + ingreso + " €, se realizó correctamente");
                break;
            }
            System.out.println("No existe la cuenta.");
        }
        return false;
    }



    //-------------------------------------

    private CuentaBancaria buscarCuenta (String iban){
        CuentaBancaria cCuenta = null;
        for (CuentaBancaria cuenta: bancaria){
            if (cuenta.getIban().equals(iban)) {
                cCuenta = cuenta;
            }
        }
        return cCuenta;
    }


    //SACAR DINERO DE LA CUENTA. PIDE IBAN Y CANTIDAD A RETIRAR.

    public boolean retiradaCuenta(String iban, double retirada){
        if (retirada == 0) {
            throw new IllegalArgumentException("El importe a retirar no puede ser cero.");
        }
        if (retirada < 0) {
            throw new IllegalArgumentException("El importe a retirar no puede ser negativo.");
        }

        CuentaBancaria cCuenta = buscarCuenta(iban);
        if (cCuenta != null){
            return cCuenta.retiradaCuenta(retirada);
        }

        System.out.println("No existe la cuenta.");
        return false;
    }


    //VER SALDO.

    public double obtenerSaldo(String iban){
        for (CuentaBancaria cuenta: bancaria){
            if (cuenta.getIban().equals(iban)){
                System.out.println("El saldo de la cuenta es de " + cuenta.getSaldo() + " euros.");
            }
        }
        return -1;
    }
        //ELIMINAR CUENTA.

    public void eliminarCuenta(String iban) {
        CuentaBancaria cCuenta = buscarCuenta(iban);
        for (CuentaBancaria cuenta : bancaria) {

            if (cCuenta == null){
                System.out.println("No existe esa cuenta bancaria.");
                break;
            }
            else if (cCuenta != null) {

                if (cCuenta.getSaldo() == 0) {
                    bancaria.remove(cCuenta);
                    System.out.println("La cuenta perteneciente a " + cCuenta.getP1().devolverInfoString() + " ha sido eliminada correctamente.");
                    break;
                } else if (cCuenta.getSaldo() != 0)
                System.out.println("El saldo de la cuenta no es cero.");
                break;
            }

        }

    }
}

