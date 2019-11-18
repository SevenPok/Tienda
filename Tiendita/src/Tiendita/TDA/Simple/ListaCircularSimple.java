package Tiendita.TDA.Simple;

import Tiendita.Objetos.Prototype.Clonar;

public class ListaCircularSimple<T> implements Clonar {

    private Nodo<T> cabeza;
    private int size;

    public ListaCircularSimple() {
        cabeza = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    private void addInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            nuevo.setNext(nuevo);
            cabeza = nuevo;
        } else {
            Nodo<T> fin = cabeza;
            while (fin.getNext() != cabeza) {
                fin = fin.getNext();
            }
            fin.setNext(nuevo);
            nuevo.setNext(cabeza);
            cabeza = nuevo;
        }
        size++;
    }

    private void addFin(T dato) {
        addInicio(dato);
        cabeza = cabeza.getNext();
    }

    private T removeInicio() throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia");
        } else {
            Nodo<T> fin = cabeza;
            while (fin.getNext() != cabeza) {
                fin = fin.getNext();
            }
            T eliminar = fin.getDato();
            fin.setNext(cabeza.getNext());
            cabeza = fin.getNext();
            size--;
            return eliminar;
        }
    }

    private T removeFin() throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia");
        } else if (size == 1) {
            return removeInicio();
        } else {
            Nodo<T> fin = cabeza;
            Nodo<T> aux = cabeza.getNext();
            while (aux.getNext() != cabeza) {
                fin = fin.getNext();
                aux = aux.getNext();
            }
            T eliminar = aux.getDato();
            fin.setNext(aux.getNext());
            size--;
            return eliminar;
        }

    }

    public Nodo<T> search(T dato) throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia");
        } else {
            Nodo<T> fin = cabeza;
            do {
                if (dato.equals(fin.getDato())) {
                    return fin;
                }
                fin = fin.getNext();
            } while (fin != cabeza);
            throw new Exception("No se encontro el dato");

        }
    }

    protected T peek() throws Exception {
        if (!isEmpty()) {
            Nodo<T> aux = cabeza;
            while (aux.getNext() != cabeza) {
                aux = aux.getNext();
            }
            return aux.getDato();
        }
        throw new Exception("No se encontro el dato");
    }

    public T search(int index) throws Exception {
        if (!isEmpty()) {
            if (index == 0) {
                return cabeza.getDato();
            } else if (index == size) {
                peek();
            } else if (index > 0 && index < size) {
                Nodo<T> aux = cabeza;
                for (int i = 0; i < index; i++) {
                    aux = aux.getNext();
                }
                return aux.getDato();
            }
        }
        throw new Exception("No se encontro el dato");
    }

    public T delete(T dato) throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia");
        } else if (dato.equals(cabeza.getDato())) {
            T eliminar = cabeza.getDato();
            removeInicio();
            return eliminar;
        } else {
            Nodo<T> fin = cabeza;
            Nodo<T> aux = cabeza.getNext();

            while (aux.getNext() != cabeza) {
                if (dato.equals(aux.getDato())) {
                    break;
                }
                fin = fin.getNext();
                aux = aux.getNext();
            }
            if (dato.equals(aux.getDato())) {

                T eliminar = aux.getDato();
                fin.setNext(aux.getNext());
                size--;
                return eliminar;
            } else {
                throw new Exception("No se encontro el dato");
            }
        }
    }

    public T deleteIndex(int index) throws Exception {
        if (!isEmpty()) {
            if (index == 0) {
                return removeInicio();
            } else if (index == size) {
                return removeFin();
            } else if (index > 0 && index < size) {
                Nodo<T> fin = cabeza;
                Nodo<T> aux = cabeza.getNext();
                for (int i = 0; i < index - 1; i++) {
                    aux = aux.getNext();
                    fin = fin.getNext();
                }
                T eliminar = aux.getDato();
                fin.setNext(aux.getNext());
                size--;
                return eliminar;
            }
        }
        throw new Exception("No se encontro el dato");
    }

    public void modify(T dato) {
        if (isEmpty()) {
            System.out.println("Esta vacia");
        } else {
            try {
                search(dato).setDato(dato);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public boolean add(T dato) {
        if (isEmpty()) {
            addInicio(dato);
            return false;
        } else {
            Nodo<T> fin = cabeza;
            do {
                if (dato.equals(fin.getDato())) {
                    return true;
                }
                fin = fin.getNext();
            } while (fin != cabeza);
        }
        addFin(dato);
        return false;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
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

    public static void main(String[] args) {
        ListaCircularSimple<Integer> lista = new ListaCircularSimple<>();
        lista.add(0);
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.show();
        try {
            lista.deleteIndex(2);
            lista.deleteIndex(0);
            lista.deleteIndex(1);
            lista.deleteIndex(1);
        } catch (Exception e) {
        }
        System.out.println("");
        lista.show();
    }

    @Override
    public Clonar clonar() {
        ListaCircularSimple<T> lista = null;
        try {
            lista = (ListaCircularSimple<T>) clone();
        } catch (Exception e) {
        }
        return lista;
    }
}
