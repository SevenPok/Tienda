package Tiendita.TDA.Doble;

import Tiendita.Objetos.Herramientas;
import Tiendita.Objetos.Prototype.Clonar;

public class ListaCircularDoble<T> implements Clonar {

    private Nodo<T> cabeza;
    private int size;

    public ListaCircularDoble() {
        cabeza = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public void addInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato, null, null);
        if (isEmpty()) {
            nuevo.setNext(nuevo);
            nuevo.setBack(nuevo);
            cabeza = nuevo;
        } else {
            Nodo<T> fin = cabeza;
            while (fin.getNext() != cabeza) {
                fin = fin.getNext();
            }
            fin.setNext(nuevo);
            nuevo.setBack(fin);
            nuevo.setNext(cabeza);
            cabeza.setBack(nuevo);
            cabeza = nuevo;
        }
        size++;
    }

    public void addFin(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato, null, null);
        if (isEmpty()) {
            addInicio(dato);
        } else {
            Nodo<T> fin = cabeza;
            while (fin.getNext() != cabeza) {
                fin = fin.getNext();
            }
            fin.setNext(nuevo);
            nuevo.setBack(fin);
            nuevo.setNext(cabeza);
            cabeza.setBack(nuevo);
            size++;
        }
    }

    public T removeInicio() throws Exception {
        Nodo<T> fin = cabeza;
        if (isEmpty()) {
            throw new Exception("Esta vacia");
        } else {
            Nodo<T> dato = cabeza;
            fin = fin.getBack();
            cabeza = cabeza.getNext();
            fin.setNext(cabeza);
            cabeza.setBack(fin);
            size--;
            return dato.getDato();
        }
    }

    public T removeFin() throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia");
        } else {
            Nodo<T> fin = cabeza;
            while (fin.getNext() != cabeza) {
                fin = fin.getNext();
            }
            Nodo<T> dato = fin;
            fin = fin.getBack();
            fin.setNext(cabeza);
            cabeza.setBack(fin);
            size--;
            return dato.getDato();
        }
    }

    public T search(T dato) throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia");
        } else {
            Nodo<T> fin = cabeza;
            do {
                if (dato.equals(fin.getDato())) {
                    return fin.getDato();
                }
                fin = fin.getNext();
            } while (fin != cabeza);
            throw new Exception("No se encontro el dato");
        }
    }

    public T search(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia");
        } else {
            if (index == 0) {
                return cabeza.getDato();
            } else if (index == (size - 1)) {
                return cabeza.getBack().getDato();
            } else if (index > 0 && index < (size - 1)) {
                Nodo<T> fin = cabeza;
                for (int i = 0; i < index; i++) {
                    fin = fin.getNext();
                }
                return fin.getDato();
            }
            throw new Exception("No se encontro el dato");
        }
    }

    public T delete(T dato) throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia");
        } else if (dato.equals(cabeza.getDato())) {
            return removeInicio();
        } else {
            Nodo<T> fin = cabeza;
            do {
                if (dato.equals(fin.getDato())) {
                    Nodo<T> aux = fin;
                    aux.getBack().setNext(fin.getNext());
                    aux.getNext().setBack(fin.getBack());
                    size--;
                    return aux.getDato();
                }
                fin = fin.getNext();
            } while (fin != cabeza);
            throw new Exception("No se encontor el dato");
        }
    }

    public T deleteIndex(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia la lista");
        } else if (index == 0) {
            return removeInicio();
        } else if (index == size - 1) {
            return removeFin();
        } else if (index > 0 && index < size) {
            Nodo<T> fin = cabeza;
            for (int i = 0; i < index; i++) {
                fin = fin.getNext();
            }
            fin.getBack().setNext(fin.getNext());
            fin.getNext().setBack(fin.getBack());
            size--;
            return fin.getDato();
        }
        throw new Exception("No se enconto el dato");
    }

    public T peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia");
        } else {
            return cabeza.getDato();
        }
    }

    public void vaciar() {
        cabeza = null;
        size = 0;
    }

    public T[] array() {

        Nodo<T> aux = cabeza;
        Object[] lista = new Object[size];
        int i = 0;
        if (isEmpty()) {

        } else {
            do {
                lista[i] = aux.getDato();
                aux = aux.getNext();
                i++;
            } while (aux != cabeza);
        }
        return (T[]) lista;
    }

    public boolean graphviz() {
        if (!isEmpty()) {
            Nodo<T> aux = cabeza;
            String cadena = "";
            do {
                cadena += "\"" + aux.getDato() + "\"" + "->" + "\"" + aux.getNext().getDato() + "\"" + "\n";
                cadena += "\"" + aux.getDato() + "\"" + "->" + "\"" + aux.getBack().getDato() + "\"" + "\n";
                aux = aux.getNext();
            } while (aux != cabeza);
            Herramientas.graficar(cadena, "Carrito");
            return true;
        }
        return false;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("Esta vacia");
        } else {
            Nodo<T> aux = cabeza;
            do {
                System.out.println(aux.getDato());
                aux = aux.getNext();
            } while (aux != cabeza);
        }
    }

    public static void main(String[] args) {
        ListaCircularDoble<Integer> lista = new ListaCircularDoble<>();
        lista.addInicio(0);
        lista.addFin(1);
        lista.addFin(2);
        lista.addInicio(-1);
        lista.addInicio(-2);
        lista.show();
        System.out.println("");
        try {
            System.out.println("");
            System.out.println(lista.search(1));
        } catch (Exception e) {
        }
        
    }

    @Override
    public Clonar clonar() {
        ListaCircularDoble<T> lista = null;
        try {
            lista = (ListaCircularDoble<T>) clone();
        } catch (Exception e) {
        }
        return lista;
    }
}
