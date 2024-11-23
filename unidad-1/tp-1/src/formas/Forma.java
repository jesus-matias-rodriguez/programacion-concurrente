package formas;

public abstract class Forma {

    private String NombreForma;

    public Forma(String NombreForma) {
        this.NombreForma = NombreForma;
    }

    public abstract double perimetro();

    public abstract double area();

    public String getNombreForma() {
        return this.NombreForma;
    }
}
