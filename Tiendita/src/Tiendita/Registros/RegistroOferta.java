package Tiendita.Registros;

import Tiendita.Objetos.Oferta;
import Tiendita.TDA.Simple.ColaPrioridad;

public class RegistroOferta {

    private static RegistroOferta instancia;
    private ColaPrioridad<Oferta> ofertas;

    private RegistroOferta() {
        ofertas = new ColaPrioridad<>();
    }

    public static RegistroOferta getInstancia() {
        if (instancia == null) {
            instancia = new RegistroOferta();
        }
        return instancia;
    }

}
