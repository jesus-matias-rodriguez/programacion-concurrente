package formas;

public class Circulo implements IForma {
    private Double radio;

    public Circulo(Double radio) {
        this.radio = radio;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * this.radio;
    }

    @Override
    public double area() {
        return Math.PI * this.radio * this.radio;
    }

    @Override
    public String NombreForma() {
        return "CIRCULO";
    }

}
