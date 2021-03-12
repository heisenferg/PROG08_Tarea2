package Tarea2;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Fernando Fernández Robledo
 */


public class concesionario {

/*
Utilizo una estructura de datos dinámica de tipo HashSet al ser una esta interfaz que es un tipo
de Collection que almacena datos asociando una llave a un valor, lo cual acelera en gran medida
 el acceso a los objetos almacenado dentro de ella.
 Como inconveniente cabría destacar que necesitan mucha memoria y no almacenan los objetos de forma ordenada
 pero en este caso, no estamos tratando con muchos datos (con lo cual el consumo de memoria no será grande en absoluto),
  y nosotros lo ordenamos por matrícula gracias a implementar "Compareto" en la clase Vehículo.
 */
    HashSet<Vehiculo> coches = new HashSet<Vehiculo>();
    public static final int GUARDADO = 0;
    public static final int MATRICULA_GUARDADA = -2;
    Vehiculo vehiculo = new Vehiculo();


    //BUSCAR VEHÍCULO

    public String buscarVehiculo (String matricula){
        Vehiculo v1 = new Vehiculo();
        for (Vehiculo vehiculo: coches){
            if (vehiculo.getMatricula().equals(matricula)){
                 vehiculo = v1;
                 return v1.toString();
            }
        }
        return null;
    }

    /*
    Insertar vehículo con los parámetros que le pasamos.
    Determinamos que busque la matrícula y si está guardada, nos devuelva
    MATRICULA_GUARDADA que le indicamos previamente que era -2 y si no, se guarda y nos devuelve
    GUARDADO, que le indicamos que equivalía a 0.
    */
    public int insertarVehiculo(String marca, String matricula, String descripcion, String Nprop, String Dniprop, int km, double precio){
        if (buscarVehiculo(matricula) != null){
            return MATRICULA_GUARDADA;
        }else {
            Vehiculo v1 = new Vehiculo(marca, matricula, descripcion, Nprop, Dniprop, km, precio);
            coches.add(v1);
            System.out.println("Insertado correctamente.");
            return GUARDADO;
        }
    }

    /*
    Para mostrar los vehículos guardados por pantalla. Nos muestra el String
    creado en la clase vehículo.
    */
    public void listarVehiculo(){
        for (Vehiculo v1: coches){
            System.out.println(v1.toString());
        }
    }

    /*
    Para actualizar los Km que le dimos en un primer momento para cambiarlos
    por los nuevos que nos pida por consola.
    */
    public boolean actualizarKM (String matricula, int km){
        for (Vehiculo v1: coches){
            if (v1.getMatricula().equals(matricula)){
                v1.setKm(km);
                System.out.println("Kilómetros actualizados.");
                return true;
            }
        }
        return false;
    }

    //Método para eliminar vehículos. Pide matricula y elimina si coincide.

    public boolean eliminarVehiculo(String matricula){
        for(Vehiculo v1 : coches) {
            if (v1.getMatricula().equals(matricula)) {
                coches.remove(v1);
                System.out.println("El vehículo ha sido eliminado correctamente.");
                return true;
            }
        }
        return false;
    }

    }







