package gestorArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class gestorAutomoviles {

    public boolean validarExistencia(String ubicacionArchivo) {
        File f = new File(ubicacionArchivo);
        if (f.exists()) {
            return true;
        }
        return false;
    }

    public ArrayList<String[]> ObtenerDatos(String ubicacionArchivo, boolean existencia) throws FileNotFoundException, IOException {
        if (existencia) {
            String linea;
            ArrayList<String[]> datos = new ArrayList<String[]>();
            FileReader fr = new FileReader(ubicacionArchivo);
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            while ((linea = br.readLine()) != null) {
                datos.add(linea.split(","));
            }
            return datos;
        }
        return null;
    }
}
