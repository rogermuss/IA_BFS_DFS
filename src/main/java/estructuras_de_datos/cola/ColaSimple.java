package estructuras_de_datos.cola;

public class ColaSimple<T> {
    private int inicio = -1;
    private int fin = -1;
    private int max;
    private T[] cola;

    public ColaSimple(int size) {
        cola = (T[]) new Object[size];
        this.max = size;
    }

    public boolean push(T dato) {
        if (isFull()) {
            return false;
        }
        fin++;
        cola[fin] = dato;
        if (inicio == -1) {
            inicio = 0;
        }
        return true;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T dato = cola[inicio];
        if (inicio == fin) {
            inicio = -1;
            fin = -1;
        } else {
            inicio++;
        }
        return dato;
    }

    public T peek() {
        if (isEmpty()) return null;
        return cola[inicio];
    }

    public boolean isEmpty() {
        return inicio == -1;
    }

    public boolean isFull() {
        return fin == max - 1;
    }

    public int size() {
        if (isEmpty()) return 0;
        return fin - inicio + 1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Cola vacía";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Inicio -> | ");
        for (int i = inicio; i <= fin; i++) {
            sb.append(cola[i]);
            sb.append(" | ");
        }
        return sb.toString();
    }

}