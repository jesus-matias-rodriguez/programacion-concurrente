package formas;

public abstract class Forma {

    public String NombreForma;

    public Forma(String NombreForma) {
        this.NombreForma = NombreForma;
    }

    public abstract double perimetro();

    public abstract double area();
}
