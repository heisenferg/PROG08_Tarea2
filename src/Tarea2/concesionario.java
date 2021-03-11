package Tarea2;


/**
 *
 * @author Fernando Fernández Robledo
 */


public class concesionario {


    private Vehiculo[] listVehiculo;
    private int Nvehiculos;
    public static final int CAPACIDAD = 50;
    public static final int GUARDADO = 0;
    public static final int LLENO = -1;
    public static final int MATRICULA_GUARDADA = -2;

    /*Declaramos el constructor inicializando el número de vehículos en 0
    y determinando el array con el máximo de capacidad.
    */


    public concesionario() {
        Nvehiculos = 0;
        listVehiculo = new Vehiculo[CAPACIDAD];
    }

    //BUSCAR VEHÍCULO

    public String buscarVehiculo (String matricula){
        for (int i=0; i<Nvehiculos;i++){
            if (listVehiculo[i].getMatricula().equals(matricula)){
                return listVehiculo[i].toString();
            }
        }
        return null;
    }

    /*
    Insertar vehículo con los parámetros que le pasamos.
    Determinamos que busque la matrícula y si está guardada, nos devuelva
    MATRICULA_GUARDADA que le indicamos previamente que era -2
    Si el número de vehículos guardados es igual a la capacidad máxima, nos devuelve
    LLENO que le indicamos que era -1; y si no, se guarda y nos devuelve
    GUARDADO, que le indicamos que equivalía a 0.
    */
    public int insertarVehiculo(String marca, String matricula, String descripcion, String Nprop, String Dniprop, int km, double precio){
        if (buscarVehiculo(matricula) != null){
            return MATRICULA_GUARDADA;
        }else if(Nvehiculos == listVehiculo.length){
            return LLENO;
        }else {
            Vehiculo vehiculo = new Vehiculo (marca, matricula, descripcion, Nprop, Dniprop, km, precio);
            listVehiculo [Nvehiculos] = vehiculo;
            Nvehiculos++;
            return GUARDADO;
        }
    }

    /*
    Para mostrar los vehículos guardados por pantalla. Nos muestra el String
    creado en la clase vehículo.
    */
    public void listarVehiculo(){
        for (int i =0; i<Nvehiculos; i++){
            System.out.println((i+1)+". " + listVehiculo[i].toString());
        }
    }

    /*
    Para actualizar los Km que le dimos en un primer momento para cambiarlos
    por los nuevos que nos pida por consola.
    */
    public boolean actualizarKM (String matricula, int km){
        for (int i=0; i<Nvehiculos; i++){
            if (listVehiculo[i].getMatricula().equals(matricula)){
                listVehiculo[i].setKm(km);
                return true;
            }
        }
        return false;
    }
}





