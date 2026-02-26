package estructuras_de_datos.pila;

public class Pila<T> {
    T[] pila;
    int tope = -1;

    public Pila(int size){
        pila = (T[]) new Object[size];
    }

    public boolean push(T item){
        if(isFull()){
            return false;}
        tope++;
        pila[tope] = item;
        return true;
    }

    public T pop(){
        if(isEmpty()){return null;}
        T temp = pila[tope];
        pila[tope] = null;
        tope--;

        return temp;
    }

    public T peek(){
        if(isEmpty()){return null;}
        return pila[tope];
    }

    public int size(){
        return tope + 1;
    }

    public boolean isEmpty(){
        return tope==-1;
    }

    public boolean isFull(){
        return tope == pila.length - 1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Pila vacía";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Tope -> | ");
        for (int i = tope; i >= 0; i--) {
            sb.append(pila[i]);
            sb.append(" | ");
        }
        return sb.toString();
    }
}



