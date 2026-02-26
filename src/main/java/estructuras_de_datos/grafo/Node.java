package estructuras_de_datos.grafo;

public class Node<T> {
    private T item;
    private int height;

    public Node(T item) {
        this.item = item;
        height = 1;
    }

    public T getItem() { return item; }
    public void setItem(T item) { this.item = item; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }
}

