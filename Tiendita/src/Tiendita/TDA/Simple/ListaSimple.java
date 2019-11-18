package Tiendita.TDA.Simple;

public class ListaSimple<T> {

    private Nodo<T> cabeza;
    private int size;

    public ListaSimple() {
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

    protected void addInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato, cabeza);
        if (isEmpty()) {
            cabeza = nuevo;
            size++;
        } else {
            cabeza = nuevo;
            size++;
        }
    }

    protected T removeInicio() throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia");
        } else {
            Nodo<T> remove = cabeza;
            cabeza = cabeza.getNext();
            size--;
            return remove.getDato();
        }
    }

    protected T removeFin() throws Exception {
        if (isEmpty()) {
            return removeInicio();
        } else if (getSize() == 1) {
            Nodo<T> remove = cabeza;
            cabeza = null;
            size--;
            return remove.getDato();
        }
        Nodo<T> remove = cabeza.getNext();
        Nodo<T> aux = cabeza;

        while (remove.getNext() != null) {
            remove = remove.getNext();
            aux = aux.getNext();
        }
        aux.setNext(null);
        size--;
        return remove.getDato();

    }

    public T delete(T dato) throws Exception {
        if (!isEmpty()) {
            if (dato.equals(cabeza.getDato())) {
                return removeInicio();
            } else {
                Nodo<T> remove = cabeza.getNext();
                Nodo<T> aux = cabeza;
                while (remove != null) {
                    if (dato.equals(remove.getDato())) {
                        aux.setNext(remove.getNext());
                        size--;
                        return remove.getDato();
                    }
                    remove = remove.getNext();
                    aux = aux.getNext();
                }
            }
        }
        throw new Exception("No se encontro el dato");
    }

    public T deleteIndex(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("Esta vacia la lista");
        } else if (index == 0) {
            return removeInicio();
        } else if (index == size) {
            return removeFin();
        } else if (index > 0 && index < size) {
            Nodo<T> fin = cabeza;
            for (int i = 0; i < index - 1; i++) {
                fin = fin.getNext();
            }
            fin.setNext(fin.getNext().getNext());
            size--;
            return fin.getNext().getDato();
        }
        throw new Exception("No se encontro el dato");
    }

    protected void addFin(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            addInicio(dato);
        } else {
            Nodo<T> aux = cabeza;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(nuevo);
            size++;
        }
    }

    protected T peek() throws Exception {
        if (!isEmpty()) {
            Nodo<T> aux = cabeza;
            while (aux.getNext() != null) {
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

    public Nodo<T> searchKey(T dato) throws Exception {
        if (!isEmpty()) {
            Nodo<T> search = cabeza;
            while (search != null) {
                if (dato.equals(search.getDato())) {
                    return search;
                }
                search = search.getNext();
            }
        }
        throw new Exception("No se encontro el dato");
    }

    public T searchK(T dato) throws Exception {
        if (!isEmpty()) {
            Nodo<T> search = cabeza;
            while (search != null) {
                if (dato.equals(search.getDato())) {
                    return search.getDato();
                }
                search = search.getNext();
            }
        }
        throw new Exception("No se encontro el dato");
    }

    public void modify(T dato) {
        if (isEmpty()) {
            System.out.println("Esta vacia");
        } else {
            try {
                searchKey(dato).setDato(dato);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public boolean compareTo(T dato) {
        Nodo<T> aux = cabeza;
        while (aux != null) {
            if (dato.equals(aux.getDato())) {
                System.out.println("Ya existe ese dato");
                return true;
            }
            aux = aux.getNext();
        }
        addFin(dato);
        return false;
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("Esta vacia");
        } else {
            Nodo<T> aux = cabeza;
            while (aux != null) {
                System.out.println(aux.getDato());
                aux = aux.getNext();
            }
        }
    }

    public T[] array() {
        Nodo<T> aux = cabeza;
        Object[] lista = new Object[size];
        int i = 0;
        while (aux != null) {
            lista[i] = aux.getDato();
            aux = aux.getNext();
            i++;
        }
        return (T[]) lista;
    }
}
