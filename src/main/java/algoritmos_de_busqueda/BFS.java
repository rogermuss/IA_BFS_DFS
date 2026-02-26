package algoritmos_de_busqueda;

import estructuras_de_datos.cola.ColaSimple;
import estructuras_de_datos.grafo.Grafo;
import file_uploaders.ManejadorArchivos;

import java.util.ArrayList;
import java.util.List;

public class BFS {

    private Grafo grafo;

    public BFS(Grafo grafo){
        this.grafo = grafo;

    }

    public void imprimirVisitados(List<Integer> visitados, int x){
        System.out.print("Lista del Total de Visitados: ");
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
        ColaSimple<Integer> cola = new ColaSimple<>(10000000);
        cola.push(inicio);

        while(!cola.isEmpty()){
            System.out.println("Cola antes de pop: " + cola);
            System.out.println("Visitados: " + visitados);
            int vertice = cola.pop();
            visitados.add(vertice);
            if(x == vertice){
                imprimirSaltoDeLinea();
                imprimirVisitados(visitados, vertice);
                imprimirSaltoDeLinea();
                return;
            }
            else {
                System.out.println("Visitando nodo: " + vertice);
                imprimirSaltoDeLinea();

                grafo.getAdyacentes(vertice).forEach(arista -> {
                    if(!visitados.contains(arista.getDestino())){
                        cola.push(arista.getDestino());
                    }
                });
            }
        }
        System.out.println("No se encontro el vertice en el grafo");
    }



    public static void main(String[] args) {
        Grafo grafo = ManejadorArchivos.cargarGrafoTXT();
        BFS bfs = new BFS(grafo);
        bfs.busqueda(1, 9);

    }
}
