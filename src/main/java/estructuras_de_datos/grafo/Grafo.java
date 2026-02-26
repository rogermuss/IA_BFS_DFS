package estructuras_de_datos.grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Grafo {

    private final int numVertices;
    private final List<List<Arista>> adyacencia;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.adyacencia = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            adyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int u, int v) {
        if (u < 0 || u >= numVertices || v < 0 || v >= numVertices) {
            throw new IllegalArgumentException("Índices de vértice fuera de rango");
        }

        Arista a = new Arista(u, v);
        Arista a2 = new Arista(v, u);
        adyacencia.get(u).add(a);
        adyacencia.get(v).add(a2);
    }

    public boolean eliminarArista(int u, int v){
        return adyacencia.get(u).removeIf(a -> a.getOrigen() == u && a.getDestino() == v);
    }

    public int getNumVertices() {
        return numVertices;
    }

    public List<Arista> getAdyacentes(int vertice) {
        if (vertice < 0 || vertice >= numVertices) {
            return Collections.emptyList();
        }
        return adyacencia.get(vertice);
    }
}
