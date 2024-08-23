package cuentas;

public interface OperacionesComunes {
    Double TOPE_FIJO = 15000.0;
    String atributo2 = "Atributo2";
    String atributo3 = "Atributo3";

    public abstract void pagarServicio();

    public abstract void cambiarAlias();
}