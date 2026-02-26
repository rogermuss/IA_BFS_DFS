package algoritmos_de_busqueda;

import estructuras_de_datos.grafo.Grafo;
import estructuras_de_datos.pila.Pila;
import file_uploaders.ManejadorArchivos;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    private Grafo grafo;

    public DFS(Grafo grafo){
        this.grafo = grafo;

    }

    public void imprimirVisitados(List<Integer> visitados, int x){
        System.out.print("Visitados: ");
        for(int vertice : visitados){
            System.out.print(" | " + vertice);
        }
        System.out.println(" |");
        System.out.println("Vertice encontrado: " + x);
    }
    public void imprimirSaltoDeLinea(){
        System.out.println("\n");
    }

    public void busqueda(int inicio, int x){
        List<Integer> visitados = new ArrayList<>();
        Pila<Integer> pila = new Pila<>(10000000);
        pila.push(inicio);

        while(!pila.isEmpty()){
            System.out.println("Pila antes de pop: " + pila);
            System.out.println("Visitados: " + visitados);
            int vertice = pila.pop();
            visitados.add(vertice);
            imprimirSaltoDeLinea();
            if(x == vertice){
                imprimirVisitados(visitados, vertice);
                imprimirSaltoDeLinea();
                return;
            }
            else {
                System.out.println("Visitando nodo: " + vertice);
                grafo.getAdyacentes(vertice).forEach(arista -> pila.push(arista.getDestino()));
            }
        }
        System.out.println("No se encontro el vertice en el grafo");
    }


    public static void main(String[] args) {
        DFS dfs = new  DFS(ManejadorArchivos.cargarGrafoTXT());
        dfs.busqueda(1, 9);


    }
}
