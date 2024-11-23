package formas;

public class Circulo extends Forma {
    private Double radio;

    public Circulo(Double radio) {
        super("CIRCULO");
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

}
