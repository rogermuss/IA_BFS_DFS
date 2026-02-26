package estructuras_de_datos.grafo;

public class Arista {

    private final int origen;
    private final int destino;

    public Arista(int origen, int destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public int getOrigen() {
        return origen;
    }

    public int getDestino() {
        return destino;
    }


    @Override
    public String toString() {
        return "Arista{" +
                "origen=" + origen +
                ", destino=" + destino +
                '}';
    }
}
