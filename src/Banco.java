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

    //SACAR DINERO DE LA CUENTA. PIDE IBAN Y CANTIDAD A RETIRAR.

    public boolean retiradaCuenta(String iban, double retirada) {
        if (retirada == 0) {
            throw new IllegalArgumentException("El importe a retirar no puede ser cero.");
        }
        if (retirada < 0) {
            throw new IllegalArgumentException("El importe a retirar no puede ser negativo.");
        }
       /* for (CuentaBancaria cuenta: bancaria){
            if (cuenta.getIban().equalsIgnoreCase(iban)){
                cuenta.retiradaCuenta(retirada);
                System.out.println("Se han retirado correctamente la cantidad de " + retirada + " €.");
                break;
            }
            System.out.println("No existe la cuenta.");
        }*/

        for (CuentaBancaria cuenta: bancaria){
            if (cuenta.getIban().equalsIgnoreCase(iban)){
                if (cuenta.getSaldo()< retirada) {
                    System.out.println("No hay fondos suficientes.");
                    break;
                }

                cuenta.saldoRetirado(retirada);
                System.out.println("Retirada de dinero realizada correctamente.");
                return true;
            }
        }
       return true;
    }

    //VER SALDO.

    public double obtenerSaldo(String iban){
        for (CuentaBancaria cuenta: bancaria){
            if (cuenta.getIban().equalsIgnoreCase(iban)){
                return cuenta.getSaldo();
            }
        }
        return -1;
    }

/*



//SACAr dinero

    public boolean retiradaCuenta(String iban, float retirada){
        if (retirada == 0) {
            throw new IllegalArgumentException("El importe a retirar no puede ser cero.");
        }
        if (retirada < 0) {
            throw new IllegalArgumentException("El importe a retirar no puede ser negativo.");
        }

        for (int i=0; i<Ncuentas; i++){
            if (listCuenta[i].getIban().equals(iban)){
                if (listCuenta[i].getSaldo()< retirada) {
                    System.out.println("NO hay fondos suficientes.");
                    break;
                }

                listCuenta[i].saldoRetirado(retirada);
                System.out.println("Retirada de dinero realizada correctamente.");
                return true;
            }
        }
        return false;
    }

//Ver saldo.

    public double obtenerSaldo(String iban){
        for (int i=0; i<Ncuentas;i++){
            if (listCuenta[i].getIban().equals(iban)){
                return listCuenta[i].getSaldo();
            }
        }
        return -1;
    }
*/


}

