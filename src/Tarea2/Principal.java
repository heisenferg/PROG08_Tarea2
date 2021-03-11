package Tarea2;

/**
 *
 * @author Fernando Fernández Robledo
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Principal {

    //Método para comprobar el formato de las matrículas introducidas.
    /*
    4 números del 0 al 9
    seguidos de 3 letras. Aunque en el ejercicio poner las letras en
    mayúsculas, he decidido poner las minúsculas también por si el usuario lo
    hace así.
    */

    public static boolean cMatricula(String matricula) {
        boolean comprobar = true;
        Pattern matr = Pattern.compile("([0-9]{4})+([A-Za-z]{3})");
        Matcher mat = matr.matcher(matricula);
        comprobar = mat.matches();
        return comprobar;
    }

    /*
    Para comprobar el formato del nombre.
    Menor de 40 caracteres y de 3 palabras que las dividimos con un espacio.
    */
    public static boolean cNombre(String Nprop) {
        boolean comprobar = true;
        if (Nprop.length() > 40) {
            comprobar = false;
        } else {
            String[] palabra = Nprop.split(" ");
            if (palabra.length != 3) {
                comprobar = false;
            }

        }
        return comprobar;
    }

    /*
    Para comprobar el DNI he utilizado este formato, estableciendo la
    posiblidad de que sea NIF y tenga una X o Y delante.
    A parte, 8  números del 0 al 9 y una letra de la A-Z en mayúscylas
    y en minúsculas (aunque no todas las letras son aceptadas por el DNI, he
    dejado todas por no complicarlo y no poner todas las letras separadas por
    " | ".
    */

    public static boolean cDNI(String Dniprop) {
        boolean comprobar = true;
        Pattern nif = Pattern.compile("^[XYxy]?[0-9]{8}[A-Za-z]$");
        Matcher Nif = nif.matcher(Dniprop);
        comprobar = Nif.matches();
        return comprobar;
    }


    //Método principal

    public static void main(String[] args) {

        //Declaro las variables con las que trabajar.
        String marca, matricula, descripcion, Nprop, Dniprop;
        int opcion, km;
        double precio;
        //Pongo la opción del menú a 0
        opcion = 0;

        Scanner teclado = new Scanner(System.in);

        //Llamo concesionario de la clase concesionario.
        concesionario concesionario = new concesionario();

        //Menú princupal con 5 opciones, siendo la 5 salir.
        while (opcion != 5) {

            try {
                System.out.println("1. Crear vehículo.");
                System.out.println("2. Listar vehículos.");
                System.out.println("3. Buscar vehículos.");
                System.out.println("4. Actualizar Kms.");
                System.out.println("5. Salir.");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        //Creamos el vehículo.

                        //MARCA.
                        System.out.println("Creación del vehículo: ");
                        System.out.println("-----------------------");
                        System.out.print("Introduce la marca: ");
                        marca = teclado.next();

                        //MATRÍCULA.
                        System.out.print("Introduce la matrícula: ");
                        matricula = teclado.next();
                        if (!cMatricula(matricula)) {
                            throw new Exception("La forma de la matrícula no es correcta.");
                        }

                        //KILÓMETROS.
                        System.out.print("Introduce los kms. del vehículo: ");
                        km = teclado.nextInt();

                        //PRECIO DE VENTA
                        System.out.print("Introduce el precio de venta: ");
                        precio = teclado.nextDouble();
                        teclado.nextLine();

                        //NOMBRE Y APELLIDOS DEL PROPIETARIO DEL VEHÍCULO.
                        System.out.print("Introduce nombre y dos apellidos del propietario: ");
                        Nprop = teclado.nextLine();
                        if (!cNombre(Nprop)) {
                            throw new Exception("El formato de nombre/apellidos no es correcto.");
                        }

                        //DNI DEL PROPIETARIO DEL VEHÍCULO.
                        System.out.print("Introduce el DNI del propietario: ");
                        Dniprop = teclado.next();
                        if (!cDNI(Dniprop)) {
                            throw new Exception("El formato del DNI no es el apropiado.");
                        }
                        teclado.nextLine();

                        //DESCRIPCIÓN DEL VEHÍCULO.
                        System.out.print("Introduce la descripción del vehículo: ");
                        descripcion = teclado.nextLine();

                        /*Para que nos informe con 0 si se ha guardado, -1 si existe la matrícula ya
                        o -2 si está lleno el concesionario.
                        */
                        int guardado = concesionario.insertarVehiculo(marca, matricula, Nprop, descripcion, Dniprop, km, precio);
                        switch (guardado) {
                            case -1:
                                System.out.println(concesionario.MATRICULA_GUARDADA);
                                break;
                            case -2:
                                System.out.println(concesionario.LLENO);
                                break;
                            case 0:
                                System.out.println(concesionario.GUARDADO);
                                break;
                            default:
                                break;
                        }

                        break;


                    case 2:
                        //LISTAMOS LOS VEHÍCULOS GUARDADOS.
                        concesionario.listarVehiculo();
                        break;

                    case 3:
                        //BUSCAR VEHÍCULO POR MATRÍCULA.
                        System.out.print("Introduce la matrícula de vehículo a buscar: ");
                        matricula = teclado.next();
                        String busqueda = concesionario.buscarVehiculo(matricula);
                        if (busqueda != null) {
                            System.out.println(busqueda);
                        } else {
                            System.out.println("La matrícula no está guardada.");
                        }
                        break;
                    case 4:
                        //MODIFICAR LOS KILÓMETROS DEL VEHÍCULO GUARDADO PREVIAMENTE.
                        System.out.println("MODIFICAR KMS. DEL VEHÍCULO.");
                        System.out.println("----------------------------");
                        System.out.print("Introduce la matrícula del vehículo a modificar: ");
                        matricula = teclado.next();
                        System.out.print("Introduce los Kms. actualizados: ");
                        km = teclado.nextInt();
                        concesionario.actualizarKM(matricula, km);

                        break;
                }
                //EXCEPCIÓN DEL MENÚ
            } catch (InputMismatchException e) {
                System.out.println("Debe introducir un número entero.");
                teclado.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }
}