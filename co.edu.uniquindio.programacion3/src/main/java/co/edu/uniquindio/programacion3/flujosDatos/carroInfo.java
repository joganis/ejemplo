package co.edu.uniquindio.programacion3.flujosDatos;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class carroInfo {


    public class CarroInfo {

        private static final String ARCHIVO_CARROS = "";

        public static void main(String[] args) {
            // Crear algunos datos de carros de ejemplo
            List<String> carros = new ArrayList<>();
            carros.add("Toyota;Camry;2020");
            carros.add("Honda;Civic;2019");

            // Escribir los datos en el archivo
            escribirEnArchivo(carros, ARCHIVO_CARROS);

            // Leer los datos del archivo
            List<String> carrosLeidos = leerArchivo(ARCHIVO_CARROS);
            for (String carro : carrosLeidos) {
                System.out.println(carro);
            }
        }

        private static void escribirEnArchivo(List<String> datos, String archivo) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, true))) {
                for (String dato : datos) {
                    writer.println(dato);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static List<String> leerArchivo(String archivo) {
            List<String> datos = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    datos.add(linea);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return datos;
        }
    }

}
