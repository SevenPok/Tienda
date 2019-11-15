package Tiendita.TDA.Simple;

public class Pila<T> extends ListaSimple<T> {

    public Pila() {
        super();
    }

    public void push(T dato) {
        super.compareTo(dato);
    }

    public T pop() throws Exception {
        return super.removeFin();
    }
}
