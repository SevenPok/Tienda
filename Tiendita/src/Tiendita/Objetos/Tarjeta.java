package Tiendita.Objetos;

public class Tarjeta {

    private String nombre;
    private int bloque1;
    private int bloque2;
    private int bloque3;
    private int bloque4;

    public Tarjeta(String nombre, int bloque1, int bloque2, int bloque3, int bloque4) {
        this.nombre = nombre;
        this.bloque1 = bloque1;
        this.bloque2 = bloque2;
        this.bloque3 = bloque3;
        this.bloque4 = bloque4;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBloque1() {
        return bloque1;
    }

    public void setBloque1(int bloque1) {
        this.bloque1 = bloque1;
    }

    public int getBloque2() {
        return bloque2;
    }

    public void setBloque2(int bloque2) {
        this.bloque2 = bloque2;
    }

    public int getBloque3() {
        return bloque3;
    }

    public void setBloque3(int bloque3) {
        this.bloque3 = bloque3;
    }

    public int getBloque4() {
        return bloque4;
    }

    public void setBloque4(int bloque4) {
        this.bloque4 = bloque4;
    }

    public String numeroRecibo() {
        return bloque1 + "-" + bloque2 + "-****-****";
    }

    public String numero() {
        return bloque1 + "-" + bloque2 + "-" + bloque3 + "-" + bloque4;
    }
}
