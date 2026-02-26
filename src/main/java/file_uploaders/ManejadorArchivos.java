package file_uploaders;

import estructuras_de_datos.grafo.Grafo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SubirGrafo {
    private static String nombreArchivo = "src/main/java/grafos/grafoPrueba.csv";
    public static Grafo cargarGrafoCSV() {
        List<int[]> aristas = new ArrayList<>();
        int maxNodo = -1;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.trim().split(",");
                int origen = Integer.parseInt(partes[0]);
                int destino = Integer.parseInt(partes[1]);
                aristas.add(new int[]{origen, destino});

                // actualizar número máximo de nodo
                maxNodo = Math.max(maxNodo, Math.max(origen, destino)); // Basicamente el numero mayor dicta la cantidad de nodos
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Grafo grafo = new Grafo(maxNodo + 1); // +1 porque los nodos empiezan en 0...

        for (int[] a : aristas) {
            grafo.agregarArista(a[0], a[1]); // Se agrega el par de aristas al grafo
        }
        return grafo;
    }

    public static Grafo cargarGrafoTXT() {
        List<int[]> aristas = new ArrayList<>();
        int maxNodo = -1;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.trim().split(" ");
                int origen = Integer.parseInt(partes[0]);
                int destino = Integer.parseInt(partes[1]);
                aristas.add(new int[]{origen, destino});

                // actualizar número máximo de nodo
                maxNodo = Math.max(maxNodo, Math.max(origen, destino)); // Basicamente el numero mayor dicta la cantidad de nodos
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Grafo grafo = new Grafo(maxNodo + 1); // +1 porque los nodos empiezan en 0...

        for (int[] a : aristas) {
            grafo.agregarArista(a[0], a[1]); // Se agrega el par de aristas al grafo
        }
        return grafo;
    }

    public static void agregarArista(Grafo grafo, int origen, int destino) {
        grafo.agregarArista(origen, destino);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(origen + "," + destino);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarArista(Grafo grafo, String nombreArchivo, int origen, int destino) {
        grafo.eliminarArista(origen, destino);
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.equals(origen + "," + destino)) {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) { e.printStackTrace(); }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }
}
