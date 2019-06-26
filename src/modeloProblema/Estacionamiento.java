package modeloProblema;

import java.util.ArrayList;
import gestorArchivos.gestorAutomoviles;
import java.io.IOException;

public class Estacionamiento {

    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public Estacionamiento() {

    }

    public void agregarVehiculo(String patente, String modelo, Tipo tipo, int tiempo, double valor) {
        vehiculos.add(new Vehiculo(patente, modelo, tipo, tiempo, valor));
    }

    public void removerVehiculo(int posicion) {
        vehiculos.remove(posicion);
    }

    public boolean cargarVehiculos(String ubicacionArchivo) throws IOException {
        gestorAutomoviles gestor = new gestorAutomoviles();
        boolean existencia = gestor.validarExistencia(ubicacionArchivo);
        if (existencia) {
            ArrayList<String[]> datos = gestor.ObtenerDatos(ubicacionArchivo, existencia);
            for(int i = 0; i < datos.size(); i++){
                vehiculos.add(new Vehiculo(datos.get(i)[0],datos.get(i)[1],StringToTipo(datos.get(i)[2]),Integer.parseInt(datos.get(i)[3]),Double.parseDouble(datos.get(i)[4])));
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String mensaje = "";
        for (int i = 0; i < vehiculos.size(); i++) {
            mensaje = mensaje + vehiculos.get(i).toString() + "\n";
        }
        return mensaje;
    }
    
    public Tipo StringToTipo(String tipo){
        return Tipo.valueOf(tipo.toUpperCase());
    }
    
    public boolean validarPatente(String patente){
        return patente.length() == 6;
    }
    
    public double calcularValor(int tiempo){
        return 25*tiempo;
    }
}
